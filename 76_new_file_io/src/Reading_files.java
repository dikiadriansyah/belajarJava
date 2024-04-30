import java.nio.file.*;
import java.util.List;
import java.net.URI;
import java.io.IOException;

public class Reading_files {
    // Reading files/membaca file

    // File dapat dibaca berdasarkan byte dan baris menggunakan kelas Files

    /*
     * Path p2 = Paths.get(URI.create("file:///home/testuser/File.txt"));
     * byte[] content = Files.readAllBytes(p2);
     * List<String> linesOfContent = Files.readAllLines(p2);
     */

    // Files.readAllLines() secara opsional menggunakan rangkaian karakter sebagai
    // parameter (standarnya adalah StandardCharsets.UTF_8):
    /*
     * List<String> linesOfContent = Files.readAllLines(p2,
     * StandardCharsets.ISO_8859_1);
     */

    public static void main(String[] args) {
        // Path creation using URI
        // URI uri = URI.create("/belajarJava/76_new_file_io/src/file.txt");
        Path p2 = Paths.get("file.txt");

        try {
            // Reading all bytes from the file
            byte[] content = Files.readAllBytes(p2);
            System.out.println("Content as bytes: " + new String(content));

            // Reading all lines from the file
            List<String> linesOfContent = Files.readAllLines(p2);
            System.out.println("Content as lines:");
            for (String line : linesOfContent) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * output:
         * Content as bytes: Hello, World!
         * Content as lines:
         * Hello, World!
         */

    }
}
