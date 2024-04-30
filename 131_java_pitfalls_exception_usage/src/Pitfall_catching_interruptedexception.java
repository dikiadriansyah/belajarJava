public class Pitfall_catching_interruptedexception {
    // Pitfall - Catching InterruptedException/Kesalahan - Menangkap
    // InterruptedException

    /*
     * Seperti yang telah ditunjukkan dalam jebakan lain, tangkap semua pengecualian
     * dengan menggunakan
     * 
     * try {
     * // Some code
     * } catch (Exception) {
     * // Some error handling
     * }
     */

    /*
     * Datang dengan banyak masalah berbeda. Namun satu masalah khususnya adalah
     * bahwa hal ini dapat menyebabkan kebuntuan ketika memecahkan masalah tersebut
     * mengganggu sistem saat menulis aplikasi multi-thread.
     * 
     * Jika Anda memulai sebuah thread, biasanya Anda juga harus bisa
     * menghentikannya secara tiba-tiba karena berbagai alasan.
     */

    /*
     * Thread t = new Thread(new Runnable() {
     * public void run() {
     * while (true) {
     * //Do something indefinetely
     * }
     * }
     * }
     * t.start();
     * //Do something else
     * // The thread should be canceld if it is still active.
     * // A Better way to solve this is with a shared variable that is tested
     * // regularily by the thread for a clean exit, but for this example we try to
     * // forcibly interrupt this thread.
     * if (t.isAlive()) {
     * t.interrupt();
     * t.join();
     * }
     * //Continue with program
     * 
     */

    /*
     * t.interrupt() akan memunculkan InterruptedException di thread tersebut, yang
     * dimaksudkan untuk mematikan thread. Tetapi
     * bagaimana jika Thread perlu membersihkan beberapa sumber daya sebelum
     * dihentikan sepenuhnya? Untuk ini ia dapat menangkap InterruptedException dan
     * melakukan pembersihan.
     */

    /*
     * Thread t = new Thread(new Runnable() {
     * public void run() {
     * try {
     * while (true) {
     * //Do something indefinetely
     * }
     * } catch (InterruptedException ex) {
     * //Do some quick cleanup
     * // In this case a simple return would do.
     * // But if you are not 100% sure that the thread ends after
     * // catching the InterruptedException you will need to raise another
     * // one for the layers surrounding this code.
     * Thread.currentThread().interrupt();
     * }
     * }
     * }
     * 
     */

    /*
     * Namun jika Anda memiliki ekspresi umum dalam kode Anda, InterruptedException
     * juga akan ditangkap olehnya dan
     * gangguan tidak akan berlanjut. Yang dalam hal ini dapat menyebabkan kebuntuan
     * karena thread induk menunggu tanpa batas waktu hingga iklan ini berhenti
     * dengan t.join().
     */

    /*
     * Thread t = new Thread(new Runnable() {
     * public void run() {
     * try {
     * while (true) {
     * try {
     * //Do something indefinetely
     * }
     * catch (Exception ex) {
     * ex.printStackTrace();
     * }
     * }
     * } catch (InterruptedException ex) {
     * // Dead code as the interrupt exception was already caught in
     * // the inner try-catch
     * Thread.currentThread().interrupt();
     * }
     * }
     * }
     */

    /*
     * Jadi lebih baik menangkap Pengecualian satu per satu, tetapi jika Anda
     * bersikeras menggunakan penampung semua, setidaknya tangkap
     * InterruptedException satu per satu terlebih dahulu
     */

    /*
     * Thread t = new Thread(new Runnable() {
     * public void run() {
     * try {
     * while (true) {
     * try {
     * //Do something indefinetely
     * } catch (InterruptedException ex) {
     * throw ex; //Send it up in the chain
     * } catch (Exception ex) {
     * ex.printStackTrace();
     * }
     * }
     * } catch (InterruptedException ex) {
     * // Some quick cleanup code
     * Thread.currentThread().interrupt();
     * }
     * }
     * }
     */
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        // Do something indefinitely
                        System.out.println("Thread is running...");
                        Thread.sleep(1000); // Sleep for 1 second
                    }
                } catch (InterruptedException ex) {
                    // Do some quick cleanup
                    // In this case a simple return would do.
                    // But if you are not 100% sure that the thread ends after
                    // catching the InterruptedException you will need to raise another
                    // one for the layers surrounding this code.
                    Thread.currentThread().interrupt();
                }
            }
        });

        t.start(); // Start the thread

        /*
         * output:
         * Thread is running...
         * Thread is running...
         * Thread is running...
         * Thread is running...
         * Thread is running...
         */

    }
}
