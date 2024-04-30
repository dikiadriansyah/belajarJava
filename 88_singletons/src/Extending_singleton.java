import java.lang.reflect.InvocationTargetException;

public class Extending_singleton {
    // Extending singleton (singleton inheritance)/Memperluas singleton (pewarisan
    // singleton)

    /*
     * Dalam contoh ini, kelas dasar Singleton menyediakan metode getMessage() yang
     * mengembalikan "Halo dunia!" pesan.
     * 
     * Ini adalah subkelas UppercaseSingleton dan LowercaseSingleton yang
     * menggantikan metode getMessage() untuk disediakan representasi pesan yang
     * tepat.
     */

    /*
     * //Yeah, we'll need reflection to pull this off.
     * import java.lang.reflect.*;
     * 
     * Enumeration that represents possible classes of singleton instance.
     * If unknown, we'll go with base class - Singleton.
     * 
     * 
     * enum SingletonKind {
     * UNKNOWN,
     * LOWERCASE,
     * UPPERCASE
     * }
     * //Base class
     * class Singleton{
     * 
     * Extended classes has to be private inner classes, to prevent extending them
     * in uncontrolled manner.
     * private class UppercaseSingleton extends Singleton {
     * private UppercaseSingleton(){
     * super();
     * }
     * 
     * @Override
     * public String getMessage() {
     * return super.getMessage().toUpperCase();
     * }
     * }
     * //Another extended class.
     * private class LowercaseSingleton extends Singleton
     * {
     * private LowercaseSingleton(){
     * super();
     * }
     * 
     * @Override
     * public String getMessage() {
     * return super.getMessage().toLowerCase();
     * }
     * }
     * //Applying Singleton pattern
     * private static SingletonKind kind = SingletonKind.UNKNOWN;
     * private static Singleton instance;
     * 
     * By using this method prior to getInstance() method, you effectively change
     * the type of singleton instance to be created
     * public static void setKind(SingletonKind kind) {
     * Singleton.kind = kind;
     * }
     * 
     * If needed, getInstance() creates instance appropriate class, based on value
     * of singletonKind field.
     * public static Singleton getInstance()
     * throws NoSuchMethodException,
     * IllegalAccessException,
     * InvocationTargetException,
     * InstantiationException {
     * if(instance==null){
     * synchronized (Singleton.class){
     * if(instance==null){
     * Singleton singleton = new Singleton();
     * switch (kind){
     * case UNKNOWN:
     * instance = singleton;
     * break;
     * case LOWERCASE:
     * 
     * I can't use simple
     * instance = new LowercaseSingleton();
     * because java compiler won't allow me to use
     * constructor of inner class in static context,
     * so I use reflection API instead.
     * To be able to access inner class by reflection API,
     * I have to create instance of outer class first.
     * Therefore, in this implementation, Singleton cannot be
     * abstract class.
     * 
     * //Get the constructor of inner class.
     * Constructor<LowercaseSingleton> lcConstructor =
     * 
     * LowercaseSingleton.class.getDeclaredConstructor(Singleton.class);
     * //The constructor is private, so I have to make it accessible.
     * lcConstructor.setAccessible(true);
     * // Use the constructor to create instance.
     * instance = lcConstructor.newInstance(singleton);
     * break;
     * case UPPERCASE:
     * //Same goes here, just with different type
     * Constructor<UppercaseSingleton> ucConstructor =
     * 
     * UppercaseSingleton.class.getDeclaredConstructor(Singleton.class);
     * ucConstructor.setAccessible(true);
     * instance = ucConstructor.newInstance(singleton);
     * }
     * }
     * }
     * }
     * return instance;
     * }
     * //Singletons state that is to be used by subclasses
     * protected String message;
     * //Private constructor prevents external instantiation.
     * private Singleton()
     * {
     * message = "Hello world!";
     * }
     * //Singleton's API. Implementation can be overwritten by subclasses.
     * public String getMessage() {
     * return message;
     * }
     * }
     * //Just a small test program
     * public class ExtendingSingletonExample {
     * public static void main(String args[]){
     * //just uncomment one of following lines to change singleton class
     * //Singleton.setKind(SingletonKind.UPPERCASE);
     * //Singleton.setKind(SingletonKind.LOWERCASE);
     * Singleton singleton = null;
     * try {
     * singleton = Singleton.getInstance();
     * } catch (NoSuchMethodException e) {
     * e.printStackTrace();
     * } catch (IllegalAccessException e) {
     * e.printStackTrace();
     * } catch (InvocationTargetException e) {
     * e.printStackTrace();
     * } catch (InstantiationException e) {
     * e.printStackTrace();
     * }
     * System.out.println(singleton.getMessage());
     * }
     * }
     */

    public static void main(String[] args) {
        Singleton3 singleton = null;
        try {
            singleton = Singleton3.getInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println(singleton.getMessage());
        // output: hello world
    }
}
