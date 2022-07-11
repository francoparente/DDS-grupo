class Empleado {
  ServicioMeteorologico servicioMeteorologico
  List<Usuario> usuarios

  calcularSugerenciasDiarias() {
    usuarios.forEach(usuario => usuario.calcularSugerenciaDiaria()
  }