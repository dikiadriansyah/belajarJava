import java.util.*;

public class Basics_of_set {
    // Basics of Set
    /*
     * Apa itu Set?
     * Himpunan adalah struktur data yang berisi sekumpulan elemen dengan properti
     * penting yang tidak ada dua elemen dalam himpunan yang sama.
     * 
     * Types of Set:
     * 1. HashSet: A set backed by a hash table (actually a HashMap instance) / Satu
     * set yang didukung oleh tabel hash (sebenarnya merupakan instance HashMap)
     * 
     * 2. Linked HashSet: A Set backed by Hash table and linked list, with
     * predictable iteration order / Kumpulan yang didukung oleh tabel Hash dan
     * daftar tertaut, dengan urutan iterasi yang dapat diprediksi
     * 
     * 3. TreeSet: A NavigableSet implementation based on a TreeMap. / Implementasi
     * NavigableSet berdasarkan TreeMap.
     */

    public static void main(String[] args) {
        // Creating a set
        Set<Integer> set = new HashSet<Integer>(); // Creates an empty Set of Integers
        Set<Integer> linkedHashSet = new LinkedHashSet<Integer>(); // Creates a empty Set of Integers, with
        // predictable iteration order

        // Adding elements to a Set
        // Elemen dapat ditambahkan ke suatu set menggunakan metode add()
        set.add(12); // - Adds element 12 to the set
        set.add(13); // - Adds element 13 to the set

        // System.out.println("Hasil adalah: " + set); // Hasil adalah: [12,13]
        // Set kami setelah menjalankan metode ini:
        // set = [12,13];

        // Delete all the elements of a Set
        set.clear(); // Removes all objects from the collection.
        // System.out.println("Hasil adalah: " + set); // Hasil adalah: []

        // Setelah set ini akan menjadi:
        // set = []

        // Check whether an element is part of the Set
        // Keberadaan suatu elemen dalam himpunan dapat diperiksa menggunakan metode
        // contains()
        System.out.println(set.contains(0));// Returns true if a specified object is an element within
        // the set.

        // Output: False

        // Check whether a Set is empty
        /*
         * isEmpty() metode dapat digunakan untuk memeriksa apakah suatu Set kosong
         */
        // set.isEmpty(); // Returns true if the set has no elements
        // Output: True

        // Remove an element from the Set
        set.remove(0); // Removes first occurrence of a specified object from the collection

        // Check the Size of the Set
        set.size(); // Returns the number of elements in the collection
        // Output: 0
    }
}
