
public class rmi_through_jndi {
    // RMI through JNDI /RMI melalui JNDI

    /*
     * Contoh ini menunjukkan cara kerja JNDI di RMI. Ini memiliki dua peran:
     * 1. untuk menyediakan server dengan API bind/unbind/rebind ke RMI Registry
     * 2. untuk memberi klien API pencarian/daftar ke RMI Registry.
     */

    /*
     * Registri RMI adalah bagian dari RMI, bukan JNDI.
     * Untuk mempermudahnya, kita akan menggunakan
     * java.rmi.registry.CreateRegistry() untuk membuat RMI Registry
     */

    // 1. Server.java(the JNDI server)

    /*
     * package com.neohope.jndi.test;
     * import javax.naming.Context;
     * import javax.naming.InitialContext;
     * import javax.naming.NamingException;
     * import java.io.IOException;
     * import java.rmi.RemoteException;
     * import java.rmi.registry.LocateRegistry;
     * import java.util.Hashtable;
     * 
     * // JNDI Server
     * //1.create a registry on port 1234
     * //2.bind JNDI
     * //3.wait for connection
     * //4.clean up and end
     * 
     * 
     * public class Server {
     * private static Registry registry;
     * private static InitialContext ctx;
     * public static void initJNDI() {
     * try {
     * registry = LocateRegistry.createRegistry(1234);
     * final Hashtable jndiProperties = new Hashtable();
     * jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
     * "com.sun.jndi.rmi.registry.RegistryContextFactory");
     * jndiProperties.put(Context.PROVIDER_URL, "rmi://localhost:1234");
     * ctx = new InitialContext(jndiProperties);
     * } catch (NamingException e) {
     * e.printStackTrace();
     * } catch (RemoteException e) {
     * e.printStackTrace();
     * }
     * }
     * public static void bindJNDI(String name, Object obj) throws NamingException {
     * ctx.bind(name, obj);
     * }
     * public static void unbindJNDI(String name) throws NamingException {
     * ctx.unbind(name);
     * }
     * public static void unInitJNDI() throws NamingException {
     * ctx.close();
     * }
     * public static void main(String[] args) throws NamingException, IOException {
     * initJNDI();
     * NMessage msg = new NMessage("Just A Message");
     * bindJNDI("/neohope/jndi/test01", msg);
     * System.in.read();
     * unbindJNDI("/neohope/jndi/test01");
     * unInitJNDI();
     * }
     * }
     * 
     */

    // 2. Client.java(the JNDI client)
    /*
     * package com.neohope.jndi.test;
     * import javax.naming.Context;
     * import javax.naming.InitialContext;
     * import javax.naming.NamingException;
     * import java.util.Hashtable;
     * 
     * //1.init context
     * //2.lookup registry for the service
     * //3.use the service
     * //4.end
     * 
     * public class Client {
     * public static void main(String[] args) throws NamingException {
     * final Hashtable jndiProperties = new Hashtable();
     * jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
     * "com.sun.jndi.rmi.registry.RegistryContextFactory");
     * jndiProperties.put(Context.PROVIDER_URL, "rmi://localhost:1234");
     * InitialContext ctx = new InitialContext(jndiProperties);
     * NMessage msg = (NeoMessage) ctx.lookup("/neohope/jndi/test01");
     * System.out.println(msg.message);
     * ctx.close();
     * }
     * }
     * 
     */

    // 3. NMessage.java (RMI server class)
    /*
     * package com.neohope.jndi.test;
     * import java.io.Serializable;
     * import java.rmi.Remote;
     * 
     * //NMessage
     * //RMI server class
     * //must implements Remote and Serializable
     * public class NMessage implements Remote, Serializable {
     * public String message = "";
     * public NMessage(String message)
     * {
     * this.message = message;
     * }
     * }
     * 
     */

    /*
     * Cara menjalankan contohnya:
     * 1. membangun dan memulai server
     * 2. membangun dan memulai klien
     */

    // Introduce

    /*
     * Java Naming and Directory Interface (JNDI) adalah Java API untuk layanan
     * direktori yang memungkinkan klien perangkat lunak Java menemukan dan mencari
     * data dan objek melalui nama. Ini dirancang agar independen terhadap penerapan
     * layanan penamaan atau direktori tertentu.
     * 
     * Arsitektur JNDI terdiri dari API (Application Programming Interface) dan SPI
     * (Service Provider Interface). Aplikasi Java menggunakan API ini untuk
     * mengakses berbagai layanan penamaan dan direktori. SPI memungkinkan berbagai
     * layanan penamaan dan direktori dipasang secara transparan, memungkinkan
     * aplikasi Java menggunakan API
     * teknologi JNDI untuk mengakses layanan mereka.
     * 
     * Seperti yang Anda lihat dari gambar di atas, JNDI mendukung LDAP, DNS, NIS,
     * NDS, RMI dan CORBA. Tentu saja Anda bisa memperpanjangnya.
     */

    // How it works/Bagaimana itu bekerja

    /*
     * Dalam contoh ini, Java RMI menggunakan JNDI API untuk mencari objek di
     * jaringan. Jika Anda ingin mencari suatu objek, Anda memerlukan setidaknya dua
     * informasi:
     * 1. Dimana menemukan benda tersebut
     * Registri RMI mengelola pengikatan nama, yang memberi tahu Anda di mana
     * menemukan objek.
     * 1. Nama benda
     * Apa nama suatu benda? Biasanya berupa string, bisa juga berupa objek yang
     * mengimplementasikan antarmuka Nama.
     */

    // Selangkah demi selangkah
    // 1. Pertama, Anda memerlukan registri, yang mengelola pengikatan nama. Dalam
    // contoh ini, kami menggunakan
    /*
     * java.rmi.registry.LocateRegistry.
     * //This will start a registry on localhost, port 1234
     * registry = LocateRegistry.createRegistry(1234);
     */

    /*
     * 2. Klien dan server memerlukan Konteks. Server menggunakan Konteks untuk
     * mengikat nama dan objek. Klien menggunakan Konteks untuk mencari nama dan
     * mendapatkan objek.
     * 
     * //We use com.sun.jndi.rmi.registry.RegistryContextFactory as the
     * InitialContextFactory
     * final Hashtable jndiProperties = new Hashtable();
     * jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
     * "com.sun.jndi.rmi.registry.RegistryContextFactory");
     * //the registry usrl is "rmi://localhost:1234"
     * jndiProperties.put(Context.PROVIDER_URL, "rmi://localhost:1234");
     * InitialContext ctx = new InitialContext(jndiProperties);
     */

    /*
     * 3. Server mengikat nama dan objek
     * //The jndi name is "/neohope/jndi/test01"
     * bindJNDI("/neohope/jndi/test01", msg);
     */

    /*
     * 4. Klien mencari objek dengan nama "/neohope/jndi/test01"
     * //look up the object by name "java:com/neohope/jndi/test01"
     * NeoMessage msg = (NeoMessage) ctx.lookup("/neohope/jndi/test01");
     */

    /*
     * 5. Sekarang klien dapat menggunakan objek tersebut
     * 6. Saat server berakhir, perlu dibersihkan.
     * ctx.unbind("/neohope/jndi/test01");
     * ctx.close();
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------------------------------

    }
}
