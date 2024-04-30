import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MustFinishHandler implements Runnable {
    private final BlockingQueue<Task> queue;
    private final AtomicBoolean shouldInterrupt;

    MustFinishHandler(BlockingQueue<Task> queue, AtomicBoolean shouldInterrupt) {
        this.queue = queue;
        this.shouldInterrupt = shouldInterrupt;
    }

    @Override
    public void run() {
        boolean shouldInterrupt = false;

        while (true) {
            try {
                Task task = queue.take();
                if (task.isEndOfTasks()) {
                    if (shouldInterrupt) {
                        Thread.currentThread().interrupt();
                    }
                    return;
                }
                handle(task);
            } catch (InterruptedException e) {
                shouldInterrupt = true; // must finish, remember to set interrupt flag when we're
                // done
            }
        }
    }

    private void handle(Task task) {
        // actual handling
    }
}
