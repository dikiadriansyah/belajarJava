import java.util.*;;

public class Removing_elements_using_an_iterator {
    // Removing elements using an iterator/Menghapus elemen menggunakan iterator

    /*
     * Metode Iterator.remove() adalah metode opsional yang menghapus elemen yang
     * dikembalikan oleh panggilan sebelumnya
     * Iterator.berikutnya(). Misalnya, kode berikut mengisi daftar string dan
     * kemudian menghapus semua string kosong
     * 
     * List<String> names = new ArrayList<>();
     * names.add("name 1");
     * names.add("name 2");
     * names.add("");
     * names.add("name 3");
     * names.add("");
     * System.out.println("Old Size : " + names.size());
     * Iterator<String> it = names.iterator();
     * while (it.hasNext()) {
     * String el = it.next();
     * if (el.equals("")) {
     * it.remove();
     * }
     * }
     * System.out.println("New Size : " + names.size());
     */

    // hasil:
    /*
     * Old Size : 5
     * New Size : 3
     */

    /*
     * Perhatikan bahwa kode di atas adalah cara aman untuk menghapus elemen saat
     * mengulangi koleksi biasa. Jika sebaliknya, Anda upaya untuk menghapus elemen
     * dari koleksi seperti ini:
     * for (String el: names) {
     * if (el.equals("")) {
     * names.remove(el); // WRONG!
     * }
     * }
     */

    /*
     * koleksi tipikal (seperti ArrayList) yang menyediakan semantik iterator cepat
     * gagal kepada iterator akan memunculkan ConcurrentModificationException.
     * 
     * Metode remove() hanya dapat dipanggil (sekali) setelah panggilan
     * berikutnya().
     * Jika dipanggil sebelum memanggil next() atau jika dipanggil dua kali setelah
     * panggilan next(), maka panggilan remove() akan memunculkan
     * IllegalStateException.
     */

    /*
     * Operasi remove digambarkan sebagai operasi opsional; yaitu tidak semua
     * iterator mengizinkannya. Contoh yang tidak ada
     * didukung menyertakan iterator untuk koleksi yang tidak dapat diubah, tampilan
     * koleksi hanya-baca, atau koleksi berukuran tetap. Jika remove() dipanggil
     * ketika iterator tidak mendukung penghapusan, maka akan muncul
     * UnsupportedOperationException.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -------------------
        List<String> names = new ArrayList<>();
        names.add("name 1");
        names.add("name 2");
        names.add("");
        names.add("name 3");
        names.add("");
        System.out.println("Old Size : " + names.size());
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String el = it.next();
            if (el.equals("")) {
                it.remove();
            }
        }
        System.out.println("New Size : " + names.size());
        /*
         * output:
         * Old Size : 5
         * New Size : 3
         */
    }
}
