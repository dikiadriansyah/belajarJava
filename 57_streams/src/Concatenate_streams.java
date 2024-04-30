import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

public class Concatenate_streams {
    // Concatenate Streams / Aliran Gabungan

    // Contoh deklarasi variabel:

    /*
     * Collection<String> abc = Arrays.asList("a", "b", "c");
     * Collection<String> digits = Arrays.asList("1", "2", "3");
     * Collection<String> greekAbc = Arrays.asList("alpha", "beta", "gamma");
     */

    // Contoh 1 - Menggabungkan dua Streams

    /*
     * final Stream<String> concat1 = Stream.concat(abc.stream(), digits.stream());
     * concat1.forEach(System.out::print);
     * // prints: abc123
     */

    /*
     * Example 2 - Concatenate more than two Streams / Gabungkan lebih dari dua
     * Aliran
     * final Stream<String> concat2 = Stream.concat(
     * Stream.concat(abc.stream(), digits.stream()),
     * greekAbc.stream());
     * System.out.println(concat2.collect(Collectors.joining(", ")));
     * // prints: a, b, c, 1, 2, 3, alpha, beta, gamma
     */

    // Sebagai alternatif untuk menyederhanakan sintaks concat() yang disarangkan,
    // Streams juga dapat digabungkan dengan flatMap():

    /*
     * final Stream<String> concat3 = Stream.of(
     * abc.stream(), digits.stream(), greekAbc.stream())
     * .flatMap(s -> s);
     * // or `.flatMap(Function.identity());` (java.util.function.Function)
     * System.out.println(concat3.collect(Collectors.joining(", ")));
     * // prints: a, b, c, 1, 2, 3, alpha, beta, gamma
     */

    /*
     * Berhati-hatilah saat membuat Streams dari penggabungan berulang, karena
     * mengakses elemen Streams yang digabungkan secara mendalam dapat menghasilkan
     * rantai panggilan yang dalam atau bahkan StackOverflowException.
     */

    public static void main(String[] args) {
        Collection<String> abc = Arrays.asList("a", "b", "c");
        Collection<String> digits = Arrays.asList("1", "2", "3");
        Collection<String> greekAbc = Arrays.asList("alpha", "beta", "gamma");

        // final Stream<String> concat1 = Stream.concat(abc.stream(), digits.stream());
        // concat1.forEach(System.out::print);
        // prints: abc123
        // -------------------------------------
        // final Stream<String> concat2 = Stream.concat(
        // Stream.concat(abc.stream(), digits.stream()),
        // greekAbc.stream());
        // System.out.println(concat2.collect(Collectors.joining(", ")));
        // prints: a, b, c, 1, 2, 3, alpha, beta, gamma
        // -------------------------------------
        final Stream<String> concat3 = Stream.of(
                abc.stream(), digits.stream(), greekAbc.stream())
                .flatMap(s -> s);

        // or `.flatMap(Function.identity());` (java.util.function.Function)
        System.out.println(concat3.collect(Collectors.joining(", ")));
        // prints: a, b, c, 1, 2, 3, alpha, beta, gamma

    }
}
