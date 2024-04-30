import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Iterate_over_a_directory_printing_subdirectories_in_it {
    // Iterate over a directory printing subdirectories in it / Iterasi pada
    // subdirektori pencetakan direktori di dalamnya

    public static void main(String[] args) {
        try {
            iterate("D://belajarJava/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * $RECYCLE.BIN
         * belajarJava
         * System Volume Information
         */

    }

    public static void iterate(final String dirPath) throws IOException {
        final DirectoryStream<Path> paths = Files.newDirectoryStream(Paths.get(dirPath));
        for (final Path path : paths) {
            if (Files.isDirectory(path)) {
                System.out.println(path.getFileName());
            }
        }
    }

}
