import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Converting_an_iterator_to_a_stream {
    // Converting an iterator to a stream / Mengubah iterator menjadi aliran

    /*
     * Gunakan Spliterators.spliterator() atau Spliterators.spliteratorUnknownSize()
     * untuk mengonversi iterator menjadi aliran:
     */

    public static void main(String[] args) {
        Iterator<String> iterator = Arrays.asList("A", "B", "C").iterator();
        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(iterator, 0);
        Stream<String> stream = StreamSupport.stream(spliterator, false);
        // Menampilkan elemen-elemen stream
        stream.forEach(System.out::println); // output: A B C

    }
}
