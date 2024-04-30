import java.util.HashMap;
import java.util.Map;

public class Clear_the_map {
    // Clear the map

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apel");
        map.put(2, "Belimbing");
        map.put(3, "Delima");
        map.clear();
        System.out.println(map.size());
        // output: 0
    }
}
