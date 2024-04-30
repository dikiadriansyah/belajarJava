import java.lang.Class;
import java.lang.ClassLoader;

public class Get_class_given_its_name {
    // Get Class given its (fully qualified) name/Dapatkan Kelas diberi nama (yang
    // sepenuhnya memenuhi syarat).

    /*
     * Diberikan sebuah String yang berisi nama suatu kelas, objek Kelasnya dapat
     * diakses menggunakan Class.forName:
     * 
     * Class clazz = null;
     * try {
     * clazz = Class.forName("java.lang.Integer");
     * } catch (ClassNotFoundException ex) {
     * throw new IllegalStateException(ex);
     * }
     */

    // Version ≥ Java SE 1.2

    /*
     * Hal ini dapat ditentukan, apakah kelas harus diinisialisasi (parameter kedua
     * forName) dan ClassLoader mana yang harus diinisialisasi
     * digunakan (parameter ketiga):
     * 
     * ClassLoader classLoader = ...
     * boolean initialize = ...
     * Class clazz = null;
     * try {
     * clazz = Class.forName("java.lang.Integer", initialize, classLoader);
     * } catch (ClassNotFoundException ex) {
     * throw new IllegalStateException(ex);
     * }
     */

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Get_class_given_its_name.class.getClassLoader(); // Contoh ClassLoader, dapat
                                                                                   // disesuaikan
        boolean initialize = true; // Contoh nilai initialize
        Class<?> clazz = null;
        try {
            clazz = Class.forName("java.lang.Integer", initialize, classLoader);
            System.out.println("Class loaded successfully: " + clazz.getName());
        } catch (ClassNotFoundException ex) {
            throw new IllegalStateException(ex);
        }
        /*
         * output:
         * Class loaded successfully: java.lang.Integer
         */
    }
}
