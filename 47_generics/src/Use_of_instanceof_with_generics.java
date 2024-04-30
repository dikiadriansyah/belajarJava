import java.util.ArrayList;
import java.util.List;

public class Use_of_instanceof_with_generics {
    // Use of instanceof with Generics / Penggunaan instanceof dengan Generik

    // Using generics to define the type in instanceof / Menggunakan obat generik
    // untuk menentukan tipe dalam instanceof

    // Pertimbangkan Contoh kelas generik berikut yang dideklarasikan dengan
    // parameter formal <T>

    /*
     * class Example<T> {
     * public boolean isTypeAString(String s) {
     * return s instanceof T; // Compilation error, cannot use T as class type here
     * }
     * }
     */

    /*
     * Hal ini akan selalu menghasilkan kesalahan Kompilasi karena segera setelah
     * kompiler mengkompilasi sumber Java menjadi bytecode Java, ia menerapkan
     * proses yang dikenal sebagai penghapusan tipe, yang mengubah semua kode
     * generik menjadi kode non-generik, sehingga tidak mungkin membedakan tipe T
     * saat runtime. Tipe yang digunakan dengan instanceof harus dapat diverifikasi,
     * artinya semua informasi tentang tipe tersebut harus tersedia saat runtime,
     * dan hal ini biasanya tidak berlaku untuk tipe generik.
     * 
     * Kelas berikut mewakili tampilan dua kelas Example yang berbeda,
     * Example<String> dan Example<Number> seperti setelah obat generik dihilangkan
     * berdasarkan jenis penghapusan:
     */

    /*
     * class Example { // formal parameter is gone
     * public boolean isTypeAString(String s) {
     * return s instanceof Object; // Both <String> and <Number> are now Object
     * }
     * }
     */

    // Karena tipe sudah tidak ada, JVM tidak mungkin mengetahui tipe mana yang T

    // Pengecualian terhadap aturan sebelumnya
    // Anda selalu dapat menggunakan wildcard tak terbatas (?) untuk menentukan tipe
    // dalam instanceof sebagai berikut:
    /*
     * public boolean isAList(Object obj) {
     * return obj instanceof List<?>;
     * }
     */

    /*
     * Ini dapat berguna untuk mengevaluasi apakah sebuah instance obj merupakan
     * sebuah List atau bukan:
     * System.out.println(isAList("foo")); // prints false
     * System.out.println(isAList(new ArrayList<String>()); // prints true
     * System.out.println(isAList(new ArrayList<Float>()); // prints true
     */

    // Faktanya, wildcard tak terbatas dianggap sebagai tipe yang dapat direifikasi.

    // Menggunakan instance generik dengan instanceof
    /*
     * Sisi lain dari hal ini adalah penggunaan instance t dari T dengan instanceof
     * adalah sah, seperti yang ditunjukkan dalam contoh berikut:
     */

    /*
     * class Example<T> {
     * public boolean isTypeAString(T t) {
     * return t instanceof String; // No compilation error this time
     * }
     * }
     */

    /*
     * karena setelah type erasure kelasnya akan terlihat seperti berikut:
     * class Example { // formal parameter is gone
     * public boolean isTypeAString(Object t) {
     * return t instanceof String; // No compilation error this time
     * }
     * }
     */

    /*
     * Karena, meskipun penghapusan tipe tetap terjadi, sekarang JVM bahkan dapat
     * membedakan tipe-tipe yang berbeda di memori
     * jika mereka menggunakan tipe referensi (Objek) yang sama, seperti yang
     * ditunjukkan cuplikan berikut:
     * Object obj1 = new String("foo"); // reference type Object, object type String
     * Object obj2 = new Integer(11); // reference type Object, object type Integer
     * System.out.println(obj1 instanceof String); // true
     * System.out.println(obj2 instanceof String); // false, it's an Integer, not a
     * String
     */

    public static void main(String[] args) {
        // System.out.println(isAList("foo")); // prints false
        // System.out.println(isAList(new ArrayList<String>())); // prints true
        // System.out.println(isAList(new ArrayList<Float>())); // prints true

        // -----------
        Object obj1 = new String("foo"); // reference type Object, object type String
        Object obj2 = new Integer(11); // reference type Object, object type Integer
        System.out.println(obj1 instanceof String); // true
        System.out.println(obj2 instanceof String); // false, ini dalam Integer, bukan sebuah String

    }

    public static boolean isAList(Object obj) {
        return obj instanceof List<?>;
    }
}
