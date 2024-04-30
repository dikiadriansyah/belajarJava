import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Wrapping_input_output_streams {
    // Wrapping Input/Output Streams / Membungkus Aliran Input/Output

    /*
     * OutputStream dan InputStream memiliki banyak kelas berbeda, masing-masing
     * memiliki fungsi unik. Dengan membungkus
     * aliran di sekitar aliran lainnya, Anda mendapatkan fungsionalitas dari kedua
     * aliran.
     * 
     * Anda dapat menyelesaikan streaming beberapa kali, cukup catat urutannya.
     * 
     * Kombinasi yang berguna
     * Menulis karakter ke file saat menggunakan buffer
     * File myFile = new File("targetFile.txt");
     * PrintWriter writer = new PrintWriter(new BufferedOutputStream(new
     * FileOutputStream(myFile)));
     * 
     */

    /*
     * Mengompresi dan mengenkripsi data sebelum menulis ke file saat menggunakan
     * buffer
     * 
     * Cipher cipher = ... // Initialize cipher
     * File myFile = new File("targetFile.enc");
     * BufferedOutputStream outputStream = new BufferedOutputStream(new
     * DeflaterOutputStream(new
     * CipherOutputStream(new FileOutputStream(myFile), cipher)));
     */

    // List of Input/Output Stream wrappers

    // Wrapper
    /*
     * BufferedOutputStream/
     * BufferedInputStream
     * 
     * DeflaterOutputStream/
     * DeflaterInputStream
     * 
     * InflaterOutputStream/ InflaterInputStream
     * 
     * CipherOutputStream/ CipherInputStream
     * 
     * DigestOutputStream/ DigestInputStream
     * 
     * CheckedOutputStream/
     * CheckedInputStream
     * 
     * DataOutputStream/ DataInputStream
     * 
     * PrintStream
     * 
     * OutputStreamWriter
     * 
     * PrintWriter
     * 
     */

    /*
     * Description
     * While OutputStream writes data one byte at a time,
     * BufferedOutputStream writes data in chunks. This reduces the
     * number of system calls, thus improving performance.
     * 
     * Performs data compression.
     * 
     * Performs data decompression
     * 
     * Encrypts/Decrypts data.
     * 
     * Generates Message Digest to verify data integrity.
     * 
     * Generates a CheckSum. CheckSum is a more trivial version of
     * Message Digest.
     * 
     * Allows writing of primitive data types and Strings. Meant for writing
     * bytes. Platform independent.
     * 
     * Allows writing of primitive data types and Strings. Meant for writing
     * bytes. Platform dependent.
     * 
     * Converts a OutputStream into a Writer. An OutputStream deals with
     * bytes while Writers deals with characters
     * 
     * 
     * Automatically calls OutputStreamWriter. Allows writing of primitive
     * data types and Strings. Strictly for writing characters and best for
     * writing characters
     * 
     */

    public static void main(String[] args) {
        // Nama file yang ingin Anda buat atau tuju
        String namaFile = "outfilename.txt";

        try {
            // Membuat objek File
            File myFile = new File(namaFile);

            // Membuat objek PrintWriter dengan menggunakan BufferedOutputStream dan
            // FileOutputStream
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(myFile)));

            // Menulis konten ke dalam file
            writer.println("Hello, ini adalah contoh tulisan dalam file.");
            writer.println("Baris kedua tulisan.");

            // Menutup writer untuk menyimpan perubahan
            writer.close();

            System.out.println("File '" + namaFile + "' berhasil dibuat.");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
