package dds.monedero.model;

public class Extraccion extends Movimiento{
	public Extraccion(LocalDate fecha, double monto){
	super(fecha, monto);
}
@Override
public boolean isDeposito(){
return false;
}

@Override
public boolean isDeposito(){
return true;
}
}