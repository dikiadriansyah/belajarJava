import java.util.*;

public class Deciding_between_t {
    // Deciding between `T`, `? super T`, and `? extends T` / Memutuskan antara `T`,
    // `? super T`, dan `? memanjang T`

    /*
     * Sintaks untuk wildcard terikat generik Java, mewakili tipe yang tidak
     * diketahui dengan ? adalah:
     * ? extends T mewakili wildcard batas atas. Tipe yang tidak diketahui mewakili
     * tipe yang harus merupakan subtipe dari T, atau tipe T itu sendiri.
     * 
     * ? super T mewakili wildcard berbatas bawah. Tipe yang tidak diketahui
     * mewakili tipe yang harus merupakan supertipe dari T, atau tipe T itu sendiri.
     * 
     */

    // Sebagai aturan praktis, Anda harus menggunakan
    /*
     * ? extends T if you only need "read" access ("input") / jika Anda hanya
     * memerlukan akses "baca" ("input")
     * ? super T if you need "write" access ("output") / jika Anda memerlukan akses
     * "tulis" ("output")
     * T if you need both ("modify") / jika Anda membutuhkan keduanya ("modifikasi")
     * 
     */

    /*
     * Menggunakan extends atau super biasanya lebih baik karena membuat kode Anda
     * lebih fleksibel (seperti: mengizinkan penggunaan
     * subtypes dan supertypes), seperti yang akan Anda lihat di bawah.
     */

    /*
     * class Shoe {}
     * class IPhone {}
     * interface Fruit {}
     * class Apple implements Fruit {}
     * class Banana implements Fruit {}
     * class GrannySmith extends Apple {}
     * public class FruitHelper {
     * public void eatAll(Collection<? extends Fruit> fruits) {}
     * public void addApple(Collection<? super Apple> apples) {}
     * }
     */

    // Kompiler sekarang dapat mendeteksi penggunaan buruk tertentu:
    /*
     * public class GenericsTest {
     * public static void main(String[] args){
     * FruitHelper fruitHelper = new FruitHelper() ;
     * List<Fruit> fruits = new ArrayList<Fruit>();
     * fruits.add(new Apple()); // Allowed, as Apple is a Fruit
     * fruits.add(new Banana()); // Allowed, as Banana is a Fruit
     * fruitHelper.addApple(fruits); // Allowed, as "Fruit super Apple"
     * fruitHelper.eatAll(fruits); // Allowed
     * Collection<Banana> bananas = new ArrayList<>();
     * bananas.add(new Banana()); // Allowed
     * //fruitHelper.addApple(bananas); // Compile error: may only contain Bananas!
     * fruitHelper.eatAll(bananas); // Allowed, as all Bananas are Fruits
     * Collection<Apple> apples = new ArrayList<>();
     * fruitHelper.addApple(apples); // Allowed
     * apples.add(new GrannySmith()); // Allowed, as this is an Apple
     * fruitHelper.eatAll(apples); // Allowed, as all Apples are Fruits.
     * 
     * Collection<GrannySmith> grannySmithApples = new ArrayList<>();
     * fruitHelper.addApple(grannySmithApples); //Compile error: Not allowed.
     * // GrannySmith is not a supertype of Apple
     * apples.add(new GrannySmith()); //Still allowed, GrannySmith is an Apple
     * fruitHelper.eatAll(grannySmithApples);//Still allowed, GrannySmith is a Fruit
     * Collection<Object> objects = new ArrayList<>();
     * fruitHelper.addApple(objects); // Allowed, as Object super Apple
     * objects.add(new Shoe()); // Not a fruit
     * objects.add(new IPhone()); // Not a fruit
     * //fruitHelper.eatAll(objects); // Compile error: may contain a Shoe, too!
     * }
     * 
     */

    /*
     * Memilih T yang tepat, ? super T atau? extends T diperlukan untuk memungkinkan
     * penggunaan dengan subtipe. Kompiler kemudian dapat memastikan keamanan tipe;
     * Anda tidak perlu melakukan cast (yang tidak aman untuk tipe, dan dapat
     * menyebabkan kesalahan pemrograman) jika Anda menggunakannya dengan benar
     */

    // Jika tidak mudah dipahami, harap ingat aturan PECS:
    // Produsen menggunakan "Extends" dan Konsumen menggunakan "Super".

    // (Produser hanya mempunyai akses tulis, dan Konsumen hanya mempunyai akses
    // baca)

    public static void main(String[] args) {
        FruitHelper fruitHelper = new FruitHelper();
        List<Fruit> fruits = new ArrayList<Fruit>();

        fruits.add(new Apple()); // Allowed, as Apple is a Fruit
        fruits.add(new Banana()); // Allowed, as Banana is a Fruit

        fruitHelper.addApple(fruits); // Allowed, as "Fruit super Apple"
        /*
         * output:
         * Added an Apple
         */

        fruitHelper.eatAll(fruits); // Allowed
        /*
         * output:
         * Eating: Apple
         */

        Collection<Banana> bananas = new ArrayList<>();

        bananas.add(new Banana()); // Allowed
        // fruitHelper.addApple(bananas); // Compile error: may only contain Bananas!
        fruitHelper.eatAll(bananas); // Allowed, as all Bananas are Fruits

        Collection<Apple> apples = new ArrayList<>();

        fruitHelper.addApple(apples); // Allowed
        /*
         * output:
         * Added an Apple
         */

        apples.add(new GrannySmith()); // Allowed, as this is an Apple
        fruitHelper.eatAll(apples); // Allowed, as all Apples are Fruits.

        Collection<GrannySmith> grannySmithApples = new ArrayList<>();
        // fruitHelper.addApple(grannySmithApples); // Compile error: Not allowed.
        // GrannySmith is not a supertype of Apple

        apples.add(new GrannySmith()); // Still allowed, GrannySmith is an Apple
        fruitHelper.eatAll(grannySmithApples);// Still allowed, GrannySmith is a Fruit

        Collection<Object> objects = new ArrayList<>();

        fruitHelper.addApple(objects); // Allowed, as Object super Apple
        /*
         * output:
         * Added an Apple
         */

        // objects.add(new Shoe()); // Not a fruit
        // objects.add(new IPhone()); // Not a fruit
        // fruitHelper.eatAll(objects); // Compile error: may contain a Shoe, too!
    }
}
