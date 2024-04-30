import sun.misc.Unsafe;

public class Instantiating_sun_misc_unsafe_via_boothclasspath {
    // Instantiating sun.misc.Unsafe via bootclasspath/Membuat instance
    // sun.misc.Unsafe melalui bootclasspath

    /*
     * public class UnsafeLoader {
     * public static Unsafe loadUnsafe() {
     * return Unsafe.getUnsafe();
     * }
     * }
     */

    /*
     * Meskipun contoh ini akan dikompilasi, kemungkinan besar akan gagal saat
     * runtime kecuali kelas Unsafe dimuat dengan classloader utama. Untuk
     * memastikan hal itu terjadi, JVM harus dimuat dengan argumen yang sesuai,
     * seperti:
     * 
     * java -Xbootclasspath:$JAVA_HOME/jre/lib/rt.jar:./UnsafeLoader.jar
     * foo.bar.MyApp
     */

    // Kelas foo.bar.MyApp kemudian dapat menggunakan UnsafeLoader.loadUnsafe().
    public static void main(String[] args) {
        Unsafe unsafe = UnsafeLoader.loadUnsafe();
        System.out.println("Unsafe instance loaded successfully: " + unsafe);
    }
}
