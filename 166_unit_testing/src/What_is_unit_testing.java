public class What_is_unit_testing {
    // What is Unit Testing?/Apa itu Pengujian Unit?

    /*
     * Ini sedikit dasar. Sebagian besar dimasukkan karena dokumentasi dipaksa untuk
     * memiliki contoh, meskipun itu dimaksudkan sebagai artikel rintisan. Jika Anda
     * sudah mengetahui dasar-dasar pengujian unit, silakan langsung saja ke
     * komentar, yang menyebutkan kerangka kerja spesifik.
     * 
     * Pengujian unit memastikan bahwa modul tertentu berperilaku seperti yang
     * diharapkan. Dalam aplikasi skala besar, memastikan eksekusi modul yang tepat
     * dalam ruang hampa merupakan bagian integral dari memastikan fidelitas
     * aplikasi.
     * 
     * Perhatikan contoh semu (sepele) berikut:
     * 
     * public class Example {
     * public static void main (String args[]) {
     * new Example();
     * }
     * // Application-level test.
     * public Example() {
     * Consumer c = new Consumer();
     * System.out.println("VALUE = " + c.getVal());
     * }
     * // Your Module.
     * class Consumer {
     * private Capitalizer c;
     * public Consumer() {
     * c = new Capitalizer();
     * }
     * public String getVal() {
     * return c.getVal();
     * }
     * }
     * // Another team's module.
     * class Capitalizer {
     * private DataReader dr;
     * public Capitalizer() {
     * dr = new DataReader();
     * }
     * public String getVal() {
     * return dr.readVal().toUpperCase();
     * }
     * }
     * // Another team's module.
     * class DataReader {
     * public String readVal() {
     * // Refers to a file somewhere in your application deployment, or
     * // perhaps retrieved over a deployment-specific network.
     * File f;
     * String s = "data";
     * // ... Read data from f into s ...
     * return s;
     * }
     * }
     * }
     * 
     * 
     * 
     * 
     */

    /*
     * Jadi contoh ini adalah hal yang sepele; DataReader mengambil data dari sebuah
     * file, meneruskannya ke Capitalizer, yang mengubah semua karakter menjadi
     * huruf besar, yang kemudian diteruskan ke Konsumen. Namun DataReader sangat
     * terkait dengan lingkungan aplikasi kami, jadi kami menunda pengujian rantai
     * ini hingga kami siap untuk menerapkan rilis pengujian.
     * 
     * Sekarang, asumsikan, di suatu tempat dalam proses rilis, karena alasan yang
     * tidak diketahui, metode getVal() di Capitalizer
     * diubah dari mengembalikan String toUpperCase() menjadi String toLowerCase():
     * 
     * // Another team's module.
     * class Capitalizer {
     * //...
     * public String getVal() {
     * return dr.readVal().toLowerCase();
     * }
     * }
     * 
     */

    /*
     * Jelas, hal ini merusak perilaku yang diharapkan. Namun, karena proses sulit
     * yang terkait dengan eksekusi DataReader, kami tidak akan menyadarinya hingga
     * penerapan pengujian berikutnya. Jadi berhari-hari/minggu/bulan berlalu dengan
     * bug ini ada di sistem kami, dan kemudian manajer produk melihatnya, dan
     * langsung menghubungi Anda, pemimpin tim yang terkait dengan Konsumen.
     * “Mengapa ini terjadi? Apa yang kalian ubah?” Jelas sekali, Anda tidak tahu
     * apa-apa. Anda tidak tahu apa yang sedang terjadi. Anda tidak mengubah kode
     * apa pun yang seharusnya menyentuh ini; kenapa tiba-tiba rusak?
     * 
     * Akhirnya, setelah diskusi antar tim dan kolaborasi, masalah tersebut
     * ditelusuri dan masalah terselesaikan. Tetapi,
     * itu menimbulkan pertanyaan; bagaimana hal ini bisa dicegah?
     * 
     * Ada dua hal yang jelas:
     * 
     */

    // Tests need to be automated/Pengujian perlu diotomatisasi

    /*
     * Ketergantungan kami pada pengujian manual membiarkan bug ini berlalu terlalu
     * lama tanpa disadari. Kami memerlukan cara untuk mengotomatiskan proses
     * munculnya bug secara instan. Bukan 5 minggu dari sekarang. Bukan 5 hari dari
     * sekarang. Tidak 5 menit dari sekarang.
     * Sekarang.
     * 
     * Anda harus menghargai bahwa, dalam contoh ini, saya telah mengungkapkan satu
     * bug yang sangat sepele yang diperkenalkan dan
     * tanpa disadari. Dalam aplikasi industri, dengan lusinan modul yang terus
     * diperbarui, modul ini dapat menyebar ke mana-mana. Anda memperbaiki sesuatu
     * dengan satu modul, hanya untuk menyadari bahwa perilaku yang Anda "perbaiki"
     * diandalkan dalam beberapa cara di tempat lain (baik secara internal maupun
     * eksternal).
     * 
     * Tanpa validasi yang ketat, segala sesuatunya akan menyusup ke dalam sistem.
     * Ada kemungkinan bahwa, jika diabaikan, hal ini akan mengakibatkan begitu
     * banyak upaya ekstra untuk mencoba memperbaiki perubahan (dan kemudian
     * memperbaiki perbaikan tersebut, dll.), sehingga suatu produk akan benar-benar
     * meningkatkan sisa pekerjaan seiring dengan upaya yang dilakukan. Anda tidak
     * ingin berada dalam situasi ini.
     */

    // Tests need to be fine-grained/Pengujian harus dilakukan secara menyeluruh

    /*
     * Masalah kedua yang dicatat dalam contoh di atas adalah jumlah waktu yang
     * diperlukan untuk melacak bug. Manajer produk mengirimi Anda pesan ketika
     * penguji menyadarinya, Anda menyelidiki dan menemukan bahwa Capitalizer
     * mengembalikan data yang tampaknya buruk, Anda mengirim pesan ke tim
     * Capitalizer dengan temuan Anda, mereka menyelidikinya, dll.
     * 
     * Hal yang sama yang saya sampaikan di atas tentang kuantitas dan kesulitan
     * contoh sepele ini berlaku di sini. Jelas siapa pun yang cukup berpengalaman
     * dengan Java dapat menemukan masalah yang muncul dengan cepat. Namun
     * seringkali jauh lebih sulit untuk melacak dan mengkomunikasikan
     * permasalahannya. Mungkin tim Capitalizer memberi Anda JAR tanpa sumber.
     * Mungkin
     * mereka berlokasi di belahan dunia lain, dan jam komunikasi sangat terbatas
     * (mungkin hanya email yang dikirim sekali sehari). Hal ini dapat menyebabkan
     * bug membutuhkan waktu berminggu-minggu atau lebih lama untuk dilacak (dan,
     * sekali lagi, mungkin ada beberapa bug pada rilis tertentu).
     * 
     * Untuk memitigasi hal ini, kami menginginkan pengujian yang ketat pada tingkat
     * yang sehalus mungkin (Anda juga ingin pengujian yang terperinci untuk
     * memastikan modul berinteraksi dengan benar, namun itu bukan titik fokus kami
     * di sini). Kami ingin secara ketat menentukan bagaimana semua fungsi yang
     * menghadap ke luar (minimal) beroperasi, dan menguji fungsi tersebut
     */

    // Enter unit-testing/Masuk ke pengujian unit

    /*
     * Bayangkan jika kita melakukan pengujian, khususnya memastikan bahwa metode
     * getVal() dari Capitalizer mengembalikan string dengan huruf kapital untuk
     * string input tertentu. Lebih jauh lagi, bayangkan pengujian tersebut
     * dijalankan bahkan sebelum kita melakukan kode apa pun. Bug yang dimasukkan ke
     * dalam sistem (yaitu, toUpperCase() diganti dengan toLowerCase()) tidak akan
     * menimbulkan masalah karena bug tidak akan pernah dimasukkan ke dalam sistem.
     * Kami akan mengujinya, pengembang (mudah-mudahan) akan menyadari kesalahan
     * mereka, dan solusi alternatif akan dicapai tentang bagaimana menerapkan efek
     * yang diinginkan.
     * 
     * Ada beberapa kelalaian yang dibuat di sini mengenai cara mengimplementasikan
     * pengujian ini, namun hal tersebut tercakup dalam dokumentasi khusus kerangka
     * kerja (ditautkan dalam komentar). Mudah-mudahan, ini bisa menjadi contoh
     * mengapa pengujian unit itu penting.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        new What_is_unit_testing();
        // output:
        // VALUE = DATA
    }

    // Application-level test.
    public What_is_unit_testing() {
        Consumer3 c = new Consumer3();
        System.out.println("VALUE = " + c.getVal());
    }

}
