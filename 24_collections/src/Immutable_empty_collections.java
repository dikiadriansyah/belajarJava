import java.util.*;;

public class Immutable_empty_collections {
    // Immutable Empty Collections

    public static void main(String[] args) {
        /*
         * Terkadang tepat untuk menggunakan koleksi kosong yang tidak dapat diubah.
         * Kelas Collections menyediakan metode untuk mendapatkan koleksi tersebut
         * dengan cara yang efisien:
         */
        List<String> anEmptyList = Collections.emptyList();
        System.out.println(anEmptyList);
        /*
         * output:
         * []
         */

        // Map<Integer, Date> anEmptyMap = Collections.emptyMap();
        // Set<Number> anEmptySet = Collections.emptySet();
        /*
         * Metode ini bersifat umum dan secara otomatis akan mengonversi koleksi yang
         * dikembalikan ke jenis yang ditetapkan. Yaitu, doa mis. emptyList() dapat
         * ditugaskan ke semua jenis List dan juga untuk emptySet() dan
         * emptyMap().
         * 
         * Koleksi yang dikembalikan oleh metode ini tidak dapat diubah karena akan
         * menampilkan UnsupportedOperationException
         * jika Anda mencoba memanggil metode yang akan mengubah isinya (add,
         * put, dll.). Koleksi-koleksi ini terutama
         * berguna sebagai pengganti hasil metode kosong atau nilai default lainnya,
         * daripada menggunakan null atau membuat objek
         * dengan yang new.
         */
    }
}
