import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pitfall_using_null_to_represent_an_empty_array_or_collection {
    // Pitfall - Using null to represent an empty array or collection/Kesalahan -
    // Menggunakan null untuk mewakili array atau koleksi kosong

    /*
     * Beberapa programmer berpikir bahwa menghemat ruang adalah ide yang bagus
     * dengan menggunakan null untuk mewakili array atau koleksi kosong. Meskipun
     * benar bahwa Anda dapat menghemat sedikit ruang, sisi buruknya adalah hal ini
     * membuat kode Anda menjadi lebih rumit dan rapuh. Bandingkan dua versi metode
     * untuk menjumlahkan array:
     * 
     * Versi pertama adalah cara Anda biasanya mengkodekan metode ini:
     * 
     * //Sum the values in an array of integers.
     * //@arg values the array to be summed
     * //@return the sum
     * public int sum(int[] values) {
     * int sum = 0;
     * for (int value : values) {
     * sum += value;
     * }
     * return sum;
     * }
     */

    // Versi kedua adalah bagaimana Anda perlu mengkodekan metode jika Anda terbiasa
    // menggunakan null untuk mewakili array kosong.

    /*
     * //Sum the values in an array of integers.
     * //@arg values the array to be summed, or null.
     * //@return the sum, or zero if the array is null.
     * public int sum(int[] values) {
     * int sum = 0;
     * if (values != null) {
     * for (int value : values) {
     * sum += value;
     * }
     * }
     * return sum;
     * }
     */

    /*
     * Seperti yang Anda lihat, kodenya sedikit lebih rumit. Hal ini secara langsung
     * disebabkan oleh keputusan untuk menggunakan null dengan cara ini.
     * 
     * Sekarang pertimbangkan apakah array yang mungkin null ini digunakan di banyak
     * tempat. Di setiap tempat Anda menggunakannya, Anda perlu mempertimbangkan
     * apakah Anda perlu menguji null. Jika Anda melewatkan pengujian null yang
     * seharusnya ada, Anda berisiko terkena NullPointerException. Oleh karena itu,
     * strategi penggunaan null dengan cara ini menyebabkan aplikasi Anda menjadi
     * lebih rapuh;
     * yaitu lebih rentan terhadap akibat kesalahan pemrogram.
     * 
     * Pelajarannya di sini adalah menggunakan array kosong dan daftar kosong jika
     * itu yang Anda maksud.
     * 
     * int[] values = new int[0]; // always empty
     * List<Integer> list = new ArrayList(); // initially empty
     * List<Integer> list = Collections.emptyList(); // always empty
     */

    /*
     * Ruang di atasnya kecil, dan ada cara lain untuk meminimalkannya jika hal ini
     * bermanfaat untuk dilakukan
     */
    // -----------------------
    public static int sum(int[] values) {
        int sum = 0;
        if (values != null) {
            for (int value : values) {
                sum += value;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        // int[] array = { 1, 2, 3, 4, 5 }; // Contoh array
        // int result = sum(array); // Memanggil metode sum dan menyimpan hasilnya
        // System.out.println("Hasil penjumlahan: " + result);
        /*
         * output:
         * Hasil penjumlahan: 15
         */
        // -------------------
        int[] values = new int[0]; // always empty
        List<Integer> list1 = new ArrayList<>(); // initially empty
        List<Integer> list2 = Collections.emptyList(); // always empty

        System.out.println("Array values:");
        for (int value : values) {
            System.out.println(value);
        }

        System.out.println("List 1:");
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        /*
         * output:
         * Array values:
         * List 1:
         */
    }
}
