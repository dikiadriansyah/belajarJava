public class Introduction_to_jna {

    // Introduction to JNA/Pengantar JNA

    /*
     * Apa itu JNA?
     * Java Native Access (JNA) adalah perpustakaan yang dikembangkan komunitas yang
     * menyediakan akses mudah bagi program Java ke perpustakaan bersama asli (file
     * .dll di windows, file .so di Unix ...)
     */

    // Bagaimana saya bisa menggunakannya?
    /*
     * Pertama, unduh rilis terbaru JNA dan rujuk jna.jar-nya di CLASSPATH proyek
     * Anda.
     * Kedua, salin, kompilasi, dan jalankan kode Java di bawah ini
     * 
     * 
     */

    /*
     * For the purpose of this introduction, we suppose the native platform in use
     * is Windows. If you're running on
     * another platform simply replace the string "msvcrt" with the string "c" in
     * the code below
     */

    // Program Java kecil di bawah ini akan mencetak pesan di konsol dengan
    // memanggil fungsi C printf.

    // CRuntimeLibrary.java
    /*
     * package jna.introduction;
     * import com.sun.jna.Library;
     * import com.sun.jna.Native;
     * // We declare the printf function we need and the library containing it
     * (msvcrt)...
     * public interface CRuntimeLibrary extends Library {
     * CRuntimeLibrary INSTANCE =
     * (CRuntimeLibrary) Native.loadLibrary("msvcrt", CRuntimeLibrary.class);
     * void printf(String format, Object... args);
     * }
     */

    // MyFirstJNAProgram.java
    /*
     * package jna.introduction;
     * // Now we call the printf function...
     * public class MyFirstJNAProgram {
     * public static void main(String args[]) {
     * CRuntimeLibrary.INSTANCE.printf("Hello World from JNA !");
     * }
     * }
     */

    // Ke mana harus pergi sekarang?
    // Lompat ke topik lain di sini atau lompat ke situs resminya.

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
