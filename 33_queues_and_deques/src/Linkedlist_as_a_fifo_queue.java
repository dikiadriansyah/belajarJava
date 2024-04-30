import java.util.*;

public class Linkedlist_as_a_fifo_queue {
    // LinkedList as a FIFO Queue

    /*
     * Kelas java.util.LinkedList, saat mengimplementasikan java.util.List adalah
     * implementasi antarmuka java.util.Queue untuk tujuan umum yang juga beroperasi
     * pada prinsip FIFO (First In, First Out).
     * 
     * Pada contoh di bawah, dengan metode offer(), elemen dimasukkan ke dalam
     * LinkedList. Operasi penyisipan ini disebut enqueue. Dalam perulangan while di
     * bawah, elemen dihapus dari Antrean berdasarkan FIFO. Operasi ini disebut
     * dequeue.
     */
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("Box1");
        queue.offer("Box2");
        queue.offer("Box3");
        queue.offer("Box4");
        queue.offer("Box5");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // Output dari kode ini adalah
        /*
         * Box1
         * Box2
         * Box3
         * Box4
         * Box5
         */

        /*
         * Seperti yang terlihat dalam output, elemen pertama yang dimasukkan
         * "elemen pertama" dihapus terlebih dahulu, "elemen kedua" dihapus di tempat
         * kedua dll.
         */
    }
}
