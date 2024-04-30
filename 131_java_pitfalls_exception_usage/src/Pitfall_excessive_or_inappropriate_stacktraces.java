import java.util.logging.Logger;

public class Pitfall_excessive_or_inappropriate_stacktraces {
    // Pitfall - Excessive or inappropriate stacktraces/Jebakan - Jejak tumpukan
    // yang berlebihan atau tidak sesuai

    /*
     * Salah satu hal paling menjengkelkan yang dapat dilakukan pemrogram adalah
     * menyebarkan panggilan ke printStackTrace() ke seluruh kodenya.
     * 
     * Masalahnya adalah printStackTrace() akan menulis stacktrace ke output
     * standar.
     * 1. Untuk aplikasi yang ditujukan bagi pengguna akhir yang bukan pemrogram
     * Java, stacktrace tidak informatif, dan paling buruk mengkhawatirkan.
     * 2. Untuk aplikasi sisi server, kemungkinan besar tidak ada orang yang akan
     * melihat keluaran standar.
     */

    /*
     * Ide yang lebih baik adalah tidak memanggil printStackTrace secara langsung,
     * atau jika Anda memanggilnya, lakukan dengan cara sehingga pelacakan tumpukan
     * ditulis ke file log atau file kesalahan, bukan ke konsol pengguna akhir.
     * 
     * Salah satu cara untuk melakukannya adalah dengan menggunakan kerangka
     * logging, dan meneruskan objek pengecualian sebagai parameter peristiwa log.
     * Namun, bahkan mencatat pengecualian pun bisa berbahaya jika dilakukan dengan
     * tidak hati-hati. Pertimbangkan hal berikut:
     * 
     * public void method1() throws SomeException {
     * try {
     * method2();
     * // Do something
     * } catch (SomeException ex) {
     * Logger.getLogger().warn("Something bad in method1", ex);
     * throw ex;
     * }
     * }
     * public void method2() throws SomeException {
     * try {
     * // Do something else
     * } catch (SomeException ex) {
     * Logger.getLogger().warn("Something bad in method2", ex);
     * throw ex;
     * }
     * }
     * 
     */

    /*
     * Jika pengecualian diberikan pada method2, Anda mungkin akan melihat dua
     * salinan pelacakan tumpukan yang sama di file log,
     * berhubungan dengan kegagalan yang sama.
     * 
     * Singkatnya, catat pengecualian tersebut atau masukkan kembali lebih jauh
     * (mungkin dibungkus dengan pengecualian lain). Jangan lakukan keduanya.
     */
    // -------------------
    static class SomeException extends Exception {
        public SomeException(String message) {
            super(message);
        }
    }

    public void method1() throws SomeException {
        try {
            method2();
            // Do something
        } catch (SomeException ex) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).warning("Something bad in method1");
            throw ex;
        }
    }

    public void method2() throws SomeException {
        try {
            // Do something else
            throw new SomeException("Error in method2");
        } catch (SomeException ex) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).warning("Something bad in method2");
            throw ex;
        }
    }

    public static void main(String[] args) {
        Pitfall_excessive_or_inappropriate_stacktraces box = new Pitfall_excessive_or_inappropriate_stacktraces();
        try {
            box.method1();
        } catch (SomeException ex) {
            ex.printStackTrace();
        }

        /*
         * output:
         * Mar 13, 2024 4:27:36 PM Pitfall_excessive_or_inappropriate_stacktraces
         * method2
         * WARNING: Something bad in method2
         * Mar 13, 2024 4:27:37 PM Pitfall_excessive_or_inappropriate_stacktraces
         * method1
         * WARNING: Something bad in method1
         */

    }

}