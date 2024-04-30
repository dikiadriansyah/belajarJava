import java.util.Date;
import java.util.concurrent.*;

interface MyFuture<V> {
    V get();

    V get(long timeout, TimeUnit unit);

    boolean cancel(boolean mayInterruptIfRunning);

    boolean isCancelled();

    boolean isDone();
}