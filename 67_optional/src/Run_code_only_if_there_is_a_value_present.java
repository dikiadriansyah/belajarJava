import java.util.Optional;

public class Run_code_only_if_there_is_a_value_present {
    // Run code only if there is a value present/ Jalankan kode hanya jika ada nilai
    public static void main(String[] args) {
        // Optional with a value
        Optional<String> optionalWithValue = Optional.of("foo");
        optionalWithValue.ifPresent(System.out::println); // output: foo

        // Empty Optional
        Optional<String> emptyOptional = Optional.empty();
        emptyOptional.ifPresent(System.out::println); // Does nothing.
    }
}
