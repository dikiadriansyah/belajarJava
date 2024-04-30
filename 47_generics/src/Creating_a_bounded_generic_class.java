import java.util.*;

public class Creating_a_bounded_generic_class {
    // Creating a Bounded Generic Class / Membuat Kelas Generik Terikat

    /*
     * Anda dapat membatasi tipe valid yang digunakan dalam kelas generik dengan
     * membatasi tipe tersebut dalam definisi kelas. Mengingat hierarki tipe
     * sederhana berikut:
     * public abstract class Animal {
     * public abstract String getSound();
     * }
     * public class Cat extends Animal {
     * public String getSound() {
     * return "Meow";
     * }
     * }
     * public class Dog extends Animal {
     * public String getSound() {
     * return "Woof";
     * }
     * }
     * 
     */

    // Tanpa obat generik yang dibatasi, kita tidak dapat membuat kelas penampung
    // yang bersifat generik dan mengetahui bahwa setiap elemen adalah hewan:
    /*
     * public class AnimalContainer<T> {
     * private Collection<T> col;
     * public AnimalContainer() {
     * col = new ArrayList<T>();
     * }
     * public void add(T t) {
     * col.add(t);
     * }
     * public void printAllSounds() {
     * for (T t : col) {
     * // Illegal, type T doesn't have makeSound()
     * // it is used as an java.lang.Object here
     * System.out.println(t.makeSound());
     * }
     * }
     * }
     */

    // Dengan batasan umum dalam definisi kelas, hal ini sekarang mungkin dilakukan.
    /*
     * public class BoundedAnimalContainer<T extends Animal> { // Note bound here.
     * private Collection<T> col;
     * public BoundedAnimalContainer() {
     * col = new ArrayList<T>();
     * }
     * public void add(T t) {
     * col.add(t);
     * }
     * public void printAllSounds() {
     * for (T t : col) {
     * // Now works because T is extending Animal
     * System.out.println(t.makeSound());
     * }
     * }
     * }
     */

    // Ini juga membatasi instantiasi valid dari tipe generik:
    /*
     * // Legal
     * AnimalContainer<Cat> a = new AnimalContainer<Cat>();
     * // Legal
     * AnimalContainer<String> a = new AnimalContainer<String>();
     * // Legal because Cat extends Animal
     * BoundedAnimalContainer<Cat> b = new BoundedAnimalContainer<Cat>();
     * // Illegal because String doesn't extends Animal
     * BoundedAnimalContainer<String> b = new BoundedAnimalContainer<String>();
     */

    public static void main(String[] args) {
        // Legal
        AnimalContainer<Cat> a = new AnimalContainer<Cat>();
        a.add(new Cat());
        a.printAllSounds(); // Output: Meow

        // Legal
        // AnimalContainer<String> b = new AnimalContainer<String>();

        // Legal because Cat extends Animal
        // BoundedAnimalContainer<Cat> c = new BoundedAnimalContainer<Cat>();

        // Illegal because String doesn't extends Animal
        // BoundedAnimalContainer<String> d = new BoundedAnimalContainer<String>();
    }
}
