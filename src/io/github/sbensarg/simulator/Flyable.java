package io.github.sbensarg.simulator;

public interface Flyable {
        void updateConditions();
        void registerTower(WeatherTower weatherTower);

        void unregisterTower(WeatherTower weatherTower);

}
