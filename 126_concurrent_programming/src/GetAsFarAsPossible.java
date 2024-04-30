import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class GetAsFarAsPossible implements Runnable {
    private final List<Task> tasks;

    public GetAsFarAsPossible(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        for (Task task : tasks) {

            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            handle(task);
        }
    }

    private void handle(Task task) {
        // actual handling
    }
}
