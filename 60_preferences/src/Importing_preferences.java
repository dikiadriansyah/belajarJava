public class Importing_preferences {
    // Importing preferences /Mengimpor preferensi

    /*
     * Node preferensi dapat diimpor dari dokumen XML. Mengimpor dimaksudkan untuk
     * digunakan bersama dengan fungsi ekspor Preferences, karena ini membuat
     * dokumen XML terkait yang benar.
     * 
     * Dokumen XML akan mengingat apakah dokumen tersebut diekspor dari Preferensi
     * pengguna atau sistem. Karena itu,
     * mereka dapat diimpor lagi ke pohon Preferensi masing-masing, tanpa Anda harus
     * mencari tahu atau mengetahui dari mana asalnya. Fungsi statis akan secara
     * otomatis mengetahui apakah dokumen XML diekspor dari Preferensi pengguna atau
     * sistem dan secara otomatis akan mengimpornya ke pohon asal ekspornya.
     */

    /*
     * Version ≥ Java SE 7
     * try (InputStream is = ...) {
     * // This is a static call on the Preferences class
     * Preferences.importPreferences(is);
     * } catch (IOException ioe) {
     * // Exception whilst reading data from the InputStream
     * ioe.printStackTrace();
     * } catch (InvalidPreferencesFormatException ipfe) {
     * // Exception whilst parsing the XML document tree
     * ipfe.printStackTrace();
     * }
     * Version < Java SE 7
     * InputStream is = null;
     * try {
     * is = ...;
     * // This is a static call on the Preferences class
     * Preferences.importPreferences(is);
     * } catch (IOException ioe) {
     * // Exception whilst reading data from the InputStream
     * ioe.printStackTrace();
     * } catch (InvalidPreferencesFormatException ipfe) {
     * // Exception whilst parsing the XML document tree
     * ipfe.printStackTrace();
     * } finally {
     * if (is != null) {
     * try {
     * is.close();
     * } catch (IOException ignored) {}
     * }
     * }
     */

    public static void main(String[] args) {
    }

}
