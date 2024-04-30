import java.util.*;

public class Eliminating_duplicates_using_set {
    // Eliminating duplicates using Set

    /*
     * Misalkan Anda mempunyai elemen koleksi, dan Anda ingin membuat koleksi lain
     * yang berisi elemen yang sama tetapi dengan semua duplikat dihilangkan:
     * Collection<Type> noDuplicates = new HashSet<Type>(elements);
     */
    public static void main(String[] args) {
        // contoh:
        List<String> names = new ArrayList<>(
                Arrays.asList("John", "Marco", "Jenny", "Emily", "Jenny", "Emily", "John"));
        Set<String> noDuplicates = new HashSet<>(names);
        System.out.println("noDuplicates = " + noDuplicates);
        /*
         * output:
         * noDuplicates = [Marco, Emily, John, Jenny]
         */

    }
}
