package dds.monedero.model;

public class Extraccion extends Movimiento{
	public Extraccion(LocalDate fecha, double monto, boolean esDeposito){
	super(fecha, monto, false);
}

}