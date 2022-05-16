class Sucia implements EstadoPrenda {

    boolean puedeSerUsada() {
        return true;
    }

    void verificarEstado(Prenda prenda) {
        Percudida percudida = new Percudida();
        if (prenda.vecesUsada >= 3)
            prenda.setEstado(percudida);
        prenda.reiniciarVecesUsada();
    }
}
