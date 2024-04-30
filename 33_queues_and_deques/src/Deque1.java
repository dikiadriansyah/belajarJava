
// import java.util.*;
import java.util.Deque;
import java.util.LinkedList;

public class Deque1 {
    // Deque
    public static void main(String[] args) {
        /*
         * Deque adalah "antrian berujung ganda" yang berarti bahwa elemen dapat
         * ditambahkan di depan atau di belakang antrian.
         * Antrian hanya dapat menambahkan elemen ke bagian ekor antrian.
         * 
         * Deque mewarisi antarmuka Queue yang berarti metode reguler tetap ada, namun
         * antarmuka Deque menawarkan metode tambahan agar lebih fleksibel dengan
         * antrian. Metode tambahan benar-benar menjelaskannya sendiri jika Anda
         * mengetahui cara kerja antrean, karena metode tersebut dimaksudkan untuk
         * menambah lebih banyak fleksibilitas:
         * 
         * Method | Brief description
         * getFirst() | Gets the first item of the head of the queue without removing
         * it(Mendapatkan item pertama dari kepala antrian tanpa menghapusnya).
         * getLast() | Gets the first item of the tail of the queue without removing
         * it(Mendapatkan item pertama dari ekor antrian tanpa menghapusnya).
         * addFirst(E e) | Adds an item to the head of the queue(Menambahkan item ke
         * kepala antrian)
         * addLast(E e) | Adds an item to the tail of the queue (Menambahkan item ke
         * bagian ekor antrian)
         * removeFirst() | Removes the first item at the head of the queue(Menghapus
         * item pertama di awal antrian)
         * removeLast() | Removes the first item at the tail of the queue(Menghapus item
         * pertama di bagian belakang antrian)
         * 
         * Tentu saja opsi yang sama untuk penawaran, jajak pendapat, dan intip juga
         * tersedia, namun opsi tersebut tidak berfungsi dengan pengecualian melainkan
         * dengan nilai khusus. Tidak ada gunanya menunjukkan apa yang mereka lakukan di
         * sini.
         * 
         * Adding and Accessing Elements
         * Untuk menambahkan elemen ke bagian ekor Deque, Anda memanggil metode
         * add()-nya. Anda juga dapat menggunakan metode addFirst() dan addLast(), yang
         * menambahkan elemen ke kepala dan ekor deque.
         */
        Deque<String> dequeA = new LinkedList<>();
        dequeA.add("element 1"); // add element at tail
        dequeA.addFirst("element 2"); // add element at head
        dequeA.addLast("element 3"); // add element at tail

        // Print the elements in the deque
        // System.out.println("Elements dalam dequeA: " + dequeA);
        /*
         * output:
         * Elements dalam dequeA: [element 2, element 1, element 3]
         */

        /*
         * Anda dapat mengintip elemen di bagian atas antrian tanpa mengeluarkan elemen
         * tersebut dari antrian. Ini dilakukan melalui
         * metode element(). Anda juga dapat menggunakan metode getFirst() dan
         * getLast(), yang mengembalikan metode pertama dan terakhir
         * elemen dalam Deque. Berikut tampilannya:
         */
        String firstElement0 = dequeA.element();
        String firstElement1 = dequeA.getFirst();
        String lastElement = dequeA.getLast();
        // System.out.println("Elements dalam dequeA: " + firstElement0); // Elements
        // dalam dequeA: element 2
        // System.out.println("Elements dalam dequeA: " + firstElement1); // Elements
        // dalam dequeA: element 2
        // System.out.println("Elements dalam dequeA: " + lastElement); // Elements
        // dalam dequeA: element 3

        // Removing Elements
        /*
         * Untuk menghapus elemen dari deque, panggil metode remove(), removeFirst() dan
         * removeLast(). Berikut beberapa contohnya:
         */
        String firstElement2 = dequeA.remove();
        String firstElement3 = dequeA.removeFirst();
        String lastElement2 = dequeA.removeLast();
        System.out.println("Elements dalam dequeA: " + firstElement2);
        System.out.println("Elements dalam dequeA: " + firstElement3);
        System.out.println("Elements dalam dequeA: " + lastElement2);
        /*
         * output:
         * Elements dalam dequeA: element 2
         * Elements dalam dequeA: element 1
         * Elements dalam dequeA: element 3
         */
    }
}
