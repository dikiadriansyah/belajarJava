import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Handle_rejection_execution {
    // jika
    /*
     * 1. Anda mencoba mengirimkan tugas ke Pelaksana shutdown atau
     * 2. antrian sudah jenuh (hanya mungkin dengan yang dibatasi) dan jumlah
     * maksimum Thread telah tercapai,
     */

    // RejectedExecutionHandler.rejectedExecution(Runnable, ThreadPoolExecutor) will
    // be called

    /*
     * Perilaku defaultnya adalah Anda akan mendapatkan RejectedExecutionException
     * yang dilemparkan ke pemanggil. Namun ada lebih banyak perilaku yang telah
     * ditentukan sebelumnya:
     * ThreadPoolExecutor.AbortPolicy (default, will throw REE)
     * ThreadPoolExecutor.CallerRunsPolicy (executes task on caller's thread -
     * blocking it)
     * ThreadPoolExecutor.DiscardPolicy (silently discard task)
     * ThreadPoolExecutor.DiscardOldestPolicy (silently discard oldest task in queue
     * and retry execution of the new task)
     */

    // Anda dapat mengaturnya menggunakan salah satu konstruktor ThreadPool:

    /*
     * public ThreadPoolExecutor(int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * RejectedExecutionHandler handler) // <--
     * 
     * public ThreadPoolExecutor(int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * ThreadFactory threadFactory,
     * RejectedExecutionHandler handler) // <--
     */

    /*
     * Anda juga dapat menerapkan perilaku Anda sendiri dengan memperluas
     * RejectedExecutionHandler interface:
     * void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
     */

    public static void main(String[] args) throws Exception {
        int corePoolSize = 5; // Jumlah minimum thread dalam pool
        int maximumPoolSize = 10; // Jumlah maksimum thread dalam pool
        long keepAliveTime = 5000; // Waktu yang idle sebelum thread non-core dihapus
        TimeUnit unit = TimeUnit.MILLISECONDS; // Unit untuk waktu idle
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(); // Antrian untuk pekerjaan yang belum selesai
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy(); // Kebijakan penanganan jika antrian
                                                                                 // penuh

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, handler);

        // Membuat Runnable task
        Runnable task = () -> {
            System.out.println("Running task on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // Menunda eksekusi untuk simulasi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Menyerahkan beberapa pekerjaan ke executor
        for (int i = 0; i < 20; i++) {
            executor.execute(task);
        }

        // Menunggu hingga semua pekerjaan selesai
        executor.shutdown();
        /*
         * output:
         * Running task on thread: pool-1-thread-4
         * Running task on thread: pool-1-thread-2
         * Running task on thread: pool-1-thread-3
         * Running task on thread: pool-1-thread-5
         * Running task on thread: pool-1-thread-1
         * Running task on thread: pool-1-thread-3
         * Running task on thread: pool-1-thread-5
         * Running task on thread: pool-1-thread-2
         * Running task on thread: pool-1-thread-1
         * Running task on thread: pool-1-thread-4
         * Running task on thread: pool-1-thread-1
         * Running task on thread: pool-1-thread-3
         * Running task on thread: pool-1-thread-4
         * Running task on thread: pool-1-thread-2
         * Running task on thread: pool-1-thread-5
         * Running task on thread: pool-1-thread-5
         * Running task on thread: pool-1-thread-3
         * Running task on thread: pool-1-thread-1
         * Running task on thread: pool-1-thread-2
         * Running task on thread: pool-1-thread-4
         */
    }
}
