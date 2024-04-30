public class Multiple_threads_with_one_shared_object {
    // Multiple threads with one shared object/Beberapa utas dengan satu objek
    // bersama

    /*
     * Dalam contoh ini kami hanya memiliki satu objek tetapi dibagikan
     * antara/dieksekusi pada utas yang berbeda. Penggunaan bidang biasa untuk
     * menyelamatkan keadaan tidak akan mungkin karena utas lain akan melihatnya
     * juga (atau mungkin tidak melihat).
     */

    /*
     * public class Test {
     * public static void main(String[] args) {
     * Foo foo = new Foo();
     * new Thread(foo, "Thread 1").start();
     * new Thread(foo, "Thread 2").start();
     * }
     * }
     */

    /*
     * Dalam foo kami menghitung mulai dari nol. Alih -alih menyimpan negara ke
     * bidang, kami menyimpan nomor kami saat ini di
     * Threadlocal object yang dapat diakses secara statis. Perhatikan bahwa
     * sinkronisasi dalam contoh ini tidak terkait dengan
     * Penggunaan ThreadLocal melainkan memastikan output konsol yang lebih baik.
     */

    /*
     * public class Foo implements Runnable {
     * private static final int ITERATIONS = 10;
     * private static final ThreadLocal<Integer> threadLocal = new
     * ThreadLocal<Integer>() {
     * 
     * @Override
     * protected Integer initialValue() {
     * return 0;
     * }
     * };
     * 
     * @Override
     * public void run() {
     * for (int i = 0; i < ITERATIONS; i++) {
     * synchronized (threadLocal) {
     * //Although accessing a static field, we get our own (previously saved) value.
     * int value = threadLocal.get();
     * System.out.println(Thread.currentThread().getName() + ": " + value);
     * 
     * //Update our own variable
     * threadLocal.set(value + 1);
     * try {
     * threadLocal.notifyAll();
     * if (i < ITERATIONS - 1) {
     * threadLocal.wait();
     * }
     * } catch (InterruptedException ex) {
     * }
     * }
     * }
     * }
     * }
     * 
     */

    // Dari output kita dapat melihat bahwa setiap utas menghitung untuk dirinya
    // sendiri dan tidak menggunakan nilai yang lain:

    /*
     * Thread 1: 0
     * Thread 2: 0
     * Thread 1: 1
     * Thread 2: 1
     * Thread 1: 2
     * Thread 2: 2
     * Thread 1: 3
     * Thread 2: 3
     * Thread 1: 4
     * Thread 2: 4
     * Thread 1: 5
     * Thread 2: 5
     * Thread 1: 6
     * Thread 2: 6
     * Thread 1: 7
     * Thread 2: 7
     * Thread 1: 8
     * Thread 2: 8
     * Thread 1: 9
     * Thread 2: 9
     */

    public static void main(String[] args) throws Exception {
        Foo2 foo = new Foo2();
        new Thread(foo, "Thread 1").start();
        new Thread(foo, "Thread 2").start();
        /*
         * output:
         * Thread 1: 0
         * Thread 2: 0
         * Thread 1: 1
         * Thread 2: 1
         * Thread 1: 2
         * Thread 2: 2
         * Thread 1: 3
         * Thread 2: 3
         * Thread 1: 4
         * Thread 2: 4
         * Thread 1: 5
         * Thread 2: 5
         * Thread 1: 6
         * Thread 2: 6
         * Thread 1: 7
         * Thread 2: 7
         * Thread 1: 8
         * Thread 2: 8
         * Thread 1: 9
         * Thread 2: 9
         */
    }
}
