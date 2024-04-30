import java.util.*;

public class Enumset_example {
    // Enum Set Example

    /*
     * Kelas Java EnumSet adalah implementasi Set khusus untuk digunakan dengan tipe
     * enum. Itu mewarisi kelas AbstrakSet dan mengimplementasikan antarmuka Set.
     */

    enum days {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Set<days> set = EnumSet.of(days.TUESDAY, days.WEDNESDAY);

        // Traversing elements
        Iterator<days> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        /*
         * output:
         * TUESDAY
         * WEDNESDAY
         */

    }
}
