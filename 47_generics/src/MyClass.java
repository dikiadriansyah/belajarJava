import java.io.Flushable;
import java.io.Closeable;

class MyClass implements Flushable, Closeable {
    @Override
    public void flush() {
        System.out.println("Flush method called.");
    }

    @Override
    public void close() {
        System.out.println("Close method called.");
    }
}