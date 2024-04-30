import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converting_a_stream_of_optional_to_a_stream_of_values {
    // Converting a Stream of Optional to a Stream of Values / Mengubah Aliran
    // Opsional menjadi Aliran Nilai

    /*
     * Anda mungkin perlu mengonversi Stream yang memancarkan Opsional menjadi
     * Stream nilai, yang hanya memancarkan nilai dari Opsional yang ada. (yaitu:
     * tanpa nilai null dan tidak berurusan dengan Opsional.empty()).
     * 
     * Optional<String> op1 = Optional.empty();
     * Optional<String> op2 = Optional.of("Hello World");
     * List<String> result = Stream.of(op1, op2)
     * .filter(Optional::isPresent)
     * .map(Optional::get)
     * .collect(Collectors.toList());
     * System.out.println(result); //[Hello World]
     */

    public static void main(String[] args) {
        Optional<String> op1 = Optional.empty();
        Optional<String> op2 = Optional.of("Hello World");
        List<String> result = Stream.of(op1, op2)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        System.out.println(result); // [Hello World]
    }
}
