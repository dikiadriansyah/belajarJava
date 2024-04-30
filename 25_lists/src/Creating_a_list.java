import java.util.*;

public class Creating_a_list {
    // Creating a List

    public static void main(String[] args) {
        /*
         * Memberikan tipe pada daftar Anda
         * Untuk membuat daftar, Anda memerlukan tipe (kelas apa pun, misalnya String).
         * Ini adalah jenis List Anda. List hanya akan menyimpan objek dengan tipe
         * tertentu. Misalnya:
         * List<String> strings;
         */
        /*
         * Dapat menyimpan "string1", "hello world!", "goodbye", dll, namun tidak dapat
         * menyimpan 9.2, namun:
         * List<Double> doubles;
         * 
         */
        /*
         * Dapat menyimpan 9.2, tetapi tidak "halo dunia!".
         */

        // Initialising your list
        /*
         * Jika Anda mencoba menambahkan sesuatu ke daftar di atas, Anda akan
         * mendapatkan NullPointerException, karena string dan doubles keduanya sama
         * dengan null!
         */

        /*
         * Ada dua cara untuk menginisialisasi daftar:
         * Option 1: Use a class that implements List
         * List adalah sebuah antarmuka, artinya tidak memiliki konstruktor, melainkan
         * metode yang harus ditimpa oleh suatu kelas.
         * ArrayList adalah Daftar yang paling umum digunakan, meskipun LinkedList juga
         * umum. Jadi kami menginisialisasi daftar kami seperti ini:
         */
        List<String> strings = new ArrayList<String>();
        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        System.out.println(strings); // [Hello, World, Java]

        // atau
        List<String> strings2 = new LinkedList<String>();

        // Version ≥ Java SE 7
        // Mulai dari Java SE 7, Anda dapat menggunakan operator diamond:
        List<String> strings3 = new ArrayList<>();

        // atau
        List<String> strings4 = new LinkedList<>();

        // Option 2: Use the Collections class
        /*
         * Kelas Collections menyediakan dua metode yang berguna untuk membuat Daftar
         * tanpa variabel Daftar:
         * emptyList(): returns an empty list.
         * singletonList(T): creates a list of type T and adds the element specified.
         * 
         */
        /*
         * Dan metode yang menggunakan Daftar yang ada untuk mengisi data:
         */
        /*
         * addAll(L, T...): adds all the specified elements to the list passed as the
         * first parameter.
         * 
         */

        /*
         * Contoh:
         * import java.util.List; import java.util.Collections; List<Integer> l =
         * Collections.emptyList(); List<Integer> l1 =
         * Collections.singletonList(42); Collections.addAll(l1, 1, 2, 3);
         */

    }
}
