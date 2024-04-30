public class Modifiers_in_interfaces {
    // Modifiers in Interfaces/Pengubah di Antarmuka

    /*
     * Panduan Gaya Oracle Java menyatakan:
     * Pengubah tidak boleh ditulis jika bersifat implisit.
     */

    /*
     * (Lihat Pengubah dalam Standar Kode Resmi Oracle untuk konteks dan tautan ke
     * dokumen Oracle sebenarnya.)
     * Panduan gaya ini berlaku khususnya untuk antarmuka. Mari perhatikan cuplikan
     * kode berikut:
     * 
     * interface I {
     * public static final int VARIABLE = 0;
     * public abstract void method();
     * public static void staticMethod() { ... }
     * public default void defaultMethod() { ... }
     * }
     */

    /*
     * Variables
     * Semua variabel antarmuka secara implisit adalah konstanta dengan pengubah
     * implisit public (dapat diakses oleh semua), static (dapat diakses dengan nama
     * antarmuka) dan final (harus diinisialisasi selama deklarasi):
     * public static final int VARIABLE = 0;
     */

    /*
     * Methods
     * 1. Semua metode yang tidak menyediakan implementasi secara implisit bersifat
     * public dan abstract.
     * 
     * public abstract void method();
     * 
     * Version ≥ Java SE 8
     * 2. Semua metode dengan pengubah static atau default harus menyediakan
     * implementasi dan secara implisit bersifat public
     * 
     * public static void staticMethod() { ... }
     */

    /*
     * Setelah semua perubahan di atas diterapkan, kita akan mendapatkan yang
     * berikut ini
     * interface I {
     * int VARIABLE = 0;
     * 
     * void method();
     * static void staticMethod() { ... }
     * default void defaultMethod() { ... }
     * }
     */

    public static void main(String[] args) {
        // Membuat objek dari kelas MyClass
        Myclass myObject = new Myclass();

        // Memanggil method dari interface
        myObject.method();
        I.staticMethod();
        myObject.defaultMethod();

        // Mengakses variabel dari interface
        System.out.println("Value of VARIABLE: " + I.VARIABLE);

        /*
         * output:
         * Implementation of method in MyClass
         * Static method in interface I ki\AppData\Roaming\Code\User\workspaceStora
         * Default method in interface I ifiers_in_interfaces'
         * Value of VARIABLE: 0
         */

    }
}
