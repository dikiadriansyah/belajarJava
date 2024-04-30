import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copying_a_file_using_inputstream_and_outputstream {
    // Copying a file using InputStream and OutputStream/Menyalin file menggunakan
    // InputStream dan OutputStream

    /*
     * Kita bisa langsung menyalin data dari sumber ke data sink menggunakan loop.
     * Dalam contoh ini, kita membaca data dari sebuah
     * InputStream dan pada saat yang sama, menulis ke OutputStream. Setelah kita
     * selesai membaca dan menulis, kita harus menutup sumber dayanya.
     */

    /*
     * public void copy(InputStream source, OutputStream destination) throws
     * IOException {
     * try {
     * int c;
     * while ((c = source.read()) != -1) {
     * destination.write(c);
     * }
     * } finally {
     * if (source != null) {
     * source.close();
     * }
     * if (destination != null) {
     * destination.close();
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        try {
            InputStream sourceStream = new FileInputStream("hello.txt"); // Sumber InputStream (misalnya: new
            // FileInputStream("sumber.txt"));

            OutputStream destinationStream = new FileOutputStream("hello2.txt"); // Tujuan OutputStream (misalnya: new
            // FileOutputStream("tujuan.txt"));

            copy(sourceStream, destinationStream);

            System.out.println("File berhasil disalin.");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public static void copy(InputStream source, OutputStream destination) throws IOException {
        try {
            int c;
            while ((c = source.read()) != -1) {
                destination.write(c);
            }
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }

}
