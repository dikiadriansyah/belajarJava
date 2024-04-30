import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Pitfall_throwing_throwable_exception_error_or_exception {
    // Pitfall - Throwing Throwable, Exception, Error or RuntimeException/Kesalahan
    // - Melempar, Pengecualian, Kesalahan, atau RuntimeException

    /*
     * Meskipun menangkap pengecualian Throwable, Exception, Error, dan
     * RuntimeException itu buruk, membuangnya adalah hal yang genap
     * lebih buruk.
     * 
     * Masalah mendasarnya adalah ketika aplikasi Anda perlu menangani pengecualian,
     * keberadaan pengecualian tingkat atas membuat sulit untuk membedakan kondisi
     * kesalahan yang berbeda. Misalnya
     * 
     * try {
     * InputStream is = new FileInputStream(someFile); // could throw IOException
     * ...
     * if (somethingBad) {
     * throw new Exception(); // WRONG
     * }
     * } catch (IOException ex) {
     * System.err.println("cannot open ...");
     * } catch (Exception ex) {
     * System.err.println("something bad happened"); // WRONG
     * }
     * 
     */

    /*
     * Masalahnya adalah karena kita melemparkan sebuah instance Exception, kita
     * terpaksa menangkapnya. Namun seperti yang dijelaskan dalam contoh lain,
     * menangkap Exception itu buruk. Dalam situasi ini, menjadi sulit untuk
     * membeda-bedakan
     * Kasus "expected" dari Pengecualian yang muncul jika somethingBad
     * true, dan kasus tak terduga di mana kita benar-benar menangkap pengecualian
     * yang tidak dicentang seperti NullPointerException.
     */

    /*
     * Jika pengecualian tingkat atas dibiarkan menyebar, kita akan mengalami
     * masalah lain:
     * 1. Sekarang kita harus mengingat semua alasan berbeda yang kita berikan pada
     * tingkat atas, dan membedakan/menanganinya.
     * 2. Dalam kasus Exception dan Throwable kita juga perlu menambahkan
     * pengecualian ini ke klausa metode throws jika kita ingin pengecualian
     * tersebut disebarkan. Ini bermasalah, seperti dijelaskan di bawah
     */

    /*
     * Singkatnya, jangan membuang pengecualian ini. Berikan pengecualian yang lebih
     * spesifik yang menjelaskan lebih dekat
     * "exceptional event" yang telah terjadi. Jika perlu, tentukan dan gunakan
     * kelas pengecualian khusus.
     */

    // Declaring Throwable or Exception in a method's "throws" is
    // problematic./Mendeklarasikan Throwable atau Exception dalam "throws" suatu
    // metode adalah masalah.

    /*
     * Sangat menggoda untuk mengganti daftar panjang pengecualian yang dilempar
     * dalam klausa throws suatu metode dengan Exception atau bahkan
     * `Throwable. Ini adalah ide yang buruk:
     * 1. Ini memaksa pemanggil untuk menangani (atau menyebarkan) Exception.
     * 2. Kami tidak dapat lagi mengandalkan kompiler untuk memberi tahu kami
     * tentang pengecualian spesifik yang perlu ditangani
     * 3. Menangani Exception dengan benar itu sulit. Sulit untuk mengetahui
     * pengecualian apa yang mungkin terjadi, dan jika Anda tidak mengetahui apa
     * saja yang mungkin terjadi, maka sulit untuk mengetahui strategi pemulihan apa
     * yang tepat.
     * 4. Menangani Throwable bahkan lebih sulit lagi, karena kini Anda juga harus
     * menghadapi potensi kegagalan yang tidak dapat dipulihkan lagi.
     */

    // Nasihat ini berarti bahwa pola-pola tertentu lainnya harus dihindari.
    // Misalnya:
    /*
     * try {
     * doSomething();
     * } catch (Exception ex) {
     * report(ex);
     * throw ex;
     * }
     */

    /*
     * Upaya di atas untuk mencatat semua pengecualian saat melewatinya, tanpa
     * menanganinya secara pasti. Sayangnya, sebelum Java 7, throw ex; pernyataan
     * menyebabkan kompiler berpikir bahwa Exception apa pun dapat dilempar. Itu
     * bisa memaksa Anda untuk mendeklarasikan metode penutup sebagai throws
     * Exception. Mulai Java 7 dan seterusnya, kompiler mengetahui bahwa kumpulan
     * pengecualian yang dapat (dilemparkan kembali) ke sana lebih kecil
     */

    public static void main(String[] args) throws Exception {
        // try {
        // InputStream is = new FileInputStream("someFile"); // could throw IOException
        // //...
        // if (somethingBad) {
        // throw new Exception(); // WRONG
        // }
        // } catch (IOException ex) {
        // System.err.println("cannot open ...");
        // } catch (Exception ex) {
        // System.err.println("something bad happened"); // WRONG
        // }
        // --------------------
        try {
            doSomething();
        } catch (Exception ex) {
            report(ex);
            throw ex;
        }
        /*
         * output:
         * Terjadi pengecualian: Contoh pengecualian dari doSomething()
         */
    }

    public static void doSomething() throws Exception {
        // Implementasi fungsi doSomething() di sini
        // Misalnya:
        throw new Exception("Contoh pengecualian dari doSomething()");
    }

    public static void report(Exception ex) {
        // Implementasi pelaporan di sini
        // Misalnya:
        System.out.println("Terjadi pengecualian: " + ex.getMessage());
    }

}
