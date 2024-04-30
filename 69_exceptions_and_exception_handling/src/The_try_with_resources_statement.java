import java.io.*;

public class The_try_with_resources_statement {
    // The try-with-resources statement/Pernyataan try-with-sumber daya

    /*
     * Seperti yang diilustrasikan oleh contoh pernyataan try-catch-final,
     * pembersihan sumber daya menggunakan klausa final memerlukan sejumlah besar
     * kode "boiler-plate" untuk mengimplementasikan kasus tepi dengan benar. Java 7
     * menyediakan cara yang lebih sederhana untuk mengatasi masalah ini dalam
     * bentuk pernyataan try-with-resources.
     */

    // What is a resource?

    /*
     * Java 7 memperkenalkan antarmuka java.lang.AutoCloseable untuk memungkinkan
     * kelas dikelola menggunakan pernyataan try-with-resources. Contoh kelas yang
     * mengimplementasikan AutoCloseable disebut sebagai sumber daya. Sampah-sampah
     * ini biasanya harus dibuang tepat pada waktunya dibandingkan bergantung pada
     * pemulung untuk membuangnya.
     */

    /*
     * Antarmuka AutoCloseable mendefinisikan satu metode:
     * public void close() throws Exception
     */

    /*
     * Metode close() harus membuang sumber daya dengan cara yang tepat. Spesifikasi
     * menyatakan bahwa memanggil metode pada sumber daya yang telah dibuang harus
     * aman. Selain itu, kelas yang mengimplementasikan
     * Autocloseable sangat dianjurkan untuk mendeklarasikan metode close() untuk
     * memunculkan pengecualian yang lebih spesifik daripada Exception, atau tanpa
     * pengecualian sama sekali.
     */

    /*
     * Berbagai kelas dan antarmuka Java standar mengimplementasikan AutoCloseable.
     * Ini termasuk:
     * 1. InputStream, OutputStream and their subclasses
     * 2. Reader, Writer and their subclasses
     * 3. Socket and ServerSocket and their subclasses
     * 4. Channel and its subclasses, and
     * 5. the JDBC interfaces Connection, Statement and ResultSet and their
     * subclasses.
     */

    // Aplikasi dan kelas pihak ketiga juga dapat melakukan hal ini.

    // Pernyataan dasar try-with-resource

    /*
     * Sintaks dari try-with-resources didasarkan pada bentuk try-catch, try-finally
     * dan try-catch-finally klasik. Berikut adalah contoh bentuk “dasar”; yaitu
     * bentuk tanpa catch atau finally.
     * 
     * try (PrintStream stream = new PrintStream("hello.txt")) {
     * stream.println("Hello world!");
     * }
     */

    /*
     * Sumber daya yang akan dikelola dideklarasikan sebagai variabel di bagian
     * (...) setelah klausa try. Dalam contoh di atas, kami mendeklarasikan aliran
     * variabel sumber daya dan menginisialisasinya ke PrintStream yang baru dibuat.
     * 
     * Setelah variabel sumber daya diinisialisasi, blok try dijalankan. Ketika itu
     * selesai, streaming.close() akan dipanggil secara otomatis untuk memastikan
     * bahwa sumber daya tidak bocor. Perhatikan bahwa panggilan close() terjadi
     * tidak peduli bagaimana blok selesai.
     */

    // Pernyataan try-with-resource yang ditingkatkan

    /*
     * Pernyataan try-with-resources dapat ditingkatkan dengan blok catch dan
     * finally, seperti sintaks try-catchfinally sebelum Java 7. Cuplikan kode
     * berikut menambahkan blok catch ke blok sebelumnya untuk menangani
     * FileNotFoundException yang dapat dilempar oleh konstruktor PrintStream:
     */

    /*
     * try (PrintStream stream = new PrintStream("hello.txt")) {
     * stream.println("Hello world!");
     * } catch (FileNotFoundException ex) {
     * System.err.println("Cannot open the file");
     * } finally {
     * System.err.println("All done");
     * }
     */

    /*
     * Jika inisialisasi sumber daya atau blok coba memunculkan pengecualian, maka
     * blok catch akan dieksekusi. Blok finally akan selalu dieksekusi, seperti
     * pernyataan try-catch-finally konvensional.
     * 
     * Namun ada beberapa hal yang perlu diperhatikan:
     * 1. Variabel sumber daya berada di luar cakupan catch dan finally
     * diblokir.
     * 2. Pembersihan sumber daya akan terjadi sebelum pernyataan mencoba
     * mencocokkan blok catch.
     * 3. Jika pembersihan sumber daya otomatis memunculkan pengecualian, maka
     * pengecualian tersebut dapat ditangkap di salah satu blok catch
     */

    // Managing multiple resources/Mengelola banyak sumber daya

    /*
     * Cuplikan kode di atas menunjukkan satu sumber daya yang dikelola. Faktanya,
     * percobaan dengan sumber daya dapat mengelola banyak sumber daya
     * sumber daya dalam satu pernyataan. Misalnya:
     * 
     * try (InputStream is = new FileInputStream(file1);
     * OutputStream os = new FileOutputStream(file2)) {
     * // Copy 'is' to 'os'
     * }
     */

    /*
     * Ini berperilaku seperti yang Anda harapkan. Is dan os ditutup secara otomatis
     * pada akhir blok try. Ada beberapa hal yang perlu diperhatikan:
     * 1. Inisialisasi terjadi dalam urutan kode, dan penginisialisasi variabel
     * sumber daya selanjutnya dapat menggunakan nilai yang sebelumnya.
     * 2. Semua variabel sumber daya yang berhasil diinisialisasi akan dibersihkan.
     * 3. Variabel sumber daya dibersihkan dalam urutan terbalik(reverse order) dari
     * deklarasinya.
     */

    /*
     * Jadi, dalam contoh di atas, is diinisialisasi sebelum os dan dibersihkan
     * setelahnya, dan is akan dibersihkan jika ada pengecualian saat
     * menginisialisasi os.
     */

    // Kesetaraan try-with-resource dan try-catch-finally klasik

    /*
     * Spesifikasi Bahasa Java menentukan perilaku formulir try-with-resource
     * dalam kaitannya dengan pernyataan try-catchfinally klasik. (Silakan
     * merujuk ke JLS untuk detail selengkapnya.)
     */

    /*
     * Misalnya, try-with-resource dasar ini :
     * try (PrintStream stream = new PrintStream("hello.txt")) {
     * stream.println("Hello world!");
     * }
     */

    // didefinisikan setara dengan try-catch-finally ini:
    /*
     * // Note that the constructor is not part of the try-catch statement
     * PrintStream stream = new PrintStream("hello.txt");
     * // This variable is used to keep track of the primary exception thrown
     * // in the try statement. If an exception is thrown in the try block,
     * // any exception thrown by AutoCloseable.close() will be suppressed.
     * Throwable primaryException = null;
     * // The actual try block
     * try {
     * stream.println("Hello world!");
     * } catch (Throwable t) {
     * // If an exception is thrown, remember it for the finally block
     * primaryException = t;
     * throw t;
     * } finally {
     * if (primaryException == null) {
     * // If no exception was thrown so far, exceptions thrown in close() will
     * // not be caught and therefore be passed on to the enclosing code.
     * stream.close();
     * } else {
     * // If an exception has already been thrown, any exception thrown in
     * // close() will be suppressed as it is likely to be related to the
     * // previous exception. The suppressed exception can be retrieved
     * // using primaryException.getSuppressed().
     * try {
     * stream.close();
     * } catch (Throwable suppressedException) {
     * primaryException.addSuppressed(suppressedException);
     * }
     * }
     * }
     */

    /*
     * (JLS menetapkan bahwa variabel t dan primaryException yang sebenarnya tidak
     * akan terlihat oleh kode Java normal.)
     * 
     * Bentuk try-with-resources yang disempurnakan ditentukan sebagai
     * kesetaraan dengan bentuk dasar. Misalnya:
     * try (PrintStream stream = new PrintStream(fileName)) {
     * stream.println("Hello world!");
     * } catch (NullPointerException ex) {
     * System.err.println("Null filename");
     * } finally {
     * System.err.println("All done");
     * }
     */

    /*
     * setara dengan:
     * try {
     * try (PrintStream stream = new PrintStream(fileName)) {
     * stream.println("Hello world!");
     * }
     * } catch (NullPointerException ex) {
     * System.err.println("Null filename");
     * } finally {
     * System.err.println("All done");
     * }
     */

    public static void main(String[] args) {
        String filePath = "output.txt";

        // try (PrintStream stream = new PrintStream(filePath)) {
        // // Menulis teks ke dalam file
        // stream.println("Hello world!");
        // System.out.println("Teks berhasil ditulis ke dalam file " + filePath);
        // } catch (IOException e) {
        // System.err.println("Terjadi kesalahan saat menulis ke dalam file: " +
        // e.getMessage());
        // }

        // --------------
        try (PrintStream stream = new PrintStream(filePath)) {
            stream.println("Hello world!");
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex.getMessage());
        } finally {
            System.err.println("All done");
        }
    }
}
