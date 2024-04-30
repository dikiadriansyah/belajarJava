public class Specifying_a_varargs_parameter {
    // Specifying a varargs parameter/Menentukan parameter varargs

    /*
     * void doSomething(String... strings) {
     * for (String s : strings) {
     * System.out.println(s);
     * }
     * }
     * 
     */

    /*
     * Tiga titik setelah tipe parameter terakhir menunjukkan bahwa argumen terakhir
     * dapat diteruskan sebagai array atau sebagai
     * serangkaian argumen. Varargs hanya dapat digunakan pada posisi argumen
     * terakhir.
     */

    // ------------------
    void doSomething(String... strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Exception {
        Specifying_a_varargs_parameter box = new Specifying_a_varargs_parameter();
        box.doSomething("Selamat", "Datang", "di", "Hotel Manhattan");
        /*
         * output:
         * Selamat
         * Datang
         * di
         * Hotel Manhattan
         */
    }
}
