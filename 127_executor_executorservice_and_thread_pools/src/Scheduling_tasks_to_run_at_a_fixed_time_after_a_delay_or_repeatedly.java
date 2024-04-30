import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Scheduling_tasks_to_run_at_a_fixed_time_after_a_delay_or_repeatedly {
    // Scheduling tasks to run at a fixed time, after a delay or
    // repeatedly/Menjadwalkan tugas untuk dijalankan pada waktu yang tetap, setelah
    // penundaan, atau berulang kali

    /*
     * Kelas ScheduledExecutorService menyediakan metode untuk menjadwalkan tugas
     * tunggal atau berulang dalam beberapa
     * cara. Contoh kode berikut mengasumsikan bahwa pool telah dideklarasikan
     * dan diinisialisasi sebagai berikut:
     * 
     * ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
     */

    /*
     * Selain metode ExecutorService normal, API ScheduledExecutorService
     * menambahkan 4 metode itu
     * menjadwalkan tugas dan mengembalikan objek ScheduledFuture. Yang terakhir
     * dapat digunakan untuk mengambil hasil (dalam beberapa kasus) dan membatalkan
     * tugas.
     */

    // Starting a task after a fixed delay/Memulai tugas setelah penundaan tetap
    // Contoh berikut menjadwalkan tugas untuk dimulai setelah sepuluh menit.

    /*
     * ScheduledFuture<Integer> future = pool.schedule(new Callable<>() {
     * 
     * @Override public Integer call() {
     * // do something
     * return 42;
     * }
     * },
     * 10, TimeUnit.MINUTES);
     */

    // Starting tasks at a fixed rate/Memulai tugas dengan kecepatan tetap

    /*
     * Contoh berikut menjadwalkan tugas untuk dimulai setelah sepuluh menit, lalu
     * berulang kali dengan kecepatan setiap satu menit sekali.
     * 
     * ScheduledFuture<?> future = pool.scheduleAtFixedRate(new Runnable() {
     * 
     * @Override public void run() {
     * // do something
     * }
     * },
     * 10, 1, TimeUnit.MINUTES);
     */

    /*
     * Eksekusi tugas akan berlanjut sesuai jadwal hingga pool ditutup, masa
     * depan dibatalkan, atau salah satu tugas menemui pengecualian.
     * 
     * Dijamin bahwa tugas yang dijadwalkan oleh panggilan scheduleAtFixedRate
     * tertentu tidak akan tumpang tindih pada waktunya. Jika suatu tugas memakan
     * waktu lebih lama dari jangka waktu yang ditentukan, maka pelaksanaan tugas
     * berikutnya dan berikutnya mungkin terlambat dimulai.
     */

    // Starting tasks with a fixed delay/Memulai tugas dengan penundaan tetap

    /*
     * Contoh berikut menjadwalkan tugas untuk dimulai setelah sepuluh menit, lalu
     * berulang kali dengan penundaan satu menit
     * antara satu tugas berakhir dan tugas berikutnya dimulai.
     */

    /*
     * ScheduledFuture<?> future = pool.scheduleWithFixedDelay(new Runnable() {
     * 
     * @Override public void run() {
     * // do something
     * }
     * },
     * 10, 1, TimeUnit.MINUTES);
     */

    /*
     * Eksekusi tugas akan berlanjut sesuai jadwal hingga kumpulan ditutup, masa
     * depan dibatalkan, atau salah satu tugas menemui pengecualian.
     */

    public static void main(String[] args) throws Exception {
        // ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        // ScheduledFuture<Integer> future = pool.schedule(new Callable<>() {
        // @Override
        // public Integer call() {
        // // Lakukan sesuatu di sini
        // return 4;
        // }
        // }, 1, TimeUnit.MINUTES);

        // try {
        // // Ambil hasil dari future setelah waktu yang ditentukan
        // Integer result = future.get();
        // System.out.println("Hasil: " + result); // output: 4
        // } catch (InterruptedException | ExecutionException e) {
        // e.printStackTrace();
        // } finally {
        // // Pastikan untuk menutup pool ketika sudah selesai
        // pool.shutdown();
        // }

        // -----------------------------------------
        // ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        // ScheduledFuture<?> future = pool.scheduleAtFixedRate(new Runnable() {
        // @Override
        // public void run() {
        // // Lakukan sesuatu di sini
        // System.out.println("Tugas dijalankan.");
        // }
        // }, 2, 1, TimeUnit.MINUTES);
        /*
         * output:
         * Tugas dijalankan.
         * Tugas dijalankan.
         * Tugas dijalankan.
         * Tugas dijalankan.
         * Tugas dijalankan.
         * Tugas dijalankan.
         */
        // ------------------------
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> future = pool.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                // Simulate doing something
                System.out.println("Task executed at: " + System.currentTimeMillis());
            }
        }, 1, 1, TimeUnit.MINUTES);
        /*
         * output:
         * Task executed at: 1709864463517
         * Task executed at: 1709864523629
         */
    }
}
