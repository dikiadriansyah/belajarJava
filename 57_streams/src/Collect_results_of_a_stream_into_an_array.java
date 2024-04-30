import java.util.Arrays;
import java.util.List;

public class Collect_results_of_a_stream_into_an_array {
    // Collect Results of a Stream into an Array/Kumpulkan Hasil Aliran ke dalam
    // Array

    /*
     * Analog untuk mendapatkan koleksi Stream dengan collect() array dapat
     * diperoleh dengan metode Stream.toArray() :
     */

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "pear", "kiwi", "orange");
        String[] filteredFruits = fruits.stream()
                .filter(s -> s.contains("a"))
                .toArray(String[]::new);

        System.out.println(Arrays.toString(filteredFruits));
        // prints: [apple, banana, pear, orange]

        // String[]::new adalah jenis referensi metode khusus: referensi konstruktor.
    }
}
