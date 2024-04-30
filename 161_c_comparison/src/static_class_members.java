public class static_class_members {
    // Static Class Members
    /*
     * Anggota statis memiliki cakupan kelas dan bukan cakupan objek
     */

    /*
     * C++ Example
     * // define in header
     * class Singleton {
     * public:
     * static Singleton *getInstance();
     * private:
     * Singleton() {}
     * static Singleton *instance;
     * };
     * // initialize in .cpp
     * Singleton* Singleton::instance = 0;
     */

    /*
     * Java Example
     * public class Singleton {
     * private static Singleton instance;
     * 
     * private Singleton() {}
     * 
     * public static Singleton getInstance() {
     * if(instance == null) {
     * instance = new Singleton();
     * }
     * return instance;
     * }
     * }
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Memanggil getInstance() untuk mendapatkan instance Singleton
        Singleton4 singleton1 = Singleton4.getInstance();
        Singleton4 singleton2 = Singleton4.getInstance();

        // Menguji apakah kedua instance tersebut sama
        if (singleton1 == singleton2) {
            System.out.println("singleton1 dan singleton2 adalah instance yang sama.");
        } else {
            System.out.println("singleton1 dan singleton2 adalah instance yang berbeda.");
        }
        /*
         * output:
         * singleton1 dan singleton2 adalah instance yang sama.
         */
    }
}
