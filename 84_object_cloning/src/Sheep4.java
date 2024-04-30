import java.util.List;
import java.util.*;

public class Sheep4 implements Cloneable {
    private String name;
    private int weight;
    private List<Sheep4> children;

    public Sheep4(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public List<Sheep4> getChildren() {
        return children;
    }

    public void setChildren(List<Sheep4> children) {
        this.children = children;
    }
}