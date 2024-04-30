public class Implementing_interfaces_in_an_abstract_class extends Animal2 {
    // Implementing interfaces in an abstract class/Mengimplementasikan antarmuka di
    // kelas abstrak

    /*
     * Metode yang didefinisikan dalam interface secara default adalah public
     * abstract.
     * Ketika abstract class mengimplementasikan sebuah
     * interface, metode apa pun yang didefinisikan dalam interface tidak harus
     * diimplementasikan secara abstract class.
     * Hal ini karena class yang dideklarasikan abstract dapat berisi
     * deklarasi metode abstrak. Oleh karena itu merupakan tanggung jawab subkelas
     * konkrit pertama untuk mengimplementasikan metode abstrak apa pun yang
     * diwarisi dari interface dan/atau abstract class apa pun.
     */

    /*
     * public interface NoiseMaker {
     * void makeNoise();
     * }
     * 
     * public abstract class Animal implements NoiseMaker {
     * //Does not need to declare or implement makeNoise()
     * public abstract void eat();
     * }
     * //Because Dog is concrete, it must define both makeNoise() and eat()
     * public class Dog extends Animal {
     * 
     * @Override
     * public void makeNoise() {
     * System.out.println("Borf borf");
     * }
     * 
     * @Override
     * public void eat() {
     * System.out.println("Dog eats some kibble.");
     * }
     * }
     */

    /*
     * Mulai Java 8 dan seterusnya, antarmuka dapat mendeklarasikan implementasi
     * metode default yang berarti metode tersebut tidak akan abstract, oleh karena
     * itu subkelas konkret apa pun tidak akan dipaksa untuk mengimplementasikan
     * metode tersebut tetapi akan mewarisi implementasi default kecuali ditimpa.
     */

    // Implementation of makeNoise method from NoiseMaker interface
    @Override
    public void makeNoise2() {
        System.out.println("Borf borf");
    }

    // Implementation of eat method from Animal abstract class
    @Override
    public void eat() {
        System.out.println("Dog eats some kibble.");
    }

    // Additional method specific to Dog class
    public void wagTail() {
        System.out.println("Dog wags its tail.");
    }

    public static void main(String[] args) {
        Implementing_interfaces_in_an_abstract_class myDog = new Implementing_interfaces_in_an_abstract_class();
        myDog.makeNoise2();
        /*
         * output:
         * Borf borf
         */

        myDog.eat();
        /*
         * output:
         * Dog eats some kibble.
         */

        myDog.wagTail();
        /*
         * output:
         * Dog wags its tail.
         */
    }
}
