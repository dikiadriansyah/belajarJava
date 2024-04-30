import java.util.*;

public class The_usage_of_the_priorityqueue {
    // The usage of the PriorityQueue

    /*
     * PriorityQueue adalah struktur data. Seperti SortedSet, PriorityQueue juga
     * mengurutkan elemen-elemennya berdasarkan prioritasnya.
     * Unsur-unsur yang mempunyai prioritas lebih tinggi akan didahulukan. Jenis
     * PriorityQueue harus mengimplementasikan antarmuka pembanding atau pembanding,
     * yang metodenya menentukan prioritas elemen struktur data.
     */
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Jenis PriorityQueue adalah Integer.
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // Elemen ditambahkan ke PriorityQueue
        queue.addAll(Arrays.asList(9, 2, 3, 1, 3, 8));

        // /The PriorityQueue mengurutkan elemen dengan menggunakan metode CompareTo
        // dari Kelas Integer
        // The head of this queue is the least element with respect to the specified
        // ordering
        System.out.println(queue);
        /*
         * output:
         * [1, 2, 3, 9, 3, 8]
         */

        queue.remove();
        System.out.println(queue);
        /*
         * output:
         * [2, 3, 3, 9, 8]
         */

        queue.remove();
        System.out.println(queue);
        /*
         * output:
         * [3, 8, 3, 9]
         */

        queue.remove();
        System.out.println(queue);
        /*
         * output:
         * [3, 8, 9]
         */

        queue.remove();
        System.out.println(queue);
        /*
         * output:
         * [8, 9]
         */

        queue.remove();
        System.out.println(queue);
        /*
         * output:
         * [9]
         */

        queue.remove();
        System.out.println(queue);
        /*
         * output:
         * []
         */

    }
}
