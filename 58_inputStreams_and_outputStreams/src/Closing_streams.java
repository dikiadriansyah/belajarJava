import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Closing_streams {
    // Closing Streams/Menutup Aliran

    /*
     * Sebagian besar aliran harus ditutup setelah Anda selesai menggunakannya, jika
     * tidak, Anda dapat menyebabkan kebocoran memori atau membiarkan file terbuka.
     * Penting agar aliran ditutup meskipun ada pengecualian.
     */

    /*
     * Version ≥ Java SE 7
     * try(FileWriter fw = new FileWriter("outfilename");
     * BufferedWriter bw = new BufferedWriter(fw);
     * PrintWriter out = new PrintWriter(bw))
     * {
     * out.println("the text");
     * //more code
     * out.println("more text");
     * //more code
     * } catch (IOException e) {
     * //handle this however you
     * }
     */

    /*
     * Ingat: jaminan try-with-resources, bahwa sumber daya telah ditutup ketika
     * blok keluar, baik itu terjadi dengan aliran kontrol biasa atau karena
     * pengecualian.
     * 
     * Versi ≤ Java SE 6
     * 
     * Terkadang, coba-dengan-sumber daya bukanlah suatu pilihan, atau mungkin Anda
     * mendukung Java 6 versi lama atau lebih lama. Dalam hal ini, penanganan yang
     * tepat adalah dengan menggunakan blok finally:
     * 
     * FileWriter fw = null;
     * BufferedWriter bw = null;
     * PrintWriter out = null;
     * try {
     * fw = new FileWriter("myfile.txt");
     * bw = new BufferedWriter(fw);
     * out = new PrintWriter(bw);
     * out.println("the text");
     * out.close();
     * } catch (IOException e) {
     * //handle this however you want
     * }
     * finally {
     * try {
     * if(out != null)
     * out.close();
     * } catch (IOException e) {
     * //typically not much you can do here...
     * }
     * }
     */

    /*
     * Perhatikan bahwa menutup aliran pembungkus juga akan menutup aliran yang
     * mendasarinya. Ini berarti Anda tidak dapat membungkus aliran,
     * tutup pembungkusnya lalu lanjutkan menggunakan aliran asli.
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        // ----------------

        // Menggunakan try-with-resources untuk otomatis menutup sumber daya setelah
        // selesai
        try (FileWriter fw = new FileWriter("outfilename");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {

            // Menulis teks ke dalam file
            out.println("the text");
            // More code
            out.println("more text");
            // More code

            System.out.println("Data berhasil ditulis ke dalam file.");

        } catch (IOException e) {
            // Menangani exception jika terjadi kesalahan saat menulis ke file
            e.printStackTrace();
        }
    }
}
