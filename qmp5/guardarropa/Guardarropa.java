class Guardarropa {
    List<Prenda> prendas;
    String criterio;
    List<Propuesta> propuestas = new ArrayList();
    List<Usuario> usuariosCompartidos = new ArrayList();

    Guardarropa(List<Prenda> prendas, String criterio) {
        this.prendas = prendas;
        this.criterio = criterio;
    }


    private Atuendo generarAtuendoAleatorio(Clima unClima) {
        Prenda parteSuperior = obtenerPrendaAleatoria(SUPERIOR,Clima unClima);
        Prenda parteInferior = obtenerPrendaAleatoria(INFERIOR,Clima unClima);
        Prenda calzado = obtenerPrendaAleatoria(CALZADO,Clima unClima);
        Prenda accesorio = obtenerPrendaAleatoria(ACCESORIO,Clima unClima);
        
        prendaSuperior.usarseEnAtuendo();
        parteInferior.usarseEnAtuendo();
        calzado.usarseEnAtuendo();
        if (accesorio != null)
            accesorio.usarseEnAtuendo();
        return new Atuendo(parteSuperiores, parteInferiores, calzado, accesorio);
    }

    // Crea n sugerencias y las devuelve en una lista
    List<Atuendo> enviarSugerencias(int cantidadVeces) {
        List<Atuendo> sugerencias = new ArrayList<>(); // Atuendo
        generarAtuendoAleatorio().agregarNVeces(cantidadVeces, listaSugerencias);
        return listaSugerencias;
    }

    Prenda obtenerPrendaAleatoria(Categoria unaCategoria,Clima unClima) {
        var prendasSugeribles = prendasDeLaCategoriaInsertada(unaCategoria);
        prendasSugeribles = prendasSugeribles(prendasSugeribles);
        prendasSugeribles = prendasSugeriblesParaElClimaActual(prendasSugeribles);
        if (prendasSugeribles.isEmpty() && unCategoria != Accesorio)
            throw new Exception("No hay prendas de la categoria " + unaCategoria + "sugeribles");
        var prendaAleatoria = prendasSugeribles.getRandomElement();
        return prendaAleatoria;
    }
    List<Prenda> prendasDeLaCategoriaInsertada(Categoria unaCategoria){
        return prendas.filter(prenda -> prenda.esDeCategoria(unaCategoria));
    }
    List<Prenda> prendasSugeribles(List<Prenda> unasPrendas){
        return unasPrendas.filter(prenda -> prenda.esSugerible());
    }
    List<Prenda> prendasSugeriblesParaElClimaActual(List<Prenda> unasPrendas){
        return unasPrendas.filter(prenda -> prenda.esAdecuadaParaClimaActual(Clima unClima));
    }

    method todasLasPosiblesCombinaciones(){
        //retorna todas las posibles combinaciones de atuendos
        //pending --> en proximas iteraciones cuando nos digan
    }

    void recibirPropuesta(Propuesta propuesta) {
        propuestas.add(propuesta);
    }
    void agregarUsuarioCompartido(Usuario usuario) {
        usuariosCompartidos.add(usuario);
    }

    void aceptarPropuesta(unaPropuesta) {
	    unaPropuesta.efectuarCambios(this);
        unaPropuesta.aceptar();
    }

    void rechazarPropuesta(unaPropuesta) {
	    this.eliminarPropuesta(unaPropuesta);
    }

    void eliminarPropuesta(Propuesta unaPropuesta) {
        propuestas.remove(propuestas.indexOf(unaPropuesta));
    }

    void deshacerTodasLasPropuestas() {
        propuestas.filter(propuesta -> propuesta.fueAceptada()).map(propuesta -> propuesta.deshacerCambios(this));
    }

    void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
    }

    void eliminarPrenda(Prenda unaPrenda) {
        prendas.remove(prendas.indexOf(unaPrenda));
    }

    List<Propuesta> getPropuestas() {
        return propuestas;
    }

}
