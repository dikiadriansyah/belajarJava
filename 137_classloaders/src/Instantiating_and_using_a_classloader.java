import java.net.URLClassLoader;
import java.net.URL;
import java.net.URLClassLoader;

public class Instantiating_and_using_a_classloader {
    // Instantiating and using a classloader/Membuat instance dan menggunakan
    // classloader

    /*
     * Contoh dasar ini menunjukkan bagaimana aplikasi dapat membuat instance
     * classloader dan menggunakannya untuk memuat kelas secara dinamis.
     * 
     * URL[] urls = new URL[] {new URL("file:/home/me/extras.jar")};
     * Classloader loader = new URLClassLoader(urls);
     * Class<?> myObjectClass = loader.findClass("com.example.MyObject");
     */

    /*
     * Classloader yang dibuat dalam contoh ini akan memiliki classloader default
     * sebagai induknya, dan pertama-tama akan mencoba menemukan kelas apa pun di
     * classloader induk sebelum mencari di "extra.jar". Jika kelas yang diminta
     * sudah dimuat, panggilan findClass akan mengembalikan referensi ke kelas yang
     * dimuat sebelumnya.
     * 
     * Panggilan findClass bisa gagal dalam berbagai cara. Yang paling umum adalah:
     * 
     * 1. Jika kelas bernama tidak dapat ditemukan, panggilan dengan throw
     * ClassNotFoundException.
     * 2. Jika kelas yang diberi nama bergantung pada kelas lain yang tidak dapat
     * ditemukan, pemanggilan akan dilakukan
     * NoClassDefFoundError.
     */

    public static void main(String[] args) throws Exception {
        URL[] urls = new URL[] { new URL("file:/home/me/extras.jar") };
        ClassLoader loader = new URLClassLoader(urls);
        Class<?> myObjectClass = loader.loadClass("com.example.MyObject");

        System.out.println("Class found: " + myObjectClass.getName());
    }
}
