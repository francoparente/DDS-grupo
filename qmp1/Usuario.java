import java.util.List;

class Usuario {
    List<Prenda> guardarropa;

    void cargarPrenda(Prenda prenda){
        guardarropa.add(prenda);
    }

    void solicitarAtuendos(){
        //lista de atuendos
        QMP.atuendosDisponibles(guardarropa).filter(atuendo -> this.meSirve(atuendo)).filter(atuendo -> this.meGusta(atuendo));
    }
}