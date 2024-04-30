import java.util.*;

public class Finding_common_elements_between_2_lists {
    // Finding common elements between 2 lists

    public static void main(String[] args) {
        /*
         * Anda dapat melakukannya hanya dengan memanggil metode List.retainAll().
         */

        // Contoh:
        List<Integer> numbersA = new ArrayList<>();
        List<Integer> numbersB = new ArrayList<>();
        numbersA.addAll(Arrays.asList(new Integer[] { 1, 3, 4, 7, 5, 2 }));
        numbersB.addAll(Arrays.asList(new Integer[] { 13, 32, 533, 3, 4, 2 }));
        // System.out.println("A: " + numbersA);
        // System.out.println("B: " + numbersB);
        /*
         * output:
         * A: [1, 3, 4, 7, 5, 2]
         * B: [13, 32, 533, 3, 4, 2]
         */

        List<Integer> numbersC = new ArrayList<>();
        numbersC.addAll(numbersA);
        numbersC.retainAll(numbersB);
        System.out.println("List A : " + numbersA);
        System.out.println("List B : " + numbersB);
        System.out.println("Unsur persekutuan antara A dan B: " + numbersC);
        /*
         * output:
         * List A : [1, 3, 4, 7, 5, 2]
         * List B : [13, 32, 533, 3, 4, 2]
         * Unsur persekutuan antara A dan B: [3, 4, 2]
         */

    }
}
