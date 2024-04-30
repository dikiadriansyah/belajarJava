public class Thread_safe_lazy_initialization_using_holder_class_bill_pugh_singleton_implementation {
    // Thread-safe lazy initialization using holder class | Bill Pugh Singleton
    // implementation / Inisialisasi malas yang aman untuk thread menggunakan kelas
    // holder | Implementasi Bill Pugh Singleton

    /*
     * public class Singleton {
     * private static class InstanceHolder {
     * static final Singleton INSTANCE = new Singleton();
     * }
     * public static Singleton getInstance() {
     * return InstanceHolder.INSTANCE;
     * }
     * private Singleton() {}
     * }
     * 
     */

    /*
     * Ini menginisialisasi variabel INSTANCE pada panggilan pertama ke
     * Singleton.getInstance(), memanfaatkan jaminan keamanan thread bahasa untuk
     * inisialisasi statis tanpa memerlukan sinkronisasi tambahan.
     * 
     * Implementasi ini juga dikenal sebagai pola tunggal Bill Pugh. [Wiki]
     */

    private static class InstanceHolder {
        static final Thread_safe_lazy_initialization_using_holder_class_bill_pugh_singleton_implementation INSTANCE = new Thread_safe_lazy_initialization_using_holder_class_bill_pugh_singleton_implementation();
    }

    public static Thread_safe_lazy_initialization_using_holder_class_bill_pugh_singleton_implementation getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private Thread_safe_lazy_initialization_using_holder_class_bill_pugh_singleton_implementation() {
    }

    public void doSomething() {
        System.out.println("Doing something...");
    }

    public static void main(String[] args) {
        // Contoh penggunaan singleton
        Thread_safe_lazy_initialization_using_holder_class_bill_pugh_singleton_implementation singleton = Thread_safe_lazy_initialization_using_holder_class_bill_pugh_singleton_implementation
                .getInstance();
        singleton.doSomething();
        /*
         * output:
         * Doing Something...
         */
    }
}
