public class Compare_operation_with_collections_create_collections {
    // Compare operation with collections - Create collections / Bandingkan operasi
    // dengan koleksi - Buat koleksi

    /*
     * Compare operation with collections - Create collections
     */

    // 1. create list
    // Description | JDK
    // Create empty list | new ArrayList<>()
    // Create list from values | Arrays.asList("1", "2","3")
    // Create list with capacity = 100 | new ArrayList<>(100)
    // Create list from any collectin | new ArrayList<>(collection)
    // Create list from any Iterable | -
    // Create list from Iterator | -
    // Create list from array | Arrays.asList(array)
    // Create list using factory | -

    /*
     * guava | gs-collections
     * Lists.newArrayList() | FastList.newList()
     * Lists.newArrayList("1", "2", "3") | FastList.newListWith("1",
     * "2", "3")
     * Lists.newArrayListWithCapacity(100) | FastList.newList(100)
     * Lists.newArrayList(collection) | FastList.newList(collection)
     * Lists.newArrayList(iterable) | FastList.newList(iterable)
     * Lists.newArrayList(iterator) | -
     * Lists.newArrayList(array) | FastList.newListWith(array)
     * - | FastList.newWithNValues(10,
     * () -> "1")
     */

    // Contoh:
    /*
     * System.out.println("createArrayList start");
     * // Create empty list
     * List<String> emptyGuava = Lists.newArrayList(); // using guava
     * List<String> emptyJDK = new ArrayList<>(); // using JDK
     * MutableList<String> emptyGS = FastList.newList(); // using gs
     * // Create list with 100 element
     * List < String > exactly100 = Lists.newArrayListWithCapacity(100); // using
     * guava
     * List<String> exactly100JDK = new ArrayList<>(100); // using JDK
     * MutableList<String> empty100GS = FastList.newList(100); // using gs
     * // Create list with about 100 element
     * List<String> approx100 = Lists.newArrayListWithExpectedSize(100); // using
     * guava
     * List<String> approx100JDK = new ArrayList<>(115); // using JDK
     * MutableList<String> approx100GS = FastList.newList(115); // using gs
     * // Create list with some elements
     * List<String> withElements = Lists.newArrayList("alpha", "beta", "gamma"); //
     * using guava
     * List<String> withElementsJDK = Arrays.asList("alpha", "beta", "gamma"); //
     * using JDK
     * MutableList<String> withElementsGS = FastList.newListWith("alpha", "beta",
     * "gamma"); // using gs
     * 
     * System.out.println(withElements);
     * System.out.println(withElementsJDK);
     * System.out.println(withElementsGS);
     * // Create list from any Iterable interface (any collection)
     * Collection<String> collection = new HashSet<>(3);
     * collection.add("1");
     * collection.add("2");
     * collection.add("3");
     * List<String> fromIterable = Lists.newArrayList(collection); // using guava
     * List<String> fromIterableJDK = new ArrayList<>(collection); // using JDK
     * MutableList<String> fromIterableGS = FastList.newList(collection); // using
     * gs
     * System.out.println(fromIterable);
     * System.out.println(fromIterableJDK);
     * System.out.println(fromIterableGS); // Attention: JDK create list only from
     * Collection, but guava and gs can create list from
     * Iterable and Collection
     * 
     * // Create list from any Iterator
     * Iterator<String> iterator = collection.iterator();
     * List<String> fromIterator = Lists.newArrayList(iterator); // using guava
     * System.out.println(fromIterator);
     * // Create list from any array
     * String[] array = {"4", "5", "6"};
     * List<String> fromArray = Lists.newArrayList(array); // using guava
     * List<String> fromArrayJDK = Arrays.asList(array); // using JDK
     * MutableList<String> fromArrayGS = FastList.newListWith(array); // using gs
     * System.out.println(fromArray);
     * System.out.println(fromArrayJDK);
     * System.out.println(fromArrayGS);
     * // Create list using fabric
     * MutableList<String> fromFabricGS = FastList.newWithNValues(10, () ->
     * String.valueOf(Math.random())); // using gs
     * System.out.println(fromFabricGS);
     * System.out.println("createArrayList end");
     * 
     */

    // 3. Create Map

    /*
     * Description | JDK
     * Create empty | new HashMap<>()
     * map
     * Create map | new HashMap<>(130)
     * with capacity
     * = 130
     * Create map | new HashMap<>(map)
     * from other
     * map
     * Create map | -
     * from keys
     * 
     * 
     */

    /*
     * guava | gs-collections
     * Maps.newHashMap() | UnifiedMap.newMap()
     * Maps.newHashMapWithExpectedSize(100) | UnifiedMap.newMap(130)
     * Maps.newHashMap(map) | UnifiedMap.newMap(map)
     * - | UnifiedMap.newWithKeysValues("1","a", "2", "b")
     * 
     */

    // contoh:
    /*
     * System.out.println("createHashMap start");
     * // Create empty map
     * Map<String, String> emptyGuava = Maps.newHashMap(); // using guava
     * Map<String, String> emptyJDK = new HashMap<>(); // using JDK
     * Map<String, String> emptyGS = UnifiedMap.newMap(); // using gs
     * // Create map with about 100 element
     * Map<String, String> approx100 = Maps.newHashMapWithExpectedSize(100); //
     * using guava
     * Map<String, String> approx100JDK = new HashMap<>(130); // using JDK
     * Map<String, String> approx100GS = UnifiedMap.newMap(130); // using gs
     * // Create map from another map
     * Map<String, String> map = new HashMap<>(3);
     * map.put("k1","v1");
     * map.put("k2","v2");
     * Map<String, String> withMap = Maps.newHashMap(map); // using guava
     * Map<String, String> withMapJDK = new HashMap<>(map); // using JDK
     * Map<String, String> withMapGS = UnifiedMap.newMap(map); // using gs
     * System.out.println(withMap);
     * System.out.println(withMapJDK);
     * System.out.println(withMapGS);
     * // Create map from keys
     * Map<String, String> withKeys = UnifiedMap.newWithKeysValues("1", "a", "2",
     * "b");
     * System.out.println(withKeys);
     * System.out.println("createHashMap end");
     */

    /*
     * More examples: CreateCollectionTest
     * 1. CollectionCompare
     * 2. CollectionSearch
     * 3. JavaTransform
     */

    public static void main(String[] args) throws Exception {
    }
}
