import java.io.IOException;
import java.io.OutputStream;

public class Writing_bytes_to_an_outputstream {
    // Writing bytes to an OutputStream/Menulis byte ke OutputStream

    // Menulis byte ke OutputStream satu byte dalam satu waktu

    /*
     * OutputStream stream = object.getOutputStream();
     * byte b = 0x00;
     * stream.write( b );
     */

    // Menulis array byte

    /*
     * byte[] bytes = new byte[] { 0x00, 0x00 };
     * stream.write( bytes );
     */

    // Menulis bagian dari array byte

    /*
     * int offset = 1;
     * int length = 2;
     * byte[] bytes = new byte[] { 0xFF, 0x00, 0x00, 0xFF };
     * stream.write( bytes, offset, length );
     */

    public static void main(String[] args) throws IOException {
        // Menggantikan "object" dengan objek yang sesuai (seperti FileOutputStream)
        // yang telah diinisialisasi sebelumnya.
        OutputStream stream = getInitializedOutputStream();

        try {
            byte b = 0x00;
            stream.write(b);
            System.out.println("Byte has been written to the OutputStream.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Tutup OutputStream setelah digunakan.
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*
         * output:
         * Byte has been written to the OutputStream.
         */

    }

    // Metode ini bisa digantikan dengan inisialisasi objek OutputStream yang
    // sesuai.
    private static OutputStream getInitializedOutputStream() {
        // Misalnya, kita menggunakan FileOutputStream untuk menulis ke file.
        // Anda dapat menggantinya dengan jenis OutputStream yang sesuai dengan
        // kebutuhan Anda.
        // Perhatikan bahwa ini hanya contoh sederhana dan Anda perlu menangani
        // IOException dengan benar.
        try {
            return new java.io.FileOutputStream("output.txt");
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
