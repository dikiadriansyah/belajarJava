import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Get_a_slice_of_a_stream {
    // Get a Slice of a Stream / Dapatkan Sepotong Aliran

    /*
     * Contoh: Dapatkan Stream 30 elemen, berisi elemen koleksi ke-21 hingga ke-50
     * (inklusif).
     * 
     * final long n = 20L; // the number of elements to skip
     * final long maxSize = 30L; // the number of elements the stream should be
     * limited to
     * final Stream<T> slice = collection.stream().skip(n).limit(maxSize);
     */

    // Catatan:
    /*
     * 1. IllegalArgumentException dilempar jika n negatif atau maxSize negatif
     * 2. baik skip(long) dan limit(long) adalah operasi perantara
     * 3. jika aliran berisi kurang dari n elemen maka skip(n) mengembalikan
     * aliran kosong
     * 4. skip(long) dan limit(long) merupakan operasi yang murah pada pipeline
     * aliran sekuensial, namun bisa juga cukup mahal pada pipa paralel yang dipesan
     */

    public static void main(String[] args) {
        final long n = 20L; // the number of elements to skip
        final long maxSize = 30L; // the number of elements the stream should be limited to

        // Contoh koleksi (gantilah dengan koleksi yang sesuai)
        List<Integer> collection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36);

        Stream<Integer> slice = collection.stream().skip(n).limit(maxSize);

        // Menampilkan hasil
        List<Integer> result = slice.collect(Collectors.toList());
        System.out.println(result);
        /*
         * output:
         * [21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36]
         */
    }
}
