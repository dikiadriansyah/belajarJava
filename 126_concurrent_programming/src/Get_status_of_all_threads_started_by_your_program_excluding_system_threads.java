import java.util.*;
import java.util.Set;

public class Get_status_of_all_threads_started_by_your_program_excluding_system_threads {
    // Get status of all threads started by your program excluding system
    // threads/Dapatkan status semua thread yang dimulai oleh program Anda kecuali
    // thread sistem

    // Cuplikan kode:

    /*
     * import java.util.Set;
     * public class ThreadStatus {
     * public static void main(String args[]) throws Exception {
     * for (int i = 0; i < 5; i++){
     * Thread t = new Thread(new MyThread());
     * t.setName("MyThread:" + i);
     * t.start();
     * }
     * int threadCount = 0;
     * Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
     * for (Thread t : threadSet) {
     * if (t.getThreadGroup() == Thread.currentThread().getThreadGroup()) {
     * System.out.println("Thread :" + t + ":" + "state:" + t.getState());
     * ++threadCount;
     * }
     * }
     * System.out.println("Thread count started by Main thread:" + threadCount);
     * }
     * }
     * class MyThread implements Runnable {
     * public void run() {
     * try {
     * Thread.sleep(2000);
     * } catch(Exception err) {
     * err.printStackTrace();
     * }
     * }
     * }
     * 
     */

    // hasil:
    /*
     * Thread :Thread[MyThread:1,5,main]:state:TIMED_WAITING
     * Thread :Thread[MyThread:3,5,main]:state:TIMED_WAITING
     * Thread :Thread[main,5,main]:state:RUNNABLE
     * Thread :Thread[MyThread:4,5,main]:state:TIMED_WAITING
     * Thread :Thread[MyThread:0,5,main]:state:TIMED_WAITING
     * Thread :Thread[MyThread:2,5,main]:state:TIMED_WAITING
     * Thread count started by Main thread:6
     * 
     */

    // penjelasan:
    /*
     * Thread.getAllStackTraces().keySet() mengembalikan semua Thread termasuk
     * thread aplikasi dan thread sistem. Jika Anda hanya tertarik pada status
     * Thread, yang dimulai oleh aplikasi Anda, ulangi kumpulan Thread dengan
     * mencentang Grup Thread dari thread tertentu terhadap thread program utama
     * Anda.
     */

    /*
     * Jika kondisi ThreadGroup di atas tidak ada, program akan mengembalikan status
     * Thread Sistem di bawah ini:
     * Reference Handler
     * Signal Dispatcher
     * Attach Listener
     * Finalizer
     */

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new MyThread2());
            t.setName("MyThread:" + i);
            t.start();
        }
        int threadCount = 0;
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for (Thread t : threadSet) {
            if (t.getThreadGroup() == Thread.currentThread().getThreadGroup()) {
                System.out.println("Thread :" + t + ":" + "state:" + t.getState());
                ++threadCount;
            }
        }
        System.out.println("Thread count started by Main thread:" + threadCount);
        /*
         * output:
         * Thread :Thread[MyThread:1,5,main]:state:TIMED_WAITING
         * Thread :Thread[MyThread:4,5,main]:state:TIMED_WAITING
         * Thread :Thread[MyThread:2,5,main]:state:TIMED_WAITING
         * Thread :Thread[MyThread:0,5,main]:state:TIMED_WAITING
         * Thread :Thread[MyThread:3,5,main]:state:TIMED_WAITING
         * Thread :Thread[main,5,main]:state:RUNNABLE
         * Thread count started by Main thread:6
         */

    }
}
