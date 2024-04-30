import java.util.*;

public class Treemap_and_teeset_thread_safety {
    // TreeMap and TreeSet Thread Safety

    /*
     * TreeMap dan TreeSet bukan koleksi thread-safe, jadi harus berhati-hati untuk
     * memastikannya saat digunakan dalam program multi-thread.
     * 
     * TreeMap dan TreeSet aman ketika dibaca, bahkan secara bersamaan, oleh
     * beberapa thread. Jadi jika mereka telah diciptakan
     * dan diisi oleh satu thread (misalnya, pada awal program), dan baru kemudian
     * dibaca, tetapi tidak diubah oleh banyak thread
     * utas, tidak ada alasan untuk sinkronisasi atau penguncian.
     * 
     * Namun, jika dibaca dan dimodifikasi secara bersamaan, atau dimodifikasi
     * secara bersamaan oleh lebih dari satu thread, koleksi mungkin memunculkan
     * ConcurrentModificationException atau berperilaku tidak terduga. Dalam kasus
     * ini, sangat penting untuk menyinkronkan/mengunci akses ke koleksi menggunakan
     * salah satu pendekatan berikut:
     */
    public static void main(String[] args) {
        // 1. gunakan Collections.synchronizedSorted..:
        // SortedSet<Integer> set = Collections.synchronizedSortedSet(new
        // TreeSet<Integer>());
        // SortedMap<Integer, String> map = Collections.synchronizedSortedMap(new
        // TreeMap<Integer, String>());

        /*
         * Ini akan menyediakan implementasi SortedSet/SortedMap yang didukung oleh
         * koleksi sebenarnya, dan disinkronkan pada beberapa objek mutex. Perhatikan
         * bahwa ini akan menyinkronkan semua akses baca dan tulis ke koleksi pada satu
         * kunci, sehingga pembacaan bersamaan pun tidak dapat dilakukan.
         */
        // 2. Dengan menyinkronkan beberapa objek secara manual, seperti koleksi itu
        // sendiri:
        // TreeSet<Integer> set = new TreeSet<>();

        // Thread 1
        // synchronized (set) {
        // set.add(4);
        // }

        // Thread 2
        // synchronized (set) {
        // set.remove(5);
        // }

        // 3. Dengan menggunakan kunci, seperti ReentrantReadWriteLock:
        TreeSet<Integer> set = new TreeSet<>();
        // ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        // Thread 1
        // lock.writeLock().lock();
        // set.add(4);
        // lock.writeLock().unlock();

        // Thread 2
        // lock.readLock().lock();
        // set.contains(5);
        // lock.readLock().unlock();

        /*
         * Berbeda dengan metode sinkronisasi sebelumnya, penggunaan ReadWriteLock
         * memungkinkan beberapa thread membaca dari peta secara bersamaan
         */
    }
}
