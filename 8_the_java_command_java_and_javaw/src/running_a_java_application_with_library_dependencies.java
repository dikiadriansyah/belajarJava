public class running_a_java_application_with_library_dependencies {
    // Running a Java application with library dependencies / Menjalankan aplikasi
    // Java dengan dependensi library

    // ini adalah kelanjutan dari contoh "main class" dan "executable JAR" yang
    // dapat dieksekusi.

    // aplikasi java tipikal terdiri dari kode khusus aplikasi dan berbagai kode
    // pustaka yang dapat digunakan kembali yang telah Anda terapkan atau yang telah
    // diterapkan oleh pihak ketiga.

    // Java adalah bahasa yang terikat secara dinamis. Saat Anda menjalankan
    // aplikasi Java dengan dependensi library, JVM perlu mengetahui letak
    // dependensi agar dapat memuat class sesuai kebutuhan. Secara garis besar, ada
    // dua cara untuk mengatasi hal ini:
    // - The application and its dependencies can be repackaged into a single JAR
    // file that contains all of the required classes and resources. / Aplikasi dan
    // dependensinya dapat dikemas ulang menjadi satu file JAR yang berisi semua
    // kelas dan sumber daya yang diperlukan.

    // - The JVM can be told where to find the dependent JAR files via the runtime
    // classpath. / JVM dapat diberi tahu di mana menemukan file JAR yang bergantung
    // melalui runtime classpath.

    // untuk file JAR yang dapat dieksekusi, classpath runtime ditentukan oleh
    // atribut manifes "Class-Path". (Catatan Redaksi: Ini harus dijelaskan dalam
    // Topik terpisah pada perintah jar.) jika tidak, classpath runtime harus
    // disediakan menggunakan -cp option atau menggunakan variabel lingkungan
    // CLASSPATH.

    // misalnya, kita memiliki aplikasi java di file "myApp.jar" yg kelas titik
    // masuknya adalah com.example.MyApp. Misalkan juga aplikasi bergantung pada
    // file JAR pustaka "lib/library1.jar" dan "lib/library2.jar".
    // Kami dapat meluncurkan aplikasi menggunakan perintah java sebagai berikut di
    // baris perintah:

    // $ # Alternative 1 (preferred)
    // $ java -cp myApp.jar:lib/library1.jar:lib/library2.jar com.example.MyApp
    // $ # Alternative 2
    // $ export CLASSPATH=myApp.jar:lib/library1.jar:lib/library2.jar
    // $ java com.example.MyApp

    // (Pada Windows, Anda akan menggunakan ; alih-alih : sebagai pemisah classpath,
    // dan Anda akan menyetel variabel CLASSPATH (lokal) menggunakan set daripada
    // ekspor.)

    // Sementara pengembang Java akan merasa nyaman dengan itu, itu tidak "ramah
    // pengguna". Jadi merupakan praktik umum untuk menulis skrip shell sederhana
    // (atau file batch Windows) untuk menyembunyikan detail yang tidak perlu
    // diketahui pengguna.
    // Misalnya, jika Anda memasukkan skrip shell berikut ke dalam file bernama
    // "myApp", membuatnya dapat dieksekusi, dan memasukkannya ke dalam
    // direktori di jalur pencarian perintah:

    // #!/bin/bash
    // # The 'myApp' wrapper script
    // export DIR=/usr/libexec/myApp
    // export CLASSPATH=$DIR/myApp.jar:$DIR/lib/library1.jar:$DIR/lib/library2.jar
    // java com.example.MyApp

    // maka Anda dapat menjalankannya sebagai berikut:
    // $ myApp arg1 arg2 ...

    // Argumen apa pun pada baris perintah akan diteruskan ke aplikasi Java melalui
    // ekspansi "$@". (Anda dapat melakukan sesuatu yang mirip dengan file batch
    // Windows, meskipun sintaksnya berbeda.)

}
