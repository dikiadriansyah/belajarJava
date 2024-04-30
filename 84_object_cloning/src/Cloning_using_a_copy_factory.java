public class Cloning_using_a_copy_factory {

    // Cloning using a copy factory/Kloning menggunakan pabrik fotokopi

    public static void main(String[] args) {
        Sheep2 originalSheep = new Sheep2("Dolly", 50);
        Sheep2 clonedSheep = Sheep2.newInstance(originalSheep);

        System.out.println("Original Sheep: " + originalSheep.getName() + ", " + originalSheep.getWeight() + " kg");
        System.out.println("Cloned Sheep: " + clonedSheep.getName() + ", " + clonedSheep.getWeight() + " kg");
        /*
         * output:
         * Original Sheep: Dolly, 50 kg
         * Cloned Sheep: Dolly, 50 kg
         */
    }

}
