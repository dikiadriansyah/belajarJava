package com.example;

public class App {
    // The 'javac' command - getting started / Perintah 'javac' - memulai

    // contoh sederhana:
    // Dengan asumsi bahwa "App.java" berisi sumber Java berikut:

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

// (Untuk penjelasan kode di atas, silakan merujuk ke Memulai dengan Bahasa
// Java.)
// Kita dapat mengkompilasi file di atas menggunakan perintah ini:
// $ javac App.java

// Ini menghasilkan file bernama "App.class", yang kemudian dapat kita
// jalankan sebagai berikut:
// $ java HelloWorld
// Hello world!

// Hal-hal penting yang perlu diperhatikan dari contoh ini adalah:
// 1. nama file sumber "App.java" harus cocok dengan nama kelas di file sumber
// ... yaitu HelloWorld. jika tidak cocok, anda akan mendapatkan kesalahan
// kompilasi.
// 2. nama file bytecode "App.class" sesuai dengan nama kelas. jika anda
// mengganti nama file "App.class", anda akan mendapatkan kesalahan saat mencoba
// menjalankannya
// 3. saat menjalankan aplikasi java menggunakan java, anda memberikan nama
// kelas Bukan nama file bytecode.

// contoh dengan packages
// kode java yang paling praktis menggunakan packages untuk mengatur ruang nama
// untuk kelas dan mengurangi risiko kecelakaan tabrakan nama kelas yang tidak
// disengaja.

// jika kita ingin mendeklarasikan kelas App dalam pemanggilan package
// com.example, "App.java" akan berisi sumber java berikut ini:

// package com.example;
// public class HelloWorld {
// public static void main(String[] args) {
// System.out.println("Hello world!");
// }
// }

// File kode sumber ini perlu disimpan dalam pohon direktori yang strukturnya
// sesuai dengan penamaan paket
// . # the current directory (for this example)
// |
// ----com
// |
// ----example
// |
// ----App.java

// Kita dapat mengkompilasi file di atas menggunakan perintah ini:
// $ javac com/example/App.java

// Ini menghasilkan file bernama "com/example/App.class"; yaitu setelah
// kompilasi, struktur file akan terlihat seperti
// . # the current directory (for this example)
// |
// ----com
// |
// ----example
// |
// ----App.java
// ----App.class

// Kami kemudian dapat menjalankan aplikasi sebagai berikut:
// $ java com.example.App
// Hello world!

// Poin tambahan yang perlu diperhatikan dari contoh ini adalah:
// 1. Struktur direktori harus sesuai dengan struktur nama package
// 2. Saat Anda menjalankan kelas, nama lengkap kelas harus diberikan; i.e.
// "com.example.App" not
// "HelloWorld".

// 3. Anda tidak perlu mengkompilasi dan menjalankan kode Java dari direktori
// saat ini. Kami hanya melakukannya di sini untuk ilustrasi

// Compiling multiple files at once with 'javac'. / Mengkompilasi banyak file
// sekaligus dengan 'javac'.

// Jika aplikasi Anda terdiri dari beberapa file kode sumber (dan sebagian
// besar!), Anda dapat mengompilasinya satu per satu.

// Sebagai alternatif, Anda dapat mengkompilasi banyak file sekaligus dengan
// mencantumkan nama path:
// $ javac Foo.java Bar.java

// atau menggunakan fungsi wildcard nama file perintah anda...
// $ javac *.java
// $ javac com/example/*.java
// $ javac */**/*.java #Only works on Zsh or with globstar enabled on your shell

// ini akan mengkompilasi semua file sumber java di direktori saat ini, di
// direktori "com/example", dan secara rekursif di direktori anak masing-masing.

// alternatif ketiga adalah menyediakan daftar nama file sumber(dan opsi
// compiler) sebagai file. sebagai contoh:
// $ javac @sourcefiles

// di mana file file sumber berisi:
// Foo.java
// Bar.java
// com/example/HelloWorld.java

// Catatan: mengkompilasi kode seperti ini sesuai untuk proyek satu orang kecil,
// dan untuk program sekali pakai. diluar itu, disarankan untuk memilih dan
// menggunakan alat build java. alternatifnya, sebagian besar pemrogram
// menggunakan Java IDE (misalnya Netbeans, Eclipse, IntelliJ IDEA) yang
// menawarkan kompiler tertanam dan pembangungan "project" tambahan.

// Commonly used 'javac' options / Opsi 'javac' yang umum digunakan

// Berikut adalah beberapa opsi untuk perintah javac yang mungkin berguna bagi
// Anda

// 1. Opsi -d menetapkan direktori tujuan untuk menulis file ".class".
// 2. Opsi -sourcepath menetapkan jalur pencarian kode sumber.
// 3. Opsi -cp atau -classpath menetapkan jalur pencarian untuk menemukan kelas
// eksternal dan yang telah dikompilasi sebelumnya. Untuk informasi selengkapnya
// tentang classpath dan cara menentukannya, lihat Topik Classpath.
// 4. Opsi -version mencetak informasi versi compiler.

// Daftar opsi kompiler yang lebih lengkap akan dijelaskan dalam contoh
// terpisah.

// Referensi
// Referensi definitif untuk perintah javac adalah halaman manual Oracle untuk
// javac(http://docs.oracle.com/javase/8/docs/technotes/tools/windows/javac.html).