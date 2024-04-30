
// import lombok.extern.java.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import java.util.logging.*;

public class Defining_asynchronous_tasks_inline_using_lambdas {
    // Defining Asynchronous Tasks Inline using Lambdas/Mendefinisikan Tugas
    // Asinkron Inline menggunakan Lambdas

    /*
     * Meskipun desain perangkat lunak yang baik sering kali memaksimalkan
     * penggunaan kembali kode, terkadang ada gunanya mendefinisikan tugas asinkron
     * sebaris dalam kode Anda melalui ekspresi Lambda untuk memaksimalkan
     * keterbacaan kode.
     * 
     * Dalam contoh ini, kita akan membuat satu kelas yang berisi metode main(). Di
     * dalam metode ini, kita akan menggunakan
     * Ekspresi Lambda untuk membuat dan mengeksekusi instance Callable dan
     * Runnable<T>.
     */

    // AsyncExample3.java
    /*
     * import lombok.extern.java.Log;
     * import java.util.ArrayList;
     * import java.util.List;
     * import java.util.concurrent.*;
     * 
     * @Log
     * public class AsyncExample3 {
     * public static void main(String[] args) {
     * ExecutorService executorService = Executors.newCachedThreadPool();
     * List<Future<Integer>> futures = new ArrayList<>();
     * for(int i = 0; i < 5; i++){
     * final int index = i;
     * executorService.execute(() -> {
     * int timeout = getTimeout();
     * log.info(String.format("Runnable %d has been submitted and will sleep for %d
     * seconds", index, timeout));
     * try {
     * TimeUnit.SECONDS.sleep(timeout);
     * } catch (InterruptedException e) {
     * log.warning(e.getMessage());
     * }
     * log.info(String.format("Runnable %d has finished sleeping", index));
     * });
     * Future<Integer> submittedFuture = executorService.submit(() -> {
     * int timeout = getTimeout();
     * log.info(String.format("Callable %d will begin sleeping", index));
     * try {
     * TimeUnit.SECONDS.sleep(timeout);
     * } catch (InterruptedException e) {
     * log.warning(e.getMessage());
     * }
     * log.info(String.format("Callable %d is done sleeping", index));
     * return timeout;
     * });
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
     * public static int getTimeout(){
     * return ThreadLocalRandom.current().nextInt(1, 20);
     * }
     * }
     * 
     */

    // Catatan Pengamatan:
    /*
     * Ada beberapa hal yang perlu diperhatikan pada output di atas,
     * 1. Ekspresi Lambda memiliki akses ke variabel dan metode yang tersedia pada
     * cakupan definisinya, namun semua variabel harus final (atau final secara
     * efektif) untuk digunakan di dalam ekspresi lambda.
     * 2. Kita tidak perlu menentukan apakah ekspresi Lambda kita adalah Callable
     * atau Runnable<T> secara eksplisit, tipe kembalian disimpulkan secara otomatis
     * oleh tipe kembalian.
     */

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> futures = new ArrayList<>();

        Logger logger = Logger.getLogger(
                Performing_asynchronous_tasks_where_a_return_value_is_needed_using_a_callable_class_insatance.class
                        .getName());

        for (int i = 0; i < 5; i++) {
            final int index = i;
            executorService.execute(() -> {
                int timeout = getTimeout();
                logger.info(
                        String.format("Runnable %d has been submitted and will sleep for %d  seconds", index, timeout));
                try {
                    TimeUnit.SECONDS.sleep(timeout);
                } catch (InterruptedException e) {
                    logger.warning(e.getMessage());
                }
                logger.info(String.format("Runnable %d has finished sleeping", index));
            });
            Future<Integer> submittedFuture = executorService.submit(() -> {
                int timeout = getTimeout();
                logger.info(String.format("Callable %d will begin sleeping", index));
                try {
                    TimeUnit.SECONDS.sleep(timeout);
                } catch (InterruptedException e) {
                    logger.warning(e.getMessage());
                }
                logger.info(String.format("Callable %d is done sleeping", index));
                return timeout;
            });
            futures.add(submittedFuture);
        }
        executorService.shutdown();
        while (!futures.isEmpty()) {
            for (int j = 0; j < futures.size(); j++) {
                Future<Integer> f = futures.get(j);
                if (f.isDone()) {
                    try {
                        int timeout = f.get();
                        logger.info(String.format("A task just completed after sleeping for %d  seconds", timeout));
                        futures.remove(f);
                    } catch (InterruptedException | ExecutionException e) {
                        logger.warning(e.getMessage());
                    }
                }
            }
        }

        /*
         * output:
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 4 has been submitted and will sleep for 13 seconds
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 3 has been submitted and will sleep for 7 seconds
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 4 will begin sleeping
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 2 has been submitted and will sleep for 16 seconds
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 3 will begin sleeping
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 0 will begin sleeping
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 1 will begin sleeping
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 2 will begin sleeping
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 0 has been submitted and will sleep for 6 seconds
         * Mar 08, 2024 3:25:51 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 1 has been submitted and will sleep for 2 seconds
         * Mar 08, 2024 3:25:53 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 1 is done sleeping
         * Mar 08, 2024 3:25:53 PM Defining_asynchronous_tasks_inline_using_lambdas main
         * INFO: A task just completed after sleeping for 2 seconds
         * Mar 08, 2024 3:25:53 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 1 has finished sleeping
         * Mar 08, 2024 3:25:57 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 3 is done sleeping
         * Mar 08, 2024 3:25:57 PM Defining_asynchronous_tasks_inline_using_lambdas main
         * INFO: A task just completed after sleeping for 6 seconds
         * Mar 08, 2024 3:25:57 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 2 is done sleeping
         * Mar 08, 2024 3:25:57 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 0 has finished sleeping
         * Mar 08, 2024 3:25:57 PM Defining_asynchronous_tasks_inline_using_lambdas main
         * INFO: A task just completed after sleeping for 6 seconds
         * Mar 08, 2024 3:25:58 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 3 has finished sleeping
         * Mar 08, 2024 3:25:59 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 0 is done sleeping
         * Mar 08, 2024 3:25:59 PM Defining_asynchronous_tasks_inline_using_lambdas main
         * INFO: A task just completed after sleeping for 8 seconds
         * Mar 08, 2024 3:26:04 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 4 has finished sleeping
         * Mar 08, 2024 3:26:07 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$0
         * INFO: Runnable 2 has finished sleeping
         * Mar 08, 2024 3:26:10 PM Defining_asynchronous_tasks_inline_using_lambdas
         * lambda$1
         * INFO: Callable 4 is done sleeping
         * Mar 08, 2024 3:26:10 PM Defining_asynchronous_tasks_inline_using_lambdas main
         * INFO: A task just completed after sleeping for 19 seconds
         */

    }

    public static int getTimeout() {
        return ThreadLocalRandom.current().nextInt(1, 20);
    }

}
