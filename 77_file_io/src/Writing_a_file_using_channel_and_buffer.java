import java.io.*;
import java.nio.*;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Writing_a_file_using_channel_and_buffer {
    // Writing a file using Channel and Buffer/Menulis file menggunakan Channel dan
    // Buffer

    // Untuk menulis data ke file menggunakan Channel kita perlu melakukan
    // langkah-langkah berikut
    /*
     * 1. Pertama, kita perlu mendapatkan objek FileOutputStream
     * 2. Dapatkan FileChannel yang memanggil metode getChannel() dari
     * FileOutputStream
     * 3. Buat ByteBuffer lalu isi dengan data
     * 4. Kemudian kita harus memanggil metode flip() dari ByteBuffer dan
     * meneruskannya sebagai argumen dari write() metode FileChannel
     * 5. Setelah kita selesai menulis, kita harus menutup sumber dayanya
     */

    /*
     * import java.io.*;
     * import java.nio.*;
     * public class FileChannelWrite {
     * public static void main(String[] args) {
     * File outputFile = new File("hello.txt");
     * String text = "I love Bangladesh.";
     * try {
     * FileOutputStream fos = new FileOutputStream(outputFile);
     * FileChannel fileChannel = fos.getChannel();
     * byte[] bytes = text.getBytes();
     * ByteBuffer buffer = ByteBuffer.wrap(bytes);
     * fileChannel.write(buffer);
     * fileChannel.close();
     * } catch (java.io.IOException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    public static void main(String[] args) {
        File outputFile = new File("hello.txt");
        String text = "I love Bangladesh.";

        try {
            FileOutputStream fos = new FileOutputStream(outputFile);
            FileChannel fileChannel = fos.getChannel();
            byte[] bytes = text.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            fileChannel.write(buffer);
            fileChannel.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
