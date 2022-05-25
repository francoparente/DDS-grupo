package dds.monedero.model;

public class Extraccion extends Movimiento{
	public Extraccion(LocalDate fecha, double monto){
	super(fecha, monto);
}
@Override
public boolean isDeposito(){
return false;
}
  public boolean fueExtraido(LocalDate fecha) {
    return esDeLaFecha(fecha);
  }

@Override
protected double getMontoOperacion(){
    return getMonto() * -1;
}

}