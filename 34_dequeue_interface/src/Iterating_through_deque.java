import java.util.*;

public class Iterating_through_deque {
    // Iterating through Deque

    public static void main(String[] args) {
        Deque<Object> deque = new LinkedList<>();
        // Menambahkan elemen di tail
        deque.add("Item1");

        // Menambahkan elemen di head
        deque.addFirst("Item2");

        // Menambahkan elemen di tail
        deque.addLast("Item3");

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            String Item = (String) iterator.next();
            System.out.println("Using Iterator: " + Item);
        }
        /*
         * output:
         * Using Iterator: Item2
         * Using Iterator: Item1
         * Using Iterator: Item3
         */

        // Using For Loop
        for (Object object : deque) {
            String Item = (String) object;

        }
    }
}
