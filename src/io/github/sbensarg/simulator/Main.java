package io.github.sbensarg.simulator;

import io.github.sbensarg.exceptions.InvalidAircraftTypeException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();
    private static int simulations;
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Usage: provide the scenario.txt input file as argument");
            System.exit(1);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {
                simulations = Integer.parseInt(line.split(" ")[0]);
            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Flyable flyable = AircraftFactory.newAircraft(parts[0], parts[1],
                        Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]));
                if (flyable != null) {
                    flyables.add(flyable);
                }
            }
            reader.close();

            weatherTower = new WeatherTower();
            for (Flyable flyable : flyables) {
                flyable.registerTower(weatherTower);
            }
            for (int i = 1; i <= simulations; i++) {
                weatherTower.changeWeather();
            }
        } catch (InvalidAircraftTypeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the scenario file: " + e.getMessage());
        }
    }
}
