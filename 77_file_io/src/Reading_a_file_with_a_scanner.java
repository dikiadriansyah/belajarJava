import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reading_a_file_with_a_scanner {
    // Reading a file with a Scanner/Membaca file dengan Pemindai

    // Membaca file baris demi baris
    /*
     * public class Main {
     * public static void main(String[] args) {
     * try {
     * Scanner scanner = new Scanner(new File("example.txt"));
     * while(scanner.hasNextLine())
     * {
     * String line = scanner.nextLine();
     * //do stuff
     * }
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    // kata demi kata
    /*
     * public class Main {
     * public static void main(String[] args) {
     * try {
     * Scanner scanner = new Scanner(new File("example.txt"));
     * while(scanner.hasNext())
     * {
     * String line = scanner.next();
     * //do stuff
     * }
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    // dan Anda juga dapat mengubah pembatas dengan menggunakan metode
    // scanner.useDelimiter()

    public static void main(String[] args) {
        // try {
        // Scanner scanner = new Scanner(new File("example.txt"));
        // while (scanner.hasNextLine()) {
        // String line = scanner.nextLine();
        // // do stuff

        // System.out.println(line);
        // /*
        // * output:
        // * uji coba
        // */
        // }
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // }
        // ----------------------
        try {
            Scanner scanner = new Scanner(new File("example.txt"));
            while (scanner.hasNext()) {
                String line = scanner.next();
                // do stuff

                System.out.println(line);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * uji
         * coba
         */

    }
}
