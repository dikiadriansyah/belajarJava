import java.nio.charset.StandardCharsets;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Conversion_to_from_bytes {
    // Conversion to / from bytes / Konversi ke / dari byte

    /*
     * Untuk mengkodekan string ke dalam array byte, Anda cukup menggunakan metode
     * String#getBytes(), dengan salah satu rangkaian karakter standar tersedia pada
     * runtime Java mana pun:
     * byte[] bytes = "test".getBytes(StandardCharsets.UTF_8);
     * 
     */

    // dan untuk memecahkan kode:
    // String testString = new String(bytes, StandardCharsets.UTF_8);

    // Anda dapat menyederhanakan panggilan lebih lanjut dengan menggunakan impor
    // statis:
    /*
     * import static java.nio.charset.StandardCharsets.UTF_8;
     * ...
     * byte[] bytes = "test".getBytes(UTF_8);
     * 
     */

    // Untuk rangkaian karakter yang kurang umum, Anda dapat menunjukkan rangkaian
    // karakter dengan string:
    // byte[] bytes = "test".getBytes("UTF-8");

    // dan sebaliknya:
    // String testString = new String (bytes, "UTF-8");

    // namun ini berarti Anda harus menangani UnsupportedCharsetException yang
    // dicentang

    /*
     * Panggilan berikut akan menggunakan kumpulan karakter default. Kumpulan
     * karakter default adalah spesifik platform dan umum berbeda antara platform
     * Windows, Mac dan Linux.
     * 
     * byte[] bytes = "test".getBytes();
     */

    // dan sebaliknya:
    // String testString = new String(bytes);
    /*
     * Perhatikan bahwa karakter dan byte yang tidak valid dapat diganti atau
     * dilewati dengan metode ini. Untuk kontrol lebih besar - untuk
     * contoh untuk memvalidasi input - Anda dianjurkan untuk menggunakan kelas
     * CharsetEncoder dan CharsetDecoder.
     */

    public static void main(String[] args) {
        // byte[] bytes = "test".getBytes(StandardCharsets.UTF_8);
        // String testString = new String(bytes, StandardCharsets.UTF_8);

        // System.out.println("Byte array: " + bytes);
        /*
         * output:
         * Byte array: [B@53bd815b
         * 
         */
        // System.out.println("String hasil: " + testString);
        /*
         * output:
         * 
         * String hasil: test
         */

        // ------------
        // byte[] bytes = "test".getBytes(UTF_8);
        // System.out.println("Byte array: " + bytes);
        // output:Byte array: [B@53bd815b
        // -----------------
        byte[] bytes = "test".getBytes();
        String testString = new String(bytes);
        System.out.println("Byte array: " + bytes);
        System.out.println("Uji array: " + testString);
        /*
         * output:
         * Byte array: [B@2401f4c3
         * Uji array: test
         */

    }
}
