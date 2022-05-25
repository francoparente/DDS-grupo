package dds.monedero.model;

public class Deposito extends Movimiento{
	public Deposito(LocalDate fecha, double monto, boolean esDeposito){
	super(fecha, monto, esDeposito);
}

}