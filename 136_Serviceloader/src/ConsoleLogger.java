public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.err.println(message);
    }

    @Override
    public void close() {
    }
}
