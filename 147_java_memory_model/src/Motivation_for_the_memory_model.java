public class Motivation_for_the_memory_model {
    // Motivation for the Memory Model/Motivasi untuk Model Memori

    /*
     * Perhatikan contoh berikut:
     * public class Example {
     * public int a, b, c, d;
     * 
     * public void doIt() {
     * a = b + 1;
     * c = d + 1;
     * }
     * }
     */

    /*
     * Jika kelas ini yang digunakan adalah aplikasi single-thread, maka perilaku
     * yang dapat diamati akan persis seperti yang Anda inginkan
     * mengharapkan. Contohnya:
     * 
     * public class SingleThreaded {
     * public static void main(String[] args) {
     * Example eg = new Example();
     * System.out.println(eg.a + ", " + eg.c);
     * eg.doIt();
     * System.out.println(eg.a + ", " + eg.c);
     * }
     * }
     */

    // akan menghasilkan:
    /*
     * 0, 0
     * 1, 1
     */

    /*
     * Sejauh yang diketahui oleh thread "main", pernyataan dalam metode main() dan
     * metode doIt() akan dieksekusi sesuai urutan penulisannya dalam kode sumber.
     * Ini merupakan persyaratan yang jelas dari Spesifikasi Bahasa Java (JLS).
     * 
     * Sekarang pertimbangkan kelas yang sama yang digunakan dalam aplikasi
     * multi-thread.
     */

    /*
     * public class MultiThreaded {
     * public static void main(String[] args) {
     * final Example eg = new Example();
     * new Thread(new Runnable() {
     * public void run() {
     * while (true) {
     * eg.doIt();
     * }
     * }
     * }).start();
     * while (true) {
     * System.out.println(eg.a + ", " + eg.c);
     * }
     * }
     * }
     */

    // Apa yang akan dicetak ini?
    /*
     * Faktanya, menurut JLS tidak mungkin untuk memprediksi bahwa ini akan
     * mencetak:
     * 1. Anda mungkin akan melihat beberapa baris 0, 0 untuk memulai.
     * 2. Kemudian Anda mungkin melihat garis seperti N, N atau N, N+1.
     * 3. Anda mungkin melihat garis seperti N + 1, N.
     * 4. Secara teori, Anda mungkin melihat bahwa garis 0, 0 berlanjut selamanya1.
     */

    /*
     * 1 - Dalam praktiknya, kehadiran pernyataan println dapat menyebabkan
     * sinkronisasi dan
     * pembilasan cache memori. Hal ini mungkin menyembunyikan beberapa dampak yang
     * akan menyebabkan perilaku di atas.
     * 
     * Jadi bagaimana kita bisa menjelaskannya?
     */

    // Reordering of assignments/Penyusunan ulang tugas
    /*
     * Salah satu penjelasan yang mungkin untuk hasil yang tidak diharapkan adalah
     * kompiler JIT telah mengubah urutan penugasan dalam metode doIt(). JLS
     * mengharuskan pernyataan muncul untuk dieksekusi secara berurutan dari
     * perspektif thread saat ini. Dalam hal ini, tidak ada kode metode doIt() yang
     * dapat mengamati efek penataan ulang (hipotetis) dari kedua pernyataan
     * tersebut. Ini berarti kompiler JIT diizinkan untuk melakukan itu.
     * 
     * Mengapa ia melakukan hal itu?
     * Pada perangkat keras modern pada umumnya, instruksi mesin dieksekusi
     * menggunakan pipa instruksi yang memungkinkan urutan instruksi berada dalam
     * tahapan yang berbeda. Beberapa fase eksekusi instruksi memakan waktu lebih
     * lama dari yang lain,
     * dan operasi memori cenderung memakan waktu lebih lama. Kompiler cerdas dapat
     * mengoptimalkan throughput instruksi pada pipeline dengan mengurutkan
     * instruksi untuk memaksimalkan jumlah tumpang tindih. Hal ini dapat
     * menyebabkan eksekusi bagian-bagian pernyataan menjadi tidak berurutan. JLS
     * mengizinkan hal ini dengan syarat tidak mempengaruhi hasil perhitungan dari
     * perspektif thread saat ini.
     */

    // Effects of memory caches/Pengaruh cache memori

    /*
     * Penjelasan kedua yang mungkin adalah efek dari cache memori. Dalam arsitektur
     * komputer klasik, setiap prosesor memiliki
     * satu set register kecil, dan jumlah memori yang lebih besar. Akses ke
     * register jauh lebih cepat dibandingkan akses ke memori utama. Dalam
     * arsitektur modern, terdapat cache memori yang lebih lambat dari register,
     * namun lebih cepat dari memori utama.
     * 
     * Kompiler akan mengeksploitasi ini dengan mencoba menyimpan salinan variabel
     * di register, atau di cache memori. Jika suatu variabel tidak perlu
     * dipindahkan ke memori utama, atau tidak perlu dibaca dari memori, ada manfaat
     * kinerja yang signifikan jika tidak melakukan hal ini. Dalam kasus di mana JLS
     * tidak memerlukan operasi memori agar dapat dilihat
     * thread lain, kompiler Java JIT kemungkinan tidak akan menambahkan instruksi
     * "penghalang baca" dan "penghalang tulis" yang akan memaksa memori utama
     * membaca dan menulis. Sekali lagi, manfaat kinerja dari melakukan hal ini
     * sangatlah signifikan.
     */

    // Proper synchronization/Sinkronisasi yang tepat
    /*
     * Sejauh ini, kita telah melihat bahwa JLS memungkinkan kompiler JIT
     * menghasilkan kode yang membuat kode single-thread lebih cepat dengan menyusun
     * ulang atau menghindari operasi memori. Namun apa jadinya jika thread lain
     * dapat mengamati keadaan tersebut
     * variabel (bersama) di memori utama?
     * 
     * Jawabannya adalah, thread lain cenderung mengamati status variabel yang
     * tampaknya mustahil ...
     * berdasarkan urutan kode pernyataan Java. Solusinya adalah dengan menggunakan
     * sinkronisasi yang tepat. Tiga pendekatan utama tersebut adalah:
     */

    /*
     * 1. Menggunakan mutex primitif dan konstruksi synchronized.
     * 2. Menggunakan variabel volatile.
     * 3. Menggunakan dukungan konkurensi tingkat yang lebih tinggi; misalnya kelas
     * dalam paket Java.util.concurrent.
     */

    /*
     * Namun meskipun demikian, penting untuk memahami di mana sinkronisasi
     * diperlukan, dan efek apa yang dapat Anda andalkan. Di sinilah Model Memori
     * Java berperan.
     */

    // The Memory Model/Model Memori

    /*
     * Model Memori Java adalah bagian JLS yang menentukan kondisi di mana satu
     * thread dijamin melihat efek penulisan memori yang dilakukan oleh thread lain.
     * Model Memori ditentukan dengan tingkat ketelitian formal yang cukup, dan
     * (sebagai hasilnya) memerlukan pembacaan yang mendetail dan cermat untuk
     * memahaminya. Namun prinsip dasarnya adalah bahwa konstruksi tertentu
     * menciptakan hubungan "terjadi-sebelum" antara penulisan suatu variabel oleh
     * satu thread, dan pembacaan selanjutnya dari variabel yang sama oleh thread
     * lain. Jika relasi "terjadi sebelum" ada, kompiler JIT wajib menghasilkan kode
     * yang akan memastikan bahwa operasi baca melihat nilai yang ditulis oleh
     * tulis.
     * 
     * Berbekal hal ini, kita dapat mempertimbangkan koherensi memori dalam program
     * Java, dan memutuskan apakah hal ini akan terjadi
     * dapat diprediksi dan konsisten untuk semua platform eksekusi.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Example2 eg = new Example2();
        // System.out.println(eg.a + ", " + eg.c); // Output: 0, 0

        // eg.doIt();
        // System.out.println(eg.a + ", " + eg.c); // Output: 1, 1
        // ---------------------
        final Example2 eg = new Example2();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    eg.doIt();
                }
            }
        }).start();
        while (true) {
            System.out.println(eg.a + ", " + eg.c);
        }

        /*
         * output:
         * 1, 1
         * 1, 1
         * 1, 1
         * 1, 1
         * 1, 1
         * 1, 1
         * 1, 1
         * 1, 1
         * 1, 1
         */

    }
}
