import java.io.FileOutputStream;
import java.io.IOException;

public class Pitfall_not_checking_if_an_io_stream_isnt_even_initialized_when_closing_it {
    // Pitfall - Not checking if an I/O stream isn't even initialized when closing
    // it / Kesalahan - Tidak memeriksa apakah aliran I/O bahkan tidak
    // diinisialisasi saat menutupnya

    /*
     * Untuk mencegah kebocoran memori, jangan lupa untuk menutup aliran masukan
     * atau aliran keluaran yang tugasnya telah selesai.
     * Hal ini biasanya dilakukan dengan pernyataan try-catch-finally tanpa bagian
     * catch:
     * 
     * void writeNullBytesToAFile(int count, String filename) throws IOException {
     * FileOutputStream out = null;
     * try {
     * out = new FileOutputStream(filename);
     * for(; count > 0; count--)
     * out.write(0);
     * } finally {
     * out.close();
     * }
     * }
     * 
     */

    /*
     * Meskipun kode di atas mungkin terlihat tidak berbahaya, kode ini memiliki
     * cacat yang membuat proses debug menjadi tidak mungkin dilakukan. Jika garis
     * keluarnya initialized(out = new FileOutputStream(filename))
     * memunculkan pengecualian, maka keluar akan menjadi null ketika out.close()
     * dijalankan, menghasilkan NullPointerException yang buruk!
     * 
     * Untuk mencegah hal ini, cukup pastikan alirannya tidak null sebelum mencoba
     * menutupnya.
     * 
     * void writeNullBytesToAFile(int count, String filename) throws IOException {
     * FileOutputStream out = null;
     * try {
     * out = new FileOutputStream(filename);
     * for(; count > 0; count--)
     * out.write(0);
     * } finally {
     * if (out != null)
     * out.close();
     * }
     * }
     */

    /*
     * Pendekatan yang lebih baik lagi adalah dengan try-with-resources,
     * karena secara otomatis akan menutup aliran dengan probabilitas 0 hingga
     * melempar NPE tanpa memerlukan blok finally.
     * 
     * void writeNullBytesToAFile(int count, String filename) throws IOException {
     * try (FileOutputStream out = new FileOutputStream(filename)) {
     * for(; count > 0; count--)
     * out.write(0);
     * }
     * }
     */
    // -----------------------
    // void writeNullBytesToAFile(int count, String filename) throws IOException {
    // FileOutputStream out = null;
    // try {
    // out = new FileOutputStream(filename);
    // for (; count > 0; count--)
    // out.write(0);
    // } finally {
    // if (out != null) {
    // out.close();
    // }
    // }
    // }
    // ---------------------
    void writeNullBytesToAFile(int count, String filename) throws IOException {
        try (FileOutputStream out = new FileOutputStream(filename)) {
            for (; count > 0; count--)
                out.write(0);
        }
    }

    public static void main(String[] args) throws Exception {
        Pitfall_not_checking_if_an_io_stream_isnt_even_initialized_when_closing_it box = new Pitfall_not_checking_if_an_io_stream_isnt_even_initialized_when_closing_it();
        try {
            box.writeNullBytesToAFile(10, "file.txt");
            System.out.println("Null bytes have been written to the file successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing null bytes to the file: " + e.getMessage());
        }

        /*
         * output:
         * Null bytes have been written to the file successfully.
         */

    }
}
