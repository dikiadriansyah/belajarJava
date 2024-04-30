import java.util.*;

public class Casting_arrays {
    // Casting Arrays
    /*
     * Array adalah objek, tetapi tipenya ditentukan oleh tipe objek yang
     * dikandungnya. Oleh karena itu, seseorang tidak bisa begitu saja melemparkan
     * A[] ke T[], tetapi setiap anggota A dari A[] tertentu harus dilemparkan ke
     * objek T. Contoh umum:
     */
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4 };

        // Jadi, jika diberi array A[]:
        // T[] target = new T[array.Length];
        // target = castArray(target, array);

        /*
         * java SE menyediakan metode Arrays.copyOf(original, newLength, newType) untuk
         * tujuan ini:
         */

        Double[] doubles = { 1.0, 2.0, 3.0 };
        Number[] numbers = Arrays.copyOf(doubles, doubles.length, Number[].class);
        System.out.println("Array baru: " + Arrays.toString(numbers)); // Array baru: [1.0, 2.0, 3.0]
    }

    public static <T, A> T[] castArray(T[] target, A[] array) {
        for (int i = 0; i < array.length; i++) {
            target[i] = (T) array[i];

        }
        return target;
    }
}
