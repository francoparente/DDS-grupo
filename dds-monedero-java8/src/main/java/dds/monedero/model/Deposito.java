package dds.monedero.model;

public class Deposito extends Movimiento{
	public Deposito(LocalDate fecha, double monto){
	super(fecha, monto);
}
@Override
public boolean isDeposito(){
return true;
}
  public boolean fueExtraido(LocalDate fecha) {
    return false
  }


@Override
protected double getMontoOperacion(){
    return getMonto();
}

}