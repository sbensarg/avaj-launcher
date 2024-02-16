package io.github.sbensarg.simulator;

public class WeatherTower extends Tower {

    public WeatherTower() {
    }

    public static String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        // Code to change the weather and call conditionsChanged()
        this.conditionsChanged();
    }
}
