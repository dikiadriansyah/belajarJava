import java.util.*;

public class Classes_implementing_list_pros_and_cons {
        // Classes implementing List - Pros and Cons

        public static void main(String[] args) {
                /*
                 * Antarmuka List diimplementasikan oleh kelas yang berbeda. Masing-masing
                 * mempunyai cara tersendiri dalam mengimplementasikannya dengan strategi yang
                 * berbeda-beda serta memberikan pro dan kontra yang berbeda pula.
                 */

                // Classes implementing List
                // Ini semua kelas publik di Java SE 8 yang mengimplementasikan antarmuka
                // java.util.List:
                /*
                 * 1. Abstract Classes:
                 * AbstractList
                 * AbstractSequentialList
                 * 2. Concrete Classes:
                 * ArrayList
                 * AttributeList
                 * CopyOnWriteArrayList
                 * LinkedList
                 * RoleList
                 * RoleUnresolvedList
                 * Stack
                 * Vector
                 */
                /*
                 * Pros and Cons of each implementation in term of time complexity(Pro dan
                 * Kontra setiap implementasi dari segi kompleksitas waktu)
                 * ArrayList
                 * public class ArrayList<E>
                 * extends AbstractList<E>
                 * implements List<E>, RandomAccess, Cloneable, Serializable
                 */
                /*
                 * ArrayList adalah implementasi array yang dapat diubah ukurannya dari
                 * antarmuka Daftar. Menyimpan daftar ke dalam array, ArrayList menyediakan
                 * metode (selain metode yang mengimplementasikan antarmuka Daftar) untuk
                 * memanipulasi ukuran array.
                 */

                // Initialize ArrayList of Integer with size 100(Inisialisasi ArrayList dari
                // Integer dengan ukuran 100)
                List<Integer> myList = new ArrayList<Integer>(100); // Constructs an empty list with the specified
                                                                    // initial capacity

                // Pros:
                /*
                 * Operasi size, isEmpty, get, set, iterator, dan listIterator berjalan dalam
                 * waktu yang konstan. Jadi mendapatkan dan mengatur setiap elemen Daftar
                 * memiliki biaya waktu yang sama:
                 */

                // int e1 = myList.get(0); // \
                // int e2 = myList.get(10); // | => All the same constant cost => O(1)
                // myList.set(2, 10); // /

                // CONS:
                /*
                 * Diimplementasikan dengan array (struktur statis) menambahkan elemen melebihi
                 * ukuran array memiliki biaya yang besar karena fakta bahwa alokasi baru perlu
                 * dilakukan untuk semua array. Namun, dari dokumentasi:
                 * Operasi penjumlahan berjalan dalam waktu konstan yang diamortisasi, yaitu
                 * penambahan n elemen memerlukan waktu O(n).
                 * 
                 * Menghapus suatu elemen membutuhkan waktu O(n).
                 */

                // AttributeList
                // On coming

                /*
                 * CopyOnWriteArrayList
                 * On coming
                 * 
                 */

                /*
                 * LinkedList
                 * public class LinkedList<E>
                 * extends AbstractSequentialList<E>
                 * implements List<E>, Deque<E>, Cloneable, Serializable
                 * 
                 */
                /*
                 * LinkedList diimplementasikan oleh daftar tertaut ganda, struktur data tertaut
                 * yang terdiri dari sekumpulan tertaut secara berurutan
                 * catatan yang disebut node
                 */

                // Iitialize LinkedList of Integer
                List<Integer> myList2 = new LinkedList<Integer>(); // Constructs an empty list.

                /*
                 * - PROS:
                 * 
                 * Menambah atau menghapus elemen ke depan atau ke akhir daftar memiliki waktu
                 * yang konstan.
                 */

                myList2.add(10); // \
                myList2.add(0, 2); // | => constant time => O(1)
                // myList2.remove(); // /
                // System.out.println(myList2);// [2,10]

                // CONS: dari dokumentasi:
                /*
                 * Operasi yang mengindeks ke dalam daftar akan melintasi daftar dari awal atau
                 * akhir, mana saja yang lebih dekat dengan indeks yang ditentukan
                 * 
                 * Operasi seperti:
                 * 
                 */
                // myList2.get(10); // \
                // myList2.add(11, 25); // | => worst case done in O(n/2)
                // myList2.set(15, 35); // /

                /*
                 * RoleList
                 * On coming
                 * RoleUnresolvedList
                 * On coming
                 * Stack
                 * On coming
                 * Vector
                 * On coming
                 */
        }
}
