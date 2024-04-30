import java.util.*;

public class Types_and_usage_of_sets {
    // Types and Usage of Sets
    /*
     * Umumnya, set adalah jenis koleksi yang menyimpan nilai unik. Keunikan
     * ditentukan oleh metode equals() dan hashCode().
     */
    public static void main(String[] args) {
        // Penyortiran ditentukan oleh jenis himpunan.

        // HashSet - Random Sorting
        // versi > java se 7
        // Set<String> set = new HashSet<>();
        // set.add("Banana");
        // set.add("Banana");
        // set.add("Apple");
        // set.add("Strawberry");

        // System.out.println(set); // [Apple, Strawberry, Banana]

        // LinkedHashSet - Insertion Order
        // versi > java se 7
        // Set<String> set = new LinkedHashSet<>();
        // set.add("Banana");
        // set.add("Banana");
        // set.add("Apple");
        // set.add("Strawberry");
        // System.out.println(set); // [Banana, Apple, Strawberry]

        // TreeSet - By compareTo() or Comparator
        // versi > java se 7
        // Set<String> set = new TreeSet<>();
        // set.add("Banana");
        // set.add("Banana");
        // set.add("Apple");
        // set.add("Strawberry");
        // System.out.println(set); // [Apple, Banana, Strawberry]

        // versi > java se 7
        Set<String> set = new TreeSet<>((string1, string2) -> string2.compareTo(string1));
        set.add("Banana");
        set.add("Banana");
        set.add("Apple");
        set.add("Strawberry");
        System.out.println(set); // [Strawberry, Banana, Apple]
    }
}
