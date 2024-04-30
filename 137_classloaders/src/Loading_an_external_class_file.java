import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loading_an_external_class_file extends ClassLoader {
    // Loading an external .class file/Memuat file .class eksternal

    /*
     * Untuk memuat kelas kita perlu mendefinisikannya terlebih dahulu. Kelas
     * ditentukan oleh ClassLoader. Hanya ada satu masalah, Oracle tidak menulis
     * kode ClassLoader dengan fitur ini tersedia. Untuk mendefinisikan kelas kita
     * perlu mengakses metode bernama defineClass() yang merupakan metode pribadi
     * dari ClassLoader
     */

    /*
     * Untuk mengaksesnya, yang akan kita lakukan adalah membuat kelas baru,
     * ByteClassLoader, dan memperluasnya ke ClassLoader. Sekarang kita telah
     * memperluas kelas kita ke ClassLoader, kita dapat mengakses metode privat
     * ClassLoader. Untuk membuat
     * defineClass() tersedia, kita akan membuat metode baru yang akan bertindak
     * seperti cermin untuk metode privat defineClass(). Untuk memanggil metode
     * privat kita memerlukan nama kelas, nama, byte kelas, classBytes, offset byte
     * pertama, yang akan menjadi 0 karena data classBytes dimulai pada
     * classBytes[0], dan offset byte terakhir, yang akan menjadi
     * classBytes.lenght karena mewakili ukuran data, yang akan menjadi offset
     * terakhir.
     */

    /*
     * public class ByteClassLoader extends ClassLoader {
     * public Class<?> defineClass(String name, byte[] classBytes) {
     * return defineClass(name, classBytes, 0, classBytes.length);
     * }
     * }
     */

    /*
     * Sekarang, kita memiliki metode defineClass() publik. Itu bisa dipanggil
     * dengan meneruskan nama kelas dan byte kelas sebagai argumen.
     */

    /*
     * Katakanlah kita memiliki kelas bernama MyClass dalam paket stackoverflow...
     * 
     * Untuk memanggil metode ini kita memerlukan kelas byte sehingga kita membuat
     * objek Path yang mewakili jalur kelas kita dengan menggunakan
     * Metode Paths.get() dan meneruskan jalur kelas biner sebagai argumen.
     * Sekarang, kita bisa mendapatkan byte kelas dengan
     * Files.readAllBytes(path). Jadi kita membuat instance ByteClassLoader dan
     * menggunakan metode yang kita buat,
     * defineClass(). Kita sudah memiliki kelas byte tetapi untuk memanggil
     * metode kita, kita juga memerlukan nama kelas yang diberikan
     * dengan nama paket (titik) nama kanonik kelas, dalam hal ini
     * stackoverflow.MyClass.
     */

    /*
     * Path path = Paths.get("MyClass.class");
     * ByteClassLoader loader = new ByteClassLoader();
     * loader.defineClass("stackoverflow.MyClass", Files.readAllBytes(path);
     */

    /*
     * Catatan: Metode defineClass() mengembalikan objek Class<?>. Anda dapat
     * menyimpannya jika Anda mau.
     * 
     * Untuk memuat kelas, kita cukup memanggil loadClass() dan meneruskan nama
     * kelasnya. Metode ini dapat membuang
     * ClassNotFoundException jadi kita perlu menggunakan blok try cath
     * 
     * try{
     * loader.loadClass("stackoverflow.MyClass");
     * } catch(ClassNotFoundException e){
     * e.printStackTrace();
     * }
     * 
     */

    public Class<?> defineClass(String name, byte[] classBytes) {
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("MyClass.class");
        Loading_an_external_class_file loader = new Loading_an_external_class_file();
        byte[] classBytes = Files.readAllBytes(path);
        Class<?> loadedClass = loader.defineClass("stackoverflow.MyClass", classBytes);
        System.out.println("Class loaded: " + loadedClass.getName());
    }
}
