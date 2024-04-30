public class Loading_native_libraries {
    // Loading native libraries/Memuat perpustakaan asli

    /*
     * Ungkapan umum untuk memuat file perpustakaan bersama di Java adalah sebagai
     * berikut :
     * public class ClassWithNativeMethods {
     * static {
     * System.loadLibrary("Example");
     * }
     * public native void someNativeMethod(String arg);
     * ...
     */

    /*
     * Panggilan ke System.loadLibrary hampir selalu statis sehingga terjadi selama
     * pemuatan kelas, memastikan tidak ada panggilan asli
     * metode dapat dijalankan sebelum perpustakaan bersama dimuat. Namun hal
     * berikut mungkin terjadi:
     * 
     * public class ClassWithNativeMethods {
     * // Call this before using any native method
     * public static void prepareNativeMethods() {
     * System.loadLibrary("Example");
     * }
     * ...
     */

    /*
     * Hal ini memungkinkan untuk menunda pemuatan perpustakaan bersama hingga
     * diperlukan, namun memerlukan kehati-hatian ekstra untuk menghindarinya
     * java.lang.UnsatisfiedLinkErrors.
     */

    /*
     * Target file lookup
     * File perpustakaan bersama dicari di jalur yang ditentukan oleh properti
     * sistem java.library.path, yang dapat berupa
     * diganti menggunakan argumen -Djava.library.path= JVM saat runtime :
     * 
     * java -Djava.library.path=path/to/lib/:path/to/other/lib
     * MainClassWithNativeMethods
     * 
     * Hati-hati dengan pemisah jalur sistem: for example, Windows uses;
     * instead of :.
     * 
     * Perhatikan bahwa System.loadLibrary menyelesaikan nama file perpustakaan
     * dengan cara yang bergantung pada platform : cuplikan kode di atas
     * mengharapkan file bernama libExample.so di Linux, dan example.dll di Windows.
     */

    /*
     * Alternatif untuk System.loadLibrary adalah System.load(String), yang
     * mengambil path lengkap ke file perpustakaan bersama,
     * menghindari pencarian java.library.path :
     * 
     * public class ClassWithNativeMethods {
     * static {
     * System.load("/path/to/lib/libExample.so");
     * }
     * ...
     */

    public static void prepareNativeMethods() {
        System.loadLibrary("Example");
    }

    // Native method declaration
    public native void nativeMethod();

    public static void main(String[] args) throws Exception {

        // Prepare native methods
        Loading_native_libraries.prepareNativeMethods();

        // Create an instance of Loading_native_libraries
        Loading_native_libraries obj = new Loading_native_libraries();

        // Call native method
        obj.nativeMethod();

    }
}
