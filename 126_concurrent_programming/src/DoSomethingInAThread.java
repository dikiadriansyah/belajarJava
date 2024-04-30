import java.util.concurrent.CountDownLatch;

public class DoSomethingInAThread implements Runnable {
    CountDownLatch latch;

    public DoSomethingInAThread(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            System.out.println("Do some thing");
            latch.countDown();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
