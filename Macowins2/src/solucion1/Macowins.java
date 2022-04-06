package solucion1;

import java.util.ArrayList;
import java.util.Collection;


public class Macowins {

    private static Collection <Venta> lista_ventas;

    public static void main(String[] args) {

        lista_ventas = new ArrayList<>();

        Estado_Prenda en_liquidacion = new Liquidacion();
        Estado_Prenda en_promocion = new Promocion(400);
        Estado_Prenda es_nuevo = new Nueva();

        Metodo_Pago tarjeta = new Tarjeta(12);
        Metodo_Pago efectivo = new Efectivo();

        Prenda prenda4 = new Prenda("saco",1000,en_liquidacion); //precio 500
        Prenda prenda5 = new Prenda("camisa",3000,es_nuevo);       //precio 3000
        Prenda prenda6 = new Prenda("pantalon",3000,en_promocion);   //precio 2600
        Prenda prenda7 = new Prenda("pantalon",3000,en_liquidacion); //precio 1500
        Prenda prenda8 = new Prenda("saco",3000,en_promocion);   //precio 2600

        Collection<Prenda> lista_prendas1 = new ArrayList<>();
        Collection<Prenda> lista_prendas2 = new ArrayList<>();

        lista_prendas1.add(prenda4);
        lista_prendas1.add(prenda5);
        lista_prendas1.add(prenda6);

        lista_prendas2.add(prenda7);
        lista_prendas2.add(prenda8);

        Venta venta1 = new Venta(lista_prendas1,2000,12,1,tarjeta);
        Venta venta2 = new Venta(lista_prendas2,2000,12,2,tarjeta);

        Macowins.registrar_venta(venta1);
        Macowins.registrar_venta(venta2);

        System.out.println(Macowins.consultar_precio(prenda6));

        System.out.println(Macowins.ganancia_dia(1));
        System.out.println(Macowins.ganancia_dia(2));
        System.out.println(consultar_tipo(prenda4));

    }

    private static String consultar_tipo(Prenda una_prenda){
        return una_prenda.getTipoPrenda();
    }

    private static double ganancia_dia(int un_dia){
        return  lista_ventas.stream()
                .filter(w -> w.dia_fecha() == un_dia)
                .mapToDouble(w -> w.calcularPrecio_venta())
                .sum();
    }

    private static void registrar_venta(Venta unaVenta){
        lista_ventas.add(unaVenta);
    }
    private static double consultar_precio(Prenda una_Prenda){
        return una_Prenda.calcularPrecio();
    }

}

