
import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class Instantiating_sun_misc_unsafe_via_reflection {
    // Instantiating sun.misc.Unsafe via reflection/Membuat instance sun.misc.Unsafe
    // melalui refleksi

    /*
     * public static Unsafe getUnsafe() {
     * try {
     * Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
     * unsafe.setAccessible(true);
     * return (Unsafe) unsafe.get(null);
     * } catch (IllegalAccessException e) {
     * // Handle
     * } catch (IllegalArgumentException e) {
     * // Handle
     * } catch (NoSuchFieldException e) {
     * // Handle
     * } catch (SecurityException e) {
     * // Handle
     * }
     * }
     */

    /*
     * sun.misc.Unsafe memiliki konstruktor Pribadi, dan metode statis getUnsafe()
     * dilindungi dengan pemeriksaan classloader untuk memastikan bahwa kode dimuat
     * dengan classloader utama. Oleh karena itu, salah satu metode memuat instance
     * adalah dengan menggunakan refleksi untuk mendapatkan bidang statis.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ------------------
        Unsafe unsafe = getUnsafe();
        System.out.println(unsafe); // output: sun.misc.Unsafe@383534aa
    }

    public static Unsafe getUnsafe() {
        try {
            Field unsafe = Unsafe.class.getDeclaredField("theUnsafe");
            unsafe.setAccessible(true);
            return (Unsafe) unsafe.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

}
