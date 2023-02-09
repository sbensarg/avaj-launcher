package io.github.sbensarg.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class Aircraft {
    private static long idCounter = 0;
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    public static String OUTPUT_FILE = "simulation.txt";

    public Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private static long nextId() {
        return ++idCounter;
    }

    public long getId() {
        return id;
    }

    public void updateConditions() {
        // code to update the aircraft's conditions based on the weather
        if (coordinates.getHeight() <= 0) {
            //f the aircraft reaches height 0 or goes below it, unregister it from the weather tower and log its current coordinates.
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
            try {
                FileWriter writer = new FileWriter(OUTPUT_FILE, true);
                String message = String.format("%s#%s(%d) landing.", this.getClass().getSimpleName(), this.name, this.id);
                writer.write(message + System.lineSeparator());
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setCoordinates(int longitude, int latitude, int height) {
        this.coordinates = new Coordinates(longitude, latitude, height);
    }


}
