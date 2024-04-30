public class Exclusive_write_concurrent_read_access {
    // Exclusive write / Concurrent read access / Akses tulis eksklusif/baca
    // bersamaan

    /*
     * Terkadang diperlukan suatu proses untuk menulis dan membaca "data" yang sama
     * secara bersamaan.
     * 
     * ReadWriteLock interface, dan implementasi ReentrantReadWriteLock memungkinkan
     * pola akses yang
     * dapat digambarkan sebagai berikut:
     * 1. Pembaca data secara bersamaan bisa berapa saja. Jika setidaknya ada satu
     * akses pembaca yang diberikan,
     * maka tidak ada akses penulis yang dimungkinkan.
     * 2. Paling banyak hanya ada satu penulis tunggal untuk data tersebut. Jika
     * akses penulis diberikan, maka tidak ada pembaca yang dapat mengakses data.
     */

    // Implementasinya bisa terlihat seperti:
    /*
     * import java.util.concurrent.locks.ReadWriteLock;
     * import java.util.concurrent.locks.ReentrantReadWriteLock;
     * public class Sample {
     * // Our lock. The constructor allows a "fairness" setting, which guarantees
     * the chronology of lock
     * attributions.
     * protected static final ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
     * // This is a typical data that needs to be protected for concurrent access
     * protected static int data = 0;
     * //This will write to the data, in an exclusive access
     * 
     * public static void writeToData() {
     * RW_LOCK.writeLock().lock();
     * try {
     * data++;
     * } finally {
     * RW_LOCK.writeLock().unlock();
     * }
     * }
     * public static int readData() {
     * RW_LOCK.readLock().lock();
     * try {
     * return data;
     * } finally {
     * RW_LOCK.readLock().unlock();
     * }
     * }
     * }
     */

    /*
     * CATATAN 1 : Kasus penggunaan khusus ini memiliki solusi yang lebih bersih
     * menggunakan AtomicInteger, tetapi yang dijelaskan di sini adalah akses
     * pola, yang berfungsi terlepas dari fakta bahwa data di sini adalah bilangan
     * bulat yang merupakan varian Atom.
     * CATATAN 2 : Kunci pada bagian membaca sangat diperlukan, meskipun mungkin
     * tidak terlihat demikian bagi pembaca biasa. Memang benar jika
     * Anda tidak mengunci sisi pembaca, ada beberapa hal yang bisa salah, di
     * antaranya:
     * 1. Penulisan nilai primitif tidak dijamin bersifat atomik di semua JVM,
     * sehingga pembaca dapat melihat mis. hanya 32bit dari 64bit menulis jika data
     * bertipe panjang 64bit
     * 2. Visibilitas penulisan dari thread yang tidak menjalankannya dijamin oleh
     * JVM hanya jika kita membuatnya
     * Terjadi Sebelum hubungan antara yang menulis dan yang dibaca. Hubungan ini
     * terjalin ketika pembaca dan penulis menggunakan kuncinya masing-masing,
     * tetapi tidak sebaliknya
     */

    // Version ≥ Java SE 8

    /*
     * Jika diperlukan kinerja yang lebih tinggi, dan dalam jenis penggunaan
     * tertentu, tersedia jenis kunci yang lebih cepat, yang disebut StampedLock,
     * yang antara lain menerapkan mode kunci optimis. Kunci ini bekerja sangat
     * berbeda dari ReadWriteLock, dan sampel ini tidak dapat dialihkan.
     */

    public static void main(String[] args) {
        // Menulis data
        Sample2.writeToData();

        // Membaca data
        int data = Sample2.readData();
        System.out.println("Data: " + data); // output: Data: 1
    }
}
