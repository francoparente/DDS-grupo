package solucion1;

public class Promocion extends Estado_Prenda {
    double valorFijo;

    public Promocion(double un_valor){
        valorFijo = un_valor;
    }

    public double calcularPrecio(double precioBase){
        return precioBase - valorFijo;
    }
}
