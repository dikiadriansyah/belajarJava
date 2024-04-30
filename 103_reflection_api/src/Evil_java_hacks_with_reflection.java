import java.lang.reflect.Field;

public class Evil_java_hacks_with_reflection {
    // Evil Java hacks with Reflection/Peretasan Java Jahat dengan Refleksi

    /*
     * Reflection API dapat digunakan untuk mengubah nilai bidang privat dan final
     * bahkan di perpustakaan default JDK. Ini dapat digunakan untuk memanipulasi
     * perilaku beberapa kelas terkenal seperti yang akan kita lihat.
     */

    // Apa yang tidak mungkin
    /*
     * Mari kita mulai dengan satu-satunya batasan yang berarti satu-satunya bidang
     * yang tidak dapat kita ubah dengan Refleksi. Itulah java
     * Security Manager. Itu dideklarasikan di java.lang.System sebagai
     * 
     * private static volatile SecurityManager security = null;
     * 
     */

    /*
     * Tapi itu tidak akan terdaftar di kelas Sistem jika kita menjalankan kode ini
     * for(Field f : System.class.getDeclaredFields())
     * System.out.println(f);
     * 
     */

    /*
     * Itu karena fieldFilterMap di sun.reflect.Reflection yang menampung peta itu
     * sendiri dan bidang keamanan di dalamnya System.class dan melindunginya dari
     * akses apa pun dengan Refleksi. Jadi kami tidak dapat menonaktifkannya
     * Security Manager.
     */

    // Crazy Strings/String Gila

    /*
     * Setiap String Java diwakili oleh JVM sebagai turunan dari kelas String.
     * Namun, dalam beberapa situasi JVM
     * menghemat ruang heap dengan menggunakan instance yang sama untuk Strings. Hal
     * ini terjadi untuk string literal, dan juga untuk
     * string yang telah "diinternir" dengan memanggil String.intern(). Jadi jika
     * Anda memiliki "hello" dalam kode Anda beberapa kali, itu selalu merupakan
     * contoh objek yang sama.
     * 
     * String seharusnya tidak dapat diubah, tetapi refleksi "evil" dapat digunakan
     * untuk mengubahnya. Contohnya di bawah ini
     * menunjukkan bagaimana kita dapat mengubah karakter dalam sebuah String dengan
     * mengganti bidang nilainya.
     */

    /*
     * public class CrazyStrings {
     * static {
     * try {
     * Field f = String.class.getDeclaredField("value");
     * f.setAccessible(true);
     * f.set("hello", "you stink!".toCharArray());
     * } catch (Exception e) {
     * }
     * }
     * public static void main(String args[]) {
     * System.out.println("hello");
     * }
     * }
     * 
     */

    // Jadi kode ini akan mencetak "kamu bau!"
    // 1 = 42
    // Ide yang sama dapat digunakan dengan Kelas Integer

    /*
     * public class CrazyMath {
     * static {
     * try {
     * Field value = Integer.class.getDeclaredField("value");
     * value.setAccessible(true);
     * value.setInt(Integer.valueOf(1), 42);
     * } catch (Exception e) {
     * }
     * }
     * public static void main(String args[]) {
     * System.out.println(Integer.valueOf(1));
     * }
     * }
     * 
     */

    // Semuanya benar
    // Dan menurut postingan stackoverflow ini kita dapat menggunakan refleksi untuk
    // melakukan sesuatu yang sangat jahat.

    /*
     * public class Evil {
     * static {
     * try {
     * Field field = Boolean.class.getField("FALSE");
     * field.setAccessible(true);
     * Field modifiersField = Field.class.getDeclaredField("modifiers");
     * modifiersField.setAccessible(true);
     * modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
     * field.set(null, true);
     * } catch (Exception e) {
     * }
     * }
     * public static void main(String args[]){
     * System.out.format("Everything is %s", false);
     * }
     * }
     */

    // Perhatikan bahwa apa yang kita lakukan di sini akan menyebabkan JVM
    // berperilaku tidak dapat dijelaskan. Ini sangat berbahaya.

    // --------------
    // static {
    // try {
    // Field f = String.class.getDeclaredField("value");
    // f.setAccessible(true);
    // f.set("hello", "you stink!".toCharArray());
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    // --------------
    // static {
    // try {
    // Field value = Integer.class.getDeclaredField("value");
    // value.setAccessible(true);
    // value.setInt(Integer.valueOf(1), 42);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }

    // ----------------
    static {
        try {
            Field field = Boolean.class.getField("FALSE");
            field.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // System.out.println("hello");
        // -----------------------
        // System.out.println(Integer.valueOf(1));
        // output: 42
        // ----------------------
        System.out.format("Everything is %s", false);

    }
}
