import java.util.*;

public class Remove_an_element_from_an_array {
    // Remove an element from an array
    /*
     * Java tidak menyediakan metode langsung di java.util.Arrays untuk menghapus
     * elemen dari array. Untuk melakukannya, Anda dapat menyalin array asli ke
     * array baru tanpa elemen yang akan dihapus atau mengonversi array Anda ke
     * struktur lain yang memungkinkan penghapusan.
     */
    public static void main(String[] args) {
        /*
         * Using ArrayList
         * Anda dapat mengonversi array menjadi java.util.List, menghapus elemen, dan
         * mengonversi daftar kembali menjadi array sebagai berikut:
         */
        String[] array = new String[] { "foo", "bar", "baz" };
        List<String> list = new ArrayList<>(Arrays.asList(array));
        list.remove("foo");

        // Creates a new array with the same size as the list and copies the list
        // elements to it.
        array = list.toArray(new String[list.size()]);
        // System.out.println(Arrays.toString(array)); // [bar, baz]

        // -----------------------
        // Using System.arraycopy
        /*
         * System.arraycopy() dapat digunakan untuk membuat salinan array asli dan
         * menghapus elemen yang Anda inginkan. Di bawah ini contohnya:
         */
        int[] box1 = new int[] { 1, 2, 3, 4 }; // Original box1.
        int[] result = new int[box1.length - 1]; // box1 which will contain the result.
        int index = 1; // Remove the value "2"

        // Copy the elements at the left of the index.
        System.arraycopy(box1, 0, result, 0, index);

        // Copy the elements at the right of the index.
        System.arraycopy(box1, index + 1, result, index, box1.length - index - 1);
        // System.out.println(Arrays.toString(result)); // [1, 3, 4]
        // -----------------------
        // Using Apache Commons Lang
        /*
         * Untuk menghapus elemen dengan mudah, Anda dapat menggunakan
         * Apache Commons Lang library dan khususnya metode statis removeElement() dari
         * kelas ArrayUtils. Di bawah ini contohnya:
         */

        // int[] box2 = new int[] { 1, 2, 3, 4 };
        // box2 = ArrayUtils.removeElement(box2, 2); // remove first occurrence of 2
        // System.out.println(Arrays.toString(box2)); // [1, 3, 4]
    }
}
