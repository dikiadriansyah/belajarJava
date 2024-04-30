import java.util.concurrent.*;

public class Semaphore {
    // Semaphore/Tiang sinyal

    /*
     * Semaphore adalah sinkronisasi tingkat tinggi yang memelihara serangkaian izin
     * yang dapat diperoleh dan dilepaskan oleh thread. Semaphore dapat dibayangkan
     * sebagai penghitung izin yang akan dikurangi ketika sebuah thread diperoleh,
     * dan bertambah ketika thread dilepaskan. Jika jumlah izin adalah 0 ketika
     * sebuah thread mencoba memperoleh, maka
     * thread akan diblokir hingga izin diberikan (atau hingga thread diinterupsi).
     * 
     * Semaphore diinisialisasi sebagai:
     * Semaphore semaphore = new Semaphore(1); // The int value being the number of
     * permits
     */

    /*
     * Konstruktor Semaphore menerima parameter boolean tambahan untuk keadilan.
     * Jika disetel false, kelas ini akan menghasilkan
     * tidak ada jaminan tentang urutan thread memperoleh izin. Ketika keadilan
     * menjadi kenyataan, semaphore menjamin bahwa thread yang meminta false satu
     * metode perolehan dipilih untuk mendapatkan izin sesuai urutannya
     * pemanggilan mereka terhadap metode tersebut telah diproses. Hal ini
     * dinyatakan dengan cara berikut:
     * Semaphore semaphore = new Semaphore(1, true);
     */

    /*
     * Sekarang mari kita lihat contoh dari javadocs, di mana Semaphore digunakan
     * untuk mengontrol akses ke kumpulan item. Semaphore digunakan dalam contoh ini
     * untuk menyediakan fungsionalitas pemblokiran untuk memastikan bahwa selalu
     * ada item untuk diperoleh ketika getItem() dipanggil.
     */

    /*
     * class Pool {
     * //Note that this DOES NOT bound the amount that may be released!
     * // This is only a starting value for the Semaphore and has no other
     * //significant meaning UNLESS you enforce this inside of the
     * // getNextAvailableItem() and markAsUnused() methods
     * 
     * private static final int MAX_AVAILABLE = 100;
     * private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
     * 
     * //Obtains the next available item and reduces the permit count by 1.
     * // If there are no items available, block.
     * 
     * public Object getItem() throws InterruptedException {
     * available.acquire();
     * return getNextAvailableItem();
     * }
     * 
     * 
     * // Puts the item into the pool and add 1 permit.
     * 
     * public void putItem(Object x) {
     * if (markAsUnused(x))
     * available.release();
     * }
     * private Object getNextAvailableItem() {
     * // Implementation
     * }
     * private boolean markAsUnused(Object o) {
     * // Implementation
     * }
     * }
     * 
     */

    public static void main(String[] args) throws Exception {
        Pool pool = new Pool();

        // Obtain items from the pool
        try {
            Object item1 = pool.getItem();
            System.out.println("Item 1 obtained: " + item1);

            Object item2 = pool.getItem();
            System.out.println("Item 2 obtained: " + item2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return items to the pool
        Object itemToReturn = new Object(); // Assuming this is the item you want to return
        pool.putItem(itemToReturn);
        System.out.println("Item returned to the pool: " + itemToReturn);

        /*
         * output:
         * Item 1 obtained: null
         * Item 2 obtained: null
         * Item returned to the pool: java.lang.Object@1517365b
         */
    }
}
