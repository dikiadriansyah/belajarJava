
// import lombok.extern.java.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.logging.*;

public class Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance {

    // Performing Asynchronous Tasks Where a Return Value Is Needed Using a Callable
    // Class Instance/Melakukan Tugas Asinkron yang Membutuhkan Nilai Pengembalian
    // Menggunakan Mesin Virtual Kelas yang Dapat Dipanggil

    /*
     * Seringkali kita perlu menjalankan tugas yang sudah berjalan lama dan
     * menggunakan hasil tugas tersebut setelah tugas tersebut selesai.
     * 
     * Dalam contoh ini, kita akan membuat dua kelas: Satu yang mengimplementasikan
     * Callable<T> interface (di mana T adalah tipe yang kita inginkan).
     * ingin kembali), dan yang berisi metode main().
     */

    // AsyncValueTypeTaskCompleter.java

    /*
     * import lombok.extern.java.Log;
     * import java.util.concurrent.Callable;
     * import java.util.concurrent.ThreadLocalRandom;
     * import java.util.concurrent.TimeUnit;
     * 
     * @Log
     * public class AsyncValueTypeTaskCompleter implements Callable<Integer> {
     * private int taskNumber;
     * public AsyncValueTypeTaskCompleter(int taskNumber) {
     * this.taskNumber = taskNumber;
     * }
     * 
     * @Override
     * public Integer call() throws Exception {
     * int timeout = ThreadLocalRandom.current().nextInt(1, 20);
     * try {
     * log.info(String.format("Task %d is sleeping", taskNumber));
     * TimeUnit.SECONDS.sleep(timeout);
     * log.info(String.format("Task %d is done sleeping", taskNumber));
     * } catch (InterruptedException e) {
     * log.warning(e.getMessage());
     * }
     * return timeout;
     * }
     * }
     * 
     */

    // AsyncExample2.java

    /*
     * import lombok.extern.java.Log;
     * import java.util.ArrayList;
     * import java.util.List;
     * import java.util.concurrent.ExecutionException;
     * import java.util.concurrent.ExecutorService;
     * import java.util.concurrent.Executors;
     * import java.util.concurrent.Future;
     * 
     * @Log
     * public class AsyncExample2 {
     * public static void main(String[] args) {
     * ExecutorService executorService = Executors.newCachedThreadPool();
     * List<Future<Integer>> futures = new ArrayList<>();
     * for (int i = 0; i < 10; i++){
     * Future<Integer> submittedFuture = executorService.submit(new
     * AsyncValueTypeTaskCompleter(i));
     * futures.add(submittedFuture);
     * }
     * executorService.shutdown();
     * while(!futures.isEmpty()){
     * for(int j = 0; j < futures.size(); j++){
     * Future<Integer> f = futures.get(j);
     * if(f.isDone()){
     * try {
     * int timeout = f.get();
     * log.info(String.format("A task just completed after sleeping for %d
     * seconds", timeout));
     * futures.remove(f);
     * } catch (InterruptedException | ExecutionException e) {
     * log.warning(e.getMessage());
     * }
     * }
     * }
     * }
     * }
     * }
     * 
     * 
     */

    // Menjalankan AsyncExample2.main() menghasilkan keluaran berikut:
    /*
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 7 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 8 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 2 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 1 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 4 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 9 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 0 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 6 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 5 is sleeping
     * Dec 28, 2016 3:07:15 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 3 is sleeping
     * Dec 28, 2016 3:07:16 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 8 is done sleeping
     * Dec 28, 2016 3:07:16 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 1 seconds
     * Dec 28, 2016 3:07:17 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 2 is done sleeping
     * Dec 28, 2016 3:07:17 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 2 seconds
     * Dec 28, 2016 3:07:17 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 9 is done sleeping
     * Dec 28, 2016 3:07:17 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 2 seconds
     * Dec 28, 2016 3:07:19 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 3 is done sleeping
     * Dec 28, 2016 3:07:19 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 4 seconds
     * Dec 28, 2016 3:07:20 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 0 is done sleeping
     * Dec 28, 2016 3:07:20 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 5 seconds
     * Dec 28, 2016 3:07:21 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 5 is done sleeping
     * Dec 28, 2016 3:07:21 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 6 seconds
     * Dec 28, 2016 3:07:25 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 1 is done sleeping
     * Dec 28, 2016 3:07:25 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 10 seconds
     * Dec 28, 2016 3:07:27 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 6 is done sleeping
     * Dec 28, 2016 3:07:27 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 12 seconds
     * Dec 28, 2016 3:07:29 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 7 is done sleeping
     * Dec 28, 2016 3:07:29 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 14 seconds
     * Dec 28, 2016 3:07:31 PM AsyncValueTypeTaskCompleter call
     * INFO: Task 4 is done sleeping
     * Dec 28, 2016 3:07:31 PM AsyncExample2 main
     * INFO: A task just completed after sleeping for 16 seconds
     */

    // Catatan Pengamatan:
    /*
     * Ada beberapa hal yang perlu diperhatikan pada output di atas,
     * 1. Setiap panggilan ke ExecutorService.submit() mengembalikan instance
     * Future, yang disimpan dalam daftar untuk digunakan nanti
     * 2. Future berisi metode bernama isDone() yang dapat digunakan untuk memeriksa
     * apakah tugas kita telah selesai
     * sebelum mencoba memeriksa nilai pengembaliannya. Memanggil metode
     * Future.get() pada Future yang belum selesai
     * akan memblokir thread saat ini hingga tugas selesai, berpotensi meniadakan
     * banyak manfaat yang didapat
     * melakukan tugas secara Asynchronous.
     * 3. Metode executorService.shutdown() dipanggil sebelum memeriksa nilai
     * kembalian objek Masa Depan.
     * Hal ini tidak diwajibkan, namun dilakukan dengan cara ini untuk menunjukkan
     * bahwa hal tersebut mungkin dilakukan. ExecutorService.shutdown()
     * metode tidak mencegah penyelesaian tugas yang telah diserahkan ke
     * ExecutorService,
     * melainkan mencegah tugas-tugas baru ditambahkan ke Antrean.
     */

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> submittedFuture = executorService.submit(new AsyncValueTypeTaskCompleter2(i));
            futures.add(submittedFuture);
        }
        executorService.shutdown();
        while (!futures.isEmpty()) {
            for (int j = 0; j < futures.size(); j++) {
                Future<Integer> f = futures.get(j);
                if (f.isDone()) {
                    // Create a Logger
                    Logger logger = Logger.getLogger(
                            Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance.class
                                    .getName());

                    try {
                        int timeout = f.get();
                        logger.info(String.format("A task just completed after sleeping for %d seconds", timeout));
                        futures.remove(f);
                    } catch (InterruptedException | ExecutionException e) {
                        logger.warning(e.getMessage());
                    }
                }
            }
        }

        /*
         * output:
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 8 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 9 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 4 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 5 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 2 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 7 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 0 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 1 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 3 is sleeping
         * Mar 08, 2024 3:07:58 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 6 is sleeping
         * Mar 08, 2024 3:08:00 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 4 is done sleeping
         * Mar 08, 2024 3:08:00 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 9 is done sleeping
         * Mar 08, 2024 3:08:00 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 1 seconds
         * Mar 08, 2024 3:08:00 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 1 seconds
         * Mar 08, 2024 3:08:01 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 0 is done sleeping
         * Mar 08, 2024 3:08:01 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 5 is done sleeping
         * Mar 08, 2024 3:08:01 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 2 seconds
         * Mar 08, 2024 3:08:01 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 2 seconds
         * Mar 08, 2024 3:08:03 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 7 is done sleeping
         * Mar 08, 2024 3:08:03 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 4 seconds
         * Mar 08, 2024 3:08:04 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 8 is done sleeping
         * Mar 08, 2024 3:08:04 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 5 seconds
         * Mar 08, 2024 3:08:09 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 1 is done sleeping
         * Mar 08, 2024 3:08:09 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 10 seconds
         * Mar 08, 2024 3:08:11 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 3 is done sleeping
         * Mar 08, 2024 3:08:11 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 12 seconds
         * Mar 08, 2024 3:08:14 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 2 is done sleeping
         * Mar 08, 2024 3:08:14 PM AsyncValueTypeTaskCompleter2 call
         * INFO: Task 6 is done sleeping
         * Mar 08, 2024 3:08:14 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 15 seconds
         * Mar 08, 2024 3:08:14 PM
         * Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance
         * main
         * INFO: A task just completed after sleeping for 15 seconds
         */

    }
}
