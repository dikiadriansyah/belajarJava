import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

public class Adding_event_listeners {
    // Adding event listeners/ Menambahkan pendengar acara

    /*
     * Ada dua jenis peristiwa yang dikeluarkan oleh objek Preferensi:
     * PreferenceChangeEvent dan NodeChangeEvent.
     */

    // PreferenceChangeEvent / PreferensiPerubahanAcara

    /*
     * PreferenceChangeEvent dipancarkan oleh objek Properties setiap kali salah
     * satu pasangan nilai kunci node berubah. PreferenceChangeEvents dapat disimak
     * dengan PreferenceChangeListener:
     * 
     * Version ≥ Java SE 8
     * preferences.addPreferenceChangeListener(evt -> {
     * String newValue = evt.getNewValue();
     * String changedPreferenceKey = evt.getKey();
     * Preferences changedNode = evt.getNode();
     * });
     * 
     * Version < Java SE 8
     * 
     * preferences.addPreferenceChangeListener(new PreferenceChangeListener() {
     * 
     * @Override
     * public void preferenceChange(PreferenceChangeEvent evt) {
     * String newValue = evt.getNewValue();
     * String changedPreferenceKey = evt.getKey();
     * Preferences changedNode = evt.getNode();
     * }
     * });
     */

    // Listener ini tidak akan mendengarkan perubahan pasangan nilai kunci dari node
    // anak.

    // NodeChangeEvent

    /*
     * Peristiwa ini akan dipicu setiap kali simpul anak dari simpul Properti
     * ditambahkan atau dihapus.
     */

    /*
     * preferences.addNodeChangeListener(new NodeChangeListener() {
     * 
     * @Override
     * public void childAdded(NodeChangeEvent evt) {
     * Preferences addedChild = evt.getChild();
     * Preferences parentOfAddedChild = evt.getParent();
     * }
     * 
     * @Override
     * public void childRemoved(NodeChangeEvent evt) {
     * Preferences removedChild = evt.getChild();
     * Preferences parentOfRemovedChild = evt.getParent();
     * }
     * });
     */

    public static void main(String[] args) {
        // Mendapatkan preferensi root
        Preferences preferences = Preferences.userRoot();

        // Menambahkan listener untuk mendengarkan perubahan preferensi
        preferences.addPreferenceChangeListener(new MyPreferenceChangeListener());

        // Simulasi perubahan preferensi
        preferences.put("exampleKey", "Nilai Awal");
        preferences.put("exampleKey", "Nilai Baru");
    }

    static class MyPreferenceChangeListener implements PreferenceChangeListener {
        @Override
        public void preferenceChange(PreferenceChangeEvent evt) {
            String newValue = evt.getNewValue();
            String changedPreferenceKey = evt.getKey();
            Preferences changedNode = evt.getNode();

            // Menanggapi perubahan preferensi
            System.out.println("Preference Key: " + changedPreferenceKey);
            System.out.println("New Value: " + newValue);
            System.out.println("Changed Node: " + changedNode);
            System.out.println("---------------------------");
        }
    }

}
