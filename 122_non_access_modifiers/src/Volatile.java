public class Volatile {
    // volatile/tidak stabil

    /*
     * volatile modifier digunakan dalam pemrograman multi-utas. Jika Anda
     * mendeklarasikan suatu bidang sebagai volatile , hal ini merupakan sinyal bagi
     * thread bahwa bidang tersebut harus membaca nilai terbaru, bukan nilai yang
     * di-cache secara lokal. Selanjutnya, bacaan yang mudah menguap dan
     * penulisan dijamin bersifat atomik (akses ke non-volatile long or double
     * bukanlah atomik), sehingga menghindari kesalahan baca/tulis tertentu di
     * antara beberapa thread.
     */

    /*
     * public class MyRunnable implements Runnable
     * {
     * private volatile boolean active;
     * public void run(){ // run is called in one thread
     * active = true;
     * while (active){
     * // some code here
     * }
     * }
     * 
     * public void stop(){ // stop() is called from another thread
     * active = false;
     * }
     * }
     * 
     * 
     */

    public static void main(String[] args) throws Exception {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable);
        thread1.start();

        // Let the thread run for some time
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the thread
        myRunnable.stop();
        /*
         * output:
         * Thread is running...
         * Thread is running...
         * Thread is running...
         * Thread stopped.
         */
    }
}
