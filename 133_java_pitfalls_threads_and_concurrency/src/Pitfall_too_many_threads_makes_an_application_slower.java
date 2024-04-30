public class Pitfall_too_many_threads_makes_an_application_slower {
    // Pitfall - Too many threads makes an application slower/Kesalahan - Terlalu
    // banyak thread membuat aplikasi menjadi lebih lambat

    /*
     * Banyak orang yang baru mengenal multi-threading berpikir bahwa penggunaan
     * thread secara otomatis membuat aplikasi berjalan
     * lebih cepat. Faktanya, ini jauh lebih rumit dari itu. Namun satu hal yang
     * dapat kami nyatakan dengan pasti adalah hal itu untuk siapa pun
     * komputer ada batasan jumlah thread yang dapat dijalankan secara bersamaan:
     * 1. Komputer memiliki jumlah inti (atau hyperthread) yang tetap.
     * 2. Thread Java harus dijadwalkan ke core atau hyperthread agar dapat
     * berjalan.
     * 3. Jika ada lebih banyak thread Java yang dapat dijalankan daripada
     * core/hyperthread (yang tersedia), beberapa di antaranya harus menunggu
     * 
     * Hal ini memberitahu kita bahwa hanya dengan membuat lebih banyak thread Java
     * tidak dapat membuat aplikasi berjalan semakin cepat. Tetapi
     * ada pertimbangan lain juga:
     * 1. Setiap thread memerlukan wilayah memori off-heap untuk tumpukan threadnya.
     * Ukuran tumpukan thread yang khas (default) adalah
     * 512Kbyte atau 1Mbyte. Jika Anda memiliki jumlah thread yang banyak,
     * penggunaan memori bisa menjadi signifikan.
     * 2. Setiap thread yang aktif akan merujuk ke sejumlah objek di heap. Hal ini
     * meningkatkan rangkaian kerja objek yang dapat dijangkau, yang berdampak pada
     * pengumpulan sampah dan penggunaan memori fisik.
     * 3. Biaya overhead peralihan antar thread tidaklah sepele. Biasanya ini
     * memerlukan peralihan ke ruang kernel OS untuk membuat keputusan penjadwalan
     * thread.
     * 4. Biaya tambahan sinkronisasi thread dan pensinyalan antar-thread (misalnya
     * wait(), notify() / notifyAll) dapat menjadi signifikan.
     */

    /*
     * Tergantung pada detail aplikasi Anda, faktor-faktor ini umumnya berarti bahwa
     * terdapat "titik terbaik" untuk jumlah rangkaian pesan. Selain itu,
     * menambahkan lebih banyak thread hanya memberikan peningkatan kinerja yang
     * minimal, dan dapat menghasilkan
     * kinerja lebih buruk.
     * 
     * Jika aplikasi Anda dibuat untuk setiap tugas baru, maka terjadi peningkatan
     * beban kerja yang tidak terduga (misalnya tingkat permintaan yang tinggi)
     * dapat menyebabkan perilaku bencana.
     * 
     * Cara yang lebih baik untuk mengatasi hal ini adalah dengan menggunakan
     * kumpulan thread terbatas yang ukurannya dapat Anda kendalikan (secara statis
     * atau dinamis).
     * Ketika ada terlalu banyak pekerjaan yang harus dilakukan, aplikasi perlu
     * mengantri permintaan. Jika Anda menggunakan ExecutorService, ini akan
     * menangani manajemen kumpulan thread dan antrian tugas.
     */

    public static void main(String[] args) throws Exception {

    }
}
