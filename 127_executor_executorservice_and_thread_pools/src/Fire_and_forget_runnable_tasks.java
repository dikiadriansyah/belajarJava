import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Fire_and_forget_runnable_tasks {
    // Fire and Forget - Runnable Tasks/Api dan Lupakan - Tugas yang Dapat
    // Dijalankan

    /*
     * Pelaksana menerima java.lang.Runnable yang berisi kode (berpotensi secara
     * komputasi atau berjalan lama atau berat) untuk dijalankan di Thread lain.
     */

    // Penggunaannya adalah:
    /*
     * Executor exec = anExecutor;
     * exec.execute(new Runnable() {
     * 
     * @Override public void run() {
     * //offloaded work, no need to get result back
     * }
     * });
     */

    /*
     * Perhatikan bahwa dengan pelaksana ini, Anda tidak memiliki cara untuk
     * mendapatkan kembali nilai yang dihitung.
     * Dengan Java 8, seseorang dapat menggunakan lambda untuk mempersingkat contoh
     * kode.
     */

    /*
     * Version ≥ Java SE 8
     * Executor exec = anExecutor;
     * exec.execute(() -> {
     * //offloaded work, no need to get result back
     * });
     */

    public static void main(String[] args) {
        Executor exec = Executors.newSingleThreadExecutor();

        exec.execute(() -> {
            // offloaded work, no need to get result back
            System.out.println("Offloaded work is being executed...");
        });

        /*
         * output:
         * Offloaded work is being executed...
         */

    }
}
