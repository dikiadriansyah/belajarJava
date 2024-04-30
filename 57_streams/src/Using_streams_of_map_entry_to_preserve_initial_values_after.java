import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.AbstractMap;

public class Using_streams_of_map_entry_to_preserve_initial_values_after {
    // Using Streams of Map.Entry to Preserve Initial Values after
    // Mapping/Menggunakan Aliran Map.Entry untuk Mempertahankan Nilai Awal setelah
    // Pemetaan

    /*
     * Ketika Anda memiliki Aliran yang perlu dipetakan tetapi ingin mempertahankan
     * nilai awalnya juga, Anda dapat memetakan Aliran ke Map.Entry<K,V> menggunakan
     * metode utilitas seperti berikut:
     * public static <K, V> Function<K, Map.Entry<K, V>> entryMapper(Function<K, V>
     * mapper){
     * return (k)->new AbstractMap.SimpleEntry<>(k, mapper.apply(k));
     * }
     * 
     */

    // Kemudian Anda dapat menggunakan konverter Anda untuk memproses Aliran yang
    // memiliki akses ke nilai asli dan nilai yang dipetakan:

    /*
     * Set<K> mySet;
     * Function<K, V> transformer = SomeClass::transformerMethod;
     * Stream<Map.Entry<K, V>> entryStream = mySet.stream()
     * .map(entryMapper(transformer));
     */

    /*
     * Anda kemudian dapat melanjutkan memproses Stream itu seperti biasa. Hal ini
     * menghindari overhead pembuatan koleksi perantara.
     */

    public static void main(String[] args) {

        // Contoh penggunaan program
        Set<String> mySet = Set.of("apple", "banana", "orange");
        Function<String, Integer> transformer = Using_streams_of_map_entry_to_preserve_initial_values_after::transformerMethod;

        Stream<Map.Entry<String, Integer>> entryStream = mySet.stream()
                .map(entryMapper(transformer));

        entryStream.forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
        /*
         * output:
         * Key: apple, Value: 5
         * Key: banana, Value: 6
         * Key: orange, Value: 6
         */

    }

    public static <K, V> Function<K, Map.Entry<K, V>> entryMapper(Function<K, V> mapper) {
        return (k) -> new AbstractMap.SimpleEntry<>(k, mapper.apply(k));
    }

    public static Integer transformerMethod(String str) {
        return str.length(); // Contoh transformasi sederhana
    }

}
