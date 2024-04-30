import java.util.Arrays;
import java.util.Base64;

// import javax.xml.bind.DatatypeConverter;
// import org.apache.commons.codec.binary.Base64;

public class Base64_encoding_decoding {
    // Base64 Encoding / Decoding

    /*
     * Terkadang Anda akan menemukan kebutuhan untuk mengkodekan data biner sebagai
     * string yang dikodekan base64
     * 
     * Untuk ini kita bisa menggunakan kelas DatatypeConverter dari paket
     * javax.xml.bind:
     * 
     * import javax.xml.bind.DatatypeConverter;
     * import java.util.Arrays;
     * // arbitrary binary data specified as a byte array
     * byte[] binaryData = "some arbitrary data".getBytes("UTF-8");
     * // convert the binary data to the base64-encoded string
     * String encodedData = DatatypeConverter.printBase64Binary(binaryData);
     * // encodedData is now "c29tZSBhcmJpdHJhcnkgZGF0YQ=="
     * // convert the base64-encoded string back to a byte array
     * byte[] decodedData = DatatypeConverter.parseBase64Binary(encodedData);
     * // assert that the original data and the decoded data are equal
     * assert Arrays.equals(binaryData, decodedData);
     * 
     */

    // Apache commons-codec
    /*
     * Alternatifnya, kita bisa menggunakan Base64 dari Apache commons-codec
     * 
     * import org.apache.commons.codec.binary.Base64;
     * // your blob of binary as a byte array
     * byte[] blob = "someBinaryData".getBytes();
     * // use the Base64 class to encode
     * String binaryAsAString = Base64.encodeBase64String(blob);
     * // use the Base64 class to decode
     * byte[] blob2 = Base64.decodeBase64(binaryAsAString);
     * // assert that the two blobs are equal
     * System.out.println("Equal : " + Boolean.toString(Arrays.equals(blob,
     * blob2)));
     */

    /*
     * Jika Anda memeriksa program ini saat berjalan, Anda akan melihat bahwa
     * someBinaryData dikodekan ke c29tZUJpbmFyeURhdGE=, a objek String UTF-8 yang
     * sangat mudah dikelola.
     */

    // Version ≥ Java SE 8
    /*
     * Detailnya dapat ditemukan di Base64
     * 
     * // encode with padding
     * String encoded = Base64.getEncoder().encodeToString(someByteArray);
     * // encode without padding
     * String encoded =
     * Base64.getEncoder().withoutPadding().encodeToString(someByteArray);
     * // decode a String
     * byte [] barr = Base64.getDecoder().decode(encoded);
     */

    public static void main(String[] args) {
        // arbitrary binary data specified as a byte array
        // byte[] binaryData = "some arbitrary data".getBytes("UTF-8");
        // convert the binary data to the base64-encoded string
        // String encodedData = DatatypeConverter.printBase64Binary(binaryData);
        // encodedData is now "c29tZSBhcmJpdHJhcnkgZGF0YQ=="
        // convert the base64-encoded string back to a byte array
        // byte[] decodedData = DatatypeConverter.parseBase64Binary(encodedData);
        // assert that the original data and the decoded data are equal
        // assert Arrays.equals(binaryData, decodedData);
        // -------------------------------------
        // your blob of binary as a byte array
        // byte[] blob = "someBinaryData".getBytes();
        // use the Base64 class to encode
        // String binaryAsAString = Base64.encodeBase64String(blob);
        // use the Base64 class to decode
        // byte[] blob2 = Base64.decodeBase64(binaryAsAString);
        // assert that the two blobs are equal
        // System.out.println("Equal : " + Boolean.toString(Arrays.equals(blob,
        // blob2)));
        // ---------------------------------------
        // encode with padding
        // String encoded = Base64.getEncoder().encodeToString(someByteArray);
        // encode without padding
        // String encoded =
        // Base64.getEncoder().withoutPadding().encodeToString(someByteArray);
        // decode a String
        // byte[] barr = Base64.getDecoder().decode(encoded);
    }
}
