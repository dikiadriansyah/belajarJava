public class Apache_hashbag_guava_hashmultiset_and_eclipse_hashbag {
    // Apache HashBag, Guava HashMultiset and Eclipse HashBag

    /*
     * Tas/ultiset menyimpan setiap objek dalam koleksi bersama dengan jumlah
     * kemunculannya. Metode tambahan pada antarmuka memungkinkan banyak salinan
     * objek ditambahkan atau dihapus sekaligus. Analog JDK adalah HashMap<T,
     * Integer>, ketika nilai dihitung, salinan kunci ini
     */

    /*
     * Type | Guava
     * Order not | HashMultiset
     * defined
     * 
     * Sorted | TreeMultiset
     * 
     * Insertion-order | LinkedHashMultiset
     * 
     * Concurrent | ConcurrentHashMultiset
     * variant
     * 
     * Concurrent | -
     * and sorted
     * 
     * Immutable | ImmutableMultiset
     * collection
     * 
     * Immutable | ImmutableSortedMultiset
     * and sorted
     * 
     */

    /*
     * Apache Commons | GS Collections
     * Collections
     * 
     * HashBag | HashBag
     * 
     * TreeBag | TreeBag
     * 
     * - | -
     * 
     * SynchronizedBag | SynchronizedBag
     * 
     * SynchronizedSortedBag | SynchronizedSortedBag
     * 
     * UnmodifiableBag | UnmodifiableBag
     * 
     * UnmodifiableSortedBag | UnmodifiableSortedBag
     * 
     */

    /*
     * JDK
     * HashMap
     * 
     * TreeMap
     * 
     * LinkedHashMap
     * 
     * Collections.synchronizedMap(HashMap<String, Integer>)
     * 
     * Collections.synchronizedSortedMap(TreeMap<String, Integer>)
     * 
     * Collections.unmodifiableMap(HashMap<String, Integer)]
     * 
     * Collections.unmodifiableSortedMap(TreeMap<String,
     * Integer>)
     */

    // Contoh:
    // 1. Using SynchronizedSortedBag from Apache:
    /*
     * // Parse text to separate words
     * String INPUT_TEXT = "Hello World! Hello All! Hi World!";
     * // Create Multiset
     * Bag bag = SynchronizedSortedBag.synchronizedBag(new
     * TreeBag(Arrays.asList(INPUT_TEXT.split("
     * "))));
     * // Print count words
     * System.out.println(bag); // print [1:All!,2:Hello,1:Hi,2:World!]- in natural
     * (alphabet) order
     * // Print all unique words
     * System.out.println(bag.uniqueSet()); // print [All!, Hello, Hi, World!]- in
     * natural
     * (alphabet) order
     * // Print count occurrences of words
     * System.out.println("Hello = " + bag.getCount("Hello")); // print 2
     * System.out.println("World = " + bag.getCount("World!")); // print 2
     * System.out.println("All = " + bag.getCount("All!")); // print 1
     * System.out.println("Hi = " + bag.getCount("Hi")); // print 1
     * System.out.println("Empty = " + bag.getCount("Empty")); // print 0
     * // Print count all words
     * System.out.println(bag.size()); //print 6
     * // Print count unique words
     * System.out.println(bag.uniqueSet().size()); //print 4
     */

    // 2. Using TreeBag from Eclipse(GC)

    /*
     * // Parse text to separate words
     * String INPUT_TEXT = "Hello World! Hello All! Hi World!";
     * // Create Multiset
     * MutableSortedBag<String> bag =
     * TreeBag.newBag(Arrays.asList(INPUT_TEXT.split(" ")));
     * // Print count words
     * System.out.println(bag); // print [All!, Hello, Hello, Hi, World!, World!]-
     * in natural order
     * // Print all unique words
     * System.out.println(bag.toSortedSet()); // print [All!, Hello, Hi, World!]- in
     * natural order
     * // Print count occurrences of words
     * System.out.println("Hello = " + bag.occurrencesOf("Hello")); // print 2
     * System.out.println("World = " + bag.occurrencesOf("World!")); // print 2
     * System.out.println("All = " + bag.occurrencesOf("All!")); // print 1
     * System.out.println("Hi = " + bag.occurrencesOf("Hi")); // print 1
     * System.out.println("Empty = " + bag.occurrencesOf("Empty")); // print 0
     * // Print count all words
     * System.out.println(bag.size()); //print 6
     * // Print count unique words
     * System.out.println(bag.toSet().size()); //print 4
     * 
     */

    // 3. Using LinkedHashMultiset from Guava:
    /*
     * // Parse text to separate words
     * String INPUT_TEXT = "Hello World! Hello All! Hi World!";
     * // Create Multiset
     * Multiset<String> multiset =
     * LinkedHashMultiset.create(Arrays.asList(INPUT_TEXT.split(" ")));
     * // Print count words
     * System.out.println(multiset); // print [Hello x 2, World! x 2, All!, Hi]- in
     * predictable
     * iteration order
     * // Print all unique words
     * System.out.println(multiset.elementSet()); // print [Hello, World!, All!, Hi]
     * - in
     * predictable iteration order
     * // Print count occurrences of words
     * System.out.println("Hello = " + multiset.count("Hello")); // print 2
     * System.out.println("World = " + multiset.count("World!")); // print 2
     * System.out.println("All = " + multiset.count("All!")); // print 1
     * System.out.println("Hi = " + multiset.count("Hi")); // print 1
     * System.out.println("Empty = " + multiset.count("Empty")); // print 0
     * // Print count all words
     * System.out.println(multiset.size()); //print 6
     * // Print count unique words
     * System.out.println(multiset.elementSet().size()); //print 4
     */

    /*
     * Contoh:
     * I. Apache Collection:
     * 1. HashBag - order not defined
     * 2. SynchronizedBag - concurrent and order not defined
     * 3. SynchronizedSortedBag - - concurrent and sorted order
     * 4. TreeBag - sorted order
     * II. GS / Eclipse Collection
     * 5. MutableBag - order not defined
     * 6. MutableSortedBag - sorted order
     * III. Guava
     * 7. HashMultiset - order not defined
     * 8. TreeMultiset - sorted order
     * 9. LinkedHashMultiset - insertion order
     * 10. ConcurrentHashMultiset - concurrent and order not defined
     */

    public static void main(String[] args) throws Exception {

    }
}
