public class Cloning_by_implementing_clonable_interface {
    // Cloning by implementing Clonable interface/Kloning dengan mengimplementasikan
    // antarmuka Clonable

    // Mengkloning objek dengan mengimplementasikan antarmuka Cloneable.

    /*
     * public class Sheep implements Cloneable {
     * private String name;
     * private int weight;
     * public Sheep(String name, int weight) {
     * this.name = name;
     * this.weight = weight;
     * }
     * 
     * @Override
     * public Object clone() throws CloneNotSupportedException {
     * return super.clone();
     * }
     * }
     * // create a sheep
     * Sheep sheep = new Sheep("Dolly", 20);
     * // clone the sheep
     * Sheep dolly = (Sheep) sheep.clone(); // dolly.name is "Dolly" and
     * dolly.weight is 20
     */

    public static void main(String[] args) {
        // create a sheep
        Sheep3 sheep = new Sheep3("Dolly", 20);

        try {
            // clone the sheep
            Sheep3 dolly = (Sheep3) sheep.clone(); // dolly.name is "Dolly" and dolly.weight is 20
            // Output the details of the cloned sheep
            System.out.println("Cloned Sheep:");
            System.out.println("Name: " + dolly.getName());
            System.out.println("Weight: " + dolly.getWeight());

            /*
             * output:
             * Cloned Sheep:
             * Name: Dolly
             * Weight: 20
             */

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
