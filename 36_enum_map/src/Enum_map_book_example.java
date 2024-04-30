import java.util.*;

public class Enum_map_book_example {

    public enum Key {
        One, Two, Three
    };

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        EnumMap<Key, Book> map = new EnumMap<Key, Book>(Key.class);

        // Creating Books
        Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);

        // Adding Books to Map
        map.put(Key.One, b1);
        map.put(Key.Two, b2);
        map.put(Key.Three, b3);

        // Traversing EnumMap
        // for (Map.Entry<Key, Book> entry : map.entrySet()) {
        // Book b = entry.getValue();
        // System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher +
        // " " + b.quantity);
        // }

        /*
         * output:
         * 101 Let us C Yashwant Kanetkar BPB 8
         * 102 Data Communications & Networking Forouzan Mc Graw Hill 4
         * 103 Operating System Galvin Wiley 6
         */

    }
}
