import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Consuming_streams {
    // Consuming Streams / Mengkonsumsi Aliran

    /*
     * Stream hanya akan dilalui ketika ada operasi terminal, seperti
     * count(),collect(), atau forEach(). Jika tidak,
     * tidak ada operasi pada Stream yang akan dilakukan.
     * 
     * Dalam contoh berikut, tidak ada operasi terminal yang ditambahkan ke Stream,
     * sehingga operasi filter() tidak akan ditambahkan
     * dipanggil dan tidak ada keluaran yang dihasilkan karena peek() BUKAN operasi
     * terminal.
     * IntStream.range(1, 10).filter(a -> a % 2 == 0).peek(System.out::println);
     * 
     */

    // https://ideone.com/YDijRj

    /*
     * Ini adalah urutan Stream dengan operasi terminal yang valid, sehingga
     * keluaran dihasilkan.
     * Anda juga bisa menggunakan forEach alih-alih mengintip:
     * IntStream.range(1, 10).filter(a -> a % 2 == 0).forEach(System.out::println);
     * 
     */

    // https://ideone.com/LzUoM6
    /*
     * Output:
     * 2
     * 4
     * 6
     * 8
     */

    /*
     * Setelah operasi terminal dilakukan, Stream dikonsumsi dan tidak dapat
     * digunakan kembali.
     * 
     * Meskipun objek aliran tertentu tidak dapat digunakan kembali, mudah untuk
     * membuat Iterable yang dapat digunakan kembali yang didelegasikan ke aliran
     * saluran pipa. Hal ini berguna untuk mengembalikan tampilan kumpulan data
     * langsung yang dimodifikasi tanpa harus mengumpulkan hasil ke dalam struktur
     * sementara.
     * 
     * List<String> list = Arrays.asList("FOO", "BAR");
     * Iterable<String> iterable = () ->
     * list.stream().map(String::toLowerCase).iterator();
     * for (String str : iterable) {
     * System.out.println(str);
     * }
     * for (String str : iterable) {
     * System.out.println(str);
     * }
     * 
     * Keluaran:
     * foo
     * bar
     * foo
     * bar
     */

    /*
     * Ini berfungsi karena Iterable mendeklarasikan metode abstrak tunggal
     * Iterator<T> iterator(). Itu membuatnya efektif
     * antarmuka fungsional, diimplementasikan oleh lambda yang membuat aliran baru
     * pada setiap panggilan.
     * 
     * Secara umum, Stream beroperasi seperti yang ditunjukkan pada gambar berikut:
     */

    // CATATAN: Pemeriksaan argumen selalu dilakukan, bahkan tanpa operasi terminal:
    /*
     * try {
     * IntStream.range(1, 10).filter(null);
     * } catch (NullPointerException e) {
     * System.out.println("We got a NullPointerException as null was passed as an
     * argument to
     * filter()");
     * }
     */

    // https://ideone.com/zrkoRz

    /*
     * Keluaran:
     * Kami mendapat NullPointerException karena null diteruskan sebagai argumen ke
     * filter()
     */

    public static void main(String[] args) {
        // IntStream.range(1, 10).filter(a -> a % 2 == 0).peek(System.out::println);

        // IntStream.range(1, 10).filter(a -> a % 2 == 0).forEach(System.out::println);
        /*
         * output:
         * 2
         * 4
         * 6
         * 8
         */

        // ------------------------
        List<String> list = Arrays.asList("FOO", "BAR");
        Iterable<String> iterable = () -> list.stream().map(String::toLowerCase).iterator();
        for (String str : iterable) {
            System.out.println(str);
        }
        for (String str : iterable) {
            System.out.println(str);
        }

        /*
         * output:
         * foo
         * bar
         * foo
         * bar
         */

    }
}
