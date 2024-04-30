import java.util.concurrent.ThreadFactory;

public class Creating_a_javalang_thread_instance {
    // Creating a java.lang.Thread instance/Membuat instance java.lang.Thread

    /*
     * Ada dua pendekatan utama untuk membuat thread di Java. Intinya membuat thread
     * semudah menulis
     * kode yang akan dieksekusi di dalamnya. Kedua pendekatan tersebut berbeda
     * dalam cara Anda mendefinisikan kode tersebut.
     * 
     * Di Java, thread diwakili oleh object - instance dari java.lang.Thread atau
     * subkelasnya. Jadi pendekatan pertama adalah
     * untuk membuat subkelas tersebut dan mengganti metode run().
     * 
     * Catatan: Saya akan menggunakan Thread untuk merujuk ke kelas java.lang.Thread
     * dan thread untuk merujuk pada konsep logika thread.
     */

    /*
     * class MyThread extends Thread {
     * 
     * @Override
     * public void run() {
     * for (int i = 0; i < 10; i++) {
     * System.out.println("Thread running!");
     * }
     * }
     * }
     */

    // Sekarang karena kita sudah mendefinisikan kode yang akan dieksekusi, thread
    // dapat dibuat hanya sebagai:
    // MyThread t = new MyThread();

    /*
     * Kelas Thread juga berisi konstruktor yang menerima string, yang akan
     * digunakan sebagai nama thread. Ini bisa sangat berguna ketika melakukan debug
     * pada program multi thread.
     */

    /*
     * class MyThread extends Thread {
     * public MyThread(String name) {
     * super(name);
     * }
     * 
     * @Override
     * public void run() {
     * for (int i = 0; i < 10; i++) {
     * System.out.println("Thread running! ");
     * }
     * }
     * }
     * MyThread t = new MyThread("Greeting Producer");
     */

    /*
     * Pendekatan kedua adalah mendefinisikan kode menggunakan java.lang.Runnable
     * dan satu-satunya metode run(). Kelas thread
     * kemudian memungkinkan Anda menjalankan metode itu di thread terpisah. Untuk
     * mencapai hal ini, buat thread menggunakan konstruktor yang menerima instance
     * Runnable interface.
     */
    // Thread t = new Thread(aRunnable);

    // Ini bisa menjadi sangat berguna bila dikombinasikan dengan lambda atau
    // referensi metode (hanya Java 8):
    // Thread t = new Thread(operator::hardWork)

    // Anda juga dapat menentukan nama threadnya
    // Thread t = new Thread(operator::hardWork, "Pi operator");

    /*
     * Secara praktis, Anda dapat menggunakan kedua pendekatan tersebut tanpa
     * khawatir. Namun kebijaksanaan umum mengatakan untuk menggunakan yang
     * terakhir.
     */

    /*
     * Untuk masing-masing dari empat konstruktor yang disebutkan, ada juga
     * alternatif yang menerima contoh
     * java.lang.ThreadGroup sebagai parameter pertama.
     */
    /*
     * ThreadGroup tg = new ThreadGroup("Operators");
     * Thread t = new Thread(tg, operator::hardWork, "PI operator");
     * 
     */

    /*
     * ThreadGroup mewakili sekumpulan thread. Anda hanya dapat menambahkan Thread
     * ke ThreadGroup menggunakan Thread
     * konstruktor. ThreadGroup kemudian dapat digunakan untuk mengelola semua
     * Thread-nya secara bersamaan, serta Thread dapat memperoleh keuntungan
     * informasi dari ThreadGroup-nya.
     */

    /*
     * Jadi untuk meringkas, Thread dapat dibuat dengan salah satu konstruktor
     * publik berikut:
     */

    /*
     * Thread()
     * Thread(String name)
     * Thread(Runnable target)
     * Thread(Runnable target, String name)
     * Thread(ThreadGroup group, String name)
     * Thread(ThreadGroup group, Runnable target)
     * Thread(ThreadGroup group, Runnable target, String name)
     * Thread(ThreadGroup group, Runnable target, String name, long stackSize)
     */

    // Yang terakhir memungkinkan kita menentukan ukuran tumpukan yang diinginkan
    // untuk thread baru.
    /*
     * Seringkali keterbacaan kode terganggu ketika membuat dan mengonfigurasi
     * banyak Thread dengan properti yang sama atau dari
     * pola yang sama. Saat itulah java.util.concurrent.ThreadFactory dapat
     * digunakan. Antarmuka ini memungkinkan Anda untuk merangkum
     * prosedur pembuatan thread melalui pola pabrik dan satu-satunya metode
     * newThread (Runnable).
     */

    /*
     * class WorkerFactory implements ThreadFactory {
     * private int id = 0;
     * 
     * @Override
     * public Thread newThread(Runnable r) {
     * return new Thread(r, "Worker " + id++);
     * }
     * }
     */

    public static void main(String[] args) throws InterruptedException {
        // MyThread t = new MyThread("Greeting Producer");
        // t.start(); // Memulai thread
        /*
         * output:
         * Thread running!
         * Thread running!
         * Thread running!
         * Thread running!
         * Thread running!
         * Thread running!
         * Thread running!
         * Thread running!
         * Thread running!
         * Thread running!
         */
        // -----------------------
        WorkerFactory factory = new WorkerFactory();

        // Membuat runnable
        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing task 1");
        };

        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing task 2");
        };

        // Membuat thread dengan menggunakan WorkerFactory
        Thread thread1 = factory.newThread(task1);
        Thread thread2 = factory.newThread(task2);

        // Memulai eksekusi thread
        thread1.start();
        thread2.start();
        /*
         * output:
         * Worker 1 is executing task 2
         * Worker 0 is executing task 1
         */
    }
}
