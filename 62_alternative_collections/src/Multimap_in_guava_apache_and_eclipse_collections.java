import java.util.*;

public class Multimap_in_guava_apache_and_eclipse_collections {
    // Multimap in Guava, Apache and Eclipse Collections / Multimap di Koleksi
    // Guava, Apache dan Eclipse

    /*
     * Multimap ini memungkinkan duplikat pasangan nilai kunci. Analog JDK adalah
     * HashMap<K, List>, HashMap<K, Set> dan seterusnya.
     * 
     * Key's order | Value's order
     * not defined | Insertion-order
     * not defined | not defined
     * not defined | sorted
     * Insertion-order | Insertion-order
     * Insertion-order | Insertion-order
     * sorted | sorted
     * 
     */

    /*
     * Duplicate | Analog key
     * yes | HashMap
     * no | HashMap
     * no | HashMap
     * yes | LinkedHashMap
     * no | LinkedHashMap
     * no | TreeMap
     * 
     */

    /*
     * Analog value | Guava
     * ArrayList | ArrayListMultimap
     * HashSet | HashMultimap
     * TreeSet | Multimaps.newMultimap(HashMap, Supplier<TreeSet>)
     * ArrayList | LinkedListMultimap
     * LinkedHashSet | LinkedHashMultimap
     * TreeSet | TreeMultimap
     * 
     */

    /*
     * Apache | Eclipse (GS) COllections
     * MultiValueMap | FastListMultimap
     * MultiValueMap. | UnifiedSetMultimap
     * multiValueMap( new
     * HashMap<K, Set>(),
     * HashSet.class);
     * MultiValueMap.multiValueMap( | TreeSortedSetMultimap
     * new HashMap<K, Set>(),
     * TreeSet.class)
     * MultiValueMap.
     * multiValueMap(new
     * LinkedHashMap<K, List>(),
     * ArrayList.class);
     * MultiValueMap.
     * multiValueMap(new
     * LinkedHashMap<K, Set>(),
     * LinkedHashSet.class)
     * MultiValueMap.
     * multiValueMap( new
     * TreeMap<K,
     * Set>(),TreeSet.class)
     * 
     */

    /*
     * JDK
     * HashMap<K,
     * ArrayList<V>>
     * HashMap<K,
     * HashSet<V>>
     * HashMap<K,
     * TreeSet<V>>
     * LinkedHashMap<
     * K, ArrayList>
     * LinkedHashMap<K,
     * LinkedHashSet<V>>
     * TreeMap<K,
     * TreeSet<V>>
     * 
     * 
     */

    // Contoh menggunakan Multimap

    /*
     * Tugas: Mengurai "Halo Dunia! Halo Semua! Hai Dunia!" string untuk memisahkan
     * kata dan mencetak semua indeks dari setiap kata yang digunakan
     * MultiMap (misalnya, Hello=[0, 2], World!=[1, 5] dan seterusnya)
     */

    // 1. MultiValueMap from Apach

    /*
     * String INPUT_TEXT = "Hello World! Hello All! Hi World!";
     * // Parse text to words and index
     * List<String> words = Arrays.asList(INPUT_TEXT.split(" "));
     * // Create Multimap
     * MultiMap<String, Integer> multiMap = new MultiValueMap<String, Integer>();
     * // Fill Multimap
     * int i = 0;
     * for(String word: words) {
     * multiMap.put(word, i);
     * i++;
     * }
     * // Print all words
     * System.out.println(multiMap); // print {Hi=[4], Hello=[0, 2], World!=[1, 5],
     * All!=[3]} - in
     * random orders
     * // Print all unique words
     * System.out.println(multiMap.keySet()); // print [Hi, Hello, World!, All!] -
     * in random orders
     * // Print all indexes
     * System.out.println("Hello = " + multiMap.get("Hello")); // print [0, 2]
     * System.out.println("World = " + multiMap.get("World!")); // print [1, 5]
     * System.out.println("All = " + multiMap.get("All!")); // print [3]
     * System.out.println("Hi = " + multiMap.get("Hi")); // print [4]
     * System.out.println("Empty = " + multiMap.get("Empty")); // print null
     * // Print count unique words
     * System.out.println(multiMap.keySet().size()); //print 4
     */

    // 2. HashBiMap from GS / Eclipse Collection
    /*
     * String[] englishWords = {"one", "two", "three","ball","snow"};
     * String[] russianWords = {"jeden", "dwa", "trzy", "kula", "snieg"};
     * // Create Multiset
     * MutableBiMap<String, String> biMap = new HashBiMap(englishWords.length);
     * // Create English-Polish dictionary
     * int i = 0;
     * for(String englishWord: englishWords) {
     * biMap.put(englishWord, russianWords[i]);
     * i++;
     * }
     * // Print count words
     * System.out.println(biMap); // print {two=dwa, ball=kula, one=jeden,
     * snow=snieg, three=trzy} - in
     * random orders
     * // Print all unique words
     * System.out.println(biMap.keySet()); // print [snow, two, one, three, ball] -
     * in random orders
     * System.out.println(biMap.values()); // print [dwa, kula, jeden, snieg, trzy]
     * - in random
     * orders
     * // Print translate by words
     * System.out.println("one = " + biMap.get("one")); // print one = jeden
     * System.out.println("two = " + biMap.get("two")); // print two = dwa
     * System.out.println("kula = " + biMap.inverse().get("kula")); // print kula =
     * ball
     * System.out.println("snieg = " + biMap.inverse().get("snieg")); // print snieg
     * = snow
     * System.out.println("empty = " + biMap.get("empty")); // print empty = null
     * // Print count word's pair
     * System.out.println(biMap.size()); //print 5
     */

    // 3. HashMultiMap from Guava
    /*
     * String INPUT_TEXT = "Hello World! Hello All! Hi World!";
     * // Parse text to words and index
     * List<String> words = Arrays.asList(INPUT_TEXT.split(" "));
     * // Create Multimap
     * Multimap<String, Integer> multiMap = HashMultimap.create();
     * // Fill Multimap
     * int i = 0;
     * for(String word: words) {
     * multiMap.put(word, i);
     * i++;
     * }
     * // Print all words
     * System.out.println(multiMap); // print {Hi=[4], Hello=[0, 2], World!=[1, 5],
     * All!=[3]} - keys
     * and values in random orders
     * // Print all unique words
     * System.out.println(multiMap.keySet()); // print [Hi, Hello, World!, All!] -
     * in random
     * orders
     * // Print all indexes
     * System.out.println("Hello = " + multiMap.get("Hello")); // print [0, 2]
     * System.out.println("World = " + multiMap.get("World!")); // print [1, 5]
     * System.out.println("All = " + multiMap.get("All!")); // print [3]
     * System.out.println("Hi = " + multiMap.get("Hi")); // print [4]
     * System.out.println("Empty = " + multiMap.get("Empty")); // print []
     * // Print count all words
     * System.out.println(multiMap.size()); //print 6
     * // Print count unique words
     * System.out.println(multiMap.keySet().size()); //print 4
     */

    /*
     * Tidak ada contoh:
     * I.Koleksi Apache:
     * 1. Peta MultiNilai
     * 2. MultiValueMapLinked
     * 3. Pohon Peta MultiNilai
     * II. Koleksi GS / Eclipse
     * 1. Daftar CepatMultimap
     * 2. HashBagMultimap
     * 3. TreeSortedSetMultimap
     * 4. UnifiedSetMultimap
     * III. Jambu biji
     * 1. HashMultiMap
     * 2. LinkedHashMultimap
     * 3. LinkedListMultimap
     * 4. PohonMultipeta
     * 5. ArrayListMultimap
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        String INPUT_TEXT = "Hello World! Hello All! Hi World!";
        // Parse text to words and index
        List<String> words = Arrays.asList(INPUT_TEXT.split(" "));
        // Create Multimap
        // MultiMap<String, Integer> multiMap = new MultiValueMap<String, Integer>();
        // Fill Multimap
        int i = 0;
        // for (String word : words) {
        // multiMap.put(word, i);
        // i++;
        // }

        // Print all words
        // System.out.println(multiMap); // print {Hi=[4], Hello=[0, 2], World!=[1, 5],
        // All!=[3]} - in
        // random orders
        // Print all unique words
        // System.out.println(multiMap.keySet()); // print [Hi, Hello, World!, All!] -
        // in random orders
        // Print all indexes
        // System.out.println("Hello = " + multiMap.get("Hello")); // print [0, 2]
        // System.out.println("World = " + multiMap.get("World!")); // print [1, 5]
        // System.out.println("All = " + multiMap.get("All!")); // print [3]
        // System.out.println("Hi = " + multiMap.get("Hi")); // print [4]
        // System.out.println("Empty = " + multiMap.get("Empty")); // print null
        // Print count unique words

        // System.out.println(multiMap.keySet().size()); // print 4

    }
}
