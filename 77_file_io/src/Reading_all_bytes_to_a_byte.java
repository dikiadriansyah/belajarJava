import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Reading_all_bytes_to_a_byte {
    // Reading all bytes to a byte[]/Membaca semua byte ke byte[]

    // Java 7 memperkenalkan kelas Files yang sangat berguna
    /*
     * Version ≥ Java SE 7
     * 
     * import java.nio.file.Files;
     * import java.nio.file.Paths;
     * import java.nio.file.Path;
     * Path path = Paths.get("path/to/file");
     * try {
     * byte[] data = Files.readAllBytes(path);
     * } catch(IOException e) {
     * e.printStackTrace();
     * }
     */

    public static void main(String[] args) {
        Path path = Paths.get("D:\\test.txt");
        try {
            byte[] data = Files.readAllBytes(path);
            System.out.println("Data yang dibaca: " + new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Data yang dibaca: This will be written in test.txt
         */

    }
}
