import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java Client <server-ip>");
            return;
        }

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(args[0]);
            String ex = "Hello, World!";
            byte[] buf = ex.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4160);
            clientSocket.send(packet);
            clientSocket.close();
        } catch (SocketException e) {
            System.err.println("Socket error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }

    }
}
