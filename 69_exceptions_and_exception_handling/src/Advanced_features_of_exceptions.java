public class Advanced_features_of_exceptions {
    // Advanced features of Exceptions/Fitur lanjutan dari Pengecualian

    // Contoh ini mencakup beberapa fitur lanjutan dan kasus penggunaan untuk
    // Pengecualian.

    // Memeriksa callstack secara terprogram
    // Version ≥ Java SE 1.4

    /*
     * Kegunaan utama dari pelacakan tumpukan pengecualian adalah untuk memberikan
     * informasi tentang kesalahan aplikasi dan konteksnya sehingga pemrogram dapat
     * mendiagnosis dan memperbaiki masalah. Terkadang bisa digunakan untuk hal
     * lain. Misalnya, kelas SecurityManager mungkin perlu memeriksa tumpukan
     * panggilan untuk memutuskan apakah kode yang membuat panggilan dapat
     * dipercaya.
     */

    // Anda dapat menggunakan pengecualian untuk memeriksa tumpukan panggilan secara
    // terprogram sebagai berikut:
    /*
     * Exception ex = new Exception(); // this captures the call stack
     * StackTraceElement[] frames = ex.getStackTrace();
     * System.out.println("This method is " + frames[0].getMethodName());
     * System.out.println("Called from method " + frames[1].getMethodName());
     */

    // Ada beberapa peringatan penting mengenai hal ini:
    /*
     * 1. Informasi yang tersedia di StackTraceElement terbatas. Tidak ada informasi
     * lebih lanjut yang tersedia selain yang ditampilkan oleh printStackTrace.
     * (Nilai variabel lokal dalam frame tidak tersedia.)
     * 2. Javadocs untuk getStackTrace() menyatakan bahwa JVM diizinkan untuk
     * meninggalkan frame:
     * Beberapa mesin virtual mungkin, dalam kondisi tertentu, menghilangkan satu
     * atau lebih frame tumpukan dari pelacakan tumpukan. Dalam kasus ekstrim, mesin
     * virtual yang tidak memiliki informasi pelacakan tumpukan
     * throwable ini diizinkan untuk mengembalikan array dengan panjang nol dari
     * metode ini.
     */

    // Optimizing exception construction/Mengoptimalkan konstruksi pengecualian

    /*
     * Seperti disebutkan di tempat lain, membuat pengecualian agak mahal karena
     * memerlukan pengambilan dan pencatatan informasi tentang semua frame tumpukan
     * di thread saat ini. Terkadang, kita tahu bahwa informasi tersebut tidak akan
     * pernah digunakan untuk pengecualian tertentu; misalnya stacktrace tidak akan
     * pernah dicetak. Dalam hal ini, ada trik implementasi yang dapat kita gunakan
     * dalam pengecualian khusus yang menyebabkan informasi tidak ditangkap.
     * 
     * Informasi bingkai tumpukan yang diperlukan untuk pelacakan tumpukan,
     * ditangkap ketika konstruktor Throwable memanggil
     * Metode Throwable.fillInStackTrace(). Metode ini bersifat public, artinya
     * subkelas dapat menimpanya. Caranya adalah dengan mengganti metode yang
     * diwarisi dari Throwable dengan metode yang tidak melakukan apa pun; misalnya
     */

    /*
     * public class MyException extends Exception {
     * // constructors
     * 
     * @Override
     * public void fillInStackTrace() {
     * // do nothing
     * }
     * }
     */

    /*
     * Masalah dengan pendekatan ini adalah pengecualian yang mengesampingkan
     * fillInStackTrace() tidak akan pernah dapat menangkap stacktrace, dan tidak
     * berguna dalam skenario di mana Anda memerlukannya.
     */

    // Erasing or replacing the stacktrace/Menghapus atau mengganti stacktrace
    // Version ≥ Java SE 1.4

    /*
     * Dalam beberapa situasi, pelacakan tumpukan untuk pengecualian yang dibuat
     * dengan cara normal berisi informasi yang salah,
     * atau informasi yang tidak ingin diungkapkan pengembang kepada pengguna. Untuk
     * skenario ini, Throwable.setStackTrace dapat digunakan untuk menggantikan
     * array objek StackTraceElement yang menyimpan informasi.
     * 
     * Misalnya, berikut ini dapat digunakan untuk membuang informasi tumpukan
     * pengecualian:
     * exception.setStackTrace(new StackTraceElement[0]);
     */

    // Suppressed exceptions/Pengecualian yang disembunyikan
    // Version ≥ Java SE 7

    /*
     * Java 7 memperkenalkan konstruksi coba-dengan-sumber daya, dan konsep terkait
     * penindasan pengecualian. Perhatikan cuplikan berikut:
     * try (Writer w = new BufferedWriter(new FileWriter(someFilename))) {
     * // do stuff
     * int temp = 0 / 0; // throws an ArithmeticException
     * }
     */

    /*
     * Ketika pengecualian dilempar, percobaan akan memanggil close() pada w yang
     * akan menghapus output yang di-buffer dan kemudian menutup FileWriter. Tapi
     * apa yang terjadi jika IOException dilempar saat mengeluarkan output?
     * 
     * Apa yang terjadi adalah pengecualian apa pun yang muncul saat membersihkan
     * sumber daya akan disembunyikan. Pengecualian ditangkap, dan ditambahkan ke
     * daftar pengecualian utama yang disembunyikan. Selanjutnya try-with-resources
     * akan dilanjutkan dengan pembersihan sumber daya lainnya.
     * Terakhir, pengecualian utama akan ditampilkan kembali.
     */

    /*
     * Pola serupa terjadi jika pengecualian dilempar selama inisialisasi sumber
     * daya, atau jika blok percobaan selesai secara normal. Pengecualian pertama
     * yang dilempar menjadi pengecualian utama, dan pengecualian berikutnya yang
     * muncul dari pembersihan akan disembunyikan.
     * 
     * Pengecualian yang disembunyikan dapat diambil dari objek pengecualian utama
     * dengan menelepon getSuppressedExceptions.
     */

    public static void main(String[] args) {
        try {
            throwException();
        } catch (Exception ex) {
            printStackTrace(ex);
        }

        /*
         * output:
         * This method is throwException
         * Called from method main
         */

    }

    static void throwException() throws Exception {
        throw new Exception();
    }

    static void printStackTrace(Exception ex) {
        StackTraceElement[] frames = ex.getStackTrace();
        System.out.println("This method is " + frames[0].getMethodName());
        System.out.println("Called from method " + frames[1].getMethodName());
    }

}
