public class Getting_the_length_of_an_array {
    // Getting the Length of an Array
    /*
     * Array adalah objek yang menyediakan ruang untuk menyimpan elemen dengan tipe
     * tertentu hingga ukurannya. Ukuran array tidak dapat diubah setelah array
     * dibuat.
     */
    public static void main(String[] args) {
        // int[] arr1 = new int[0];
        // int[] arr2 = new int[2];
        // int[] arr3 = new int[] { 1, 2, 3, 4 };
        // int[] arr4 = { 1, 2, 3, 4, 5, 6, 7 };

        // int len1 = arr1.length; // 0
        // int len2 = arr2.length; // 2
        // int len3 = arr3.length; // 4
        // int len4 = arr4.length; // 7

        // System.out.println(len3); // 4

        /*
         * Bidang panjang dalam array menyimpan ukuran array. Ini adalah bidang final
         * dan tidak dapat diubah.
         * 
         * Kode ini menunjukkan perbedaan antara panjang array dan jumlah objek yang
         * disimpan array.
         */

        Integer arr[] = new Integer[] { 1, 2, 3, null, 5, null, 7, null, null, null, 11, null, 13 };
        int arrayLength = arr.length;
        int nonEmptyElementsCount = 0;
        for (int i = 0; i < arrayLength; i++) {
            Integer arrElt = arr[i];
            if (arrElt != null) {
                nonEmptyElementsCount++;
            }
        }
        System.out.println("Array 'arr' has a length of " + arrayLength + "\n"
                + "and it contains " + nonEmptyElementsCount + " non-empty values");
        /*
         * output:
         * Array 'arr' has a length of 13
         * and it contains 7 non-empty values
         */
    }
}
