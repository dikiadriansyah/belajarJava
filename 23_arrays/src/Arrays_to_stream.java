import java.util.*;
import java.util.stream.*;

public class Arrays_to_stream {
    // Arrays to Stream

    public static void main(String[] args) {
        // Mengonversi array objek menjadi Stream:
        String[] arr = new String[] { "str1", "str2", "str3" };
        Stream<String> stream = Arrays.stream(arr);
        // stream.forEach(str -> System.out.println(str + " "));
        /*
         * output:
         * str1
         * str2
         * str3
         */

        /*
         * Mengonversi array primitif menjadi Stream menggunakan Arrays.stream() akan
         * mengubah array menjadi spesialisasi primitif Stream:
         */
        int[] intArr = { 1, 2, 3 };
        IntStream intStream = Arrays.stream(intArr);
        // intStream.forEach(str -> System.out.println(str + " "));
        /*
         * output:
         * 1
         * 2
         * 3
         */

        /*
         * Anda juga dapat membatasi Stream ke berbagai elemen dalam array. Indeks awal
         * bersifat inklusif dan indeks akhir bersifat eksklusif:
         */

        int[] values = { 1, 2, 3, 4 };
        IntStream box1 = Arrays.stream(values, 2, 4);
        // box1.forEach(str -> System.out.println(str + " "));
        /*
         * output:
         * 3
         * 4
         */

        /*
         * Metode yang mirip dengan Arrays.stream() muncul di kelas Stream: Stream.of().
         * Perbedaannya adalah Stream.of()
         * menggunakan parameter varargs, sehingga Anda dapat menulis sesuatu seperti:
         */
        Stream<Integer> box2 = Stream.of(1, 2, 3);
        Stream<String> box3 = Stream.of("1", "2", "3");
        Stream<Double> box4 = Stream.of(new Double[] { 1.0, 2.0 });
        box2.forEach(System.out::println);
        /*
         * output:
         * 1
         * 2
         * 3
         */
    }
}
