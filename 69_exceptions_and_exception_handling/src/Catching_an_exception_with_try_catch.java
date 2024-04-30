public class Catching_an_exception_with_try_catch {
    // Catching an exception with try-catch /Menangkap pengecualian dengan try-catch

    /*
     * Pengecualian dapat ditangkap dan ditangani menggunakan pernyataan
     * try...catch. (Sebenarnya pernyataan try mengambil bentuk lain, seperti
     * dijelaskan dalam contoh lain tentang try...catch...finally dan
     * try-with-resources.)
     */

    // Try-catch with one catch block

    // Bentuk paling sederhana terlihat seperti ini:

    /*
     * try {
     * doSomething();
     * } catch (SomeException e) {
     * handle(e);
     * }
     * // next statement
     */

    // Perilaku try...catch sederhana adalah sebagai berikut:
    /*
     * 1. Pernyataan di blok try dieksekusi.
     * 2. Jika tidak ada pengecualian yang dilemparkan oleh pernyataan di blok try,
     * maka kendali diteruskan ke pernyataan berikutnya setelah try...catch
     * 3. Jika pengecualian dilemparkan ke dalam try block.
     * a. Objek pengecualian diuji untuk melihat apakah itu merupakan turunan dari
     * SomeException atau subtipe
     * b. Jika ya, maka blok catch akan menangkap pengecualian:
     * i. Variabel e terikat pada objek pengecualian
     * ii. Kode di dalam blok catch dieksekusi.
     * iii. Jika kode tersebut memunculkan pengecualian, maka pengecualian yang baru
     * dilempar akan diterapkan di tempat yang asli.
     * iv. Jika tidak, kontrol berpindah ke pernyataan berikutnya setelah
     * try...catch
     * c. Jika tidak, pengecualian asli akan terus menyebar.
     */

    // Try-catch dengan banyak tangkapan

    // Sebuah try...catch juga dapat memiliki beberapa blok catch. Misalnya:

    /*
     * try {
     * doSomething();
     * } catch (SomeException e) {
     * handleOneWay(e)
     * } catch (SomeOtherException e) {
     * handleAnotherWay(e);
     * }
     * // next statement
     * 
     */

    /*
     * Jika ada beberapa blok catch, blok tersebut dicoba satu per satu, dimulai
     * dengan blok tangkapan pertama, hingga ditemukan kecocokan untuk pengecualian.
     * Penangan terkait dieksekusi (seperti di atas), dan kemudian kontrol
     * diteruskan ke pernyataan berikutnya setelah pernyataan try...catch. Blok
     * catch setelah blok yang cocok selalu dilewati, bahkan jika kode
     * pengendali memunculkan pengecualian.
     */

    /*
     * Strategi pencocokan "dari atas ke bawah" mempunyai konsekuensi untuk
     * kasus-kasus di mana pengecualian dalam blok tangkapan tidak terputus-putus.
     * Misalnya:
     * 
     * try {
     * throw new RuntimeException("test");
     * } catch (Exception e) {
     * System.out.println("Exception");
     * } catch (RuntimeException e) {
     * System.out.println("RuntimeException");
     * }
     */

    /*
     * Cuplikan kode ini akan menampilkan "Exception" dan bukan "RuntimeException".
     * Karena RuntimeException adalah subtipe dari Exception, catch (yang
     * lebih umum) akan dicocokkan. catch
     * kedua (yang lebih spesifik) tidak akan pernah dieksekusi.
     * 
     * Pelajaran yang dapat diambil dari hal ini adalah bahwa blok catch yang
     * paling spesifik (dalam hal jenis pengecualian) harus muncul terlebih dahulu,
     * dan blok catch yang paling umum harus muncul terakhir. (Beberapa kompiler
     * Java akan memperingatkan Anda jika catch tidak pernah dapat dieksekusi,
     * namun ini bukan kesalahan kompilasi.)
     */

    // Multi-exception catch blocks/Blok tangkapan multi-pengecualian
    // Version ≥ Java SE 7

    /*
     * Dimulai dengan Java SE 7, satu blok catch dapat menangani daftar pengecualian
     * yang tidak terkait. Jenis pengecualian terdaftar,
     * dipisahkan dengan simbol batang vertikal (|). Misalnya:
     * 
     * try {
     * doSomething();
     * } catch (SomeException | SomeOtherException e) {
     * handleSomeException(e);
     * }
     */

    /*
     * Perilaku tangkapan multi-pengecualian adalah perluasan sederhana untuk kasus
     * pengecualian tunggal. Hasil catch cocok jika
     * pengecualian yang dilempar cocok (setidaknya) dengan salah satu pengecualian
     * yang terdaftar.
     * 
     * Ada beberapa kehalusan tambahan dalam spesifikasinya. Tipe e adalah gabungan
     * sintetik dari tipe pengecualian di
     * daftar. Ketika nilai e digunakan, tipe statisnya adalah supertipe yang paling
     * tidak umum dari gabungan tipe. Namun, jika e adalah
     * dilempar kembali ke dalam blok catch, tipe pengecualian yang dilempar adalah
     * tipe di gabungan. Misalnya:
     * 
     * public void method() throws IOException, SQLException
     * try {
     * doSomething();
     * } catch (IOException | SQLException e) {
     * report(e);
     * throw e;
     * }
     */

    /*
     * Di atas, IOException dan SQLException dicentang pengecualian dengan supertipe
     * yang paling tidak umum adalah Pengecualian.
     * Artinya metode laporan harus cocok dengan laporan (Exception). Namun,
     * kompiler mengetahui bahwa lemparan tersebut
     * hanya dapat menampilkan IOException atau SQLException. Dengan demikian,
     * metode dapat dideklarasikan sebagai throws IOException,
     * SQLException daripada throws Exception. (Yang merupakan hal yang baik:
     * lihat Jebakan - Melempar Dapat Dilempar, Pengecualian,
     * Kesalahan atau RuntimeException.)
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // ---------------------------
        try {
            throw new RuntimeException("test");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        /*
         * output:
         * RuntimeException: test
         */

    }
}
