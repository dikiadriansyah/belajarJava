import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.Arrays;
import java.util.List;

public class Joining_a_stream_to_a_single_string {
    // Joining a stream to a single String / Menggabungkan aliran ke satu String

    /*
     * Kasus penggunaan yang sering muncul adalah membuat String dari suatu aliran,
     * di mana item aliran dipisahkan oleh karakter tertentu. Metode
     * Collectors.joining() dapat digunakan untuk ini, seperti pada contoh berikut:
     * 
     * Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi",
     * "orange");
     * String result = fruitStream.filter(s -> s.contains("a"))
     * .map(String::toUpperCase)
     * .sorted()
     * .collect(Collectors.joining(", "));
     * 
     * System.out.println(result);
     * 
     * keluaran:
     * APPLE, BANANA, ORANGE, PEAR
     */

    /*
     * Metode Collectors.joining() juga dapat memenuhi perbaikan sebelum dan
     * sesudah:
     * String result = fruitStream.filter(s -> s.contains("e"))
     * .map(String::toUpperCase)
     * .sorted()
     * .collect(Collectors.joining(", ", "Fruits: ", "."));
     * 
     * System.out.println(result);
     * keluaran:
     * Fruits: APPLE, ORANGE, PEAR.
     */

    public static void main(String[] args) {
        // Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi",
        // "orange");
        // String result = fruitStream.filter(s -> s.contains("a"))
        // .map(String::toUpperCase)
        // .sorted()
        // .collect(Collectors.joining(", "));

        // System.out.println(result);
        // output:
        // APPLE, BANANA, ORANGE, PEAR

        // -------------------
        Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
        String result = fruitStream.filter(s -> s.contains("e"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining(", ", "Fruits: ", "."));

        System.out.println(result);
        /*
         * output:
         * Fruits: APPLE, ORANGE, PEAR.
         */

    }
}
