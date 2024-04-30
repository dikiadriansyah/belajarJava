import java.io.*;
import java.net.*;

public class Basic_client_server_communication_using_udp {
    // Basic Client/Server Communication using UDP (Datagram)/Komunikasi
    // Klien/Server Dasar menggunakan UDP (Datagram)

    // Client.java

    /*
     * import java.io.*;
     * import java.net.*;
     * 
     * public class Client{
     * public static void main(String [] args) throws IOException{
     * DatagramSocket clientSocket = new DatagramSocket();
     * InetAddress address = InetAddress.getByName(args[0]);
     * String ex = "Hello, World!";
     * byte[] buf = ex.getBytes();
     * DatagramPacket packet = new DatagramPacket(buf,buf.length, address, 4160);
     * clientSocket.send(packet);
     * }
     * }
     * 
     */

    // Dalam hal ini, kita meneruskan alamat server, melalui argumen (args[0]). Port
    // yang kami gunakan adalah 4160.

    /*
     * Server.java
     * import java.io.*;
     * import java.net.*;
     * public class Server{
     * public static void main(String [] args) throws IOException{
     * DatagramSocket serverSocket = new DatagramSocket(4160);
     * byte[] rbuf = new byte[256];
     * DatagramPacket packet = new DatagramPacket(rbuf, rbuf.length);
     * serverSocket.receive(packet);
     * String response = new String(packet.getData());
     * System.out.println("Response: " + response);
     * }
     * }
     */

    /*
     * Di sisi server, deklarasikan DatagramSocket pada port yang sama dengan tempat
     * kita mengirim pesan (4160) dan tunggu hingga response.
     */

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(4160);
            byte[] rbuf = new byte[256];
            DatagramPacket packet = new DatagramPacket(rbuf, rbuf.length);
            serverSocket.receive(packet);
            String response = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Response: " + response);
            serverSocket.close();
        } catch (SocketException e) {
            System.err.println("Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
