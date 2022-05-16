class Atuendo {
    private final Prenda torso;
    private final Prenda piernas;
    private final Prenda pies;
    private final Prenda accesorio;

    Atuendo(Prenda parteSuperior, Prenda parteInferior, Prenda calzado, Prenda accesorio) {
        this.torso = parteSuperior;
        this.piernas = parteInferior;
        this.pies = calzado;
        this.accesorio = accesorio;
    }
}
