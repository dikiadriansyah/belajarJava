import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Pitfall_testing_a_file_before_attempting_to_open_it {
    // Pitfall: testing a file before attempting to open it/Kesalahan: menguji file
    // sebelum mencoba membukanya

    /*
     * Beberapa orang menyarankan agar Anda menerapkan berbagai tes pada file
     * sebelum mencoba membukanya untuk memberikan diagnostik yang lebih baik atau
     * menghindari penanganan pengecualian. Misalnya, metode ini mencoba memeriksa
     * apakah jalurnya sesuai dengan file yang dapat dibaca:
     * 
     * public static File getValidatedFile(String path) throws IOException {
     * File f = new File(path);
     * if (!f.exists()) throw new IOException("Error: not found: " + path);
     * if (!f.isFile()) throw new IOException("Error: Is a directory: " + path);
     * if (!f.canRead()) throw new IOException("Error: cannot read file: " + path);
     * return f;
     * }
     * 
     */

    // Anda mungkin menggunakan metode di atas seperti ini:

    /*
     * File f = null;
     * try {
     * f = getValidatedFile("somefile");
     * } catch (IOException ex) {
     * System.err.println(ex.getMessage());
     * return;
     * }
     * try (InputStream is = new FileInputStream(file)) {
     * // Read data etc.
     * }
     */

    /*
     * Masalah pertama ada pada tanda tangan untuk FileInputStream(File) karena
     * kompiler masih bersikeras agar kita catch IOException di sini, atau lebih
     * jauh lagi tumpukannya.
     */

    /*
     * Masalah kedua adalah pemeriksaan yang dilakukan oleh getValidatedFile tidak
     * menjamin bahwa FileInputStream
     * akan sukses.
     * 1. Kondisi balapan: thread lain atau proses terpisah dapat mengganti nama
     * file, menghapus file, atau menghapus yang sudah dibaca
     * akses setelah getValidatedFile kembali. Itu akan menghasilkan IOException
     * "plain" tanpa pesan khusus.
     * 2. Ada kasus-kasus ekstrem yang tidak tercakup dalam pengujian tersebut.
     * Misalnya, pada sistem dengan SELinux dalam mode "menegakkan",
     * upaya untuk membaca file bisa gagal meskipun canRead() mengembalikan nilai
     * true.
     */

    /*
     * Masalah ketiga adalah tes tersebut tidak efisien. Misalnya, exists,
     * isFile dan canRead masing-masing akan dilakukan
     * syscall untuk melakukan pemeriksaan yang diperlukan. Syscall lain kemudian
     * dibuat untuk membuka file, yang mengulangi pemeriksaan yang sama di belakang
     * layar.
     * 
     * Singkatnya, metode seperti getValidatedFile salah arah. Lebih baik mencoba
     * membuka file dan menangani pengecualian:
     * 
     * try (InputStream is = new FileInputStream("somefile")) {
     * // Read data etc.
     * } catch (IOException ex) {
     * System.err.println("IO Error processing 'somefile': " + ex.getMessage());
     * return;
     * }
     */

    // --------------------------
    public static File getValidatedFile(String path) throws IOException {
        File f = new File(path);
        if (!f.exists())
            throw new IOException("Error: not found: " + path);
        if (!f.isFile())
            throw new IOException("Error: Is a directory: " + path);
        if (!f.canRead())
            throw new IOException("Error: cannot read file: " + path);
        return f;
    }

    public static void main(String[] args) {
        File file = null;
        try {
            file = getValidatedFile("file.txt"); // Ganti "somefile.txt" dengan nama file yang benar
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return;
        }

        try (InputStream is = new FileInputStream(file)) {
            byte[] data = is.readAllBytes();
            // Read data etc.
            // Di sini Anda dapat menambahkan kode untuk membaca data dari file
            // Contoh: byte[] data = is.readAllBytes();
            // Anda dapat menangani data yang telah dibaca sesuai kebutuhan aplikasi Anda
            System.out.println("File content:");
            System.out.println(new String(data)); // Mengonversi byte menjadi String dan mencetaknya
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        /*
         * output:
         * File content:
         * Hello, World!
         */

    }
}
