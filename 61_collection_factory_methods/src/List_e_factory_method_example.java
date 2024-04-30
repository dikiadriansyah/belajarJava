import java.util.List;

public class List_e_factory_method_example {
    // List<E> Factory Method Examples/ List<E> Contoh Metode Pabrik

    /*
     * List<Integer> immutableEmptyList = List.of();
     * Initializes an empty, immutable List<Integer>.
     * List<Integer> immutableList = List.of(1, 2, 3, 4, 5);
     * Initializes an immutable List<Integer> with five initial elements.
     * List<Integer> mutableList = new ArrayList<>(immutableList);
     * Initializes a mutable List<Integer> from an immutable List<Integer>
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Membuat immutable list menggunakan List.of()
        List<Integer> immutableList = List.of(1, 2, 3, 4, 5);

        // Menampilkan elemen-elemen dalam immutable list
        System.out.println("Immutable List:");
        for (Integer element : immutableList) {
            System.out.println(element);
        }

        /*
         * output:
         * Immutable List:
         * 1
         * 2
         * 3
         * 4
         * 5
         */

    }
}
