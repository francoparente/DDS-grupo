public class PropuestaQuitar extends Propuesta {

    PropuestaAgregar(Prenda prenda) {
        this.prendaSugerida = prenda;
    }

    void efectuarCambios(Guardarropa guardarropa) {
        guardarropa.eliminarPrenda(prenda);
        this.fueAceptada();
    }

    void deshacerCambios(Guardarropa guardarropa) {
        guardarropa.agregarPrenda(prenda);
    }
}