import java.util.concurrent.*;
import java.util.Random;

public class Consumer2 implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;
    private int threadNo;

    public Consumer2(BlockingQueue<Integer> sharedQueue, int threadNo) {
        this.sharedQueue = sharedQueue;
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        // Consumer consumes numbers generated from Producer threads continuously
        while (true) {
            try {
                int num = sharedQueue.take();
                System.out.println("Consumed: " + num + ":by thread:" + threadNo);
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }
}
