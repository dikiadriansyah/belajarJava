import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public class Getting_instance_of_unsafe {
    // Getting Instance of Unsafe/Mendapatkan Contoh Tidak Aman

    /*
     * Tidak aman disimpan sebagai bidang pribadi yang tidak dapat diakses secara
     * langsung. Konstruktor bersifat pribadi dan satu-satunya metode untuk
     * mengakses public static Unsafe getUnsafe() yang memiliki akses istimewa.
     * Dengan menggunakan refleksi, ada solusi untuk membuat bidang pribadi dapat
     * diakses:
     */

    /*
     * public static final Unsafe UNSAFE;
     * static {
     * Unsafe unsafe = null;
     * try {
     * final PrivilegedExceptionAction<Unsafe> action = () -> {
     * final Field f = Unsafe.class.getDeclaredField("theUnsafe");
     * f.setAccessible(true);
     * return (Unsafe) f.get(null);
     * };
     * unsafe = AccessController.doPrivileged(action);
     * } catch (final Throwable t) {
     * throw new RuntimeException("Exception accessing Unsafe", t);
     * }
     * UNSAFE = unsafe;
     * }
     */
    public static final Unsafe UNSAFE;

    static {
        Unsafe unsafe = null;
        try {
            final PrivilegedExceptionAction<Unsafe> action = () -> {
                final Field f = Unsafe.class.getDeclaredField("theUnsafe");
                f.setAccessible(true);
                return (Unsafe) f.get(null);
            };
            unsafe = AccessController.doPrivileged(action);
        } catch (final Throwable t) {
            throw new RuntimeException("Exception accessing Unsafe", t);
        }
        UNSAFE = unsafe;
    }

    public static void main(String[] args) {
        // You can use UNSAFE here as needed
        System.out.println("UNSAFE object: " + UNSAFE); // output: UNSAFE object: sun.misc.Unsafe@5f8ed237
    }
}
