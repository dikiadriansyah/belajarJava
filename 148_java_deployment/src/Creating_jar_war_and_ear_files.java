public class Creating_jar_war_and_ear_files {
    // Creating JAR, WAR and EAR files/Membuat file JAR, WAR dan EAR

    /*
     * Jenis file JAR, WAR dan EAR pada dasarnya adalah file ZIP dengan file
     * "manifest" dan (untuk file WAR dan EAR) direktori internal/struktur file
     * tertentu.
     * 
     * Cara yang disarankan untuk membuat file-file ini adalah dengan menggunakan
     * alat build khusus Java yang "memahami" persyaratan untuk masing-masing jenis
     * file. Jika Anda tidak menggunakan alat build, maka IDE "ekspor" adalah opsi
     * berikutnya untuk dicoba.
     * 
     * (Catatan editorial: deskripsi cara membuat file-file ini paling baik
     * ditempatkan dalam dokumentasi untuk masing-masing alat.
     * Letakkan di sana. Tolong tunjukkan pengendalian diri dan JANGAN memasukkan
     * mereka ke dalam contoh ini!)
     */

    // Creating JAR and WAR files using Maven/Membuat file JAR dan WAR menggunakan
    // Maven

    /*
     * Membuat JAR atau WAR menggunakan Maven hanyalah masalah memasukkan elemen
     * <packaging> yang benar ke dalam file POM;
     * misalnya,
     * <packaging>jar</packaging>
     * 
     * atau
     * <packaging>war</packaging>
     * 
     */

    /*
     * Untuk lebih jelasnya. Maven dapat dikonfigurasi untuk membuat file JAR yang
     * "dapat dieksekusi" dengan menambahkan informasi yang diperlukan
     * tentang kelas titik masuk dan dependensi eksternal sebagai properti plugin
     * untuk plugin maven jar. Bahkan ada
     * sebuah plugin untuk membuat file "uberJAR" yang menggabungkan aplikasi dan
     * dependensinya ke dalam satu file JAR.
     * 
     * Silakan merujuk ke dokumentasi Maven
     * (http://stackoverflow.com/documentation/maven/topics ) untuk informasi lebih
     * lanjut informasi.
     */

    // Creating JAR, WAR and EAR files using Ant/Membuat file JAR, WAR dan EAR
    // menggunakan Ant

    /*
     * Alat pembuat Ant memiliki "tugas" terpisah untuk membuat JAR, WAR, dan EAR.
     * Silakan merujuk ke dokumentasi Ant (
     * http://stackoverflow.com/documentation/ant/topics ) untuk informasi lebih
     * lanjut
     */

    // Creating JAR, WAR and EAR files using an IDE/Membuat file JAR, WAR dan EAR
    // menggunakan IDE

    /*
     * Tiga IDE Java terpopuler semuanya memiliki dukungan bawaan untuk membuat file
     * penerapan. Fungsinya sering kali digambarkan sebagai "mengekspor".
     * 
     * Eclipse - http://stackoverflow.com/documentation/eclipse/topics
     * NetBeans - http://stackoverflow.com/documentation/netbeans/topics
     * Intellij-IDEA - Exporting
     */

    // Creating JAR, WAR and EAR files using the jar command./Membuat file JAR, WAR
    // dan EAR menggunakan perintah jar.

    /*
     * Dimungkinkan juga untuk membuat file-file ini "dengan tangan" menggunakan
     * perintah jar. Ini hanyalah masalah merakit file
     * pohon dengan file komponen yang benar di tempat yang benar, membuat file
     * manifes, dan menjalankan jar untuk membuat file JAR.
     * 
     * Silakan merujuk ke topik perintah jar (Membuat dan memodifikasi file JAR)
     * untuk informasi lebih lanjut
     */

    public static void main(String[] args) throws Exception {

    }
}
