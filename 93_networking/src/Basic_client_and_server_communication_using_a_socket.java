public class Basic_client_and_server_communication_using_a_socket {
    // Basic Client and Server Communication using a Socket/Komunikasi Dasar Klien
    // dan Server menggunakan Socket

    // Server: Start, and wait for incoming connections

    /*
     * //Open a listening "ServerSocket" on port 1234.
     * ServerSocket serverSocket = new ServerSocket(1234);
     * while (true) {
     * // Wait for a client connection.
     * // Once a client connected, we get a "Socket" object
     * // that can be used to send and receive messages to/from the newly
     * // connected client
     * Socket clientSocket = serverSocket.accept();
     * 
     * // Here we'll add the code to handle one specific client.
     * }
     */

    // Server: Handling clients
    /*
     * Kami akan menangani setiap klien dalam thread terpisah sehingga beberapa
     * klien dapat berinteraksi dengan server pada saat yang bersamaan. Teknik ini
     * berfungsi dengan baik selama jumlah klien sedikit (<< 1000 klien, tergantung
     * pada arsitektur OS dan
     * beban yang diharapkan dari setiap thread).
     * 
     * new Thread(() -> {
     * // Get the socket's InputStream, to read bytes from the socket
     * InputStream in = clientSocket.getInputStream();
     * // wrap the InputStream in a reader so you can read a String instead of bytes
     * BufferedReader reader = new BufferedReader(
     * new InputStreamReader(in, StandardCharsets.UTF_8));
     * // Read text from the socket and print line by line
     * String line;
     * while ((line = reader.readLine()) != null) {
     * System.out.println(line);
     * }
     * }).start();
     */

    // Client: Connect to the server and send a message

    /*
     * // 127.0.0.1 is the address of the server (this is the localhost address;
     * i.e.
     * // the address of our own machine)
     * // 1234 is the port that the server will be listening on
     * Socket socket = new Socket("127.0.0.1", 1234);
     * // Write a string into the socket, and flush the buffer
     * OutputStream outStream = socket.getOutputStream();
     * PrintWriter writer = new PrintWriter(
     * new OutputStreamWriter(outStream, StandardCharsets.UTF_8));
     * writer.println("Hello world!");
     * writer.flush();
     */

    // Closing Sockets and Handling Exceptions
    /*
     * Contoh di atas mengabaikan beberapa hal agar lebih mudah dibaca.
     * 1. Sama seperti file dan sumber daya eksternal lainnya, penting bagi kita
     * untuk memberi tahu OS setelah kita selesai menggunakannya. Ketika kita
     * selesai dengan soket, panggil socket.close() untuk menutupnya dengan benar.
     * 2. Soket menangani operasi I/O (Input/Output) yang bergantung pada berbagai
     * faktor eksternal. Misalnya apa
     * jika pihak lain tiba-tiba terputus? Bagaimana jika ada kesalahan jaringan?
     * Hal-hal ini berada di luar kendali kita.
     * Inilah sebabnya mengapa banyak operasi soket mungkin menimbulkan
     * pengecualian, terutama IOException.
     */

    // Oleh karena itu, kode yang lebih lengkap untuk klien akan menjadi seperti
    // ini:

    /*
     * // "try-with-resources" will close the socket once we leave its scope
     * try (Socket socket = new Socket("127.0.0.1", 1234)) {
     * OutputStream outStream = socket.getOutputStream();
     * PrintWriter writer = new PrintWriter(
     * new OutputStreamWriter(outStream, StandardCharsets.UTF_8));
     * writer.println("Hello world!");
     * writer.flush();
     * } catch (IOException e) {
     * //Handle the error
     * }
     */

    // Basic Server and Client - complete examples

    // Server:

    /*
     * import java.io.BufferedReader;
     * import java.io.IOException;
     * import java.io.InputStream;
     * import java.io.InputStreamReader;
     * import java.net.ServerSocket;
     * import java.net.Socket;
     * import java.nio.charset.StandardCharsets;
     * public class Server {
     * public static void main(String args[]) {
     * try (ServerSocket serverSocket = new ServerSocket(1234)) {
     * while (true) {
     * // Wait for a client connection.
     * Socket clientSocket = serverSocket.accept();
     * 
     * // Create and start a thread to handle the new client
     * new Thread(() -> {
     * try {
     * // Get the socket's InputStream, to read bytes
     * // from the socket
     * InputStream in = clientSocket.getInputStream();
     * // wrap the InputStream in a reader so you can
     * // read a String instead of bytes
     * BufferedReader reader = new BufferedReader(
     * new InputStreamReader(in, StandardCharsets.UTF_8));
     * // Read from the socket and print line by line
     * String line;
     * while ((line = reader.readLine()) != null) {
     * System.out.println(line);
     * }
     * }
     * catch (IOException e) {
     * e.printStackTrace();
     * } finally {
     * // This finally block ensures the socket is closed.
     * // A try-with-resources block cannot be used because
     * // the socket is passed into a thread, so it isn't
     * // created and closed in the same block
     * try {
     * clientSocket.close();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     * }).start();
     * }
     * }
     * catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * 
     */

    // Client

    /*
     * import java.io.IOException;
     * import java.io.OutputStream;
     * import java.io.OutputStreamWriter;
     * import java.io.PrintWriter;
     * import java.net.Socket;
     * import java.nio.charset.StandardCharsets;
     * public class Client {
     * public static void main(String args[]) {
     * try (Socket socket = new Socket("127.0.0.1", 1234)) {
     * // We'll reach this code once we've connected to the server
     * 
     * // Write a string into the socket, and flush the buffer
     * OutputStream outStream = socket.getOutputStream();
     * PrintWriter writer = new PrintWriter(
     * new OutputStreamWriter(outStream, StandardCharsets.UTF_8));
     * writer.println("Hello world!");
     * writer.flush();
     * } catch (IOException e) {
     * // Exception should be handled.
     * e.printStackTrace();
     * }
     * }
     * }
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // -------------
        // "try-with-resources" will close the socket once we leave its scope
        try (Socket socket = new Socket("127.0.0.1", 1234)) {
            OutputStream outStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(outStream, StandardCharsets.UTF_8));
            writer.println("Hello world!");
            writer.flush();
        } catch (IOException e) {
            // Handle the error
        }
        /*
         * output:
         * Hello world!
         * Hello world!
         * 
         */

    }
}
