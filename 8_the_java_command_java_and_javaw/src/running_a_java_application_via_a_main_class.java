public class running_a_java_application_via_a_main_class {
    // Running a Java applications via a "main" class / Menjalankan aplikasi Java
    // melalui kelas "utama".

    // Saat aplikasi belum dikemas sebagai JAR yang dapat dieksekusi, Anda perlu
    // memberikan nama titik masuk kelas pada baris perintah java

    // Running the HelloWorld class / Menjalankan kelas HelloWorld
    // Contoh "HelloWorld" dijelaskan dalam Membuat program Java baru. Ini terdiri
    // dari satu kelas yang disebut HelloWorld yang memenuhi persyaratan untuk titik
    // masuk

    // Dengan asumsi bahwa file (dikompilasi) "HelloWorld.class" ada di direktori
    // saat ini, dapat diluncurkan sebagai berikut:
    // java HelloWorld

    // Beberapa hal penting yang perlu diperhatikan adalah:
    // - We must provide the name of the class: not the pathname for the ".class"
    // file or the ".java" file. / Kita harus memberikan nama kelas: bukan nama
    // jalur untuk file ".class" atau file ".java"

    // - If the class is declared in a package (as most Java classes are), then the
    // class name we supply to the java command must be the full classname. For
    // instance if SomeClass is declared in the com.example package, then the full
    // classname will be com.example.SomeClass / jika kelas dideklarasikan dalam
    // sebuah paket(seperti kebanyakan kelas Java), maka nama kelas yang kami
    // berikan ke kelas java perintah harus nama kelas lengkap (full classname).
    // misalnya, jika SomeClass dideklarasikan dalam paket com.example, maka nama
    // kelas lengkapnya adalah com.example.SomeClass.

    // Specifying a classpath
    // kecuali jika kita menggunakan sintaks perintah java -jar, perintah java
    // mencari kelas yang akan dimuat mencari classpath; lihat jalur
    // kelas(Classpath). perintah diatas mengandalkan classpath default yang (atau
    // termasuk) direktori saat ini. kita bisa lebih eksplisit tentang ini dengan
    // menentukan classpath yang akan digunakan menggunakan -cp option.

    // java -cp . HelloWorld

    // Ini mengatakan untuk menjadikan direktori saat ini (yang mengacu pada ".")
    // satu-satunya entri di classpath.

    // -cp adalah opsi yang diproses oleh perintah java. Semua opsi yang ditujukan
    // untuk perintah java harus sebelum nama kelas (classname). apapun setelah
    // kelas akan diperlakukan sebagai argumen baris perintah untuk aplikasi Java,
    // dan akan diteruskan ke aplikasi dalam String[] yang diteruskan ke main
    // method.

    // (jika tidak ada opsi -cp, java akan menggunakan classpath yang diberikan oleh
    // variabel lingkungan CLASSPATH. jika variabel itu tidak disetel atau kosong,
    // java menggunakan "." sebagai jalur kelas default)

}
