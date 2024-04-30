import java.util.concurrent.atomic.AtomicIntegerArray;

public class Creating_atomic_types {
    // Creating Atomic Types/Membuat Tipe Atom

    /*
     * Untuk kode multi-utas sederhana, penggunaan sinkronisasi dapat diterima.
     * Namun, penggunaan sinkronisasi memang berdampak pada keaktifan, dan seiring
     * dengan semakin kompleksnya basis kode, semakin besar kemungkinan Anda akan
     * berakhir dengan Deadlock, Starvation, atau Livelock.
     */

    /*
     * Dalam kasus konkurensi yang lebih kompleks, penggunaan Variabel Atom sering
     * kali merupakan alternatif yang lebih baik, karena memungkinkan variabel
     * individual diakses dengan cara yang aman untuk thread tanpa perlu menggunakan
     * metode atau blok kode yang disinkronkan.
     * 
     * Membuat tipe AtomicInteger:
     * 
     * AtomicInteger aInt = new AtomicInteger() // Create with default value 0
     * AtomicInteger aInt = new AtomicInteger(1) // Create with initial value 1
     */

    // Demikian pula untuk tipe instans lainnya.
    /*
     * AtomicIntegerArray aIntArray = new AtomicIntegerArray(10) // Create array of
     * specific length
     * AtomicIntegerArray aIntArray = new AtomicIntegerArray(new int[] {1, 2, 3}) //
     * Initialize array with
     * another array
     */

    /*
     * Demikian pula untuk tipe atom lainnya.
     * Ada pengecualian bahwa tidak ada tipe float dan double. Ini dapat
     * disimulasikan melalui penggunaan
     * Float.floatToIntBits(float) dan Float.intBitsToFloat(int) untuk float serta
     * Double.doubleToLongBits(double) dan Double.longBitsToDouble(long) untuk
     * doubles.
     */

    /*
     * Jika Anda ingin menggunakan sun.misc.Unsafe Anda dapat menggunakan variabel
     * primitif apa pun sebagai atom dengan menggunakan operasi atom di
     * sun.misc.Unsafe. Semua tipe primitif harus dikonversi atau dikodekan dalam
     * int atau long untuk menggunakannya dengan cara ini. Untuk lebih lanjut
     * tentang ini lihat: sun.misc.Unsafe.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ------------------
        // Create array of specific length
        AtomicIntegerArray aIntArray1 = new AtomicIntegerArray(10);
        for (int i = 0; i < aIntArray1.length(); i++) {
            aIntArray1.set(i, i * 2); // Set values of array
        }
        System.out.println("AtomicIntegerArray 1:");
        for (int i = 0; i < aIntArray1.length(); i++) {
            System.out.println("Index " + i + ": " + aIntArray1.get(i)); // Get values of array
        }
        /*
         * output:
         * AtomicIntegerArray 1:
         * Index 0: 0
         * Index 1: 2
         * Index 2: 4
         * Index 3: 6
         * Index 4: 8
         * Index 5: 10
         * Index 6: 12
         * Index 7: 14
         * Index 8: 16
         * Index 9: 18
         */

        // Initialize array with another array
        int[] initialValues = { 1, 2, 3 };
        AtomicIntegerArray aIntArray2 = new AtomicIntegerArray(initialValues);
        System.out.println("\nAtomicIntegerArray 2:");
        for (int i = 0; i < aIntArray2.length(); i++) {
            System.out.println("Index " + i + ": " + aIntArray2.get(i)); // Get values of array
        }
        /*
         * output:
         * AtomicIntegerArray 2:
         * Index 0: 1
         * Index 1: 2
         * Index 2: 3
         */

    }
}
