public class Visualizing_read_write_barriers_while_using_synchronized_volatile {
    /*
     * Visualizing read/write barriers while using synchronized / volatile /
     * Memvisualisasikan hambatan baca/tulis saat menggunakan
     * tersinkronisasi/volatil
     */

    /*
     * Seperti yang kita ketahui bahwa kita harus menggunakan kata kunci
     * synchronized untuk membuat eksekusi suatu metode atau blok menjadi
     * eksklusif. Namun hanya sedikit dari kita yang mungkin tidak menyadari satu
     * aspek penting lagi dalam menggunakan kata kunci synchronized dan mudah
     * menguap: selain membuat unit kode menjadi atom, ini juga memberikan
     * penghalang baca/tulis. Apa hambatan baca/tulis ini? Mari kita bahas ini
     * menggunakan sebuah contoh:
     * 
     * class Counter {
     * private Integer count = 10;
     * public synchronized void incrementCount() {
     * count++;
     * }
     * public Integer getCount() {
     * return count;
     * }
     * }
     */

    /*
     * Misalkan thread A memanggil incrementCount() terlebih dahulu, lalu thread B
     * lainnya memanggil getCount(). Dalam skenario ini tidak ada jaminan bahwa B
     * akan melihat nilai hitungan yang diperbarui. Mungkin masih melihat hitungan
     * sebagai 10, bahkan mungkin juga tidak pernah melihat nilai hitungan yang
     * diperbarui.
     * 
     * Untuk memahami perilaku ini kita perlu memahami bagaimana model memori Java
     * terintegrasi dengan arsitektur perangkat keras. Di Java, setiap thread
     * memiliki tumpukan threadnya sendiri. Tumpukan ini berisi: tumpukan panggilan
     * metode dan variabel lokal yang dibuat di thread itu. Dalam sistem multi inti,
     * sangat mungkin dua thread berjalan secara bersamaan dalam inti yang terpisah.
     * Dalam skenario seperti itu ada kemungkinan bahwa bagian dari tumpukan thread
     * terletak di dalam register/cache suatu inti. Jika di dalam thread, sebuah
     * objek diakses menggunakan kata kunci synchronized (atau volatile),
     * setelah blok synchronized, thread tersebut menyinkronkan salinan lokal
     * variabel tersebut dengan memori utama. Ini menciptakan hambatan baca/tulis
     * dan membuat
     * yakin bahwa thread melihat nilai terbaru dari objek itu.
     * 
     * Namun dalam kasus kami, karena thread B belum menggunakan akses
     * tersinkronisasi untuk menghitung, ini mungkin merujuk pada nilai hitungan
     * disimpan dalam register dan mungkin tidak pernah melihat pembaruan dari
     * thread A. Untuk memastikan bahwa B melihat nilai hitungan terbaru, kita perlu
     * membuat getCount() disinkronkan juga.
     */

    /*
     * public synchronized Integer getCount() {
     * return count;
     * }
     */

    /*
     * Sekarang ketika thread A selesai dengan memperbarui jumlah, ia membuka
     * Counter instance, pada saat yang sama menciptakan penghalang tulis dan
     * menghapus semua perubahan yang dilakukan di dalam blok itu ke memori utama.
     * Demikian pula ketika thread B memperoleh kunci pada instance Counter yang
     * sama, ia masuk ke dalam penghalang baca dan membaca nilai hitungan dari
     * memori utama dan melihat semua pembaruan
     */

    /*
     * Efek visibilitas yang sama juga berlaku untuk pembacaan/penulisan yang mudah
     * berubah. Semua variabel yang diperbarui sebelum menulis ke volatile akan
     * dipindahkan ke memori utama dan semua pembacaan setelah pembacaan variabel
     * volatile akan berasal dari memori utama.
     */

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Increment count using synchronized method
        counter.incrementCount();

        // Get count
        Integer count = counter.getCount();
        System.out.println("Count: " + count); // Output: Count: 11
    }
}
