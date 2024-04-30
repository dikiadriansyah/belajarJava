public class Creating_and_reading_stacktraces {
    // Creating and reading stacktraces/Membuat dan membaca stacktraces

    /*
     * Ketika objek pengecualian dibuat (yaitu saat new), konstruktor
     * Throwable menangkap informasi tentang konteks di mana pengecualian tersebut
     * dibuat. Nantinya, informasi ini dapat dikeluarkan dalam bentuk stacktrace,
     * yang dapat digunakan untuk membantu mendiagnosis masalah yang menyebabkan
     * pengecualian tersebut.
     */

    // Printing a stacktrace/Mencetak pelacakan tumpukan

    /*
     * Mencetak stacktrace hanyalah masalah memanggil metode printStackTrace().
     * Misalnya:
     * try {
     * int a = 0;
     * int b = 0;
     * int c = a / b;
     * } catch (ArithmeticException ex) {
     * // This prints the stacktrace to standard output
     * ex.printStackTrace();
     * }
     */

    /*
     * Metode printStackTrace() tanpa argumen akan mencetak ke output standar
     * aplikasi; yaitu arus Sistem.out. Ada juga kelebihan
     * printStackTrace(PrintStream) dan printStackTrace(PrintWriter) yang mencetak
     * ke Stream atau Writer tertentu.
     */

    // Catatan:
    /*
     * 1. Stacktrace tidak menyertakan detail pengecualian itu sendiri. Anda dapat
     * menggunakan metode toString() untuk mendapatkannya rincian tersebut; misalnya
     * 
     * // Cetak exception and stacktrace
     * Sistem.out.println(ex);
     * ex.printStackTrace();
     * 
     * 2. Pencetakan stacktrace harus digunakan dengan hemat; lihat Pitfall -
     * Stacktrace yang berlebihan atau tidak tepat. Seringkali lebih baik
     * menggunakan kerangka logging, dan meneruskan objek pengecualian untuk
     * dicatat.
     */

    // Understanding a stacktrace/Memahami stacktrace

    /*
     * Perhatikan program sederhana berikut yang terdiri dari dua kelas dalam dua
     * file. (Kami telah menunjukkan nama file dan menambahkan nomor baris untuk
     * tujuan ilustrasi.)
     */

    /*
     * File: "Main.java"
     * 1 public class Main {
     * 2 public static void main(String[] args) {
     * 3 new Test().foo();
     * 4 }
     * 5 }
     * File: "Test.java"
     * 1 class Test {
     * 2 public void foo() {
     * 3 bar();
     * 4 }
     * 5
     * 6 public int bar() {
     * 7 int a = 1;
     * 8 int b = 0;
     * 9 return a / b;
     * 10 }
     */

    // Ketika file-file ini dikompilasi dan dijalankan, kita akan mendapatkan output
    // berikut.
    /*
     * Exception in thread "main" java.lang.ArithmeticException: / by zero
     * at Test.bar(Test.java:9)
     * at Test.foo(Test.java:3)
     * at Main.main(Main.java:3)
     */

    /*
     * Mari kita baca baris ini satu per satu untuk mencari tahu apa yang
     * disampaikannya kepada kita.
     * 
     * Line #1 tells us that the thread called "main" has terminated due to an
     * uncaught exception. The full name of the
     * exception is java.lang.ArithmeticException, and the exception message is
     * "/ by zero".
     */

    /*
     * Jika kita mencari javadocs untuk pengecualian ini, dikatakan:
     * Dilempar ketika kondisi aritmatika yang luar biasa telah terjadi. Misalnya,
     * bilangan bulat "divide by zero" menampilkan turunan kelas ini.
     */

    /*
     * Memang benar, pesan "/ by zero" merupakan petunjuk kuat bahwa penyebab
     * pengecualian tersebut adalah beberapa kode telah mencoba membagi sesuatu
     * dengan zero. Tapi apa?
     * 
     * 3 baris sisanya adalah jejak tumpukan. Setiap baris mewakili panggilan metode
     * (atau konstruktor) pada tumpukan panggilan, dan masing-masing memberi tahu
     * kita tiga hal:
     * 
     * 1. nama kelas dan metode yang sedang dieksekusi,
     * 2. nama file kode sumber,
     * 3. nomor baris kode sumber dari pernyataan yang sedang dieksekusi
     * 
     */

    /*
     * Baris-baris pelacakan tumpukan ini dicantumkan dengan bingkai untuk panggilan
     * saat ini di bagian atas. Bingkai teratas dalam contoh kita di atas ada dalam
     * metode Test.bar, dan pada baris 9 file Test.java. Itu adalah baris berikut:
     * return a / b;
     */

    /*
     * Jika kita melihat beberapa a baris sebelumnya di file tempat b
     * diinisialisasi, terlihat jelas bahwa b akan bernilai nol. Kita dapat
     * mengatakan tanpa keraguan bahwa ini adalah penyebab pengecualian tersebut.
     * 
     * Jika kita perlu melangkah lebih jauh, kita dapat melihat dari stacktrace
     * bahwa bar() dipanggil dari foo() pada baris 3 Test.java,
     * dan foo() itu pada gilirannya dipanggil dari Main.main().
     */

    /*
     * Catatan: Nama kelas dan metode dalam bingkai tumpukan adalah nama internal
     * kelas dan metode. Anda perlu mengenali kasus-kasus tidak biasa berikut ini:
     * 1. Kelas bersarang atau kelas dalam akan terlihat seperti
     * "OuterClass$InnerClass".
     * 
     * 2. Kelas dalam anonim akan terlihat seperti "OuterClass$1", "OuterClass$2",
     * dan sebagainya.
     * 
     * 3. Ketika kode dalam konstruktor, penginisialisasi bidang instans, atau blok
     * penginisialisasi instans sedang dijalankan, maka nama metodenya adalah "".
     * 
     * 4. Ketika kode dalam penginisialisasi bidang statis atau blok
     * penginisialisasi statis dieksekusi, nama metodenya adalah "".
     */

    /*
     * (Dalam beberapa versi Java, kode pemformatan stacktrace akan mendeteksi dan
     * menghilangkan urutan stackframe yang berulang, seperti yang dapat terjadi
     * ketika aplikasi gagal karena rekursi yang berlebihan.)
     */

    // Exception chaining and nested stacktraces/Rangkaian pengecualian dan
    // pelacakan tumpukan bertumpuk
    // Version ≥ Java SE 1.4

    /*
     * Rangkaian pengecualian terjadi ketika sepotong kode menangkap pengecualian,
     * lalu membuat dan melemparkan yang baru,
     * melewatkan pengecualian pertama sebagai penyebabnya. Berikut ini contohnya:
     * 
     * File: Test,java
     * 1 public class Test {
     * 2 int foo() {
     * 3 return 0 / 0;
     * 4 }
     * 5
     * 6 public Test() {
     * 7 try {
     * 8 foo();
     * 9 } catch (ArithmeticException ex) {
     * 10 throw new RuntimeException("A bad thing happened", ex);
     * 11 }
     * 12 }
     * 13
     * 14 public static void main(String[] args) {
     * 15 new Test();
     * 16 }
     * 17 }
     * 
     */

    // Ketika kelas di atas dikompilasi dan dijalankan, kita mendapatkan stacktrace
    // berikut:
    /*
     * Exception in thread "main" java.lang.RuntimeException: A bad thing happened
     * at Test.<init>(Test.java:10)
     * at Test.main(Test.java:15)
     * Caused by: java.lang.ArithmeticException: / by zero
     * at Test.foo(Test.java:3)
     * at Test.<init>(Test.java:8)
     * ... 1 more
     * 
     */

    /*
     * Stacktrace dimulai dengan nama kelas, metode, dan tumpukan panggilan untuk
     * pengecualian yang (dalam hal ini) menyebabkan
     * aplikasi mogok. Ini diikuti dengan baris "Disebabkan oleh:" yang melaporkan
     * pengecualian penyebab. Nama kelas dan
     * pesan dilaporkan, diikuti dengan frame tumpukan pengecualian penyebab.
     * Jejaknya diakhiri dengan "... N more" yang mana
     * menunjukkan bahwa N frame terakhir sama dengan pengecualian sebelumnya.
     */

    /*
     * "Disebabkan oleh:" hanya disertakan dalam output ketika penyebab pengecualian
     * utama bukan nol). Pengecualian bisa saja terjadi
     * dirantai tanpa batas waktu, dan dalam hal ini pelacakan tumpukan dapat
     * memiliki beberapa jejak "Disebabkan oleh:".
     * 
     * Catatan: mekanisme penyebab hanya terungkap di Throwable API di Java 1.4.0.
     * Sebelum itu, rangkaian pengecualian perlu diterapkan oleh aplikasi
     * menggunakan bidang pengecualian khusus untuk mewakili penyebabnya, dan bidang
     * pengecualian khusus
     * metode printStackTrace
     */

    // Capturing a stacktrace as a String/Menangkap stacktrace sebagai String

    /*
     * Terkadang, suatu aplikasi harus mampu menangkap stacktrace sebagai String
     * Java, sehingga dapat digunakan untuk hal lain tujuan. Pendekatan umum untuk
     * melakukan hal ini adalah dengan membuat OutputStream atau Writer sementara
     * yang menulis ke buffer memori dan meneruskannya ke printStackTrace(...).
     * 
     * Pustaka Apache Commons dan Guava menyediakan metode utilitas untuk menangkap
     * stacktrace sebagai String:
     * org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(Throwable)
     * com.google.common.base.Throwables.getStackTraceAsString(Throwable)
     */

    /*
     * Jika Anda tidak dapat menggunakan perpustakaan pihak ketiga di basis kode
     * Anda, maka metode berikut dapat melakukan tugas tersebut:
     * 
     * //Returns the string representation of the stack trace.
     * //@param throwable the throwable
     * //@return the string.
     *
     * public static String stackTraceToString(Throwable throwable) {
     * StringWriter stringWriter = new StringWriter();
     * throwable.printStackTrace(new PrintWriter(stringWriter));
     * return stringWriter.toString();
     * }
     * 
     */

    /*
     * Perhatikan bahwa jika tujuan Anda adalah menganalisis pelacakan tumpukan,
     * akan lebih mudah menggunakan getStackTrace() dan getCause() daripada mencoba
     * menguraikan pelacakan tumpukan.
     */

    public static void main(String[] args) {
        // try {
        // int a = 0;
        // int b = 0;
        // int c = a / b;
        // } catch (ArithmeticException ex) {
        // // This prints the stacktrace to standard output
        // ex.printStackTrace();
        // }
        /*
         * output:
         * java.lang.ArithmeticException: / by zero
         * at your.package.YourClassName.main(YourClassName.java: lineNumber)
         */
        // ---------------------
        new Test().foo();
        /*
         * output:
         * xception in thread "main" java.lang.ArithmeticException: / by zero
         * at Test.bar(Test.java:9)
         * at Test.foo(Test.java:3)
         */
    }
}
