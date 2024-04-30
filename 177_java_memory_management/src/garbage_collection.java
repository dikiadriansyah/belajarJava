public class garbage_collection {
    // Garbage collection/Pengumpulan sampah

    // The C++ approach - new and delete/Pendekatan C++ - baru dan hapus

    /*
     * Dalam bahasa seperti C++, program aplikasi bertanggung jawab untuk mengelola
     * memori yang digunakan oleh memori yang dialokasikan secara dinamis. Ketika
     * sebuah objek dibuat di heap C++ menggunakan new operator, perlu ada
     * penggunaan operator delete yang sesuai untuk membuang objek tersebut:
     * 1. Jika program lupa menghapus suatu objek dan hanya "melupakannya", memori
     * terkait akan hilang ke aplikasi. Istilah untuk situasi ini adalah kebocoran
     * memori, dan jika terlalu banyak kebocoran memori, aplikasi dapat menggunakan
     * lebih banyak memori, dan akhirnya crash.
     * 2. Sebaliknya, jika suatu aplikasi mencoba menghapus objek yang sama sebanyak
     * dua kali, atau menggunakan suatu objek setelah objek tersebut dihapus, maka
     * aplikasi tersebut kemungkinan besar akan crash karena masalah kerusakan
     * memori.
     * 
     * Dalam program C++ yang rumit, penerapan manajemen memori menggunakan new dan
     * delete dapat memakan waktu lama.
     * Memang benar, manajemen memori adalah sumber bug yang umum.
     */

    // The Java approach - garbage collection/Pendekatan Java - pengumpulan sampah
    /*
     * Java mengambil pendekatan yang berbeda. Alih-alih operator delete
     * eksplisit, Java menyediakan mekanisme otomatis
     * dikenal sebagai pengumpulan sampah untuk mendapatkan kembali memori yang
     * digunakan oleh objek yang tidak lagi diperlukan. Sistem runtime Java
     * bertanggung jawab untuk menemukan objek yang akan dibuang. Tugas ini
     * dilakukan oleh komponen yang disebut pengumpul sampah(garbage collector),
     * atau disingkat GC.
     * 
     * Kapan pun selama eksekusi program Java, kita dapat membagi kumpulan semua
     * objek yang ada menjadi dua subset1 yang berbeda:
     */

    // 1. Objek yang dapat dijangkau didefinisikan oleh JLS sebagai berikut:
    // Objek yang dapat dijangkau adalah objek apa pun yang dapat diakses dalam
    // potensi komputasi berkelanjutan dari thread aktif mana pun.

    /*
     * Dalam praktiknya, ini berarti ada rantai referensi yang dimulai dari variabel
     * lokal dalam cakupan atau static variabel yang dengannya beberapa kode mungkin
     * dapat menjangkau objek.
     */

    // 2. Benda yang tidak terjangkau adalah benda yang tidak mungkin dijangkau
    // seperti
    // diatas.

    /*
     * Objek apa pun yang tidak dapat dijangkau memenuhi syarat untuk pengumpulan
     * sampah. Ini tidak berarti bahwa mereka akan menjadi sampah yang dikumpulkan.
     * Nyatanya:
     * 
     * 1. Objek yang tidak terjangkau tidak langsung dikumpulkan setelah menjadi
     * tidak terjangkau1.
     * 2. Objek yang tidak terjangkau tidak boleh dikumpulkan sampahnya.
     */

    /*
     * Spesifikasi bahasa Java memberikan banyak keleluasaan pada implementasi JVM
     * untuk memutuskan kapan harus mengumpulkan objek yang tidak dapat dijangkau.
     * Ini juga (dalam praktiknya) memberikan izin bagi implementasi JVM untuk
     * bersikap konservatif dalam mendeteksi objek yang tidak dapat dijangkau.
     * 
     * Satu hal yang dijamin oleh JLS adalah tidak akan ada objek yang dapat
     * dijangkau yang dikumpulkan sampahnya.
     */

    // What happens when an object becomes unreachable/Apa yang terjadi ketika suatu
    // objek menjadi tidak terjangkau

    /*
     * Pertama-tama, tidak ada yang terjadi secara spesifik ketika suatu objek
     * menjadi tidak dapat dijangkau. Hal-hal hanya terjadi ketika pengumpul sampah
     * berjalan dan mendeteksi bahwa objek tersebut tidak dapat dijangkau. Selain
     * itu, proses GC biasanya tidak mendeteksi semua objek yang tidak dapat
     * dijangkau.
     * Saat GC mendeteksi objek yang tidak dapat dijangkau, kejadian berikut dapat
     * terjadi.
     * 1. Jika ada objek Reference yang merujuk ke objek tersebut, referensi
     * tersebut akan dihapus sebelum objek tersebut dihapus.
     * 2. Jika objek tersebut dapat diselesaikan, maka objek tersebut akan
     * diselesaikan. Hal ini terjadi sebelum objek dihapus.
     * 3. Objek dapat dihapus, dan memori yang ditempati dapat diperoleh kembali.
     */

    /*
     * Perhatikan bahwa ada urutan yang jelas di mana peristiwa di atas dapat
     * terjadi, tetapi tidak ada yang memerlukan pengumpul sampah
     * untuk melakukan penghapusan akhir objek tertentu dalam jangka waktu tertentu.
     */

    // Examples of reachable and unreachable objects/Contoh benda yang terjangkau
    // dan tidak terjangkau

    // Perhatikan contoh kelas berikut:
    /*
     * // A node in simple "open" linked-list.
     * public class Node {
     * private static int counter = 0;
     * public int nodeNumber = ++counter;
     * public Node next;
     * }
     * public class ListTest {
     * public static void main(String[] args) {
     * test(); // M1
     * System.out.prinln("Done"); // M2
     * }
     * 
     * private static void test() {
     * Node n1 = new Node(); // T1
     * Node n2 = new Node(); // T2
     * Node n3 = new Node(); // T3
     * n1.next = n2; // T4
     * n2 = null; // T5
     * n3 = null; // T6
     * }
     * }
     */

    /*
     * Mari kita periksa apa yang terjadi ketika test() dipanggil. Pernyataan T1, T2
     * dan T3 membuat objek Node, dan objek
     * semuanya dapat dijangkau melalui variabel n1, n2 dan n3. Pernyataan T4
     * memberikan referensi ke Node ke-2
     * objek ke bidang berikutnya dari yang pertama. Ketika hal itu selesai, Node
     * ke-2 dapat dijangkau melalui dua jalur:
     * 
     * n2 -> Node2
     * n1 -> Node1, Node1.next -> Node2
     * 
     * 
     */

    /*
     * Dalam pernyataan T5, kami menetapkan null ke n2. Hal ini memutus rantai
     * keterjangkauan pertama untuk Node2, namun rantai keterjangkauan kedua tetap
     * tidak terputus, sehingga Node2 masih dapat dijangkau.
     * 
     * Dalam pernyataan T6, kami menetapkan null ke n3. Hal ini memutus satu-satunya
     * rantai keterjangkauan untuk Node3, yang menjadikan Node3
     * tidak dapat dijangkau. Namun, Node1 dan Node2 keduanya masih dapat dijangkau
     * melalui variabel n1.
     * 
     * Terakhir, ketika metode test() kembali, variabel lokalnya n1, n2 dan n3
     * keluar dari cakupan, dan karenanya tidak dapat diakses oleh apa pun. Hal ini
     * memutus rantai jangkauan yang tersisa untuk Node1 dan Node2, dan semua objek
     * Node juga tidak dapat dijangkau dan memenuhi syarat untuk pengumpulan sampah.
     * 
     * 1 - Ini adalah penyederhanaan yang mengabaikan finalisasi, dan kelas
     * Reference. 2 - Secara hipotetis, implementasi Java dapat melakukan hal ini,
     * namun biaya kinerja untuk melakukan hal ini membuatnya tidak praktis.
     */

}
