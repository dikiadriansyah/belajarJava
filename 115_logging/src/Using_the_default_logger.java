import java.util.logging.Level;
import java.util.logging.Logger;

public class Using_the_default_logger {

    // retrieve the logger for the current class
    private static final Logger LOG = Logger.getLogger(Using_the_default_logger.class.getName());

    public void foo() {
        LOG.info("A log message");
        LOG.log(Level.INFO, "Another log message");
        LOG.fine("A fine message");

        // logging an exception
        try {
            // code might throw an exception
            throw new SomeException("Something went wrong!");
        } catch (SomeException ex) {
            // log a warning printing "Something went wrong"
            // together with the exception message and stacktrace
            LOG.log(Level.WARNING, "Something went wrong", ex);
        }
        String s = "Hello World!";
        // logging an object
        LOG.log(Level.FINER, "String s: {0}", s);
        // logging several objects
        LOG.log(Level.FINEST, "String s: {0} has length {1}", new Object[] { s, s.length() });
    }

    public static void main(String[] args) throws Exception {
        Using_the_default_logger box = new Using_the_default_logger();
        box.foo();

        /*
         * output:
         * Mar 03, 2024 2:41:10 PM Using_the_default_logger foo
         * INFO: A log message
         * 
         * Mar 03, 2024 2:41:10 PM Using_the_default_logger foo
         * INFO: Another log message
         * 
         * Mar 03, 2024 2:41:10 PM Using_the_default_logger foo
         * WARNING: Something went wrong
         * 
         * Using_the_default_logger$SomeException: Something went wrong!
         */

    }

    // Sample custom exception class
    static class SomeException extends Exception {
        public SomeException(String message) {
            super(message);
        }
    }

}
