import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locky {
    int count = 0; // shared among multiple threads
    Lock lockObj = new ReentrantLock();

    public void doSomething() {
        try {
            try {
                lockObj.lockInterruptibly();
                ++count; // a non-atomic operation
                System.out.println("Incremented count: " + count);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // stopping
            }
        } finally {
            if (!Thread.currentThread().isInterrupted()) {
                lockObj.unlock(); // sure to release the lock without fail
            }
        }
    }
}
