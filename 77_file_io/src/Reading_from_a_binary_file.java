import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reading_from_a_binary_file {
    // Reading from a binary file/Membaca dari file biner

    // Anda dapat membaca file biner menggunakan potongan kode ini di semua versi
    // terbaru Java:

    /*
     * Version ≥ Java SE 1.4
     * 
     * File file = new File("path_to_the_file");
     * byte[] data = new byte[(int) file.length()];
     * DataInputStream stream = new DataInputStream(new FileInputStream(file));
     * stream.readFully(data);
     * stream.close();
     */

    // Jika Anda menggunakan Java 7 atau lebih baru, ada cara yang lebih sederhana
    // menggunakan nio API
    /*
     * Version ≥ Java SE 7
     * Path path = Paths.get("path_to_the_file");
     * byte [] data = Files.readAllBytes(path);
     */

    public static void main(String[] args) {
        // Ganti "path_to_the_file" dengan path file yang sesuai
        Path path = Paths.get("hello.txt");

        try {
            byte[] data = Files.readAllBytes(path);
            // Lakukan sesuatu dengan data yang telah dibaca, misalnya mencetaknya
            System.out.println("Data yang dibaca dari file:");
            System.out.println(new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Data yang dibaca dari file:
         * Hello world!
         */

    }
}
