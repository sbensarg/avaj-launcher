package io.github.sbensarg.simulator;

public class WeatherProvider {
    private final static WeatherProvider weatherProvider;
    private static final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    static {
        weatherProvider = new WeatherProvider();
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        // Code to determine and return the current weather based on the coordinates
        int weatherIndex = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        return weather[weatherIndex];
    }
}
