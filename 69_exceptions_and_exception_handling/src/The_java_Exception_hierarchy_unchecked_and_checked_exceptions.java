import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class The_java_Exception_hierarchy_unchecked_and_checked_exceptions {
    // The Java Exception Hierarchy - Unchecked and Checked Exceptions/Hirarki
    // Pengecualian Java - Pengecualian Tidak Dicentang dan Dicentang

    /*
     * Semua pengecualian Java adalah turunan kelas dalam hierarki kelas
     * Pengecualian. Hal ini dapat direpresentasikan sebagai berikut:
     * 1. java.lang.Throwable - Ini adalah kelas dasar untuk semua kelas
     * pengecualian. Metode dan konstruktornya mengimplementasikan serangkaian
     * fungsi yang umum untuk semua pengecualian.
     * a. java.lang.Exception - Ini adalah superkelas dari semua pengecualian
     * normal.
     * 1a. berbagai kelas pengecualian standar dan khusus.
     * java.lang.RuntimeException - Ini superkelas dari semua pengecualian normal
     * yang merupakan pengecualian yang tidak dicentang.
     * berbagai kelas pengecualian runtime standar dan khusus
     * 
     * java.lang.Error - Ini adalah superkelas dari semua pengecualian
     * "kesalahan fatal".
     * 
     */

    /*
     * Catatan:
     * 1. Perbedaan antara pengecualian yang dicentang dan tidak dicentang
     * dijelaskan di bawah.
     * 2. Kelas Throwable, Exception dan RuntimeException harus diperlakukan sebagai
     * abstract; lihat Jebakan - Melempar
     * Dapat Dibuang, Pengecualian, Kesalahan, atau RuntimeException.
     * 3. Pengecualian Error diberikan oleh JVM dalam situasi yang tidak aman atau
     * tidak bijaksana untuk suatu
     * aplikasi untuk mencoba memulihkan.
     * 4. Tidaklah bijaksana untuk mendeklarasikan subtipe khusus dari Throwable.
     * Alat dan perpustakaan Java mungkin berasumsi bahwa Error dan Exception adalah
     * satu-satunya subtipe langsung dari Throwable, dan berperilaku buruk jika
     * asumsi tersebut salah.
     */

    // Pengecualian yang Dicentang versus Tidak Dicentang
    /*
     * Salah satu kritik terhadap dukungan pengecualian dalam beberapa bahasa
     * pemrograman adalah sulitnya mengetahui yang mana
     * pengecualian yang mungkin diberikan oleh metode atau prosedur tertentu.
     * Mengingat bahwa pengecualian yang tidak ditangani dapat menyebabkan program
     * mogok, hal ini dapat menjadikan pengecualian sebagai sumber kerapuhan.
     * 
     * Bahasa Java mengatasi masalah ini dengan mekanisme pengecualian yang
     * dicentang. Pertama, Java mengklasifikasikan pengecualian menjadi dua
     * kategori:
     * 1. Pengecualian yang dicentang biasanya mewakili kejadian yang diantisipasi
     * yang
     * seharusnya dapat ditangani oleh aplikasi. Misalnya, IOException dan
     * subtipenya mewakili kondisi kesalahan yang dapat terjadi dalam operasi I/O.
     * Contohnya, pembukaan file gagal karena file atau direktori tidak ada,
     * pembacaan dan penulisan jaringan gagal karena koneksi jaringan telah terputus
     * dan sebagainya.
     * 
     * 2. Pengecualian yang tidak dicentang biasanya mewakili kejadian tak terduga
     * yang tidak dapat ditangani oleh aplikasi. Ini biasanya disebabkan oleh bug
     * pada aplikasi.
     */

    /*
     * (Berikut ini, "thrown" mengacu pada pengecualian apa pun yang dilemparkan
     * secara eksplisit (dengan pernyataan throw), atau secara implisit (dalam
     * dereferensi yang gagal, ketik cast, dan sebagainya). Demikian pula,
     * "propagated" mengacu pada pengecualian yang dilemparkan ke dalam a panggilan
     * bersarang, dan tidak terjebak dalam panggilan itu. Contoh kode di bawah akan
     * menggambarkan hal ini.)
     * 
     * Bagian kedua dari mekanisme pengecualian yang dicentang adalah adanya batasan
     * pada metode di mana pengecualian yang dicentang dapat terjadi:
     * 1. Ketika pengecualian yang dicentang dilemparkan atau disebarkan dalam suatu
     * metode, pengecualian tersebut harus ditangkap oleh metode tersebut, atau
     * tercantum dalam klausa throws metode. (Pentingnya klausa throws dijelaskan
     * dalam contoh ini.)
     * 
     * 2. Ketika pengecualian yang dicentang dilemparkan atau disebarkan dalam blok
     * penginisialisasi, blok tersebut harus ditangkap.
     * 
     * 3. Pengecualian yang dicentang tidak dapat disebarkan dengan pemanggilan
     * metode dalam ekspresi inisialisasi bidang. (Tidak ada cara untuk menangkap
     * pengecualian seperti itu.)
     */

    /*
     * Singkatnya, pengecualian yang dicentang harus ditangani atau dideklarasikan.
     * 
     * Pembatasan ini tidak berlaku untuk pengecualian yang tidak dicentang. Ini
     * mencakup semua kasus di mana pengecualian diberikan secara implisit, karena
     * semua kasus tersebut memunculkan pengecualian yang tidak dicentang.
     */

    /*
     * Checked exception examples/Contoh pengecualian yang diperiksa
     * 
     * Cuplikan kode ini dimaksudkan untuk mengilustrasikan pembatasan pengecualian
     * yang dicentang. Dalam setiap kasus, kami menampilkan versi kode dengan
     * kesalahan kompilasi, dan versi kedua dengan kesalahan yang diperbaiki.
     */

    /*
     * // This declares a custom checked exception.
     * public class MyException extends Exception {
     * // constructors omitted.
     * }
     * // This declares a custom unchecked exception.
     * public class MyException2 extends RuntimeException {
     * // constructors omitted.
     * }
     */

    /*
     * Contoh pertama menunjukkan bagaimana pengecualian yang dicentang secara
     * eksplisit dapat dinyatakan sebagai "thrown" jika pengecualian tersebut
     * tidak ditangani dalam metode.
     */

    /*
     * // INCORRECT
     * public void methodThrowingCheckedException(boolean flag) {
     * int i = 1 / 0; // Compiles OK, throws ArithmeticException
     * if (flag) {
     * throw new MyException(); // Compilation error
     * } else {
     * throw new MyException2(); // Compiles OK
     * }
     * }
     * // CORRECTED
     * public void methodThrowingCheckedException(boolean flag) throws MyException {
     * int i = 1 / 0; // Compiles OK, throws ArithmeticException
     * if (flag) {
     * throw new MyException(); // Compilation error
     * } else {
     * throw new MyException2(); // Compiles OK
     * }
     * }
     */

    /*
     * Contoh kedua menunjukkan bagaimana pengecualian yang dicentang dapat
     * ditangani.
     */

    /*
     * // INCORRECT
     * public void methodWithPropagatedCheckedException() {
     * InputStream is = new FileInputStream("someFile.txt"); // Compilation error
     * // FileInputStream throws IOException or a subclass if the file cannot
     * // be opened. IOException is a checked exception.
     * ...
     * }
     * // CORRECTED (Version A)
     * public void methodWithPropagatedCheckedException() throws IOException {
     * InputStream is = new FileInputStream("someFile.txt");
     * ...
     * }
     * // CORRECTED (Version B)
     * public void methodWithPropagatedCheckedException() {
     * try {
     * InputStream is = new FileInputStream("someFile.txt");
     * ...
     * } catch (IOException ex) {
     * System.out.println("Cannot open file: " + ex.getMessage());
     * }
     * }
     * 
     */

    // Contoh terakhir menunjukkan cara menangani pengecualian yang dicentang di
    // penginisialisasi bidang statis.

    /*
     * // INCORRECT
     * public class Test {
     * private static final InputStream is =
     * new FileInputStream("someFile.txt"); // Compilation error
     * }
     * // CORRECTED
     * public class Test {
     * private static final InputStream is;
     * static {
     * InputStream tmp = null;
     * try {
     * tmp = new FileInputStream("someFile.txt");
     * } catch (IOException ex) {
     * System.out.println("Cannot open file: " + ex.getMessage());
     * }
     * is = tmp;
     * }
     * }
     */

    /*
     * Perhatikan bahwa dalam kasus terakhir ini, kita juga harus menangani masalah
     * yang tidak dapat ditugaskan lebih dari satu kali, namun juga harus
     * ditugaskan, bahkan dalam kasus pengecualian.
     */

    private static final InputStream is;

    static {
        InputStream tmp = null;
        try {
            tmp = new FileInputStream("someFile.txt");
        } catch (IOException ex) {
            System.out.println("Cannot open file: " + ex.getMessage());
        }
        is = tmp;
    }

    public static void main(String[] args) {

        // ------------------
        // Kode untuk memanfaatkan InputStream dapat ditambahkan di sini
        // Misalnya, membaca data dari is
        // Contoh:
        try {
            int data = is.read();
            System.out.println("Data: " + data);
        } catch (IOException ex) {
            System.out.println("Error reading from the file: " + ex.getMessage());
        }

        /*
         * output:
         * Data: 117
         */

    }

}
