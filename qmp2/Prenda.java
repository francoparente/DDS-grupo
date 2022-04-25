
enum TipoPrenda {
    REMERA,CAMISA,ZAPATOS,ZAPATILLAS,PANTALON
}

enum Categoria{
  PARTE_SUPERIOR, 
  CALZADO, 
  PARTE_INFERIOR, 
  ACCESORIOS
}


public class Prenda {
    TipoPrenda unTipoPrenda
    Material material
    var colorPrincipal
    var colorSecundario = "N/A"
    
    //quiero guardar un borrador de la la última prenda que empecé a cargar para continuar después.
    //aplicacion parcial: se puede cargar sin parámetros completos.
    public Prenda(TipoPrenda unTipoPrenda, var material, var colorPrincipal, var colorSecundario) {
        if (not unTipoPrenda.puedeSerDe(material)) {
            fallar("el material no es adecuado con skald");
        } 
        // INICIALIZAR ATRIBUTOS CON requireNonNull
    }
}



