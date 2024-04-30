import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Read_from_socket {
    // Read from socket/Baca dari soket

    /*
     * String hostName = args[0];
     * int portNumber = Integer.parseInt(args[1]);
     * try (
     * Socket echoSocket = new Socket(hostName, portNumber);
     * PrintWriter out =
     * new PrintWriter(echoSocket.getOutputStream(), true);
     * BufferedReader in =
     * new BufferedReader(
     * new InputStreamReader(echoSocket.getInputStream()));
     * BufferedReader stdIn =
     * new BufferedReader(
     * new InputStreamReader(System.in))
     * ) {
     * //Use the socket
     * }
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -------------------
        if (args.length < 2) {
            System.err.println("Usage: java SocketClient <hostname> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(
                        new InputStreamReader(System.in))) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Server: " + in.readLine()); // Membaca dan menampilkan respons dari server
            }
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }
        /*
         * output:
         * Usage: java SocketClient <hostname> <port number>
         */

    }
}
