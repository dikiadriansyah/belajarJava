import java.util.*;

public class Creating_an_array_from_a_collection {
    // Creating an Array from a Collection
    /*
     * Dua metode di java.util.Collection membuat array dari koleksi:
     * Object[] toArray()
     * <T>T[] toArray(T[] a)
     * 
     * Object[] toArray() dapat digunakan sebagai berikut:
     * 
     */
    public static void main(String[] args) throws Exception {
        // Set<String> box1 = new HashSet<String>();
        // box1.add("Merah");
        // box1.add("Biru");
        // although set is a Set<String>, toArray() returns an Object[] not a String[]
        // Object[] objectArray = box1.toArray();
        // System.out.println(objectArray[1]); // merah

        // <T> T[] toArray(T[] a) dapat digunakan sebagai berikut:
        // versi > java se 5
        Set<String> box2 = new HashSet<String>();
        box2.add("Merah");
        box2.add("Biru");

        // Array tidak perlu dibuat terlebih dahulu dengan ukuran yang benar. Hanya tipe
        // array yang penting. (Jika ukurannya salah, array baru akan dibuat dengan tipe
        // yang sama.)
        String[] stringArray = box2.toArray(new String[0]);
        // Jika Anda menyediakan array dengan ukuran yang sama dengan koleksi atau lebih
        // besar, array tersebut akan diisi dengan nilai koleksi dan dikembalikan (array
        // baru tidak akan dialokasikan)

        // System.out.println(stringArray[1]); // Merah

        String[] stringArray2 = box2.toArray(new String[box2.size()]);
        System.out.println(stringArray2[1]); // Merah

        /*
         * Perbedaan di antara keduanya lebih dari sekedar hasil yang tidak diketik vs
         * diketik. Kinerjanya juga dapat berbeda (untuk detailnya silakan baca bagian
         * analisis kinerja ini):
         * 1. Object[] toArray() uses vectorized arraycopy, which is much faster than
         * the type-checked arraycopy used in T[] toArray(T[] a).
         * 2. T[] toArray(new T[non-zero-size]) needs to zero-out the array at runtime,
         * while T[] toArray(new T[0])
         * does not. Such avoidance makes the latter call faster than the former.
         * Detailed analysis here : Arrays of Wisdom of the Ancients.
         */

        // versi > java se 8
        /*
         * Mulai dari Java SE 8+, di mana konsep Stream telah diperkenalkan, Stream yang
         * dihasilkan oleh koleksi dapat digunakan untuk membuat Array baru menggunakan
         * metode Stream.toArray.
         */
        String[] strings = box2.stream().toArray(String[]::new);
        /*
         * Contoh diambil dari dua jawaban (1, 2) untuk Mengonversi 'ArrayList menjadi
         * 'String[]' di Java pada Stack Overflow.
         */
    }

}
