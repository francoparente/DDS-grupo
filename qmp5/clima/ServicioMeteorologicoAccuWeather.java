java.util.concurrent.TimeUnit

class ServicioMeteorologicoAccuWeather implements WeatherAPI {
    AccuWeatherAPI api_actual = new AccuWeatherAPI(); //import
    List<Clima> climas_actuales = null;
    LocalDate ultimoPedido = null;
    
    boolean pediElClimaEnLasUltimas12Horas() {
                                       // metodo que me retorne la diferencia de horas entre dos fechas
        return ultimoPedido != null && this.compararFechas();
    }
    
    getWeather() {
        if (!this.pediElClimaEnLasUltimas12Horas()) {
            this.obtenerClimaParaLasSiguientes12Horas();
        }
        return this.climaActual(horaActual);
    }

    void obtenerClimaParaLasSiguientes12Horas() {
        this.setClimasActuales(this.obtenerListaClimas(api_actual.getClima()));
    }
    
    // Compara 2 fechas y devuelve True si es mayor a 12 horas
    boolean compararFechas() {
        return LocalDate.now() - ultimoPedido >= 12;
    }
}