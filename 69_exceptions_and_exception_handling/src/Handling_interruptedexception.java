public class Handling_interruptedexception {
    // Handling InterruptedException/Menangani InterruptedException

    /*
     * InterruptedException adalah binatang yang membingungkan - ia muncul dalam
     * metode yang tampaknya tidak berbahaya seperti Thread.sleep(), namun
     * penanganannya yang salah menyebabkan kode yang sulit dikelola dan berperilaku
     * buruk di lingkungan bersamaan.
     * 
     * Pada dasarnya, jika InterruptedException tertangkap, itu berarti seseorang,
     * di suatu tempat, bernama Thread.interrupt()
     * di thread yang sedang menjalankan kode Anda. Anda mungkin cenderung
     * mengatakan, "Ini kode saya! Saya tidak akan pernah mengganggunya!"
     * dan karena itu lakukan sesuatu seperti ini:
     * 
     * // Bad. Don't do this.
     * try {
     * Thread.sleep(1000);
     * } catch (InterruptedException e) {
     * // disregard
     * }
     * 
     */

    /*
     * Tapi ini adalah cara yang salah untuk menangani peristiwa "mustahil" yang
     * terjadi. Jika Anda tahu aplikasi Anda tidak akan pernah menemukan
     * InterruptedException, Anda harus menganggap peristiwa tersebut sebagai
     * pelanggaran serius terhadap asumsi program Anda dan keluar secepat mungkin.
     * 
     * Cara yang tepat untuk menangani interupsi yang "tidak mungkin" adalah seperti
     * ini:
     * // When nothing will interrupt your code
     * try {
     * Thread.sleep(1000);
     * } catch (InterruptedException e) {
     * Thread.currentThread().interrupt();
     * throw new AssertionError(e);
     * }
     */

    /*
     * Ini menghasilkan dua hal; pertama-tama ia mengembalikan status interupsi
     * thread (seolah-olah InterruptedException tidak dilempar sejak awal), dan
     * kemudian memunculkan AssertionError yang menunjukkan invarian dasar aplikasi
     * Anda telah dilanggar. Jika Anda tahu pasti bahwa Anda tidak akan pernah
     * mengganggu thread ini, kode ini dijalankan
     * aman karena blok catch tidak boleh tercapai.
     * 
     * Menggunakan kelas Uninterruptibles Guava membantu menyederhanakan pola ini;
     * panggilan Uninterruptibles.sleepUninterruptively() mengabaikan status
     * interupsi thread hingga durasi tidurnya habis (di titik ini, durasi tersebut
     * akan dipulihkan untuk panggilan selanjutnya guna memeriksa dan menampilkan
     * InterruptedException-nya sendiri). Jika Anda tahu Anda tidak akan pernah
     * menginterupsi kode tersebut, ini dengan aman menghindari kebutuhan untuk
     * membungkus panggilan tidur Anda dalam try-catch block.
     */

    /*
     * Namun seringkali, Anda tidak dapat menjamin bahwa thread Anda tidak akan
     * pernah terputus. Khususnya jika Anda sedang menulis
     * kode yang akan dieksekusi oleh Executor atau manajemen thread lainnya, sangat
     * penting bahwa kode Anda segera merespons interupsi, jika tidak, aplikasi Anda
     * akan terhenti atau bahkan menemui jalan buntu.
     * 
     * Dalam kasus seperti itu, hal terbaik yang harus dilakukan adalah mengizinkan
     * InterruptedException menyebarkan tumpukan panggilan,
     * menambahkan throws InterruptedException ke setiap metode secara bergantian.
     * Ini mungkin tampak klise tapi sebenarnya merupakan properti yang diinginkan -
     * tanda tangan metode Anda sekarang menunjukkan kepada penelepon bahwa metode
     * tersebut akan segera merespons interupsi.
     */

    /*
     * // Let the caller determine how to handle the interrupt if you're unsure
     * public void myLongRunningMethod() throws InterruptedException {
     * ...
     * }
     */

    /*
     * Dalam kasus tertentu (misalnya saat mengganti metode yang tidak menampilkan
     * pengecualian apa pun yang dicentang), Anda dapat menyetel ulang status
     * interupsi tanpa memunculkan pengecualian, dengan mengharapkan kode apa pun
     * yang dieksekusi berikutnya untuk menangani interupsi.
     * Hal ini menunda penanganan interupsi namun tidak menekannya sepenuhnya.
     */

    /*
     * // Suppresses the exception but resets the interrupted state letting later
     * code
     * // detect the interrupt and handle it properly.
     * try {
     * Thread.sleep(1000);
     * } catch (InterruptedException e) {
     * Thread.currentThread().interrupt();
     * return ...; // your expectations are still broken at this point - try not to
     * do more work.
     * }
     */

    public static void main(String[] args) {
        try {
            // Suppresses the exception but resets the interrupted state
            // letting later code detect the interrupt and handle it properly.
            sleepWithInterruptHandling();

            // Your code continues here after the interrupted state is handled.
            System.out.println("Execution continues after handling interrupt.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * output:
         * Execution continues after handling interrupt.
         */

    }

    private static void sleepWithInterruptHandling() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Reset the interrupted state
            Thread.currentThread().interrupt();

            // Handle the interrupt or perform any necessary cleanup.
            System.out.println("Interrupt handled. Returning...");

            // Your expectations are still broken at this point - try not to do more work.
            throw new Exception("Interrupted Exception");
        }
    }
}
