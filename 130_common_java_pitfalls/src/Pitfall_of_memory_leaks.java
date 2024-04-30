import java.math.BigDecimal;
import java.util.Deque;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pitfall_of_memory_leaks {
    // Pitfall: memory leaks/Jebakan: kebocoran memori

    /*
     * Java mengelola memori secara otomatis. Anda tidak perlu mengosongkan memori
     * secara manual. Memori suatu objek di
     * heap dapat dibebaskan oleh pengumpul sampah ketika objek tidak lagi dapat
     * dijangkau oleh thread aktif.
     * 
     * Namun, Anda dapat mencegah pembebasan memori dengan mengizinkan objek yang
     * tidak diperlukan lagi dapat dijangkau. Baik Anda menyebutnya sebagai
     * kebocoran memori atau kebocoran memori, hasilnya tetap sama -- peningkatan
     * alokasi memori yang tidak perlu.
     * 
     * Kebocoran memori di Java dapat terjadi dengan berbagai cara, namun alasan
     * paling umum adalah referensi objek yang kekal,
     * karena pengumpul sampah tidak dapat menghapus objek dari tumpukan selama
     * masih ada referensi ke objek tersebut.
     */

    // Static fields/Bidang statis
    /*
     * Seseorang dapat membuat referensi seperti itu dengan mendefinisikan kelas
     * dengan bidang static yang berisi beberapa kumpulan objek, dan
     * lupa menyetel bidang static itu ke null setelah koleksi tidak lagi
     * diperlukan. bidang static dianggap sebagai akar GC dan tidak pernah
     * dikumpulkan. Masalah lainnya adalah kebocoran memori non-heap saat JNI
     * digunakan.
     */

    // Classloader leak/Kebocoran pemuat kelas
    /*
     * Namun sejauh ini, jenis kebocoran memori yang paling berbahaya adalah
     * kebocoran classloader. Sebuah classloader menyimpan referensi ke setiap kelas
     * yang dimuatnya, dan setiap kelas menyimpan referensi ke classloadernya.
     * Setiap objek juga memiliki referensi ke kelasnya. Oleh karena itu, bahkan
     * jika satu objek dari suatu kelas yang dimuat oleh pemuat kelas bukanlah
     * sampah, tidak satu pun kelas yang dimuat oleh pemuat kelas tersebut dapat
     * dikumpulkan. Karena setiap kelas juga mengacu pada bidang statisnya, bidang
     * tersebut juga tidak dapat dikumpulkan.
     */

    // Kebocoran akumulasi Contoh kebocoran akumulasi dapat terlihat seperti
    // berikut:
    /*
     * final ScheduledExecutorService scheduledExecutorService =
     * Executors.newScheduledThreadPool(1);
     * final Deque<BigDecimal> numbers = new LinkedBlockingDeque<>();
     * final BigDecimal divisor = new BigDecimal(51);
     * scheduledExecutorService.scheduleAtFixedRate(() -> {
     * BigDecimal number = numbers.peekLast();
     * if (number != null && number.remainder(divisor).byteValue() == 0) {
     * System.out.println("Number: " + number);
     * System.out.println("Deque size: " + numbers.size());
     * }
     * }, 10, 10, TimeUnit.MILLISECONDS);
     * scheduledExecutorService.scheduleAtFixedRate(() -> {
     * numbers.add(new BigDecimal(System.currentTimeMillis()));
     * }, 10, 10, TimeUnit.MILLISECONDS);
     * try {
     * scheduledExecutorService.awaitTermination(1, TimeUnit.DAYS);
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     */

    /*
     * Contoh ini membuat dua tugas terjadwal. Tugas pertama mengambil numbers
     * terakhir dari deque yang disebut angka, dan, jika
     * bilangan tersebut habis dibagi 51, ia mencetak bilangan dan ukuran deque.
     * Tugas kedua memasukkan angka ke dalam
     * deque. Kedua tugas dijadwalkan dengan kecepatan tetap, dan dijalankan setiap
     * 10 ms.
     * 
     * Jika kode dijalankan, Anda akan melihat bahwa ukuran deque meningkat secara
     * permanen. Hal ini pada akhirnya akan menyebabkan deque diisi dengan objek
     * yang menghabiskan semua memori heap yang tersedia.
     * 
     * Untuk mencegah hal ini sambil menjaga semantik program ini, kita dapat
     * menggunakan metode lain untuk mengambil angka
     * dari deque: pollLast. Bertentangan dengan metode peekLast, pollLast
     * mengembalikan elemen dan menghapusnya
     * deque sementara peekLast hanya mengembalikan elemen terakhir.
     */

    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        final Deque<BigDecimal> numbers = new LinkedBlockingDeque<>();
        final BigDecimal divisor = new BigDecimal(51);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            BigDecimal number = numbers.peekLast();
            if (number != null && number.remainder(divisor).byteValue() == 0) {
                System.out.println("Number: " + number);
                System.out.println("Deque size: " + numbers.size());
            }
        }, 10, 10, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            numbers.add(new BigDecimal(System.currentTimeMillis()));
        }, 10, 10, TimeUnit.MILLISECONDS);
        try {
            scheduledExecutorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Number: 1710220938135
         * Deque size: 4
         * Number: 1710220939155
         * Deque size: 106
         * Number: 1710220939716
         * Deque size: 162
         * Number: 1710220939869
         * Deque size: 177
         * Number: 1710220940226
         * Deque size: 213
         * Number: 1710220941093
         * Deque size: 299
         * Number: 1710220941450
         * Deque size: 335
         */

    }
}
