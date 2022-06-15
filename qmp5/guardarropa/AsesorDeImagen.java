public class AsesorDeImagen { 
  private ServicioMeteorologico servicioMeteorologico; 
  
  public Atuendo sugerirAtuendo(String direccion, Guardarropas guardarrpas) {
    Clima climaActual = this.servicioMeteorologico()
                                          .getClima(direccion,LocalDate.now());
    List<Atuendo> combinaciones = guardarropas.todasLasPosiblesCombinaciones()
  	return combinaciones
        .filter(combinacion -> combinacion.esAdecuadaParaClimaActual(climaActual))
        .first();
  }
}






