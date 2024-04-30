public class Singleton_without_use_of_enum {
    // Singleton without use of Enum (eager initialization)/Singleton tanpa
    // menggunakan Enum (inisialisasi bersemangat)

    /*
     * public class Singleton {
     * private static final Singleton INSTANCE = new Singleton();
     * private Singleton() {}
     * public static Singleton getInstance() {
     * return INSTANCE;
     * }
     * }
     */

    /*
     * Dapat dikatakan bahwa contoh ini adalah inisialisasi yang lambat. Bagian
     * 12.4.1 of the java language specification menyatakan:
     * 
     * Kelas atau antarmuka tipe T akan diinisialisasi segera sebelum terjadinya
     * salah satu hal berikut ini:
     * 1. T is a class and an instance of T is created
     * 2. T is a class and a static method declared by T is invoked
     * 3. A static field declared by T is assigned
     * 4. A static field declared by T is used and the field is not a constant
     * variable
     * 5. T is a top level class, and an assert statement lexically nested within T
     * is executed.
     * 
     */

    /*
     * Oleh karena itu, selama tidak ada bidang statis atau metode statis lain di
     * kelas, instance Singleton tidak akan melakukannya
     * diinisialisasi hingga metode getInstance() dipanggil pertama kali.
     */

    public static void main(String[] args) {
        // Mendapatkan instance Singleton
        Singleton2 singleton1 = Singleton2.getInstance();

        // Mendapatkan instance Singleton lagi
        Singleton2 singleton2 = Singleton2.getInstance();

        // Mengecek apakah kedua instance adalah objek yang sama
        System.out.println("Apakah singleton1 dan singleton2 adalah objek yang sama? " + (singleton1 == singleton2));
        /*
         * output:
         * Instansi Singleton dibuat!
         * Apakah singleton1 dan singleton2 adalah objek yang sama? true
         */
    }
}
