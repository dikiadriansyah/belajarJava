import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
import java.util.stream.Collectors;

public class Flatten_Stream_with_flatMap {
    // Flatten Streams with flatMap() / Ratakan Aliran dengan flatMap()

    /*
     * Stream item yang dapat dialirkan dapat diratakan menjadi satu Stream
     * berkelanjutan:
     * Array Daftar Item dapat diubah menjadi Daftar tunggal.
     * 
     * List<String> list1 = Arrays.asList("one", "two");
     * List<String> list2 = Arrays.asList("three", "four", "five");
     * List<String> list3 = Arrays.asList("six");
     * List<String> finalList = Stream.of(list1, list2,
     * list3).flatMap(Collection::stream).collect(Collectors.toList());
     * System.out.println(finalList); // [one, two, three, four, five, six]
     */

    // Map yang berisi Daftar Item sebagai nilai dapat diratakan menjadi Daftar
    // Gabungan

    /*
     * Map<String, List<Integer>> map = new LinkedHashMap<>();
     * map.put("a", Arrays.asList(1, 2, 3));
     * map.put("b", Arrays.asList(4, 5, 6));
     * List<Integer> allValues = map.values() // Collection<List<Integer>>
     * .stream() // Stream<List<Integer>>
     * .flatMap(List::stream) // Stream<Integer>
     * .collect(Collectors.toList());
     * System.out.println(allValues);
     * // [1, 2, 3, 4, 5, 6]
     */

    // list Peta dapat diratakan menjadi satu stream yang berkesinambungan

    /*
     * List<Map<String, String>> list = new ArrayList<>();
     * Map<String,String> map1 = new HashMap();
     * map1.put("1", "one");
     * map1.put("2", "two");
     * Map<String,String> map2 = new HashMap();
     * map2.put("3", "three");
     * map2.put("4", "four");
     * list.add(map1);
     * list.add(map2);
     * Set<String> output= list.stream() // Stream<Map<String, String>>
     * .map(Map::values) // Stream<List<String>>
     * .flatMap(Collection::stream) // Stream<String>
     * .collect(Collectors.toSet()); //Set<String>
     * // [one, two, three,four]
     * 
     */

    public static void main(String[] args) {
        // List<String> list1 = Arrays.asList("one", "two");
        // List<String> list2 = Arrays.asList("three", "four", "five");
        // List<String> list3 = Arrays.asList("six");
        // List<String> finalList = Stream.of(list1, list2,
        // list3).flatMap(Collection::stream).collect(Collectors.toList());
        // System.out.println(finalList); // [one, two, three, four, five, six]
        // -----------------------------
        // Map<String, List<Integer>> map = new LinkedHashMap<>();
        // map.put("a", Arrays.asList(1, 2, 3));
        // map.put("b", Arrays.asList(4, 5, 6));
        // List<Integer> allValues = map.values() // Collection<List<Integer>>
        // .stream() // Stream<List<Integer>>
        // .flatMap(List::stream) // Stream<Integer>
        // .collect(Collectors.toList());
        // System.out.println(allValues); // [1,2,3,4,5,6]

        // ----------------------------------------
        // List<Map<String, String>> list = new ArrayList<>();
        // Map<String, String> map1 = new HashMap();
        // map1.put("1", "one");
        // map1.put("2", "two");
        // Map<String, String> map2 = new HashMap();
        // map2.put("3", "three");
        // map2.put("4", "four");
        // list.add(map1);
        // list.add(map2);
        // Set<String> output = list.stream() // Stream<Map<String, String>>
        // .map(Map::values) // Stream<List<String>>
        // .flatMap(Collection::stream) // Stream<String>
        // .collect(Collectors.toSet()); // Set<String>
        // // [one, two, three,four]

        // System.out.println(output); // output: [four, one, two, three]

    }
}
