import java.util.*;
import java.lang.reflect.*;

public class Dynamic_proxies {
    // Dynamic Proxies/Proksi Dinamis

    /*
     * Proksi Dinamis tidak banyak hubungannya dengan Refleksi tetapi merupakan
     * bagian dari API. Ini pada dasarnya adalah cara untuk membuat implementasi
     * antarmuka yang dinamis. Ini bisa berguna saat membuat layanan maket.
     * Proksi Dinamis adalah contoh antarmuka yang dibuat dengan apa yang disebut
     * pengendali pemanggilan yang mencegat semua pemanggilan metode dan
     * memungkinkan penanganan pemanggilannya secara manual.
     */

    /*
     * public class DynamicProxyTest {
     * public interface MyInterface1{
     * public void someMethod1();
     * public int someMethod2(String s);
     * }
     * public interface MyInterface2{
     * public void anotherMethod();
     * }
     * 
     * public static void main(String args[]) throws Exception {
     * // the dynamic proxy class
     * Class<?> proxyClass = Proxy.getProxyClass(
     * ClassLoader.getSystemClassLoader(),
     * new Class[] {MyInterface1.class, MyInterface2.class});
     * // the dynamic proxy class constructor
     * Constructor<?> proxyConstructor =
     * proxyClass.getConstructor(InvocationHandler.class);
     * // the invocation handler
     * InvocationHandler handler = new InvocationHandler(){
     * // this method is invoked for every proxy method call
     * // method is the invoked method, args holds the method parameters
     * // it must return the method result
     * 
     * @Override
     * public Object invoke(Object proxy, Method method, Object[] args) throws
     * Throwable {
     * String methodName = method.getName();
     * if(methodName.equals("someMethod1")){
     * System.out.println("someMethod1 was invoked!");
     * return null;
     * }
     * if(methodName.equals("someMethod2")){
     * System.out.println("someMethod2 was invoked!");
     * System.out.println("Parameter: " + args[0]);
     * return 42;
     * }
     * if(methodName.equals("anotherMethod")){
     * System.out.println("anotherMethod was invoked!");
     * return null;
     * }
     * System.out.println("Unkown method!");
     * return null;
     * }
     * };
     * // create the dynamic proxy instances
     * MyInterface1 i1 = (MyInterface1) proxyConstructor.newInstance(handler);
     * MyInterface2 i2 = (MyInterface2) proxyConstructor.newInstance(handler);
     * // and invoke some methods
     * i1.someMethod1();
     * i1.someMethod2("stackoverflow");
     * i2.anotherMethod();
     * }
     * }
     * 
     */

    // Hasil dari kode ini adalah ini:
    /*
     * someMethod1 was invoked!
     * someMethod2 was invoked!
     * Parameter: stackoverflow
     * anotherMethod was invoked!
     */

    public interface MyInterface1 {
        public void someMethod1();

        public int someMethod2(String s);
    }

    public interface MyInterface2 {
        public void anotherMethod();
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ----------------
        // the dynamic proxy class
        Class<?> proxyClass = Proxy.getProxyClass(
                ClassLoader.getSystemClassLoader(),
                new Class[] { MyInterface1.class, MyInterface2.class });
        // the dynamic proxy class constructor
        Constructor<?> proxyConstructor = proxyClass.getConstructor(InvocationHandler.class);
        // the invocation handler
        InvocationHandler handler = new InvocationHandler() {
            // this method is invoked for every proxy method call
            // method is the invoked method, args holds the method parameters
            // it must return the method result
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if (methodName.equals("someMethod1")) {
                    System.out.println("someMethod1 was invoked!");
                    return null;
                }
                if (methodName.equals("someMethod2")) {
                    System.out.println("someMethod2 was invoked!");
                    System.out.println("Parameter: " + args[0]);
                    return 42;
                }
                if (methodName.equals("anotherMethod")) {
                    System.out.println("anotherMethod was invoked!");
                    return null;
                }
                System.out.println("Unkown method!");
                return null;
            }
        };
        // create the dynamic proxy instances
        MyInterface1 i1 = (MyInterface1) proxyConstructor.newInstance(handler);
        MyInterface2 i2 = (MyInterface2) proxyConstructor.newInstance(handler);
        // and invoke some methods
        i1.someMethod1();
        i1.someMethod2("stackoverflow");
        i2.anotherMethod();

        /*
         * hasil:
         * someMethod1 was invoked!
         * someMethod2 was invoked!
         * Parameter: stackoverflow
         * anotherMethod was invoked!
         */

    }
}
