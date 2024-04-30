import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Removing_items_from_a_list_whitin_a_loop {
    // Removing items from a List within a loop
    /*
     * Sulit untuk menghapus item dari daftar saat berada dalam satu lingkaran, hal
     * ini disebabkan oleh fakta bahwa indeks dan panjang daftar berubah.
     * 
     * Berdasarkan daftar berikut, berikut adalah beberapa contoh yang akan
     * memberikan hasil yang tidak diharapkan dan beberapa akan memberikan hasil
     * yang benar.
     */
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        List<String> fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");
        // System.out.println(fruits); // [Apple, Banana, Strawberry]

        // INCORRECT
        // Removing in iteration of for statement Skips "Banana"(Menghapus iterasi untuk
        // pernyataan Lewati "Pisang"):
        /*
         * Contoh kode hanya akan mencetak Apple dan Strawberry. Pisang dilewati karena
         * berpindah ke indeks 0 setelah Apple dihapus, tetapi pada saat yang sama i
         * bertambah menjadi 1.
         */

        for (int i = 0; i < fruits.size(); i++) {
            // System.out.println(fruits.get(i));
            if ("Apple".equals(fruits.get(i))) {
                fruits.remove(i);
            }
        }
        /*
         * output:
         * Apple
         * Strawberry
         */

        // Removing in the enhanced for statement Throws Exception(Menghapus
        // Pengecualian Throws yang disempurnakan untuk pernyataan):
        /*
         * Karena mengulangi pengumpulan dan memodifikasinya pada saat yang bersamaan.
         * Throws: java.util.ConcurrentModificationException
         */
        for (String fruit : fruits) {
            // System.out.println(fruit);
            if ("Apple".equals(fruit)) {
                fruits.remove(fruit);
            }
        }
        /*
         * output:
         * Banana
         * Strawberry
         */

        // CORRECT
        // Removing in while loop using an Iterator(Menghapus loop while menggunakan
        // Iterator)
        Iterator<String> fruitIterator = fruits.iterator();
        while (fruitIterator.hasNext()) {
            String fruit = fruitIterator.next();
            // System.out.println(fruit);
            if ("Apple".equals(fruit)) {
                fruitIterator.remove();
            }
        }
        /*
         * output:
         * Banana
         * Strawberry
         */

        /*
         * interface Iterator memiliki metode hapus() yang dibuat khusus untuk kasus
         * ini. Namun, metode ini ditandai sebagai "opsional" dalam dokumentasi, dan
         * mungkin memunculkan UnsupportedOperationException.
         * Throws: UnsupportedOperationException - if the remove operation is not
         * supported by this iterator
         * 
         * Oleh karena itu, disarankan untuk memeriksa dokumentasi untuk memastikan
         * operasi ini didukung (dalam praktiknya, kecuali
         * koleksi tersebut merupakan koleksi yang tidak dapat diubah yang diperoleh
         * melalui perpustakaan pihak ketiga atau penggunaan salah satu dari
         * perpustakaan tersebut
         * Collections.unmodified...() metode, operasi ini hampir selalu didukung).
         * 
         * Saat menggunakan Iterator, ConcurrentModificationException dilemparkan ketika
         * modCount List diubah sejak Iterator dibuat. Hal ini bisa terjadi di thread
         * yang sama atau di aplikasi multi-thread yang berbagi daftar yang sama.
         * 
         * ModCount adalah variabel int yang menghitung berapa kali daftar ini
         * dimodifikasi secara struktural. Sebuah struktural
         * perubahan pada dasarnya berarti operasi add() atau remove() yang dipanggil
         * pada objek Koleksi (perubahan dilakukan oleh
         * Iterator tidak dihitung). Ketika Iterator dibuat, ia menyimpan modCount ini
         * dan pada setiap iterasi Daftar
         * memeriksa apakah modCount saat ini sama dengan dan kapan Iterator dibuat.
         * Jika ada perubahan pada modCount
         * nilai yang dilontarkannya ConcurrentModificationException
         */

        // Oleh karena itu untuk daftar yang dideklarasikan di atas, operasi seperti di
        // bawah ini tidak akan menimbulkan pengecualian apa pun:
        // Iterator<String> fruitIterator2 = fruits.iterator();
        // fruits.set(0, "Watermelon");
        // while (fruitIterator.hasNext()) {
        // System.out.println(fruitIterator.next());
        // }

        /*
         * Namun menambahkan elemen baru ke Daftar setelah menginisialisasi Iterator
         * akan memunculkan ConcurrentModificationException
         * 
         */

        // Iterator<String> fruitIterator3 = fruits.iterator();
        // fruits.add("Watermelon");
        // while (fruitIterator.hasNext()) {
        // System.out.println(fruitIterator.next()); // ConcurrentModificationException
        // // here
        // }

        // Iterating backwards
        // for (int i = (fruits.size() - 1); i >= 0; i--) {
        // System.out.println(fruits.get(i));
        // if ("Apple".equals(fruits.get(i))) {
        // fruits.remove(i);
        // }
        // }

        /*
         * Ini tidak melewatkan apa pun. Kelemahan dari pendekatan ini adalah
         * keluarannya terbalik. Namun, dalam kebanyakan kasus di mana Anda menghapus
         * item itu tidak masalah. Anda tidak boleh melakukan ini dengan LinkedList.
         */

        // Iterating forward, adjusting the loop index
        // for (int i = 0; i < fruits.size(); i++) {
        // System.out.println(fruits.get(i));
        // if ("Apple".equals(fruits.get(i))) {
        // fruits.remove(i);
        // i--;
        // }
        // }

        /*
         * Ini tidak melewatkan apa pun. Ketika elemen ke-i dihapus dari Daftar, elemen
         * tersebut awalnya diposisikan di
         * indeks i+1 menjadi elemen ke-i yang baru. Oleh karena itu, loop dapat
         * mengurangi i agar iterasi berikutnya dapat dilakukan
         * memproses elemen berikutnya, tanpa melewatkan.
         */

        // Using a "should-be-removed" list
        /*
         * ArrayList shouldBeRemoved = new ArrayList();
         * for (String str : currentArrayList) {
         * if (condition) {
         * shouldBeRemoved.add(str);
         * }
         * }
         * currentArrayList.removeAll(shouldBeRemoved);
         */

        /*
         * Solusi ini memungkinkan pengembang untuk memeriksa apakah elemen yang benar
         * dihapus dengan cara yang lebih bersih.
         */

        // Version ≥ Java SE 8

        /*
         * Di Java 8 alternatif berikut dimungkinkan. Ini lebih bersih dan lebih mudah
         * dilakukan jika pelepasan tidak harus dilakukan berulang-ulang.
         */

        // Filtering a Stream
        /*
         * List dapat dialirkan dan disaring. Filter yang tepat dapat digunakan untuk
         * menghilangkan semua elemen yang tidak diinginkan.
         */
        List<String> filteredList = fruits.stream().filter(p -> !"Apple".equals(p)).collect(Collectors.toList());
        // System.out.println(filteredList); // [Banana, strawberry]

        /*
         * Perhatikan bahwa tidak seperti semua contoh lain di sini, contoh ini
         * menghasilkan instance new List dan menjaga List asli tidak berubah.
         */

        // Using removeIf
        /*
         * Menghemat overhead pembuatan aliran jika yang diperlukan hanyalah menghapus
         * sekumpulan item
         */
        fruits.removeIf(p -> "Apple".equals(p));
        System.out.println(filteredList); // [Banana, strawberry]

    }
}
