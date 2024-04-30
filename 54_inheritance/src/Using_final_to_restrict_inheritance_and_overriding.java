public class Using_final_to_restrict_inheritance_and_overriding {
    // Using 'final' to restrict inheritance and overriding / Menggunakan 'final'
    // untuk membatasi warisan dan penggantian

    // Final classes
    /*
     * Saat digunakan dalam deklarasi class, pengubah final mencegah deklarasi kelas
     * lain yang memperluas kelas tersebut. Kelas final adalah kelas "leaf" dalam
     * hierarki kelas warisan.
     * 
     * // This declares a final class
     * final class MyFinalClass {
     * /* some code
     * }
     */

    /*
     * // Compilation error: cannot inherit from final MyFinalClass
     * class MySubClass extends MyFinalClass {
     * // more code
     * }
     */

    // Use-cases for final classes

    /*
     * Kelas akhir dapat digabungkan dengan konstruktor private untuk mengontrol
     * atau mencegah pembuatan instance kelas. Ini bisa
     * digunakan untuk membuat apa yang disebut "utility class" yang hanya
     * mendefinisikan anggota statis; yaitu konstanta dan metode statis.
     */

    /*
     * public final class UtilityClass {
     * // Private constructor to replace the default visible constructor
     * private UtilityClass() {}
     * // Static members can still be used as usual
     * public static int doSomethingCool() {
     * return 123;
     * }
     * }
     */

    /*
     * Kelas yang tidak dapat diubah juga harus dinyatakan sebagai kelas final.
     * (Kelas yang tidak dapat diubah adalah kelas yang instance-nya tidak dapat
     * diubah setelah dibuat; lihat topik Objek yang Tidak Dapat Diubah.) Dengan
     * melakukan ini, Anda membuat subkelas yang dapat diubah dari kelas yang tidak
     * dapat diubah menjadi mustahil. Hal itu akan melanggar Prinsip Substitusi
     * Liskov yang mana mensyaratkan bahwa subtipe harus mematuhi "kontrak perilaku"
     * supertipenya.
     * 
     * Dari sudut pandang praktis, mendeklarasikan kelas yang tidak dapat diubah
     * sebagai kelas final akan mempermudah pertimbangan tentang perilaku program.
     * Hal ini juga mengatasi masalah keamanan dalam skenario ketika kode yang tidak
     * tepercaya dieksekusi di sandbox keamanan. (Misalnya, karena String
     * dideklarasikan sebagai final, kelas tepercaya tidak perlu khawatir bahwa
     * kelas tersebut mungkin tertipu untuk menerima subkelas yang dapat diubah,
     * yang kemudian dapat diubah secara diam-diam oleh pemanggil yang tidak
     * tepercaya.)
     * 
     * Salah satu kelemahan kelas final adalah bahwa kelas tersebut tidak bekerja
     * dengan kerangka kerja yang mengejek seperti Mockito.
     * Pembaruan: Mockito versi 2 sekarang mendukung tiruan kelas akhir.
     */

    // Final methods
    /*
     * Pengubah final juga dapat diterapkan pada metode untuk mencegahnya ditimpa
     * di subkelas:
     * 
     * public class MyClassWithFinalMethod {
     * public final void someMethod() {
     * }
     * }
     * public class MySubClass extends MyClassWithFinalMethod {
     * 
     * @Override
     * public void someMethod() { // Compiler error (overridden method is final)
     * }
     * }
     * 
     */

    /*
     * Metode final biasanya digunakan ketika Anda ingin membatasi apa yang dapat
     * diubah oleh subkelas di suatu kelas tanpa melarang subkelas sepenuhnya.
     * 
     * Pengubah final juga dapat diterapkan pada variabel, tetapi arti variabel
     * final for tidak ada hubungannya dengan pewarisan.
     */

    // Private constructor to replace the default visible constructor
    private Using_final_to_restrict_inheritance_and_overriding() {
        // Constructor is private to prevent instantiation
        throw new AssertionError("Utility class instantiation is not allowed");
    }

    // Static members can still be used as usual
    public static int doSomethingCool() {
        return 123;
    }

    public static void main(String[] args) {
        // Create an object of MyFinalClass
        // MyFinalClass myFinalObject = new MyFinalClass("Hello, I'm final!");

        // Access the method of MyFinalClass
        // System.out.println(myFinalObject.getMessage()); // Hello, I'm final!

        // -------------------------
        int result = Using_final_to_restrict_inheritance_and_overriding.doSomethingCool();
        System.out.println("Result of doing something cool: " + result); // Result of doing something cool: 123
    }
}
