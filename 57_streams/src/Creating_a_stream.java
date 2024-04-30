import java.util.Arrays;
import java.util.stream.Stream;
import java.util.function.Supplier;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Creating_a_stream {
    // Creating a Stream / Membuat Aliran

    /*
     * Semua Java Collection<E> memiliki metode stream() dan parallelStream() yang
     * dapat digunakan untuk membuat Stream<E>:
     * Collection<String> stringList = new ArrayList<>();
     * Stream<String> stringStream = stringList.parallelStream();
     * 
     * Stream<E> dapat dibuat dari array menggunakan salah satu dari dua metode:
     * String[] values = { "aaa", "bbbb", "ddd", "cccc" };
     * Stream<String> stringStream = Arrays.stream(values);
     * Stream<String> stringStreamAlternative = Stream.of(values);
     */

    /*
     * Perbedaan antara Arrays.stream() dan Stream.of() adalah Stream.of() memiliki
     * parameter varargs, sehingga dapat digunakan seperti:
     * Stream<Integer> integerStream = Stream.of(1, 2, 3);
     */

    /*
     * Ada juga Streams primitif yang dapat Anda gunakan. Misalnya:
     * IntStream intStream = IntStream.of(1, 2, 3);
     * DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);
     */

    /*
     * Aliran primitif ini juga dapat dibuat menggunakan metode Arrays.stream() :
     * IntStream intStream = Arrays.stream(new int[]{ 1, 2, 3 });
     */

    /*
     * Dimungkinkan untuk membuat Stream dari array dengan rentang tertentu.
     * int[] values= new int[]{1, 2, 3, 4, 5};
     * IntStream intStram = Arrays.stream(values, 1, 3);
     * 
     */

    /*
     * Perhatikan bahwa aliran primitif apa pun dapat dikonversi ke aliran tipe
     * kotak menggunakan metode kotak :
     * Stream<Integer> integerStream = intStream.boxed();
     * 
     */

    /*
     * Ini bisa berguna dalam beberapa kasus jika Anda ingin mengumpulkan data
     * karena aliran primitif tidak memiliki metode pengumpulan yang menggunakan
     * Collector sebagai argumen.
     */

    // Reusing intermediate operations of a stream chain/ Menggunakan kembali
    // operasi perantara dari rantai aliran

    /*
     * Aliran ditutup ketika operasi terminal dipanggil. Menggunakan kembali aliran
     * operasi perantara, jika saja operasi terminal hanya bervariasi. kita dapat
     * membuat pemasok aliran untuk membangun aliran baru dengan semua operasi
     * perantara sudah disiapkan.
     */

    /*
     * Supplier<Stream<String>> streamSupplier = () -> Stream.of("apple",
     * "banana","orange", "grapes",
     * "melon","blueberry","blackberry")
     * .map(String::toUpperCase).sorted();
     * streamSupplier.get().filter(s ->
     * s.startsWith("A")).forEach(System.out::println);
     * // APPLE
     * streamSupplier.get().filter(s ->
     * s.startsWith("B")).forEach(System.out::println);
     * // BANANA
     * // BLACKBERRY
     * // BLUEBERRY
     */

    // array int[] dapat dikonversi ke List<Integer> menggunakan aliran
    /*
     * int[] ints = {1,2,3};
     * List<Integer> list = IntStream.of(ints).boxed().collect(Collectors.toList());
     */

    public static void main(String[] args) {
        // String[] values = { "aaa", "bbbb", "ddd", "cccc" };
        // Stream<String> stringStream = Arrays.stream(values);
        // Stream<String> stringStreamAlternative = Stream.of(values);

        // // Contoh penggunaan stream
        // System.out.println("Menggunakan Arrays.stream():");
        // stringStream.forEach(System.out::println);

        /*
         * output:
         * Menggunakan Arrays.stream():
         * aaa
         * bbbb
         * ddd
         * cccc
         */

        // System.out.println("\nMenggunakan Stream.of():");
        // stringStreamAlternative.forEach(System.out::println);
        /*
         * output:
         * 
         * Menggunakan Stream.of():
         * aaa
         * bbbb
         * ddd
         * cccc
         */

        // -----------------------------------------
        // Supplier<Stream<String>> streamSupplier = () -> Stream
        // .of("apple", "banana", "orange", "grapes", "melon", "blueberry",
        // "blackberry").map(String::toUpperCase)
        // .sorted();

        // streamSupplier.get().filter(s ->
        // s.startsWith("A")).forEach(System.out::println);
        // Output: APPLE

        // streamSupplier.get().filter(s ->
        // s.startsWith("B")).forEach(System.out::println);
        // Output: BLACKBERRY, BLUEBERRY

        // -----------------------------------------
        // Array of integers
        int[] ints = { 1, 2, 3 };

        // Convert int array to List<Integer>
        List<Integer> list = IntStream.of(ints)
                .boxed()
                .collect(Collectors.toList());

        // Print the converted list
        System.out.println("Converted List: " + list); // Converted List: [1, 2, 3]
    }
}
