import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Bufferedreader1 {
    // BufferedReader/Pembaca Buffer

    // Introduction

    /*
     * Kelas BufferedReader adalah pembungkus kelas Reader lainnya yang memiliki dua
     * tujuan utama:
     * 1. BufferedReader menyediakan buffering untuk Reader yang dibungkus. Ini
     * memungkinkan aplikasi membaca karakter
     * satu per satu tanpa overhead I/O yang berlebihan.
     * 2. BufferedReader menyediakan fungsionalitas untuk membaca teks baris demi
     * baris.
     */

    // Basics of using a BufferedReader/ Dasar-dasar penggunaan BufferedReader

    /*
     * Pola normal untuk menggunakan BufferedReader adalah sebagai berikut. Pertama,
     * Anda mendapatkan Pembaca yang ingin Anda baca karakternya. Selanjutnya Anda
     * membuat instance BufferedReader yang membungkus Reader. Kemudian Anda membaca
     * data karakter.
     * Akhirnya Anda menutup BufferedReader yang menutup `Reader. Misalnya:
     */

    /*
     * File someFile = new File("");
     * int aCount = 0;
     * try (FileReader fr = new FileReader(someFile);
     * BufferedReader br = new BufferedReader(fr)) {
     * // Count the number of 'a' characters.
     * int ch;
     * while ((ch = br.read()) != -1) {
     * if (ch == 'a') {
     * aCount++;
     * }
     * }
     * System.out.println("There are " + aCount + " 'a' characters in " + someFile);
     * }
     */

    // Anda dapat menerapkan pola ini ke Pembaca mana pun

    // Catatan:
    /*
     * 1. Kami telah menggunakan sumber daya percobaan Java 7 (atau lebih baru)
     * untuk memastikan bahwa pembaca yang mendasarinya selalu ditutup. Hal ini
     * untuk menghindari potensi kebocoran sumber daya. Di versi Java sebelumnya,
     * Anda akan menutup BufferedReader secara eksplisit di blok finally.
     * 2. Kode di dalam blok try hampir sama dengan apa yang akan kita gunakan jika
     * kita membaca langsung dari blok tersebut
     * FileReader. Faktanya, BufferedReader berfungsi persis seperti perilaku
     * Reader yang dibungkusnya. Bedanya, versi ini jauh lebih efisien.
     */

    /*
     * The BufferedReader buffer size
     * The BufferedReader.readLine() method
     * Example: reading all lines of a File into a List
     */

    // Hal ini dilakukan dengan memasukkan setiap baris ke dalam file, dan
    // menambahkannya ke dalam List<String>. Daftar tersebut kemudian
    // dikembalikan:

    /*
     * public List<String> getAllLines(String filename) throws IOException {
     * List<String> lines = new ArrayList<String>();
     * try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
     * String line = null;
     * while ((line = reader.readLine) != null) {
     * lines.add(line);
     * }
     * }
     * return lines;
     * }
     */

    // Java 8 menyediakan cara yang lebih ringkas untuk melakukan ini menggunakan
    // metode lines():

    /*
     * public List<String> getAllLines(String filename) throws IOException {
     * try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
     * return br.lines().collect(Collectors.toList());
     * }
     * return Collections.empty();
     * }
     */

    // --------------
    public static List<String> getAllLines(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace(); // handle the exception as per your requirement
            return Collections.emptyList(); // return an empty list if there is an error
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // File someFile = new File("outfilename");
        // int aCount = 0;
        // try (FileReader fr = new FileReader(someFile);
        // BufferedReader br = new BufferedReader(fr)) {
        // // Count the number of 'a' characters.
        // int ch;
        // while ((ch = br.read()) != -1) {
        // if (ch == 'a') {
        // aCount++;
        // }
        // }
        // System.out.println("There are " + aCount + " 'a' characters in " + someFile);
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        /*
         * output:
         * There are 1 'a' characters in outfilename
         */
        // ---------------------------------
        String filename = "outfilename"; // ganti dengan path file yang sebenarnya

        List<String> allLines = getAllLines(filename);

        if (!allLines.isEmpty()) {
            System.out.println("Isi file:");
            for (String line : allLines) {
                System.out.println(line);
            }
        } else {
            System.out.println("File kosong atau terjadi kesalahan dalam membaca file.");
        }

        /*
         * output:
         * Isi file:
         * the text
         * more text
         * a
         */

    }
}
