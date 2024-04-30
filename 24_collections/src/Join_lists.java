import java.util.*;
import java.util.stream.*;

public class Join_lists {
    // Join lists
    /*
     * Cara berikut dapat digunakan untuk menggabungkan daftar tanpa mengubah daftar
     * sumber.
     * 
     * Pendekatan pertama. Memiliki lebih banyak baris tetapi mudah dimengerti
     */
    public static void main(String[] args) {
        // List<String> newList = new ArrayList<String>();

        List<String> listOne = new ArrayList<String>();
        List<String> listTwo = new ArrayList<String>();

        listOne.add("Apple");
        listOne.add("Banana");
        listOne.add("Cherry");

        listTwo.add("Coconut");
        listTwo.add("star fruit");

        // newList.addAll(listOne);
        // newList.addAll(listTwo);

        // System.out.println("List favorite fruit: " + newList);
        /*
         * output:
         * List favorite fruit: [Apple, Banana, Cherry, Coconut, star fruit]
         */

        /*
         * Pendekatan kedua. Memiliki satu baris lebih sedikit tetapi kurang mudah
         * dibaca.
         */

        // List<String> newList = new ArrayList<String>(listOne);
        // newList.addAll(listTwo);
        // System.out.println("List favorite fruit: " + newList);
        /*
         * List favorite fruit: [Apple, Banana, Cherry, Coconut, star fruit]
         */

        /*
         * Pendekatan ketiga. Membutuhkan perpustakaan koleksi umum Apache pihak ketiga.
         */
        // ListUtils.union(listOne, listTwo);

        // Version ≥ Java SE 8
        // Menggunakan Streams, hal yang sama dapat dicapai dengan

        List<String> newList = Stream.concat(listOne.stream(),
                listTwo.stream()).collect(Collectors.toList());
        System.out.println("List favorite fruit: " + newList);
        /*
         * output:
         * List favorite fruit: [Apple, Banana, Cherry, Coconut, star fruit]
         */

    }
}
