package solucion1;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

public class Venta {
    private Collection<Prenda> listaPrendasVendidas;
    private final LocalDate fecha;
    private Metodo_Pago metodoDePago;

    public Venta(Collection<Prenda> una_listaDePrendas, int agno, int mes, int dia, Metodo_Pago un_metodoDePago) {
        listaPrendasVendidas = una_listaDePrendas;
        GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
        Date una_fecha = calendario.getTime();
        fecha = una_fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        metodoDePago = un_metodoDePago;
    }

    public int cantidadPrendasVendidas() {
        return listaPrendasVendidas.size();
    }

    public double calcularPrecio_venta() {

        double monto_Total_venta = (listaPrendasVendidas.stream().mapToDouble(w -> w.calcularPrecio())
                .sum());
        return monto_Total_venta +metodoDePago.calcularRegarco(monto_Total_venta);
    }

    public int dia_fecha(){
        return fecha.getDayOfMonth();
    }
}



