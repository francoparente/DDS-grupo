import java.util.List;

class Usuario {
    List<Prenda> guardarropa;
    

    metodo cargarPrenda(Prenda prenda){
        //si la prenda existe => es válida, sino fallaría
        guardarropa.add(prenda);
    }

    metodo solicitarAtuendos(){
        //lista de atuendos
        QMP.atuendosDisponibles(guardarropa).filter(atuendo -> this.meSirve(atuendo)).filter(atuendo -> this.meGusta(atuendo));
    }
    //TipoPrenda unTipoPrenda, var material, var colorPrincipal, var colorSecundario
    
    Prenda crearPrenda  (
        TipoPrenda TipoPrenda,
        Color colorPrincipal,
        Color colorSecundario = NULL,
        TipoMaterial material,
        Trama trama = LISA){
        retornar new Prenda(TipoPrenda,colorPrincipal,colorSecundario,material,trama);
    }
    

    //Falta especificar implementacion en el enunciado para completar el método
    metodo recibirSugerenciaUniformes(){
        
    }


}