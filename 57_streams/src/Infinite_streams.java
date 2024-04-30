import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Infinite_streams {

    // Infinite Streams / Aliran Tak Terbatas

    /*
     * Dimungkinkan untuk menghasilkan Aliran yang tidak berakhir. Memanggil metode
     * terminal pada Aliran tak terbatas menyebabkan Streaming untuk memasuki loop
     * tak terbatas. Metode limit Aliran dapat digunakan untuk membatasi jumlah suku
     * Streaming proses Java itu.
     * 
     * Contoh ini menghasilkan Stream semua bilangan asli, dimulai dengan bilangan
     * 1. Setiap suku yang berurutan dari
     * Alirannya lebih tinggi dari sebelumnya. Dengan memanggil metode limit Aliran
     * ini, hanya lima suku pertama saja Stream dipertimbangkan dan dicetak.
     */

    public static void main(String[] args) {
        // Generate infinite stream - 1, 2, 3, 4, 5, 6, 7, ...
        // IntStream naturalNumbers = IntStream.iterate(1, x -> x + 1);
        // Print out only the first 5 terms
        // naturalNumbers.limit(5).forEach(System.out::println);
        /*
         * output:
         * 1
         * 2
         * 3
         * 4
         * 5
         */

        /*
         * Cara lain untuk menghasilkan aliran tak terbatas adalah dengan menggunakan
         * metode Stream.generate. Metode ini mengambil lambda bertipe Pemasok.
         */
        // --------------------------------
        // Generate an infinite stream of random numbers
        Stream<Double> infiniteRandomNumbers = Stream.generate(Math::random);

        // Print out only the first 10 random numbers
        infiniteRandomNumbers.limit(10).forEach(System.out::println);
        /*
         * output:
         * 0.26601415918087934
         * 0.15529696982383379
         * 0.40507756643937254
         * 0.7880973388849934
         * 0.14425765455954564
         * 0.09829123133754447
         * 0.8250879009703715
         * 0.22594486211837117
         * 0.18855145981468324
         * 0.6221325683647623
         */
    }
}
