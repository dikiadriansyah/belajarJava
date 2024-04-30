import java.util.ArrayList;
import java.util.Date;
import java.util.List;

interface Observer {
    void onAction(String a);
}

interface Observable {
    public abstract List<Observer> getObservers();

    public default void addObserver(Observer o) {
        getObservers().add(o);
    }

    public default void notify(String something) {
        for (Observer l : getObservers()) {
            l.onAction(something);
        }
    }
}

abstract class Worker {
    public abstract void work();
}

public class MyWorker extends Worker implements Observable {
    private List<Observer> myObservers = new ArrayList<Observer>();

    @Override
    public List<Observer> getObservers() {
        return myObservers;
    }

    @Override
    public void work() {
        notify("Started work");
        // Code goes here...
        notify("Completed work");
    }

    public static void main(String[] args) {
        MyWorker w = new MyWorker();

        w.addObserver(new Observer() {
            @Override

            public void onAction(String a) {
                System.out.println(a + " (" + new Date() + ")");
            }
        });

        w.work();
        /*
         * output:
         * Started work (Tue Feb 06 09:46:37 WIB 2024)
         * Completed work (Tue Feb 06 09:46:37 WIB 2024)
         */

    }
}