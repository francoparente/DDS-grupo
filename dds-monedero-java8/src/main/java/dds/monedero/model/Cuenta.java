package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {

  //Doble inicialización innecesaria de saldo
  private double saldo;
  private List<Movimiento> movimientos = new ArrayList<>();

  // Inicializa nuevamente salgo a 0 cuando crea un Objeto Cuenta
  public Cuenta() {
    saldo = 0;
  }

  //No se verifica que pases un monto negativo o null (AGREGAR verificacion de null)
  public Cuenta(double montoInicial) {
    montoNegativoException(double monto);
    saldo = montoInicial;

  }

  public void setMovimientos(List<Movimiento> movimientos) {
    this.movimientos = movimientos;
  }

  public void poner(double cuanto) {
    montoNegativoException(double cuanto);

    //No se verifica la fecha, (no pasa la fecha como parametro)
    //No se utiliza los métodos propias de las clases, en este caso movimiento.fueDepositado

    comprobarDepositosDiarios();

    //Ya tengo una función agregar movimiento que es propia de esta clase
    //Además no tendría por qué pedirle a un movimiento que se agregue a esta cuenta
    //Un movimiento no conoce a una cuenta, por lo que tranquilamente podriamos usar solamente
    //Agregarmovimiento de esta clase, hay un Middle man caso contrario.

    new Movimiento(LocalDate.now(), cuanto, true).agregateA(this);
  }

  public void sacar(double cuanto) {

    montoNegativoComprobacion(cuanto);
    saldoMenorComprobacion(cuanto);
    comprobarMontoARetirarEnDia(cuanto);

    //Ya tengo una función agregar movimiento que es propia de esta clase
    //Además no tendría por qué pedirle a un movimiento que se agregue a esta cuenta
    //Un movimiento no conoce a una cuenta, por lo que tranquilamente podriamos usar solamente
    //Agregarmovimiento de esta clase, hay un Middle man caso contrario.

    //Tener en cuenta usar dos clases en vez de booleanos
    new Movimiento(LocalDate.now(), cuanto, false).agregateA(this);
  }

  public void agregarMovimiento(LocalDate fecha, double cuanto, boolean esDeposito) {
    Movimiento movimiento = new Movimiento(fecha, cuanto, esDeposito);
    movimientos.add(movimiento);
  }

  public double getMontoExtraidoA(LocalDate fecha) {
    //Deberia haber una delegación de responsabilidad
    return getMovimientos().stream()
        .filter(movimiento -> !movimiento.isDeposito() && movimiento.getFecha().equals(fecha))
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
    if(monto <= 0) {
      MontoNegativoException(monto + ": el monto a ingresar debe ser un valor positivo");
    }
  }

  private void saldoMenorComprobacion(double monto) {
    if (getSaldo() - monto < 0) {
      throw new SaldoMenorException("No puede sacar mas de " + getSaldo() + " $");
    }
  }

  private double calcularLimiteActual(){
    double montoExtraidoHoy = getMontoExtraidoA(LocalDate.now());
    return 1000 - montoExtraidoHoy;
  }

  private void comprobarMontoARetirarEnDia(double cuanto, double limite) {
    double limite = calcularLimiteActual();
    if (cuanto > limite) {
      throw new MaximoExtraccionDiarioException("No puede extraer mas de $ " + 1000
          + " diarios, límite: " + limite);
    }
  }

  private void comprobarDepositosDiarios() {
    if (getMovimientos().stream().filter(movimiento -> movimiento.isDeposito(LocalDate.Now())).count() >= 3) {
      throw new MaximaCantidadDepositosException("Ya excedio los " + 3 + " depositos diarios");
    }
  }


}
