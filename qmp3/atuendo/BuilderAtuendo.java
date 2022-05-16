public class BuilderAtuendo {
    private Prenda parteSuperior;
    private Prenda piernas;
    private Prenda pies;
    private Prenda accesorio;

    void setParteSuperior(Prenda torso) {
        if (!torso.esDeCategoria(ParteSuperior)) {
            throw new RuntimeException("La prenda ingresada no es una parte superior");
        }
        this.parteSuperior = torso;
    }

    void setPiernas(Prenda piernas) {
        if (!piernas.esDeCategoria(ParteInferior)) {
            throw new RuntimeException("La prenda ingresada no es parte inferior");
        }
        this.piernas = piernas;

    }

    void setPies(Prenda unCalzado) {
        if (!calzado.esDeCategoria(Calzado)) {
            throw new RuntimeException("La prenda ingresada no es un calzado");
        }
        this.calzado = unCalzado;

    }

    void setAccesorio(Prenda accesorio) {
        if (!accesorio.esDeCategoria(Accesorio)) {
            throw new RuntimeException("La prenda ingresada no es accesorio");
        }
        this.accesorio = accesorio;

    }


    Atuendo build() {
        this.todosLosCamposEstanCorrectos();
        return new Atuendo(torso, piernas, pies, accesorio);
    }

    void todosLosCamposEstanCorrectos() {
        // torso, piernas, calzado, accesorio
        if (parteSuperior == null) {
            throw new RuntimeException("falta definir la parte superior");
        }
        if (piernas == null) {
            throw new RuntimeException("falta definir la parte inferior");
        }
        if (calzado == null) {
            throw new RuntimeException("falta definir el calzado");
        }
    }
}
// listaDePrenda
// Guardarropa.damePrendaRandom(unaCategoria);
// builderAtuendo.setTorso(Guardarropa.damePrendaRandom(parteSuperior);)
