import java.util.stream.IntStream;

public class Using_intstream_to_iterate {
    // Using IntStream to iterate over indexes / Menggunakan IntStream untuk
    // mengulangi indeks

    /*
     * Streams elemen biasanya tidak mengizinkan akses ke nilai indeks item saat
     * ini.
     * Untuk mengulangi array atau ArrayList sambil memiliki akses ke indeks,
     * gunakan IntStream.range(start, endExclusive).
     * 
     * 
     * String[] names = { "Jon", "Darin", "Bauke", "Hans", "Marc" };
     * IntStream.range(0, names.length)
     * .mapToObj(i -> String.format("#%d %s", i + 1, names[i]))
     * .forEach(System.out::println);
     * 
     * Metode range(start, endExclusive) mengembalikan ÌntStream lain dan
     * mapToObj(mapper) mengembalikan aliran String.
     * 
     * Keluaran:
     * Output:
     * #1 Jon
     * #2 Darin
     * #3 Bauke
     * #4 Hans
     * #5 Marc
     * 
     * 
     */

    // Ini sangat mirip dengan penggunaan perulangan for normal dengan penghitung,
    // namun dengan keunggulan pipelining dan paralelisasi:
    /*
     * for (int i = 0; i < names.length; i++) {
     * String newName = String.format("#%d %s", i + 1, names[i]);
     * System.out.println(newName);
     * }
     */

    public static void main(String[] args) {
        String[] names = { "Jon", "Darin", "Bauke", "Hans", "Marc" };
        IntStream.range(0, names.length)
                .mapToObj(i -> String.format("#%d %s", i + 1, names[i]))
                .forEach(System.out::println);

        /*
         * output:
         * #1 Jon
         * #2 Darin
         * #3 Bauke
         * #4 Hans
         * #5 Marc
         */

        // ------------------
        // for (int i = 0; i < names.length; i++) {
        // String newName = String.format("#%d %s", i + 1, names[i]);
        // System.out.println(newName);
        // }

        /*
         * output:
         * #1 Jon
         * #2 Darin
         * #3 Bauke
         * #4 Hans
         * #5 Marc
         */

    }
}