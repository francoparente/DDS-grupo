import java.util.ArrayList;

public class Negocio {
    List uniformes;
    // Convendría que sea singleton para ahorrar costos
    WeatherAPI apiClima = new AccuWeather(); 
    
    public void setApiClima(WeatherAPI otraApi) {
        this.apiClima = otraApi;
    }

    Temperature getClima() {
        return apiClima.getClima();
    }
}

