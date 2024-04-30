import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Use_cases_for_different_types_of_concurrency_construct {
    // Use cases for different types of concurrency constructs/Gunakan kasus untuk
    // berbagai jenis konstruksi konkurensi

    // 1. ExecutorService
    /*
     * ExecutorService executor = Executors.newFixedThreadPool(50);
     * 
     * Ini sederhana dan mudah digunakan. Itu menyembunyikan detail tingkat rendah
     * dari ThreadPoolExecutor.
     * 
     * Saya lebih suka yang ini ketika jumlah tugas Callable/Runnable sedikit dan
     * penumpukan tugas dalam antrian tak terbatas tidak menambah memori &
     * menurunkan kinerja sistem. Jika Anda memiliki kendala CPU/Memori, saya lebih
     * suka menggunakan ThreadPoolExecutor dengan batasan kapasitas &
     * RejectedExecutionHandler untuk menangani penolakan tugas.
     */

    // 2. CountDownLatch
    /*
     * CountDownLatch akan diinisialisasi dengan hitungan tertentu. Jumlah ini
     * dikurangi dengan panggilan ke metode countDown(). Thread yang menunggu
     * hitungan mencapai nol dapat memanggil salah satu metode await(). Memanggil
     * await() memblokir thread hingga hitungan mencapai nol. Kelas ini
     * memungkinkan thread java menunggu hingga rangkaian thread lain menyelesaikan
     * tugasnya.
     */

    /*
     * Kasus penggunaan:
     * 1. Mencapai Paralelisme Maksimum: Terkadang kita ingin memulai sejumlah
     * thread secara bersamaan untuk mencapai paralelisme maksimum
     * 2. Tunggu N thread selesai sebelum memulai eksekusi
     * 3. Deteksi kebuntuan.
     */

    /*
     * 3. ThreadPoolExecutor : Memberikan kontrol lebih besar. Jika aplikasi
     * dibatasi oleh jumlah tugas Runnable/Callable yang tertunda, Anda dapat
     * menggunakan antrian terbatas dengan mengatur kapasitas maksimal. Setelah
     * antrean mencapai kapasitas maksimum, Anda dapat menentukan RejectionHandler.
     * Java menyediakan empat jenis kebijakan RejectedExecutionHandler.
     */

    /*
     * 1. ThreadPoolExecutor.AbortPolicy, handler menampilkan runtime
     * RejectedExecutionException setelah penolakan.
     * 2. ThreadPoolExecutor.CallerRunsPolicy`, thread yang memanggil eksekusi
     * sendiri akan menjalankan tugas. Hal ini memberikan mekanisme kontrol umpan
     * balik sederhana yang akan memperlambat laju penyerahan tugas baru.
     * 3. Di ThreadPoolExecutor.DiscardPolicy, tugas yang tidak dapat dijalankan
     * akan dibuang begitu saja.
     * 4. ThreadPoolExecutor.DiscardOldestPolicy, jika eksekutor tidak dimatikan,
     * tugas di awal antrian pekerjaan akan dihapus, lalu eksekusi dicoba ulang
     * (yang dapat gagal lagi, menyebabkan hal ini terulang kembali.)
     */

    // Jika Anda ingin mensimulasikan perilaku CountDownLatch, Anda dapat
    // menggunakan metode invokeAll().

    /*
     * 4. Satu lagi mekanisme yang tidak Anda kutip adalah ForkJoinPool
     * 
     * ForkJoinPool telah ditambahkan ke Java di Java 7. ForkJoinPool mirip dengan
     * Java ExecutorService tetapi dengan satu perbedaan. ForkJoinPool memudahkan
     * tugas untuk membagi pekerjaannya menjadi tugas-tugas yang lebih kecil yang
     * kemudian diserahkan ke ForkJoinPool juga. Pencurian tugas terjadi di
     * ForkJoinPool ketika thread pekerja bebas mencuri tugas dari antrian thread
     * pekerja yang sibuk.
     * 
     * Java 8 telah memperkenalkan satu API lagi di ExecutorService untuk membuat
     * kumpulan pencurian pekerjaan. Anda tidak perlu membuat
     * RecursiveTask dan RecursiveAction tetapi masih bisa menggunakan ForkJoinPool.
     * 
     * public static ExecutorService newWorkStealingPool()
     */

    // Membuat kumpulan thread yang mencuri pekerjaan menggunakan semua prosesor
    // yang tersedia sebagai tingkat paralelisme targetnya.

    // Secara default, ini akan menggunakan jumlah inti CPU sebagai parameter

    /*
     * Keempat mekanisme ini saling melengkapi satu sama lain. Bergantung pada
     * tingkat perincian yang ingin Anda kontrol, Anda harus memilih yang benar.
     */

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(50);

        // Submit tasks to the executor
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                // Task to be executed
                System.out.println("Executing task...");
            });
        }

        // Shutdown the executor to terminate all threads after all tasks are done
        executor.shutdown();
        /*
         * output:
         * Executing task...
         * Executing task...
         * Executing task...
         * Executing task...
         * Executing task...
         * Executing task...
         * Executing task...
         * Executing task...
         * Executing task...
         * Executing task...
         */
    }
}
