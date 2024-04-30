import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyStoreBuilderParameters;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManagerFactorySpi;

public class Loading_trustStore_and_keystore_from_inputstream {
    // Loading TrustStore and KeyStore from InputStream/Memuat TrustStore dan
    // KeyStore dari Aliran Masukan

    /*
     * public class TrustLoader {
     * 
     * public static void main(String args[]) {
     * try {
     * //Gets the inputstream of a a trust store file under ssl/rpgrenadesClient.jks
     * //This path refers to the ssl folder in the jar file, in a jar file in the
     * same
     * directory
     * //as this jar file, or a different directory in the same directory as the jar
     * file
     * InputStream stream =
     * TrustLoader.class.getResourceAsStream("/ssl/rpgrenadesClient.jks");
     * //Both trustStores and keyStores are represented by the KeyStore object
     * KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
     * //The password for the trustStore
     * char[] trustStorePassword = "password".toCharArray();
     * //This loads the trust store into the object
     * trustStore.load(stream, trustStorePassword);
     * 
     * //This is defining the SSLContext so the trust store will be used
     * //Getting default SSLContext to edit.
     * SSLContext context = SSLContext.getInstance("SSL");
     * //TrustMangers hold trust stores, more than one can be added
     * TrustManagerFactory factory =
     * TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
     * //Adds the truststore to the factory
     * factory.init(trustStore);
     * //This is passed to the SSLContext init method
     * TrustManager[] managers = factory.getTrustManagers();
     * context.init(null, managers, null);
     * //Sets our new SSLContext to be used.
     * SSLContext.setDefault(context);
     * } catch (KeyStoreException | IOException | NoSuchAlgorithmException
     * | CertificateException | KeyManagementException ex) {
     * //Handle error
     * ex.printStackTrace();
     * }
     * 
     * }
     * }
     */

    /*
     * Memulai KeyStore bekerja dengan cara yang sama, kecuali mengganti kata Trust
     * pada nama objek dengan Key. Selain itu,
     * Array KeyManager[] harus diteruskan ke argumen pertama SSLContext.init. Itu
     * adalah SSLContext.init(keyMangers, trustMangers, null)
     */

    public static void main(String[] args) {
        try {
            // Gets the inputstream of a a trust store file under ssl/rpgrenadesClient.jks
            // This path refers to the ssl folder in the jar file, in a jar file in the same
            // directory
            // as this jar file, or a different directory in the same directory as the jar
            // file
            InputStream stream = Loading_trustStore_and_keystore_from_inputstream.class
                    .getResourceAsStream("/ssl/rpgrenadesClient.jks");
            // Both trustStores and keyStores are represented by the KeyStore object
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            // The password for the trustStore
            char[] trustStorePassword = "password".toCharArray();
            // This loads the trust store into the object
            trustStore.load(stream, trustStorePassword);

            // This is defining the SSLContext so the trust store will be used
            // Getting default SSLContext to edit.
            SSLContext context = SSLContext.getInstance("SSL");

            // TrustMangers hold trust stores, more than one can be added
            TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            // Adds the truststore to the factory
            factory.init(trustStore);

            // This is passed to the SSLContext init method
            TrustManager[] managers = factory.getTrustManagers();
            context.init(null, managers, null);

            // Sets our new SSLContext to be used.
            SSLContext.setDefault(context);
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException
                | KeyManagementException ex) {
            // Handle error
            ex.printStackTrace();
        }

    }
}
