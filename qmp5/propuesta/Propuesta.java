public abstract class Propuesta {
    bool fueAceptada = false;
    Prenda prendaSugerida;

    void efectuarCambios();
    void deshacerCambios();
    void fueAceptada() {
        fueAceptada = true;
    }
}