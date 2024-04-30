import java.util.concurrent.*;
import java.util.Random;

public class Multiple_producer_consumer_example_with_shared_global_queue {
    // Multiple producer/consumer example with shared global queue/Contoh beberapa
    // produsen/konsumen dengan antrian global bersama

    /*
     * Kode di bawah ini menampilkan beberapa program Produser/Konsumen. Thread
     * Produser dan Konsumen berbagi antrean global yang sama.
     */

    /*
     * import java.util.concurrent.*;
     * import java.util.Random;
     * public class ProducerConsumerWithES {
     * public static void main(String args[]) {
     * BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
     * 
     * ExecutorService pes = Executors.newFixedThreadPool(2);
     * ExecutorService ces = Executors.newFixedThreadPool(2);
     * 
     * pes.submit(new Producer(sharedQueue, 1));
     * pes.submit(new Producer(sharedQueue, 2));
     * ces.submit(new Consumer(sharedQueue, 1));
     * ces.submit(new Consumer(sharedQueue, 2));
     * 
     * pes.shutdown();
     * ces.shutdown();
     * }
     * }
     */

    /*
     * Different producers produces a stream of integers continuously to a shared
     * queue, which is shared between all Producers and consumers
     */

    /*
     * class Producer implements Runnable {
     * private final BlockingQueue<Integer> sharedQueue;
     * private int threadNo;
     * private Random random = new Random();
     * public Producer(BlockingQueue<Integer> sharedQueue,int threadNo) {
     * this.threadNo = threadNo;
     * this.sharedQueue = sharedQueue;
     * }
     * 
     * @Override
     * public void run() {
     * // Producer produces a continuous stream of numbers for every 200 milli
     * seconds
     * while (true) {
     * try {
     * int number = random.nextInt(1000);
     * System.out.println("Produced:" + number + ":by thread:"+ threadNo);
     * sharedQueue.put(number);
     * Thread.sleep(200);
     * } catch (Exception err) {
     * err.printStackTrace();
     * }
     * }
     * }
     * }
     */

    /*
     * Different consumers consume data from shared queue, which is shared by both
     * producer and consumer threads
     */

    /*
     * class Consumer implements Runnable {
     * private final BlockingQueue<Integer> sharedQueue;
     * private int threadNo;
     * public Consumer (BlockingQueue<Integer> sharedQueue,int threadNo) {
     * this.sharedQueue = sharedQueue;
     * this.threadNo = threadNo;
     * }
     * 
     * @Override
     * public void run() {
     * // Consumer consumes numbers generated from Producer threads continuously
     * while(true){
     * try {
     * int num = sharedQueue.take();
     * System.out.println("Consumed: "+ num + ":by thread:"+threadNo);
     * } catch (Exception err) {
     * err.printStackTrace();
     * }
     * }
     * }
     * }
     */

    // hasil:
    /*
     * Produced:69:by thread:2
     * Produced:553:by thread:1
     * Consumed: 69:by thread:1
     * Consumed: 553:by thread:2
     * Produced:41:by thread:2
     * Produced:796:by thread:1
     * Consumed: 41:by thread:1
     * Consumed: 796:by thread:2
     * Produced:728:by thread:2
     * Consumed: 728:by thread:1
     * and so on ................
     */

    // penjelasan:
    /*
     * 1. sharedQueue, yang merupakan LinkedBlockingQueue yang dibagikan di antara
     * semua thread Produser dan Konsumen.
     * 2. Utas produser menghasilkan satu bilangan bulat untuk setiap 200 mili detik
     * secara terus menerus dan menambahkannya ke sharedQueue
     * 3. Thread konsumen menggunakan bilangan bulat dari sharedQueue secara terus
     * menerus.
     * 4. Program ini diimplementasikan tanpa sinkronisasi eksplisit atau konstruksi
     * Kunci. BlockingQueue adalah kuncinya untuk mencapainya.
     */

    /*
     * Implementasi BlockingQueue dirancang untuk digunakan terutama pada antrian
     * produsen-konsumen.
     * 
     * Implementasi BlockingQueue aman untuk thread. Semua metode antrian mencapai
     * efeknya secara atom menggunakan kunci internal atau bentuk kontrol konkurensi
     * lainnya.
     */

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

        ExecutorService pes = Executors.newFixedThreadPool(2);
        ExecutorService ces = Executors.newFixedThreadPool(2);

        pes.submit(new Producer2(sharedQueue, 1));
        pes.submit(new Producer2(sharedQueue, 2));
        ces.submit(new Consumer2(sharedQueue, 1));
        ces.submit(new Consumer2(sharedQueue, 2));

        pes.shutdown();
        ces.shutdown();

        /*
         * output:
         * Produced:7:by thread:2
         * Produced:5:by thread:1
         * Consumed: 7:by thread:2
         * Consumed: 5:by thread:1
         * Produced:8:by thread:2
         * Produced:3:by thread:1
         * Consumed: 8:by thread:2
         * Consumed: 3:by thread:1
         * Produced:1:by thread:2
         * Consumed: 1:by thread:2
         * Produced:4:by thread:1
         * Consumed: 4:by thread:1
         * Produced:8:by thread:2
         * Consumed: 8:by thread:2
         */
    }
}
