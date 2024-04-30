import java.util.*;

public class Compare_and_contains_for_enum_values {
    // Compare and Contains for Enum values / Bandingkan dan Berisi untuk nilai Enum

    /*
     * Enum hanya berisi konstanta dan dapat dibandingkan langsung dengan ==. Jadi,
     * hanya perlu pengecekan referensi saja, tidak perlu
     * untuk menggunakan metode .equals. Selain itu, jika .equals digunakan secara
     * tidak benar, dapat memunculkan NullPointerException saat itu
     * tidak demikian halnya dengan == check.
     */

    enum Day {
        GOOD, AVERAGE, WORST;
    }

    public static void main(String[] args) {
        Day day = null;
        // if (day.equals(Day.GOOD)) {
        // System.out.println("Good Day!");
        // }

        if (day == Day.GOOD) {// Always use == to compare enum
            System.out.println("Good Day!");
        }

        /*
         * output:
         * NullPointerException!
         */

        // Untuk mengelompokkan, melengkapi, merentangkan nilai enum kita memiliki kelas
        // EnumSet yang berisi metode berbeda
        /*
         * 1. EnumSet#range : To get subset of enum by range defined by two
         * endpoints(Untuk mendapatkan subset enum berdasarkan rentang yang ditentukan
         * oleh dua titik akhir)
         * 2. EnumSet#of : Set of specific enums without any range. Multiple overloaded
         * of methods are there (Kumpulan enum tertentu tanpa rentang apa pun. Ada
         * banyak metode yang kelebihan beban)
         * 3. EnumSet#complementOf : Set of enum which is complement of enum values
         * provided in method parameter(Kumpulan enum yang merupakan pelengkap nilai
         * enum yang disediakan dalam parameter metode)
         */
        // ---------------
        // EnumSet<Page> range = EnumSet.range(Page.A1, Page.A5);
        // if (range.contains(Page.A4)) {
        // System.out.println("Rentang berisi A4");
        // }
        // EnumSet<Page> of = EnumSet.of(Page.A1, Page.A5, Page.A3);
        // if (of.contains(Page.A1)) {
        // System.out.println("Berisi A1");
        // }

        /*
         * output:
         * Rentang berisi A4
         * Berisi A1
         */

    }

    // enum Page {
    // A1, A2, A3, A4, A5, A6, A7, A8, A9, A10
    // }

}
