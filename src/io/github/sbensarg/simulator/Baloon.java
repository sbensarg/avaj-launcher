package io.github.sbensarg.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        // Code to update the aircraft's conditions based on the weather
        String weather = WeatherTower.getWeather(coordinates);
        int longitude = this.coordinates.getLongitude();
        int latitude = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();
        String message = "";

        if (coordinates.getHeight() > 100) {
            coordinates.setHeight(100);
        }
        try {
            FileWriter writer = new FileWriter(OUTPUT_FILE, true);
            if (weather.equals("SUN")) {
                longitude += 2;
                height += 4;
                message = String.format("Baloon#%s(%d): It's a beautiful day, let's fly high!", this.name, this.id);
            } else if (weather.equals("RAIN")) {
                height -= 5;
                if (height < 0) {
                    height = 0;
                }
                message = String.format("Baloon#%s(%d): The rain is like a blessing from the sky.", this.name, this.id);
            } else if (weather.equals("FOG")) {
                height -= 3;
                if (height < 0) {
                    height = 0;
                }
                message = String.format("Baloon#%s(%d): Foggy days are like slow motion days.", this.name, this.id);
            } else if (weather.equals("SNOW")) {
                height -= 15;
                if (height < 0) {
                    height = 0;
                }
                message = String.format("Baloon#%s(%d): Winter is coming! Brace yourselves!", this.name, this.id);
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
