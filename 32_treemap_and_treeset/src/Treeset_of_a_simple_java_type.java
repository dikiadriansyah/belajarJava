import java.util.TreeSet;
import java.util.*;

public class Treeset_of_a_simple_java_type {
    // TreeSet of a simple Java Type

    public static void main(String[] args) {
        /*
         * Pertama, kita membuat himpunan kosong, dan memasukkan beberapa elemen ke
         * dalamnya:
         */

        // Version ≥ Java SE 7
        // TreeSet<Integer> treeSet = new TreeSet<>();
        // Version < Java SE 7
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(10);
        treeSet.add(4);
        treeSet.add(1);
        treeSet.add(12);

        /*
         * Setelah kita memiliki beberapa elemen dalam kumpulan, kita dapat melakukan
         * beberapa operasi:
         */
        // System.out.println(treeSet.first());
        // 1

        // System.out.println(treeSet.last());
        // 12

        // System.out.println(treeSet.size());
        // 4, karena ada 4 elemen dalam himpunan

        // System.out.println(treeSet.contains(12));
        // true

        // System.out.println(treeSet.contains(15));
        // false

        /*
         * Kita juga dapat melakukan iterasi pada elemen map menggunakan Iterator atau
         * loop foreach. Perhatikan bahwa entri dicetak menurut urutan aslinya, bukan
         * urutan penyisipan:
         */

        // Version ≥ Java SE 7
        // for (Integer i : treeSet) {
        // System.out.print(i + " "); // prints 1 4 10 12
        // }
        // output: 1 4 10 12

        // Iterator<Integer> iter = treeSet.iterator();
        // while (iter.hasNext()) {
        // System.out.print(iter.next() + " "); // prints 1 4 10 12
        // }
        // 1 4 10 12

    }
}
