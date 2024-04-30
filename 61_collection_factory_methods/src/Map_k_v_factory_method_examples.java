import java.util.Map;

public class Map_k_v_factory_method_examples {
    // Map<K, V> Factory Method Examples

    /*
     * Map<Integer, Integer> immutableEmptyMap = Map.of();
     * Initializes an empty, immutable Map<Integer, Integer>.
     * Map<Integer, Integer> immutableMap = Map.of(1, 2, 3, 4);
     * Initializes an immutable Map<Integer, Integer> with two initial key-value
     * entries.
     * Map<Integer, Integer> immutableMap = Map.ofEntries(Map.entry(1, 2),
     * Map.entry(3, 4));
     * Initializes an immutable Map<Integer, Integer> with two initial key-value
     * entries.
     * Map<Integer, Integer> mutableMap = new HashMap<>(immutableMap);
     * Initializes a mutable Map<Integer, Integer> from an immutable Map<Integer,
     * Integer>.
     */

    public static void main(String[] args) throws Exception {
        // Membuat immutableMap menggunakan Map.of
        Map<Integer, Integer> immutableMap = Map.of(1, 2, 3, 4);

        // Menampilkan isi immutableMap
        System.out.println("Immutable Map: " + immutableMap); // Immutable Map: {3=4, 1=2}
    }
}
