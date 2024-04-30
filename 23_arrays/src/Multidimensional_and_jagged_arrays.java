public class Multidimensional_and_jagged_arrays {
    // Multidimensional and Jagged Arrays
    /*
     * Dimungkinkan untuk mendefinisikan array dengan lebih dari satu dimensi.
     * Daripada diakses dengan menyediakan indeks tunggal, array multidimensi
     * diakses dengan menentukan indeks untuk setiap dimensi.
     * 
     * Deklarasi array multidimensi dapat dilakukan dengan menambahkan [] untuk
     * setiap dimensi ke dalam deklarasi array biasa. Misalnya, untuk membuat array
     * int 2 dimensi, tambahkan satu set tanda kurung ke deklarasi, seperti int[][].
     * Hal ini berlanjut untuk array 3 dimensi (int[][][]) dan seterusnya
     * 
     * Untuk mendefinisikan array 2 dimensi dengan tiga baris dan tiga kolom:
     * 
     */

    public static void main(String[] args) throws Exception {
        int rows = 3;
        int columns = 3;
        int[][] table = new int[rows][columns];
        // System.out.println(table);

        /*
         * Array dapat diindeks dan diberi nilai dengan konstruksi ini. Perhatikan bahwa
         * nilai yang belum ditetapkan adalah nilai default untuk tipe array, dalam hal
         * ini 0 untuk int.
         * table[0][0] = 0;
         * table[0][1] = 1;
         * table[0][2] = 2;
         * 
         * Dimungkinkan juga untuk membuat instance dimensi pada suatu waktu, dan bahkan
         * membuat array non-persegi panjang. Ini lebih sering disebut sebagai jagged
         * array.
         */
        int[][] nonRect = new int[4][];
        /*
         * Penting untuk dicatat bahwa meskipun dimensi apa pun dari array bergerigi
         * dapat ditentukan, level sebelumnya harus ditentukan.
         */
        // valid
        String[][] employeeGraph = new String[30][];
        // System.out.println(employeeGraph);// [[Ljava.lang.String;@53bd815b

        // invalid
        // int[][] unshapenMatrix = new int[][10];

        // also invalid
        // int[][][] misshapenGrid = new int[100][][10];

        /*
         * How Multidimensional Arrays are represented in Java(Bagaimana Array
         * Multidimensi direpresentasikan di Java)
         * 
         * Jagged array literal intialization(Inisialisasi literal array bergerigi)
         * Array multidimensi dan array bergerigi juga dapat diinisialisasi dengan
         * ekspresi literal. Berikut ini mendeklarasikan dan mengisi array int 2x3:
         * 
         */
        int[][] table2 = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        // System.out.println(table2[1][1]); // 5

        /*
         * Catatan: Subarray bergerigi mungkin juga bernilai nol. Misalnya, kode berikut
         * mendeklarasikan dan mengisi array int dua dimensi yang subarray pertamanya
         * adalah null, subarray kedua panjangnya nol, subarray ketiga panjangnya satu,
         * dan subarray terakhir adalah array dua panjang:
         */
        int[][] table3 = {
                null,
                {},
                { 1 },
                { 1, 2 }
        };
        // System.out.println(table3[1]); // [I@53bd815b

        // Untuk array multidimensi, dimungkinkan untuk mengekstrak array dengan dimensi
        // tingkat lebih rendah berdasarkan indeksnya:
        int[][][] arr = new int[3][3][3];
        int[][] arr1 = arr[0]; // get first 3x3-dimensional array from arr
        int[] arr2 = arr1[0]; // get first 3-dimensional array from arr1
        // int[] arr3 = arr[0]; // error: cannot convert from int[][] to int[]
        System.out.println(arr1[1][1]); // 0
    }
}
