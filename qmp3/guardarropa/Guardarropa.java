class Guardarropa {
    List<Prenda> prendas;

    Guardarropa(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    private Atuendo generarAtuendoAleatorio() {
        Prenda parteSuperior = obtenerPrendaAleatoria(SUPERIOR);
        Prenda parteInferior = obtenerPrendaAleatoria(INFERIOR);
        Prenda calzado = obtenerPrendaAleatoria(CALZADO);
        Prenda accesorio = obtenerPrendaAleatoria(ACCESORIO);
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

    Prenda obtenerPrendaAleatoria(Categoria unaCategoria) {
        var prendasDelTipoInsertado = prendas.filter(prenda -> prenda.esDeCategoria(unaCategoria));
        var prendasSugeribles = prendasDelTipoInsertado.filter(prenda -> prenda.esSugerible());
        if (prendasSugeribles.isEmpty() && unCategoria != Accesorio)
            throw new Exception("No hay prendas de la categoria " + unaCategoria + "sugeribles");
        var prendaAleatoria = prendasSugeribles.getRandomElement();
        return prendaAleatoria;
    }

    void agregarPrenda(Prenda prenda) {
        prendas.add(prenda);
    }
}
