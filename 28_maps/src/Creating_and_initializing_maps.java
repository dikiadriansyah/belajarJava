import java.util.*;
import java.util.stream.Collectors;

public class Creating_and_initializing_maps {
    // Creating and Initializing Maps

    public static void main(String[] args) {
        /*
         * Perkenalan
         * Maps menyimpan pasangan kunci/nilai, di mana setiap kunci memiliki nilai
         * terkait. Dengan adanya kunci tertentu, peta dapat mencari nilai terkait
         * dengan sangat cepat.
         * 
         * Maps, juga dikenal sebagai array asosiasi, adalah objek yang menyimpan data
         * dalam bentuk kunci dan nilai. Di Java, peta direpresentasikan menggunakan
         * Map interface yang bukan merupakan perpanjangan dari collection interface.
         * 
         */

        // cara 1:
        /* J2SE < 5.0 */
        // Map map = new HashMap();
        // map.put("name", "A");
        // map.put("address", "Malviya-Nagar");
        // map.put("city", "Jaipur");
        // System.out.println(map);
        /*
         * output:
         * {address=Malviya-Nagar, city=Jaipur, name=A}
         */

        // cara 2:
        /* J2SE 5.0+ style (use of generics): */
        // Map<String, Object> map = new HashMap<>();
        // map.put("name", "A");
        // map.put("address", "Malviya-Nagar");
        // map.put("city", "Jaipur");
        // System.out.println(map);
        /*
         * {address=Malviya-Nagar, city=Jaipur, name=A}
         */

        // cara 3:
        // Map<String, Object> map = new HashMap<String, Object>() {
        // {
        // put("name", "A");
        // put("address", "Malviya-Nagar");
        // put("city", "Jaipur");
        // }
        // };
        // System.out.println(map);
        /*
         * {address=Malviya-Nagar, city=Jaipur, name=A}
         */

        // cara 4:
        // Map<String, Object> map = new TreeMap<String, Object>();
        // map.put("name", "A");
        // map.put("address", "Malviya-Nagar");
        // map.put("city", "Jaipur");
        // System.out.println(map);
        /*
         * output:
         * {address=Malviya-Nagar, city=Jaipur, name=A}
         */

        // cara 5:
        // Java 8
        // final Map<String, String> map = Arrays.stream(new String[][] {
        // { "name", "A" },
        // { "address", "Malviya-Nagar" },
        // { "city", "jaipur" },
        // }).collect(Collectors.toMap(m -> m[0], m -> m[1]));
        // System.out.println(map);
        /*
         * {address=Malviya-Nagar, city=jaipur, name=A}
         */

        // cara 6:
        // map.forEach((key, value) -> System.out.println(key + " -> " + value));
        /*
         * output:
         * box1 -> belimbing
         * box2 -> delima
         */

        // cara 7: Membuat peta nilai kunci tunggal yang tidak dapat diubah.
        // Immutable single key-value map
        // Map<String, String> singletonMap = Collections.singletonMap("key", "value");

        // Harap dicatat, bahwa tidak mungkin mengubah peta tersebut.

        // Setiap upaya untuk mengubah peta akan menghasilkan
        // UnsupportedOperationException.

        // Immutable single key-value pair
        // Map<String, String> singletonMap = Collections.singletonMap("key", "value");
        // singletonMap.put("newKey", "newValue"); // will throw
        // UnsupportedOperationException
        // singletonMap.putAll(new HashMap<>()); // will throw
        // UnsupportedOperationException
        // singletonMap.remove("key"); // will throw UnsupportedOperationException
        // singletonMap.replace("key", "value", "newValue"); // will throw
        // UnsupportedOperationException
        // // and etc
    }

    // This way for initial a map in outside the function
    // final static Map<String, String> map;
    // static {
    // map = new HashMap<String, String>();
    // map.put("box1", "belimbing");
    // map.put("box2", "delima");
    // }
}
