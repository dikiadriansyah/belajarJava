import java.util.*;

public class Requiring_multiple_upper_bounds {
    // Requiring multiple upper bounds ("extends A & B")

    /*
     * Anda dapat meminta tipe generik untuk memperluas beberapa batas atas.
     * 
     * Contoh: kita ingin mengurutkan daftar angka tetapi Number tidak
     * mengimplementasikan Comparable.
     * 
     * public <T extends Number & Comparable<T>> void sortNumbers( List<T> n ) {
     * Collections.sort( n );
     * }
     * 
     */

    /*
     * Dalam contoh ini T harus memperluas Number dan mengimplementasikan
     * Comparable<T> yang harus sesuai dengan semua nomor bawaan "normal".
     * implementasi seperti Integer atau BigDecimal tetapi tidak cocok dengan
     * implementasi yang lebih eksotik seperti Striped64.
     * 
     * Karena pewarisan berganda tidak diperbolehkan, Anda dapat menggunakan paling
     * banyak satu kelas sebagai pengikat dan kelas tersebut harus menjadi yang
     * pertama dicantumkan.
     * Misalnya, <T extends Comparable<T> & Number> tidak diperbolehkan karena
     * Comparable adalah antarmuka, dan bukan
     * kelas.
     */
    public <T extends Number & Comparable<T>> void sortNumbers(List<T> n) {
        Collections.sort(n);
    }

    public static void main(String[] args) {
        Requiring_multiple_upper_bounds box1 = new Requiring_multiple_upper_bounds();

        // Example with Integer
        List<Integer> integerList = List.of(5, 3, 7, 1, 8);
        System.out.println("Before sorting: " + integerList);
        /*
         * output:
         * Before sorting: [5, 3, 7, 1, 8]
         */

        box1.sortNumbers(integerList);
        System.out.println("After sorting: " + integerList);

        // Example with Double
        // List<Double> doubleList = List.of(3.5, 1.2, 5.8, 2.7);
        // System.out.println("Before sorting: " + doubleList);
        // box1.sortNumbers(doubleList);
        // System.out.println("After sorting: " + doubleList);
    }
}
