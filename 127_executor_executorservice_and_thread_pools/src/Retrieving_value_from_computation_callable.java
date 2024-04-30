import java.util.Random;
import java.util.concurrent.*;

public class Retrieving_value_from_computation_callable {
    // Retrieving value from computation - Callable /Mengambil nilai dari komputasi
    // - Callable

    /*
     * Jika perhitungan Anda menghasilkan nilai kembalian yang nantinya diperlukan,
     * tugas Runnable sederhana saja tidak cukup. Untuk kasus seperti itu, Anda
     * dapat menggunakan ExecutorService.submit(Callable<T>) yang mengembalikan
     * nilai setelah eksekusi selesai.
     * 
     * Layanan akan mengembalikan Masa Depan yang dapat Anda gunakan untuk mengambil
     * hasil eksekusi tugas.
     */

    /*
     * // Submit a callable for execution
     * ExecutorService pool = anExecutorService;
     * Future<Integer> future = pool.submit(new Callable<Integer>() {
     * 
     * @Override public Integer call() {
     * //do some computation
     * return new Random().nextInt();
     * }
     * });
     * // ... perform other tasks while future is executed in a different thread
     */

    // Saat Anda perlu mendapatkan hasil di masa depan, hubungi future.get()

    /*
     * Tunggu tanpa batas waktu hingga masa depan selesai dengan hasil.
     * try {
     * // Blocks current thread until future is completed
     * Integer result = future.get();
     * catch (InterruptedException || ExecutionException e) {
     * // handle appropriately
     * }
     */

    /*
     * Tunggu hingga future selesai, namun tidak lebih dari waktu yang ditentukan.
     * try {
     * // Blocks current thread for a maximum of 500 milliseconds.
     * // If the future finishes before that, result is returned,
     * // otherwise TimeoutException is thrown.
     * Integer result = future.get(500, TimeUnit.MILLISECONDS);
     * catch (InterruptedException || ExecutionException || TimeoutException e) {
     * // handle appropriately
     * }
     * 
     */

    /*
     * Jika hasil dari tugas yang dijadwalkan atau berjalan tidak lagi diperlukan,
     * Anda dapat memanggil Future.cancel(boolean) untuk membatalkannya.
     * 1. Memanggil cancel(false) hanya akan menghapus tugas dari antrian tugas yang
     * akan dijalankan.
     * 2. Memanggil cancel(true) juga akan mengganggu tugas jika sedang berjalan.
     */

    public static void main(String[] args) throws Exception {

        // Inisialisasi ExecutorService
        ExecutorService pool = Executors.newFixedThreadPool(1);

        // Submit callable untuk dieksekusi
        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                // Melakukan komputasi
                return new Random().nextInt();
            }
        });

        // ... melakukan tugas-tugas lain selama future dieksekusi di thread yang
        // berbeda

        try {
            // Blok thread saat ini hingga future selesai
            Integer result = future.get();
            System.out.println("Hasil: " + result);
        } catch (InterruptedException | ExecutionException e) {
            // Menangani pengecualian dengan tepat
            e.printStackTrace();
        } finally {
            // Menutup pool executor setelah selesai
            pool.shutdown();
        }

        /*
         * output:
         * Hasil: -1703106647
         */

    }
}
