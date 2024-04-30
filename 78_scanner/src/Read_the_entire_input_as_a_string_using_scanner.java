import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_the_entire_input_as_a_string_using_scanner {
    // Read the entire input as a String using Scanner/Baca seluruh masukan sebagai
    // String menggunakan Pemindai

    /*
     * Anda dapat menggunakan scanner untuk membaca semua teks dalam masukan
     * sebagai String, dengan menggunakan \Z (keseluruhan masukan) sebagai pembatas.
     * Misalnya, ini bisa digunakan untuk membaca semua teks dalam file teks dalam
     * satu baris:
     * String content = new Scanner(new
     * File("filename")).useDelimiter("\\Z").next();
     * System.out.println(content);
     */

    /*
     * Ingatlah bahwa Anda harus menutup scanner, serta menangkap IoException yang
     * mungkin muncul, seperti dijelaskan dalam contoh Membaca input file
     * menggunakan scanner.
     */

    public static void main(String[] args) {
        try {
            String fileName = "hello.txt"; // Ganti dengan nama file yang sesuai
            String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
            System.out.println(content);
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please check the file path and try again.");
        }
        /*
         * output:
         * I love Bangladesh.
         */
    }
}
