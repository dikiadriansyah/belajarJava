import java.util.Arrays;

public class Converting_arrays_between_primitive_and_boxed_types {
    // Converting arrays between primitives and boxed types

    /*
     * Terkadang konversi tipe primitif ke tipe kotak diperlukan.
     * 
     * Untuk mengonversi array, dimungkinkan untuk menggunakan stream (di Java 8 ke
     * atas):
     */
    public static void main(String[] args) {
        // Version ≥ Java SE 8
        // int[] primitiveArray = { 1, 2, 3, 4 };
        // Integer[] boxedArray =
        // Arrays.stream(primitiveArray).boxed().toArray(Integer[]::new);
        // for (Integer n : boxedArray) {
        // System.out.println(n + " ");
        // }
        /*
         * 1
         * 2
         * 3
         * 4
         */

        /*
         * Dengan versi yang lebih rendah, hal ini dapat dilakukan dengan mengulangi
         * array primitif dan secara eksplisit menyalinnya ke array kotak:
         */

        // Version < Java SE 8
        int[] primitiveArray2 = { 1, 2, 3, 4 };
        Integer[] boxedArray2 = new Integer[primitiveArray2.length];
        for (int i = 0; i < primitiveArray2.length; ++i) {
            boxedArray2[i] = primitiveArray2[i]; // Each element is autoboxed here
        }
        // System.out.println("hasil aray baru: ");
        // for (int i = 0; i < boxedArray2.length; ++i) {
        // System.out.print(boxedArray2[i] + " ");
        // }
        /*
         * output:
         * 1 2 3 4
         */

        // Demikian pula, array kotak dapat dikonversi ke array dari pasangan
        // primitifnya:

        // Version ≥ Java SE 8
        Integer[] boxedArray3 = { 1, 2, 3, 4 };
        int[] primitiveArray3 = Arrays.stream(boxedArray3).mapToInt(Integer::intValue).toArray();
        // for (int i = 0; i < primitiveArray3.length; ++i) {
        // System.out.print(primitiveArray3[i] + " ");
        // }
        /*
         * output:
         * 1
         * 2
         * 3
         * 4
         */

        // Version < Java SE 8
        Integer[] boxedArray4 = { 1, 2, 3, 4 };
        int[] primitiveArray4 = new int[boxedArray4.length];
        for (int i = 0; i < boxedArray4.length; ++i) {
            primitiveArray4[i] = boxedArray4[i]; // Each element is outboxed here
        }
        System.out.println("hasil aray baru: ");
        for (int i = 0; i < primitiveArray4.length; ++i) {
            System.out.print(primitiveArray4[i] + " ");
        }
        /*
         * output:
         * hasil aray baru:
         * 1 2 3 4
         */
    }
}
