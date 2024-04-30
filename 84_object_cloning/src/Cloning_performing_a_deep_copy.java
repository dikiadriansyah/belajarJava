import java.util.Arrays;
import java.util.List;

public class Cloning_performing_a_deep_copy {
    // Cloning performing a deep copy/Kloning melakukan penyalinan mendalam

    /*
     * Untuk menyalin objek bertumpuk, salinan mendalam harus dilakukan, seperti
     * yang ditunjukkan dalam contoh ini.
     */

    /*
     * import java.util.ArrayList;
     * import java.util.List;
     * public class Sheep implements Cloneable {
     * private String name;
     * private int weight;
     * private List<Sheep> children;
     * public Sheep(String name, int weight) {
     * this.name = name;
     * this.weight = weight;
     * }
     * 
     * @Override
     * public Object clone() throws CloneNotSupportedException {
     * Sheep clone = (Sheep) super.clone();
     * if (children != null) {
     * // make a deep copy of the children
     * List<Sheep> cloneChildren = new ArrayList<>(children.size());
     * for (Sheep child : children) {
     * cloneChildren.add((Sheep) child.clone());
     * }
     * clone.setChildren(cloneChildren);
     * }
     * return clone;
     * }
     * public List<Sheep> getChildren() {
     * return children;
     * }
     * public void setChildren(List<Sheep> children) {
     * this.children = children;
     * }
     * }
     * import java.util.Arrays;
     * import java.util.List;
     * // create a sheep
     * Sheep sheep = new Sheep("Dolly", 20);
     * // create children
     * Sheep child1 = new Sheep("Child1", 4);
     * Sheep child2 = new Sheep("Child2", 5);
     * sheep.setChildren(Arrays.asList(child1, child2));
     * // clone the sheep
     * Sheep dolly = (Sheep) sheep.clone();
     * List<Sheep> sheepChildren = sheep.getChildren();
     * List<Sheep> dollysChildren = dolly.getChildren();
     * for (int i = 0; i < sheepChildren.size(); i++) {
     * // prints false, both arrays contain copies of the objects inside
     * System.out.println(sheepChildren.get(i) == dollysChildren.get(i));
     * }
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // create a sheep
        Sheep sheep = new Sheep("Dolly", 20);

        // create children
        Sheep child1 = new Sheep("Child1", 4);
        Sheep child2 = new Sheep("Child2", 5);
        sheep.setChildren(Arrays.asList(child1, child2));

        try {
            // clone the sheep
            Sheep dolly = (Sheep) sheep.clone();

            List<Sheep> sheepChildren = sheep.getChildren();
            List<Sheep> dollysChildren = dolly.getChildren();
            for (int i = 0; i < sheepChildren.size(); i++) {
                // prints false, both arrays contain copies of the objects inside
                System.out.println(sheepChildren.get(i) == dollysChildren.get(i));
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
