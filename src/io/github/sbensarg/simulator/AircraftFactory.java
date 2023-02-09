package io.github.sbensarg.simulator;

import io.github.sbensarg.exceptions.InvalidAircraftTypeException;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalidAircraftTypeException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equalsIgnoreCase("Baloon")) {
            return new Baloon(name, coordinates);
        } else if (type.equalsIgnoreCase("Helicopter")) {
            return new Helicopter(name, coordinates);
        } else if (type.equalsIgnoreCase("JetPlane")) {
            return new JetPlane(name, coordinates);
        } else {
            throw new InvalidAircraftTypeException("Invalid aircraft type: " + type);
        }
    }
}
