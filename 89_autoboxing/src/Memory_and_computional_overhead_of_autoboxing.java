import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Memory_and_computional_overhead_of_autoboxing {
    // Memory and Computational Overhead of Autoboxing/Memori dan Overhead Komputasi
    // Autoboxing

    /*
     * Autoboxing dapat menimbulkan overhead memori yang besar. Misalnya:
     * Map<Integer, Integer> square = new HashMap<Integer, Integer>();
     * for(int i = 256; i < 1024; i++) {
     * square.put(i, i * i); // Autoboxing of large integers
     * }
     */

    /*
     * biasanya akan menghabiskan sejumlah besar memori (sekitar 60kb untuk 6k data
     * aktual).
     * Selain itu, bilangan bulat dalam kotak biasanya memerlukan perjalanan
     * bolak-balik tambahan dalam memori, sehingga membuat cache CPU menjadi kurang
     * efektif. Dalam contoh di atas, memori yang diakses tersebar ke lima lokasi
     * berbeda yang mungkin berada di wilayah memori yang berbeda:
     * 1. objek HashMap,
     * 2. objek tabel Entry[] peta,
     * 3. objek Entri,
     * 4. objek kunci entri (meninju kunci primitif),
     * 5. objek nilai entri (mengepak nilai primitif).
     */

    /*
     * class Example {
     * int primitive; // Stored directly in the class `Example`
     * Integer boxed; // Reference to another memory location
     * }
     */

    /*
     * baca boxed memerlukan dua akses memori, mengakses primitif hanya satu.
     * Saat mendapatkan data dari peta ini, kode yang tampaknya tidak bersalah
     * int sumOfSquares = 0;
     * for(int i = 256; i < 1024; i++) {
     * sumOfSquares += square.get(i);
     * }
     * 
     * setara dengan:
     * int sumOfSquares = 0;
     * for(int i = 256; i < 1024; i++) {
     * sumOfSquares += square.get(Integer.valueOf(i)).intValue();
     * }
     * 
     */

    /*
     * Biasanya, kode di atas menyebabkan pembuatan dan pengumpulan sampah objek
     * Integer untuk setiap Operasi peta#get(Integer). (Lihat Catatan di
     * bawah untuk lebih jelasnya.)
     * 
     * Untuk mengurangi overhead ini, beberapa perpustakaan menawarkan koleksi yang
     * dioptimalkan untuk tipe primitif yang tidak memerlukan tinju.
     * Selain menghindari overhead tinju, koleksi ini akan memerlukan memori sekitar
     * 4x lebih sedikit per entri. Ketika Java Hotspot mungkin dapat mengoptimalkan
     * autoboxing dengan bekerja dengan objek di tumpukan, bukan di tumpukan, itu
     * adalah tidak mungkin untuk mengoptimalkan overhead memori dan tipuan memori
     * yang dihasilkan.
     * 
     * Aliran Java 8 juga memiliki antarmuka yang dioptimalkan untuk tipe data
     * primitif, seperti IntStream yang tidak memerlukan tinju.
     * 
     * Catatan: runtime Java pada umumnya memelihara cache sederhana Integer dan
     * objek pembungkus primitif lainnya yang digunakan oleh metode pabrik valueOf,
     * dan dengan autoboxing. Untuk Integer, rentang default cache ini adalah -128
     * hingga +127. Beberapa JVM menyediakan opsi baris perintah JVM untuk mengubah
     * size/range cache.
     */

    public static void main(String[] args) {
        // Map<Integer, Integer> square = new HashMap<Integer, Integer>();
        // for (int i = 256; i < 280; i++) {
        // square.put(i, i * i); // Autoboxing of large integers
        // }

        // // Menampilkan hasil dari map
        // for (Map.Entry<Integer, Integer> entry : square.entrySet()) {
        // System.out.println("Kuadrat dari " + entry.getKey() + " = " +
        // entry.getValue());
        // }
        /*
         * output:
         * Kuadrat dari 256 = 65536
         * Kuadrat dari 257 = 66049
         * Kuadrat dari 258 = 66564
         * Kuadrat dari 259 = 67081
         * Kuadrat dari 260 = 67600
         * Kuadrat dari 261 = 68121
         * Kuadrat dari 262 = 68644
         * Kuadrat dari 263 = 69169
         * Kuadrat dari 264 = 69696
         * Kuadrat dari 265 = 70225
         * Kuadrat dari 266 = 70756
         * Kuadrat dari 267 = 71289
         * Kuadrat dari 268 = 71824
         * Kuadrat dari 269 = 72361
         * Kuadrat dari 270 = 72900
         * Kuadrat dari 271 = 73441
         * Kuadrat dari 272 = 73984
         * Kuadrat dari 273 = 74529
         * Kuadrat dari 274 = 75076
         * Kuadrat dari 275 = 75625
         * Kuadrat dari 276 = 76176
         * Kuadrat dari 277 = 76729
         * Kuadrat dari 278 = 77284
         * Kuadrat dari 279 = 77841
         */
        // ------------------------------
        // Map<Integer, Integer> square = new HashMap<Integer, Integer>();

        // int sumOfSquares = 0;
        // for (int i = 256; i < 1024; i++) {
        // sumOfSquares += square.get(i);
        // }
        // System.out.println("Sum of squares: " + sumOfSquares);
        // ------------------------------
        HashMap<Integer, Integer> square = new HashMap<>();
        for (int i = 0; i < 1024; i++) {
            square.put(i, i * i);
        }

        int sumOfSquares = 0;
        for (int i = 256; i < 1024; i++) {
            sumOfSquares += square.get(Integer.valueOf(i)).intValue();
        }
        System.out.println("Sum of squares from 256 to 1023: " + sumOfSquares);
        /*
         * output:
         * Sum of squares from 256 to 1023: 351830144
         */
    }
}
