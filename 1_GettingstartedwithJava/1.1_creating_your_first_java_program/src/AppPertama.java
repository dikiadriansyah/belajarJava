public class AppPertama { // bagian class
    public static void main(String[] args) throws Exception { // main method
        System.out.println("Hello, Dunia!");
        System.out.println("Perkenalkan saya Dhiki");
        System.out.println(23);
        System.out.print("dari " + 3 + " Bersaudara");
        // Fungsi print() untuk menampilkan teks apa adanya, sedangkan println() untuk
        // menampilkan teks dengan ditambah baris baru.

    }
}

// hasil:
// Hello, Dunia
// Perkenalkan saya Dhiki

// penjelasan:
// awalnya membuat public class AppPertama{} yg berisi main method yg ditulis
// public static void main(String[] args)throws Exception{},
// selanjutnya di main method berisi perintah untuk menampilkan yaitu
// System.out.println("Hello, Dunia");

// catatan:
// agar Java mengenali ini sebagai public class (dan tidak menimbulkan kesalahan
// waktu kompilasi), nama file harus sama dengan class name(HelloWorld dalam
// contoh ini) dengan ekstensi .java

// konvensi penamaan merekomendasikan bahwa kelas Java dimulai dengan karakter
// huruf besar, dan dalam format huruf unta( dimana huruf pertama dari setiap
// kata dikapitalisasi). konvensi merekomendasikan garis bawah(_) dan tanda
// dolar ($).

// untuk mengkompilasi, buka jendela terminal dan arahkan ke direktori
// HelloWorld.java:

// cd /path/to/containing/folder/

// Catatan: cd adalah perintah terminal untuk mengubah direktori.

// masukkan javac diikuti dengan nama file dan ekstensi sebagai berikut:
// $ javac HelloWorld.java

// cukup umum untuk mendapatkan error 'javac' tidak dikenali sebagai perintah
// internal atau eksternal, program yg dapat dijalankan, atau file batch.
// bahkan ketika anda telah menginstal JDK dan dapat menjalankan program dari
// IDE, misal Eclipse, dll. Karena jalur tidak ditambahkan ke lingkungan secara
// default.

// jika anda mendapatkkan ini di windows, untuk mengatasinya pertama coba
// jelajahi jalur javac.exe anda, kemungkinan besar ada di
// C:\ProgramFiles\Java\jdk(version number)\bin. kemudian coba jalankan dengan
// dibawah ini.
// $ C:\Program Files\Java\jdk(version number)\bin\javac HelloWorld.java

// sebelumnya ketika memanggil javac sama dengan perintah diatas. hanya dalam
// hal itu OS anda tahu dimana tinggal javac.
// jadi mari kita beri tahu sekarang, dengan cara ini anda tidak perlu
// mengetikkan seluruh jalur setiap saat. kami perlu menambahkan ini ke PATH
// kami.

// untuk mengedit variabel lingkungan PATH di Windows XP/Vista/7/8/10:
// - Control Panel => System => Advanced system settings
// Switch to "Advanced" tab => Environment Variables
// Dalam "System Variables", scroll down to select "PATH" => Edit

// Anda tidak dapat membatalkan ini jadi berhati-hatilah. pertama salin jalur
// anda yg ada ke notepad. kemudian untuk mendapatkan PATH yg tepat untuk anda
// telusuri javac secara manual ke folder tempat javac berada dan click on the
// address bar dan lalu salin. itu harus terlihat seperti
// c:\ProgramFiles\Java\jdk1.8.0_xx\bin

// di kolom "Variable value", tempel ini IN FRONT dari semua direktori yg ada,
// diikuti dengan titik koma (;). Jangan Delete entri yg ada.

// Variable name : PATH
// Variable value : c:\Program Files\Java\jdk1.8.0_xx\bin;[Existing Entries...]

// Sekarang ini harus diselesaikan.

// Untuk sistem Berbasis Linux coba di sini.

// Catatan: The javac command invoikes the Java compiler.

// kompiler kemudian akan menghasilkan file bytecode bernama HelloWorld.class yg
// dapat dieksekusi di Java Virtual Mesin (JVM).

// kompiler bahsa pemrograman Java, javac, membaca file sumber yg ditulis dalam
// bahasa pemrograman Java dan mengkompilasinya menjadi file kelas bytecode.
// secara opsional, kompiler juga dapat memproses anotasi yg ditemukan dalam
// file sumber dan kelas menggunakan Pluggable Annotation Processing API.
// compiler adalah alat baris perintah tetapi juga dapat dipanggil menggunakan
// Java Compiler API.

// untuk menjalankan program anda, masukkan java diikuti dengan nama kelas yg
// berisi metode utama (HelloWorld dalam contoh kita).
// Perhatikan bagaimana .class dihilangkan:
// $ java HelloWorld

// Catatan: Perintah java menjalankan aplikasi Java.

// Ini akan ditampilkan ke konsol Anda:
// Hello, World!

// Anda telah berhasil membuat kode dan membuat program Java pertama Anda!
// Catatan: Agar perintah Java (java, javac, dll) dikenali, Anda perlu
// memastikan:
// - A JDK is installed (e.g. Oracle, OpenJDK and other sources)
// - Your environment variables are properly set up (Variabel lingkungan Anda
// sudah diatur dengan benar)

// anda harus menggunakan compiler (javac) dan eksekutor (java) yg disediakan
// oleh JVM anda.
// untuk mengetahui versi mana yg telah anda instal, masukkan java -version dan
// javac -version pada baris perintah.
// nomor versi program anda akan dicetak di terminal (misal. 1.8.0_73)

// A closer look at the Hello World program / Melihat lebih dekat program Hello
// World

// Program "Hello World" berisi 1 file, yg terdiri dari definisi kelas
// HelloWorld, metode utama, dan pernyataan di dalam metode utama.

// public class HelloWorld {

// class keyword memulai definisi kelas untuk kelas bernama HelloWorld.
// setiap aplikasi java berisi setidaknya 1 definisi kelas (informasi lebih
// lanjut tentang classes).
// public static void main(String[] args) {

// ini adalah metode titik masuk (ditentukan oleh nama dan tanda tangan pulic
// static void main(String[])) dari mana JVM dapat menjalankan program anda.
// Setiap program Java harus memilikinya. Dia:

// public : artinya metode tersebut dapat dipanggil darimana saja artinya dari
// luar program juga. Lihat Visibilitas untuk informasi lebih lanjut tentang
// ini.

// static : artinya itu ada dan dapat dijalankan dengan sendirinya (ditingkat
// kelas tanpa membuat objek)

// void: artinya tidak mengembalikan nilai. Catatan: ini tidak seperti C dan C++
// dimana kode pengembalian seperti int di harapkan (cara java adalah
// System.exit()).

// Metode utama ini menerima:
// array (biasanya disebut args) dari string diteruskan sebagai argumen ke main
// function (misalnya dari baris perintah argumen).

// hampir semua ini diperlukan untuk metode titik masuk Java.
// Bagian yang tidak diperlukan:
// - Nama args adalah nama variabel, sehingga bisa disebut apapun yg anda
// inginkan, meskipun biasanya disebut arg
// - Apakah tipe parameternya adalah array (String[] args) atau Varrgs(String...
// args) tidak masalah karena array dapat diteruskan ke varargs.

// Catatan: 1 aplikasi mungkin memiliki banyak kelas yg berisi metode titik
// masuk (main). titik masuk dari aplikasi ditentukan oleh nama kelas yg
// diteruskan sebagai argumen ke perintah java.

// Di dalam metode utama(main method), kita melihat pernyataan berikut:
// System.out.println("Hello, World!");

// Mari kita uraikan pernyataan ini elemen demi elemen:
// element | Tujuan
// System | ini menunjukkan bahwa ekspresi selanjutnya akan memanggil kelas
// sistem dari java.lang package.

// . | ini adalah "operator titik(dot operator)". operator titik memberi anda
// akses ke anggota
// kelas 1; yaitu bidangnya (variabel) dan metode nya. dalam hal ini, operator
// titik ini memungkinkan anda merujuk bidang satis keluar di dalam kelas
// sitstem (System class).

// out | ini adalah nama field statis dari tipe PrintStream di dalam kelas
// System yg berisi fungsionalitas keluaran standar.

// . | ini adalah operator titik lainnya. operator titik ini menyediakan akses
// ke metode println di dalam variabel out

// println | ini adalah nama metode di dalam kelas PrintStream. metode ini
// khususnya mencetak isi parameter ke dalam konsol dan menyisipkan baris baru
// setelahnya.

// ( | tanda kurung ini menunjukkan bahwa metode sedang diakses (dan bukan
// bidang) dan memulai parameter yg diteruskan ke metode println.

// "Hello World" | ini adalah string literal yg diteruskan sebagai parameter, ke
// dalam metode println. tanda kutip ganda di setiap ujung membatasi teks
// sebagai sebuah String.

// ) | tanda kurung ini menandakan penutupan parameter yg diteruskan ke metode
// println

// ; | titik koma ini menandai akhir pernyataan.

// Catatan: setiap pernyataan di Java harus diakhiri dengan titik koma(;).

// method body dan class body kemudian ditutup.

// } // end of main function scope
// } // end of class HelloWorld scope
