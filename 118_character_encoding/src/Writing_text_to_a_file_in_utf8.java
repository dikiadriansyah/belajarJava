import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Writing_text_to_a_file_in_utf8 {
    // Writing text to a file in UTF-8/Menulis teks ke file dalam UTF-8

    /*
     * import java.io.BufferedWriter;
     * import java.io.IOException;
     * import java.nio.charset.StandardCharsets;
     * import java.nio.file.Files;
     * import java.nio.file.Paths;
     * 
     * public class WritingUTF8TextFile {
     * public static void main(String[] args) throws IOException {
     * //StandardCharsets is available since Java 1.7
     * //for ealier version use Charset.forName("UTF-8");
     * try (BufferedWriter wr = Files.newBufferedWriter(Paths.get("test2.txt"),
     * StandardCharsets.UTF_8)) {
     * wr.write("Cyrillic symbol Ы");
     * }
     * }
     * }
     * 
     */

    public static void main(String[] args) throws Exception {
        // StandardCharsets is available since Java 1.7
        // for ealier version use Charset.forName("UTF-8");
        try (BufferedWriter wr = Files.newBufferedWriter(Paths.get("file3.txt"),
                StandardCharsets.UTF_8)) {
            wr.write("Cyrillic symbol Ы");
        }

    }
}
