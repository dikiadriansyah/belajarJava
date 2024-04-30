import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Reading_a_file_using_channel_and_buffer {
    // Reading a file using Channel and Buffer/ Membaca file menggunakan Channel dan
    // Buffer

    // Saluran menggunakan Buffer untuk membaca/menulis data. Buffer adalah wadah
    // berukuran tetap tempat kita dapat menulis satu blok data sekaligus. Saluran
    // lebih cepat dibandingkan I/O berbasis aliran.

    // Untuk membaca data dari file menggunakan Channel kita perlu melakukan
    // langkah-langkah berikut
    /*
     * 1. Kita memerlukan sebuah instance dari FileInputStream.
     * FileInputStreammemiliki metode bernama getChannel() yang mengembalikan
     * Saluran.
     * 2. Panggil metode getChannel() pada FileInputStream dan dapatkan Channel.
     * 3. Buat ByteBuffer. ByteBuffer adalah wadah byte berukuran tetap.
     * 4. Channel mempunyai metode baca dan kita harus menyediakan ByteBuffer
     * sebagai argumen untuk metode baca ini.
     * ByteBuffer memiliki dua mode - mood read-only dan mood write-only. Kita dapat
     * mengubah mode menggunakan pemanggilan metode flip(). Buffer mempunyai posisi,
     * limit, dan kapasitas. Setelah buffer dibuat dengan ukuran tetap, batasnya dan
     * kapasitasnya sama besarnya dan posisinya dimulai dari nol. Saat buffer
     * ditulis dengan data, posisinya secara bertahap meningkat. Mengubah mode
     * artinya, mengubah posisi. Untuk membaca data dari awal buffer, kita harus
     * mengatur posisinya ke nol. flip() metode mengubah posisi
     * 5. Ketika kita memanggil metode baca channel, itu mengisi buffer menggunakan
     * data
     * 6. Jika kita perlu membaca data dari ByteBuffer, kita perlu membalik buffer
     * untuk mengubah modenya menjadi write-only ke mode read-only dan kemudian
     * terus membaca data dari buffer.
     * 7. Ketika tidak ada lagi data untuk dibaca, metode read() saluran
     * mengembalikan 0 atau -1.
     * 
     */

    /*
     * import java.io.File;
     * import java.io.FileInputStream;
     * import java.io.IOException;
     * import java.nio.ByteBuffer;
     * import java.nio.channels.FileChannel;
     * public class FileChannelRead {
     * public static void main(String[] args) {
     * File inputFile = new File("hello.txt");
     * if (!inputFile.exists()) {
     * System.out.println("The input file doesn't exit.");
     * return;
     * }
     * try {
     * FileInputStream fis = new FileInputStream(inputFile);
     * FileChannel fileChannel = fis.getChannel();
     * ByteBuffer buffer = ByteBuffer.allocate(1024);
     * while (fileChannel.read(buffer) > 0) {
     * buffer.flip();
     * while (buffer.hasRemaining()) {
     * byte b = buffer.get();
     * System.out.print((char) b);
     * }
     * buffer.clear();
     * }
     * fileChannel.close();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        File inputFile = new File("hello.txt");
        if (!inputFile.exists()) {
            System.out.println("The input file doesn't exit.");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(inputFile);
            FileChannel fileChannel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                buffer.clear();
            }
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * output:
         * Hello world!
         */

    }
}
