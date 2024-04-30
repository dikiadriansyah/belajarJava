import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Encrypt_and_decrypt_data_with_public_private_keys {
    // Encrypt and Decrypt Data with Public / Private Keys/Enkripsi dan Dekripsi
    // Data dengan Kunci Publik / Pribadi

    // Untuk mengenkripsi data dengan kunci publik
    /*
     * final Cipher rsa = Cipher.getInstance("RSA");
     * rsa.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
     * rsa.update(message.getBytes());
     * final byte[] result = rsa.doFinal();
     * System.out.println("Message: " + message);
     * System.out.println("Encrypted: " + DatatypeConverter.printHexBinary(result));
     * 
     */

    // Menghasilkan output yang mirip dengan:
    /*
     * Message: Hello
     * Encrypted: 5641FBB9558ECFA9ED...
     * 
     */

    /*
     * Perhatikan bahwa saat membuat objek Cipher, Anda harus menentukan
     * transformasi yang kompatibel dengan tipe kunci yang digunakan. (Lihat Nama
     * Algoritma Standar JCA untuk daftar transformasi yang didukung.). Untuk data
     * enkripsi RSA, panjang message.getBytes() harus lebih kecil dari ukuran kunci.
     * Lihat Jawaban SO ini untuk detailnya.
     * 
     * Untuk mendekripsi data:
     * 
     * final Cipher rsa = Cipher.getInstance("RSA");
     * rsa.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
     * rsa.update(cipherText);
     * final String result = new String(rsa.doFinal());
     * System.out.println("Decrypted: " + result);
     */

    /*
     * Menghasilkan keluaran berikut:
     * Decrypted: Hello
     */

    public static void main(String[] args) throws Exception {
        try {
            // Generate Key Pair
            KeyPair keyPair = generateKeyPair();

            // Message to be encrypted
            String message = "Hello, World!";

            // Encryption process
            final Cipher rsa = Cipher.getInstance("RSA");
            rsa.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
            rsa.update(message.getBytes());
            final byte[] result = rsa.doFinal();

            // Display original message and encrypted result
            System.out.println("Message: " + message);
            System.out.println("Encrypted: " + DatatypeConverter.printHexBinary(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to generate Key Pair
    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // You can change this value as per your requirement
        return keyPairGenerator.generateKeyPair();
    }

}
