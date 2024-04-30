import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copying_input_stream_to_output_stream {
    // Copying Input Stream to Output Stream / Menyalin Aliran Input ke Aliran
    // Output

    // Fungsi ini menyalin data antara dua aliran -

    /*
     * void copy(InputStream in, OutputStream out) throws IOException {
     * byte[] buffer = new byte[8192];
     * while ((bytesRead = in.read(buffer)) > 0) {
     * out.write(buffer, 0, bytesRead);
     * }
     * }
     * 
     */

    // contoh
    /*
     * // reading from System.in and writing to System.out
     * copy(System.in, System.out);
     */

    static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, bytesRead);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            copy(System.in, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // reading from System.in and writing to System.out
        // copy(System.in, System.out);
    }
}
