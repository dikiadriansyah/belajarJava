public class Client_server_invoking_methods_in_one_jvm_from_another {
    // Client-Server: invoking methods in one JVM from another/Client-Server:
    // memanggil metode dalam satu JVM dari JVM lainnya

    // Antarmuka jarak jauh bersama:

    /*
     * Antarmuka jarak jauh bersama:
     * package remote;
     * import java.rmi.Remote;
     * import java.rmi.RemoteException;
     * public interface RemoteServer extends Remote {
     * int stringToInt(String string) throws RemoteException;
     * }
     */

    // Server yang mengimplementasikan antarmuka jarak jauh bersama:
    /*
     * package server;
     * import java.rmi.RemoteException;
     * import java.rmi.registry.LocateRegistry;
     * import java.rmi.registry.Registry;
     * import java.rmi.server.UnicastRemoteObject;
     * import remote.RemoteServer;
     * public class Server implements RemoteServer {
     * 
     * @Override
     * public int stringToInt(String string) throws RemoteException {
     * System.out.println("Server received: \"" + string + "\"");
     * return Integer.parseInt(string);
     * }
     * public static void main(String[] args) {
     * try {
     * Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
     * Server server = new Server();
     * UnicastRemoteObject.exportObject(server, Registry.REGISTRY_PORT);
     * reg.rebind("ServerName", server);
     * } catch (RemoteException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */

    // Klien memanggil metode di server (jarak jauh):

    /*
     * package client;
     * import java.rmi.NotBoundException;
     * import java.rmi.RemoteException;
     * import java.rmi.registry.LocateRegistry;
     * import java.rmi.registry.Registry;
     * import remote.RemoteServer;
     * public class Client {
     * static RemoteServer server;
     * public static void main(String[] args) {
     * try {
     * Registry reg = LocateRegistry.getRegistry();
     * server = (RemoteServer) reg.lookup("ServerName");
     * } catch (RemoteException | NotBoundException e) {
     * e.printStackTrace();
     * }
     * Client client = new Client();
     * client.callServer();
     * }
     * void callServer() {
     * 
     * try {
     * int i = server.stringToInt("120");
     * System.out.println("Client received: " + i);
     * } catch (RemoteException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * 
     */

    // output:
    /*
     * Server received: "120"
     * Client received: 120
     */

    public static void main(String[] args) throws Exception {

    }
}
