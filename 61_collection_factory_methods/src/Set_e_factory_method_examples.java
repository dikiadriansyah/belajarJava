import java.util.Set;

public class Set_e_factory_method_examples {
    // Set<E> Factory Method Examples/Set<E> Contoh Metode Pabrik

    /*
     * Set<Integer> immutableEmptySet = Set.of();
     * Initializes an empty, immutable Set<Integer>.
     * Set<Integer> immutableSet = Set.of(1, 2, 3, 4, 5);
     * Initializes an immutable Set<Integer> with five initial elements.
     * Set<Integer> mutableSet = new HashSet<>(immutableSet);
     * Initializes a mutable Set<Integer> from an immutable Set<Integer>.
     * 
     */

    public static void main(String[] args) throws Exception {
        // Membuat Immutable Set
        Set<Integer> immutableSet = Set.of(1, 2, 3, 4, 5);

        // Menampilkan elemen-elemen dalam Immutable Set
        System.out.println("Immutable Set: " + immutableSet);
    }
}
