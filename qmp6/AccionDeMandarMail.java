public class AccionDeMandarMail implements AccionConfigurable {

  List<Usuario> usuariosInteresados = new ArrayList<>();

  @Override
  public void nuevasAlertasMeteorologicas() {
    usuariosInteresados.forEach(usuario-> new Correo().enviarCorreo(usuario.correoElectronico,"Hay nuevas alertas meteorológicas..." /*Imprimir las alertas sacadas del Gestor de Alertas*/));
  }
  public void suscribirUsuario(Usuario usuario) {
    usuariosInteresados.add(usuario);
  }
  public void desuscribirUsuario(Usuario usuario) {
    usuariosInteresados.remove(usuario);
  }

}