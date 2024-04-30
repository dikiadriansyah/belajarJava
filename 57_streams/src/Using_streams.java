import java.util.stream.Stream;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays.*;

public class Using_streams {
    // Using Streams / Menggunakan Aliran

    /*
     * Aliran adalah urutan elemen di mana operasi agregat berurutan dan paralel
     * dapat dilakukan.
     * Aliran apa pun berpotensi memiliki jumlah data tak terbatas yang mengalir
     * melaluinya. Hasilnya, data diterima
     * dari Aliran diproses satu per satu saat data tersebut diterima, bukan
     * melakukan pemrosesan batch pada data secara keseluruhan. Ketika
     * dikombinasikan dengan ekspresi lambda, ekspresi ini menyediakan cara ringkas
     * untuk melakukan operasi pada rangkaian data menggunakan pendekatan
     * fungsional.
     */

    /*
     * contoh: https://ideone.com/IUWRdv
     */

    /*
     * Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi",
     * "orange");
     * fruitStream.filter(s -> s.contains("a"))
     * .map(String::toUpperCase)
     * .sorted()
     * .forEach(System.out::println);
     * 
     * Output:
     * APPLE
     * BANANA
     * ORANGE
     * PEAR
     */

    /*
     * Operasi yang dilakukan oleh kode di atas dapat diringkas sebagai berikut:
     * 1. Buat Stream<String> yang berisi elemen Stream buah String yang diurutkan
     * menggunakan statis metode pabrik Stream.of(nilai).
     * 2. Operasi filter() hanya mempertahankan elemen yang cocok dengan predikat
     * tertentu (elemen yang saat diuji dengan predikat return true). Dalam hal ini,
     * ia mempertahankan elemen yang mengandung "a". Predikatnya diberikan sebagai
     * ekspresi lambda.
     * 3. Operasi map() mentransformasi setiap elemen menggunakan fungsi tertentu,
     * yang disebut mapper. Dalam hal ini, setiap buah String dipetakan ke versi
     * String huruf besar menggunakan referensi metode
     * String::toUppercase.
     * 
     * Perhatikan bahwa operasi map() akan mengembalikan aliran dengan tipe generik
     * yang berbeda jika pemetaan
     * fungsi mengembalikan tipe yang berbeda dengan parameter inputnya. Misalnya
     * pada panggilan Stream<String>
     * .map(String::isEmpty) mengembalikan Stream<Boolean>
     * 
     * 
     * 4. Operasi sorted() mengurutkan elemen-elemen Stream berdasarkan urutan
     * alaminya (secara leksikografis, dalam kasus String).
     * 5. Terakhir, operasi forEach(action) melakukan tindakan yang bekerja pada
     * setiap elemen Aliran,
     * meneruskannya kepada Konsumen. Dalam contoh ini, setiap elemen hanya dicetak
     * ke konsol. Operasi ini adalah operasi terminal, sehingga tidak mungkin untuk
     * dioperasikan lagi.
     * 
     * Perhatikan bahwa operasi yang ditentukan pada Stream dilakukan karena operasi
     * terminal.
     * Tanpa operasi terminal, aliran tidak diproses. Streaming tidak dapat
     * digunakan kembali. Setelah operasi terminal dipanggil, objek Stream menjadi
     * tidak dapat digunakan.
     * 
     * 
     */

    // Operasi (seperti yang terlihat di atas) dirangkai bersama untuk membentuk apa
    // yang bisa dilihat sebagai kueri pada data.

    /*
     * Menutup Streams
     * Perhatikan bahwa Aliran umumnya tidak harus ditutup. Hanya diperlukan untuk
     * menutup aliran itu beroperasi pada saluran IO. Sebagian besar tipe Aliran
     * tidak beroperasi pada sumber daya dan oleh karena itu tidak memerlukannya
     * penutupan
     */

    /*
     * Antarmuka Stream memperluas AutoCloseable. Aliran dapat ditutup dengan
     * memanggil metode close atau dengan menggunakan pernyataan trywith-resource.
     * Contoh kasus penggunaan di mana Aliran harus ditutup adalah ketika Anda
     * membuat Aliran garis dari sebuah file:
     * try (Stream<String> lines = Files.lines(Paths.get("somePath"))) {
     * lines.forEach(System.out::println);
     * }
     */

    /*
     * Antarmuka Stream juga mendeklarasikan metode Stream.onClose() yang
     * memungkinkan Anda mendaftarkan penangan Runnable
     * yang akan dipanggil ketika aliran ditutup. Contoh kasus penggunaan adalah
     * ketika kode yang menghasilkan aliran dibutuhkan
     * untuk mengetahui kapan dikonsumsi untuk melakukan pembersihan.
     * 
     * public Stream<String>streamAndDelete(Path path) throws IOException {
     * return Files.lines(path).onClose(() -> someClass.deletePath(path));
     * }
     */

    /*
     * Pengendali run hanya akan mengeksekusi jika metode close() dipanggil, baik
     * secara eksplisit atau implisit dengan pernyataan try-withresources.
     */

    // Processing Order/memproses pesanan
    // Pemrosesan objek Stream bisa berurutan atau paralel.

    /*
     * Dalam mode sekuensial, elemen diproses sesuai urutan sumber Aliran. Jika
     * Aliran dipesan
     * (seperti implementasi SortedMap atau Daftar) pemrosesannya dijamin sesuai
     * dengan urutan sumbernya.
     * Namun, dalam kasus lain, harus berhati-hati agar tidak bergantung pada
     * pengurutan (lihat: apakah Java HashMap keySet()
     * urutan iterasi konsisten?).
     */

    // Contoh:
    /*
     * List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 42);
     * // sequential
     * long howManyOddNumbers = integerList.stream()
     * .filter(e -> (e % 2) == 1)
     * .count();
     * System.out.println(howManyOddNumbers); // Output: 2
     * 
     * https://ideone.com/FuMz1c
     * 
     */

    /*
     * Mode paralel memungkinkan penggunaan banyak thread pada banyak inti tetapi
     * tidak ada jaminan urutannya elemen diproses.
     * 
     * Jika beberapa metode dipanggil pada Aliran berurutan, tidak setiap metode
     * harus dipanggil. Misalnya, jika Stream
     * difilter dan jumlah elemen dikurangi menjadi satu, pemanggilan berikutnya ke
     * metode seperti sortir tidak akan terjadi.
     * Hal ini dapat meningkatkan kinerja Aliran sekuensial — sebuah pengoptimalan
     * yang tidak mungkin dilakukan dengan aliran paralel Sungai kecil.
     */

    // Contoh:
    /*
     * // parallel
     * long howManyOddNumbersParallel = integerList.parallelStream()
     * .filter(e -> (e % 2) == 1)
     * .count();
     * System.out.println(howManyOddNumbersParallel); // Output: 2
     * 
     */

    // Differences from Containers (or Collections) / Perbedaan dari Wadah (atau
    // Koleksi)
    /*
     * Meskipun beberapa tindakan dapat dilakukan pada Container dan Stream,
     * tindakan tersebut pada akhirnya memiliki tujuan yang berbeda dan mendukung
     * operasi yang berbeda. Kontainer lebih fokus pada bagaimana elemen disimpan
     * dan bagaimana elemen tersebut dapat diakses secara efisien. Sebaliknya,
     * Stream tidak menyediakan akses dan manipulasi langsung ke elemen-elemennya;
     * itu lebih didedikasikan untuk sekelompok objek sebagai entitas kolektif dan
     * melakukan operasi pada entitas itu secara keseluruhan. Aliran dan Koleksi
     * adalah abstraksi tingkat tinggi yang terpisah untuk tujuan yang berbeda ini.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi",
        // "orange");
        // fruitStream.filter(s -> s.contains("a"))
        // .map(String::toUpperCase)
        // .sorted()
        // .forEach(System.out::println);

        /*
         * output:
         * APPLE
         * BANANA
         * ORANGE
         * PEAR
         */
        // ---------------------------------
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 42);

        // sequential
        long howManyOddNumbers = integerList.stream()
                .filter(e -> (e % 2) == 1).count();

        System.out.println(howManyOddNumbers); // Output: 2

        // parallel
        long howManyOddNumbersParallel = integerList.parallelStream()
                .filter(e -> (e % 2) == 1).count();

        System.out.println(howManyOddNumbersParallel); // Output: 2
    }
}
