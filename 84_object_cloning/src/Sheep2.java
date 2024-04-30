public class Sheep2 {
    private String name;

    private int weight;

    public Sheep2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public static Sheep2 newInstance(Sheep2 other) {
        return new Sheep2(other.name, other.weight);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}
