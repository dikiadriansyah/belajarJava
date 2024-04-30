public class Autounboxing_may_lead_to_nullpointerexception {
    // Auto-unboxing may lead to NullPointerException/Pembuka kotak otomatis dapat
    // menyebabkan NullPointerException

    // Kode ini mengkompilasi:
    /*
     * Integer arg = null;
     * int x = arg;
     */

    /*
     * Tapi itu akan crash saat runtime dengan java.lang.NullPointerException di
     * baris kedua.
     * 
     * Masalahnya adalah int primitif tidak boleh memiliki nilai null.
     * 
     * Ini adalah contoh minimalis, namun dalam praktiknya sering kali terwujud
     * dalam bentuk yang lebih canggih. NullPointerException tidak terlalu intuitif
     * dan seringkali tidak banyak membantu dalam menemukan bug tersebut.
     * 
     * Andalkan autoboxing dan auto-unboxing dengan hati-hati, pastikan nilai yang
     * tidak dikotakkan tidak memiliki nilai null saat runtime.
     */

    public static void main(String[] args) throws Exception {
        Integer arg = null;
        Integer x = arg;

        // System.out.println(x);
        if (arg != null) {
            x = arg.intValue(); // Mengonversi Integer ke int
            System.out.println("Nilai x: " + x);
        } else {
            System.out.println("Variabel arg memiliki nilai null.");
        }
        /*
         * output:
         * Variabel arg memiliki nilai null.
         */
    }
}
