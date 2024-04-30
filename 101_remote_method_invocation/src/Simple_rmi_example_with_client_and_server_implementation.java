public class Simple_rmi_example_with_client_and_server_implementation {
    // Simple RMI example with Client and Server implementation/Contoh RMI sederhana
    // dengan implementasi Client dan Server

    /*
     * Ini adalah contoh RMI sederhana dengan lima kelas Java dan dua paket, server
     * dan client
     */

    /*
     * Server Package
     * PersonListInterface.java
     * public interface PersonListInterface extends Remote
     * {
     * 
     * This interface is used by both client and server
     * 
     * @return List of Persons
     * 
     * @throws RemoteException
     * ArrayList<String> getPersonList() throws RemoteException;
     * }
     */

    /*
     * PersonListImplementation.java
     * public class PersonListImplementation
     * extends UnicastRemoteObject
     * implements PersonListInterface
     * {
     * private static final long serialVersionUID = 1L;
     * // standard constructor needs to be available
     * public PersonListImplementation() throws RemoteException
     * {}
     * Implementation of "PersonListInterface"
     * 
     * @throws RemoteException
     * 
     * @Override
     * public ArrayList<String> getPersonList() throws RemoteException
     * {
     * ArrayList<String> personList = new ArrayList<String>();
     * 
     * personList.add("Peter Pan");
     * personList.add("Pippi Langstrumpf");
     * // add your name here :)
     * 
     * return personList;
     * }
     * }
     */

    /*
     * Server.java
     * public class Server {
     * Register servicer to the known public methods
     * private static void createServer() {
     * try {
     * // Register registry with standard port 1099
     * LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
     * System.out.println("Server : Registry created.");
     * // Register PersonList to registry
     * Naming.rebind("PersonList", new PersonListImplementation());
     * System.out.println("Server : PersonList registered");
     * } catch (final IOException e) {
     * e.printStackTrace();
     * }
     * }
     * public static void main(final String[] args) {
     * createServer();
     * }
     * }
     * 
     */

    /*
     * Client package
     * PersonListLocal.java
     * public class PersonListLocal {
     * private static PersonListLocal instance;
     * private PersonListInterface personList;
     * //Create a singleton instance
     * private PersonListLocal() {
     * try {
     * // Lookup to the local running server with port 1099
     * final Registry registry = LocateRegistry.getRegistry("localhost",
     * Registry.REGISTRY_PORT);
     * // Lookup to the registered "PersonList"
     * personList = (PersonListInterface) registry.lookup("PersonList");
     * } catch (final RemoteException e) {
     * e.printStackTrace();
     * } catch (final NotBoundException e) {
     * e.printStackTrace();
     * }
     * }
     * public static PersonListLocal getInstance() {
     * if (instance == null) {
     * instance = new PersonListLocal();
     * }
     * return instance;
     * }
     * 
     * // Returns the servers PersonList
     * public ArrayList<String> getPersonList() {
     * if (instance != null) {
     * try {
     * return personList.getPersonList();
     * } catch (final RemoteException e) {
     * e.printStackTrace();
     * }
     * }
     * return new ArrayList<>();
     * }
     * }
     * 
     */

    /*
     * PersonTest.java
     * public class PersonTest
     * {
     * public static void main(String[] args)
     * {
     * // get (local) PersonList
     * ArrayList<String> personList = PersonListLocal.getInstance().getPersonList();
     * 
     * // print all persons
     * for(String person : personList)
     * {
     * System.out.println(person);
     * }
     * }
     * }
     */

    // Test your application
    /*
     * Start main method of Server.java. Output:
     * Server : Registry created.
     * Server : PersonList registered
     * 
     * Start main method of PersonTest.java. Output:
     * Peter Pan
     * Pippi Langstrumpf
     */

    public static void main(String[] args) throws Exception {

    }
}
