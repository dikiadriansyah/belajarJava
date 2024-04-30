import java.util.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Iterator;

public class Treemap_of_a_simple_java_type {
    // TreeMap of a simple Java type
    /*
     * Pertama, kita membuat peta kosong, dan memasukkan beberapa elemen ke
     * dalamnya:
     */
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Version ≥ Java SE 7
        // TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Version < Java SE 7
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(10, "ten");
        treeMap.put(4, "four");
        treeMap.put(1, "one");
        treeMap.put(12, "twelve");

        // Setelah kita memiliki beberapa elemen di map, kita dapat melakukan beberapa
        // operasi:
        // System.out.println(treeMap.firstEntry());
        /*
         * output:
         * 1=one
         */

        // System.out.println(treeMap.lastEntry());
        /*
         * output:
         * 12=twelve
         */

        // System.out.println(treeMap.size());
        /*
         * output:
         * 4 karena ada 4 elemen di peta
         */

        // System.out.println(treeMap.get(12)); // twelve

        // System.out.println(treeMap.get(15));
        // null, karena kuncinya tidak ditemukan di peta

        /*
         * Kita juga dapat melakukan iterasi pada elemen peta menggunakan Iterator atau
         * loop foreach. Perhatikan bahwa entri dicetak menurut urutan aslinya, bukan
         * urutan penyisipan:
         */

        // Version ≥ Java SE 7
        for (Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.print(entry + " ");
            /*
             * output:
             * 1=one 4=four 10=ten 12=twelve
             */

        }
        Iterator<Entry<Integer, String>> iter = treeMap.entrySet().iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
            /*
             * output:
             * 1=one 4=four 10=ten 12=twelve
             */

        }

    }
}
