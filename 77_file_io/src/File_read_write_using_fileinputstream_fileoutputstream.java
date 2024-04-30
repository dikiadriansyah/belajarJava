import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File_read_write_using_fileinputstream_fileoutputstream {
    // File Baca/Tulis Menggunakan FileInputStream/FileOutputStream

    // Tulis ke file test.txt:
    /*
     * String filepath ="C:\\test.txt";
     * FileOutputStream fos = null;
     * try {
     * fos = new FileOutputStream(filepath);
     * byte[] buffer = "This will be written in test.txt".getBytes();
     * fos.write(buffer, 0, buffer.length);
     * fos.close();
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * } catch (IOException e) {
     * e.printStackTrace();
     * } finally{
     * if(fos != null)
     * fos.close();
     * }
     */

    // Baca dari file test.txt:
    /*
     * String filepath ="C:\\test.txt";
     * FileInputStream fis = null;
     * try {
     * fis = new FileInputStream(filepath);
     * int length = (int) new File(filepath).length();
     * byte[] buffer = new byte[length];
     * fis.read(buffer, 0, length);
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * } catch (IOException e) {
     * e.printStackTrace();
     * } finally{
     * if(fis != null)
     * fis.close();
     * }
     * 
     */

    /*
     * Perhatikan, bahwa sejak Java 1.7 pernyataan coba-dengan-sumber daya
     * diperkenalkan yang membuat implementasi operasi membaca\menulis lebih
     * sederhana:
     */

    // Tulis ke file test.txt:
    /*
     * String filepath ="C:\\test.txt";
     * try (FileOutputStream fos = new FileOutputStream(filepath)){
     * byte[] buffer = "This will be written in test.txt".getBytes();
     * fos.write(buffer, 0, buffer.length);
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     */

    // Baca dari file test.txt
    /*
     * String filepath ="C:\\test.txt";
     * try (FileInputStream fis = new FileInputStream(filepath)){
     * int length = (int) new File(filepath).length();
     * byte[] buffer = new byte[length];
     * fis.read(buffer, 0, length);
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     */

    public static void main(String[] args) {
        // String filepath = "D:\\test.txt";
        // FileOutputStream fos = null;
        // try {
        // fos = new FileOutputStream(filepath);
        // byte[] buffer = "This will be written in test.txt".getBytes();
        // fos.write(buffer, 0, buffer.length);
        // System.out.println("Data has been written to " + filepath);
        // fos.close();

        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // } finally {
        // try {
        // if (fos != null)
        // fos.close();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // }

        /*
         * output:
         * Data has been written to D:\test.txt
         */
        // ----------------------------
        // String filepath = "D:\\test.txt";
        // FileInputStream fis = null;
        // try {
        // fis = new FileInputStream(filepath);
        // int length = (int) new File(filepath).length();
        // byte[] buffer = new byte[length];
        // fis.read(buffer, 0, length);
        // String content = new String(buffer);
        // System.out.println("Content of " + filepath + ":\n" + content);
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // } finally {
        // try {
        // if (fis != null)
        // fis.close();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // }
        /*
         * output:
         * Content of D:\test.txt:
         * This will be written in test.txt
         */
        // -------------------------------
        // String filepath = "D:\\test.txt";
        // try (FileOutputStream fos = new FileOutputStream(filepath)) {
        // byte[] buffer = "This will be written in test.txt".getBytes();
        // fos.write(buffer, 0, buffer.length);
        // System.out.println("Data has been written to " + filepath);
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        /*
         * output:
         * Data has been written to D:\test.txt
         */
        // ---------------------------------
        String filepath = "D:\\test.txt";
        try (FileInputStream fis = new FileInputStream(filepath)) {
            int length = (int) new File(filepath).length();
            byte[] buffer = new byte[length];
            fis.read(buffer, 0, length);

            String content = new String(buffer);
            System.out.println("Content of " + filepath + ":\n" + content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Content of D:\test.txt:
         * This will be written in test.txt
         */

    }
}
