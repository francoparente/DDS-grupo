public class PropuestaAgregar extends Propuesta {

    PropuestaAgregar(Prenda prenda) {
        this.prendaSugerida = prenda;
    }

    void efectuarCambios(Guardarropa guardarropa) {
        guardarropa.agregarPrenda(prenda);
        this.fueAceptada();
    }

    void deshacerCambios(Guardarropa guardarropa) {
        guardarropa.eliminarPrenda(prenda);
    }
}