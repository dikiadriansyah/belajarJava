import java.util.concurrent.*;

public class Pitfall_thread_creation_is_relatively_expensive {
    // Pitfall - Thread creation is relatively expensive/Kesalahan - Pembuatan
    // thread relatif mahal

    /*
     * Pertimbangkan dua tolok ukur mikro berikut:
     * Tolok ukur pertama hanya membuat, memulai, dan menggabungkan thread. Runnable
     * thread tidak berfungsi
     */

    /*
     * public class ThreadTest {
     * public static void main(String[] args) throws Exception {
     * while (true) {
     * long start = System.nanoTime();
     * for (int i = 0; i < 100_000; i++) {
     * Thread t = new Thread(new Runnable() {
     * public void run() {
     * }});
     * t.start();
     * t.join();
     * }
     * long end = System.nanoTime();
     * System.out.println((end - start) / 100_000.0);
     * }
     * }
     * }
     * 
     */

    /*
     * $ java ThreadTest
     * 34627.91355
     * 33596.66021
     * 33661.19084
     * 33699.44895
     * 33603.097
     * 33759.3928
     * 33671.5719
     * 33619.46809
     * 33679.92508
     * 33500.32862
     * 33409.70188
     * 33475.70541
     * 33925.87848
     * 33672.89529
     * ^C
     * 
     */

    /*
     * Pada tipikal PC modern yang menjalankan Linux dengan 64bit Java 8 u101,
     * benchmark ini menunjukkan waktu rata-rata yang dibutuhkan untuk membuat,
     * memulai, dan menggabungkan thread antara 33,6 dan 33,9 mikrodetik.
     * 
     * Tolok ukur kedua melakukan hal yang sama dengan yang pertama tetapi
     * menggunakan ExecutorService untuk mengirimkan tugas dan Masa Depan untuk
     * bertemu dengan akhir tugas.
     */

    /*
     * import java.util.concurrent.*;
     * public class ExecutorTest {
     * public static void main(String[] args) throws Exception {
     * ExecutorService exec = Executors.newCachedThreadPool();
     * while (true) {
     * long start = System.nanoTime();
     * for (int i = 0; i < 100_000; i++) {
     * Future<?> future = exec.submit(new Runnable() {
     * public void run() {
     * }
     * });
     * future.get();
     * }
     * long end = System.nanoTime();
     * System.out.println((end - start) / 100_000.0);
     * }
     * }
     * }
     */

    /*
     * $ java ExecutorTest
     * 6714.66053
     * 5418.24901
     * 5571.65213
     * 5307.83651
     * 5294.44132
     * 5370.69978
     * 5291.83493
     * 5386.23932
     * 5384.06842
     * 5293.14126
     * 5445.17405
     * 5389.70685
     * ^C
     */

    /*
     * Seperti yang Anda lihat, rata-ratanya adalah antara 5,3 dan 5,6 mikrodetik.
     * 
     * Meskipun waktu sebenarnya akan bergantung pada berbagai faktor, perbedaan
     * antara kedua hasil ini cukup signifikan. Jelas lebih cepat menggunakan
     * kumpulan thread untuk mendaur ulang thread daripada membuat thread baru
     */

    public static void main(String[] args) throws Exception {
        // while (true) {
        // long start = System.nanoTime();
        // for (int i = 0; i < 100_000; i++) {
        // Thread t = new Thread(new Runnable() {
        // public void run() {
        // }
        // });
        // t.start();
        // t.join();
        // }
        // long end = System.nanoTime();
        // System.out.println((end - start) / 100_000.0);
        // }
        /*
         * output:
         * 127300.448
         * 123086.785
         * 124492.096
         */
        // ----------------
        ExecutorService exec = Executors.newCachedThreadPool();
        while (true) {
            long start = System.nanoTime();
            for (int i = 0; i < 100_000; i++) {
                Future<?> future = exec.submit(new Runnable() {
                    public void run() {
                    }
                });
                future.get();
            }
            long end = System.nanoTime();
            System.out.println((end - start) / 100_000.0);
        }
        /*
         * output:
         * 5033.043
         * 3791.645
         * 3606.926
         * 3742.145
         * 3535.969
         * 3447.491
         * 3272.691
         * 3414.891
         */
    }
}
