import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Cloning_performing_a_shallow_copy {
    // Cloning performing a shallow copy/Kloning melakukan penyalinan dangkal

    /*
     * Perilaku default saat mengkloning suatu objek adalah melakukan salinan
     * dangkal bidang objek. Dalam hal ini, baik objek asli maupun objek kloning,
     * menyimpan referensi ke objek yang sama.
     */

    // Contoh ini menunjukkan perilaku itu.

    /*
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
     * return super.clone();
     * }
     * public List<Sheep> getChildren() {
     * return children;
     * }
     * public void setChildren(List<Sheep> children) {
     * this.children = children;
     * }
     * }
     */

    /*
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
     * // prints true, both arrays contain the same objects
     * System.out.println(sheepChildren.get(i) == dollysChildren.get(i));
     * }
     */

    public static void main(String[] args) {
        // create a sheep
        Sheep4 sheep = new Sheep4("Dolly", 20);

        // create children
        Sheep4 child1 = new Sheep4("Child1", 4);
        Sheep4 child2 = new Sheep4("Child2", 5);
        sheep.setChildren(Arrays.asList(child1, child2));

        try {
            // clone the sheep
            Sheep4 dolly = (Sheep4) sheep.clone();
            List<Sheep4> sheepChildren = sheep.getChildren();
            List<Sheep4> dollysChildren = dolly.getChildren();
            for (int i = 0; i < sheepChildren.size(); i++) {
                // prints true, both arrays contain the same objects
                System.out.println(sheepChildren.get(i) == dollysChildren.get(i));
            }
            // output:
            // true

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
