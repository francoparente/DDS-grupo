public class Usuario {

    String nombre;
    List<Guardarropa> guardarropas = new ArrayList();
    BorradorPrenda borrador;

    Usuario(String nombre) {
        this.nombre = nombre;
    }

    void agregarPrendaDeBorrador(Prenda unaPrenda, Guardarropa guardarropa) {
        guardarropa.agregarPrenda(unaPrenda);
    }

    List<Atuendo> recibirSugerencias(int sugerencias) {
        return guardarropa.enviarSugerencias(sugerencias);
    }

    void agregarNuevoGuardarropas(Guardarropa unGuardarropa) {
        guardarropas.add(unGuardarropa);
    }

    void compartirCon(Usuario usuario, Guardarropa guardarropa) {
        usuario.agregarNuevoGuardarropas(guardarropa);
        guardarropa.agregarUsuarioCompartido(usuario);
    }

    //caso1: guardarropas compartido: le mando a uno que tenga acceso, le llega a todos, cualquiera puede aceptarla. 
    //caso2: guardarropasPersonal: le mando al dueño del guardarropas.
    void proponer(Propuesta propuesta, Guardarropa guardarropa) {
        guardarropa.recibirPropuesta(propuesta);
    }

}
