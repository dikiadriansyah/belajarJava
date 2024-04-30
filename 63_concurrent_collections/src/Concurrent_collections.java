import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Concurrent_collections {
    // Concurrent Collections / Koleksi Bersamaan

    /*
     * Koleksi serentak adalah generalisasi dari koleksi thread-safe, yang
     * memungkinkan penggunaan lebih luas secara bersamaan
     * lingkungan.
     * 
     * Meskipun koleksi thread-safe memiliki penambahan atau penghapusan elemen yang
     * aman dari beberapa thread, namun hal tersebut belum tentu demikian
     * memiliki iterasi yang aman dalam konteks yang sama (seseorang mungkin tidak
     * dapat melakukan iterasi dengan aman melalui koleksi dalam satu thread,
     * sementara yang lain memodifikasinya dengan menambahkan/menghapus elemen).
     * 
     * Di sinilah koleksi bersamaan digunakan.
     * 
     * Karena iterasi sering kali merupakan implementasi dasar dari beberapa metode
     * massal dalam koleksi, seperti addAll, deleteAll, atau juga
     * collection copying (melalui konstruktor, atau cara lain), pengurutan, ...
     * kasus penggunaan untuk koleksi bersamaan adalah
     * sebenarnya cukup besar.
     */

    /*
     * Misalnya, Java SE 5 java.util.concurrent.CopyOnWriteArrayList adalah Daftar
     * thread yang aman dan bersamaan implementasi, javadoc menyatakan:
     * 
     * Metode iterator gaya "snapshot" menggunakan referensi ke status array pada
     * titik pembuatan iterator. Array ini tidak pernah berubah selama masa pakai
     * iterator, sehingga interferensi tidak mungkin terjadi dan iterator dijamin
     * tidak akan memunculkan ConcurrentModificationException.
     */

    // Oleh karena itu, kode berikut ini aman:

    /*
     * public class ThreadSafeAndConcurrent {
     * public static final List<Integer> LIST = new CopyOnWriteArrayList<>();
     * public static void main(String[] args) throws InterruptedException {
     * Thread modifier = new Thread(new ModifierRunnable());
     * Thread iterator = new Thread(new IteratorRunnable());
     * modifier.start();
     * iterator.start();
     * modifier.join();
     * iterator.join();
     * }
     * public static final class ModifierRunnable implements Runnable {
     * 
     * @Override
     * public void run() {
     * try {
     * for (int i = 0; i < 50000; i++) {
     * LIST.add(i);
     * }
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * public static final class IteratorRunnable implements Runnable {
     * 
     * @Override
     * public void run() {
     * try {
     * for (int i = 0; i < 10000; i++) {
     * long total = 0;
     * for(Integer inList : LIST) {
     * total += inList;
     * }
     * System.out.println(total);
     * }
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * }
     * 
     */

    // Koleksi bersamaan lainnya mengenai iterasi adalah ConcurrentLinkedQueue, yang
    // menyatakan :

    /*
     * Iterator memiliki konsistensi yang lemah, mengembalikan elemen yang
     * mencerminkan keadaan antrian di beberapa titik di atau
     * sejak pembuatan iterator. Mereka tidak membuang
     * java.util.ConcurrentModificationException, dan mungkin
     * melanjutkan bersamaan dengan operasi lainnya. Elemen yang terdapat dalam
     * antrian sejak pembuatan iterator akan dikembalikan tepat satu kali.
     */

    /*
     * Seseorang harus memeriksa javadocs untuk melihat apakah suatu koleksi
     * bersamaan, atau tidak. Atribut iterator dikembalikan oleh
     * metode iterator() ("gagal cepat", "konsisten lemah", ...) adalah atribut
     * paling penting yang harus dicari.
     */

    // Thread safe but non concurrent examples/Contoh thread aman tetapi tidak
    // bersamaan

    /*
     * Pada kode di atas, ubah deklarasi LIST menjadi
     * public static final List<Integer> LIST = Collections.synchronizedList(new
     * ArrayList<>());
     */

    /*
     * Bisa (dan secara statistik akan terjadi pada sebagian besar arsitektur multi
     * CPU/inti modern) menyebabkan pengecualian.
     */

    /*
     * Koleksi yang disinkronkan dari metode utilitas Koleksi aman untuk
     * addition/removal elemen,
     * tetapi bukan iterasi (kecuali koleksi dasar yang diteruskan ke iterasi
     * tersebut sudah ada).
     */

    public static final List<Integer> LIST = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread modifier = new Thread(new ModifierRunnable());
        Thread iterator = new Thread(new IteratorRunnable());
        modifier.start();
        iterator.start();
        modifier.join();
        iterator.join();

        /*
         * output:
         * 1249975000
         * 1249975000
         * 1249975000
         * 1249975000
         * 1249975000
         * 1249975000
         */

    }

    public static final class ModifierRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 50000; i++) {
                    LIST.add(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final class IteratorRunnable implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
                    long total = 0;
                    for (Integer inList : LIST) {
                        total += inList;
                    }
                    System.out.println(total);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
