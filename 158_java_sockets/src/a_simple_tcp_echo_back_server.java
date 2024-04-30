import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a_simple_tcp_echo_back_server {
    // A simple TCP echo back server/Server gema kembali TCP sederhana

    /*
     * Server TCP echo back kami akan menjadi thread terpisah. Ini sederhana sebagai
     * permulaan. Itu hanya akan membalas apa pun yang Anda kirimkan tetapi dalam
     * bentuk huruf kapital.
     */

    /*
     * public class CAPECHOServer extends Thread{
     * // This class implements server sockets. A server socket waits for requests
     * to come
     * // in over the network only when it is allowed through the local firewall
     * ServerSocket serverSocket;
     * 
     * public CAPECHOServer(int port, int timeout){
     * try {
     * // Create a new Server on specified port.
     * serverSocket = new ServerSocket(port);
     * // SoTimeout is basiacally the socket timeout.
     * // timeout is the time until socket timeout in milliseconds
     * serverSocket.setSoTimeout(timeout);
     * } catch (IOException ex) {
     * Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * }
     * 
     * @Override
     * public void run(){
     * try {
     * // We want the server to continuously accept connections
     * while(!Thread.interrupted()){
     * 
     * }
     * // Close the server once done.
     * serverSocket.close();
     * } catch (IOException ex) {
     * Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * }
     * 
     * }
     */

    // Sekarang untuk menerima koneksi. Mari perbarui metode run.

    /*
     * @Override
     * public void run(){
     * while(!Thread.interrupted()){
     * try {
     * // Log with the port number and machine ip
     * Logger.getLogger((this.getClass().getName())).log(Level.INFO, "Listening for
     * Clients at
     * {0} on {1}", new Object[]{serverSocket.getLocalPort(),
     * InetAddress.getLocalHost().getHostAddress()});
     * Socket client = serverSocket.accept(); // Accept client conncetion
     * // Now get DataInputStream and DataOutputStreams
     * DataInputStream istream = new DataInputStream(client.getInputStream()); //
     * From
     * client's input stream
     * DataOutputStream ostream = new DataOutputStream(client.getOutputStream());
     * // Important Note
     * 
     * //The server's input is the client's output
     * //The client's input is the server's output
     * // Send a welcome message
     * ostream.writeUTF("Welcome!");
     * 
     * // Close the connection
     * istream.close();
     * ostream.close();
     * client.close();
     * } catch (IOException ex) {
     * Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * }
     * 
     * // Close the server once done
     * 
     * try {
     * serverSocket.close();
     * } catch (IOException ex) {
     * Logger.getLogger(CAPECHOServer.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * }
     */

    /*
     * Sekarang jika Anda dapat membuka telnet dan mencoba menghubungkan Anda akan
     * melihat pesan Selamat Datang.
     * Anda harus terhubung dengan port yang Anda tentukan dan Alamat IP.
     * Anda akan melihat hasil yang serupa dengan ini:
     * 
     * Welcome!
     * Connection to host lost.
     * 
     */

    /*
     * Nah, koneksi terputus karena kami memutusnya. Terkadang kita harus memprogram
     * klien TCP kita sendiri.
     * Dalam hal ini, kita memerlukan klien untuk meminta masukan dari pengguna dan
     * mengirimkannya melalui jaringan, menerima masukan dengan huruf kapital.
     * Jika server mengirimkan data terlebih dahulu, maka klien harus membaca data
     * tersebut terlebih dahulu.
     */

    /*
     * public class CAPECHOClient extends Thread{
     * Socket server;
     * Scanner key; // Scanner for input
     * public CAPECHOClient(String ip, int port){
     * try {
     * server = new Socket(ip, port);
     * key = new Scanner(System.in);
     * } catch (IOException ex) {
     * Logger.getLogger(CAPECHOClient.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * }
     * 
     * @Override
     * public void run(){
     * DataInputStream istream = null;
     * DataOutputStream ostream = null;
     * try {
     * istream = new DataInputStream(server.getInputStream()); // Familiar lines
     * ostream = new DataOutputStream(server.getOutputStream());
     * System.out.println(istream.readUTF()); // Print what the server sends
     * System.out.print(">");
     * String tosend = key.nextLine();
     * ostream.writeUTF(tosend); // Send whatever the user typed to the server
     * System.out.println(istream.readUTF()); // Finally read what the server sends
     * before
     * exiting.
     * } catch (IOException ex) {
     * Logger.getLogger(CAPECHOClient.class.getName()).log(Level.SEVERE, null, ex);
     * } finally {
     * try {
     * istream.close();
     * ostream.close();
     * server.close();
     * } catch (IOException ex) {
     * Logger.getLogger(CAPECHOClient.class.getName()).log(Level.SEVERE, null, ex);
     * }
     * }
     * }
     * }
     * 
     */

    // Sekarang perbarui server

    /*
     * ostream.writeUTF("Welcome!");
     * 
     * String inString = istream.readUTF(); // Read what the user sent
     * String outString = inString.toUpperCase(); // Change it to caps
     * ostream.writeUTF(outString);
     * 
     * // Close the connection
     * istream.close();
     * 
     */

    // Dan sekarang jalankan server dan klien, Anda akan mendapatkan keluaran
    // seperti ini

    /*
     * Welcome!
     * >
     */
    public static void main(String[] args) throws Exception {
        // Start the server
        int serverPort = 12345; // Choose any available port
        int timeout = 0; // No timeout for simplicity, you can set it if needed
        CAPECHOServer server = new CAPECHOServer(serverPort, timeout);
        server.start(); // Start the server thread

        // Start the client
        String serverIP = "localhost"; // Server's IP, assuming it's running on the same machine
        CAPECHOClient client = new CAPECHOClient(serverIP, serverPort);
        client.start(); // Start the client thread

        /*
         * output:
         * Waiting for client connection...
         * Client connected: Socket[addr=/127.0.0.1,port=58976,localport=12345]
         * Waiting for client connection...
         */

    }
}
