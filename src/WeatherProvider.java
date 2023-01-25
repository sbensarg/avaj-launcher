public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather;

    private WeatherProvider() {
        // initialize the weather array
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        // Code to determine and return the current weather based on the coordinates
        return null;
    }
}
