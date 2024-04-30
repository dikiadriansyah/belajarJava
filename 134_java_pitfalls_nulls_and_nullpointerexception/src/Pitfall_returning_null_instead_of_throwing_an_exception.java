import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Pitfall_returning_null_instead_of_throwing_an_exception {
    // Pitfall - Returning null instead of throwing an exception/Kesalahan -
    // Mengembalikan null alih-alih memberikan pengecualian

    /*
     * Beberapa pemrogram Java umumnya tidak suka melemparkan atau menyebarkan
     * pengecualian. Ini mengarah ke kode seperti berikut:
     * 
     * public Reader getReader(String pathname) {
     * try {
     * return new BufferedReader(FileReader(pathname));
     * } catch (IOException ex) {
     * System.out.println("Open failed: " + ex.getMessage());
     * return null;
     * }
     * }
     */

    /*
     * Jadi apa masalahnya dengan itu?
     * Masalahnya adalah getReader mengembalikan null sebagai nilai khusus untuk
     * menunjukkan bahwa Reader tidak dapat dibuka. Sekarang nilai yang dikembalikan
     * perlu diuji untuk melihat apakah nilainya nol sebelum digunakan. Jika
     * pengujian diabaikan, hasilnya adalah NullPointerException.
     */

    /*
     * Sebenarnya ada tiga masalah di sini:
     * 1. IOException tertangkap terlalu cepat.
     * 2. Struktur kode ini berarti ada risiko kebocoran sumber daya.
     * 3. Sebuah null digunakan kemudian dikembalikan karena tidak ada Reader
     * "asli" yang tersedia untuk dikembalikan.
     */

    /*
     * Faktanya, dengan asumsi bahwa pengecualian memang perlu diketahui lebih awal
     * seperti ini, ada beberapa alternatif untuk mengembalikan null:
     * 1. Dimungkinkan untuk mengimplementasikan kelas NullReader; misalnya di mana
     * operasi API berperilaku seolah-olah pembaca sudah berada pada posisi
     * "akhir file".
     * 2. Dengan Java 8, dimungkinkan untuk mendeklarasikan getReader sebagai
     * mengembalikan Optional<Reader>.
     */

    public static void main(String[] args) throws Exception {
        String filePath = "file.txt"; // Ganti dengan path file yang sesuai
        Pitfall_returning_null_instead_of_throwing_an_exception main = new Pitfall_returning_null_instead_of_throwing_an_exception();
        Reader reader = main.getReader(filePath);
        if (reader != null) {
            try {
                int character;
                while ((character = reader.read()) != -1) {
                    System.out.print((char) character);
                }
                reader.close();
            } catch (IOException ex) {
                System.out.println("Error reading file: " + ex.getMessage());
            }
        }
    }

    public Reader getReader(String pathname) {
        try {
            return new BufferedReader(new FileReader(pathname));
        } catch (IOException ex) {
            System.out.println("Open failed: " + ex.getMessage());
            return null;
        }
    }

}
