import java.util.Iterator;
import java.util.NoSuchElementException;

public class Creating_your_own_iterable_structure<T> implements Iterable<T> {
    // Creating your own Iterable structure for use with Iterator or for-each loop

    /*
     * Untuk memastikan bahwa koleksi kita dapat diiterasi menggunakan iterator atau
     * for-each loop, kita harus melakukan langkah-langkah berikut:
     * 1. Hal-hal yang ingin kita ulangi harus dapat diubah dan diekspos iterator().
     * 2. Rancang java.util.Iterator dengan mengganti hasNext(), next() dan
     * delete().
     * 
     * Saya telah menambahkan implementasi daftar tertaut umum sederhana di bawah
     * ini yang menggunakan entitas di atas untuk membuat daftar tertaut dapat
     * diubah.
     * 
     */

    Node<T> head, current;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public Creating_your_own_iterable_structure(T data) {
        head = new Node<>(data);
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node<T> node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Node<T> prevNode = node;
            node = node.next;
            return prevNode.data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Removal logic not implemented.");
        }
    }

    public void add(T data) {
        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = new Node<>(data);
    }

    public static void main(String[] args) {
        Creating_your_own_iterable_structure<Integer> list = new Creating_your_own_iterable_structure<>(1);
        list.add(2);
        list.add(4);
        list.add(3);

        // Test #1
        System.out.println("using Iterator:");
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            Integer i = itr.next();
            System.out.print(i + " ");
        }
        /*
         * using Iterator:
         * 1 2 4 3
         */

        // Test #2
        System.out.println("\n\nusing for-each:");
        for (Integer data : list) {
            System.out.print(data + " ");
        }
        /*
         * using for-each:
         * 1 2 4 3
         */

        // Ini akan berjalan di Java 7+. Anda dapat menjalankannya di Java 5 dan Java 6
        // juga dengan mengganti:
        // Creating_your_own_iterable_structure<Integer> list2 = new
        // Creating_your_own_iterable_structure<>(1);

        // dengan
        // Creating_your_own_iterable_structure<Integer> list3 = new
        // Creating_your_own_iterable_structure<Integer>(1);
        // atau versi lainnya dengan memasukkan perubahan yang kompatibel.

    }

}
