import java.util.HashMap;
import java.util.Map;

public class Check_if_key_exists {
    // Check if key exists

    public static void main(String[] args) {
        Map<String, String> num = new HashMap<>();
        num.put("Apel", "box1");
        if (num.containsKey("Apel")) {
            System.out.println(num.get("Apel"));
        }
        /*
         * output:
         * 
         * box1
         */

        // Maps can contain null values
        /*
         * Untuk maps, kita harus berhati-hati agar tidak bingung antara
         * "mengandung kunci" dengan "memiliki nilai". Misalnya, HashMaps
         * dapat berisi null yang berarti perilaku berikut ini normal:
         */

        // Map<String, String> map = new HashMap<>();
        // map.put("Apple", null);
        // if (map.containsKey("Apple")) {
        // System.out.println("This prints !"); // This line is reached
        // }

        // if (map.get("Apple") != null) {
        // System.out.println("This is never reached !"); // This line is never reached
        // }
        /*
         * output:
         * this prints
         */

        /*
         * Secara lebih formal, tidak ada jaminan bahwa map.contains(key) <=>
         * map.get(key)!=null
         */

    }
}
