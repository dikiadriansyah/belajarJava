import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Pitfall_ignoring_or_squashing_exceptions {
    // Pitfall - Ignoring or squashing exceptions/Jebakan - Mengabaikan atau
    // menghilangkan pengecualian

    /*
     * Contoh ini adalah tentang sengaja mengabaikan atau "squashing"
     * pengecualian. Atau lebih tepatnya, ini tentang bagaimana caranya
     * menangkap dan menangani pengecualian dengan cara mengabaikannya. Namun,
     * sebelum kami menjelaskan cara melakukan hal ini, pertama-tama kami harus
     * menunjukkan bahwa menghilangkan pengecualian pada umumnya bukanlah cara yang
     * tepat untuk menanganinya.
     * 
     * Pengecualian biasanya diberikan (oleh sesuatu) untuk memberi tahu bagian lain
     * dari program bahwa ada beberapa hal penting (mis.
     * peristiwa "exceptional") telah terjadi. Secara umum (meskipun tidak selalu)
     * pengecualian berarti ada sesuatu yang hilang
     * salah. Jika Anda mengkodekan program Anda untuk menghilangkan pengecualian,
     * ada kemungkinan besar masalah akan muncul kembali dalam bentuk lain. Lebih
     * buruk lagi, ketika Anda menghentikan pengecualian, Anda membuang informasi
     * dalam objek pengecualian dan pelacakan tumpukan terkait. Hal ini mungkin akan
     * mempersulit pencarian sumber asli masalahnya.
     * 
     * Dalam prakteknya, pengecualian squashing sering terjadi ketika Anda
     * menggunakan fitur koreksi otomatis IDE untuk "fix" kesalahan
     * kompilasi yang disebabkan oleh pengecualian yang tidak tertangani. Misalnya,
     * Anda mungkin melihat kode seperti ini:
     * 
     * try {
     * inputStream = new FileInputStream("someFile");
     * } catch (IOException e) {
     * //add exception handling code here
     * }
     * 
     */

    /*
     * Jelasnya, pemrogram telah menerima saran IDE untuk menghilangkan kesalahan
     * kompilasi, tetapi saran tersebut tidak tepat. (Jika pembukaan file gagal,
     * kemungkinan besar program harus melakukan sesuatu.
     * Dengan "correction" di atas, program ini kemungkinan besar akan gagal di
     * kemudian hari; misalnya dengan NullPointerException karena
     * inputStream sekarang null.)
     * 
     * Karena itu, berikut adalah contoh penghapusan pengecualian dengan sengaja.
     * (Untuk keperluan argumen, asumsikan bahwa kami telah menentukan bahwa
     * interupsi saat menunjukkan selfie tidak berbahaya.) Komentar tersebut memberi
     * tahu pembaca bahwa kami sengaja menghilangkan pengecualian tersebut, dan
     * mengapa kami melakukan itu.
     */

    /*
     * try {
     * selfie.show();
     * } catch (InterruptedException e) {
     * // It doesn't matter if showing the selfie is interrupted.
     * }
     */

    /*
     * Cara konvensional lain untuk menyoroti bahwa kita sengaja menghapus
     * pengecualian tanpa menyebutkan alasannya adalah dengan menunjukkan hal ini
     * dengan nama variabel pengecualian, seperti ini:
     * 
     * try {
     * selfie.show();
     * } catch (InterruptedException ignored) { }
     */

    /*
     * Beberapa IDE (seperti IntelliJ IDEA) tidak akan menampilkan peringatan
     * tentang blok tangkapan kosong jika nama variabel disetel ke diabaikan.
     */

    public static void main(String[] args) throws Exception {

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("file.txt");
            // Lakukan operasi lain menggunakan inputStream
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            // Penanganan eksepsi jika terjadi IOException
            e.printStackTrace(); // Contoh penanganan sederhana, bisa diganti dengan log, pesan kesalahan, atau
                                 // tindakan lainnya
        } finally {
            // Pastikan untuk menutup inputStream jika dibuka
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace(); // Penanganan eksepsi jika gagal menutup inputStream
            }
        }
        /*
         * output:
         * Hello, World!
         */

    }
}
