import java.util.*;

public class Inplace_replacement_of_a_list_element {
    // In-place replacement of a List element

    public static void main(String[] args) {
        /*
         * Contoh ini tentang mengganti elemen List sambil memastikan bahwa elemen
         * pengganti berada pada posisi yang sama dengan elemen yang diganti.
         */
        /*
         * Hal ini dapat dilakukan dengan menggunakan metode berikut:
         * set(int index, T type)
         * int indexOf(T type)
         */

        /*
         * Pertimbangkan ArrayList yang berisi elemen "Program dimulai!", "Halo dunia!"
         * dan "Selamat tinggal dunia!"
         */
        List<String> strings = new ArrayList<String>();
        strings.add("Program dimulai!");
        strings.add("Halo dunia!");
        strings.add("Selamat tinggal dunia!");

        /*
         * Jika kita mengetahui indeks elemen yang ingin kita ganti, kita cukup
         * menggunakan set sebagai berikut:
         */
        strings.set(1, "Hai dunia");

        /*
         * Jika kita belum mengetahui indeksnya, kita bisa mencarinya terlebih dahulu.
         * Misalnya:
         */
        int pos = strings.indexOf("Selamat tinggal dunia!");
        if (pos >= 0) {
            strings.set(pos, "Selamat tinggal dunia yang kejam!");
        }

        // System.out.println(pos);
        /*
         * output: 2
         */

        // System.out.println(strings);
        /*
         * output:
         * [Program dimulai!, Hai dunia, Selamat tinggal dunia yang kejam!]
         */

        // Tampilkan hasil
        for (String str : strings) {
            System.out.println(str);
        }
        /*
         * output:
         * Program dimulai!
         * Hai dunia
         * Selamat tinggal dunia yang kejam!
         */

        /*
         * Catatan:
         * 1. Operasi set tidak akan menyebabkan ConcurrentModificationException.
         * 2. Operasi set cepat ( O(1) ) untuk ArrayList tetapi lambat ( O(N) ) untuk
         * LinkedList.
         * 3. Pencarian indexOf pada ArrayList atau LinkedList lambat ( O(N) ).
         */
    }
}
