import java.util.concurrent.atomic.AtomicInteger;

public class Motivation_for_atomic_types {
    // Motivation for Atomic Types/Motivasi untuk Tipe Atom

    /*
     * Cara sederhana untuk mengimplementasikan aplikasi multi-thread adalah dengan
     * menggunakan sinkronisasi bawaan Java dan penguncian primitif; misalnya kata
     * kunci yang synchronized. Contoh berikut menunjukkan bagaimana kita dapat
     * menggunakan synchronized untuk mengumpulkan jumlah.
     */

    /*
     * public class Counters {
     * private final int[] counters;
     * public Counters(int nosCounters) {
     * counters = new int[nosCounters];
     * }
     * 
     * //Increments the integer at the given index
     * public synchronized void count(int number) {
     * if (number >= 0 && number < counters.length) {
     * counters[number]++;
     * }
     * }
     * 
     * 
     * //Obtains the current count of the number at the given index,
     * //or if there is no number at that index, returns 0.
     * public synchronized int getCount(int number) {
     * return (number >= 0 && number < counters.length) ? counters[number] : 0;
     * }
     * }
     * 
     * 
     */

    /*
     * Implementasi ini akan bekerja dengan benar. Namun, jika Anda memiliki jumlah
     * thread yang banyak, hasilkan banyak
     * panggilan simultan pada objek Counters yang sama, sinkronisasi dapat menjadi
     * hambatan. Secara khusus:
     * 1. Setiap pemanggilan metode yang synchronized akan dimulai dengan thread
     * saat ini yang memperoleh kunci untuk instance Counters.
     * 2. Thread akan menahan kunci saat memeriksa nilai angka dan memperbarui
     * penghitung.
     * 3. Akhirnya, itu akan melepaskan kunci, memungkinkan akses thread lain.
     */

    /*
     * Jika satu thread mencoba untuk mendapatkan kunci sementara thread lain
     * menahannya, thread yang mencoba tersebut akan diblokir (dihentikan) pada
     * langkah 1 hingga kunci tersebut dilepaskan. Jika ada beberapa utas yang
     * menunggu, salah satu dari mereka akan mendapatkannya, dan yang lainnya akan
     * terus diblokir.
     * Hal ini dapat menyebabkan beberapa masalah:
     * 1. Jika ada banyak pertentangan untuk kunci tersebut (yaitu banyak thread
     * yang mencoba mendapatkannya), maka beberapa thread dapat diblokir untuk waktu
     * yang lama.
     * 2. Ketika thread diblokir menunggu kunci, sistem operasi biasanya akan
     * mencoba mengalihkan eksekusi ke thread lain. Peralihan konteks ini
     * menimbulkan dampak kinerja yang relatif besar pada prosesor.
     * 3. Ketika ada beberapa thread yang diblokir pada kunci yang sama, tidak ada
     * jaminan bahwa salah satu dari thread tersebut akan diperlakukan "secara adil"
     * (yaitu setiap thread dijamin akan dijadwalkan untuk berjalan). Hal ini dapat
     * menyebabkan kelaparan benang.
     */

    /*
     * Bagaimana cara mengimplementasikan Tipe Atom?
     * Mari kita mulai dengan menulis ulang contoh di atas menggunakan penghitung
     * AtomicInteger:
     * 
     * public class Counters {
     * private final AtomicInteger[] counters;
     * public Counters(int nosCounters) {
     * counters = new AtomicInteger[nosCounters];
     * for (int i = 0; i < nosCounters; i++) {
     * counters[i] = new AtomicInteger();
     * }
     * }
     * //Increments the integer at the given index
     * 
     * public void count(int number) {
     * if (number >= 0 && number < counters.length) {
     * counters[number].incrementAndGet();
     * }
     * }
     * 
     * 
     * //Obtains the current count of the object at the given index,
     * //or if there is no number at that index, returns 0.
     * 
     * public int getCount(int number) {
     * return (number >= 0 && number < counters.length) ?
     * counters[number].get() : 0;
     * }
     * }
     */

    /*
     * Kami telah mengganti int[] dengan AtomicInteger[], dan menginisialisasinya
     * dengan sebuah instance di setiap elemen. Kami juga telah menambahkan
     * panggilan ke incrementAndGet() dan get() sebagai pengganti operasi pada nilai
     * int.
     * 
     * Namun yang paling penting adalah kita dapat menghapus kata kunci
     * synchronized karena penguncian tidak diperlukan lagi. Ini berfungsi karena
     * operasi incrementAndGet() dan get() bersifat atomik dan aman untuk thread.
     * Dalam konteks ini, artinya:
     * 1. Setiap penghitung dalam array hanya akan dapat diamati dalam keadaan
     * "sebelum" untuk suatu operasi (seperti "peningkatan") atau dalam keadaan
     * "sesudah".
     * 2. Dengan asumsi bahwa operasi terjadi pada waktu T, tidak ada thread yang
     * dapat melihat status "sebelum" setelah waktu T.
     */

    /*
     * Selain itu, meskipun dua thread sebenarnya mencoba memperbarui instance
     * AtomicInteger yang sama pada saat yang sama, implementasi operasi memastikan
     * bahwa hanya satu kenaikan yang terjadi pada satu waktu pada instance
     * tertentu. Hal ini dilakukan tanpa mengunci, seringkali menghasilkan kinerja
     * yang lebih baik.
     * 
     * Bagaimana cara kerja Tipe Atom?
     * Tipe atom biasanya bergantung pada instruksi perangkat keras khusus dalam set
     * instruksi mesin target. Misalnya, set instruksi berbasis Intel menyediakan
     * instruksi CAS (Bandingkan dan Tukar) yang akan melakukan urutan operasi
     * memori tertentu secara atom.
     * Instruksi tingkat rendah ini digunakan untuk mengimplementasikan operasi
     * tingkat tinggi di API masing-masing
     * Kelas Atomicxxx. Misalnya, (sekali lagi, dalam pseudocode mirip C):
     */

    /*
     * private volatile num;
     * int increment() {
     * while (TRUE) {
     * int old = num;
     * int new = old + 1;
     * if (old == compare_and_swap(&num, old, new)) {
     * return new;
     * }
     * }
     * }
     */

    /*
     * Jika tidak ada pertikaian di AtomicXxxx, pengujian if akan berhasil dan loop
     * akan segera berakhir. Jika ada perselisihan, maka if akan gagal untuk semua
     * kecuali satu thread, dan thread tersebut akan "berputar" dalam loop selama
     * sejumlah kecil siklus loop. Dalam praktiknya, perputaran tersebut jauh lebih
     * cepat (kecuali pada tingkat yang sangat tinggi
     * pertentangan, di mana sinkronisasi berkinerja lebih baik daripada kelas atom
     * karena ketika operasi CAS gagal, maka percobaan ulang hanya akan menambah
     * lebih banyak pertentangan) daripada menangguhkan thread dan beralih ke yang
     * lain.
     * 
     * Kebetulan, instruksi CAS biasanya digunakan oleh JVM untuk
     * mengimplementasikan penguncian tanpa hambatan. Jika JVM dapat melihat bahwa
     * kunci saat ini tidak terkunci, JVM akan mencoba menggunakan CAS untuk
     * memperoleh kunci tersebut. Jika CAS berhasil, maka tidak perlu melakukan
     * penjadwalan thread yang mahal, peralihan konteks, dan sebagainya. Untuk
     * informasi lebih lanjut mengenai teknik yang digunakan, lihat Penguncian Bias
     * di HotSpot.
     */
    // ------------------
    // private final AtomicInteger[] counters;

    // public Motivation_for_atomic_types(int nosCounters) {
    // counters = new AtomicInteger[nosCounters];
    // for (int i = 0; i < nosCounters; i++) {
    // counters[i] = new AtomicInteger();
    // }
    // }

    /**
     * Increments the integer at the given index
     */
    // public void count(int number) {
    // if (number >= 0 && number < counters.length) {
    // counters[number].incrementAndGet();
    // }
    // }

    /**
     * Obtains the current count of the object at the given index,
     * or if there is no number at that index, returns 0.
     */
    // public int getCount(int number) {
    // return (number >= 0 && number < counters.length) ? counters[number].get() :
    // 0;
    // }
    // -------------------------------
    private volatile int num;

    public int increment() {
        while (true) {
            int old = num;
            int newNum = old + 1;
            if (old == compareAndSwap(old, newNum)) {
                return newNum;
            }
        }
    }

    // Metode untuk melakukan operasi compare-and-swap
    private synchronized int compareAndSwap(int oldValue, int newValue) {
        if (num == oldValue) {
            num = newValue;
            return oldValue;
        } else {
            return num;
        }
    }

    public static void main(String[] args) throws Exception {
        // Motivation_for_atomic_types counters = new Motivation_for_atomic_types(5);

        // Increment counters
        // counters.count(0);
        // counters.count(1);
        // counters.count(2);
        // counters.count(1);
        // counters.count(2);
        // counters.count(2);

        // Get counts
        // for (int i = 0; i < 5; i++) {
        // System.out.println("Counter " + i + ": " + counters.getCount(i));
        // }
        /*
         * output:
         * Counter 0: 1
         * Counter 1: 2
         * Counter 2: 3
         * Counter 3: 0
         * Counter 4: 0
         */
        // ------------------
        Motivation_for_atomic_types counters = new Motivation_for_atomic_types();
        System.out.println("Incremented value: " + counters.increment()); // output:Incremented value: 1
    }
}
