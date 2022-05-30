class Limpia implements EstadoPrenda {
    boolean puedeSerUsada() {
        return true;
    }

    void verificarEstado(Prenda prenda) {
        if (prenda.vecesUsada() > 1) {
            prenda.setEstado(new Sucia());
            prenda.reiniciarVecesUsada();
        }
    }
}
