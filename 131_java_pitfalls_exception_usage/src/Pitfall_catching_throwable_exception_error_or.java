public class Pitfall_catching_throwable_exception_error_or {
    // Catching Throwable, Exception, Error or RuntimeException/ Menangkap
    // Throwable, Exception, Error, atau RuntimeException

    /*
     * Pola pikir umum bagi pemrogram Java yang tidak berpengalaman adalah bahwa
     * pengecualian adalah "a problem" atau "a burden"
     * dan cara terbaik untuk mengatasi hal ini adalah menangkap semuanya1 sesegera
     * mungkin. Ini mengarah ke kode seperti ini:
     * 
     * try {
     * InputStream is = new FileInputStream(fileName);
     * // process the input
     * } catch (Exception ex) {
     * System.out.println("Could not open file " + fileName);
     * }
     */

    /*
     * Kode di atas memiliki kelemahan yang signifikan. catch ini sebenarnya
     * akan menangkap lebih banyak pengecualian daripada yang diharapkan oleh
     * programmer. Misalkan nilai fileName adalah null, karena ada bug di tempat
     * lain dalam aplikasi. Ini akan menyebabkan konstruktor FileInputStream
     * menampilkan NullPointerException. Penangan akan menangkap ini, dan melaporkan
     * kepada pengguna:
     * Could not open file null
     */

    /*
     * yang tidak membantu dan membingungkan. Lebih buruk lagi, misalkan kode
     * "proses input" yang memunculkan pengecualian yang tidak terduga (dicentang
     * atau tidak dicentang!). Sekarang pengguna akan mendapatkan pesan menyesatkan
     * untuk masalah yang tidak terjadi saat membuka file, dan mungkin tidak terkait
     * dengan I/O sama sekali.
     * 
     * Akar masalahnya adalah pemrogram telah mengkodekan penangan untuk
     * Exception. Ini hampir selalu merupakan kesalahan:
     * 1. Catching Exceptionakan menangkap semua pengecualian yang dicentang, dan
     * juga sebagian besar pengecualian yang tidak dicentang.
     * 2. Catching RuntimeException akan menangkap sebagian besar pengecualian yang
     * tidak dicentang.
     * 3. Catching Error akan menangkap pengecualian yang tidak dicentang yang
     * menandakan kesalahan internal JVM. Kesalahan ini umumnya tidak dapat
     * dipulihkan dan tidak boleh ditangkap.
     * 4. Catching Throwable akan menangkap semua kemungkinan pengecualian.
     * 
     */

    /*
     * Masalah dengan menangkap sekumpulan pengecualian yang terlalu luas adalah
     * bahwa handler biasanya tidak dapat menangani semuanya dengan tepat. Dalam
     * kasus Exception dan sebagainya, sulit bagi pemrogram untuk memprediksi apa
     * yang bisa ditangkap; yaitu apa yang diharapkan.
     * 
     * Secara umum, solusi yang tepat adalah menangani pengecualian yang diberikan.
     * Misalnya, Anda dapat menangkapnya dan menanganinya di tempat:
     * 
     * try {
     * InputStream is = new FileInputStream(fileName);
     * // process the input
     * } catch (FileNotFoundException ex) {
     * System.out.println("Could not open file " + fileName);
     * }
     */

    // atau Anda dapat mendeklarasikannya sebagai thrown dengan metode
    // terlampir.

    /*
     * Ada sangat sedikit situasi di mana menangkap Exception adalah tepat.
     * Satu-satunya yang umum muncul adalah seperti ini:
     * 
     * public static void main(String[] args) {
     * try {
     * // do stuff
     * } catch (Exception ex) {
     * System.err.println("Unfortunately an error has occurred. " +
     * "Please report this to X Y Z");
     * // Write stacktrace to a log file.
     * System.exit(1);
     * }
     * }
     */

    /*
     * Di sini kami benar-benar ingin menangani semua pengecualian, jadi menangkap
     * Exception (atau bahkan Throwable) adalah benar.
     */

    // 1 - Juga dikenal sebagai Penanganan Pengecualian Pokemon

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -----------------------
        try {
            // do stuff that may cause an exception
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (Exception ex) {
            System.err.println("Unfortunately an error has occurred. " +
                    "Please report this to X Y Z");
            // Write stacktrace to a log file.
            System.exit(1);
        }

        /*
         * output:
         * Unfortunately an error has occurred. Please report this to X Y Z
         */
    }

    public static int divide(int dividend, int divisor) {
        return dividend / divisor;
    }
}
