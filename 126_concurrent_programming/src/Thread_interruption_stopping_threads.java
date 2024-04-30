import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.ArrayList;
import java.util.List;

public class Thread_interruption_stopping_threads {
    // Thread Interruption / Stopping Threads/Gangguan Thread / Penghentian Thread

    /*
     * Setiap Java Thread memiliki tanda interupsi, yang awalnya salah. Mengganggu
     * sebuah thread, pada dasarnya tidak lebih dari itu
     * menyetel tanda itu ke true. Kode yang berjalan pada thread tersebut
     * kadang-kadang dapat memeriksa flag dan menindaklanjutinya. Kode juga dapat
     * mengabaikannya sepenuhnya. Namun mengapa setiap Thread memiliki tanda seperti
     * itu? Lagi pula, memiliki bendera boolean pada thread adalah sesuatu yang bisa
     * kita atur sendiri, jika dan saat kita membutuhkannya. Ya, ada metode yang
     * berperilaku khusus ketika thread yang dijalankannya terganggu. Metode-metode
     * ini disebut metode pemblokiran.
     * Ini adalah metode yang menempatkan thread dalam status WAITING atau
     * TIMED_WAITING. Saat thread berada dalam kondisi ini,
     * menginterupsinya, akan menyebabkan InterruptedException dilemparkan pada
     * thread yang terputus, alih-alih flag interupsi disetel ke true, dan thread
     * tersebut menjadi RUNNABLE lagi. Kode yang memanggil metode pemblokiran
     * dipaksa untuk menangani InterruptedException, karena ini adalah pengecualian
     * yang dicentang. Jadi, sesuai dengan namanya, interupsi dapat mempunyai efek
     * menginterupsi WAIT, yang secara efektif mengakhirinya. Perhatikan bahwa tidak
     * semua metode yang menunggu (mis.
     * blocking IO) merespons interupsi dengan cara itu, karena mereka tidak
     * menempatkan thread dalam status menunggu. Terakhir, thread yang flag
     * interupsinya disetel, yang memasuki metode pemblokiran (yaitu mencoba masuk
     * ke status menunggu), akan segera menampilkan InterruptedException dan flag
     * interupsi akan dihapus.
     */

    /*
     * Selain mekanisme ini, Java tidak memberikan arti semantik khusus apa pun pada
     * interupsi. Kode bebas untuk
     * menafsirkan interupsi sesukanya. Namun sering kali interupsi digunakan untuk
     * memberi sinyal pada thread bahwa thread tersebut harus berhenti berjalan
     * secepatnya. Namun, seperti yang sudah jelas di atas, kode pada thread
     * tersebut harus bereaksi terhadap gangguan tersebut dengan tepat agar dapat
     * berhenti berjalan. Menghentikan thread adalah sebuah kolaborasi. Ketika
     * sebuah thread diinterupsi, kode yang berjalan dapat berada beberapa level
     * jauh di dalam pelacakan tumpukan. Sebagian besar kode tidak memanggil metode
     * pemblokiran, dan selesai tepat waktu sehingga tidak terlalu menunda
     * penghentian thread. Kode yang paling berkaitan dengan respons terhadap
     * interupsi, adalah kode yang berada dalam satu perulangan yang menangani tugas
     * hingga tidak ada lagi yang tersisa, atau hingga sebuah tanda disetel yang
     * menandakannya untuk menghentikan perulangan tersebut. Perulangan yang
     * menangani tugas-tugas yang mungkin tidak terbatas (yaitu, tetap
     * berjalan pada prinsipnya) harus memeriksa flag interupsi untuk keluar dari
     * loop. Untuk loop terbatas, semantik mungkin menentukan bahwa semua tugas
     * harus diselesaikan sebelum diakhiri, atau mungkin lebih tepat jika beberapa
     * tugas dibiarkan tidak tertangani. Kode yang memanggil metode pemblokiran akan
     * dipaksa untuk menangani InterruptedException. Jika memungkinkan secara
     * semantik, ia cukup menyebarkan InterruptedException dan mendeklarasikan untuk
     * membuangnya. Dengan demikian, ini menjadi metode pemblokiran itu sendiri
     * sehubungan dengan peneleponnya. Jika thread tersebut tidak dapat menyebarkan
     * pengecualian, setidaknya thread tersebut harus menyetel tanda interupsi,
     * sehingga pemanggil yang berada di tingkat atas tumpukan juga mengetahui bahwa
     * thread tersebut telah diinterupsi. Dalam beberapa kasus, metode ini perlu
     * terus menunggu tanpa menghiraukan InterruptedException, dalam hal ini metode
     * tersebut harus menunda pengaturan tanda interupsi sampai setelahnya.
     * selesai menunggu, ini mungkin melibatkan pengaturan variabel lokal, yang
     * harus diperiksa sebelum keluar dari metode untuk kemudian mengganggu
     * threadnya
     */

    // contoh:

    // Contoh kode yang berhenti menangani tugas saat terjadi gangguan

    /*
     * class TaskHandler implements Runnable {
     * 
     * private final BlockingQueue<Task> queue;
     * TaskHandler(BlockingQueue<Task> queue) {
     * this.queue = queue;
     * }
     * 
     * @Override
     * public void run() {
     * while (!Thread.currentThread().isInterrupted()) { // check for interrupt
     * flag, exit loop
     * when interrupted
     * try {
     * Task task = queue.take(); // blocking call, responsive to interruption
     * handle(task);
     * } catch (InterruptedException e) {
     * Thread.currentThread().interrupt(); // cannot throw InterruptedException (due
     * to
     * Runnable interface restriction) so indicating interruption by setting the
     * flag
     * }
     * }
     * }
     * 
     * private void handle(Task task) {
     * // actual handling
     * }
     * }
     */

    /*
     * Contoh kode yang menunda pengaturan flag interupsi sampai selesai :
     * 
     * class MustFinishHandler implements Runnable {
     * private final BlockingQueue<Task> queue;
     * MustFinishHandler(BlockingQueue<Task> queue) {
     * this.queue = queue;
     * }
     * 
     * @Override
     * public void run() {
     * boolean shouldInterrupt = false;
     * 
     * while (true) {
     * try {
     * Task task = queue.take();
     * if (task.isEndOfTasks()) {
     * if (shouldInterrupt) {
     * Thread.currentThread().interrupt();
     * }
     * return;
     * }
     * handle(task);
     * } catch (InterruptedException e) {
     * shouldInterrupt = true; // must finish, remember to set interrupt flag when
     * we're
     * done
     * }
     * }
     * }
     * private void handle(Task task) {
     * // actual handling
     * }
     * }
     * 
     * 
     */

    // Contoh kode yang memiliki daftar tugas tetap namun dapat berhenti lebih awal
    // jika terganggu
    /*
     * class GetAsFarAsPossible implements Runnable {
     * private final List<Task> tasks = new ArrayList<>();
     * 
     * @Override
     * public void run() {
     * for (Task task : tasks) {
     * if (Thread.currentThread().isInterrupted()) {
     * return;
     * }
     * handle(task);
     * }
     * }
     * private void handle(Task task) {
     * // actual handling
     * }
     * }
     */

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Task> queue = new LinkedBlockingQueue<>();
        AtomicBoolean shouldInterrupt = new AtomicBoolean(false);

        // Create and start threads
        Thread taskHandlerThread = new Thread(new TaskHandler(queue));
        Thread mustFinishHandlerThread = new Thread(new MustFinishHandler(queue, shouldInterrupt));

        taskHandlerThread.start();
        mustFinishHandlerThread.start();

        // Example usage of GetAsFarAsPossible
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(false));
        tasks.add(new Task(false));
        tasks.add(new Task(true)); // End of tasks
        Thread getAsFarAsPossibleThread = new Thread(new GetAsFarAsPossible(tasks));
        getAsFarAsPossibleThread.start();

        // Let the threads run for a while
        TimeUnit.SECONDS.sleep(1);

        // Interrupt threads
        taskHandlerThread.interrupt();
        mustFinishHandlerThread.interrupt();
        getAsFarAsPossibleThread.interrupt();

    }
}
