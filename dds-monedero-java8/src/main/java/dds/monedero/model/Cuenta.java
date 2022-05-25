package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {

  private double saldo;
  private List<Movimiento> movimientos = new ArrayList<>();

  public Cuenta() {
    saldo = 0;
  }

  public Cuenta(double montoInicial) {
    montoNegativoComprobacion(montoInicial);
    saldo = montoInicial;

  }

  public void setMovimientos(List<Movimiento> movimientos) {
    this.movimientos = movimientos;
  }

  public void poner(double cuanto) {
    montoNegativoComprobacion(cuanto);
    comprobarDepositosDiarios(3);
    new Movimiento(LocalDate.now(), cuanto, true).agregateA(this);
  }

  public void sacar(double cuanto) {
    montoNegativoComprobacion(cuanto);
    saldoMenorComprobacion(cuanto);
    comprobarMontoARetirarEnDia(cuanto,1000);
    new Movimiento(LocalDate.now(), cuanto, false).agregateA(this);
  }



  public void agregarMovimiento(Movimiento unMovimiento) {
    movimientos.add(unMovimiento);
  }

  public double getMontoExtraidoA(LocalDate fecha) {
    return getMovimientos().stream()
        .filter(movimiento -> movimiento.fueExtraido(fecha))
        .mapToDouble(Movimiento::getMonto)
        .sum();
  }

  public List<Movimiento> getMovimientos() {
    return movimientos;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  private void montoNegativoComprobacion(double monto) {
    if(monto <= 0)
      throw new MontoNegativoException(monto + ": el monto a ingresar debe ser un valor positivo");
  }

  private void saldoMenorComprobacion(double monto) {
    if (getSaldo() - monto < 0) {
      throw new SaldoMenorException("No puede sacar mas de " + getSaldo() + " $");
    }
  }

  private double calcularLimiteActual(double limiteDiario){
    double montoExtraidoHoy = getMontoExtraidoA(LocalDate.now());
    return limiteDiario - montoExtraidoHoy;
  }

  private void comprobarMontoARetirarEnDia(double cuanto, double limiteDiario) {
    double limiteActual = calcularLimiteActual(limiteDiario);
    if(cuanto > limiteActual) {
      throw new MaximoExtraccionDiarioException("No puede extraer mas de $ " + limiteDiario
          + " diarios, límite: " + limiteActual);
    }
  }

  private void comprobarDepositosDiarios(int limiteDiario) {
    if (getMovimientos()
        .stream()
        .filter(movimiento -> movimiento.fueDepositado(LocalDate.now()))
        .count() >= limiteDiario) {
      throw new MaximaCantidadDepositosException("Ya excedio los " + limiteDiario + " depositos diarios");
    }
  }
}
