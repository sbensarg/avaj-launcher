import exceptions.InvalidAircraftTypeException;

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
        try {
            BufferedReader reader = new BufferedReader(new FileReader("scenario.txt"));
            String line = reader.readLine();
            if (line != null) {
                simulations = Integer.parseInt(line.split(" ")[0]);
            }
            while ((line = reader.readLine()) != null) {
                Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                        Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                        Integer.parseInt(line.split(" ")[4]));
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