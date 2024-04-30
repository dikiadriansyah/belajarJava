import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Reading_a_file_using_bufferedinputstream {
    // Reading a file using BufferedInputStream/Membaca file menggunakan
    // BufferedInputStream

    /*
     * Membaca file menggunakan BufferedInputStream umumnya lebih cepat daripada
     * FileInputStream karena mempertahankan buffer internal untuk menyimpan byte
     * yang dibaca dari aliran input yang mendasarinya.
     */

    /*
     * import java.io.BufferedInputStream;
     * import java.io.FileInputStream;
     * import java.io.IOException;
     * public class FileReadingDemo {
     * public static void main(String[] args) {
     * String source = "hello.txt";
     * 
     * try (BufferedInputStream bis = new BufferedInputStream(new
     * FileInputStream(source))) {
     * byte data;
     * while ((data = (byte) bis.read()) != -1) {
     * System.out.println((char) data);
     * }
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        String source = "hello.txt";

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source))) {
            byte data;
            while ((data = (byte) bis.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * H
         * e
         * l
         * l
         * o
         * 
         * w
         * o
         * r
         * l
         * d
         * !
         */

    }
}
