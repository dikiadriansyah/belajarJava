import java.util.*;

public class Iterating_through_the_contents_of_a_map {
    // Iterating through the contents of a Map
    public static void main(String[] args) {
        /*
         * maps menyediakan metode yang memungkinkan Anda mengakses kunci, nilai, atau
         * pasangan nilai kunci maps sebagai koleksi. Anda dapat mengulangi koleksi ini.
         * Misalnya saja pada maps berikut:
         */

        HashMap<String, Integer> repMap = new HashMap<>();
        repMap.put("Jon Skeet", 927_654);
        repMap.put("BalusC", 708_826);
        repMap.put("Darin Dimitrov", 715_567);

        // Iterating through map keys:
        // for (String key : repMap.keySet()) {
        // System.out.println(key);
        // }
        /*
         * output:
         * BalusC
         * Jon Skeet
         * Darin Dimitrov
         */

        /*
         * keySet() menyediakan kunci peta sebagai Set. Set digunakan karena kunci tidak
         * boleh berisi nilai duplikat. Iterasi melalui set menghasilkan setiap kunci
         * secara bergantian. HashMaps tidak diurutkan, jadi dalam contoh ini kunci
         * dapat dikembalikan dalam urutan apa pun
         */

        // Iterating through map values:
        // for (Integer value : repMap.values()) {
        // System.out.println(value);
        // }
        /*
         * output:
         * 708826
         * 927654
         * 715567
         */

        /*
         * value() mengembalikan nilai peta sebagai Koleksi. Iterasi melalui koleksi
         * menghasilkan setiap nilai secara bergantian. Sekali lagi, nilai dapat
         * dikembalikan dalam urutan apa pun.
         */

        // Iterating through keys and values together
        // for (Map.Entry<String, Integer> entry : repMap.entrySet()) {
        // System.out.printf("%s = %d\n", entry.getKey(), entry.getValue());
        // }
        /*
         * output:
         * BalusC = 708826
         * Jon Skeet = 927654
         * Darin Dimitrov = 715567
         */

        // entrySet() mengembalikan koleksi objek Map.Entry. Map.Entry memberikan akses
        // ke kunci dan nilai untuk setiap entri.

    }
}
