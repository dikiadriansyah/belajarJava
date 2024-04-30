public class Arrayindex_out_of_bounds_exception {
    // ArrayIndexOutOfBoundsException
    /*
     * ArrayIndexOutOfBoundsException dilempar ketika indeks array yang tidak ada
     * sedang diakses.
     * 
     * Array diindeks berbasis nol, sehingga indeks elemen pertama adalah 0 dan
     * indeks elemen terakhir adalah kapasitas array dikurangi 1 (yaitu array.length
     * - 1).
     * 
     * 
     * Oleh karena itu, setiap permintaan elemen array dengan indeks i harus
     * memenuhi kondisi 0 <= i < array.length,
     * jika tidak, ArrayIndexOutOfBoundsException akan dilempar.
     * 
     * Kode berikut adalah contoh sederhana di mana ArrayIndexOutOfBoundsException
     * dilempar.
     */

    public static void main(String[] args) {
        String[] people = new String[] { "Carol", "Andy" };
        // An array will be created:
        // people[0]: "Carol"
        // people[1]: "Andy"
        // Notice: no item on index 2. Trying to access it triggers the exception:
        // System.out.println(people[2]); // throws an ArrayIndexOutOfBoundsException
        /*
         * Output:
         * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
         * at your.package.path.method(YourClass.java:15)
         */

        /*
         * Perhatikan bahwa indeks ilegal yang sedang diakses juga termasuk dalam
         * pengecualian (2 dalam contoh); informasi ini dapat berguna untuk menemukan
         * penyebab pengecualian tersebut.
         * 
         * Untuk menghindari hal ini, cukup periksa apakah indeks berada dalam batas
         * array:
         */

        int index = 1;
        if (index >= 0 && index < people.length) {
            System.out.println(people[index]);
        } // Andy

    }
}
