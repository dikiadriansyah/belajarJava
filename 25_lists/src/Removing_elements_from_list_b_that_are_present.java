import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Removing_elements_from_list_b_that_are_present {
    // Removing elements from list B that are present in the list A

    public static void main(String[] args) {
        /*
         * Misalkan Anda memiliki 2 Daftar A dan B, dan Anda ingin menghapus dari B
         * semua elemen yang Anda miliki di A metode dalam hal ini adalah
         * List.removeAll(Collection c);
         */
        // Contoh:
        List<Integer> numbersA = new ArrayList<>();
        List<Integer> numbersB = new ArrayList<>();
        numbersA.addAll(Arrays.asList(new Integer[] { 1, 3, 4, 7, 5, 2 }));
        numbersB.addAll(Arrays.asList(new Integer[] { 13, 32, 533, 3, 4, 2 }));
        System.out.println("A: " + numbersA);
        System.out.println("B: " + numbersB);
        numbersB.removeAll(numbersA);
        System.out.println("B cleared: " + numbersB);

        // ini akan mencetak:

        /*
         * output:
         * A: [1, 3, 4, 7, 5, 2]
         * B: [13, 32, 533, 3, 4, 2]
         * B cleared: [13, 32, 533]
         */
    }
}
