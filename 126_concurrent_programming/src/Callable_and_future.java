import java.util.Date;
import java.util.concurrent.*;

public class Callable_and_future {
    // Callable and Future/Dapat Dipanggil dan Masa Depan

    /*
     * Meskipun Runnable menyediakan sarana untuk membungkus kode yang akan
     * dieksekusi di thread berbeda, Runnable memiliki batasan karena tidak dapat
     * mengembalikan hasil eksekusi. Satu-satunya cara untuk mendapatkan nilai
     * kembalian dari eksekusi Runnable
     * adalah menetapkan hasilnya ke variabel yang dapat diakses dalam lingkup di
     * luar Runnable.
     * 
     * Callable diperkenalkan di Java 5 sebagai rekan Runnable. Callable pada
     * dasarnya sama kecuali ia memiliki metode panggilan, bukan dijalankan. Metode
     * panggilan memiliki kemampuan tambahan untuk mengembalikan hasil dan juga
     * diperbolehkan untuk menampilkan pengecualian yang dicentang.
     */

    // The result from a Callable task submission is available to be tapped via a
    // Future/Hasil dari penyerahan tugas Callable tersedia untuk dimanfaatkan
    // melalui Masa Depan

    /*
     * future dapat dianggap sebagai wadah yang menampung hasil perhitungan
     * Callable. Perhitungan callable dapat dilanjutkan di thread lain, dan segala
     * upaya untuk memanfaatkan hasil Future akan diblokir dan hanya akan
     * mengembalikan hasilnya setelah tersedia.
     */

    // Callable Interface
    /*
     * public interface Callable<V> {
     * V call() throws Exception;
     * }
     */

    // Future
    /*
     * interface Future<V> {
     * V get();
     * V get(long timeout, TimeUnit unit);
     * boolean cancel(boolean mayInterruptIfRunning);
     * boolean isCancelled();
     * boolean isDone();
     * }
     */

    // contoh gunakan Callable dan Future:
    /*
     * public static void main(String[] args) throws Exception {
     * ExecutorService es = Executors.newSingleThreadExecutor();
     * 
     * System.out.println("Time At Task Submission : " + new Date());
     * Future<String> result = es.submit(new ComplexCalculator());
     * // the call to Future.get() blocks until the result is available.So we are in
     * for about a 10 sec
     * wait now
     * System.out.println("Result of Complex Calculation is : " + result.get());
     * System.out.println("Time At the Point of Printing the Result : " + new
     * Date());
     * }
     */

    // Our Callable that does a lengthy computation
    /*
     * public class ComplexCalculator implements Callable<String> {
     * 
     * @Override
     * public String call() throws Exception {
     * // just sleep for 10 secs to simulate a lengthy computation
     * Thread.sleep(10000);
     * System.out.println("Result after a lengthy 10sec calculation");
     * return "Complex Result"; // the result
     * }
     * }
     */

    // hasil:
    /*
     * Time At Task Submission : Thu Aug 04 15:05:15 EDT 2016
     * Result after a lengthy 10sec calculation
     * Result of Complex Calculation is : Complex Result
     * Time At the Point of Printing the Result : Thu Aug 04 15:05:25 EDT 2016
     * 
     */

    // Other operations permitted on Future/Operasi lain diizinkan di Masa Depan
    /*
     * Sedangkan get() adalah metode untuk mengekstrak hasil aktual yang dimiliki
     * Future
     * 
     * 1. get(long timeout, TimeUnit unit) mendefinisikan periode waktu maksimum
     * selama thread saat ini akan menunggu hasilnya;
     * 2. untuk membatalkan panggilan tugas cancel(mayInterruptIfRunning).Bendera
     * mayInterrupt menunjukkan bahwa tugas harus dihentikan jika dimulai dan sedang
     * berjalan saat ini;
     * 3. Untuk memeriksa apakah task is completed/finished dengan memanggil
     * isDone();
     * 4. Untuk memeriksa apakah tugas panjang telah dibatalkan, isCancelled().
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ------------------
        ExecutorService es = Executors.newSingleThreadExecutor();

        System.out.println("Time At Task Submission : " + new Date());
        Future<String> result = es.submit(new ComplexCalculator2());
        // Panggilan ke Future.get() akan menghentikan eksekusi hingga hasil tersedia.
        // Jadi kita harus menunggu sekitar 10 detik sekarang
        System.out.println("Result of Complex Calculation is : " + result.get());
        System.out.println("Time At the Point of Printing the Result : " + new Date());

        es.shutdown();

        /*
         * output:
         * Time At Task Submission : Tue Mar 05 22:45:54 WIB 2024
         * Result after a lengthy 10sec calculation
         * Result of Complex Calculation is : Complex Result
         * Time At the Point of Printing the Result : Tue Mar 05 22:46:04 WIB 2024
         */
    }
}
