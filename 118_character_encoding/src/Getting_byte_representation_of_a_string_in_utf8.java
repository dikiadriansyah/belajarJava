import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Getting_byte_representation_of_a_string_in_utf8 {
    // Getting byte representation of a string in UTF-8/Mendapatkan representasi
    // byte dari sebuah string di UTF-8

    /*
     * import java.nio.charset.StandardCharsets;
     * import java.util.Arrays;
     * public class GetUtf8BytesFromString {
     * public static void main(String[] args) {
     * String str = "Cyrillic symbol Ы";
     * //StandardCharsets is available since Java 1.7
     * //for ealier version use Charset.forName("UTF-8");
     * byte[] textInUtf8 = str.getBytes(StandardCharsets.UTF_8);
     * System.out.println(Arrays.toString(textInUtf8));
     * }
     * }
     */

    public static void main(String[] args) throws Exception {
        String str = "Cyrillic symbol Ы";
        // StandardCharsets is available since Java 1.7
        // for ealier version use Charset.forName("UTF-8");
        byte[] textInUtf8 = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(textInUtf8));
        /*
         * output:
         * [67, 121, 114, 105, 108, 108, 105, 99, 32, 115, 121, 109, 98, 111, 108, 32,
         * -48, -85]
         */
    }
}
