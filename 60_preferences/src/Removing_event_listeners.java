import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

public class Removing_event_listeners {
    // Removing event listeners / Menghapus pendengar acara

    /*
     * Event Listener dapat dihapus lagi dari node Properties mana pun, namun
     * instance dari Listener harus tetap ada untuk itu.
     */

    /*
     * Version ≥ Java SE 8
     * Preferences preferences = Preferences.userNodeForPackage(getClass());
     * PreferenceChangeListener listener = evt -> {
     * System.out.println(evt.getKey() + " got new value " + evt.getNewValue());
     * };
     * preferences.addPreferenceChangeListener(listener);
     * //
     * // later...
     * //
     * preferences.removePreferenceChangeListener(listener);
     */

    /*
     * Version < Java SE 8
     * Preferences preferences = Preferences.userNodeForPackage(getClass());
     * PreferenceChangeListener listener = new PreferenceChangeListener() {
     * 
     * @Override
     * public void preferenceChange(PreferenceChangeEvent evt) {
     * System.out.println(evt.getKey() + " got new value " + evt.getNewValue());
     * }
     * };
     * preferences.addPreferenceChangeListener(listener);
     * //
     * // later...
     * //
     * preferences.removePreferenceChangeListener(listener);
     * 
     */

    // Hal yang sama berlaku untuk NodeChangeListener.

    public static void main(String[] args) {
        // Membuat objek Preferences untuk node pengguna yang terkait dengan kelas saat
        // ini
        Preferences preferences = Preferences.userNodeForPackage(Removing_event_listeners.class);

        // Membuat objek listener untuk mendengarkan perubahan preferensi
        PreferenceChangeListener listener = evt -> {
            System.out.println(evt.getKey() + " got new value " + evt.getNewValue());
        };

        // Menambahkan listener ke preferensi
        preferences.addPreferenceChangeListener(listener);

        // Simulasi perubahan preferensi (contoh)
        preferences.put("exampleKey", "exampleValue");

        // Memberi waktu untuk melihat output sebelum menghapus listener
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Menghapus listener dari preferensi
        preferences.removePreferenceChangeListener(listener);

        /*
         * output:
         * exampleKey got new value exampleValue
         */

    }
}
