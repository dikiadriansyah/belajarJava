import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Copying_a_file_using_channel {
    // Copying a file using Channel/Menyalin file menggunakan Channel

    /*
     * Kita dapat menggunakan Channel untuk menyalin konten file lebih cepat. Untuk
     * melakukannya, kita dapat menggunakan metode transferTo() dari FileChannel .
     */

    /*
     * import java.io.File;
     * import java.io.FileInputStream;
     * import java.io.FileOutputStream;
     * import java.io.IOException;
     * import java.nio.channels.FileChannel;
     * public class FileCopier {
     * 
     * public static void main(String[] args) {
     * File sourceFile = new File("hello.txt");
     * File sinkFile = new File("hello2.txt");
     * copy(sourceFile, sinkFile);
     * }
     * public static void copy(File sourceFile, File destFile) {
     * if (!sourceFile.exists() || !destFile.exists()) {
     * System.out.println("Source or destination file doesn't exist");
     * return;
     * }
     * try (FileChannel srcChannel = new FileInputStream(sourceFile).getChannel();
     * FileChannel sinkChanel = new FileOutputStream(destFile).getChannel()) {
     * srcChannel.transferTo(0, srcChannel.size(), sinkChanel);
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * 
     */

    public static void main(String[] args) {
        File sourceFile = new File("hello.txt");
        File sinkFile = new File("hello2.txt");
        copy(sourceFile, sinkFile);
        /*
         * output:
         * Sumber file berhasil di salin
         */
    }

    public static void copy(File sourceFile, File destFile) {
        if (!sourceFile.exists() || !destFile.exists()) {
            System.out.println("Source or destination file doesn't exist");
            return;
        } else {
            System.out.println("Sumber file berhasil di salin");

        }

        try (FileChannel srcChannel = new FileInputStream(sourceFile).getChannel();
                FileChannel sinkChanel = new FileOutputStream(destFile).getChannel()) {
            srcChannel.transferTo(0, srcChannel.size(), sinkChanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
