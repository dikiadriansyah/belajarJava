import java.util.concurrent.*;

public class Producer_consumer {
    // Producer-Consumer/Produsen-Konsumen

    /*
     * Contoh sederhana penyelesaian masalah produsen-konsumen. Perhatikan bahwa
     * kelas JDK (AtomicBoolean dan
     * BlockingQueue) digunakan untuk sinkronisasi, yang mengurangi kemungkinan
     * terciptanya solusi yang tidak valid. Berkonsultasi
     * Javadoc untuk berbagai jenis BlockingQueue; memilih implementasi yang berbeda
     * dapat mengubah perilaku contoh ini secara drastis (seperti DelayQueue atau
     * Priority Queue).
     */

    /*
     * public class Producer implements Runnable {
     * private final BlockingQueue<ProducedData> queue;
     * public Producer(BlockingQueue<ProducedData> queue) {
     * this.queue = queue;
     * }
     * public void run() {
     * int producedCount = 0;
     * try {
     * while (true) {
     * producedCount++;
     * //put throws an InterruptedException when the thread is interrupted
     * queue.put(new ProducedData());
     * }
     * } catch (InterruptedException e) {
     * // the thread has been interrupted: cleanup and exit
     * producedCount--;
     * //re-interrupt the thread in case the interrupt flag is needeed higher up
     * Thread.currentThread().interrupt();
     * }
     * System.out.println("Produced " + producedCount + " objects");
     * }
     * }
     * public class Consumer implements Runnable {
     * private final BlockingQueue<ProducedData> queue;
     * public Consumer(BlockingQueue<ProducedData> queue) {
     * this.queue = queue;
     * }
     * public void run() {
     * int consumedCount = 0;
     * try {
     * while (true) {
     * //put throws an InterruptedException when the thread is interrupted
     * ProducedData data = queue.poll(10, TimeUnit.MILLISECONDS);
     * // process data
     * consumedCount++;
     * }
     * } catch (InterruptedException e) {
     * // the thread has been interrupted: cleanup and exit
     * consumedCount--;
     * //re-interrupt the thread in case the interrupt flag is needeed higher up
     * Thread.currentThread().interrupt();
     * }
     * System.out.println("Consumed " + consumedCount + " objects");
     * }
     * }
     * public class ProducerConsumerExample {
     * static class ProducedData {
     * // empty data object
     * }
     * public static void main(String[] args) throws InterruptedException {
     * BlockingQueue<ProducedData> queue = new
     * ArrayBlockingQueue<ProducedData>(1000);
     * // choice of queue determines the actual behavior: see various BlockingQueue
     * implementations
     * Thread producer = new Thread(new Producer(queue));
     * Thread consumer = new Thread(new Consumer(queue));
     * producer.start();
     * consumer.start();
     * Thread.sleep(1000);
     * producer.interrupt();
     * Thread.sleep(10);
     * consumer.interrupt();
     * }
     * }
     */

    static class ProducedData {
        // empty data object

    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<ProducedData> queue = new ArrayBlockingQueue<ProducedData>(1000);
        // choice of queue determines the actual behavior: see various BlockingQueue
        // implementations
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
        Thread.sleep(1000);
        producer.interrupt();
        Thread.sleep(10);
        consumer.interrupt();
        /*
         * output:
         * Consumed 5695005 objects
         * Produced 5695005 objects
         */
    }

    static class Producer implements Runnable {
        private final BlockingQueue<ProducedData> queue;

        public Producer(BlockingQueue<ProducedData> queue) {
            this.queue = queue;
        }

        public void run() {
            int producedCount = 0;
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    producedCount++;
                    // put throws an InterruptedException when the thread is interrupted
                    queue.put(new ProducedData());
                }
            } catch (InterruptedException e) {
                // the thread has been interrupted: cleanup and exit
                producedCount--;
                // re-interrupt the thread in case the interrupt flag is needeed higher up
                Thread.currentThread().interrupt();
            }
            System.out.println("Produced " + producedCount + " objects");
        }

    }

    static class Consumer implements Runnable {
        private final BlockingQueue<ProducedData> queue;

        public Consumer(BlockingQueue<ProducedData> queue) {
            this.queue = queue;
        }

        public void run() {
            int consumedCount = 0;
            try {
                while (true) {
                    // put throws an InterruptedException when the thread is interrupted
                    ProducedData data = queue.poll(10, TimeUnit.MILLISECONDS);
                    // process data
                    consumedCount++;
                }
            } catch (InterruptedException e) {
                // the thread has been interrupted: cleanup and exit
                consumedCount--;
                // re-interrupt the thread in case the interrupt flag is needeed higher up
                Thread.currentThread().interrupt();
            }
            System.out.println("Consumed " + consumedCount + " objects");
        }
    }

}
