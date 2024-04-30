import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Logger;

public class The_try_finally_and_try_catch_finally_statements {
    // The try-finally and try-catch-finally statements/Pernyataan coba-akhirnya dan
    // coba-tangkap-akhirnya

    /*
     * Pernyataan try...catch...finally menggabungkan penanganan pengecualian dengan
     * kode pembersihan. Blok finally berisi kode yang akan dieksekusi dalam segala
     * keadaan. Hal ini membuat mereka cocok untuk pengelolaan sumber daya, dan
     * jenis pembersihan lainnya.
     */

    // Try-finally
    /*
     * Berikut adalah contoh bentuk (try...finally) yang lebih sederhana:
     * try {
     * doSomething();
     * } finally {
     * cleanUp();
     * }
     */

    // Perilaku try...finally adalah sebagai berikut:
    /*
     * 1. Kode di blok try dieksekusi.
     * 2. Jika tidak ada pengecualian yang dilemparkan ke blok try:
     * a. Kode di blok finally dieksekusi.
     * b. Jika blok finally memunculkan pengecualian, pengecualian itu akan
     * disebarkan.
     * c. Jika tidak, kontrol berpindah ke pernyataan berikutnya setelah
     * try...finally
     * 3. Jika pengecualian diberikan pada blok try:
     * a. Kode di blok finally dieksekusi.
     * b. Jika blok finally memunculkan pengecualian, pengecualian itu akan
     * disebarkan
     * c. Jika tidak, pengecualian asli akan terus menyebar.
     */

    /*
     * Kode di dalam blok finally akan selalu dieksekusi. (Satu-satunya
     * pengecualian adalah jika System.exit(int) dipanggil, atau jika JVM panik.)
     * Jadi blok finally adalah kode tempat yang benar yang harus selalu
     * dieksekusi; misalnya menutup file dan sumber daya lainnya atau melepaskan
     * kunci.
     * 
     */

    // try-catch-finally

    /*
     * Contoh kedua kami menunjukkan bagaimana catch dan finally dapat digunakan
     * bersama-sama. Hal ini juga menggambarkan bahwa membersihkan sumber daya
     * tidaklah mudah.
     */

    /*
     * // This code snippet writes the first line of a file to a string
     * String result = null;
     * Reader reader = null;
     * try {
     * reader = new BufferedReader(new FileReader(fileName));
     * result = reader.readLine();
     * } catch (IOException ex) {
     * Logger.getLogger.warn("Unexpected IO error", ex); // logging the exception
     * } finally {
     * if (reader != null) {
     * try {
     * reader.close();
     * } catch (IOException ex) {
     * // ignore / discard this exception
     * }
     * }
     * }
     */

    /*
     * Kumpulan lengkap perilaku (hipotetis) try...catch...finally dalam contoh ini
     * terlalu rumit untuk dijelaskan di sini. Versi sederhananya adalah kode di
     * blok finally akan selalu dieksekusi.
     * 
     * Melihat hal ini dari perspektif pengelolaan sumber daya:
     * 1. Kami mendeklarasikan "sumber daya" (yaitu variabel pembaca) sebelum blok
     * try sehingga akan berada dalam cakupan blok finally.
     * 
     * 2. Dengan meletakkan new FileReader(...) , catch mampu menangani
     * pengecualian IOError apa pun yang dilempar saat membuka file.
     * 
     * 3. Kita memerlukan reader.close() di blok finally karena ada beberapa jalur
     * pengecualian yang tidak dapat kita intersepsi baik di blok try atau di blok
     * catch.
     * 
     * 4. Namun, karena pengecualian mungkin telah diberikan sebelum pembaca
     * diinisialisasi, kita juga memerlukan pengujian null yang eksplisit.
     * 
     * 5. Terakhir, panggilan reader.close() mungkin (secara hipotetis) memunculkan
     * pengecualian. Kami tidak peduli tentang hal itu, tetapi jika kami tidak
     * menangkap pengecualian di sumbernya, kami perlu menanganinya lebih jauh di
     * tumpukan panggilan.
     */

    // Version ≥ Java SE 7
    /*
     * Java 7 dan yang lebih baru menyediakan sintaks try-with-resources
     * alternatif yang secara signifikan menyederhanakan pembersihan sumber daya.
     */

    private static final Logger logger = Logger
            .getLogger(The_try_finally_and_try_catch_finally_statements.class.getName());

    public static void main(String[] args) {
        String fileName = "someFile.txt";
        String result = null;
        Reader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            result = ((BufferedReader) reader).readLine();
        } catch (IOException ex) {
            logger.warning("Unexpected IO error: " + ex.getMessage()); // logging the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    // ignore / discard this exception
                }
            }
        }

        // You can use 'result' here or perform other operations
        System.out.println("Result: " + result);

        /*
         * output:
         * Result: uji coba file
         */

    }
}
