public class Pitfall_shared_variables_require_proper_synchronization implements Runnable {
    // Pitfall: Shared variables require proper synchronization/Kesalahan: Variabel
    // bersama memerlukan sinkronisasi yang tepat

    /*
     * Perhatikan contoh ini:
     * 
     * public class ThreadTest implements Runnable {
     * private boolean stop = false;
     * 
     * public void run() {
     * long counter = 0;
     * while (!stop) {
     * counter = counter + 1;
     * }
     * System.out.println("Counted " + counter);
     * }
     * public static void main(String[] args) {
     * ThreadTest tt = new ThreadTest();
     * new Thread(tt).start(); // Create and start child thread
     * Thread.sleep(1000);
     * tt.stop = true; // Tell child thread to stop.
     * }
     * }
     */

    /*
     * Maksud dari program ini adalah untuk memulai sebuah thread, membiarkannya
     * berjalan selama 1000 milidetik, dan kemudian menghentikannya dengan menyetel
     * stop flag.
     */

    // Will it work as intended?/Akankah ini berfungsi sebagaimana mestinya?

    /*
     * Mungkin ya mungkin tidak.
     * 
     * Sebuah aplikasi tidak serta merta berhenti ketika metode main kembali. Jika
     * thread lain telah dibuat, dan
     * thread tersebut belum ditandai sebagai thread daemon, maka aplikasi akan
     * terus berjalan setelah thread utama berakhir. Dalam contoh ini, artinya
     * aplikasi akan terus berjalan hingga thread turunan berakhir. Itu seharusnya
     * terjadi ketika tt.stop disetel ke true.
     * 
     * Namun hal tersebut sebenarnya tidak sepenuhnya benar. Faktanya, thread anak
     * akan berhenti setelah observed stop dengan nilai true.
     * Akankah itu terjadi? Mungkin ya mungkin tidak.
     * 
     * Spesifikasi Bahasa Java menjamin bahwa pembacaan dan penulisan memori yang
     * dilakukan di thread dapat dilihat oleh thread tersebut, sesuai urutan
     * pernyataan dalam kode sumber. Namun, secara umum, hal ini TIDAK dijamin
     * ketika satu thread menulis dan thread lainnya (selanjutnya) membaca. Untuk
     * mendapatkan visibilitas yang terjamin, perlu ada rangkaian hubungan
     * terjadi-sebelum antara penulisan dan pembacaan berikutnya. Pada contoh di
     * atas, tidak ada rantai seperti itu
     * untuk pembaruan pada tanda stop, dan oleh karena itu tidak ada jaminan bahwa
     * thread anak akan melihat perubahan stop menjadi true.
     */

    /*
     * (Catatan untuk penulis: Harus ada Topik terpisah tentang Model Memori Java
     * untuk membahas detail teknis yang mendalam.)
     */

    // How do we fix the problem?/Bagaimana cara kita memperbaiki masalahnya?

    /*
     * Dalam hal ini, ada dua cara sederhana untuk memastikan bahwa pembaruan yang
     * dihentikan terlihat:
     * 1. Menyatakan berhenti sebagai hal volatile; yaitu
     * private volatile boolean stop = false;
     * 
     * Untuk variabel volatile, JLS menetapkan bahwa ada hubungan terjadi-sebelum
     * antara penulisan satu per satu
     * thread dan kemudian dibaca oleh thread kedua.
     * 
     * 2. Gunakan mutex untuk melakukan sinkronisasi sebagai berikut:
     * 
     * public class ThreadTest implements Runnable {
     * private boolean stop = false;
     * 
     * public void run() {
     * long counter = 0;
     * while (true) {
     * synchronize (this) {
     * if (stop) {
     * break;
     * }
     * }
     * counter = counter + 1;
     * }
     * System.out.println("Counted " + counter);
     * }
     * public static void main(String[] args) {
     * ThreadTest tt = new ThreadTest();
     * new Thread(tt).start(); // Create and start child thread
     * Thread.sleep(1000);
     * synchronize (tt) {
     * tt.stop = true; // Tell child thread to stop.
     * }
     * }
     * }
     */

    /*
     * Selain memastikan bahwa ada saling pengecualian, JLS menetapkan bahwa ada
     * hubungan terjadi-sebelum antara melepaskan mutex di satu thread dan
     * mendapatkan mutex yang sama di thread kedua.
     */

    // But isn't assignment atomic?/Namun bukankah penugasannya bersifat atomik?
    /*
     * Ya itu!
     * Namun, fakta tersebut tidak berarti bahwa efek pembaruan akan terlihat secara
     * bersamaan di semua thread. Hanya rangkaian hubungan yang terjadi sebelum
     * hubungan yang tepat akan menjamin hal itu.
     */

    // Why did they do this?/Mengapa mereka melakukan ini?

    /*
     * Pemrogram yang melakukan pemrograman multi-thread di Java untuk pertama
     * kalinya menganggap Model Memori itu menantang.
     * Program berperilaku tidak intuitif karena ekspektasi alaminya adalah
     * penulisan terlihat secara seragam. Jadi mengapa para desainer Java mendesain
     * Model Memori dengan cara ini.
     * 
     * Ini sebenarnya merupakan kompromi antara kinerja dan kemudahan penggunaan
     * (untuk programmer).
     * 
     * Arsitektur komputer modern terdiri dari beberapa prosesor (inti) dengan
     * kumpulan register individual. Memori utama dapat diakses oleh semua prosesor
     * atau kelompok prosesor. Properti lain dari perangkat keras komputer modern
     * adalah bahwa akses ke register biasanya lebih cepat diakses daripada akses ke
     * memori utama. Seiring bertambahnya jumlah inti, mudah untuk melihat bahwa
     * membaca dan menulis ke memori utama dapat menjadi hambatan utama kinerja
     * sistem.
     * 
     * Ketidakcocokan ini diatasi dengan menerapkan satu atau lebih tingkat cache
     * memori antara inti prosesor dan memori utama. Setiap inti mengakses sel
     * memori melalui cache-nya. Biasanya, pembacaan memori utama hanya terjadi
     * ketika ada cache yang hilang, dan penulisan memori utama hanya terjadi ketika
     * baris cache perlu dikosongkan. Untuk aplikasi yang set lokasi memori
     * masing-masing inti akan masuk ke dalam cache-nya, kecepatan inti tidak lagi
     * dibatasi oleh kecepatan/bandwidth memori utama.
     * 
     * Tapi itu memberi kita masalah baru ketika banyak inti membaca dan menulis
     * variabel bersama. Versi terbaru dari suatu variabel mungkin berada di cache
     * satu inti. Kecuali jika inti tersebut membuang baris cache ke memori utama,
     * DAN inti lainnya membatalkan salinan cache versi lama, beberapa di antaranya
     * cenderung melihat versi variabel yang sudah basi. Tetapi jika cache
     * dipindahkan ke memori setiap kali ada penulisan cache ("untuk berjaga-jaga"
     * ada pembacaan oleh orang lain
     * core) yang akan menghabiskan bandwidth memori utama secara tidak perlu.
     * 
     * Solusi standar yang digunakan pada tingkat set instruksi perangkat keras
     * adalah dengan memberikan instruksi untuk pembatalan cache dan penulisan
     * cache, dan menyerahkannya kepada kompiler untuk memutuskan kapan akan
     * menggunakannya.
     * 
     * Kembali ke Java. Model Memori dirancang sedemikian rupa sehingga kompiler
     * Java tidak perlu mengeluarkan pembatalan cache dan instruksi penulisan jika
     * sebenarnya tidak diperlukan. Asumsinya adalah pemrogram akan menggunakan
     * mekanisme sinkronisasi yang sesuai (misalnya mutex primitif, volatile, kelas
     * konkurensi tingkat tinggi, dan sebagainya) untuk menunjukkan bahwa pemrogram
     * memerlukan visibilitas memori. Dengan tidak adanya kejadian sebelumnya
     * kaitannya, kompiler Java bebas berasumsi bahwa tidak diperlukan operasi cache
     * (atau serupa).
     * 
     * Hal ini memiliki keuntungan kinerja yang signifikan untuk aplikasi
     * multi-thread, namun kelemahannya adalah menulis aplikasi multi-thread yang
     * benar bukanlah hal yang mudah. Pemrogram memang harus memahami apa yang dia
     * lakukan.
     */

    // Why can't I reproduce this?/Mengapa saya tidak dapat mereproduksi ini?

    /*
     * Ada sejumlah alasan mengapa masalah seperti ini sulit untuk direproduksi:
     * 1. Seperti dijelaskan di atas, konsekuensi dari tidak menangani masalah
     * visibilitas memori dengan benar biasanya adalah aplikasi yang Anda kompilasi
     * tidak menangani cache memori dengan benar. Namun, seperti yang telah kami
     * singgung di atas, cache memori sering kali tetap dihapus.
     * 2. Saat Anda mengubah platform perangkat keras, karakteristik cache memori
     * dapat berubah. Hal ini dapat menyebabkan perilaku berbeda jika aplikasi Anda
     * tidak melakukan sinkronisasi dengan benar.
     * 3. Anda mungkin mengamati efek sinkronisasi yang tidak disengaja. Misalnya,
     * jika Anda menambahkan jejak, biasanya ada beberapa sinkronisasi yang terjadi
     * di belakang layar dalam aliran I/O yang menyebabkan pengosongan cache.
     * Jadi menambahkan jejak jejak sering kali menyebabkan aplikasi berperilaku
     * berbeda.
     * 4. Menjalankan aplikasi di bawah debugger menyebabkannya dikompilasi secara
     * berbeda oleh kompiler JIT.
     * Breakpoint dan loncatan tunggal memperburuk hal ini. Efek ini sering kali
     * mengubah cara aplikasi berperilaku.
     */

    /*
     * Hal-hal ini membuat bug yang disebabkan oleh sinkronisasi yang tidak memadai
     * menjadi sangat sulit untuk dipecahkan.
     */

    // ----------------------
    // private boolean stop = false;

    // public void run() {
    // long counter = 0;
    // while (!stop) {
    // counter = counter + 1;
    // }
    // System.out.println("Counted " + counter);
    // }
    // ----------------------
    private boolean stop = false;

    public void run() {
        long counter = 0;
        while (true) {
            synchronized (this) {
                if (stop) {
                    break;
                }
            }
            counter = counter + 1;
        }
        System.out.println("Counted " + counter);
    }

    public static void main(String[] args) throws Exception {
        Pitfall_shared_variables_require_proper_synchronization box = new Pitfall_shared_variables_require_proper_synchronization();
        // new Thread(box).start();
        // Thread.sleep(1000);
        // box.stop = true;

        // --------------------
        new Thread(box).start(); // Create and start child thread
        Thread.sleep(1000);
        synchronized (box) {
            box.stop = true; // Tell child thread to stop.
        }
        /*
         * output:
         * Counted 803336369
         */

    }
}
