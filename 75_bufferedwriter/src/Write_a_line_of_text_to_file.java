import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Write_a_line_of_text_to_file {
    // Write a line of text to File/Tulis sebaris teks ke File

    // Kode ini menulis string ke file. Penting untuk menutup penulis, jadi ini
    // dilakukan di blok finally.

    /*
     * public void writeLineToFile(String str) throws IOException {
     * File file = new File("file.txt");
     * BufferedWriter bw = null;
     * try {
     * bw = new BufferedWriter(new FileWriter(file));
     * bw.write(str);
     * } finally {
     * if (bw != null) {
     * bw.close();
     * }
     * }
     * }
     */

    /*
     * Perhatikan juga bahwa write(String s) tidak menempatkan karakter baris baru
     * setelah string ditulis. Untuk menggunakannya gunakan metode newLine().
     */

    // Version ≥ Java SE 7
    /*
     * Java 7 menambahkan paket java.nio.file, dan mencoba dengan sumber daya:
     * public void writeLineToFile(String str) throws IOException {
     * Path path = Paths.get("file.txt");
     * try (BufferedWriter bw = Files.newBufferedWriter(path)) {
     * bw.write(str);
     * }
     * }
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        try {
            writeLineToFile("Hello, World!");
            System.out.println("Data has been written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        /*
         * output:
         * Data has been written to file successfully.
         */

    }

    // public static void writeLineToFile(String str) throws IOException {
    // File file = new File("file.txt");
    // BufferedWriter bw = null;
    // try {
    // bw = new BufferedWriter(new FileWriter(file));
    // bw.write(str);
    // } finally {
    // if (bw != null) {
    // bw.close();
    // }
    // }

    // -------------
    public static void writeLineToFile(String str) throws IOException {
        Path path = Paths.get("file.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write(str);
        }

    }

}
