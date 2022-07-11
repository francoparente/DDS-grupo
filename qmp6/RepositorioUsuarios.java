class RepositorioUsuarios{
  List<Usuario> usuarios;

  List<Usuario> getUsuarios(){...}

  void calcularSugerencias() {
    usuarios.forEach(usuario -> usuario.pedirSugerencia() )
  }

}