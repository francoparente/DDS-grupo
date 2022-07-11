public class RegistroAlertas {
  List<AlertaMeteorologica> alertasActuales = new ArrayList<>();
  RepositorioUsuarios repoUsuarios;


  public void actualizarAlertas() {
    this.alertasActuales = new ServicioMeteorologicoAccuWeather().getAlertasMeteorologicas();
    this.realizarAccionesSobreAlertas(this.alertasActuales)
  }

  public void realizarAccionesSobreAlertas(List<AlertaMeteorologica> alertas){
    repoUsuarios.getUsuarios().forEach(usuario -> usuario.realizarAccionesSobreAlertas(alertas))
  }

}