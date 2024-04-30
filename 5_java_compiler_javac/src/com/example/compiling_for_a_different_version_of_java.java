package com.example;

public class compiling_for_a_different_version_of_java {
    // Compiling for a different version of Java / Mengkompilasi untuk versi Java
    // yang berbeda

    // bahasa pemrograman java (dan runtime-nya) telah mengalami banyak perubahan
    // sejak dirilis sejak rilis publik pertamanya. perubahan ini meliputi:
    // 1. Perubahan dalam sintaks dan semantik bahasa pemrograman Java
    // 2. perubahan pada API yang disediakan oleh pustaka kelas standar Java.
    // 3. perubahan pada set instruksi java (bytecode) dan format file kelas.

    // dengan sangat sedikit pengecualian (misalnya enum keyword, perubahan pada
    // beberapa kelas "internal", dll), perubahan ini kompatibel ke belakang.

    // 4. program java yang dikompilasi menggunakan Java toolchain versi lama akan
    // berjalan di versi yang lebih baru Platform Java tanpa kompilasi ulang.
    // 5. program java yang ditulis dalam versi java yang lebih lama akan berhasil
    // dikompilasi dengan kompiler java yang baru.

    // Compiling old Java with a newer compiler / mengkompilasi java lama dengan
    // kompiler yang lebih baru
    // jika anda perlu (mengkompilasi ulang) kode java lama pada platform java yang
    // lebih baru untuk dijalankan pada platform yang lebih baru, anda biasanya
    // tidak perlu memberikan flag kompilasi khusus.
    // dalam beberapa kasus (misalnya jika anda menggunakan enum sebagai
    // pengindentifikasi), anda dapat menggunakan -source option untuk menonaktifkan
    // sintaks baru. misalnya, diberikan kelas berikut:

    // public class OldSyntax {
    // private static int enum; // tidak valid di Java 5 atau lebih baru
    // }

    // berikut ini diperlukan untuk mengkompilasi kelas menggunakan kompiler java 5
    // (atau lebih baru):

    // $ javac -source 1.4 OldSyntax.java

    // Compiling for an older execution platform / Mengkompilasi untuk platform
    // eksekusi yang lebih lama

    // jika anda pelu mengompilasi java untuk dijalankan pada platform java lama,
    // pendekatan paling sederhana adalah menginstal JDK untuk versi terlama yang
    // perlu anda dukung, dan menggunakan compiler JDK tersebut dalam build anda.

    // anda juga dapat mengkompilasi dengan kompiler java yang lebih baru, tetapi
    // ada yang rumit. Pertama-tama, ada beberapa prasyarat penting yang harus
    // dipenuhi:
    // 1. kode yang anda kompilasi tidak boleh menggunakan konstruksi bahasa java
    // yang tidak tersedia dalam versi java yang anda targetkan
    // 2. kode tidak boleh bergantung pada kelas(classes), bidang(fields), metode
    // java standar, dan sebagainya yang tidak tersedia di platform yang lebih tua.
    // 3. pustaka pihak ketiga yang bergantung pada kode juga harus dibuat untuk
    // platform lama dan tersedia pada waktu kompilasi dan waktu proses.

    // mengingat prasyarat terpenuhi, anda dapat mengkompilasi ulang kode untuk
    // platform lama menggunakan -target option.
    // $ javac -target 1.4 SomeClass.java

    // akan mengkompilasi kelas di atas untuk menghasilkan bytecode yang kompatibel
    // dengan Java 1.4 atau JVM yang lebih baru. (bahkan, - source option
    // menyiratkan -target yang kompatibel, jadi javac - source 1.4 ... akan
    // memiliki efek yang sama. itu hubungan antara -source dan -target dijelaskan
    // dalam dokumentasi Oracle).

    // karena itu, jika anda hanya menggunakan -target atau -source, anda masih akan
    // mengkompilasi pustaka kelas standar yang disediakan oleh JDK compiler.
    // jika anda tidak hati-hati, anda bisa mendapatkan kelas dengan versi bytecode
    // yang benar, tapi dengan ketergantungan pada API yang tidak tersedia.
    // solusinya adalah menggunakan -bootclasspath option. sebagai contoh:
    // $ javac -target 1.4 --bootclasspath path/to/java1.4/rt.jar SomeClass.java

    // akan dikompilasi dengan serangkaian perpustakaan runtime alternatif.
    // Jika kelas yang sedang dikompilasi memiliki dependensi (kebetulan) pada
    // pustaka yang lebih baru, ini akan memberi Anda kesalahan kompilasi.
}
