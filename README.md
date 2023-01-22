# avaj-launcher
First projet of the Java projects arc in 42 cursus. Implementation of a simple Java program according to a given class diagram written in UML.

## UML Conception

### Tower // has a Aggregation relationship with Aircraft
-observers: Flyable*
+register(flayable: Flyable) : void
+unregister(flayable: Flyable) : void
#conditionsChanged(): void

### WeatherTower // inherite from Tower
+getWeather(coordinates: Coordinates): String
-changeWeather(): void

### Aircraft
#id: long
#name: string
#cordinates: Cordinates
-idCounter: long
#Aircraft(name: string, coordinates: Cordinates)
-nextId(): long

### Coordinates // has a Composition relationship with Aircraft
-longitude: int
-latitude: int
-height: int
-Cordinates(longitude: int, latitude: int, height: int)
+getLongitude()
+getLatitude()
+getHeight()

### Flyable << Interface >>
+updateConditions(): void
+registerTower(WeatherTower: WeatherTower) : void

### Helicopter // inherite from Aircraft and impliment from Flyable
-weatherTower: WeatherTower
~Helicopter(name: string, coordinates: Coordinates)
+updateConditions(): void
+registerTower(WeatherTower: WeatherTower) : void

### JetPlane // inherite from Aircraft and impliment from Flyable
-weatherTower: WeatherTower
~JeTPlane(name: string, coordinates: Coordinates)
+updateConditions(): void
+registerTower(WeatherTower: WeatherTower) : void

### Baloon
-weatherTower: WeatherTower
~Ballon(name: string, coordinates: Coordinates)
+updateConditions(): void
+registerTower(WeatherTower: WeatherTower) : void

### WeatherProvider //Self Association
-weatherProvider: WeatherProvider
-weather:string[]
-WeatherProvider()
+getProvider(): WeatherProvider
+getCurrentWeather(cordinates: Coordinates) : string

### AircraftFactory
+newAircraft(type: string, name: string, longitude: int, latitude: int, height: int) : Flyable 

