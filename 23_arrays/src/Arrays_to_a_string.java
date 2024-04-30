import java.io.*;
import java.util.*;

public class Arrays_to_a_string {
    // Arrays to a String

    /*
     * Sejak Java 1.5 Anda bisa mendapatkan representasi String dari konten array
     * yang ditentukan tanpa mengulangi setiap elemennya. Cukup gunakan
     * Arrays.toString(Object[]) atau Arrays.deepToString(Object[]) untuk array
     * multidimensi:
     */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        // System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]
        // ---------------
        int[][] box2 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }

        };
        // System.out.println(Arrays.deepToString(box2));// [[1, 2, 3], [4, 5, 6], [7,
        // 8, 9]]

        /*
         * Metode Arrays.toString() menggunakan metode Object.toString() untuk
         * menghasilkan nilai String dari setiap item dalam array,
         * selain array tipe primitif, dapat digunakan untuk semua tipe array.
         * Contohnya:
         */
        Cat[] box3 = { new Cat(), new Cat() };
        // System.out.println(Arrays.toString(box3)); // [CAT!, CAT!]

        /*
         * Jika tidak ada toString() yang diganti untuk kelas tersebut, maka toString()
         * yang diwarisi dari Object akan digunakan. Biasanya outputnya tidak terlalu
         * berguna, misalnya:
         */
        Dog2[] box4 = { new Dog2() };
        System.out.println(Arrays.toString(box4)); // [Dog@17ed40e0]

    }
}
