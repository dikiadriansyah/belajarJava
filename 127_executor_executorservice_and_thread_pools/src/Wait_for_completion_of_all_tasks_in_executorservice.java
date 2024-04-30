import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.*;

public class Wait_for_completion_of_all_tasks_in_executorservice {
    // Wait for completion of all tasks in ExecutorService/Tunggu selesainya semua
    // tugas di ExecutorService

    // Mari kita lihat berbagai opsi untuk menunggu penyelesaian tugas yang
    // diserahkan ke Executor

    // 1. ExecutorService invokeAll()
    /*
     * Menjalankan tugas yang diberikan, mengembalikan daftar Kontrak Berjangka yang
     * menyimpan status dan hasilnya ketika semuanya selesai.
     */

    // contoh:
    /*
     * import java.util.concurrent.*;
     * import java.util.*;
     * public class InvokeAllDemo{
     * public InvokeAllDemo(){
     * System.out.println("creating service");
     * ExecutorService service =
     * Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
     * 
     * List<MyCallable> futureList = new ArrayList<MyCallable>();
     * for (int i = 0; i < 10; i++){
     * MyCallable myCallable = new MyCallable((long)i);
     * futureList.add(myCallable);
     * }
     * System.out.println("Start");
     * try{
     * List<Future<Long>> futures = service.invokeAll(futureList);
     * } catch(Exception err){
     * err.printStackTrace();
     * }
     * System.out.println("Completed");
     * service.shutdown();
     * }
     * public static void main(String args[]){
     * InvokeAllDemo demo = new InvokeAllDemo();
     * }
     * class MyCallable implements Callable<Long>{
     * Long id = 0L;
     * public MyCallable(Long val){
     * this.id = val;
     * }
     * public Long call(){
     * // Add your business logic
     * return id;
     * }
     * }
     * }
     */

    // 2. CountDownLatch

    /*
     * Bantuan sinkronisasi yang memungkinkan satu atau lebih thread menunggu hingga
     * serangkaian operasi yang dilakukan di thread lain selesai.
     */

    /*
     * CountDownLatch diinisialisasi dengan hitungan tertentu. Metode menunggu
     * diblokir hingga hitungan saat ini mencapai nol karena pemanggilan metode
     * countDown(), setelah itu semua thread yang menunggu dilepaskan dan
     * pemanggilan menunggu selanjutnya akan segera dikembalikan. Ini adalah
     * fenomena sekali pakai -- penghitungan tidak dapat diatur ulang. Jika Anda
     * memerlukan versi yang mengatur ulang hitungan, pertimbangkan untuk
     * menggunakan CyclicBarrier.
     */

    // 3. ForkJoinPool atau newWorkStealingPool() di Pelaksana

    /*
     * 4. Ulangi semua future object yang dibuat setelah dikirimkan ke
     * ExecutorService
     * 5. Cara mematikan yang disarankan dari halaman dokumentasi Oracle
     * ExecutorService:
     */

    /*
     * void shutdownAndAwaitTermination(ExecutorService pool) {
     * pool.shutdown(); // Disable new tasks from being submitted
     * try {
     * // Wait a while for existing tasks to terminate
     * if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
     * pool.shutdownNow(); // Cancel currently executing tasks
     * // Wait a while for tasks to respond to being cancelled
     * if (!pool.awaitTermination(60, TimeUnit.SECONDS))
     * System.err.println("Pool did not terminate");
     * }
     * } catch (InterruptedException ie) {
     * // (Re-)Cancel if current thread also interrupted
     * pool.shutdownNow();
     * // Preserve interrupt status
     * Thread.currentThread().interrupt();
     * }
     */

    /*
     * shutdown(): Memulai penghentian secara teratur di mana tugas yang diserahkan
     * sebelumnya dijalankan, namun tidak ada tugas baru yang akan diterima.
     * 
     * shutdownNow():Mencoba menghentikan semua tugas yang sedang dijalankan secara
     * aktif, menghentikan pemrosesan tugas yang menunggu, dan
     * mengembalikan daftar tugas yang menunggu eksekusi.
     * 
     * Dalam contoh di atas, jika tugas Anda membutuhkan waktu lebih lama untuk
     * diselesaikan, Anda dapat mengubah kondisi if menjadi kondisi while
     */

    /*
     * Replace
     * if (!pool.awaitTermination(60, TimeUnit.SECONDS))
     */

    /*
     * dengan
     * while(!pool.awaitTermination(60, TimeUnit.SECONDS)) {
     * Thread.sleep(60000);
     * }
     */

    // ---------------------
    public Wait_for_completion_of_all_tasks_in_executorservice() {
        System.out.println("creating service");
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<MyCallable> futureList = new ArrayList<MyCallable>();
        for (int i = 0; i < 10; i++) {
            MyCallable myCallable = new MyCallable((long) i);
            futureList.add(myCallable);
        }
        System.out.println("Start");
        try {
            List<Future<Long>> futures = service.invokeAll(futureList);
        } catch (Exception err) {
            err.printStackTrace();
        }
        System.out.println("Completed");
        service.shutdown();
    }

    // ---------------------

    public static void main(String[] args) {
        Wait_for_completion_of_all_tasks_in_executorservice demo = new Wait_for_completion_of_all_tasks_in_executorservice();
        /*
         * output:
         * creating service
         * Start
         * Completed
         */

    }

    class MyCallable implements Callable<Long> {
        Long id = 0L;

        public MyCallable(Long val) {
            this.id = val;
        }

        public Long call() {
            // Add your business logic
            return id;
        }
    }
    // -------------------------------------------------

}
