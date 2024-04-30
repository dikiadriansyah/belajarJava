import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;

public class Writing_a_file_using_printstream {
    // Writing a file using PrintStream/Menulis file menggunakan PrintStream

    /*
     * Kita dapat menggunakan kelas PrintStream untuk menulis file. Ini memiliki
     * beberapa metode yang memungkinkan Anda mencetak nilai tipe data apa pun.
     * 
     * metode println() menambahkan baris baru. Setelah kita selesai mencetak, kita
     * harus membilas PrintStream.
     */

    /*
     * import java.io.FileNotFoundException;
     * import java.io.PrintStream;
     * import java.time.LocalDate;
     * public class FileWritingDemo {
     * public static void main(String[] args) {
     * String destination = "file1.txt";
     * try(PrintStream ps = new PrintStream(destination)){
     * ps.println("Stackoverflow documentation seems fun.");
     * ps.println();
     * ps.println("I love Java!");
     * ps.printf("Today is: %1$tm/%1$td/%1$tY", LocalDate.now());
     * ps.flush();
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        String destination = "file1.txt";
        try (PrintStream ps = new PrintStream(destination)) {
            ps.println("Stackoverflow documentation seems fun.");
            ps.println();
            ps.println("I love Java!");
            ps.printf("Today is: %1$tm/%1$td/%1$tY", LocalDate.now());
            ps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
