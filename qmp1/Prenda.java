public class Prenda {
    var unTipoDePrenda
    var listaDeTiposPermitidos
    string categoria
    var material
    var colorPrincipal
    var colorSecundario = "N/A"
    
    public Prenda(var unTipoDePrenda, var material, var colorPrincipal, var colorSecundario) {
        if(this.esValida(unTipoDePrenda,categoria) /*categoria.esValida(tipoPrenda)*/ ) {
            //inicializo atributos
        } 
        else {
        throw RuntimeException("El tipo de prenda no es valido con la categoria");
        }
    }
    
    boolean esValida(unTipoDePrenda, categoria) {
        switch(categoria){                      
          case (categoria.isEqual("ParteSuperior"))
            return listaPS.incluye(unTipoDePrenda);

          case (categoria.isEqual("ParteInferior"))
            return listaPI.incluye(unTipoDePrenda);

    
          case (categoria.isEqual("Calzado"))
            return listaCalz.incluye(unTipoDePrenda);

          
          case (categoria.isEqual("Accesorio"))
            return listaAc.incluye(unTipoDePrenda);

          default: lanzarError("Categoria invalida");
        }
    }
}



// SOLUCION ALTERNATIVA USANDO COMPOSICION CON CLASES SIN UTILIZAR SWITCH

class prenda{
    var unTipoDePrenda = "zapatos"  // Ejemplo
    var categoria = new Inferior(listaPrendas = {"zapatos"})
    method verificar(){
        if(categoria.incluyeA(unTipoDePrenda)){
            // Es una prenda valida
        }
    
}

Class abstract categoria{
    var listaPrendas
    method incluyeA(tipoPrenda){
        listaPrendas.contains(tipoPrenda)
        }
    }

//listaPrendas.incluye(unTipoDePrenda)

Superior extends Categoria
{
    var listaPrendas = {}

}

Inferior extends Categoria{
    var listaPrendas = {"zapatillas"}

}

Accesorio extends Categoria{
    var listaPrendas = {}
}

Calzado extends Categoria{
    var listaPrendas = {}
}
