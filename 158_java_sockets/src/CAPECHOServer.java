import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CAPECHOServer extends Thread {

    // This class implements server sockets. A server socket waits for requests to
    // come
    // in over the network only when it is allowed through the local firewall
    private ServerSocket serverSocket;
    private int timeout;

    public CAPECHOServer(int port, int timeout) {
        this.timeout = timeout;
        try {
            // Create a new Server on specified port.
            serverSocket = new ServerSocket(port);
            // SoTimeout is basically the socket timeout.
            // timeout is the time until socket timeout in milliseconds
            serverSocket.setSoTimeout(timeout);
        } catch (IOException ex) {
            Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            // We want the server to continuously accept connections
            while (!Thread.interrupted()) {
                System.out.println("Waiting for client connection...");
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Handle client request in a separate thread
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
            // Close the server once done.
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Inner class to handle client connections
    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader input;
        private PrintWriter output;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            try {
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                output = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
            } catch (IOException ex) {
                Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = input.readLine()) != null) {
                    // Echo back the received message to the client
                    output.println("Server: " + request);
                }
            } catch (IOException ex) {
                Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    // Close the connection
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ----------------
        int port = 12345; // Specify your desired port number
        int timeout = 10000; // Specify your desired timeout in milliseconds
        CAPECHOServer server = new CAPECHOServer(port, timeout);
        server.start();
        /*
         * output:
         * Waiting for client connection...
         * Mar 20, 2024 2:22:33 PM a_simple_tcp_echo_back_server run
         * SEVERE: null
         */
    }
}
