public class Pitfall_of_auto_unboxing_null_object_into_primitive {
    // Pitfall of Auto-Unboxing Null Objects into Primitives/Jebakan Membuka Kotak
    // Otomatis Objek Null menjadi Primitif

    /*
     * public class Foobar {
     * public static void main(String[] args) {
     * // example:
     * Boolean ignore = null;
     * if (ignore == false) {
     * System.out.println("Do not ignore!");
     * }
     * }
     * }
     */

    /*
     * Jebakan di sini adalah null dibandingkan dengan false. Karena kita
     * membandingkan boolean primitif dengan Boolean,
     * Java mencoba membuka kotak Boolean Object menjadi setara primitif, siap untuk
     * dibandingkan. Namun, karena nilai tersebut adalah null, NullPointerException
     * akan dilempar.
     * 
     * Java tidak mampu membandingkan tipe primitif dengan nilai null, yang
     * menyebabkan NullPointerException saat runtime. Pertimbangkan kasus primitif
     * dari kondisi false == null; ini akan menghasilkan kesalahan waktu kompilasi
     * tipe yang incomparable: int dan <null>.
     */

    public static void main(String[] args) throws Exception {
        // example:
        Boolean ignore = null;
        if (ignore == false) {
            System.out.println("Do not ignore!");
        }
        /*
         * output:
         * Exception in thread "main" java.lang.NullPointerException
         */
    }
}
