public class troubleshooting_the_java_command {
    // Troubleshooting the 'java' command / Memecahkan masalah perintah 'Java'

    // contoh ini mencakup kesalahan umum dengan menggunakan perintah 'java'
    // "Command not found" / "Perintah tidak ditemukan"

    // Jika Anda mendapatkan pesan kesalahan seperti:

    // java: command not found

    // ketika mencoba menjalankan perintah java, ini berarti tidak ada perintah java
    // di pencarian perintah shell Anda jalur. Penyebabnya bisa:
    // - you don't have a Java JRE or JDK installed at all / Anda tidak menginstal
    // Java JRE atau JDK sama sekali
    // - you have not updated the PATH environment variable (correctly) in your
    // shell initialization file, or / Anda belum memperbarui variabel lingkungan
    // PATH (dengan benar) di file inisialisasi shell Anda, atau
    // - you have not "sourced" the relevant initialization file in the current
    // shell. / anda belum "mendapatkan" file inisialisasi yang relevan di shell
    // saat ini.

    // Refer to "Installing Java" for the steps that you need to take. / Rujuk ke
    // "Menginstal Java" untuk langkah-langkah yang perlu Anda lakukan

    // "Could not find or load main class" / "Tidak dapat menemukan atau memuat
    // kelas utama"

    // pesan kesalahan ini dikeluarkan oleh perintah java jika tidak dapat
    // menemukan/memuat kelas entry-point yang anda telah ditentukan.
    // Secara umum, ada tiga alasan luas mengapa hal ini dapat terjadi:

    // - Anda telah menentukan kelas titik masuk yang tidak ada
    // - Kelas itu ada, tetapi Anda salah menentukannya.
    // - Kelas tersebut ada dan Anda telah menentukannya dengan benar, tetapi Java
    // tidak dapat menemukannya karena jalur kelasnya salah.

    // Berikut adalah prosedur untuk mendiagnosis dan menyelesaikan masalah:
    // 1. Cari tahu nama lengkap kelas entry-point.
    // - Jika Anda memiliki kode sumber untuk suatu kelas, maka nama lengkapnya
    // terdiri dari nama paket dan nama kelas sederhana. misalnya kelas "Main"
    // dideklarasikan dalam package "com.example.myapp" maka nama lengkapnya adalah
    // "com.example.myapp.Main".
    // - jika anda memiliki file kelas yang dikompilasi anda dapat menemukan nama
    // kelas dengan menjalankan javap di dalamnya
    // - jika file kelas ada di direktori, anda dapat menyimpulkan nama kelas
    // lengkap dari nama direktori
    // - Jika file kelas berada dalam file JAR atau ZIP, Anda dapat menyimpulkan
    // nama lengkap kelas dari jalur file di file JAR atau ZIP.

    // 2. Lihatlah pesan kesalahan dari perintah java.
    // - Periksa apakah itu sama persis dengan nama kelas lengkap untuk kelas
    // entry-point.
    // - It should not end with ".java" or ".class". / Seharusnya tidak diakhiri
    // dengan ".java" atau ".class".
    // - It should not contain slashes or any other character that is not legal in a
    // Java identifier1. / Seharusnya tidak mengandung garis miring atau karakter
    // lain yang tidak sah dalam pengidentifikasi Java1.
    // - Casing nama harus sama persis dengan nama kelas lengkap.

    // 3. Jika Anda menggunakan nama kelas yang benar, pastikan kelas tersebut
    // benar-benar ada di jalur kelas:
    // - Work out the pathname that the classname maps to; see Mapping classnames to
    // pathnames / Cari tahu nama jalur yang dipetakan oleh nama kelas; lihat
    // Memetakan nama kelas ke nama jalur
    // - Work out what the classpath is; see this example: Different ways to specify
    // the classpath / Cari tahu apa itu classpath; lihat contoh ini: Berbagai cara
    // untuk menentukan classpath

    // - Look at each of the JAR and ZIP files on the classpath to see if they
    // contain a class with the required pathname / Lihat masing-masing file JAR dan
    // ZIP di classpath untuk melihat apakah file tersebut berisi class yang
    // diperlukan nama path
    // - Look at each directory to see if the pathname resolves to a file within the
    // directory. / Lihatlah setiap direktori untuk melihat apakah pathname
    // menyelesaikan file di dalam direktori.

    // jika memeriksa classpath secara manual tidak menemukan masalah, anda dapat
    // menambahkan opsi -Xdiag dan -XshowSetting.
    // Yang pertama mencantumkan semua kelas yang dimuat, dan yang terakhir mencetak
    // pengaturan yang menyertakan classpath efektif untuk JVM.

    // akhirnya, ada beberapa penyebab yang tidak jelas untuk masalah ini:
    // - An executable JAR file with a Main-Class attribute that specifies a class
    // that does not exist. / File JAR yang dapat dieksekusi dengan atribut
    // Main-Class yang menentukan kelas yang tidak ada.
    // - An executable JAR file with an incorrect Class-Path attribute. / File JAR
    // yang dapat dieksekusi dengan atribut Class-Path yang salah
    // - If you mess up2 the options before the classname, the java command may
    // attempt to interpret one of them as the classname. / Jika Anda mengacaukan 2
    // opsi sebelum nama kelas, perintah java mungkin mencoba menafsirkan salah
    // satunya sebagai nama kelas
    // - If someone has ignored Java style rules and used package or class
    // identifiers that differ only in letter case,
    // and you are running on a platform that treats letter case in filenames as
    // non-significant. / Jika seseorang telah mengabaikan aturan gaya Java dan
    // menggunakan pengidentifikasi paket atau kelas yang hanya berbeda dalam huruf
    // kapital, dan Anda menjalankan platform yang menganggap huruf besar-kecil
    // dalam nama file sebagai tidak signifikan.
    // - Problems with homoglyphs in class names in the code or on the command line.
    // / Masalah dengan homoglyph pada nama kelas dalam kode atau baris perintah.

    // "Main method not found in class <name>" / "Metode utama tidak ditemukan di
    // kelas <nama>"

    // masalah ini terjadi ketika perintah java dapat menemukan dan memuat kelas
    // yang anda pilih, tetapi kemudian tidak dapat menemukan metode titik masuk.

    // Ada tiga kemungkinan penjelasan:
    // - If you are trying to run an executable JAR file, then the JAR's manifest
    // has an incorrect "Main-Class" attribute. / Jika Anda mencoba menjalankan file
    // JAR yang dapat dieksekusi, maka manifes JAR memiliki atribut "Kelas Utama"
    // yang salah yang menentukan kelas yang bukan kelas titik masuk yang valid.

    // - that specifies a class that is not a valid entry point class. / yang
    // menentukan kelas yang bukan kelas titik masuk yang valid.
    // - You have told the java command a class that is not an entry point class. /
    // Anda telah memberi tahu perintah java sebuah kelas yang bukan merupakan kelas
    // titik masuk.
    // - The entry point class is incorrect; see Entry point classes for more
    // information. / Kelas titik masuk salah; lihat Kelas titik masuk untuk
    // informasi lebih lanjut.

    // Sumber Daya Lainnya
    // What does "Could not find or load main class" mean?
    // (http://stackoverflow.com/questions/18093928/what-does-could-not-find-or-load-main-class-mean)
    // (http://docs.oracle.com/javase/tutorial/getStarted/problems/index.html)

    // 1. Dari Java 8 dan yang lebih baru, perintah java akan membantu memetakan
    // pemisah nama file ("/" atau "") ke tanda titik (".").
    // 2. Kasus yang sangat tidak jelas adalah jika Anda menyalin dan menempelkan
    // perintah dari dokumen yang diformat di mana editor teks menggunakan "tanda
    // hubung panjang" alih-alih tanda hubung biasa.
}
