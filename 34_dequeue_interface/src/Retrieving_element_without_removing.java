import java.util.*;

public class Retrieving_element_without_removing {
    // Retrieving Element without Removing / Mengambil elemen tanpa menghapus

    public static void main(String[] args) {
        Deque<Object> deque = new LinkedList<>();
        // Menambahkan elemen di tail
        deque.add("Item1");

        // Menambahkan elemen di head
        deque.addFirst("Item2");

        // Menambahkan elemen di tail
        deque.addLast("Item3");

        // Mengambil, tetapi tidak menghapus, kepala antrian yang diwakili oleh deque
        // ini
        Object headItem = deque.element();

        // Mengambil, tetapi tidak menghapus, elemen pertama dari deque ini.
        Object firstItem = deque.getFirst();

        // Mengambil, tetapi tidak menghapus, elemen terakhir dari deque ini.
        Object lastItem = deque.getLast();

        System.out.println("Retrieved headItem: " + headItem);
        System.out.println("Retrieved firstItem: " + firstItem);
        System.out.println("Retrieved lastItem: " + lastItem);
        /*
         * output:
         * Retrieved headItem: Item2
         * Retrieved firstItem: Item2
         * Retrieved lastItem: Item3
         */
    }
}
