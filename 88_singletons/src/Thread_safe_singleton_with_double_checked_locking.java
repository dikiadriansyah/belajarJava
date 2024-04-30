public class Thread_safe_singleton_with_double_checked_locking {
    // Thread safe Singleton with double checked locking/Thread safe Singleton
    // dengan penguncian ganda

    /*
     * Jenis Singleton ini aman untuk thread, dan mencegah penguncian yang tidak
     * perlu setelah instance Singleton dibuat.
     */

    /*
     * Version ≥ Java SE 5
     * public class MySingleton {
     * // instance of class
     * private static volatile MySingleton instance = null;
     * // Private constructor
     * private MySingleton() {
     * // Some code for constructing object
     * }
     * public static MySingleton getInstance() {
     * MySingleton result = instance;
     * 
     * //If the instance already exists, no locking is necessary
     * if(result == null) {
     * //The singleton instance doesn't exist, lock and check again
     * synchronized(MySingleton.class) {
     * result = instance;
     * if(result == null) {
     * instance = result = new MySingleton();
     * }
     * }
     * }
     * return result;
     * }
     * }
     */

    /*
     * Perlu ditekankan -- pada versi sebelum Java SE 5, penerapan di atas tidak
     * benar dan harus dihindari. Tidak mungkin menerapkan penguncian yang diperiksa
     * ulang dengan benar di Java sebelum Java 5.
     */

    // instance of class
    private static volatile Thread_safe_singleton_with_double_checked_locking instance = null;

    // Private constructor
    private Thread_safe_singleton_with_double_checked_locking() {
        // Some code for constructing object

    }

    public static Thread_safe_singleton_with_double_checked_locking getInstance() {
        Thread_safe_singleton_with_double_checked_locking result = instance;

        // If the instance already exists, no locking is necessary
        if (result == null) {
            // The singleton instance doesn't exist, lock and check again
            synchronized (Thread_safe_singleton_with_double_checked_locking.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Thread_safe_singleton_with_double_checked_locking();
                }
            }
        }
        return result;
    }

    // Sample method
    public void someMethod() {
        System.out.println("Inside singleton method");
    }

    public static void main(String[] args) {
        Thread_safe_singleton_with_double_checked_locking singleton1 = Thread_safe_singleton_with_double_checked_locking
                .getInstance();
        Thread_safe_singleton_with_double_checked_locking singleton2 = Thread_safe_singleton_with_double_checked_locking
                .getInstance();

        // Both references should point to the same object
        System.out.println("Are both singletons same instance? " + (singleton1 == singleton2)); // Should print true
        /*
         * output:
         * Are both singletons same instance? true
         */

        // Accessing a method of singleton
        singleton1.someMethod();
        /*
         * output:
         * Inside singleton method
         */
    }
}
