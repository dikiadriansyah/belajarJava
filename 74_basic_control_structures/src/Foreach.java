import java.util.ArrayList;
import java.util.List;

public class Foreach {
    // Foreach

    /*
     * Version ≥ Java SE 5
     * Dengan Java 5 dan yang lebih baru, seseorang dapat menggunakan perulangan
     * for-each, yang juga dikenal sebagai perulangan for-enhanced
     * 
     * List strings = new ArrayList();
     * 
     * strings.add("This");
     * strings.add("is");
     * strings.add("a for-each loop");
     * 
     * (String string : strings) { System.out.println(string); }
     */

    /*
     * Untuk setiap loop dapat digunakan untuk mengulangi Array dan implementasi
     * antarmuka Iterable, yang kemudian disertakan
     * Kelas collection, seperti List atau Set.
     * 
     * Variabel loop dapat berupa tipe apa pun yang dapat ditetapkan dari tipe
     * sumber.
     */

    /*
     * Variabel perulangan untuk perulangan for yang disempurnakan untuk Iterable<T>
     * atau T[] dapat bertipe S, jika
     * 1. T extends S
     * 2. baik T dan S adalah tipe primitif dan dapat ditugaskan tanpa pemeran
     * 3. S adalah tipe primitif dan T dapat dikonversi ke tipe yang dapat
     * ditetapkan ke S setelah konversi unboxing
     * 4. T adalah tipe primitif dan dapat dikonversi ke S dengan konversi
     * autoboxing.
     */

    // Contoh:

    /*
     * T elements = ...
     * for(S s : elements){}
     */

    // T | S | Compiles
    /*
     * int[] | long | yes
     * long[] | int | no
     * Iterable<Byte> | long | yes
     * Iterable<String> | CharSequence | yes
     * Iterable<CharSequence> | String | no
     * int[] | Long | no
     * int[] | Integer | yes
     * 
     */

    public static void main(String[] args) {
        List<String> strings = new ArrayList();

        strings.add("This");
        strings.add("is");
        strings.add("a for-each loop");
        // Menampilkan isi List menggunakan for-each loop
        for (String str : strings) {
            System.out.println(str);
        }

        /*
         * output:
         * This
         * is
         * a for-each loop
         */

    }
}
