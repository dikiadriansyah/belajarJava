import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Retrieving_information_using_the_filesystem {
    // Retrieving information using the filesystem/Mengambil informasi menggunakan
    // sistem file

    // Untuk berinteraksi dengan sistem file Anda menggunakan metode kelas File.

    // Checking existence/Memeriksa keberadaan
    // Untuk memeriksa keberadaan file atau direktori yang ditunjuk jalurnya, Anda
    // menggunakan metode berikut:
    // Files.exists(Path path)

    // dan
    // Files.notExists(Path path)

    /*
     * !Files.exists(path) tidak harus sama dengan Files.notExists(path), karena ada
     * tiga kemungkinan skenario:
     * Keberadaan file atau direktori diverifikasi (exists mengembalikan nilai true
     * dan notExists mengembalikan false dalam kasus ini)
     * 
     * Ketidakberadaan file atau direktori diverifikasi (exists mengembalikan false
     * dan notExists mengembalikan true)
     * 
     * Baik keberadaan maupun ketiadaan file atau direktori tidak dapat diverifikasi
     * (misalnya karena pembatasan akses): Baik yang ada maupun yang tidak ada akan
     * menghasilkan false.
     */

    // Checking whether a path points to a file or a directory/Memeriksa apakah
    // jalur menunjuk ke file atau direktori

    // Ini dilakukan dengan menggunakan Files.isDirectory(Jalur jalur) dan
    // Files.isRegularFile(Jalur jalur)
    /*
     * Path p1 = Paths.get("/var/www");
     * Path p2 = Paths.get("/home/testuser/File.txt");
     * Files.isDirectory(p1) == true
     * Files.isRegularFile(p1) == false
     * Files.isDirectory(p2) == false
     * Files.isRegularFile(p2) == true
     */

    // Getting properties/Mendapatkan properti
    // Hal ini dapat dilakukan dengan menggunakan metode berikut:
    /*
     * Files.isReadable(Path path)
     * Files.isWritable(Path path)
     * Files.isExecutable(Path path)
     * Files.isHidden(Path path)
     * Files.isSymbolicLink(Path path)
     */

    // Getting MIME type/Mendapatkan tipe MIME
    // Files.probeContentType(Path path)

    // Ini mencoba untuk mendapatkan tipe file MIME. Ia mengembalikan String tipe
    // MIME, seperti ini:
    /*
     * text/plain for text files
     * text/html for HTML pages
     * application/pdf for PDF files
     * image/png for PNG files
     */

    public static void main(String[] args) {
        // String filePath = "file.txt";

        // Membuat objek Path dari string path
        // Path path = FileSystems.getDefault().getPath(filePath);

        // Memeriksa keberadaan file
        // if (Files.exists(path)) {
        // System.out.println("File " + filePath + " ditemukan.");
        // } else {
        // System.out.println("File " + filePath + " tidak ditemukan.");
        // }
        /*
         * output:
         * File file.txt ditemukan.
         */
        // -----------------------------------
        Path p1 = Paths.get("\\belajarJava\\76_new_file_io\\src");
        // Path p2 = Paths.get("file");

        System.out.println("Is Directory p1: " + Files.isDirectory(p1)); // true
        System.out.println("Is Regular File p1: " + Files.isRegularFile(p1)); // false
    }
}
