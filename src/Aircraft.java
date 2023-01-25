public class Aircraft {
    private static long idCounter = 0;
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    public Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private static long nextId() {
        return ++idCounter;
    }
}
