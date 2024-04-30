
public class Basic_authentication {
    // Basic Authentication/Otentikasi Dasar

    // Cara melakukan panggilan JAX-WS dengan otentikasi dasar agak tidak jelas.

    // Berikut adalah contoh dimana Service adalah representasi kelas layanan dan
    // Port adalah port layanan yang ingin Anda akses.

    /*
     * Service s = new Service();
     * Port port = s.getPort();
     * 
     * BindingProvider prov = (BindingProvider)port;
     * prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
     * "myusername");
     * prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
     * "mypassword");
     * port.call();
     * 
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------------
        Service s = new Service();
        Port port = s.getPort();
        BindingProvider prov = (BindingProvider) port;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "myusername");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "mypassword");

        try {
            // Memanggil metode call()
            port.call();
            System.out.println("Panggilan berhasil.");
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat melakukan panggilan: " + e.getMessage());
        }

    }
}
