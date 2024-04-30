import java.util.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Declaring_a_hashset_with_values {
    // Declaring a HashSet with values
    /*
     * Anda dapat membuat kelas baru yang mewarisi HashSet:
     */
    public static void main(String[] args) {
        // Set<String> box1 = new HashSet<String>() {
        // {
        // add("apel");
        // add("belimbing");
        // }
        // };
        // System.out.println(box1); // [Belimbing, apel]

        // solusi satu baris:
        // Set<String> box2 = new HashSet<String>(Arrays.asList("apel", "belimbing"));
        // System.out.println(box2); // [belimbing, apel]

        // Menggunakan Guava:
        // Sets.newHashSet("a", "b", "c")

        // menggunakan Streams:
        Set<String> set3 = Stream.of("apel", "belimbing", "ceri").collect(Collectors.toSet());
        System.out.println(set3); // [ceri, belimbing, apel]
    }
}
