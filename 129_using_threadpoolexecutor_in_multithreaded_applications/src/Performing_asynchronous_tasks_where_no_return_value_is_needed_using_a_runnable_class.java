import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Performing_asynchronous_tasks_where_no_return_value_is_needed_using_a_runnable_class {
    // Performing Asynchronous Tasks Where No Return Value Is Needed Using a
    // Runnable Class Instance / Melakukan Tugas Asinkron yang Tidak Diperlukan
    // Nilai Pengembalian Menggunakan Instance Kelas Runnable

    /*
     * Beberapa aplikasi mungkin ingin membuat tugas yang disebut "Api & Lupakan"
     * yang dapat dipicu secara berkala dan tidak dapat dipicu
     * perlu mengembalikan semua jenis nilai yang dikembalikan setelah menyelesaikan
     * tugas yang diberikan (misalnya, membersihkan file sementara lama, memutar
     * log, status penyimpanan otomatis).
     * 
     * Dalam contoh ini, kita akan membuat dua kelas: Satu yang mengimplementasikan
     * antarmuka Runnable, dan satu lagi berisi metode main().
     */

    // AsyncMaintenanceTaskCompleter.java
    /*
     * import lombok.extern.java.Log;
     * import java.util.concurrent.ThreadLocalRandom;
     * import java.util.concurrent.TimeUnit;
     * 
     * @Log
     * public class AsyncMaintenanceTaskCompleter implements Runnable {
     * private int taskNumber;
     * public AsyncMaintenanceTaskCompleter(int taskNumber) {
     * this.taskNumber = taskNumber;
     * }
     * public void run() {
     * int timeout = ThreadLocalRandom.current().nextInt(1, 20);
     * try {
     * log.info(String.format("Task %d is sleeping for %d seconds", taskNumber,
     * timeout));
     * TimeUnit.SECONDS.sleep(timeout);
     * log.info(String.format("Task %d is done sleeping", taskNumber));
     * } catch (InterruptedException e) {
     * log.warning(e.getMessage());
     * }
     * }
     * }
     */

    // AsyncExample1

    /*
     * import java.util.concurrent.ExecutorService;
     * import java.util.concurrent.Executors;
     * public class AsyncExample1 {
     * public static void main(String[] args){
     * ExecutorService executorService = Executors.newCachedThreadPool();
     * for(int i = 0; i < 10; i++){
     * executorService.execute(new AsyncMaintenanceTaskCompleter(i));
     * }
     * executorService.shutdown();
     * }
     * }
     * 
     */

    /*
     * Menjalankan AsyncExample1.main() menghasilkan output berikut:
     * 
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 8 is sleeping for 18 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 6 is sleeping for 4 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 2 is sleeping for 6 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 3 is sleeping for 4 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 9 is sleeping for 14 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 4 is sleeping for 9 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 5 is sleeping for 10 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 0 is sleeping for 7 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 1 is sleeping for 9 seconds
     * Dec 28, 2016 2:21:03 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 7 is sleeping for 8 seconds
     * Dec 28, 2016 2:21:07 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 6 is done sleeping
     * Dec 28, 2016 2:21:07 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 3 is done sleeping
     * Dec 28, 2016 2:21:09 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 2 is done sleeping
     * Dec 28, 2016 2:21:10 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 0 is done sleeping
     * Dec 28, 2016 2:21:11 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 7 is done sleeping
     * Dec 28, 2016 2:21:12 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 4 is done sleeping
     * Dec 28, 2016 2:21:12 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 1 is done sleeping
     * Dec 28, 2016 2:21:13 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 5 is done sleeping
     * Dec 28, 2016 2:21:17 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 9 is done sleeping
     * Dec 28, 2016 2:21:21 PM AsyncMaintenanceTaskCompleter run
     * INFO: Task 8 is done sleeping
     * Process finished with exit code 0
     */

    /*
     * Catatan Catatan : Ada beberapa hal yang perlu diperhatikan pada output
     * diatas,
     * 
     * 1. Tugas tidak dilaksanakan dalam urutan yang dapat diprediksi.
     * 2. Karena setiap tugas ditidurkan selama jangka waktu (semu)acak, tugas
     * tersebut belum tentu selesai sesuai urutan pemanggilannya.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // -----------------
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new AsyncMaintenanceTaskCompleter(i));
        }
        executorService.shutdown();

        /*
         * output:
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 3 is sleeping for 17 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 9 is sleeping for 14 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 1 is sleeping for 4 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 4 is sleeping for 19 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 8 is sleeping for 15 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 2 is sleeping for 9 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 5 is sleeping for 7 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 7 is sleeping for 19 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 6 is sleeping for 19 seconds
         * Mar 08, 2024 2:30:52 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 0 is sleeping for 8 seconds
         * Mar 08, 2024 2:30:56 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 1 is done sleeping
         * Mar 08, 2024 2:30:59 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 5 is done sleeping
         * Mar 08, 2024 2:31:00 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 0 is done sleeping
         * Mar 08, 2024 2:31:01 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 2 is done sleeping
         * Mar 08, 2024 2:31:06 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 9 is done sleeping
         * Mar 08, 2024 2:31:07 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 8 is done sleeping
         * Mar 08, 2024 2:31:09 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 3 is done sleeping
         * Mar 08, 2024 2:31:11 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 4 is done sleeping
         * Mar 08, 2024 2:31:11 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 6 is done sleeping
         * Mar 08, 2024 2:31:11 PM AsyncMaintenanceTaskCompleter run
         * INFO: Task 7 is done sleeping
         */

    }
}
