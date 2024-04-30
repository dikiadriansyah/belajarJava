public class Pitfall_calling_new_string_is_inefficient {
    // Pitfall - Calling 'new String(String)' is inefficient/Kesalahan - Memanggil
    // 'String baru (String)' tidak efisien

    /*
     * Menggunakan new String(String) untuk menduplikasi string tidak efisien dan
     * hampir selalu tidak diperlukan.
     * 1. Objek string tidak dapat diubah, jadi tidak perlu menyalinnya untuk
     * melindunginya dari perubahan.
     * 2. Di beberapa versi Java yang lebih lama, objek String dapat berbagi array
     * pendukung dengan objek String lainnya. Dalam versi tersebut, dimungkinkan
     * untuk membocorkan memori dengan membuat substring (small) dari string (large)
     * dan menyimpannya.
     * Namun, mulai Java 7 dan seterusnya, array pendukung string tidak dibagikan.
     * 
     * Dengan tidak adanya manfaat nyata, memanggil new String(String) hanya akan
     * sia-sia:
     * 1. Membuat salinan membutuhkan waktu CPU.
     * 2. Salinan menggunakan lebih banyak memori yang meningkatkan jejak memoru
     * aplikasi dan/atau meningkatkan overhead GC.
     * 3. Operasi seperti same(Object) dan hashCode() bisa lebih lambat jika objek
     * String disalin.
     */

    public static void main(String[] args) throws Exception {
    }
}
