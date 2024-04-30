public class Introducing_to_javaweb_start {
    // Introduction to Java Web Start/Pengantar Java Web Mulai

    // Tutorial Oracle Java merangkum Web Start sebagai berikut:
    /*
     * Perangkat lunak Java Web Start memberikan kemampuan untuk meluncurkan
     * aplikasi berfitur lengkap dengan satu klik. Pengguna dapat mengunduh dan
     * meluncurkan aplikasi, seperti program spreadsheet lengkap atau klien obrolan
     * Internet, tanpa melalui prosedur instalasi yang panjang.
     */

    /*
     * Keuntungan lain dari Java Web Start adalah dukungan untuk kode yang
     * ditandatangani dan deklarasi dependensi platform secara eksplisit, dan
     * dukungan untuk cache kode dan penerapan pembaruan aplikasi.
     * 
     * Java Web Start juga disebut sebagai JavaWS dan JAWS. Sumber informasi utama
     * adalah:
     * The Java Tutorials
     * Java Web Start Guide
     * Java Web Start FAQ
     * JNLP Specification
     * javax.jnlp API DOCUMENTATION
     * Java Web Start Developers site
     * 
     * 
     */

    // Prerequisites/Prasyarat
    /*
     * Pada tingkat tinggi, Web Start bekerja dengan mendistribusikan aplikasi Java
     * yang dikemas sebagai file JAR dari server web jarak jauh. Prasyaratnya
     * adalah:
     * 1. Instalasi Java yang sudah ada sebelumnya (JRE atau JDK) pada mesin target
     * tempat aplikasi dijalankan. Java 1.2.2 atau
     * lebih tinggi diperlukan:
     * 1. Mulai Java 5.0 dan seterusnya, dukungan Web Start disertakan dalam
     * JRE/JDK.
     * 2. Untuk rilis sebelumnya, dukungan Web Start diinstal secara terpisah.
     * 3. Infrastruktur Web Start mencakup beberapa Javascript yang dapat disertakan
     * dalam halaman web untuk membantu pengguna menginstal perangkat lunak yang
     * diperlukan
     * 
     * 3. Server web yang menghosting perangkat lunak harus dapat diakses oleh mesin
     * target.
     * 4. Jika pengguna akan meluncurkan aplikasi Web Start menggunakan link di
     * halaman web, maka:
     * 1. mereka memerlukan browser web yang kompatibel, dan
     * 2. untuk browser modern (aman), mereka perlu diberi tahu cara memberi tahu
     * browser agar Java dapat berjalan ...
     * tanpa mengorbankan keamanan browser web.
     */

    /*
     * Contoh file JNLP
     * Contoh berikut dimaksudkan untuk menggambarkan fungsionalitas dasar JNLP.
     * 
     * <?xml version="1.0" encoding="UTF-8"?>
     * <jnlp spec="1.0+" codebase="https://www.example.com/demo"
     * href="demo_webstart.jnlp">
     * <information>
     * <title>Demo</title>
     * <vendor>The Example.com Team</vendor>
     * </information>
     * <resources>
     * <!-- Application Resources -->
     * <j2se version="1.7+" href="http://java.sun.com/products/autodl/j2se"/>
     * <jar href="Demo.jar" main="true"/>
     * </resources>
     * <application-desc
     * name="Demo Application"
     * main-class="com.example.jwsdemo.Main"
     * width="300"
     * height="300">
     * </application-desc>
     * <update check="background"/>
     * </jnlp>
     */

    /*
     * Seperti yang Anda lihat, file JNLP berbasis XML, dan semua informasi
     * terkandung dalam elemen <jnlp>.
     * 
     * 1. Atribut spec memberikan versi spesifikasi JNPL yang sesuai dengan file
     * ini.
     * 2. Atribut basis kode memberikan URL dasar untuk menyelesaikan URL href
     * relatif di seluruh file.
     * 3. Atribut href memberikan URL pasti untuk file JNLP ini.
     * 4. Elemen <informasi> berisi metadata aplikasi termasuk judul, penulis,
     * deskripsi, dan
     * situs web bantuan.
     * 5. Elemen <resources> menjelaskan dependensi aplikasi termasuk versi Java
     * yang diperlukan,
     * Platform OS dan file JAR.
     * 6. Elemen <application-desc> (atau <applet-desc>) menyediakan informasi yang
     * diperlukan untuk meluncurkan
     * aplikasi.
     */

    // Menyiapkan server web
    /*
     * Server web harus dikonfigurasi untuk menggunakan application/x-java-jnlp-file
     * sebagai tipe MIME untuk file .jnlp.
     * File JNLP dan file JAR aplikasi harus diinstal di server web agar tersedia
     * menggunakan
     * URL yang ditunjukkan oleh file JNLP.
     */

    // Mengaktifkan peluncuran melalui halaman web
    /*
     * Jika aplikasi akan diluncurkan melalui link web, halaman yang berisi link
     * tersebut harus dibuat di server web.
     * 1. Jika Anda dapat berasumsi bahwa Java Web Start sudah terinstal di mesin
     * pengguna, maka halaman webnya sederhana
     * perlu berisi tautan untuk meluncurkan aplikasi. Misalnya.
     * <a href="https://www.example.com/demo_webstart.jnlp">Launch the
     * application</a>
     * 
     * 2. Jika tidak, halaman tersebut juga harus menyertakan beberapa skrip untuk
     * mendeteksi jenis browser yang digunakan pengguna dan
     * permintaan untuk mengunduh dan menginstal versi Java yang diperlukan.
     */

    // CATATAN: Merupakan ide yang buruk untuk mendorong pengguna untuk menginstal
    // Java dengan cara ini, atau bahkan mengaktifkan Java di browser web mereka
    // sehingga peluncuran halaman web JNLP akan berfungsi.

    // Meluncurkan aplikasi Web Start dari baris perintah
    /*
     * Petunjuk untuk meluncurkan aplikasi Web Start dari baris perintah sederhana
     * saja. Dengan asumsi bahwa pengguna
     * telah menginstal Java 5.0 JRE atau JDK, Anda hanya perlu menjalankan ini:
     *
     * $ javaws <url>
     */

    // dimana <url> adalah URL untuk file JNLP di server jauh

    public static void main(String[] args) throws Exception {

    }
}
