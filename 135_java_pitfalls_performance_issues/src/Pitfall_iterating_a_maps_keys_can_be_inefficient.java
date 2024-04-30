import java.util.HashMap;
import java.util.Map;

public class Pitfall_iterating_a_maps_keys_can_be_inefficient {
    // Pitfall - Iterating a Map's keys can be inefficient/Kesalahan - Mengulangi
    // kunci Peta bisa jadi tidak efisien

    // Contoh kode berikut ini lebih lambat dari yang seharusnya:

    /*
     * Map<String, String> map = new HashMap<>();
     * for (String key : map.keySet()) {
     * String value = map.get(key);
     * // Do something with key and value
     * }
     */

    /*
     * Hal ini karena memerlukan pencarian peta (metode get()) untuk setiap kunci di
     * peta. Pencarian ini mungkin tidak efisien (dalam HashMap, ini memerlukan
     * pemanggilan hashCode pada kunci, lalu mencari keranjang yang benar dalam
     * struktur data internal, dan terkadang bahkan memanggil equals). Pada
     * peta yang besar, hal ini mungkin bukan masalah sepele.
     * 
     * Cara yang benar untuk menghindari hal ini adalah dengan mengulangi entri
     * peta, yang dirinci dalam topik Koleksi
     */

    public static void main(String[] args) throws Exception {
        // Membuat objek map
        Map<String, String> map = new HashMap<>();

        // Menambahkan elemen ke dalam map
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        // Melakukan iterasi melalui map
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
            // Lakukan sesuatu dengan key dan value
        }
        /*
         * output:
         * Key: key1, Value: value1
         * Key: key2, Value: value2
         * Key: key3, Value: value3
         */

    }
}
