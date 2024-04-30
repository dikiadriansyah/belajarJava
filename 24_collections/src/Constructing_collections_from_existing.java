import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
// import org.apache.commons.lang3.ArrayUtils;

// import com.google.common.collect.Lists;
// import com.google.common.collect.Sets;

public class Constructing_collections_from_existing {
    // Constructing collections from existing data

    /*
     * Standard Collections
     * Java Collections framework
     * 
     * Cara sederhana untuk membuat List dari nilai data individual adalah dengan
     * menggunakan java.utils.Arrays metode Arrays.asList:
     * 
     */

    public static void main(String[] args) throws Exception {
        List<String> data = Arrays.asList("ab", "bc", "cd", "ab", "bc", "cd");
        // System.out.println("Berikut urutan: " + data); // Berikut urutan: [ab, bc,
        // cd, ab, bc, cd]

        /*
         * Semua implementasi koleksi standar menyediakan konstruktor yang menggunakan
         * koleksi lain sebagai argumen yang menambahkan semua elemen ke new collection
         * pada saat konstruksi:
         */
        List<String> list = new ArrayList<>(data); // will add data as is
        // System.out.println(list); // [ab, bc, cd, ab, bc, cd]

        Set<String> set1 = new HashSet<>(data); // will add data keeping only unique values
        // System.out.println(set1);
        /*
         * output:
         * [ab, bc, cd]
         */

        SortedSet<String> set2 = new TreeSet<>(data); // will add data keeping unique values and sorting
        // System.out.println(set2);// [ab,bc,cd]

        Set<String> set3 = new LinkedHashSet<>(data); // will add data keeping only unique values and
        // preserving the original order
        // System.out.println(set3); // [ab,bc,cd]

        // Google Guava Collections framework
        /*
         * Kerangka kerja hebat lainnya adalah Google Guava yang merupakan kelas
         * utilitas luar biasa (memberikan metode statis yang nyaman) untuk konstruksi
         * berbagai jenis standar collections Lists dan sets :
         */

        // List<String> list1 = Lists.newArrayList("ab", "bc", "cd");
        // List<String> list2 = Lists.newArrayList(data);
        // Set<String> set4 = Sets.newHashSet(data);
        // SortedSet<String> set5 = Sets.newTreeSet("bc", "cd", "ab", "bc", "cd");

        // --------------
        // Mapping Collections
        // Java Collections framework
        /*
         * Demikian pula untuk peta, dengan peta Map<String, Object>, new map dapat
         * dibuat dengan semua elemen sebagai berikut:
         */
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key3", "value3");
        map.put("key2", "value2");
        Map<String, Object> map1 = new HashMap<>(map);
        SortedMap<String, Object> map2 = new TreeMap<>(map);

        // System.out.println("Original Map: " + map);
        // System.out.println("Map 1: " + map1);
        // System.out.println("Map 2 (Sorted by Keys): " + map2);
        /*
         * output:
         * Original Map: {key1=value1, key2=value2, key3=value3}
         * Map 1: {key1=value1, key2=value2, key3=value3}
         * Map 2 (Sorted by Keys): {key1=value1, key2=value2, key3=value3}
         */

        // Apache Commons Collections framework
        // Menggunakan Apache Commons Anda dapat membuat Map menggunakan array di
        // ArrayUtils.toMap serta MapUtils.toMap:

        // Taken from org.apache.commons.lang.ArrayUtils#toMap JavaDoc
        // Create a Map mapping colors.
        // Map colorMap = MapUtils.toMap(new String[][] { {
        // { "RED", "#FF0000" },
        // { "GREEN", "#00FF00" },
        // { "BLUE", "#0000FF" }
        // } });

        /*
         * Setiap elemen array harus berupa Map.Entry atau Array, yang berisi setidaknya
         * dua elemen, dengan elemen pertama digunakan sebagai kunci dan elemen kedua
         * sebagai value.
         */

        // Google Guava Collections framework
        /*
         * Kelas utilitas dari kerangka Google Guava diberi nama Maps:
         */
        // void howToCreateMapsMethod(Function<? super K,V> valueFunction,
        // Iterable<K> keys1,
        // Set<K> keys2,
        // SortedSet<K> keys3) {
        // ImmutableMap<K, V> map1 = toMap(keys1, valueFunction); // Immutable copy
        // Map<K, V> map2 = asMap(keys2, valueFunction); // Live Map view
        // SortedMap<K, V> map3 = toMap(keys3, valueFunction); // Live Map view
        // }

        // using stream
        // Stream.of("xyz", "abc").collect(Collectors.toList());

        // atau
        // Arrays.stream("xyz", "abc").collect(Collectors.toList());
    }
}
