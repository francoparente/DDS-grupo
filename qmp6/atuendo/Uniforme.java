class Uniforme {
    Prenda prendaSuperior;
    Prenda prendaInferior;
    Prenda calzado;

    classmethod fabricar(Sastre sastre)
       new Uniforme(
          sastre.fabricarParteSuperior(),
          sastre.fabricarParteInferior(),
          sastre.fabricarCalzado())
}