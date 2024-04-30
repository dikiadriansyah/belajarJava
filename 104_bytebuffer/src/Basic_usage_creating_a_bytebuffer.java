import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Basic_usage_creating_a_bytebuffer {
    // Basic Usage - Creating a ByteBuffer/ Penggunaan Dasar - Membuat ByteBuffer

    /*
     * Ada dua cara untuk membuat ByteBuffer, yang dapat dibagi lagi.
     * 
     * Jika Anda sudah memiliki byte[], Anda dapat "wrap" ke dalam
     * ByteBuffer untuk menyederhanakan pemrosesan:
     * 
     * byte[] reqBuffer = new byte[BUFFER_SIZE];
     * int readBytes = socketInputStream.read(reqBuffer);
     * final ByteBuffer reqBufferWrapper = ByteBuffer.wrap(reqBuffer);
     */

    /*
     * Ini akan menjadi kemungkinan untuk kode yang menangani interaksi jaringan
     * tingkat rendah.
     * 
     * Jika Anda belum memiliki byte[], Anda dapat membuat ByteBuffer melalui array
     * yang secara khusus dialokasikan untuk buffer seperti ini:
     * final ByteBuffer respBuffer = ByteBuffer.allocate(RESPONSE_BUFFER_SIZE);
     * putResponseData(respBuffer);
     * socketOutputStream.write(respBuffer.array());
     */

    /*
     * Jika jalur kode sangat penting bagi kinerja dan Anda memerlukan akses memori
     * sistem langsung, ByteBuffer bahkan dapat mengalokasikan buffer langsung
     * menggunakan #allocationDirect()
     */

    public static void main(String[] args) throws Exception {
        // final int BUFFER_SIZE = 1024; // Assuming BUFFER_SIZE is defined somewhere
        // // Example data for demonstration
        // byte[] exampleData = "Example data from socket".getBytes();
        // try {
        // InputStream socketInputStream = new ByteArrayInputStream(exampleData);
        // byte[] reqBuffer = new byte[BUFFER_SIZE];
        // int readBytes = socketInputStream.read(reqBuffer);
        // final ByteBuffer reqBufferWrapper = ByteBuffer.wrap(reqBuffer);

        // // Example usage of reqBufferWrapper
        // while (reqBufferWrapper.hasRemaining()) {
        // System.out.print((char) reqBufferWrapper.get());
        // // output: Example data from socket
        // }

        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // ------------------------
        // Define RESPONSE_BUFFER_SIZE
        final int RESPONSE_BUFFER_SIZE = 4;

        Socket socket = new Socket("alamat_server", 1102); // Ganti dengan alamat dan port yang sesuai
        OutputStream socketOutputStream = socket.getOutputStream();

        // Create ByteBuffer
        final ByteBuffer respBuffer = ByteBuffer.allocate(RESPONSE_BUFFER_SIZE);

        // Put response data into ByteBuffer
        putResponseData(respBuffer);

        // Write ByteBuffer's content to OutputStream
        socketOutputStream.write(respBuffer.array());
    }

    // Sample method for putting response data into ByteBuffer
    public static void putResponseData(ByteBuffer buffer) {
        // Sample data, you should replace this with your actual implementation
        String responseData = "Sample response data";
        buffer.put(responseData.getBytes());
    }
}
