import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Coordinating_preferences_access_across_multiple_application_instances {
    // Coordinating preferences access across multiple application instances /
    // Mengkoordinasikan akses preferensi di beberapa contoh aplikasi

    /*
     * Semua contoh Preferences selalu aman untuk thread di seluruh thread dari satu
     * Java Virtual Machine (JVM).
     * Karena Preferensi dapat dibagikan ke beberapa JVM, ada metode khusus yang
     * menangani sinkronisasi perubahan di seluruh mesin virtual.
     * 
     * Jika Anda memiliki aplikasi yang seharusnya dijalankan dalam satu instance
     * saja, maka sinkronisasi eksternal tidak diperlukan.
     * 
     * Jika Anda memiliki aplikasi yang berjalan dalam beberapa contoh pada satu
     * sistem dan oleh karena itu Preferensi akses
     * perlu dikoordinasikan antara JVM di sistem, maka metode sync() dari node
     * Preferensi mana pun dapat digunakan untuk memastikan perubahan pada node
     * Preferensi terlihat oleh JVM lain di sistem:
     */

    /*
     * // Warning: don't use this if your application is intended
     * // to only run a single instance on a machine once
     * // (this is probably the case for most desktop applications)
     * try {
     * preferences.sync();
     * } catch (BackingStoreException e) {
     * // Deal with any errors while saving the preferences to the backing storage
     * e.printStackTrace();
     * }
     */

    public static void main(String[] args) {
        // Create a Preferences object for the user root node
        Preferences preferences = Preferences.userRoot().node("com.example.myapp");

        // Set some preferences
        preferences.put("username", "john_doe");
        preferences.put("language", "en_US");
        preferences.putInt("fontSize", 14);

        // Save the preferences to the backing storage
        try {
            preferences.sync();
            System.out.println("Preferences saved successfully");
        } catch (BackingStoreException e) {
            // Deal with any errors while saving the preferences to the backing storage
            e.printStackTrace();
        }

        // Retrieve and display the preferences
        String username = preferences.get("username", "default_username");
        String language = preferences.get("language", "default_language");
        int fontSize = preferences.getInt("fontSize", 12);

        System.out.println("Username: " + username);
        System.out.println("Language: " + language);
        System.out.println("Font Size: " + fontSize);
        /*
         * output:
         * Preferences saved successfully
         * Username: john_doe
         * Language: en_US
         * Font Size: 14
         */

    }
}
