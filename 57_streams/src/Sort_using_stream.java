import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Sort_using_stream {
    // Sort Using Stream / Urutkan Menggunakan Aliran

    /*
     * List<String> data = new ArrayList<>();
     * data.add("Sydney");
     * data.add("London");
     * data.add("New York");
     * data.add("Amsterdam");
     * data.add("Mumbai");
     * data.add("California");
     * System.out.println(data);
     * List<String> sortedData =
     * data.stream().sorted().collect(Collectors.toList());
     * System.out.println(sortedData);
     * 
     * Hasil:
     * [Sydney, London, New York, Amsterdam, Mumbai, California]
     * [Amsterdam, California, London, Mumbai, New York, Sydney]
     */

    /*
     * Dimungkinkan juga untuk menggunakan mekanisme perbandingan yang berbeda
     * karena ada versi pengurutan yang kelebihan beban yang menggunakan pembanding
     * sebagai argumennya.
     * 
     * Selain itu, Anda juga dapat menggunakan ekspresi lambda untuk menyortir:
     */
    /*
     * List<String> sortedData2 = data.stream().sorted((s1,s2) ->
     * s2.compareTo(s1)).collect(Collectors.toList());
     */

    // ini akan keluaran:
    // [Sydney, New York, Mumbai, London, California, Amsterdam]

    /*
     * Anda dapat menggunakan Comparator.reverseOrder() untuk memiliki komparator
     * yang menerapkan kebalikan dari pengurutan alami.
     * 
     * List<String> reverseSortedData =
     * data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
     */

    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        data.add("Sydney");
        data.add("London");
        data.add("New York");
        data.add("Amsterdam");
        data.add("Mumbai");
        data.add("California");
        System.out.println(data);
        /*
         * output:
         * [Sydney, London, New York, Amsterdam, Mumbai, California]
         */
        // -----------------------------------------

        // List<String> sortedData =
        // data.stream().sorted().collect(Collectors.toList());
        // System.out.println(sortedData);
        /*
         * output:
         * [Amsterdam, California, London, Mumbai, New York, Sydney]
         */

        // List<String> sortedData2 = data.stream().sorted((s1, s2) ->
        // s2.compareTo(s1)).collect(Collectors.toList());
        // System.out.println(sortedData2); // [Sydney, New York, Mumbai, London,
        // California, Amsterdam]

        // -----------------------------------------
        List<String> reverseSortedData = data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        // Menampilkan data yang sudah diurutkan secara terbalik
        System.out.println("Data setelah diurutkan secara terbalik:");
        for (String city : reverseSortedData) {
            System.out.println(city);
        }

        /*
         * output:
         * Data setelah diurutkan secara terbalik:
         * Sydney
         * New York
         * Mumbai
         * London
         * California
         * Amsterdam
         */

    }
}
