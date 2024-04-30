
// import lombok.extern.java.Log;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import java.util.logging.*;

public class AsyncMaintenanceTaskCompleter implements Runnable {
    private int taskNumber;

    public AsyncMaintenanceTaskCompleter(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void run() {
        int timeout = ThreadLocalRandom.current().nextInt(1, 20);

        // Create a Logger
        Logger logger = Logger.getLogger(
                AsyncMaintenanceTaskCompleter.class.getName());

        try {
            logger.info(String.format("Task %d is sleeping for %d seconds", taskNumber, timeout));
            TimeUnit.SECONDS.sleep(timeout);
            logger.info(String.format("Task %d is done sleeping", taskNumber));
        } catch (InterruptedException e) {
            logger.warning(e.getMessage());
        }
    }
}
