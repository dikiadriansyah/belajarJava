import java.io.IOException;

public class Multicasting {
    // Multicasting

    /*
     * Multicasting adalah jenis Soket Datagram. Tidak seperti Datagram biasa,
     * Multicasting tidak menangani setiap klien
     * secara individual, ia mengirimkannya ke satu Alamat IP dan semua klien yang
     * berlangganan akan menerima pesan tersebut.
     */

    /*
     * Contoh kode untuk sisi server:
     * public class Server {
     * 
     * private DatagramSocket serverSocket;
     * 
     * private String ip;
     * 
     * private int port;
     * 
     * public Server(String ip, int port) throws SocketException, IOException{
     * this.ip = ip;
     * this.port = port;
     * // socket used to send
     * serverSocket = new DatagramSocket();
     * }
     * 
     * public void send() throws IOException{
     * // make datagram packet
     * byte[] message = ("Multicasting...").getBytes();
     * DatagramPacket packet = new DatagramPacket(message, message.length,
     * InetAddress.getByName(ip), port);
     * // send packet
     * serverSocket.send(packet);
     * }
     * 
     * public void close(){
     * serverSocket.close();
     * }
     * }
     * 
     */

    /*
     * Contoh kode untuk sisi klien:
     * public class Client {
     * 
     * private MulticastSocket socket;
     * 
     * public Client(String ip, int port) throws IOException {
     * 
     * // important that this is a multicast socket
     * socket = new MulticastSocket(port);
     * 
     * // join by ip
     * socket.joinGroup(InetAddress.getByName(ip));
     * }
     * 
     * public void printMessage() throws IOException{
     * // make datagram packet to recieve
     * byte[] message = new byte[256];
     * DatagramPacket packet = new DatagramPacket(message, message.length);
     * 
     * // recieve the packet
     * socket.receive(packet);
     * System.out.println(new String(packet.getData()));
     * }
     * 
     * public void close(){
     * socket.close();
     * }
     * }
     */

    /*
     * Kode untuk menjalankan Server:
     * public static void main(String[] args) {
     * try {
     * final String ip = args[0];
     * final int port = Integer.parseInt(args[1]);
     * Server server = new Server(ip, port);
     * server.send();
     * server.close();
     * } catch (IOException ex) {
     * ex.printStackTrace();
     * }
     * }
     * 
     */

    /*
     * Kode untuk menjalankan Klien:
     * public static void main(String[] args) {
     * try {
     * final String ip = args[0];
     * final int port = Integer.parseInt(args[1]);
     * Client client = new Client(ip, port);
     * client.printMessage();
     * client.close();
     * } catch (IOException ex) {
     * ex.printStackTrace();
     * }
     * }
     * 
     */

    /*
     * Jalankan Klien Terlebih Dahulu: Klien harus berlangganan IP sebelum dapat
     * mulai menerima paket apa pun. Jika Anda memulai server dan panggil metode
     * send(), lalu buat klien (& call printMessage()).
     * Tidak akan terjadi apa-apa karena klien terhubung setelah pesan dikirim.
     */

    public static void main(String[] args) {
        try {
            final String ip = args[0];
            final int port = Integer.parseInt(args[1]);
            Server2 server = new Server2(ip, port);
            server.send();
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
