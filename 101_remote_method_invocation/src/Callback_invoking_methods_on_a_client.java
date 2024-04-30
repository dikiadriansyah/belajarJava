public class Callback_invoking_methods_on_a_client {
    // Callback: invoking methods on a "client"/Callback: memanggil metode pada
    // "klien"

    // Ringkasan

    /*
     * Dalam contoh ini 2 klien saling mengirim informasi melalui server. Satu klien
     * mengirimkan nomor ke server yang diteruskan ke klien kedua. Klien kedua
     * membagi dua nomor tersebut dan mengirimkannya kembali ke klien pertama
     * melalui server. Klien pertama melakukan hal yang sama. Server menghentikan
     * komunikasi ketika nomor tersebut kembali
     * yang diberikan oleh salah satu klien kurang dari 10. Nilai yang dikembalikan
     * dari server ke klien (angka yang dikonversi menjadi representasi string)
     * kemudian menelusuri kembali prosesnya.
     */

    /*
     * 1. Server login mengikat dirinya ke registry.
     * 2. Klien mencari server login dan memanggil metode login beserta
     * informasinya. Kemudian:
     * Server login menyimpan informasi klien. Ini mencakup rintisan klien dengan
     * metode panggilan balik.
     * Server login membuat dan mengembalikan stub server ("koneksi" atau "sesi") ke
     * klien untuk disimpan. Ini mencakup stub server dengan metodenya termasuk
     * metode logout (tidak digunakan dalam contoh ini).
     * 3. Klien memanggil passInt server dengan nama klien penerima dan int.
     * 4. Server memanggil separuh klien penerima dengan int tersebut. Ini memulai
     * bolak-balik (panggilan dan
     * panggilan balik) komunikasi hingga dihentikan oleh server.
     */

    // The shared remote interfaces/Antarmuka jarak jauh bersama

    // The login server:

    /*
     * package callbackRemote;
     * import java.rmi.Remote;
     * import java.rmi.RemoteException;
     * public interface RemoteLogin extends Remote {
     * RemoteConnection login(String name, RemoteClient client) throws
     * RemoteException;
     * }
     */

    /*
     * The server:
     * package callbackRemote;
     * import java.rmi.Remote;
     * import java.rmi.RemoteException;
     * public interface RemoteConnection extends Remote {
     * void logout() throws RemoteException;
     * String passInt(String name, int i) throws RemoteException;
     * }
     */

    /*
     * The client:
     * package callbackRemote;
     * import java.rmi.Remote;
     * import java.rmi.RemoteException;
     * public interface RemoteClient extends Remote {
     * void half(int i) throws RemoteException;
     * }
     */

    /*
     * The implementations
     * The login server:
     * package callbackServer;
     * import java.rmi.RemoteException;
     * import java.rmi.registry.LocateRegistry;
     * import java.rmi.registry.Registry;
     * import java.rmi.server.UnicastRemoteObject;
     * import java.util.HashMap;
     * import java.util.Map;
     * import callbackRemote.RemoteClient;
     * import callbackRemote.RemoteConnection;
     * import callbackRemote.RemoteLogin;
     * public class LoginServer implements RemoteLogin {
     * static Map<String, RemoteClient> clients = new HashMap<>();
     * 
     * @Override
     * public RemoteConnection login(String name, RemoteClient client) {
     * Connection connection = new Connection(name, client);
     * clients.put(name, client);
     * System.out.println(name + " logged in");
     * return connection;
     * }
     * public static void main(String[] args) {
     * try {
     * Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
     * LoginServer server = new LoginServer();
     * UnicastRemoteObject.exportObject(server, Registry.REGISTRY_PORT);
     * reg.rebind("LoginServerName", server);
     * } catch (RemoteException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    /*
     * The server:
     * package callbackServer;
     * import java.rmi.NoSuchObjectException;
     * import java.rmi.RemoteException;
     * import java.rmi.registry.Registry;
     * import java.rmi.server.UnicastRemoteObject;
     * import java.rmi.server.Unreferenced;
     * import callbackRemote.RemoteClient;
     * import callbackRemote.RemoteConnection;
     * public class Connection implements RemoteConnection, Unreferenced {
     * RemoteClient client;
     * String name;
     * public Connection(String name, RemoteClient client) {
     * this.client = client;
     * this.name = name;
     * try {
     * UnicastRemoteObject.exportObject(this, Registry.REGISTRY_PORT);
     * } catch (RemoteException e) {
     * e.printStackTrace();
     * }
     * }
     * 
     * @Override
     * public void unreferenced() {
     * try {
     * UnicastRemoteObject.unexportObject(this, true);
     * } catch (NoSuchObjectException e) {
     * e.printStackTrace();
     * }
     * }
     * 
     * @Override
     * public void logout() {
     * try {
     * UnicastRemoteObject.unexportObject(this, true);
     * } catch (NoSuchObjectException e) {
     * e.printStackTrace();
     * }
     * }
     * 
     * @Override
     * public String passInt(String recipient, int i) {
     * System.out.println("Server received from " + name + ":" + i);
     * if (i < 10)
     * return String.valueOf(i);
     * RemoteClient client = LoginServer.clients.get(recipient);
     * try {
     * client.half(i);
     * } catch (RemoteException e) {
     * e.printStackTrace();
     * }
     * return String.valueOf(i);
     * }
     * }
     */

    /*
     * The client:
     * package callbackClient;
     * import java.rmi.NotBoundException;
     * import java.rmi.RemoteException;
     * import java.rmi.registry.LocateRegistry;
     * import java.rmi.registry.Registry;
     * import java.rmi.server.UnicastRemoteObject;
     * import callbackRemote.RemoteClient;
     * import callbackRemote.RemoteConnection;
     * import callbackRemote.RemoteLogin;
     * public class Client implements RemoteClient {
     * RemoteConnection connection;
     * String name, target;
     * Client(String name, String target) {
     * this.name = name;
     * this.target = target;
     * }
     * public static void main(String[] args) {
     * Client client = new Client(args[0], args[1]);
     * try {
     * Registry reg = LocateRegistry.getRegistry();
     * RemoteLogin login = (RemoteLogin) reg.lookup("LoginServerName");
     * UnicastRemoteObject.exportObject(client, Integer.parseInt(args[2]));
     * client.connection = login.login(client.name, client);
     * } catch (RemoteException | NotBoundException e) {
     * e.printStackTrace();
     * }
     * if ("Client1".equals(client.name)) {
     * try {
     * client.connection.passInt(client.target, 120);
     * } catch (RemoteException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * 
     * @Override
     * public void half(int i) throws RemoteException {
     * String result = connection.passInt(target, i / 2);
     * System.out.println(name + " received: \"" + result + "\"");
     * }
     * }
     */

    /*
     * Menjalankan contoh:
     * 1. Jalankan login server.
     * 2. Jalankan client dengan argumen Client2 Client1 1097.
     * 3. Jalankan client dengan argumen Client1 Client2 1098
     */

    /*
     * Outputnya akan muncul di 3 konsol karena ada 3 JVM. di sini mereka disatukan:
     * Client2 logged in
     * Client1 logged in
     * Server received from Client1:120
     * Server received from Client2:60
     * Server received from Client1:30
     * Server received from Client2:15
     * Server received from Client1:7
     * Client1 received: "7"
     * Client2 received: "15"
     * Client1 received: "30"
     * Client2 received: "60"
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

    }
}
