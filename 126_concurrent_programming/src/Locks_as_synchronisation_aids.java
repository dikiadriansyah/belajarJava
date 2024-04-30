import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks_as_synchronisation_aids {
    // Locks as Synchronisation aids/Kunci sebagai alat bantu Sinkronisasi

    /*
     * Sebelum pengenalan paket serentak Java 5, threading berada pada level yang
     * lebih rendah. Pengenalan paket ini menyediakan beberapa bantuan/konstruksi
     * pemrograman serentak tingkat yang lebih tinggi.
     * 
     * Kunci adalah mekanisme sinkronisasi thread yang pada dasarnya memiliki tujuan
     * yang sama dengan blok atau kata kunci yang disinkronkan.
     */

    // Intrinsic Locking
    /*
     * int count = 0; // shared among multiple threads
     * public void doSomething() {
     * synchronized(this) {
     * ++count; // a non-atomic operation
     * }
     * }
     */

    // Synchronisation using Locks

    /*
     * int count = 0; // shared among multiple threads
     * Lock lockObj = new ReentrantLock();
     * public void doSomething() {
     * try {
     * lockObj.lock();
     * ++count; // a non-atomic operation
     * } finally {
     * lockObj.unlock(); // sure to release the lock without fail
     * }
     * }
     */

    /*
     * Kunci juga memiliki fungsionalitas yang tidak ditawarkan oleh penguncian
     * intrinsik, seperti mengunci namun tetap responsif
     * untuk mengganggu, atau mencoba mengunci, dan tidak memblokir ketika tidak
     * mampu.
     */

    // Locking, responsive to interruption

    /*
     * class Locky {
     * int count = 0; // shared among multiple threads
     * Lock lockObj = new ReentrantLock();
     * public void doSomething() {
     * try {
     * try {
     * lockObj.lockInterruptibly();
     * ++count; // a non-atomic operation
     * } catch (InterruptedException e) {
     * Thread.currentThread().interrupt(); // stopping
     * }
     * } finally {
     * if (!Thread.currentThread().isInterrupted()) {
     * lockObj.unlock(); // sure to release the lock without fail
     * }
     * }
     * }
     * }
     */

    // Only do something when able to lock

    /*
     * public class Locky2 {
     * int count = 0; // shared among multiple threads
     * Lock lockObj = new ReentrantLock();
     * public void doSomething() {
     * boolean locked = lockObj.tryLock(); // returns true upon successful lock
     * if (locked) {
     * try {
     * ++count; // a non-atomic operation
     * } finally {
     * lockObj.unlock(); // sure to release the lock without fail
     * }
     * }
     * }
     * }
     */

    // Ada beberapa varian kunci yang tersedia. Untuk lebih jelasnya lihat dokumen
    // api di sini

    // ---------------------
    // private int count = 0; // shared among multiple threads
    // private Lock lockObj = new ReentrantLock();

    // public void doSomething() {
    // try {
    // lockObj.lock();
    // ++count; // a non-atomic operation
    // System.out.println("Count is: " + count);
    // } finally {
    // lockObj.unlock(); // sure to release the lock without fail
    // }
    // }

    public static void main(String[] args) throws Exception {
        // Locks_as_synchronisation_aids box = new Locks_as_synchronisation_aids();

        // // Create multiple threads to test concurrent access
        // for (int i = 0; i < 5; i++) {
        // Thread thread = new Thread(() -> {
        // for (int j = 0; j < 3; j++) {
        // box.doSomething();
        // }
        // });
        // thread.start();
        // }

        /*
         * output:
         * Count is: 1
         * Count is: 2
         * Count is: 3
         * Count is: 4
         * Count is: 5
         * Count is: 6
         * Count is: 7
         * Count is: 8
         * Count is: 9
         * Count is: 10
         * Count is: 11
         * Count is: 12
         * Count is: 13
         * Count is: 14
         * Count is: 15
         */
        // ---------------------------------
        // Locky locky = new Locky();

        // Create multiple threads to invoke doSomething method concurrently
        // for (int i = 0; i < 5; i++) {
        // new Thread(() -> {
        // locky.doSomething();
        // }).start();
        // }
        /*
         * output:
         * Incremented count: 1
         * Incremented count: 2
         * Incremented count: 3
         * Incremented count: 4
         * Incremented count: 5
         */
        // ---------------------------------
        final Locky2 locky = new Locky2();

        // Create multiple threads to invoke doSomething()
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    locky.doSomething();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    locky.doSomething();
                }
            }
        });

        thread1.start();
        thread2.start();

        // Wait for threads to finish execution
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final count value
        System.out.println("Final count: " + locky.count); // output: Final count: 913
    }
}
