import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Add_two_int_arrays_using_a_threadpool {
    // Add two `int` arrays using a Threadpool/Tambahkan dua array `int` menggunakan
    // Threadpool

    /*
     * Threadpool memiliki Antrean tugas, yang masing-masing tugas akan dieksekusi
     * pada salah satu Thread ini.
     * 
     * 
     * Contoh berikut menunjukkan cara menambahkan dua array int menggunakan
     * Threadpool.
     */

    // versi > java se 8

    /*
     * int[] firstArray = { 2, 4, 6, 8 };
     * int[] secondArray = { 1, 3, 5, 7 };
     * int[] result = { 0, 0, 0, 0 };
     * ExecutorService pool = Executors.newCachedThreadPool();
     * // Setup the ThreadPool:
     * // for each element in the array, submit a worker to the pool that adds
     * elements
     * for (int i = 0; i < result.length; i++) {
     * final int worker = i;
     * pool.submit(() -> result[worker] = firstArray[worker] + secondArray[worker]
     * );
     * }
     * // Wait for all Workers to finish:
     * try {
     * // execute all submitted tasks
     * pool.shutdown();
     * // waits until all workers finish, or the timeout ends
     * pool.awaitTermination(12, TimeUnit.SECONDS);
     * }
     * catch (InterruptedException e) {
     * pool.shutdownNow(); //kill thread
     * }
     * System.out.println(Arrays.toString(result));
     */

    /*
     * Catatan:
     * 1. Contoh ini murni ilustratif. Dalam praktiknya, tidak akan ada percepatan
     * apa pun dengan menggunakan thread untuk tugas sekecil ini. Perlambatan
     * mungkin terjadi, karena biaya tambahan dalam pembuatan tugas dan penjadwalan
     * akan menghabiskan waktu yang dibutuhkan untuk menjalankan tugas.
     * 2. Jika Anda menggunakan Java 7 dan versi lebih lama, Anda akan menggunakan
     * kelas anonim alih-alih lambda untuk mengimplementasikan tugas.
     */

    public static void main(String[] args) throws InterruptedException {
        int[] firstArray = { 2, 4, 6, 8 };
        int[] secondArray = { 1, 3, 5, 7 };
        int[] result = { 0, 0, 0, 0 };
        ExecutorService pool = Executors.newCachedThreadPool();
        // Setup the ThreadPool:
        // for each element in the array, submit a worker to the pool that adds elements
        for (int i = 0; i < result.length; i++) {
            final int worker = i;
            pool.submit(() -> result[worker] = firstArray[worker] + secondArray[worker]);
        }
        // Wait for all Workers to finish:
        try {
            // execute all submitted tasks
            pool.shutdown();
            // waits until all workers finish, or the timeout ends
            pool.awaitTermination(12, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            pool.shutdownNow(); // kill thread
        }
        System.out.println(Arrays.toString(result));// output: [3, 7, 11, 15]
    }
}
