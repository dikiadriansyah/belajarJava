import java.util.HashMap;
import java.util.Map;

public class Using_default_methods_of_map_from_java8 {
    // Using Default Methods of Map from Java 8

    public static void main(String[] args) {
        /*
         * Contoh penggunaan Metode Default yang diperkenalkan di Java 8 pada Map
         * interface
         * 
         */

        // 1. Using getOrDefault
        /*
         * Mengembalikan nilai yang dipetakan ke kunci, atau jika kunci tidak ada,
         * mengembalikan nilai default
         */
        // Map<Integer, String> map = new HashMap<>();
        // map.put(1, "First element");
        // map.get(1); // => First element
        // map.get(2); // => null
        // map.getOrDefault(2, "Default element"); // => Default element
        // System.out.println("Nilai default untuk kunci 2: " + map);
        /*
         * output:
         * Nilai default untuk kunci 2: {1=First element}
         */

        // 2. Using forEach
        /*
         * Memungkinkan untuk melakukan operasi yang ditentukan dalam 'tindakan' pada
         * setiap Entry Map
         */
        // Map<Integer, String> map = new HashMap<Integer, String>();
        // map.put(1, "one");
        // map.put(2, "two");
        // map.put(3, "three");
        // map.forEach((key, value) -> System.out.println("Key: " + key + " :: Value: "
        // + value));
        /*
         * output:
         * Key: 1 :: Value: one
         * Key: 2 :: Value: two
         * Key: 3 :: Value: three
         */

        // 3. Using replaceAll
        // Akan diganti dengan nilai baru hanya jika kunci ada
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("john", 20);
        // map.put("paul", 30);
        // map.put("peter", 40);
        // map.replaceAll((key, value) -> value + 10); // {john=30, paul=40, peter=50}
        // System.out.println(map);
        /*
         * output:
         * {peter=50, john=30, paul=40}
         */

        // 4. Using putIfAbsent
        /*
         * Pasangan Nilai-Kunci ditambahkan ke map, jika kunci tidak ada atau dipetakan
         * ke null
         */
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("john", 20);
        // map.put("paul", 30);
        // map.put("peter", 40);
        // map.putIfAbsent("kelly", 50); // {john=20, paul=30, peter=40, kelly=50}
        // System.out.println(map);
        /*
         * output:
         * {peter=40, john=20, paul=30, kelly=50}
         */

        // 5. Using remove
        // Menghapus kunci hanya jika dikaitkan dengan nilai yang diberikan
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("john", 20);
        // map.put("paul", 30);
        // map.put("peter", 40);
        // map.remove("peter", 40); // {john=30, paul=40}
        // System.out.println(map);
        /*
         * output:
         * {john=20, paul=30}
         */

        // 6. Using replace
        /*
         * Jika kuncinya ada maka nilainya diganti dengan nilai baru. Jika kuncinya
         * tidak ada, tidak melakukan apa pun.
         */
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("john", 20);
        // map.put("paul", 30);
        // map.put("peter", 40);
        // map.replace("peter", 50); // {john=20, paul=30, peter=50}
        // map.replace("jack", 60); // {john=20, paul=30, peter=50}
        // System.out.println(map);
        /*
         * output:
         * {peter=50, john=20, paul=30}
         */

        // 7. Using computeIfAbsent
        // Metode ini menambahkan entri di Peta. kuncinya ditentukan dalam fungsi dan
        // nilainya merupakan hasil penerapan fungsi pemetaan
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("john", 20);
        // map.put("paul", 30);
        // map.put("peter", 40);
        // map.computeIfAbsent("kelly", k -> map.get("john") + 10); // {john=20,
        // paul=30, peter=40, kelly=30}
        // map.computeIfAbsent("peter", k -> map.get("john") + 10); // {john=20,
        // paul=30, peter=40, kelly=30}
        // peter already present
        // System.out.println(map);
        /*
         * {peter=40, john=20, kelly=30, paul=30}
         */

        // 8. Using computeIfPresent
        /*
         * Metode ini menambahkan entri atau memodifikasi entri yang ada di Peta. Tidak
         * melakukan apa pun jika entri dengan kunci itu tidak ada
         */
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("john", 20);
        // map.put("paul", 30);
        // map.put("peter", 40);
        // map.computeIfPresent("kelly", (k, v) -> v + 10); // {john=20, paul=30,
        // peter=40} //kelly not present
        // map.computeIfPresent("peter", (k, v) -> v + 10); // {john=20, paul=30,
        // peter=50} // peter present, so
        // increase the value
        // System.out.println(map);
        /*
         * output:
         * {peter=50, john=20, paul=30}
         */

        // 9. Using compute
        /*
         * Metode ini menggantikan nilai kunci dengan nilai yang baru dihitung
         */
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("john", 20);
        // map.put("paul", 30);
        // map.put("peter", 40);
        // map.compute("peter", (k, v) -> v + 50); // {john=20, paul=30, peter=90}
        // //Increase the value
        // System.out.println(map);
        /*
         * output:
         * {peter=90, john=20, paul=30}
         */

        // 10. Using merge
        /*
         * Menambahkan pasangan kunci-nilai ke peta, jika kunci tidak ada atau nilai
         * kunci adalah null Menggantikan nilai dengan nilai yang baru dihitung, jika
         * kunci ada Kunci dihapus dari peta, jika nilai baru yang dihitung adalah nol
         */
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // map.put("john", 20);
        // map.put("paul", 30);
        // map.put("peter", 40);

        // Adds the key-value pair to the map, if key is not present or value for the
        // key is null
        // map.merge("kelly", 50, (k, v) -> map.get("john") + 10); // {john=20, paul=30,
        // peter=40, kelly=50}

        // Replaces the value with the newly computed value, if the key is present
        // map.merge("peter", 50, (k, v) -> map.get("john") + 10); // {john=20, paul=30,
        // peter=30, kelly=50}

        // Key is removed from the map , if new value computed is null
        // map.merge("peter", 30, (k, v) -> map.get("nancy")); // {john=20, paul=30,
        // kelly=50}
        // System.out.println(map);
        /*
         * output:
         * {john=20, kelly=50, paul=30}
         */
    }
}
