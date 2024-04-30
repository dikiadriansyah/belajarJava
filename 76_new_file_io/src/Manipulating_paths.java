import java.nio.file.Path;
import java.nio.file.Paths;

public class Manipulating_paths {
    // Manipulating paths/Memanipulasi jalur

    // Joining Two Paths/Menggabungkan Dua Jalur

    /*
     * Jalur dapat digabungkan menggunakan metode resolve(). Jalur yang dilewati
     * harus berupa jalur parsial, yaitu jalur yang tidak menyertakan elemen root.
     * 
     * Path p5 = Paths.get("/home/");
     * Path p6 = Paths.get("arthur/files");
     * Path joined = p5.resolve(p6);
     * Path otherJoined = p5.resolve("ford/files");
     * joined.toString() == "/home/arthur/files"
     * otherJoined.toString() == "/home/ford/files"
     */

    // Normalizing a path /Normalisasi jalur

    /*
     * Jalur mungkin berisi elemen . (yang menunjuk ke direktori tempat Anda berada
     * saat ini) dan ..(yang menunjuk ke direktori induk).
     * 
     * Saat digunakan di suatu jalur, . dapat dihapus kapan saja tanpa mengubah
     * tujuan jalur, dan .. dapat dihapus bersama dengan elemen sebelumnya.
     * 
     * Dengan Paths API, hal ini dilakukan menggunakan metode .normalize():
     * 
     * Path p7 = Paths.get("/home/./arthur/../ford/files");
     * Path p8 = Paths.get("C:\\Users\\.\\..\\Program Files");
     * p7.normalize().toString() == "/home/ford/files"
     * p8.normalize().toString() == "C:\\Program Files"
     */

    public static void main(String[] args) {
        Path p7 = Paths.get("/home/./arthur/../ford/files");
        // System.out.println(p7.normalize().toString() == "/home/ford/files");
        // output: false

        Path p8 = Paths.get("C:\\Users\\.\\..\\Program Files");
        System.out.println(p8.normalize().toString() == "C:\\Program Files");
        // output: false

    }
}
