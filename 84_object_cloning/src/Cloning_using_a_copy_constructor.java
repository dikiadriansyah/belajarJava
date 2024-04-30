public class Cloning_using_a_copy_constructor {
    // Cloning using a copy constructor/Kloning menggunakan konstruktor salinan

    // Cara mudah untuk mengkloning suatu objek adalah dengan mengimplementasikan
    // copy konstruktor.

    /*
     * public class Sheep {
     * private String name;
     * private int weight;
     * public Sheep(String name, int weight) {
     * this.name = name;
     * this.weight = weight;
     * }
     * // copy constructor
     * // copies the fields of other into the new object
     * public Sheep(Sheep other) {
     * this.name = other.name;
     * this.weight = other.weight;
     * }
     * }
     * // create a sheep
     * Sheep sheep = new Sheep("Dolly", 20);
     * // clone the sheep
     * Sheep dolly = new Sheep(sheep); // dolly.name is "Dolly" and dolly.weight is
     * 20
     */

    private String name;
    private int weight;

    public Cloning_using_a_copy_constructor(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    // copy constructor
    // copies the fields of other into the new object
    public Cloning_using_a_copy_constructor(Cloning_using_a_copy_constructor other) {
        this.name = other.name;
        this.weight = other.weight;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Method to clone Sheep
    public Cloning_using_a_copy_constructor cloneSheep() {
        return new Cloning_using_a_copy_constructor(this);
    }

    public static void main(String[] args) {
        // create a sheep
        Cloning_using_a_copy_constructor sheep = new Cloning_using_a_copy_constructor("Dolly", 20);

        // clone the sheep
        Cloning_using_a_copy_constructor dolly = new Cloning_using_a_copy_constructor(sheep); // dolly.name is "Dolly"
                                                                                              // and dolly.weight is 20

        // Output
        System.out.println("Original Sheep - Name: " + sheep.getName() + ", Weight: " + sheep.getWeight());
        System.out.println("Cloned Sheep - Name: " + dolly.getName() + ", Weight: " + dolly.getWeight());
        /*
         * output:
         * Original Sheep - Name: Dolly, Weight: 20
         * Cloned Sheep - Name: Dolly, Weight: 20
         */
    }
}
