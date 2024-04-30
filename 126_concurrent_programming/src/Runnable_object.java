public class Runnable_object implements Runnable {
    // Runnable Object/

    /*
     * Runnable interface mendefinisikan satu metode, run(), yang dimaksudkan untuk
     * memuat kode yang dieksekusi di thread.
     * 
     * Runnable object diteruskan ke konstruktor Thread. Dan metode thread start()
     * dipanggil
     * 
     */

    // contoh
    /*
     * public class HelloRunnable implements Runnable {
     * 
     * @Override
     * public void run() {
     * System.out.println("Hello from a thread");
     * }
     * public static void main(String[] args) {
     * new Thread(new HelloRunnable()).start();
     * }
     * }
     */

    // contoh dalam java8
    /*
     * public static void main(String[] args) {
     * Runnable r = () -> System.out.println("Hello world");
     * new Thread(r).start();
     * }
     */

    // Runnable vs Thread subclass
    /*
     * Penggunaan Runnable object lebih umum, karena Runnable object dapat membuat
     * subkelas kelas selain Thread.
     * 
     * Subkelas thread lebih mudah digunakan dalam aplikasi sederhana, namun
     * dibatasi oleh fakta bahwa kelas tugas Anda harus merupakan turunan dari
     * Thread.
     * 
     * Runnable object berlaku untuk API manajemen thread tingkat tinggi
     */

    @Override
    public void run() {
        System.out.println("Hello from a thread");
    }

    public static void main(String[] args) {
        new Thread(new Runnable_object()).start();
        // output:
        // Hello from a thread
        // -----------------------------
        // Runnable r = () -> System.out.println("Hello world");
        // new Thread(r).start();
        // output: Hello World

    }

}
