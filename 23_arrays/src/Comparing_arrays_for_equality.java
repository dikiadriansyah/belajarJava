import java.util.Arrays;

public class Comparing_arrays_for_equality {
    // Comparing arrays for equality
    /*
     * Tipe array mewarisi implementasi equals() (dan hashCode()) dari
     * java.lang.Object, jadi equals() hanya akan mengembalikan nilai true saat
     * membandingkan dengan objek array yang sama persis. Untuk membandingkan array
     * demi kesetaraan berdasarkan nilainya, gunakan java.util.Arrays.equals, yang
     * kelebihan beban untuk semua tipe array.
     */
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3 };
        int[] b = new int[] { 1, 2, 3 };
        // System.out.println(a.equals(b)); // "false" karena a dan b merujuk pada objek
        // yang berbeda
        // System.out.println(Arrays.equals(a, b)); // prints "true" karena unsur a dan
        // b mempunyai nilai yang sama

        /*
         * Jika tipe elemen adalah tipe referensi, Arrays.equals() akan memanggil same()
         * pada elemen array untuk menentukan kesetaraan. Khususnya, jika tipe elemen
         * itu sendiri merupakan tipe array, perbandingan identitas akan digunakan.
         * Untuk membandingkan array multidimensi demi kesetaraan, gunakan
         * Arrays.deepEquals() seperti di bawah ini:
         */

        int box1[] = { 1, 2, 3 };
        int box2[] = { 1, 2, 3 };
        Object[] aObject = { box1 }; // aObject contains one element
        Object[] bObject = { box2 }; // bObject contains one element
        System.out.println(Arrays.equals(aObject, bObject)); // false
        System.out.println(Arrays.deepEquals(aObject, bObject));// true

        /*
         * Karena set dan peta menggunakan equals() dan hashCode(), array umumnya
         * tidak berguna sebagai elemen set atau kunci peta(map keys).
         * Bungkus mereka dalam kelas pembantu yang mengimplementasikan sama dengan()
         * dan hashCode() dalam elemen array, atau konversikan ke instance List dan
         * simpan daftarnya.
         */

    }
}
