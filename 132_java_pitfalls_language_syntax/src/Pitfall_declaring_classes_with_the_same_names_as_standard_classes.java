public class Pitfall_declaring_classes_with_the_same_names_as_standard_classes {
    // Pitfall - Declaring classes with the same names as standard classes / Pitfall
    // - Mendeklarasikan kelas dengan nama yang sama dengan kelas standar

    /*
     * Terkadang, programmer yang baru mengenal Java membuat kesalahan dengan
     * mendefinisikan sebuah kelas dengan nama yang sama dengan kelas yang banyak
     * digunakan. Misalnya:
     * 
     * package com.example;
     * // My string utilities
     * 
     * public class String {
     * ....
     * }
     * 
     */

    // Kemudian mereka bertanya-tanya mengapa mereka mendapatkan kesalahan yang
    // tidak terduga. Misalnya:

    /*
     * package com.example;
     * public class Test {
     * public static void main(String[] args) {
     * System.out.println("Hello world!");
     * }
     * }
     */

    // Jika Anda mengkompilasi dan kemudian mencoba menjalankan kelas-kelas di atas,
    // Anda akan mendapatkan kesalahan:
    /*
     * $ javac com/example/*.java
     * $ java com.example.Test
     * Error: Main method not found in class test.Test, please define the main
     * method as:
     * public static void main(String[] args)
     * or a JavaFX application class must extend javafx.application.Application
     */

    /*
     * Seseorang yang melihat kode untuk kelas Test akan melihat deklarasi main dan
     * melihat tanda tangannya dan
     * bertanya-tanya apa yang dikeluhkan oleh perintah java. Namun kenyataannya,
     * perintah java mengatakan yang sebenarnya.
     * 
     * Saat kami mendeklarasikan versi String dalam paket yang sama dengan Test,
     * versi ini lebih diutamakan daripada impor otomatis java.lang.String. Jadi,
     * tanda tangan dari metode Test.main sebenarnya
     * 
     * void main(com.example.String[] args)
     */

    // alih-alih
    // void main(java.lang.String[] args)

    /*
     * dan perintah java tidak akan mengenalinya sebagai metode titik masuk.
     * 
     * Pelajaran: Jangan mendefinisikan kelas yang memiliki nama yang sama dengan
     * kelas yang ada di java.lang, atau kelas lain yang umum digunakan di
     * perpustakaan Java SE. Jika Anda melakukan itu, Anda membuka diri terhadap
     * segala jenis kesalahan yang tidak jelas.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
    }
}
