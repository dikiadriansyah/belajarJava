import java.util.*;

public class Using_iterable_in_for_loop {
    // Using Iterable in for loop/Menggunakan Iterable dalam perulangan for

    /*
     * Kelas yang mengimplementasikan antarmuka Iterable<> dapat digunakan dalam
     * loop for. Ini sebenarnya hanyalah gula sintaksis untuk mendapatkan iterator
     * dari objek dan menggunakannya untuk mendapatkan semua elemen secara
     * berurutan; itu membuat kode lebih jelas, lebih cepat untuk menulis dan
     * mengurangi rawan kesalahan.
     */

    /*
     * public class UsingIterable {
     * public static void main(String[] args) {
     * List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7);
     * 
     * // List extends Collection, Collection extends Iterable
     * Iterable<Integer> iterable = intList;
     * 
     * // foreach-like loop
     * for (Integer i: iterable) {
     * 
     */

    public static void main(String[] args) throws Exception {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // List extends Collection, Collection extends Iterable
        Iterable<Integer> iterable = intList;

        // foreach-like loop
        for (Integer i : iterable) {
            System.out.println(i);
        }

        // pre java 5 way of iterating loops
        for (Iterator<Integer> i = iterable.iterator(); i.hasNext();) {
            Integer item = i.next();
            System.out.println(item);
        }

        /*
         * output:
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         */

    }
}
