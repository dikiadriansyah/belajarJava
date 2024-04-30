import java.util.Base64;
import java.security.*;
import java.util.Base64;

public class Compute_and_verify_digital_signatures {
    // Compute and Verify Digital Signatures/Hitung dan Verifikasi Tanda Tangan
    // Digital

    /*
     * Untuk menghitung tanda tangan:
     * final PrivateKey privateKey = keyPair.getPrivate();
     * final byte[] data = "FOO BAR".getBytes();
     * final Signature signer = Signature.getInstance("SHA1withRSA");
     * signer.initSign(privateKey);
     * signer.update(data);
     * final byte[] signature = signer.sign();
     * 
     */

    /*
     * Perhatikan bahwa algoritma tanda tangan harus kompatibel dengan algoritma
     * yang digunakan untuk menghasilkan pasangan kunci.
     * Untuk memverifikasi tanda tangan:
     * 
     * final PublicKey publicKey = keyPair.getPublic();
     * final Signature verifier = Signature.getInstance("SHA1withRSA");
     * verifier.initVerify(publicKey);
     * verifier.update(data);
     * System.out.println("Signature: " + verifier.verify(signature));
     * 
     * 
     */
    // Menghasilkan keluaran ini:
    // Signature: true

    public static void main(String[] args) throws Exception {

        // Membuat pasangan kunci (KeyPair)
        // KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        // keyPairGenerator.initialize(2048); // Panjang kunci 2048 bit
        // KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Mendapatkan kunci privat dari pasangan kunci
        // final PrivateKey privateKey = keyPair.getPrivate();

        // Data yang akan ditandatangani
        // final byte[] data = "FOO BAR".getBytes();

        // Membuat objek Signature dengan algoritma "SHA1withRSA"
        // final Signature signer = Signature.getInstance("SHA1withRSA");

        // Menginisialisasi objek Signature untuk operasi penandatanganan dengan kunci
        // privat
        // signer.initSign(privateKey);

        // Memasukkan data ke dalam objek Signature
        // signer.update(data);

        // Melakukan penandatanganan data
        // final byte[] signature = signer.sign();

        // Menampilkan hasil penandatanganan
        // System.out.println("Signature: " +
        // Base64.getEncoder().encodeToString(signature));
        /*
         * output:
         * Signature:
         * Ed0C4sx5D8Ujq2SEgR1lZ4LP0rEIMGQjZvGPPBqLuorapNSXKkh9GcRueOnrAuZf3zgGO33H+/R/
         * pY7Fmq2YYi2gTEPVBb54fpWEYP25eMgOUFl//v2NqHjytlr2f1sW7tw3Dh1/
         * iGrVwhoNOuWK8M2OGuCju+tgeDiXPgxLrXa5VjBZH2VztZM7u+
         * NPJoFsfFY6tMCGPxdgkvGTYvfA9AZYzg/u3M4GyjBGSKVac7TcPym1jVbLUkGRtjwC/
         * OVSpyDsXM5rNjIm8NFeoEDjkn4Pswwl8ZLhLfrlb9qWCmcQV21nzINr/
         * iyQGSUcg56xt2oD97J3S4OASg7+maVH/w==
         */

        // --------------------------
        // Membuat pasangan kunci (KeyPair)
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Panjang kunci 2048 bit
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Data yang akan diverifikasi
        final byte[] data = "FOO BAR".getBytes();

        // Mendapatkan kunci publik dari pasangan kunci
        final PublicKey publicKey = keyPair.getPublic();

        // Membuat objek Signature dengan algoritma "SHA1withRSA"
        final Signature verifier = Signature.getInstance("SHA1withRSA");

        // Menginisialisasi objek Signature untuk operasi verifikasi dengan kunci publik
        verifier.initVerify(publicKey);

        // Memasukkan data ke dalam objek Signature
        verifier.update(data);

        final byte[] signature = generateSignature(data, keyPair.getPrivate());

        // Memverifikasi tanda tangan
        boolean isSignatureValid = verifier.verify(signature);

        // Menampilkan hasil verifikasi
        System.out.println("Signature valid: " + isSignatureValid);// output: Signature valid: true
    }

    // Metode untuk menghasilkan tanda tangan
    private static byte[] generateSignature(byte[] data, PrivateKey privateKey) throws Exception {
        // Membuat objek Signature dengan algoritma "SHA1withRSA"
        Signature signer = Signature.getInstance("SHA1withRSA");

        // Menginisialisasi objek Signature untuk operasi penandatanganan dengan kunci
        // privat
        signer.initSign(privateKey);

        // Memasukkan data ke dalam objek Signature
        signer.update(data);

        // Melakukan penandatanganan data
        return signer.sign();
    }

}
