public class Pitfall_incorrect_use_of_wait_notify {
    // Pitfall: incorrect use of wait() / notify()/Kesalahan: penggunaan wait() /
    // notify() yang salah

    /*
     * Metode object.wait(), object.notify() dan object.notifyAll() dimaksudkan
     * untuk digunakan dalam kondisi yang sangat spesifik
     * jalan. (lihat http://stackoverflow.com/documentation/java/5409/wait-notify#t=
     * 20160811161648303307 )
     */
    // The "Lost Notification" problem/Masalah "Pemberitahuan Hilang".

    // Salah satu kesalahan umum pemula adalah memanggil objek.wait() tanpa syarat

    /*
     * private final Object lock = new Object();
     * public void myConsumer() {
     * synchronized (lock) {
     * lock.wait(); // DON'T DO THIS!!
     * }
     * doSomething();
     * }
     */

    /*
     * Alasan mengapa hal ini salah adalah karena panggilan lock.notify() atau
     * lock.notifyAll() bergantung pada thread lain, tetapi
     * tidak ada yang menjamin bahwa thread lain tidak melakukan panggilan tersebut
     * sebelum thread konsumen bernama lock.wait().
     * 
     * lock.notify() dan lock.notifyAll() tidak melakukan apa pun jika thread lain
     * belum menunggu notifikasi. Thread yang memanggil myConsumer() dalam contoh
     * ini akan hang selamanya jika terlambat untuk menangkap notifikasi.
     */

    // The "Illegal Monitor State" bug/Bug "Status Monitor Ilegal".

    /*
     * Jika Anda memanggil wait() atau notify() pada suatu objek tanpa menahan
     * kuncinya, maka JVM akan melempar IlegalMonitorStateException.
     */

    /*
     * public void myConsumer() {
     * lock.wait(); // throws exception
     * consume();
     * }
     * public void myProducer() {
     * produce();
     * lock.notify(); // throws exception
     * }
     * 
     */

    /*
     * (Desain untuk wait() / notify() mengharuskan kunci ditahan karena hal ini
     * diperlukan untuk menghindari kondisi balapan yang sistemik. Jika memungkinkan
     * untuk memanggil wait() atau notify() tanpa mengunci, maka penerapannya tidak
     * mungkin dilakukan kasus penggunaan utama untuk primitif ini: menunggu suatu
     * kondisi terjadi.)
     */

    // Wait / notify is too low-level / Tunggu / beri tahu levelnya terlalu rendah

    /*
     * Cara terbaik untuk menghindari masalah dengan wait() dan notify() adalah
     * dengan tidak menggunakannya. Sebagian besar masalah sinkronisasi dapat
     * diselesaikan dengan menggunakan objek sinkronisasi tingkat tinggi (queues,
     * barriers, semaphores, dll.) yang tersedia dalam paket java.utils.concurrent.
     */

    public static void main(String[] args) throws Exception {

    }

    private final Object lock = new Object();

    public void myConsumer() {
        synchronized (lock) {
            lock.wait(); // DON'T DO THIS!!
        }
        doSomething();
    }
}
