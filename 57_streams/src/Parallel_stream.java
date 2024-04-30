import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Parallel_stream {
    // Parallel Stream / Aliran Paralel

    /*
     * Catatan: Sebelum memutuskan Stream mana yang akan digunakan, silakan lihat
     * perilaku ParallelStream vs Sequential Stream.
     * 
     * Saat Anda ingin melakukan operasi Stream secara bersamaan, Anda dapat
     * menggunakan salah satu cara berikut.
     * 
     * List<String> data = Arrays.asList("One", "Two", "Three", "Four", "Five");
     * Stream<String> aParallelStream = data.stream().parallel();
     * 
     * atau:
     * Stream<String> aParallelStream = data.parallelStream();
     * 
     * Untuk menjalankan operasi yang ditentukan untuk aliran paralel, panggil
     * operator terminal:
     * aParallelStream.forEach(System.out::println);
     * 
     */

    /*
     * (Kemungkinan) keluaran dari Aliran paralel:
     * Three
     * Four
     * One
     * Two
     * Five
     */

    /*
     * Urutannya mungkin berubah karena semua elemen diproses secara paralel (Yang
     * mungkin membuatnya lebih cepat). Menggunakan parallelStream saat memesan
     * tidak masalah.
     */

    // Dampak kinerja

    /*
     * Jika melibatkan jaringan, Streams paralel dapat menurunkan kinerja aplikasi
     * secara keseluruhan karena semua Streams paralel menggunakan kumpulan thread
     * gabungan fork yang umum untuk jaringan.
     * 
     * Di sisi lain, Streams paralel dapat meningkatkan kinerja secara signifikan
     * dalam banyak kasus lainnya, bergantung pada
     * jumlah inti yang tersedia di CPU yang sedang berjalan saat ini.
     */

    public static void main(String[] args) {
        List<String> data = Arrays.asList("One", "Two", "Three", "Four", "Five");
        // Membuat parallel stream
        Stream<String> aParallelStream = data.stream().parallel();

        // Menampilkan elemen-elemen parallel stream
        System.out.println("Parallel Stream Elements:");
        aParallelStream.forEach(System.out::println);

        /*
         * output:
         * Parallel Stream Elements:
         * Three
         * Four
         * Two
         * Five
         * One
         */
    }
}
