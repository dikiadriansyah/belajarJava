
// import org.apache.commons.collections4.IterableMap;
// import org.apache.commons.collections4.MapIterator;
// import org.apache.commons.collections4.map.HashedMap;
// import org.eclipse.collections.api.map.MutableMap;
// import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Iterating_map_entries_efficiently {
    // Iterating Map Entries Eciently

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        /*
         * Bagian ini menyediakan kode dan tolok ukur untuk sepuluh contoh implementasi
         * unik yang mengulangi entri Map<Integer, Integer> dan menghasilkan jumlah
         * nilai Integer. Semua contoh memiliki algorithmic complexity sebesar Θ(n),
         * namun tolok ukurnya tetap berguna untuk memberikan wawasan tentang
         * implementasi mana yang lebih efisien dalam lingkungan "dunia nyata".
         */

        // 1. Implementation menggunakan Iterator dengan Map.Entry
        // Inisialisasi map
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);

        // Inisialisasi sum
        int sum = 0;

        // Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        // while (it.hasNext()) {
        // Map.Entry<Integer, Integer> pair = it.next();
        // sum += pair.getKey() + pair.getValue();
        // }

        // System.out.println("Penjumlahan " + sum); // Penjumlahan 66

        // -----------------
        // 2. Implementation using for with Map.Entry
        // for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
        // sum += pair.getKey() + pair.getValue();
        // }
        // System.out.println("Penjumlahan " + sum); // Penjumlahan 66

        // 3. Implementation using Map.forEach (Java 8+)
        // Map<Integer, Integer> box1 = new HashMap<>();
        // box1.put(1, 10);
        // box1.put(2, 20);
        // box1.put(3, 30);

        // Inisialisasi sum sebagai array dengan satu elemen
        // final int[] box2 = { 0 };

        // Iterasi menggunakan forEach dan lambda expression
        // box1.forEach((k, v) -> box2[0] += k + v);

        // System.out.println("Penjumlahan: " + box2[0]); // Penjumlahan: 66

        // 4. Implementation using Map.keySet with for
        // for (Integer key : map.keySet()) {
        // sum += key + map.get(key);
        // }
        // System.out.println("Penjumlahan: " + sum); // Penjumlahan: 66

        // 5. Implementation using Map.keySet with Iterator
        // Iterator<Integer> it = map.keySet().iterator();
        // while (it.hasNext()) {
        // Integer key = it.next();
        // sum += key + map.get(key);
        // }
        // System.out.println(sum); // 66

        // 6. Implementation using for with Iterator and Map.Entry
        // for (Iterator<Map.Entry<Integer, Integer>> entries =
        // map.entrySet().iterator(); entries.hasNext();) {
        // Map.Entry<Integer, Integer> entry = entries.next();
        // sum += entry.getKey() + entry.getValue();
        // }
        // System.out.println(sum); // 66

        // 7. Implementation using Stream.forEach (Java 8+)

        // map.entrySet().stream().forEach(e -> sum += e.getKey() + e.getValue());
        // System.out.println(sum);

        // 8. Implementation using Stream.forEach with Stream.parallel (Java 8+)
        // map.entrySet()
        // .stream()
        // .parallel()
        // .forEach(e -> sum += e.getKey() + e.getValue());

        // 9. Implementation using IterableMap from Apache Collections
        // MapIterator<Integer, Integer> mit = iterableMap.mapIterator();
        // while (mit.hasNext()) {
        // sum += mit.next() + it.getValue();
        // }

        // 10. Implementation using MutableMap from Eclipse Collections
        // map.forEachKeyValue((key, value) -> {
        // sum += key + value;
        // });

        /*
         * Performance Tests (Code available on Github)
         */
    }
}
