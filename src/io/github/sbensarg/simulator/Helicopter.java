package io.github.sbensarg.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        // Code to update the aircraft's conditions based on the weather
        WeatherTower weatherTower = new WeatherTower();
        String weather = WeatherTower.getWeather(coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();
        String message = "";
        String landingMsg = "";

        if (coordinates.getHeight() > 100) {
            coordinates.setHeight(100);
        }
        try {
            FileWriter writer = new FileWriter(OUTPUT_FILE, true);
            if (weather.equals("SUN")) {
                longitude += 10;
                height += 2;
                message = String.format("Helicopter#%s(%d): It's a beautiful day, let's fly high!", this.name, this.id);
            } else if (weather.equals("RAIN")) {
                longitude += 5;
                message = String.format("Helicopter#%s(%d): The rain is like a blessing from the sky.", this.name, this.id);
            } else if (weather.equals("FOG")) {
                longitude += 1;
                message = String.format("Helicopter#%s(%d): Foggy days are like slow motion days.", this.name, this.id);
            } else if (weather.equals("SNOW")) {
                height -= 12;
                if (height <= 0) {
                    height = 0;
                    this.unregisterTower(weatherTower);
                    landingMsg = String.format("%s#%s(%d) landing.", this.getClass().getSimpleName(), this.name, this.id);
                    writer.write(landingMsg + System.lineSeparator());
                }
                message = String.format("Helicopter#%s(%d): Winter is coming! Brace yourselves!", this.name, this.id);
            }
            setCoordinates(longitude, latitude, height);
            writer.write(message + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        try {
            FileWriter writer = new FileWriter(OUTPUT_FILE, true);
            String message = String.format("Tower says: %s#%s(%d) registered to weather tower.",
                    this.getClass().getSimpleName(), this.name, this.id);
            writer.write(message + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void unregisterTower(WeatherTower weatherTower) {
        weatherTower.unregister(this);
        try {
            FileWriter writer = new FileWriter(OUTPUT_FILE, true);
            String message = String.format("Tower says: %s#%s(%d) unregistered from weather tower.",
                    this.getClass().getSimpleName(), this.name, this.id);
            writer.write(message + System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
