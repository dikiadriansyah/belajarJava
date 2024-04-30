import java.util.*;

public class Concepts_of_weakhashmap {
        // Concepts of WeakHashmap
        public static void main(String[] args) {
                // System.out.println("Hello, World!");
                /*
                 * Poin Penting:
                 * 1. Implementasi Map.
                 * 2. hanya menyimpan referensi lemah ke kuncinya.
                 */
                /*
                 * Referensi Lemah : Objek yang hanya direferensikan oleh referensi lemah adalah
                 * sampah yang dikumpulkan dengan penuh semangat; GC tidak akan menunggu sampai
                 * membutuhkan memori dalam hal ini
                 */
                /*
                 * Perbedaan antara Hashmap dan WeakHashMap:
                 * Jika manajer memori Java tidak lagi memiliki referensi kuat ke objek yang
                 * ditentukan sebagai kunci, maka entri di peta akan dihapus di WeakHashMap.
                 */

                HashMap hashMap = new HashMap();

                WeakHashMap weakHashMap = new WeakHashMap();

                String keyHashMap = new String("keyHashMap");
                String keyWeakHashMap = new String("keyWeakHashMap");

                hashMap.put(keyHashMap, "Ankita");
                weakHashMap.put(keyWeakHashMap, "Atul");
                System.gc();
                System.out.println("Sebelum: hash map nilai:" + hashMap.get("keyHashMap") +
                                " dan weak hash map nilai:" + weakHashMap.get("keyWeakHashMap"));

                /*
                 * output:
                 * Sebelum: hash map nilai:Ankita dan weak hash map nilai:Atul
                 */

                keyHashMap = null;
                keyWeakHashMap = null;

                System.gc();

                System.out.println("After: hash map nilai:" + hashMap.get("keyHashMap") +
                                " dan weak hash map nilai:" + weakHashMap.get("keyWeakHashMap"));
                /*
                 * output:
                 * Sesudah: hash map nilai:Ankita dan weak hash map nilai:null
                 */

                /*
                 * Size differences (HashMap vs WeakHashMap)/Perbedaan ukuran (HashMap vs
                 * WeakHashMap):
                 * Memanggil metode size() pada objek HashMap akan mengembalikan jumlah pasangan
                 * nilai kunci yang sama. ukuran akan berkurang hanya jika metode remove()
                 * dipanggil secara eksplisit pada objek HashMap.
                 * 
                 * Karena pengumpul sampah dapat membuang kunci kapan saja, WeakHashMap mungkin
                 * berperilaku seolah-olah tidak diketahui
                 * thread secara diam-diam menghapus entri. Jadi metode ukuran mungkin saja
                 * mengembalikan nilai yang lebih kecil seiring berjalannya waktu. Jadi, masuk
                 * Penurunan ukuran WeakHashMap terjadi secara otomatis
                 */

        }
}
