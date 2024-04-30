import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invoking_a_method {
    // Invoking a method/Memanggil suatu metode

    /*
     * Dengan menggunakan refleksi, metode suatu objek dapat dipanggil saat runtime.
     * 
     * Contoh ini menunjukkan cara memanggil metode String object.
     */

    /*
     * import java.lang.reflect.InvocationTargetException;
     * import java.lang.reflect.Method;
     * String s = "Hello World!";
     * // method without parameters
     * // invoke s.length()
     * Method method1 = String.class.getMethod("length");
     * int length = (int) method1.invoke(s); // variable length contains "12"
     * // method with parameters
     * // invoke s.substring(6)
     * Method method2 = String.class.getMethod("substring", int.class);
     * String substring = (String) method2.invoke(s, 6); // variable substring
     * contains "World!"
     * 
     */

    public static void main(String[] args) throws Exception {
        String s = "Hello World!";
        // method without parameters
        // invoke s.length()
        Method method1 = String.class.getMethod("length");
        int length = (int) method1.invoke(s); // variable length contains "12"
        // method with parameters
        // invoke s.substring(6)
        Method method2 = String.class.getMethod("substring", int.class);
        String substring = (String) method2.invoke(s, 6); // variable substring contains "World!"

        System.out.println("Length of the string: " + length); // output: Length of the string: 12
        System.out.println("Substring from index 6: " + substring); // output: Substring from index 6: World!
    }
}
