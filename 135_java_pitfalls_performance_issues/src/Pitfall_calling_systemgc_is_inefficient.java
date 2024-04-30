public class Pitfall_calling_systemgc_is_inefficient {
    // Pitfall - Calling System.gc() is inefficient/Kesalahan - Memanggil
    // System.gc() tidak efisien

    /*
     * (hampir selalu) merupakan ide buruk untuk memanggil System.gc().
     * Javadoc untuk metode gc() menetapkan hal berikut:
     * 
     * "Memanggil metode gc menunjukkan bahwa Java Virtual Machine mengeluarkan upaya untuk mendaur ulang objek yang tidak terpakai agar memori yang ditempati saat ini tersedia untuk digunakan kembali dengan cepat. Ketika kontrol kembali dari pemanggilan metode, Java Virtual Machine telah melakukan upaya terbaik untuk mendapatkan kembali ruang dari semua benda yang dibuang."
     * 
     */

    /*
     * Ada beberapa poin penting yang dapat diambil dari sini:
     * 1. Penggunaan kata "suggests" daripada (mengatakan) "tells" berarti
     * JVM bebas mengabaikan saran tersebut.
     * Perilaku JVM default (rilis terkini) adalah mengikuti saran, tetapi ini dapat
     * ditimpa dengan mengatur -
     * XX:+DisableExplicitGC saat meluncurkan JVM.
     * 2. Ungkapan
     * "upaya terbaik untuk mendapatkan kembali ruang dari semua benda yang dibuang"
     * menyiratkan bahwa pemanggilan gc akan memicu pengumpulan sampah "penuh".
     */

    /*
     * Jadi mengapa memanggil System.gc() merupakan ide yang buruk?
     * Pertama, menjalankan pengumpulan sampah secara penuh itu mahal. GC lengkap
     * melibatkan kunjungan dan "menandai" setiap objek yang masih dapat dijangkau;
     * yaitu setiap benda yang bukan sampah. Jika Anda memicu ini saat tidak banyak
     * sampah yang harus dikumpulkan,
     * maka GC melakukan banyak pekerjaan dengan keuntungan yang relatif kecil.
     * 
     * Kedua, pengumpulan sampah secara menyeluruh dapat mengganggu sifat
     * “lokalitas” dari benda-benda yang tidak dikumpulkan.
     * Objek yang dialokasikan oleh thread yang sama pada waktu yang hampir
     * bersamaan cenderung dialokasikan berdekatan dalam memori. Ini bagus. Objek
     * yang dialokasikan pada waktu yang sama kemungkinan besar berhubungan; yaitu
     * saling merujuk.
     * Jika aplikasi Anda menggunakan referensi tersebut, maka kemungkinan besar
     * akses memori akan lebih cepat karena berbagai efek memori dan cache halaman.
     * Sayangnya, kumpulan sampah yang penuh cenderung memindahkan benda-benda
     * sehingga benda-benda yang dulunya berdekatan kini semakin berjauhan.
     */

    /*
     * Ketiga, menjalankan pengumpulan sampah secara penuh dapat menyebabkan
     * aplikasi Anda dijeda hingga pengumpulan sampah selesai.
     * Ketika hal ini terjadi, aplikasi Anda tidak akan responsif.
     * Faktanya, strategi terbaik adalah membiarkan JVM memutuskan kapan menjalankan
     * GC, dan jenis koleksi apa yang akan dijalankan. Jika Anda tidak ikut campur,
     * JVM akan memilih waktu dan jenis pengumpulan yang mengoptimalkan throughput
     * atau meminimalkan waktu jeda GC.
     * Pada awalnya kami berkata "... (hampir selalu) ide yang buruk...". Sebenarnya
     * ada beberapa skenario yang mungkin merupakan ide bagus:
     * 1. Jika Anda menerapkan pengujian unit untuk beberapa kode yang sensitif
     * terhadap pengumpulan sampah (misalnya sesuatu yang melibatkan finalizer atau
     * referensi lemah/lunak/hantu) maka pemanggilan System.gc() mungkin diperlukan.
     * 2. Dalam beberapa aplikasi interaktif, mungkin ada titik waktu tertentu di
     * mana pengguna tidak akan peduli jika ada jeda pengumpulan sampah. Salah satu
     * contohnya adalah permainan di mana terdapat jeda alami dalam "permainannya";
     * misalnya saat memuat level baru.
     */

    public static void main(String[] args) throws Exception {
    }
}
