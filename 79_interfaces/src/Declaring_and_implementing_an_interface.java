
public class Declaring_and_implementing_an_interface {
    // Declaring and Implementing an Interface/Mendeklarasikan dan
    // Mengimplementasikan Antarmuka

    // Deklarasi antarmuka menggunakan kata kunci interface:

    /*
     * public interface Animal {
     * String getSound(); // Interface methods are public by default
     * }
     * Override Annotation
     * 
     * @Override
     * public String getSound() {
     * // Code goes here...
     * }
     */

    /*
     * Hal ini memaksa kompiler untuk memeriksa apakah kita melakukan override dan
     * mencegah program mendefinisikan metode atau mengacaukan tanda tangan metode.
     */

    // Interfaces are implemented using the implements keyword / Antarmuka
    // diimplementasikan menggunakan kata kunci implementasi

    /*
     * public class Cat implements Animal {
     * 
     * @Override
     * public String getSound() {
     * return "meow";
     * }
     * }
     * public class Dog implements Animal {
     * 
     * @Override
     * public String getSound() {
     * return "woof";
     * }
     * }
     */

    /*
     * Dalam contoh ini, kelas Cat dan Dog harus mendefinisikan metode getSound()
     * karena metode antarmuka bersifat abstrak (dengan pengecualian metode
     * default).
     */

    // Using the interfaces/Menggunakan antarmuka
    /*
     * Animal cat = new Cat();
     * Animal dog = new Dog();
     * System.out.println(cat.getSound()); // prints "meow"
     * System.out.println(dog.getSound()); // prints "woof"
     */

    public static void main(String[] args) throws Exception {
        Animal cat = new Cat2();
        Animal dog = new Dog2();
        System.out.println(cat.getSound()); // prints "meow"
        System.out.println(dog.getSound()); // prints "woof"

    }
}
