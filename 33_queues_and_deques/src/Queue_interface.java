import java.util.*;

public class Queue_interface {
    // Queue Interface

    public static void main(String[] args) {
        /*
         * Dasar -dasar
         * Antrian adalah koleksi untuk memegang elemen sebelum diproses. Antrian
         * biasanya, tetapi tidak harus, memesan elemen dengan cara FIFO
         * (pertama-dalam-pertama).
         * 
         * Kepala antrian adalah elemen yang akan dihapus dengan panggilan untuk
         * menghapus atau melakukan polling. Dalam antrian FIFO, semua elemen baru
         * dimasukkan pada ekor antrian.
         * 
         */

    }

    // The Queue Interface

    public interface Queue<E> extends Collection<E> {
        // Inserts the specified element into this queue if possible.
        boolean add(E e);

        // Inserts the specified element into this queue if it is possible to do so
        // immediately without violating capacity restrictions.
        boolean offer(E e);

        // Retrieves and removes the head of this queue.
        E remove();

        // Retrieves and removes the head of this queue, or returns null if this queue
        // is empty.
        E poll();

        // Retrieves, but does not remove, the head of this queue.
        E element();

        // Retrieves, but does not remove, the head of this queue, or returns null if
        // this queue is empty.
        E peek();
    }

    // Setiap metode antrian ada dalam dua bentuk:
    /*
     * 1. Satu melempar pengecualian jika operasi gagal;
     * 2. Lainnya mengembalikan nilai khusus jika operasi gagal (baik nol atau false
     * tergantung pada operasi.
     */

    /*
     * Type of operation | Throws exception | Returns special value
     * Insert | add(e) | offer(e)
     * Remove | remove() | poll()
     * Examine | element() | peek()
     */
}
