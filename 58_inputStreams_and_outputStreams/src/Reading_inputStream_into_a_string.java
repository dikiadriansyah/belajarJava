import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.*;

public class Reading_inputStream_into_a_string {
    // Reading InputStream into a String/ Membaca InputStream menjadi sebuah String
    /*
     * Terkadang Anda mungkin ingin membaca input byte ke dalam sebuah String. Untuk
     * melakukan ini, Anda perlu menemukan sesuatu yang mengkonversi antara byte dan
     * Codepoint UTF-16 "Jawa asli" yang digunakan sebagai char. Itu dilakukan
     * dengan InputStreamReader.
     * 
     * Untuk sedikit mempercepat proses, "biasa" mengalokasikan buffer, sehingga
     * kita tidak memiliki terlalu banyak overhead saat membaca dari Input.
     */

    /*
     * Version ≥ Java SE 7
     * public String inputStreamToString(InputStream inputStream) throws Exception {
     * StringWriter writer = new StringWriter();
     * char[] buffer = new char[1024];
     * try (Reader reader = new BufferedReader(new InputStreamReader(inputStream,
     * "UTF-8"))) {
     * int n;
     * while ((n = reader.read(buffer)) != -1) {
     * // all this code does is redirect the output of `reader` to `writer` in
     * // 1024 byte chunks
     * writer.write(buffer, 0, n);
     * }
     * }
     * return writer.toString();
     * }
     */

    //

    public static void main(String[] args) {
        String file = "outfilename";
        try {
            // Gantilah path dengan lokasi file atau sumber InputStream Anda
            InputStream inputStream = new FileInputStream(file);
            String result = inputStreamToString(inputStream);
            System.out.println("Hasil konversi InputStream ke String:\n" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * output:
         * Hasil konversi InputStream ke String:
         * the text
         * more text
         */

    }

    public static String inputStreamToString(InputStream inputStream) throws Exception {
        StringWriter writer = new StringWriter();
        char[] buffer = new char[1024];
        try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            int n;
            while ((n = reader.read(buffer)) != -1) {
                // Semua yang dilakukan oleh kode ini adalah mengarahkan keluaran `reader` ke
                // `writer` dalam
                // potongan 1024 byte
                writer.write(buffer, 0, n);
            }
        }
        return writer.toString();
    }

}
