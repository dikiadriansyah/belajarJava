import java.util.*;

public class Copying_arrays {
    // Copying arrays
    /*
     * Java menyediakan beberapa cara untuk menyalin array.
     */
    public static void main(String[] args) {
        // for loop
        int[] box1 = { 4, 1, 3, 2 };
        int[] box2 = new int[box1.length];
        // for (int i = 0; i < box1.length; i++) {
        // box2[i] = box1[i];
        // }
        // for (int value : box2) {
        // System.out.println(value + " ");
        // }
        /*
         * output:
         * 4
         * 1
         * 3
         * 2
         */
        /*
         * Perhatikan bahwa menggunakan opsi ini dengan array Object alih-alih array
         * primitif akan mengisi salinan dengan referensi ke konten asli, bukan
         * salinannya.
         */

        // Object.clone()
        /*
         * Karena array adalah Objek di Java, Anda dapat menggunakan Object.clone().
         */
        int[] box3 = { 4, 1, 3, 2 };
        int[] box4 = box3.clone(); // [4, 1, 3, 2]
        // for (int v : box4) {
        // System.out.println(v);
        // }
        /*
         * output:
         * 4
         * 1
         * 3
         * 2
         */

        /*
         * Perhatikan bahwa metode Object.clone untuk sebuah array melakukan penyalinan
         * dangkal, yaitu mengembalikan referensi ke new array yang mereferensikan
         * elemen yang sama dengan array sumber.
         */

        // Arrays.copyOf()
        /*
         * java.util.Arrays menyediakan cara mudah untuk melakukan penyalinan array ke
         * array lain. Berikut adalah penggunaan dasarnya:
         */

        int[] box5 = { 4, 1, 3, 2 };
        int[] box6 = Arrays.copyOf(box5, box5.length); // [4, 1, 3, 2]
        // for (int v2 : box6) {
        // System.out.println(v2);
        // }
        /*
         * output:
         * 
         * 4
         * 1
         * 3
         * 2
         */

        /*
         * Perhatikan bahwa Arrays.copyOf juga menyediakan kelebihan beban yang
         * memungkinkan Anda mengubah tipe array:
         */
        Double[] doubles = { 1.0, 2.0, 3.0 };
        Number[] numbers = Arrays.copyOf(doubles, doubles.length, Number[].class);
        // for (int i = 0; i < numbers.length; i++) {
        // System.out.print(numbers[i] + " ");
        // }
        /*
         * output:
         * 1.0 2.0 3.0
         */

        // System.arraycopy()
        /*
         * public static void arraycopy(Objek src, int srcPos, Object dest, int
         * destPos, int length) Menyalin array dari array sumber tertentu, dimulai dari
         * posisi tertentu, ke posisi tertentu dari array tujuan.
         * 
         * Di bawah ini contoh penggunaannya
         */

        int[] box7 = { 4, 1, 3, 2 };
        int[] box8 = new int[box7.length];
        System.arraycopy(box7, 0, box8, 0, box7.length); // [4, 1, 3, 2]
        // for (int box9 : box8) {
        // System.out.print(box9 + " "); // 4 1 3 2
        // }

        // Arrays.copyOfRange()
        /*
         * Terutama digunakan untuk menyalin bagian dari Array, Anda juga dapat
         * menggunakannya untuk menyalin seluruh array ke array lain seperti di bawah
         * ini:
         */

        int[] box10 = { 4, 1, 3, 2 };
        int[] box11 = Arrays.copyOfRange(box10, 0, box10.length); // [4, 1, 3, 2]
        System.out.println(Arrays.toString(box11)); // [4,1,3,2]
    }
}
