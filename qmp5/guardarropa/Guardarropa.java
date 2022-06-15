class Guardarropa {
    List<Prenda> prendas;

    Guardarropa(List<Prenda> prendas) {
        this.prendas = prendas;
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

    void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
    }
}
