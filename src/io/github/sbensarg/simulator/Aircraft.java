package io.github.sbensarg.simulator;

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

    public void updateConditions() {
    }

    public void setCoordinates(int longitude, int latitude, int height) {
        this.coordinates = new Coordinates(longitude, latitude, height);
    }
}
