public class Convert_enum_to_string {
    // Convert enum to String / Ubah enum menjadi String

    /*
     * Terkadang Anda ingin mengonversi enum Anda menjadi sebuah String, ada dua
     * cara untuk melakukannya.
     * 
     * Asumsikan kita memiliki:
     */

    public enum Fruit {
        APPLE, ORANGE, STRAWBERRY, BANANA, LEMON, GRAPE_FRUIT;
    }

    // Jadi bagaimana kita mengubah sesuatu seperti Fruit.APPLE menjadi "APPLE"?

    // Convert using name()
    /*
     * name() adalah metode internal dalam enum yang mengembalikan representasi
     * String dari enum, String yang dikembalikan mewakili dengan tepat bagaimana
     * nilai enum didefinisikan.
     * 
     */

    public static void main(String[] args) {
        // Misalnya:
        // System.out.println(Fruit.BANANA.name()); // "BANANA"
        // System.out.println(Fruit.GRAPE_FRUIT.name()); // "GRAPE_FRUIT

        // Convert using toString()

        // toString(), secara default, diganti agar memiliki perilaku yang sama seperti
        // name()

        /*
         * Namun, toString() kemungkinan besar diganti oleh pengembang untuk membuatnya
         * mencetak String yang lebih ramah pengguna
         * 
         * Jangan gunakan toString() jika Anda ingin memeriksa kode Anda, name() jauh
         * lebih stabil untuk itu. Hanya gunakan toString() ketika Anda akan menampilkan
         * nilai ke log atau stdout atau semacamnya
         */
        // By default:

        System.out.println(Fruit.BANANA.toString()); // "BANANA"
        System.out.println(Fruit.GRAPE_FRUIT.toString()); // "GRAPE_FRUIT"

        // Contoh ditimpa
        System.out.println(Fruit.BANANA.toString()); // "Banana"
        System.out.println(Fruit.GRAPE_FRUIT.toString()); // "Grape Fruit"
    }
}
