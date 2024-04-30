import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Initializing_static_final_fields_using_a_static {
    // Initializing static final fields using a static initializer /
    // Menginisialisasi bidang akhir statis menggunakan penginisialisasi statis

    /*
     * Untuk menginisialisasi bidang static final yang memerlukan penggunaan lebih
     * dari satu ekspresi, penginisialisasi statis dapat digunakan untuk menetapkan
     * nilai. Contoh berikut menginisialisasi sekumpulan String yang tidak dapat
     * dimodifikasi:
     */

    public static final Set<String> WORDS;

    static {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("foo");
        set.add("bar");
        set.add("42");
        WORDS = Collections.unmodifiableSet(set);
    }

    public static void main(String[] args) {
        // Contoh penggunaan
        System.out.println("Kata-kata yang tidak dapat diubah:");
        for (String word : WORDS) {
            System.out.println(word);
        }
        /*
         * output:
         * Kata-kata yang tidak dapat diubah:
         * bar
         * Hello
         * foo
         * World
         * 42
         */
    }
}
