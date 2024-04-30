import java.util.stream.IntStream;

public class Streams_of_primitives {
    // Streams of Primitives / Aliran Primitif

    /*
     * Java menyediakan Aliran khusus untuk tiga jenis primitif IntStream (untuk
     * int), LongStream (untuk long) dan
     * DoubleStream (untuk ganda). Selain implementasi yang dioptimalkan untuk
     * masing-masing primitif, mereka juga menyediakan beberapa metode terminal
     * spesifik, biasanya untuk operasi matematika. Misalnya.:
     */
    public static void main(String[] args) {
        IntStream is = IntStream.of(10, 20, 30);
        double average = is.average().getAsDouble(); // average is 20.0

        // Menampilkan hasil rata-rata
        System.out.println("Average is: " + average);
        /*
         * output:
         * Average is: 20.0
         */

    }
}
