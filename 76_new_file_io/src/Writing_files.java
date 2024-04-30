import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Writing_files {
    // Writing files/menulis file

    // File dapat ditulis sedikit demi sedikit menggunakan kelas Files

    /*
     * Path p2 = Paths.get("/home/testuser/File.txt");
     * List<String> lines = Arrays.asList(
     * new String[]{"First line", "Second line", "Third line"});
     * Files.write(p2, lines);
     * Files.write(Path path, byte[] bytes)
     * 
     */
    // File yang ada akan ditimpa, file yang tidak ada akan dibuat.

    public static void main(String[] args) {

        try {
            Path p2 = Paths.get("file2.txt");
            List<String> lines = Arrays.asList(
                    new String[] { "First line", "Second line", "Third line" });
            Files.write(p2, lines);
            // Files.write(Path path, byte[] bytes);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

}
