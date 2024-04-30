import java.util.stream.IntStream;

public class Using_streams_to_implement_mathematical_functions {

    // Using Streams to Implement Mathematical Functions / Menggunakan Aliran untuk
    // Mengimplementasikan Fungsi Matematika

    /*
     * Stream, dan khususnya IntStream, adalah cara elegan dalam mengimplementasikan
     * istilah penjumlahan (∑). Kisaran dari Aliran dapat digunakan sebagai batas
     * penjumlahan.
     * 
     * Misalnya, pendekatan Madhava terhadap Pi diberikan oleh rumus (Sumber:
     * wikipedia):
     */

    // Ini dapat dihitung dengan presisi yang berubah-ubah. Misalnya, untuk 101
    // istilah:

    public static void main(String[] args) {
        double pi = Math.sqrt(12) *
                IntStream.rangeClosed(0, 100)
                        .mapToDouble(k -> Math.pow(-3, -1 * k) / (2 * k + 1))
                        .sum();
        System.out.println("Approximation of Pi: " + pi);
        /*
         * output:
         * Approximation of Pi: 3.141592653589793
         */

        /*
         * Catatan: Dengan presisi ganda, memilih batas atas 29 sudah cukup untuk
         * mendapatkan hasil yang tidak dapat dibedakan
         * dari Math.Pi.
         */
    }
}
