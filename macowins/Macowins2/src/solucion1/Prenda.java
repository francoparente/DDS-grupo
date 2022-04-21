package solucion1;

public class Prenda {
    double precio_base;
    String tipoPrenda;
    Estado_Prenda estadoDePrenda;

    public Prenda(String un_tipoPrenda, double un_precio, Estado_Prenda unEstado){
        tipoPrenda = un_tipoPrenda;
        precio_base = un_precio;
        estadoDePrenda = unEstado;
        }

    public Prenda(double un_precio){
        precio_base = un_precio;
    }

    public double calcularPrecio(){
        return estadoDePrenda.calcularPrecio(this.precio_base);
    }

    public double getPrecio_base(){
        return precio_base;
    }

    public Estado_Prenda getEstadoDePrenda(){
        return estadoDePrenda;
    }

    public void setEstadoDePrenda(Estado_Prenda un_estado){
        estadoDePrenda = un_estado;
    }

    public String getTipoPrenda(){
        return tipoPrenda;
    }
}