package dds.monedero.model;

import dds.monedero.exceptions.MaximaCantidadDepositosException;
import dds.monedero.exceptions.MaximoExtraccionDiarioException;
import dds.monedero.exceptions.MontoNegativoException;
import dds.monedero.exceptions.SaldoMenorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonederoTest {
  private Cuenta cuenta;

  @BeforeEach
  void init() {
    cuenta = new Cuenta();
  }

  @Test
  void siPongo1500EnUnaCuentaDeberiaMostrarseEnSaldo() {
    cuenta.poner(1500);
    assertEquals(cuenta.getSaldo(), 1500);
  }

  @Test
  void unaCuentaNoPuedeCrearseTeniendoSaldoNegativo() {
    assertThrows(MontoNegativoException.class, () -> new Cuenta(-1500));
  }

  @Test
  void PonerUnMontoNegativoDeberiaFallar() {
    assertThrows(MontoNegativoException.class, () -> cuenta.poner(-1500));
  }

  @Test
  void laSumaDeTresDepositosDeberiaDarUnSaldoEquivalenteYNoFallarPorLimiteDiario() {
    cuenta.poner(1500);
    cuenta.poner(456);
    cuenta.poner(1900);
    assertEquals(cuenta.getSaldo(), 1500+456+1900);
  }

  @Test
  void MasDeTresDepositosDiariosDeberiaFallar() {
    assertThrows(MaximaCantidadDepositosException.class, () -> {
          cuenta.poner(1500);
          cuenta.poner(456);
          cuenta.poner(1900);
          cuenta.poner(245);
    });
  }

  @Test
  void ExtraerMasQueElSaldoDeberiaFallar() {
    assertThrows(SaldoMenorException.class, () -> {
          cuenta.setSaldo(90);
          cuenta.sacar(1001);
    });
  }

  @Test
  public void ExtraerMasDelLimiteDiarioDeberiaFallar() {
    assertThrows(MaximoExtraccionDiarioException.class, () -> {
      cuenta.setSaldo(5000);
      cuenta.sacar(1001);
    });
  }

  @Test
  public void ExtraerMontoNegativoDeberiaFallar() {
    assertThrows(MontoNegativoException.class, () -> cuenta.sacar(-500));
  }



  @Test
  public void SiTengoExtraccionesDeUnaFechaDeberiaPoderSaberElMontoTotalDeExtraccion() {
    cuenta.agregarMovimiento(new Movimiento(LocalDate.now(),20, false));
    cuenta.agregarMovimiento(new Movimiento(LocalDate.now(),50, false));
    cuenta.agregarMovimiento(new Movimiento(LocalDate.now(),30, false));
    assertEquals(cuenta.getMontoExtraidoA(LocalDate.now()), 100);
  }
}