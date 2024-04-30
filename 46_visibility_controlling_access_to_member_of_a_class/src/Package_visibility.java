public class Package_visibility {
    // Package Visibility/ Visibilitas Paket

    /*
     * Tanpa pengubah, defaultnya adalah visibilitas paket. Dari Dokumentasi Java,
     * "[visibilitas paket] menunjukkan apakah kelas dalam paket yang sama dengan kelas tersebut (terlepas dari asal usulnya) memiliki akses ke anggota."
     * Dalam contoh ini dari javax.swing,
     * 
     * package javax.swing;
     * public abstract class JComponent extends Container … {
     * …
     * static boolean DEBUG_GRAPHICS_LOADED;
     * …
     * }
     * 
     * 
     */

    // DebugGraphics ada dalam paket yang sama, sehingga DEBUG_GRAPHICS_LOADED dapat
    // diakses.

    /*
     * package javax.swing;
     * public class DebugGraphics extends Graphics {
     * …
     * static {
     * JComponent.DEBUG_GRAPHICS_LOADED = true;
     * }
     * …
     * }
     */

    // Artikel ini memberikan beberapa latar belakang tentang topik tersebut

    public static void main(String[] args) {
    }
}
