import java.util.*;

public class Introduction_to_sorted_map {
    // Introduction to sorted Map

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        /*
         * Inti:
         * 1. Antarmuka SortedMap memperluas Map.
         * 2. entri dipertahankan dalam urutan kunci menaik.
         * 
         * Metode Peta yang diurutkan :
         * Comparator comparator( ).
         * Object firstKey( ).
         * SortedMap headMap(Object end).
         * Object lastKey( ).
         * SortedMap subMap(Object start, Object end).
         * SortedMap tailMap(Object start).
         */

        // Create a hash map
        TreeMap tm = new TreeMap();

        // Put elements to the map
        tm.put("Zara", new Double(3434.34));
        tm.put("Mahnaz", new Double(123.22));
        tm.put("Ayan", new Double(1378.00));
        tm.put("Daisy", new Double(99.22));
        tm.put("Qadir", new Double(-19.08));

        // Get a set of the entries
        Set set = tm.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        // while (i.hasNext()) {
        // Map.Entry me = (Map.Entry) i.next();
        // System.out.print(me.getKey() + ": ");
        // System.out.println(me.getValue());
        // }
        // System.out.println();
        /*
         * output:
         * Ayan: 1378.0
         * Daisy: 99.22
         * Mahnaz: 123.22
         * Qadir: -19.08
         * Zara: 3434.34
         */

        // Deposit 1000 into Zara's account
        // double balance = ((Double) tm.get("Zara")).doubleValue();
        // tm.put("Zara", new Double(balance + 1000));
        // System.out.println("Zara's new balance: " + tm.get("Zara"));
        /*
         * output:
         * Zara's new balance: 4434.34
         */
    }
}
