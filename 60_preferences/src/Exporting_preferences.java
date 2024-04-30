public class Exporting_preferences {
    // Exporting preferences /Mengekspor preferensi

    /*
     * Node preferensi dapat diekspor ke dokumen XML yang mewakili node tersebut.
     * Pohon XML yang dihasilkan bisa berupa
     * diimpor lagi. Dokumen XML yang dihasilkan akan mengingat apakah itu diekspor
     * dari Preferensi pengguna atau sistem.
     * Untuk mengekspor satu node, namun bukan node turunannya:
     * 
     * Version ≥ Java SE 7
     * try (OutputStream os = ...) {
     * preferences.exportNode(os);
     * } catch (IOException ioe) {
     * // Exception whilst writing data to the OutputStream
     * ioe.printStackTrace();
     * } catch (BackingStoreException bse) {
     * // Exception whilst reading from the backing preferences store
     * bse.printStackTrace();
     * }
     * Version < Java SE 7
     * OutputStream os = null;
     * try {
     * os = ...;
     * preferences.exportSubtree(os);
     * } catch (IOException ioe) {
     * // Exception whilst writing data to the OutputStream
     * ioe.printStackTrace();
     * } catch (BackingStoreException bse) {
     * // Exception whilst reading from the backing preferences store
     * bse.printStackTrace();
     * } finally {
     * if (os != null) {
     * try {
     * os.close();
     * } catch (IOException ignored) {}
     * }
     * }
     * 
     */

    // Untuk mengekspor satu node dengan node turunannya:
    /*
     * Version ≥ Java SE 7
     * try (OutputStream os = ...) {
     * preferences.exportNode(os);
     * } catch (IOException ioe) {
     * // Exception whilst writing data to the OutputStream
     * ioe.printStackTrace();
     * } catch (BackingStoreException bse) {
     * // Exception whilst reading from the backing preferences store
     * bse.printStackTrace();
     * }
     * Version < Java SE 7
     * OutputStream os = null;
     * try {
     * os = ...;
     * preferences.exportSubtree(os);
     * } catch (IOException ioe) {
     * // Exception whilst writing data to the OutputStream
     * ioe.printStackTrace();
     * } catch (BackingStoreException bse) {
     * // Exception whilst reading from the backing preferences store
     * bse.printStackTrace();
     * } finally {
     * if (os != null) {
     * try {
     * os.close();
     * } catch (IOException ignored) {}
     * }
     * }
     * 
     */

    public static void main(String[] args) {
    }
}
