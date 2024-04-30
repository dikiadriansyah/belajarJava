public class Usefulness_of_interfaces {
    // Usefulness of interfaces/Kegunaan antarmuka

    /*
     * Antarmuka bisa sangat membantu dalam banyak kasus. Misalnya, Anda memiliki
     * daftar hewan dan Anda ingin menelusuri daftar tersebut, masing-masing
     * mencetak suara yang dihasilkannya.
     */

    // {cat, dog, bird}

    /*
     * Salah satu cara untuk melakukan ini adalah dengan menggunakan antarmuka. Ini
     * akan memungkinkan metode yang sama dipanggil di semua kelas
     */

    /*
     * public interface Animal {
     * public String getSound();
     * }
     */

    /*
     * Setiap kelas yang implements Animal juga harus memiliki metode
     * getSound() di dalamnya, namun semuanya dapat memiliki implementasi yang
     * berbeda
     */

    /*
     * public class Dog implements Animal {
     * public String getSound() {
     * return "Woof";
     * }
     * }
     * public class Cat implements Animal {
     * public String getSound() {
     * return "Meow";
     * }
     * }
     * public class Bird implements Animal{
     * public String getSound() {
     * return "Chirp";
     * }
     * }
     */

    /*
     * Kami sekarang memiliki tiga kelas berbeda, yang masing-masing memiliki metode
     * getSound(). Karena semua kelas ini implement Animal interface, yang
     * mendeklarasikan metode getSound(),
     * yang dapat dimiliki oleh setiap instance Hewan getSound() memanggilnya
     */

    /*
     * Animal dog = new Dog();
     * Animal cat = new Cat();
     * Animal bird = new Bird();
     * dog.getSound(); // "Woof"
     * cat.getSound(); // "Meow"
     * bird.getSound(); // "Chirp"
     */

    /*
     * Karena masing-masingnya adalah Animal, kita bahkan dapat memasukkan
     * hewan-hewan tersebut ke dalam daftar, menelusurinya, dan mencetak suaranya
     */

    /*
     * Animal[] animals = { new Dog(), new Cat(), new Bird() };
     * for (Animal animal : animals) {
     * System.out.println(animal.getSound());
     * }
     */

    /*
     * Karena urutan lariknya adalah Anjing, Kucing, lalu Burung, "Woof Meow Chirp"
     * akan dicetak ke console.
     * 
     * Antarmuka juga dapat digunakan sebagai nilai kembalian fungsi. Misalnya,
     * mengembalikan Dog jika inputnya adalah "dog", Cat jika
     * inputnya adalah "cat", dan Bird jika "bird", lalu pencetakan suara
     * hewan tersebut dapat dilakukan dengan menggunakan
     */

    /*
     * public Animal getAnimalByName(String name) {
     * switch(name.toLowerCase()) {
     * case "dog":
     * return new Dog();
     * case "cat":
     * return new Cat();
     * case "bird":
     * return new Bird();
     * default:
     * return null;
     * }
     * }
     * public String getAnimalSoundByName(String name){
     * Animal animal = getAnimalByName(name);
     * if (animal == null) {
     * return null;
     * } else {
     * return animal.getSound();
     * }
     * }
     * String dogSound = getAnimalSoundByName("dog"); // "Woof"
     * String catSound = getAnimalSoundByName("cat"); // "Meow"
     * String birdSound = getAnimalSoundByName("bird"); // "Chirp"
     * String lightbulbSound = getAnimalSoundByName("lightbulb"); // null
     */

    /*
     * Antarmuka juga berguna untuk ekstensibilitas, karena jika Anda ingin
     * menambahkan jenis Animal baru, Anda tidak perlu mengubah apa pun dengan
     * operasi yang Anda lakukan pada Animal tersebut.
     */

    public static void main(String[] args) {
        Animal dog = new Dog3();
        Animal cat = new Cat3();
        Animal bird = new Bird2();

        System.out.println(dog.getSound());// "Woof"
        System.out.println(cat.getSound());// "Meow"
        System.out.println(bird.getSound());// "Chirp"

    }
}
