import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class threadpoolexecutor {
    // ThreadPoolExecutor

    /*
     * Executor yang umum digunakan adalah ThreadPoolExecutor, yang menangani
     * penanganan Thread. Anda dapat mengonfigurasi
     * jumlah minimal Thread yang harus dipertahankan oleh pelaksana ketika tidak
     * banyak yang harus dilakukan (ini disebut ukuran inti)
     * dan ukuran Thread maksimal yang dapat digunakan untuk mengembangkan Pool,
     * jika ada lebih banyak pekerjaan yang harus dilakukan. Ketika beban kerja
     * berkurang,
     * Pool secara perlahan mengurangi jumlah Thread lagi hingga mencapai ukuran
     * minimum.
     */

    /*
     * ThreadPoolExecutor pool = new ThreadPoolExecutor(
     * 1, // keep at least one thread ready,
     * // even if no Runnables are executed
     * 5, // at most five Runnables/Threads
     * // executed in parallel
     * 1, TimeUnit.MINUTES, // idle Threads terminated after one
     * // minute, when min Pool size exceeded
     * new ArrayBlockingQueue<Runnable>(10)); // outstanding Runnables are kept here
     * pool.execute(new Runnable() {
     * 
     * @Override public void run() {
     * //code to run
     * }
     * });
     * 
     */

    /*
     * Catatan Jika Anda mengkonfigurasi ThreadPoolExecutor dengan antrian tak
     * terbatas, maka jumlah thread tidak akan melebihi
     * corePoolSize karena thread baru hanya dibuat jika antriannya penuh:
     */

    // ThreadPoolExecutor dengan semua parameter:
    /*
     * ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
     * TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory
     * threadFactory,
     * RejectedExecutionHandler handler)
     */

    // dari javadoc

    /*
     * Jika ada lebih dari corePoolSize tetapi kurang dari maksimumPoolSize thread
     * yang berjalan, new thread akan dibuat hanya jika antrian sudah penuh.
     */

    // keuntungan:
    /*
     * 1. Ukuran BlockingQueue dapat dikontrol dan skenario kehabisan memori dapat
     * dihindari. Performa aplikasi tidak akan menurun dengan ukuran antrean
     * terbatas.
     * 2. Anda dapat menggunakan kebijakan Penangan Penolakan yang sudah ada atau
     * membuat yang baru.
     */

    /*
     * 1. Dalam ThreadPoolExecutor.AbortPolicy default, handler menampilkan runtime
     * RejectedExecutionException setelah penolakan.
     * 2. Di ThreadPoolExecutor.CallerRunsPolicy, thread yang memanggil eksekusi
     * sendiri akan menjalankan tugas. Hal ini memberikan mekanisme kontrol umpan
     * balik sederhana yang akan memperlambat laju penyerahan tugas baru.
     * 3. Di ThreadPoolExecutor.DiscardPolicy, tugas yang tidak dapat dijalankan
     * akan dibuang begitu saja.
     * 4. Di ThreadPoolExecutor.DiscardOldestPolicy, jika eksekutor tidak dimatikan,
     * tugas di awal antrian pekerjaan akan dihapus, lalu eksekusi dicoba ulang
     * (yang dapat gagal lagi, sehingga menyebabkan hal ini terulang kembali.)
     */

    /*
     * 3. Custom ThreadFactory dapat dikonfigurasi, yang berguna :
     * 
     * 1. Untuk menetapkan nama thread yang lebih deskriptif
     * 2. Untuk mengatur status daemon thread
     * 3. Untuk mengatur prioritas thread
     */

    // Berikut adalah contoh cara menggunakan ThreadPoolExecutor
    // -----------------------------------------------

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1, // keep at least one thread ready,
                   // even if no Runnables are executed
                5, // at most five Runnables/Threads
                   // executed in parallel
                1, TimeUnit.MINUTES, // idle Threads terminated after one
                // minute, when min Pool size exceeded
                new ArrayBlockingQueue<Runnable>(10)); // outstanding Runnables are kept here
        pool.execute(new Runnable() {
            @Override
            public void run() {
                // code to run
                System.out.println("Hello from Runnable!");
            }
        });

        // Menutup pool saat selesai
        pool.shutdown();

        /*
         * output:
         * Hello from Runnable!
         */

    }
}
