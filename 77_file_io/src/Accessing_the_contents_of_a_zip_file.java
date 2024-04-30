import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Accessing_the_contents_of_a_zip_file {
    // Accessing the contents of a ZIP file/Mengakses konten file ZIP

    /*
     * FileSystem API Java 7 memungkinkan untuk membaca dan menambahkan entri dari
     * atau ke file Zip menggunakan API file Java NIO dengan cara yang sama seperti
     * beroperasi pada sistem file lainnya.
     * 
     * FileSystem adalah sumber daya yang harus ditutup dengan benar setelah
     * digunakan, oleh karena itu blok coba-dengan-sumber daya harus digunakan.
     */

    // Reading from an existing file/Membaca dari file yang ada
    /*
     * Path pathToZip = Paths.get("path/to/file.zip");
     * try(FileSystem zipFs = FileSystems.newFileSystem(pathToZip, null)) {
     * Path root = zipFs.getPath("/");
     * ... //access the content of the zip file same as ordinary files
     * } catch(IOException ex) {
     * ex.printStackTrace();
     * }
     * 
     */

    // Creating a new file/Membuat file baru

    /*
     * Map<String, String> env = new HashMap<>();
     * env.put("create", "true"); //required for creating a new zip file
     * env.put("encoding", "UTF-8"); //optional: default is UTF-8
     * URI uri = URI.create("jar:file:/path/to/file.zip");
     * try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
     * Path newFile = zipFs.getPath("/newFile.txt");
     * //writing to file
     * Files.write(newFile, "Hello world".getBytes());
     * } catch(IOException ex) {
     * ex.printStackTrace();
     * }
     */

    public static void main(String[] args) {
        Path pathToZip = Paths.get("D:/test.zip");

        try (FileSystem zipFs = FileSystems.newFileSystem(pathToZip, null)) {
            Path root = zipFs.getPath("/");
            // Akses konten file ZIP seperti file biasa di sini

            // Contoh: Mencetak daftar file di dalam ZIP
            System.out.println("Isi file ZIP:");
            Files.walk(root).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    System.out.println(filePath);
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /*
         * output:
         * Isi file ZIP:
         * /test.txt
         */
        // -----------------------------
        // Map<String, String> env = new HashMap<>();
        // env.put("create", "true"); // required for creating a new zip file
        // env.put("encoding", "UTF-8"); // optional: default is UTF-8
        // URI uri = URI.create("jar:file:/test.zip");

        // try (FileSystem zipFs = FileSystems.newFileSystem(uri, env)) {
        // Path newFile = zipFs.getPath("/newFile.txt");

        // // writing to file
        // Files.write(newFile, "Hello world".getBytes());
        // } catch (IOException ex) {
        // ex.printStackTrace();
        // }
    }
}
