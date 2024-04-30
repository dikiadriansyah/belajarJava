import java.util.*;

public class Creating_adding_and_removing_element_from_an_arraylist {
    // Creating, Adding and Removing element from an ArrayList
    public static void main(String[] args) {
        /*
         * ArrayList adalah salah satu struktur data bawaan di Java. Ini adalah array
         * dinamis (di mana ukuran struktur data tidak perlu dideklarasikan terlebih
         * dahulu) untuk menyimpan elemen (Objek).
         * 
         * Ini memperluas kelas AbstrakList dan mengimplementasikan List interface.
         * ArrayList dapat berisi elemen duplikat yang mempertahankan urutan penyisipan.
         * Perlu dicatat bahwa kelas ArrayList tidak disinkronkan, jadi harus
         * berhati-hati saat menangani konkurensi dengan ArrayList. ArrayList
         * memungkinkan akses acak karena array bekerja berdasarkan indeks. Manipulasi
         * di ArrayList lambat karena pergeseran yang sering terjadi ketika sebuah
         * elemen dihapus dari daftar array.
         */

        // ArrayList dapat dibuat sebagai berikut:
        List<String> myArrayList = new ArrayList<>();

        // Dimana T ( Generics ) adalah tipe yang akan disimpan di dalam ArrayList.

        // Tipe ArrayList dapat berupa Objek apa saja. Tipenya tidak boleh tipe primitif
        // (sebagai gantinya gunakan kelas pembungkusnya).

        /*
         * Untuk menambahkan elemen ke ArrayList, gunakan metode add():
         */
        myArrayList.add("Element 1");

        int index = 1;
        String element = "New Element";

        // Atau untuk menambahkan item ke indeks tertentu:
        myArrayList.add(index, element); // index of the element should be an int (starting from 0)

        /*
         * Untuk menghapus item dari ArrayList, gunakan metode hapus():
         */

        /*
         * myArrayList.remove(element);
         */

        /*
         * Atau untuk menghapus item dari indeks tertentu
         */

        myArrayList.remove(index); // index of the element should be an int (starting from 0)

        System.out.println("ArrayList setelah menghapus elemen : " + myArrayList);
        /*
         * output:
         * ArrayList setelah menghapus elemen : [Element 1]
         */
    }
}
