import java.util.HashMap;
import java.util.Map;

public class Add_an_element {
    // Add an element

    public static void main(String[] args) {
        /*
         * 1. addition(tambahan)
         */
        // Map<Integer, String> map = new HashMap<>();
        // map.put(1, "CPU");
        // System.out.println(map.get(1));
        // output: CPU

        // 2. override
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(1, "Mouse");
        map2.put(1, "Motherboard");
        System.out.println(map2.get(1));
        /*
         * output:
         * Motherboard
         */

        // HashMap digunakan sebagai contoh. Implementasi lain yang mengimplementasikan
        // Map interface juga dapat digunakan
    }
}
