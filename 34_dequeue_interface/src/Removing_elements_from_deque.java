import java.util.*;

public class Removing_elements_from_deque {
    // Removing Elements from Deque / Menghapus elemen dari deque

    public static void main(String[] args) {
        Deque<Object> deque = new LinkedList();

        // Menambahkan elemen di tail
        deque.add("Item1");

        // Menambahkan elemen di head
        deque.addFirst("Item2");

        // Menambahkan elemen di tail
        deque.addLast("Item3");

        // Mengambil dan menghilangkan kepala antrian yang diwakili oleh deque ini
        Object headItem = deque.remove();

        // Mengambil dan menghilangkan elemen pertama deque ini.
        Object firstItem = deque.removeFirst();

        // Mengambil dan menghilangkan elemen terakhir dari deque ini.
        Object lastItem = deque.removeLast();

        System.out.println("Removed headItem: " + headItem);
        System.out.println("Removed firstItem: " + firstItem);
        System.out.println("Removed lastItem: " + lastItem);
        /*
         * output:
         * Removed headItem: Item2
         * Removed firstItem: Item1
         * Removed lastItem: Item3
         */

    }
}
