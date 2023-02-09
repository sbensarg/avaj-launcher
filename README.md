# avaj-launcher
First projet of the Java projects arc in 42 cursus. Implementation of a simple Java program according to a given class diagram written in UML.

## Usage
- ``` docker pull williamyeh/java7 ```
- ``` docker run -it -v  ${PWD}:/avaj-launcher williamyeh/java7 bash ```
- ``` cd avaj-launcher ```
- ``` make ```

## UML Conception

### io.github.sbensarg.simulator.Tower // has a Aggregation relationship with io.github.sbensarg.simulator.Aircraft
-observers: io.github.sbensarg.simulator.Flyable*
+register(flayable: io.github.sbensarg.simulator.Flyable) : void
+unregister(flayable: io.github.sbensarg.simulator.Flyable) : void
#conditionsChanged(): void

### io.github.sbensarg.simulator.WeatherTower // inherite from io.github.sbensarg.simulator.Tower
+getWeather(coordinates: io.github.sbensarg.simulator.Coordinates): String
-changeWeather(): void

### io.github.sbensarg.simulator.Aircraft
#id: long
#name: string
#cordinates: Cordinates
-idCounter: long
#io.github.sbensarg.simulator.Aircraft(name: string, coordinates: Cordinates)
-nextId(): long

### io.github.sbensarg.simulator.Coordinates // has a Composition relationship with io.github.sbensarg.simulator.Aircraft
-longitude: int
-latitude: int
-height: int
-Cordinates(longitude: int, latitude: int, height: int)
+getLongitude()
+getLatitude()
+getHeight()

### io.github.sbensarg.simulator.Flyable << Interface >>
+updateConditions(): void
+registerTower(io.github.sbensarg.simulator.WeatherTower: io.github.sbensarg.simulator.WeatherTower) : void

### io.github.sbensarg.simulator.Helicopter // inherite from io.github.sbensarg.simulator.Aircraft and impliment from io.github.sbensarg.simulator.Flyable
-weatherTower: io.github.sbensarg.simulator.WeatherTower
~io.github.sbensarg.simulator.Helicopter(name: string, coordinates: io.github.sbensarg.simulator.Coordinates)
+updateConditions(): void
+registerTower(io.github.sbensarg.simulator.WeatherTower: io.github.sbensarg.simulator.WeatherTower) : void

### io.github.sbensarg.simulator.JetPlane // inherite from io.github.sbensarg.simulator.Aircraft and impliment from io.github.sbensarg.simulator.Flyable
-weatherTower: io.github.sbensarg.simulator.WeatherTower
~JeTPlane(name: string, coordinates: io.github.sbensarg.simulator.Coordinates)
+updateConditions(): void
+registerTower(io.github.sbensarg.simulator.WeatherTower: io.github.sbensarg.simulator.WeatherTower) : void

### io.github.sbensarg.simulator.Baloon
-weatherTower: io.github.sbensarg.simulator.WeatherTower
~Ballon(name: string, coordinates: io.github.sbensarg.simulator.Coordinates)
+updateConditions(): void
+registerTower(io.github.sbensarg.simulator.WeatherTower: io.github.sbensarg.simulator.WeatherTower) : void

### io.github.sbensarg.simulator.WeatherProvider //Self Association
-weatherProvider: io.github.sbensarg.simulator.WeatherProvider
-weather:string[]
-io.github.sbensarg.simulator.WeatherProvider()
+getProvider(): io.github.sbensarg.simulator.WeatherProvider
+getCurrentWeather(cordinates: io.github.sbensarg.simulator.Coordinates) : string

### io.github.sbensarg.simulator.AircraftFactory
+newAircraft(type: string, name: string, longitude: int, latitude: int, height: int) : io.github.sbensarg.simulator.Flyable 

