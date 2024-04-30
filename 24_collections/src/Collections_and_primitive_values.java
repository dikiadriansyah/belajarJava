import java.util.*;

public class Collections_and_primitive_values {
    // Collections and Primitive Values
    /*
     * Koleksi di Java hanya berfungsi untuk objek. Yaitu. tidak ada Map<int, int>
     * di Jawa. Sebaliknya, nilai-nilai primitif harus ada
     * dimasukkan ke dalam objek, seperti pada Map<Integer, Integer>. Java
     * auto-boxing akan memungkinkan penggunaan koleksi berikut secara transparan:
     */
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 17); // Automatic boxing of int to Integer objects
        int a = map.get(1); // Automatic unboxing.
        System.out.println(a); // 17

        /*
         * Sayangnya, biaya overhead dari hal ini cukup besar. HashMap<Integer, Integer>
         * akan membutuhkan sekitar 72 byte per
         * entri (misalnya pada JVM 64-bit dengan pointer terkompresi, dan dengan asumsi
         * bilangan bulat lebih besar dari 256, dan dengan asumsi beban 50%
         * dari Map). Karena data sebenarnya hanya 8 byte, hal ini menghasilkan
         * overhead yang sangat besar. Selain itu, ini membutuhkan dua
         * tingkat tipuan (Map -> Entry -> Value) terlalu lambat.
         * 
         * Terdapat beberapa perpustakaan dengan koleksi yang dioptimalkan untuk tipe
         * data primitif (yang hanya memerlukan ~16 byte per entri pada beban 50%, yaitu
         * memori 4x lebih sedikit, dan tingkat tipuan lebih sedikit), yang dapat
         * menghasilkan manfaat kinerja yang besar
         * saat menggunakan banyak koleksi nilai primitif di Java.
         */
    }
}
