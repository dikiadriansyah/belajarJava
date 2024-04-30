import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Use_cases_for_different_types_of_executorservice {
    // Use cases for different types of ExecutorService/Kasus penggunaan untuk
    // berbagai jenis ExecutorService

    // Excutors mengembalikan berbagai jenis ThreadPools yang memenuhi kebutuhan
    // spesifik.

    // 1. public static ExecutorService newSingleThreadExecutor()
    // Membuat Executor yang menggunakan satu thread pekerja yang beroperasi dari
    // antrean tak terbatas

    /*
     * Ada perbedaan antara newFixedThreadPool(1) dan newSingleThreadExecutor()
     * seperti yang dikatakan oleh dokumen Java untuk yang terakhir:
     * 
     * Berbeda dengan newFixedThreadPool(1) yang setara, eksekutor yang dikembalikan
     * dijamin tidak dapat dikonfigurasi ulang untuk menggunakan thread tambahan.
     */

    /*
     * Artinya, newFixedThreadPool dapat dikonfigurasi ulang nanti di program
     * dengan:
     * ((ThreadPoolExecutor) fixedThreadPool).setMaximumPoolSize(10) Ini tidak
     * mungkin untuk newSingleThreadExecutor
     */

    // kasus pengguna:
    /*
     * 1. Anda ingin menjalankan tugas yang diserahkan secara berurutan.
     * 2. Anda hanya memerlukan satu Thread untuk menangani semua permintaan Anda
     */

    /*
     * Kontra:
     * 1. Antrean tanpa batas berbahaya
     */

    /*
     * 2. public static ExecutorService newFixedThreadPool(int nThreads)
     * Membuat kumpulan thread yang menggunakan kembali sejumlah thread yang
     * beroperasi dari antrian bersama yang tidak dibatasi. Kapan pun, paling banyak
     * thread nThreads akan menjadi tugas pemrosesan aktif. Jika tugas tambahan
     * dikirimkan ketika semua thread aktif, mereka akan menunggu dalam antrian
     * sampai thread tersedia
     */

    // Kasus penggunaan:
    /*
     * 1. Penggunaan inti yang tersedia secara efektif. Konfigurasikan nThreads
     * sebagai
     * Runtime.getRuntime().availableProcessors()
     * 2. Ketika Anda memutuskan bahwa jumlah thread tidak boleh melebihi nomor di
     * kumpulan thread
     */

    /*
     * Kontra:
     * 1. Antrean tanpa batas berbahaya.
     */

    // 3. public static ExecutorService newCachedThreadPool()
    /*
     * Membuat kumpulan thread yang membuat thread baru sesuai kebutuhan, tetapi
     * akan menggunakan kembali thread yang dibuat sebelumnya saat tersedia
     */

    /*
     * Kasus penggunaan:
     * 1. Untuk tugas asinkron yang berumur pendek
     */

    /*
     * Kekurangan:
     * 1. Antrean tanpa batas berbahaya.
     * 2. Setiap tugas baru akan membuat thread baru jika semua thread yang ada
     * sedang sibuk. Jika tugasnya memakan waktu lama
     * durasi, lebih banyak jumlah thread yang akan dibuat, yang akan menurunkan
     * kinerja sistem.
     * Alternatif dalam hal ini: newFixedThreadPool
     */

    // 4. public static ScheduledExecutorService newScheduledThreadPool(int
    // corePoolSize)

    /*
     * Membuat kumpulan thread yang dapat menjadwalkan perintah untuk dijalankan
     * setelah penundaan tertentu, atau untuk dijalankan secara berkala.
     */

    /*
     * Kasus penggunaan:
     * 1. Menangani peristiwa-peristiwa yang berulang dan tertunda, yang akan
     * terjadi di masa depan dalam selang waktu tertentu
     * 
     * Kontra:
     * 1. Antrean tanpa batas berbahaya.
     */

    // 5.public static ExecutorService newWorkStealingPool()
    /*
     * Membuat kumpulan thread yang mencuri pekerjaan menggunakan semua prosesor
     * yang tersedia sebagai tingkat paralelisme targetnya
     */

    /*
     * Kasus penggunaan:
     * 1. Untuk jenis masalah yang membagi dan menaklukkan.
     * 2. Penggunaan thread idle secara efektif. Thread yang menganggur mencuri
     * tugas dari thread yang sibuk.
     * 
     * Kekurangan:
     * 1. Ukuran antrian yang tidak dibatasi berbahaya.
     */

    /*
     * Anda dapat melihat satu kelemahan umum di semua ExecutorService ini: antrian
     * tidak terbatas. Hal ini akan diatasi dengan
     * ThreadPoolExecutor
     */

    /*
     * ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
     * TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory
     * threadFactory,
     * RejectedExecutionHandler handler)
     */

    /*
     * Dengan ThreadPoolExecutor, Anda bisa
     * 1. Kontrol ukuran kumpulan thread secara dinamis
     * 2. Atur kapasitas BlockingQueue
     * 3. Tentukan RejectionExecutionHander ketika antrian penuh
     * 4. CustomThreadFactory untuk menambahkan beberapa fungsi tambahan selama
     * pembuatan Thread (public Thread newThread(Runnable r)
     */

    public static void main(String[] args) {
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAliveTime = 5000; // 5 seconds
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);

        // Submitting tasks to the executor
        for (int i = 0; i < 20; i++) {
            executor.submit(new Task(i));
        }

        // Shutting down the executor
        executor.shutdown();
        /*
         * output:
         * Task 1 is running.
         * Task 3 is running.
         * Task 2 is running.
         * Task 0 is running.
         * Task 4 is running.
         * Task 4 is completed.
         * Task 1 is completed.
         * Task 3 is completed.
         * Task 0 is completed.
         * Task 2 is completed.
         * Task 9 is running.
         * Task 8 is running.
         * Task 7 is running.
         * Task 6 is running.
         * Task 5 is running.
         * Task 6 is completed.
         * Task 8 is completed.
         * Task 11 is running.
         * Task 7 is completed.
         * Task 12 is running.
         * Task 9 is completed.
         * Task 13 is running.
         * Task 10 is running.
         * Task 5 is completed.
         * Task 14 is running.
         * Task 13 is completed.
         * Task 11 is completed.
         * Task 12 is completed.
         * Task 10 is completed.
         * Task 18 is running.
         * Task 17 is running.
         * Task 16 is running.
         * Task 15 is running.
         * Task 14 is completed.
         * Task 19 is running.
         * Task 19 is completed.
         * Task 18 is completed.
         * Task 16 is completed.
         * Task 17 is completed.
         * Task 15 is completed.
         */

    }

    static class Task implements Runnable {
        private final int taskId;

        Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " is running.");
            try {
                Thread.sleep(2000); // Simulating task execution time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task " + taskId + " is completed.");
        }
    }

}
