import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton3 {
    /*
     * Extended classes has to be private inner classes, to prevent extending them
     * in
     * uncontrolled manner.
     */
    private class UppercaseSingleton extends Singleton3 {
        private UppercaseSingleton() {
            super();
        }

        @Override
        public String getMessage() {
            return super.getMessage().toUpperCase();
        }
    }

    // Another extended class.
    private class LowercaseSingleton extends Singleton3 {
        private LowercaseSingleton() {
            super();
        }

        @Override
        public String getMessage() {
            return super.getMessage().toLowerCase();
        }
    }

    // Applying Singleton pattern
    private static SingletonKind kind = SingletonKind.UNKNOWN;
    private static Singleton3 instance;
    /*
     * By using this method prior to getInstance() method, you effectively change
     * the type of singleton instance to be created
     */

    public static void setKind(SingletonKind kind) {
        Singleton3.kind = kind;
    }

    /*
     * If needed, getInstance() creates instance appropriate class, based on value
     * of
     * singletonKind field.
     */
    public static Singleton3 getInstance()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    Singleton3 singleton = new Singleton3();
                    switch (kind) {
                        case UNKNOWN:
                            instance = singleton;
                            break;
                        case LOWERCASE:
                            /*
                             * I can't use simple
                             * instance = new LowercaseSingleton();
                             * because java compiler won't allow me to use
                             * constructor of inner class in static context,
                             * so I use reflection API instead.
                             * To be able to access inner class by reflection API,
                             * I have to create instance of outer class first.
                             * Therefore, in this implementation, Singleton cannot be
                             * abstract class.
                             */
                            // Get the constructor of inner class.
                            Constructor<LowercaseSingleton> lcConstructor = LowercaseSingleton.class
                                    .getDeclaredConstructor(Singleton3.class);
                            // The constructor is private, so I have to make it accessible.
                            lcConstructor.setAccessible(true);

                            // Use the constructor to create instance.
                            instance = lcConstructor.newInstance(singleton);
                            break;
                        case UPPERCASE:

                            // Same goes here, just with different type
                            Constructor<UppercaseSingleton> ucConstructor = UppercaseSingleton.class
                                    .getDeclaredConstructor(Singleton3.class);
                            ucConstructor.setAccessible(true);
                            instance = ucConstructor.newInstance(singleton);
                    }
                }
            }
        }
        return instance;

    }

    // Singletons state that is to be used by subclasses
    protected String message;

    // Private constructor prevents external instantiation.
    private Singleton3() {
        message = "Hello world!";
    }

    // Singleton's API. Implementation can be overwritten by subclasses.
    public String getMessage() {
        return message;
    }

}
