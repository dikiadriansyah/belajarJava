public class Sheep3 implements Cloneable {
    private String name;
    private int weight;

    public Sheep3(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}