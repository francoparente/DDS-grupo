public class Usuario {

    private String nombre;
    private Guardarropa guardarropa;

    Usuario(String nombre, List<Prenda> prendas) {
        this.nombre = nombre;
        this.guardarropa = new Guardarropa(prendas);
    }

    void agregarPrendaDeBorrador(Prenda unaPrenda) {
        guardarropa.agregarPrenda(unaPrenda);
    }

    List<Atuendo> recibirSugerencias(int sugerencias) {
        return guardarropa.enviarSugerencias(sugerencias);
    }
}
