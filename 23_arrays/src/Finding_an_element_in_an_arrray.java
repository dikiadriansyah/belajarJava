import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.*;

public class Finding_an_element_in_an_arrray {
    // Finding an element in an array

    /*
     * Ada banyak cara untuk menemukan lokasi suatu nilai dalam array. Cuplikan
     * contoh berikut semuanya berasumsi bahwa array adalah salah satu dari berikut
     * ini:
     */
    public static void main(String[] args) {
        String[] strings = new String[] { "A", "B", "C" };
        int[] ints = new int[] { 1, 2, 3, 4 };
        // System.out.println(ints[3]);// 4
        // System.out.println(strings[1]);// B

        /*
         * Selain itu, masing-masing menetapkan index atau index2 ke indeks elemen
         * yang diperlukan, atau -1 jika elemen tersebut tidak ada.
         */

        // Using Arrays.binarySearch (for sorted arrays only)
        // int index = Arrays.binarySearch(strings, "A");
        // int index2 = Arrays.binarySearch(ints, 2);
        // System.out.println(index);// 0

        // System.out.println(index2);// 1

        // Using a Arrays.asList (for non-primitive arrays only)
        int box = Arrays.asList(strings).indexOf("A");
        int box2 = Arrays.asList(ints).indexOf(1); // compilation error
        // System.out.println(box);// 0

        // System.out.println(box2);// -1

        // Using a Stream
        int box3 = IntStream.range(0, strings.length)
                .filter(i -> "A".equals(strings[i]))
                .findFirst()
                .orElse(-1); // If not present, gives us -1. Similar for an array of primitives
        // System.out.println(box3);// 0

        // Linear search using a loop
        String[] myArray = { "A", "B", "C", "D", "E" };
        int box4 = -1;
        for (int i = 0; i < myArray.length; i++) {
            if ("A".equals(myArray[i])) {
                box4 = i;
                break;
            }
        }
        // Similar for an array of primitives

        // if (box4 != -1) {
        // System.out.println("Elemen 'A' ditemukan di indeks: " + box4);
        // } else {
        // System.out.println("Elemen 'A' tidak ditemukan dalam array.");
        // }
        /*
         * output:
         * Elemen 'A' ditemukan di indeks: 0
         */

        // Linear search using 3rd-party libraries such as org.apache.commons
        // int box5 = org.apache.commons.lang3.ArrayUtils.contains(strings, "A");
        // int box6 = org.apache.commons.lang3.ArrayUtils.contains(ints, 1);
        /*
         * Catatan: Menggunakan pencarian linier langsung lebih efisien daripada
         * menggabungkannya dalam list.
         */

        // Testing if an array contains an element
        /*
         * Contoh di atas dapat diadaptasi untuk menguji apakah array berisi elemen
         * hanya dengan menguji apakah indeks yang dihitung lebih besar atau sama dengan
         * nol.
         * 
         * Sebagai alternatif, ada juga beberapa variasi yang lebih ringkas:
         */
        boolean isPresent = Arrays.asList(strings).contains("A");
        System.out.println(isPresent); // true

        // Version ≥ Java SE 8
        // boolean isPresent = Stream<String>.of(strings).anyMatch(x -> "A".equals(x));
        // boolean isPresent = false;
        // for (String s : strings) {
        // if ("A".equals(s)) {
        // isPresent = true;
        // break;
        // }
        // }
        // boolean isPresent = org.apache.commons.lang3.ArrayUtils.contains(ints, 4);
    }
}
