import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locky2 {
    int count = 0; // shared among multiple threads
    Lock lockObj = new ReentrantLock();

    public void doSomething() {
        boolean locked = lockObj.tryLock(); // returns true upon successful lock
        if (locked) {
            try {
                ++count; // a non-atomic operation
            } finally {
                lockObj.unlock(); // sure to release the lock without fail
            }
        }
    }
}
