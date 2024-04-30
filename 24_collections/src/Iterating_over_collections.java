import java.util.*;

public class Iterating_over_collections {
    // Iterating over Collections

    public static void main(String[] args) {
        // Iterating over List(Mengulangi Daftar)
        List<String> box = new ArrayList<>(Arrays.asList("Clementine", "Duran", "Mike"));

        // Version ≥ Java SE 8
        // box.forEach(System.out::println);
        /*
         * output:
         * Clementine
         * Duran
         * Mike
         */

        // Jika kita membutuhkan penggunaan paralelisme
        // box.parallelStream().forEach(System.out::println);
        /*
         * output:
         * Duran
         * Clementine
         * Mike
         */

        // Version ≥ Java SE 5
        // for (String value : box) {
        // System.out.println(value);
        // }
        /*
         * output:
         * Clementine
         * Duran
         * Mike
         */

        // Version < Java SE 5
        // for (int i = 0; i < box.size(); i++) {
        // System.out.println(box.get(i));
        // }
        /*
         * output:
         * Clementine
         * Duran
         * Mike
         */

        // Creates ListIterator which supports both forward as well as backward
        // traversel
        ListIterator<String> listIterator = box.listIterator();
        // Iterates list in forward direction
        // while (listIterator.hasNext()) {
        // System.out.println(listIterator.next());
        // }
        /*
         * output:
         * Clementine
         * Duran
         * Mike
         */

        // Iterates list in backward direction once reaches the last element from above
        // iterator in forward direction(Iterasi daftar dalam arah mundur setelah
        // mencapai elemen terakhir dari atas iterator dalam arah maju)
        // while (listIterator.hasPrevious()) {
        // System.out.println(listIterator.previous());
        // }
        /*
         * output:
         * Mike
         * Duran
         * Clementine
         */

        // Iterating over Set
        Set<String> box2 = new HashSet<>(Arrays.asList("Clementine", "Duran", "Mike"));

        // Version ≥ Java SE 8
        // box2.forEach(System.out::println);
        /*
         * output:
         * Mike
         * Clementine
         * Duran
         */

        // Version ≥ Java SE 5
        // for (Iterator<String> iterator = box2.iterator(); iterator.hasNext();) {
        // System.out.println(iterator.next());
        // }
        // for (String name : box2) {
        // System.out.println(name);
        // }
        /*
         * output:
         * Mike
         * Clementine
         * Duran
         * 
         * Mike
         * Clementine
         * Duran
         * 
         */

        // Version < Java SE 5
        // Iterator iterator = box2.iterator();
        // while (iterator.hasNext()) {
        // System.out.println(iterator.next());
        // }
        /*
         * output:
         * Mike
         * Clementine
         * Duran
         */

        // Iterating over Map
        HashMap<Integer, String> names = new HashMap<>();
        names.put(1, "Clementine");
        names.put(2, "Duran");
        names.put(3, "Mike");

        // Version ≥ Java SE 8
        // names.forEach((key, value) -> System.out.println("Key: " + key + " Value: " +
        // value));
        /*
         * output:
         * Key: 1 Value: Clementine
         * Key: 2 Value: Duran
         * Key: 3 Value: Mike
         */

        // Version ≥ Java SE 5
        // for (Map.Entry<Integer, String> entry : names.entrySet()) {
        // System.out.println(entry.getKey());
        // System.out.println(entry.getValue());
        // }
        /*
         * output:
         * 1
         * Clementine
         * 2
         * Duran
         * 3
         * Mike
         */

        // Iterating over only keys
        // for (Integer key : names.keySet()) {
        // System.out.println(key);
        // }
        /*
         * output:
         * 1
         * 2
         * 3
         */

        // Iterating over only values
        // for (String value : names.values()) {
        // System.out.println(value);
        // }
        /*
         * output:
         * Clementine
         * Duran
         * Mike
         */

        // Version < Java SE 5
        Iterator entries = names.entrySet().iterator();
        // while (entries.hasNext()) {
        // Map.Entry entry = (Map.Entry) entries.next();
        // System.out.println(entry.getKey());
        // System.out.println(entry.getValue());
        // }
        /*
         * output:
         * 1
         * Clementine
         * 2
         * Duran
         * 3
         * Mike
         */

    }
}
