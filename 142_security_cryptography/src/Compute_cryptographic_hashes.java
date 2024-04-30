import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

public class Compute_cryptographic_hashes {
    // Compute Cryptographic Hashes/Hitung Hash Kriptografi

    // Untuk menghitung hash dari blok data yang relatif kecil menggunakan algoritma
    // yang berbeda:
    /*
     * final MessageDigest md5 = MessageDigest.getInstance("MD5");
     * final MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
     * final MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
     * final byte[] data = "FOO BAR".getBytes();
     * System.out.println("MD5 hash: " +
     * DatatypeConverter.printHexBinary(md5.digest(data)));
     * System.out.println("SHA1 hash: " +
     * DatatypeConverter.printHexBinary(sha1.digest(data)));
     * System.out.println("SHA256 hash: " +
     * DatatypeConverter.printHexBinary(sha256.digest(data)));
     */

    // Menghasilkan keluaran ini:
    /*
     * MD5 hash: E99E768582F6DD5A3BA2D9C849DF736E
     * SHA1 hash: 0135FAA6323685BA8A8FF8D3F955F0C36949D8FB
     * SHA256 hash: 8D35C97BCD902B96D1B551741BBE8A7F50BB5A690B4D0225482EAA63DBFB9DED
     */

    /*
     * Algoritme tambahan mungkin tersedia tergantung pada implementasi platform
     * Java Anda.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // ---------------------
        try {
            final MessageDigest md5 = MessageDigest.getInstance("MD5");
            final MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            final MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            final byte[] data = "FOO BAR".getBytes();

            System.out.println("MD5 hash: " + DatatypeConverter.printHexBinary(md5.digest(data)));
            System.out.println("SHA1 hash: " + DatatypeConverter.printHexBinary(sha1.digest(data)));
            System.out.println("SHA256 hash: " + DatatypeConverter.printHexBinary(sha256.digest(data)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
