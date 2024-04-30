import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class Iterating_over_a_directory_and_filter_by_file_extension {
    // Iterating over a directory and filter by file extension / Iterasi pada
    // direktori dan filter berdasarkan ekstensi file

    /*
     * public void iterateAndFilter() throws IOException {
     * Path dir = Paths.get("C:/foo/bar");
     * PathMatcher imageFileMatcher =
     * FileSystems.getDefault().getPathMatcher(
     * "regex:.*(?i:jpg|jpeg|png|gif|bmp|jpe|jfif)");
     * try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,
     * entry -> imageFileMatcher.matches(entry.getFileName()))) {
     * for (Path path : stream) {
     * System.out.println(path.getFileName());
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        try {
            new Iterating_over_a_directory_and_filter_by_file_extension().iterateAndFilter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Tulips.jpg
         */

    }

    public void iterateAndFilter() throws IOException {
        Path dir = Paths.get("D:/belajarJava/");
        PathMatcher imageFileMatcher = FileSystems.getDefault().getPathMatcher(
                "regex:.*(?i:jpg|jpeg|png|gif|bmp|jpe|jfif)");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,
                entry -> imageFileMatcher.matches(entry.getFileName()))) {
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        }
    }

}
