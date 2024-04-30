public class Deep_recursion_is_problematic_in_java {
    // Deep recursion is problematic in Java/Rekursi mendalam bermasalah di Java

    // Pertimbangkan metode naif berikut untuk menjumlahkan dua bilangan positif
    // menggunakan rekursi:
    /*
     * public static int add(int a, int b) {
     * if (a == 0) {
     * return b;
     * } else {
     * return add(a - 1, b + 1); // TAIL CALL
     * }
     * }
     */

    /*
     * Secara algoritmik ini benar, tetapi mempunyai masalah besar. Jika Anda
     * memanggil add dengan a besar, itu akan crash dengan StackOverflowError, pada
     * versi Java apa pun hingga (setidaknya) Java 9.
     * 
     * Dalam bahasa pemrograman fungsional yang khas (dan banyak bahasa lainnya),
     * kompiler mengoptimalkan rekursi ekor.
     * Kompiler akan menyadari bahwa panggilan untuk menambahkan (pada baris yang
     * diberi tag) adalah panggilan ekor, dan secara efektif akan menulis ulang
     * rekursi sebagai sebuah loop. Transformasi ini disebut eliminasi tail-call.
     * 
     * Namun, kompiler Java generasi saat ini tidak melakukan penghapusan tail call.
     * (Ini bukan kelalaian sederhana.
     * Ada alasan teknis yang kuat untuk hal ini; lihat di bawah.) Sebaliknya,
     * setiap panggilan add yang rekursif menyebabkan frame baru dialokasikan pada
     * tumpukan thread. Misalnya, jika Anda memanggil add(1000, 1), dibutuhkan 1000
     * panggilan rekursif untuk sampai pada jawaban 1001.
     * 
     * Masalahnya adalah ukuran tumpukan thread Java diperbaiki saat thread dibuat.
     * (Ini termasuk thread "utama" dalam program single-thread.) Jika terlalu
     * banyak frame tumpukan yang dialokasikan, tumpukan akan meluap. JVM akan
     * mendeteksi ini dan menampilkan StackOverflowError.
     * 
     * Salah satu pendekatan untuk mengatasi hal ini adalah dengan menggunakan
     * tumpukan yang lebih besar. Ada opsi JVM yang mengontrol ukuran default
     * tumpukan, dan Anda juga dapat menentukan ukuran tumpukan sebagai parameter
     * konstruktor Thread. Sayangnya, ini hanya "menunda" stack overflow. Jika Anda
     * perlu melakukan komputasi yang memerlukan tumpukan lebih besar,
     * StackOverflowError akan muncul kembali.
     * 
     * Solusi sebenarnya adalah dengan mengidentifikasi algoritma rekursif di mana
     * kemungkinan terjadi rekursi mendalam, dan secara manual melakukan optimasi
     * tail-call pada tingkat kode sumber. Misalnya, metode penambahan kami dapat
     * ditulis ulang sebagai berikut:
     * 
     * public static int add(int a, int b) {
     * while (a != 0) {
     * a = a - 1;
     * b = b + 1;
     * }
     * return b;
     * }
     */

    /*
     * (Jelas, ada cara yang lebih baik untuk menjumlahkan dua bilangan bulat. Hal
     * di atas hanyalah untuk mengilustrasikan efek eliminasi tail-call manual.)
     */

    // Mengapa penghapusan tail-call tidak diterapkan di Java (belum)
    /*
     * 1. Ada sejumlah alasan mengapa menambahkan penghapusan tail call ke Java
     * tidaklah mudah. Misalnya:
     * Beberapa kode dapat mengandalkan StackOverflowError untuk (misalnya)
     * membatasi ukuran masalah komputasi.
     * 2. Manajer keamanan Sandbox sering kali mengandalkan analisis tumpukan
     * panggilan
     * saat memutuskan apakah akan mengizinkan kode yang tidak memiliki hak istimewa
     * untuk melakukan tindakan yang memiliki hak istimewa.
     */

    // Seperti yang dijelaskan John Rose dalam "Panggilan ekor di VM":
    /*
     * "Efek dari penghapusan bingkai tumpukan pemanggil terlihat oleh beberapa API,
     * terutama pemeriksaan kontrol akses dan penelusuran tumpukan. Seolah-olah
     * penelepon dari pemanggil telah langsung menelepon penerima panggilan. Hak
     * istimewa apa pun yang dimiliki oleh pemanggil akan dibuang setelah kontrol
     * ditransfer ke callee Namun, keterkaitan dan aksesibilitas metode callee
     * dihitung sebelum transfer kendali, dan memperhitungkan pemanggil ekor."
     */

    /*
     * Dengan kata lain, penghapusan tail-call dapat menyebabkan metode kontrol
     * akses salah mengira bahwa API yang sensitif terhadap keamanan dipanggil
     * dengan kode tepercaya.
     */

    public static void main(String[] args) {
        Deep_recursion_is_problematic_in_java box = new Deep_recursion_is_problematic_in_java();
        int result = box.add(4, 7);
        System.out.println("Berikut hasil dari perhitungan diatas " + result);
        /*
         * output:
         * Berikut hasil dari perhitungan diatas 11
         */
    }

    // public static int add(int a, int b) {
    // if (a == 0) {
    // return b;
    // } else {
    // return add(a - 1, b + 1); // TAIL CALL
    // }
    // }
    // ------------------------
    public static int add(int a, int b) {
        while (a != 0) {
            a = a - 1;
            b = b + 1;
        }
        return b;
    }
}
