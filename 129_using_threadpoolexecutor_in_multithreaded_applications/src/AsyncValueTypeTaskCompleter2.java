
// import lombok.extern.java.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import java.util.logging.*;

public class AsyncValueTypeTaskCompleter2 implements Callable<Integer> {
    private int taskNumber;

    public AsyncValueTypeTaskCompleter2(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public Integer call() throws Exception {
        int timeout = ThreadLocalRandom.current().nextInt(1, 20);

        // Create a Logger
        Logger logger = Logger.getLogger(
                AsyncValueTypeTaskCompleter2.class.getName());

        try {
            logger.info(String.format("Task %d is sleeping", taskNumber));
            TimeUnit.SECONDS.sleep(timeout);
            logger.info(String.format("Task %d is done sleeping", taskNumber));
        } catch (InterruptedException e) {
            logger.warning(e.getMessage());
        }
        return timeout;
    }
}
