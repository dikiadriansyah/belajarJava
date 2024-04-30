import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reading_a_whole_file_at_once {
    // Reading a whole file at once/Membaca seluruh file sekaligus

    /*
     * File f = new File(path);
     * String content = new Scanner(f).useDelimiter("\\Z").next();
     */

    // \Z adalah Simbol EOF (End of File). Ketika ditetapkan sebagai delimiter,
    // scanner akan membaca isian hingga Bendera EOF tercapai.

    public static void main(String[] args) {
        // Mengganti "path" dengan path sesuai dengan lokasi file yang ingin dibaca
        String path = "hello.txt";

        File file = new File(path);

        try {
            // Membaca isi file menggunakan Scanner
            String content = new Scanner(file).useDelimiter("\\Z").next();

            // Menampilkan isi file ke konsol
            System.out.println("File Content:");
            System.out.println(content);
        } catch (FileNotFoundException e) {
            // Menangani jika file tidak ditemukan
            System.out.println("File not found: " + e.getMessage());
        }
        /*
         * output:
         * File Content:
         * Hello world!
         */

    }
}
