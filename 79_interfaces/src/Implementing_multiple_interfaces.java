
public class Implementing_multiple_interfaces {
    // Implementing multiple interfaces/Menerapkan banyak antarmuka

    // Kelas Java dapat mengimplementasikan banyak antarmuka.

    /*
     * public interface NoiseMaker {
     * String noise = "Making Noise"; // interface variables are public static final
     * by default
     * String makeNoise(); //interface methods are public abstract by default
     * }
     * public interface FoodEater {
     * void eat(Food food);
     * }
     * public class Cat implements NoiseMaker, FoodEater {
     * 
     * @Override
     * public String makeNoise() {
     * return "meow";
     * }
     * 
     * @Override
     * public void eat(Food food) {
     * System.out.println("meows appreciatively");
     * }
     * }
     */

    /*
     * Perhatikan bagaimana kelas Cat harus mengimplementasikan metode abstract yang
     * diwarisi di kedua antarmuka. Lebih-lebih lagi,
     * perhatikan bagaimana suatu kelas secara praktis dapat mengimplementasikan
     * antarmuka sebanyak yang diperlukan (ada batas 65.535 karena Batasan JVM).
     */
    /*
     * NoiseMaker noiseMaker = new Cat(); // Valid
     * FoodEater foodEater = new Cat(); // Valid
     * Cat cat = new Cat(); // valid
     * Cat invalid1 = new NoiseMaker(); // Invalid
     * Cat invalid2 = new FoodEater(); // Invalid
     */

    /*
     * Catatan:
     * 1. Semua variabel yang dideklarasikan dalam antarmuka adalah public static
     * final
     * 2. Semua metode yang dideklarasikan dalam metode antarmuka adalah public
     * abstract (Pernyataan ini hanya valid melalui Java
     * 7. Dari Java 8, Anda diperbolehkan memiliki metode dalam antarmuka, yang
     * tidak perlu bersifat abstrak; metode seperti itu
     * dikenal sebagai metode default)
     * 3. Antarmuka tidak dapat dinyatakan final
     * 4. Jika lebih dari satu antarmuka mendeklarasikan suatu metode yang memiliki
     * tanda tangan yang identik, maka secara efektif metode tersebut diperlakukan
     * sebagai metode saja
     * satu metode dan Anda tidak dapat membedakan metode antarmuka mana yang
     * diterapkan
     * 5. File InterfaceName.class yang sesuai akan dibuat untuk setiap antarmuka,
     * setelah kompilasi
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        NoiseMaker noiseMaker = new Cat(); // Valid
        System.out.println(noiseMaker.makeNoise()); // meow

        // FoodEater foodEater = new Cat(); // Valid
        // Cat cat = new Cat(); // valid

        // Cat invalid1 = new NoiseMaker(); // Invalid
        // Cat invalid2 = new FoodEater(); // Invalid
    }
}
