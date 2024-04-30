import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Objects_nonnull_method_reference_use_in_stream_api {
    // Objects.nonNull() method reference use in stream api / Referensi metode
    // Objects.nonNull() digunakan dalam stream api

    // Dengan cara lama untuk mengumpulkan cek nol
    /*
     * List<Object> someObjects = methodGetList();
     * for (Object obj : someObjects) {
     * if (obj == null) {
     * continue;
     * }
     * doSomething(obj);
     * }
     */

    // Dengan metode Objects.nonNull dan Java8 Stream API, kita dapat melakukan hal
    // di atas dengan cara ini:
    /*
     * List<Object> someObjects = methodGetList();
     * someObjects.stream()
     * .filter(Objects::nonNull)
     * .forEach(this::doSomething);
     */

    public static void main(String[] args) {
        List<Object> someObjects = methodGetList();
        someObjects.stream()
                .filter(Objects::nonNull)
                .forEach(Objects_nonnull_method_reference_use_in_stream_api::doSomething);

        /*
         * output:
         * Processing: Item 1
         * Processing: Item 3
         * Processing: Item 5
         */
    }

    private static List<Object> methodGetList() {
        // Contoh implementasi methodGetList()
        return Arrays.asList("Item 1", null, "Item 3", null, "Item 5");
    }

    private static void doSomething(Object obj) {
        // Contoh implementasi doSomething()
        System.out.println("Processing: " + obj);
    }
}
