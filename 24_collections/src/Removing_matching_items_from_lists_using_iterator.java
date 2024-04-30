import java.util.*;

public class Removing_matching_items_from_lists_using_iterator {
    // Removing matching items from Lists using Iterator(Menghapus item yang cocok
    // dari Daftar menggunakan Iterator)

    /*
     * Di atas saya melihat contoh untuk menghapus item dari Daftar dalam satu Loop
     * dan saya memikirkan contoh lain yang mungkin berguna kali ini menggunakan
     * Iterator interface.
     * Ini adalah demonstrasi trik yang mungkin berguna saat menangani item duplikat
     * dalam daftar yang ingin Anda hapus.
     */
    public static void main(String[] args) {
        /*
         * Catatan: Ini hanya menambahkan pada contoh Menghapus item dari Daftar dalam
         * satu lingkaran:
         * 
         * Jadi mari kita definisikan daftar kita seperti biasa
         */
        String[] names = { "James", "Smith", "Sonny", "Huckle", "Berry", "Finn", "Allan" };
        List<String> nameList = new ArrayList<>();

        // Create a List from an Array
        nameList.addAll(Arrays.asList(names));

        String[] removeNames = { "Sonny", "Huckle", "Berry" };
        List<String> removeNameList = new ArrayList<>();

        // Create a List from an Array
        removeNameList.addAll(Arrays.asList(removeNames));
        // System.out.println(removeNameList);
        /*
         * output:
         * [Sonny, Huckle, Berry]
         */

        /*
         * Metode berikut mengambil dua objek Koleksi dan melakukan keajaiban
         * menghilangkan elemen di dalamnya
         * removeNameList yang cocok dengan elemen di nameList.
         */

        // --------------------

        System.out.println("Array List before removing names: " + nameList);

        // Panggil metode removeNames untuk menghapus nama yang ada di removeNameList
        // dari nameList
        removeNames(nameList, removeNameList);

        // Tampilkan ArrayList setelah menghapus nama
        System.out.println("Array List after removing names: " + nameList);
    }

    private static void removeNames(Collection<String> collection1, Collection<String> collection2) {
        // get Iterator.
        Iterator<String> iterator = collection1.iterator();

        // Loop while collection has items
        while (iterator.hasNext()) {
            if (collection2.contains(iterator.next()))
                iterator.remove(); // remove the current Name or Item
        }
    }
    /*
     * Memanggil metode dan meneruskan nameList dan removeNameListas berikut ini
     * removeNames(nameList,removeNameList);
     * Akan menghasilkan keluaran sebagai berikut:
     * 
     * Array List before removing names: James Smith Sonny Huckle Berry Finn Allan
     * Array List after removing names: James Smith Finn Allan
     * 
     * Penggunaan sederhana yang rapi untuk Koleksi yang mungkin berguna untuk
     * menghapus elemen berulang dalam lists
     */
}
