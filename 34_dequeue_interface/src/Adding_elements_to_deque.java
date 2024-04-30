import java.util.*;

public class Adding_elements_to_deque {
    // Adding Elements to Deque / Menambahkan elemen ke Deque

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Deque deque = new LinkedList();

        // Menambahkan elemen di tail
        deque.add("Item1");

        // Menambahkan elemen di head
        deque.addFirst("Item2");

        // Menambahkan elemen di tail
        deque.addLast("Item3");

        System.out.println("Kumpulan hasil: " + deque);
        /*
         * output:
         * Kumpulan hasil: [Item2, Item1, Item3]
         */
    }
}
