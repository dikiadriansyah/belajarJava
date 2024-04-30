import java.io.*;

public class Stream_vs_writer_reader_api {
    // Stream vs Writer/Reader API / Aliran vs API Penulis/Pembaca

    /*
     * Aliran memberikan akses paling langsung ke konten biner, sehingga setiap
     * implementasi InputStream/OutputStream selalu beroperasi pada int dan byte
     */

    /*
     * // Read a single byte from the stream
     * int b = inputStream.read();
     * if (b >= 0) { // A negative value represents the end of the stream, normal
     * values are in the range 0
     * - 255
     * // Write the byte to another stream
     * outputStream.write(b);
     * }
     * // Read a chunk
     * byte[] data = new byte[1024];
     * int nBytesRead = inputStream.read(data);
     * if (nBytesRead >= 0) { // A negative value represents end of stream
     * // Write the chunk to another stream
     * outputStream.write(data, 0, nBytesRead);
     * }
     */

    /*
     * Ada beberapa pengecualian, mungkin yang paling terkenal adalah PrintStream
     * yang menambahkan
     * "kemampuan untuk mencetak representasi berbagai nilai data dengan mudah". Hal
     * ini memungkinkan untuk menggunakan System.out baik sebagai InputStream biner
     * dan sebagai output tekstual menggunakan metode seperti System.out.println().
     * 
     * Selain itu, beberapa implementasi aliran berfungsi sebagai antarmuka ke
     * konten tingkat tinggi seperti objek Java (lihat Serialisasi) atau tipe asli,
     * misalnya. DataOutputStream / DataInputStream.
     * 
     * Dengan kelas Writer dan Reader, Java juga menyediakan API untuk aliran
     * karakter eksplisit. Meskipun sebagian besar aplikasi akan mendasarkan
     * implementasi ini pada aliran, API aliran karakter tidak memaparkan metode apa
     * pun untuk konten biner.
     */

    /*
     * // This example uses the platform's default charset, see below
     * // for a better implementation.
     * Writer writer = new OutputStreamWriter(System.out);
     * writer.write("Hello world!");
     * Reader reader = new InputStreamReader(System.in);
     * char singleCharacter = reader.read();
     */

    /*
     * Kapan pun diperlukan untuk menyandikan karakter ke dalam data biner (misalnya
     * saat menggunakan InputStreamWriter /
     * Kelas OutputStreamWriter), Anda harus menentukan rangkaian karakter jika Anda
     * tidak ingin bergantung pada rangkaian karakter default platform. Jika ragu,
     * gunakan pengkodean yang kompatibel dengan Unicode, mis. UTF-8 yang didukung
     * di semua platform Java.
     * Oleh karena itu, Anda mungkin harus menjauhi kelas seperti FileWriter dan
     * FileReader karena kelas tersebut selalu menggunakan
     * rangkaian karakter platform default. Cara yang lebih baik untuk mengakses
     * file menggunakan aliran karakter adalah ini:
     */

    /*
     * Charset myCharset = StandardCharsets.UTF_8;
     * Writer writer = new OutputStreamWriter( new FileOutputStream("test.txt"),
     * myCharset );
     * writer.write('Ä');
     * writer.flush();
     * writer.close();
     * Reader reader = new InputStreamReader( new FileInputStream("test.txt"),
     * myCharset );
     * char someUnicodeCharacter = reader.read();
     * reader.close();
     * 
     */

    /*
     * Salah satu Reader yang paling umum digunakan adalah BufferedReader yang
     * menyediakan metode untuk membaca seluruh baris teks dari pembaca lain dan
     * mungkin merupakan cara paling sederhana untuk membaca aliran karakter baris
     * demi baris:
     * 
     * // Read from baseReader, one line at a time
     * BufferedReader reader = new BufferedReader( baseReader );
     * String line;
     * while((line = reader.readLine()) != null) {
     * // Remember: System.out is a stream, not a writer!
     * System.out.println(line);
     * }
     */

    public static void main(String[] args) {
        // try {
        // // Contoh membaca satu byte dari stream
        // FileInputStream inputStream = new FileInputStream("input.txt");
        // FileOutputStream outputStream = new FileOutputStream("output.txt");

        // int b = inputStream.read();
        // if (b >= 0) {
        // // Nilai negatif menandakan akhir stream, nilai normal berada dalam rentang
        // // 0-255
        // // Menulis byte ke stream lain
        // outputStream.write(b);
        // }

        // // Contoh membaca sekelompok byte (chunk)
        // byte[] data = new byte[1024];
        // int nBytesRead = inputStream.read(data);
        // if (nBytesRead >= 0) {
        // // Nilai negatif menandakan akhir stream
        // // Menulis sekelompok byte ke stream lain
        // outputStream.write(data, 0, nBytesRead);
        // }

        // // Tutup stream
        // inputStream.close();
        // outputStream.close();

        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // ------------------------
        // try {
        // // Menentukan charset sebagai UTF-8
        // java.nio.charset.Charset myCharset = java.nio.charset.StandardCharsets.UTF_8;

        // // Menulis karakter 'Ä' ke dalam file "test.txt"
        // Writer writer = new OutputStreamWriter(new FileOutputStream("test.txt"),
        // myCharset);
        // writer.write('Ä');
        // writer.flush();
        // writer.close();

        // // Membaca karakter dari file "test.txt" menggunakan charset yang sama
        // Reader reader = new InputStreamReader(new FileInputStream("test.txt"),
        // myCharset);
        // char someUnicodeCharacter = (char) reader.read();
        // reader.close();

        // // Menampilkan karakter yang dibaca
        // System.out.println("Karakter yang dibaca: " + someUnicodeCharacter);

        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        /*
         * output:
         * Karakter yang dibaca: Ä
         */
        // --------------------
        // Ganti path dengan path file yang ingin Anda baca
        // String filePath = "file.txt";
        // try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        // String line;
        // while ((line = reader.readLine()) != null) {
        // // Remember: System.out is a stream, not a writer!
        // System.out.println(line);
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        /*
         * output:
         * Hello, World!
         */
        // --------------------------

    }
}
