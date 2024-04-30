import java.util.ArrayList;
import java.util.Collection;

public class Pitfall_using_size_to_test_if_a_collection_is_empty_is_inefficient {
    // Pitfall - Using size() to test if a collection is empty is
    // inefficient/Kesalahan - Menggunakan size() untuk menguji apakah koleksi
    // kosong tidak efisien

    /*
     * Java Collections Framework menyediakan dua metode terkait untuk semua objek
     * Collection:
     * 1. size() mengembalikan jumlah entri dalam Collection, dan
     * 2. Metode isEmpty() mengembalikan nilai true jika (dan hanya jika) Collection
     * kosong.
     * 
     * Kedua metode tersebut dapat digunakan untuk menguji kekosongan koleksi.
     * Misalnya:
     * Collection<String> strings = new ArrayList<>();
     * boolean isEmpty_wrong = strings.size() == 0; // Avoid this
     * boolean isEmpty = strings.isEmpty(); // Best
     */

    /*
     * Meskipun pendekatan ini terlihat sama, beberapa implementasi koleksi tidak
     * menyimpan ukurannya. Untuk koleksi seperti itu, implementasi size() perlu
     * menghitung ukurannya setiap kali dipanggil. Contohnya:
     * 1. Kelas daftar tertaut sederhana (tetapi bukan java.util.LinkedList) mungkin
     * perlu melintasi daftar untuk menghitung elemen.
     * 2. Kelas ConcurrentHashMap perlu menjumlahkan entri di semua "segments" peta.
     * 3. Implementasi koleksi yang lambat mungkin perlu merealisasikan seluruh
     * koleksi dalam memori untuk menghitung elemennya.
     * 
     * Sebaliknya, metode isEmpty() hanya perlu menguji apakah ada setidaknya satu
     * elemen dalam koleksi. Ini tidak berarti menghitung unsur-unsurnya.
     * 
     * Meskipun size() == 0 tidak selalu kurang efisien dibandingkan isEmpty(), hal
     * ini tidak dapat dibayangkan jika diterapkan dengan benar
     * isEmpty() menjadi kurang efisien dibandingkan size() == 0. Oleh karena itu
     * isEmpty() lebih disukai
     */

    public static void main(String[] args) throws Exception {
        Collection<String> strings = new ArrayList<>();
        boolean isEmpty_wrong = strings.size() == 0; // Avoid this
        boolean isEmpty = strings.isEmpty(); // Best

        System.out.println("isEmpty_wrong: " + isEmpty_wrong); // Output: isEmpty_wrong: true
        System.out.println("isEmpty: " + isEmpty); // Output: isEmpty: true
    }
}
