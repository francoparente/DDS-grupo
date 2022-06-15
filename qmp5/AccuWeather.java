

class AccuWeather implements WeatherAPI {
    AccuWeatherAPI api_actual = new AccuWeatherAPI(); //import


    
    getWeather() {
        api_actual.getWeather();
    }
}