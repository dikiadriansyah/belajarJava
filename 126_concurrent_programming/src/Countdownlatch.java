import java.util.concurrent.CountDownLatch;

public class Countdownlatch {
    // CountDownLatch

    // CountDownLatch

    /*
     * Bantuan sinkronisasi yang memungkinkan satu atau lebih thread menunggu hingga
     * serangkaian operasi yang dilakukan di thread lain selesai.
     */

    /*
     * 1. CountDownLatch diinisialisasi dengan hitungan tertentu.
     * 2. Metode menunggu diblokir hingga hitungan saat ini mencapai nol karena
     * pemanggilan metode countDown(),
     * setelah itu semua thread yang menunggu dilepaskan dan pemanggilan waiting
     * berikutnya akan segera dikembalikan.
     * 3. Ini adalah fenomena sekali pakai—penghitungan tidak dapat diatur ulang.
     * Jika Anda memerlukan versi yang mengatur ulang hitungan,
     * pertimbangkan untuk menggunakan CyclicBarrier.
     */

    // Key Methods:
    // public void await() throws InterruptedException

    /*
     * Menyebabkan thread saat ini menunggu hingga kait menghitung mundur hingga
     * nol, kecuali thread tersebut diinterupsi.
     */

    // public void countDown()

    /*
     * Mengurangi jumlah kait, melepaskan semua thread yang menunggu jika jumlah
     * mencapai nol.
     */

    // contoh:

    /*
     * import java.util.concurrent.*;
     * class DoSomethingInAThread implements Runnable {
     * CountDownLatch latch;
     * public DoSomethingInAThread(CountDownLatch latch) {
     * this.latch = latch;
     * }
     * public void run() {
     * try {
     * System.out.println("Do some thing");
     * latch.countDown();
     * } catch(Exception err) {
     * err.printStackTrace();
     * }
     * }
     * }
     * public class CountDownLatchDemo {
     * public static void main(String[] args) {
     * try {
     * int numberOfThreads = 5;
     * if (args.length < 1) {
     * System.out.println("Usage: java CountDownLatchDemo numberOfThreads");
     * return;
     * }
     * try {
     * numberOfThreads = Integer.parseInt(args[0]);
     * } catch(NumberFormatException ne) {
     * 
     * }
     * CountDownLatch latch = new CountDownLatch(numberOfThreads);
     * for (int n = 0; n < numberOfThreads; n++) {
     * Thread t = new Thread(new DoSomethingInAThread(latch));
     * t.start();
     * }
     * latch.await();
     * System.out.println("In Main thread after completion of " + numberOfThreads +
     * "
     * threads");
     * } catch(Exception err) {
     * err.printStackTrace();
     * }
     * }
     * }
     */

    // hasil:
    /*
     * java CountDownLatchDemo 5
     * Do some thing
     * Do some thing
     * Do some thing
     * Do some thing
     * Do some thing
     * In Main thread after completion of 5 threads
     */

    /*
     * penjelasan:
     * 1. CountDownLatch diinisialisasi dengan penghitung 5 di thread Utama
     * 2. Thread utama sedang menunggu dengan menggunakan metode await().
     * 3. Lima contoh DoSomethingInAThread telah dibuat. Setiap instance mengurangi
     * penghitung dengan metode countDown().
     * 4. Setelah penghitung menjadi nol, Thread utama akan dilanjutkan
     */

    public static void main(String[] args) throws Exception {
        try {
            int numberOfThreads = 5;
            if (args.length < 1) {
                System.out.println("Usage: java CountDownLatchDemo numberOfThreads");
                return;
            }
            try {
                numberOfThreads = Integer.parseInt(args[0]);
            } catch (NumberFormatException ne) {

            }
            CountDownLatch latch = new CountDownLatch(numberOfThreads);
            for (int n = 0; n < numberOfThreads; n++) {
                Thread t = new Thread(new DoSomethingInAThread(latch));
                t.start();
            }
            latch.await();
            System.out.println("In Main thread after completion of " + numberOfThreads + "threads");
        } catch (Exception err) {
            err.printStackTrace();
        }
        /*
         * output:
         * Usage: java CountDownLatchDemo numberOfThreads
         */
    }
}
