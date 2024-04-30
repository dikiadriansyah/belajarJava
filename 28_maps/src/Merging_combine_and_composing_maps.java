import java.util.*;

public class Merging_combine_and_composing_maps {
    // Merging, combine and composing Maps
    public static void main(String[] args) {
        /*
         * Gunakan putAll untuk menempatkan setiap anggota dari satu peta ke peta
         * lainnya. Kunci yang sudah ada di peta akan ditimpa nilainya.
         */

        // Map<String, Integer> box1 = new HashMap<>();
        // box1.put("Apel", 1);
        // box1.put("Belimbing", 3);

        // Map<String, Integer> box2 = new HashMap<>();
        // box2.put("Ceri", 2);
        // box2.put("Belimbing", 4);
        // box1.putAll(box2);

        // System.out.println(box1);
        /*
         * output:
         * {Ceri=2, Apel=1, Belimbing=4}
         */

        /*
         * Jika Anda ingin menggabungkan nilai alih-alih menimpanya, Anda bisa
         * menggunakan Map.merge, yang ditambahkan di Java 8, yang menggunakan
         * BiFunction yang disediakan pengguna untuk menggabungkan nilai kunci duplikat.
         * merge beroperasi pada kunci dan nilai individual, jadi Anda harus menggunakan
         * loop atau Map.forEach. Di sini kami menggabungkan string untuk kunci
         * duplikat:
         */

        // for (Map.Entry<String, Integer> e : box2.entrySet()) {
        // box1.merge(e.getKey(), e.getValue(), Integer::sum);
        // }

        // or instead of the above loop
        // box2.forEach((k, v) -> box1.merge(k, v, Integer::sum));

        // System.out.println(box1);
        /*
         * output:
         * {Ceri=4, Apel=1, Belimbing=8}
         */

        /*
         * Jika Anda ingin menerapkan batasan tidak ada kunci duplikat, Anda dapat
         * menggunakan fungsi penggabungan yang menampilkan AssertionError:
         * mapA.forEach((k, v) ->
         * mapB.merge(k, v, (v1, v2) ->
         * {throw new AssertionError("duplicate values for key: "+k);}));
         * 
         */

        // Composing Map<X,Y> and Map<Y,Z> to get Map<X,Z>
        /*
         * Jika Anda ingin membuat dua pemetaan, Anda dapat melakukannya sebagai berikut
         */
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("key1", 1);
        map1.put("key2", 2);
        map1.put("key3", 3);

        HashMap<Integer, Double> map2 = new HashMap<Integer, Double>();
        map2.put(1, 1.0);
        map2.put(2, 2.0);
        map2.put(3, 3.0);

        HashMap<String, Double> map3 = new HashMap<String, Double>();
        map1.forEach((key, value) -> map3.put(key, map2.get(value)));

        map3.forEach((key, value) -> System.out.println("\"" + key + "\"->" + value));
        /*
         * output:
         * "key1"->1.0
         * "key2"->2.0
         * "key3"->3.0
         */
    }
}
