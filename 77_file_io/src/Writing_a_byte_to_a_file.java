import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writing_a_byte_to_a_file {
    // Writing a byte[] to a file/Menulis byte[] ke file

    /*
     * Version ≥ Java SE 7
     * byte[] bytes = { 0x48, 0x65, 0x6c, 0x6c, 0x6f };
     * try(FileOutputStream stream = new FileOutputStream("Hello world.txt")) {
     * stream.write(bytes);
     * } catch (IOException ioe) {
     * // Handle I/O Exception
     * ioe.printStackTrace();
     * }
     * Version < Java SE 7
     * byte[] bytes = { 0x48, 0x65, 0x6c, 0x6c, 0x6f };
     * FileOutputStream stream = null;
     * try {
     * stream = new FileOutputStream("Hello world.txt");
     * stream.write(bytes);
     * } catch (IOException ioe) {
     * // Handle I/O Exception
     * ioe.printStackTrace();
     * } finally {
     * if (stream != null) {
     * try {
     * stream.close();
     * } catch (IOException ignored) {}
     * }
     * }
     * 
     * 
     */
    // Sebagian besar API file java.io menerima String dan File sebagai argumen,
    // jadi Anda juga bisa menggunakannya

    /*
     * File file = new File("Hello world.txt");
     * FileOutputStream stream = new FileOutputStream(file);
     */

    public static void main(String[] args) {
        // byte[] bytes = { 0x48, 0x65, 0x6c, 0x6c, 0x6f };
        // try (FileOutputStream stream = new FileOutputStream("Hello world.txt")) {
        // stream.write(bytes);
        // System.out.println("Data has been written to the file.");
        // } catch (IOException ioe) {
        // // Handle I/O Exception
        // ioe.printStackTrace();
        // }
        /*
         * output:
         * Data has been written to the file.
         */
        // -------------------
        // byte[] bytes = { 0x48, 0x65, 0x6c, 0x6c, 0x6f };
        // FileOutputStream stream = null;
        // try {
        // stream = new FileOutputStream("Hello world.txt");
        // stream.write(bytes);
        // System.out.println("Bytes written to file successfully!");
        // } catch (IOException ioe) {
        // // Handle I/O Exception
        // ioe.printStackTrace();
        // } finally {
        // if (stream != null) {
        // try {
        // stream.close();
        // } catch (IOException ignored) {
        // }
        // }
        // }
        /*
         * output:
         * Bytes written to file successfully!
         */
        // ------------------------------------
        // Nama file yang akan dibuat
        String fileName = "Hello world.txt";
        File file = new File(fileName);

        try {
            FileOutputStream stream = new FileOutputStream(file);
            // Data yang akan ditulis ke file
            String data = "Hello, World!";

            // Mengubah string menjadi byte array
            byte[] byteArray = data.getBytes();

            // Menulis data ke file
            stream.write(byteArray);

            // Menutup stream setelah selesai
            stream.close();

            System.out.println("File berhasil dibuat: " + fileName);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
        /*
         * outputt:
         * File berhasil dibuat: Hello world.txt
         */

    }
}
