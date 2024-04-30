import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class Loading_properties {
    // Loading properties/Memuat properti

    // Untuk memuat file properti yang dibundel dengan aplikasi Anda:

    /*
     * public class Defaults {
     * public static Properties loadDefaults() {
     * try (InputStream bundledResource =
     * Defaults.class.getResourceAsStream("defaults.properties")) {
     * Properties defaults = new Properties();
     * defaults.load(bundledResource);
     * return defaults;
     * } catch (IOException e) {
     * // Since the resource is bundled with the application,
     * // we should never get here.
     * throw new UncheckedIOException(
     * "defaults.properties not properly packaged"
     * + " with application", e);
     * }
     * }
     * }
     */

    public static Properties loadDefaults() {
        try (InputStream bundledResource = Loading_properties.class.getResourceAsStream("/defaults.properties")) {
            Properties defaults = new Properties();
            if (bundledResource != null) {
                defaults.load(bundledResource);
                return defaults;
            } else {
                throw new IOException("defaults.properties not found in the bundled resources");
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Error loading defaults.properties", e);
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Properties defaultProperties = loadDefaults();

        // Contoh penggunaan nilai default yang dimuat
        String username = defaultProperties.getProperty("default.username");
        String password = defaultProperties.getProperty("default.password");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

    }
}
