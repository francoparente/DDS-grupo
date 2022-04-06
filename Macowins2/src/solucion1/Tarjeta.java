package solucion1;

public class Tarjeta extends Metodo_Pago{
    private int cantidadDeCoutas;
    private double coeficienteFijo = 1;

    public Tarjeta(int una_cantidadDeCuotas){
        cantidadDeCoutas = una_cantidadDeCuotas;
    }

    public double calcularRegarco(double un_total){
        return cantidadDeCoutas * coeficienteFijo + 0.01 * un_total;
    }
}
