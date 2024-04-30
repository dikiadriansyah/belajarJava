import java.util.*;
import java.util.stream.Collectors;

public class Creating_a_list_from_an_existing_set {
    // Create a list from an existing Set

    public static void main(String[] args) {
        // Contoh listOfElements
        List<String> listOfElements = List.of("Apel", "Belimbing", "Ceri", "Delima");

        // Using a new List
        // List<String> list = new ArrayList<String>(listOfElements);
        // System.out.println(list); // [Apel, Belimbing, Ceri, Delima]

        // Using List.addAll() method
        Set<String> set = new HashSet<String>();
        set.add("Monitor");
        set.add("Cpu");

        // List<String> list2 = new ArrayList<String>();
        // list2.addAll(set);
        // System.out.println(list2); // [Monitor, Cpu]

        // Using Java 8 Steam API
        List<String> list3 = set.stream().collect(Collectors.toList());
        System.out.println(list3); // [Monitor, Cpu]
    }
}
