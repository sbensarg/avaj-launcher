package io.github.sbensarg.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
