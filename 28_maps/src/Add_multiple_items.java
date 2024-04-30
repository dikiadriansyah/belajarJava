import java.util.*;

public class Add_multiple_items {
    // Add multiple items
    public static void main(String[] args) {
        // Kita dapat menggunakan V put (kunci K, nilai V):
        /*
         * Kaitkan nilai yang ditentukan dengan kunci yang ditentukan di peta ini
         * (operasi opsional). Jika peta sebelumnya berisi pemetaan untuk kunci
         * tersebut, nilai lama diganti dengan nilai yang ditentukan
         */

        String currentVal;
        TreeMap<Integer, String> map = new TreeMap<>();
        currentVal = map.put(1, "First element.");
        // System.out.println(currentVal);// null

        currentVal = map.put(2, "Second element.");
        // System.out.println(currentVal); // null

        currentVal = map.put(2, "This will replace 'Second element'");
        // System.out.println(currentVal); // Second element.
        // System.out.println(map.size()); // 2

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(2, "Element 2");
        map2.put(3, "Element 3");
        map.putAll(map2);
        // System.out.println(map.size());
        /*
         * output:
         * 3
         */

        /*
         * Untuk menambahkan banyak item Anda dapat menggunakan kelas dalam seperti ini:
         */
        // Map<Integer, String> map3 = new HashMap<>() {
        // {
        // // This is now an anonymous inner class with an unnamed instance constructor
        // put(5, "high");
        // put(4, "low");
        // put(1, "too slow");
        // }
        // };
        // System.out.println(map3);
        /*
         * output:
         * {1=too slow, 4=low, 5=high}
         */

        /*
         * Ingatlah bahwa membuat kelas dalam anonim tidak selalu efisien dan dapat
         * menyebabkan kebocoran memori, jadi jika memungkinkan, gunakan blok
         * penginisialisasi sebagai gantinya:
         */

        // map4.forEach((key, value) -> System.out.println(key + "->" + value));
        /*
         * output:
         * 1->too slow
         * 4->low
         * 5->high
         */
    }

    // static Map<Integer, String> map4 = new HashMap<>();
    // static {
    // // Now no inner classes are created so we can avoid memory leaks
    // map4.put(5, "high");
    // map4.put(4, "low");
    // map4.put(1, "too slow");
    // }

}
