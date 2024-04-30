import java.security.*;
import javax.crypto.*;
import java.nio.ByteBuffer;
import javax.crypto.spec.GCMParameterSpec;
// import java.security.spec.InvalidAlgorithmParameterException;

public class an_example_using_a_hybrid_cryptosystem_consisting_of_oaep_and_gcm {
    // An example using a hybrid cryptosystem consisting of OAEP and GCM/Contoh
    // penggunaan kriptosistem hibrid terdiri dari OAEP dan GCM

    /*
     * Contoh berikut mengenkripsi data dengan menggunakan kriptosistem hibrid yang
     * terdiri dari AES GCM dan OAEP, menggunakan ukuran parameter default dan
     * ukuran kunci AES 128 bit.
     * 
     * OAEP kurang rentan terhadap serangan oracle padding dibandingkan padding
     * PKCS#1 v1.5. GCM juga terlindungi dari serangan padding oracle.
     * 
     * Dekripsi dapat dilakukan dengan terlebih dahulu mengambil panjang kunci yang
     * dienkapsulasi dan kemudian mengambil kunci yang dienkapsulasi. Kunci yang
     * dienkapsulasi kemudian dapat didekripsi menggunakan kunci privat RSA yang
     * membentuk pasangan kunci dengan kunci publik. Setelah itu ciphertext
     * terenkripsi AES/GCM dapat didekripsi menjadi plaintext asli.
     */

    /*
     * Protokolnya terdiri dari:
     * 1. bidang panjang untuk kunci yang dibungkus (RSAPrivateKey melewatkan metode
     * getKeySize());
     * 2. kunci yang dibungkus/dienkapsulasi, dengan ukuran yang sama dengan ukuran
     * kunci RSA dalam byte;
     * 3. ciphertext GCM dan tag otentikasi 128 bit (secara otomatis ditambahkan
     * oleh Java).
     */

    /*
     * Catatan:
     * 1. Untuk menggunakan kode ini dengan benar, Anda harus menyediakan kunci RSA
     * minimal 2048 bit, lebih besar lebih baik (tetapi lebih lambat, terutama saat
     * dekripsi);
     * 2. Untuk menggunakan AES-256 Anda harus menginstal file kebijakan kriptografi
     * tak terbatas terlebih dahulu;
     * 3. Daripada membuat protokol Anda sendiri, Anda mungkin ingin menggunakan
     * format wadah seperti Sintaks Pesan Kriptografis (CMS / PKCS#7) atau PGP.
     */

    // Jadi inilah contohnya:

    /*
     * //Encrypts the data using a hybrid crypto-system which uses GCM to encrypt
     * //the data and OAEP to encrypt the AES key.
     * //The key size of the AES encryption will be 128 bit.
     * //All the default parameter choices are used for OAEP and GCM.
     * //@param publicKey the RSA public key used to wrap the AES key
     * //@param plaintext the plaintext to be encrypted, not altered
     * //@return the ciphertext
     * //@throws InvalidKeyException if the key is not an RSA public key
     * //@throws NullPointerException if the plaintext is null
     * 
     */

    /*
     * public static byte[] encryptData(PublicKey publicKey, byte[] plaintext)
     * throws InvalidKeyException, NullPointerException {
     * // --- create the RSA OAEP cipher ---
     * Cipher oaep;
     * try {
     * // SHA-1 is the default and not vulnerable in this setting
     * // use OAEPParameterSpec to configure more than just the hash
     * oaep = Cipher.getInstance("RSA/ECB/OAEPwithSHA1andMGF1Padding");
     * } catch (NoSuchAlgorithmException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for RSA cipher (mandatory algorithm for runtimes)"
     * ,
     * e);
     * } catch (NoSuchPaddingException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for OAEP padding (present in the standard Java
     * runtime sinze XX)", e);
     * }
     * oaep.init(Cipher.WRAP_MODE, publicKey);
     * // --- wrap the plaintext in a buffer
     * 
     * // will throw NullPointerException if plaintext is null
     * ByteBuffer plaintextBuffer = ByteBuffer.wrap(plaintext);
     * // --- generate a new AES secret key ---
     * KeyGenerator aesKeyGenerator;
     * try {
     * aesKeyGenerator = KeyGenerator.getInstance("AES");
     * } catch (NoSuchAlgorithmException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for AES key generator (mandatory algorithm for
     * runtimes)", e);
     * }
     * // for AES-192 and 256 make sure you've got the rights (install the
     * // Unlimited Crypto Policy files)
     * aesKeyGenerator.init(128);
     * SecretKey aesKey = aesKeyGenerator.generateKey();
     * 
     * // --- wrap the new AES secret key ---
     * 
     * byte[] wrappedKey;
     * try {
     * wrappedKey = oaep.wrap(aesKey);
     * } catch (IllegalBlockSizeException e) {
     * throw new RuntimeException(
     * "AES key should always fit OAEP with normal sized RSA key", e);
     * }
     * // --- setup the AES GCM cipher mode ---
     * 
     * Cipher aesGCM;
     * try {
     * aesGCM = Cipher.getInstance("AES/GCM/Nopadding");
     * // we can get away with a zero nonce since the key is randomly generated
     * // 128 bits is the recommended (maximum) value for the tag size
     * // 12 bytes (96 bits) is the default nonce size for GCM mode encryption
     * GCMParameterSpec staticParameterSpec = new GCMParameterSpec(128, new
     * byte[12]);
     * aesGCM.init(Cipher.ENCRYPT_MODE, aesKey, staticParameterSpec);
     * } catch (NoSuchAlgorithmException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for AES cipher (mandatory algorithm for runtimes)"
     * ,
     * e);
     * } catch (NoSuchPaddingException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for GCM (present in the standard Java runtime
     * sinze
     * XX)", e);
     * } catch (InvalidAlgorithmParameterException e) {
     * throw new RuntimeException(
     * "IvParameterSpec not accepted by this implementation of GCM", e);
     * }
     * // --- create a buffer of the right size for our own protocol ---
     * ByteBuffer ciphertextBuffer = ByteBuffer.allocate(
     * Short.BYTES
     * + oaep.getOutputSize(128 / Byte.SIZE)
     * + aesGCM.getOutputSize(plaintext.length));
     * 
     * // - element 1: make sure that we know the size of the wrapped key
     * ciphertextBuffer.putShort((short) wrappedKey.length);
     * 
     * // - element 2: put in the wrapped key
     * ciphertextBuffer.put(wrappedKey);
     * // - element 3: GCM encrypt into buffer
     * try {
     * aesGCM.doFinal(plaintextBuffer, ciphertextBuffer);
     * } catch (ShortBufferException | IllegalBlockSizeException |
     * BadPaddingException e) {
     * throw new RuntimeException("Cryptographic exception, AES/GCM encryption
     * should not fail
     * here", e);
     * }
     * return ciphertextBuffer.array();
     * }
     * 
     */

    /*
     * Tentu saja enkripsi tidak akan berguna tanpa dekripsi. Perhatikan bahwa ini
     * akan mengembalikan informasi minimal jika dekripsi gagal.
     */

    /*
     * //Decrypts the data using a hybrid crypto-system which uses GCM to encrypt
     * //the data and OAEP to encrypt the AES key. All the default parameter
     * //choices are used for OAEP and GCM.
     * //@param privateKey
     * //the RSA private key used to unwrap the AES key
     * //@param ciphertext
     * //the ciphertext to be encrypted, not altered
     * //@return the plaintext
     * //@throws InvalidKeyException
     * //if the key is not an RSA private key
     * //@throws NullPointerException
     * //if the ciphertext is null
     * //@throws IllegalArgumentException
     * //with the message "Invalid ciphertext" if the ciphertext is invalid
     * (minimize information leakage)
     * 
     * public static byte[] decryptData(PrivateKey privateKey, byte[] ciphertext)
     * throws InvalidKeyException, NullPointerException {
     * // --- create the RSA OAEP cipher ---
     * Cipher oaep;
     * try {
     * // SHA-1 is the default and not vulnerable in this setting
     * // use OAEPParameterSpec to configure more than just the hash
     * oaep = Cipher.getInstance("RSA/ECB/OAEPwithSHA1andMGF1Padding");
     * } catch (NoSuchAlgorithmException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for RSA cipher (mandatory algorithm for runtimes)"
     * ,
     * e);
     * } catch (NoSuchPaddingException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for OAEP padding (present in the standard Java
     * runtime sinze XX)",
     * e);
     * }
     * oaep.init(Cipher.UNWRAP_MODE, privateKey);
     * // --- wrap the ciphertext in a buffer
     * // will throw NullPointerException if ciphertext is null
     * ByteBuffer ciphertextBuffer = ByteBuffer.wrap(ciphertext);
     * // sanity check #1
     * if (ciphertextBuffer.remaining() < 2) {
     * throw new IllegalArgumentException("Invalid ciphertext");
     * }
     * // - element 1: the length of the encapsulated key
     * int wrappedKeySize = ciphertextBuffer.getShort() & 0xFFFF;
     * // sanity check #2
     * if (ciphertextBuffer.remaining() < wrappedKeySize + 128 / Byte.SIZE) {
     * throw new IllegalArgumentException("Invalid ciphertext");
     * }
     * // --- unwrap the AES secret key ---
     * byte[] wrappedKey = new byte[wrappedKeySize];
     * // - element 2: the encapsulated key
     * ciphertextBuffer.get(wrappedKey);
     * SecretKey aesKey;
     * try {
     * aesKey = (SecretKey) oaep.unwrap(wrappedKey, "AES",
     * Cipher.SECRET_KEY);
     * } catch (NoSuchAlgorithmException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for AES cipher (mandatory algorithm for runtimes)"
     * ,
     * e);
     * } catch (InvalidKeyException e) {
     * throw new RuntimeException(
     * "Invalid ciphertext");
     * }
     * // --- setup the AES GCM cipher mode ---
     * Cipher aesGCM;
     * try {
     * aesGCM = Cipher.getInstance("AES/GCM/Nopadding");
     * // we can get away with a zero nonce since the key is randomly
     * // generated
     * // 128 bits is the recommended (maximum) value for the tag size
     * // 12 bytes (96 bits) is the default nonce size for GCM mode
     * // encryption
     * GCMParameterSpec staticParameterSpec = new GCMParameterSpec(128,
     * new byte[12]);
     * aesGCM.init(Cipher.DECRYPT_MODE, aesKey, staticParameterSpec);
     * } catch (NoSuchAlgorithmException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for AES cipher (mandatory algorithm for runtimes)"
     * ,
     * e);
     * } catch (NoSuchPaddingException e) {
     * throw new RuntimeException(
     * "Runtime doesn't have support for GCM (present in the standard Java runtime
     * sinze
     * XX)",
     * e);
     * } catch (InvalidAlgorithmParameterException e) {
     * throw new
     * RuntimeException("IvParameterSpec not accepted by this implementation of GCM"
     * ,e);
     * }
     * // --- create a buffer of the right size for our own protocol ---
     * ByteBuffer plaintextBuffer = ByteBuffer.allocate(aesGCM
     * .getOutputSize(ciphertextBuffer.remaining()));
     * // - element 3: GCM ciphertext
     * try {
     * aesGCM.doFinal(ciphertextBuffer, plaintextBuffer);
     * } catch (ShortBufferException | IllegalBlockSizeException
     * | BadPaddingException e) {
     * throw new RuntimeException(
     * "Invalid ciphertext");
     * }
     * return plaintextBuffer.array();
     * }
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ----------------
        try {
            // Generate RSA key pair (just for demonstration purposes, you should use real
            // keys)
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();

            PrivateKey privateKey = keyPair.getPrivate();

            // Data to be encrypted
            byte[] plaintext = "Hello, World!".getBytes();

            // Encrypt data
            byte[] ciphertext = encryptData(publicKey, plaintext);

            // Display encrypted data
            System.out.println("Encrypted data: " + bytesToHex(ciphertext));

            // Decrypt data
            byte[] decryptedText = decryptData(privateKey, ciphertext);

            // Display decrypted data
            System.out.println("Decrypted data: " + new String(decryptedText));

        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
         * output:
         * Encrypted data:
         * 01001E819BF7AA7F37896DDD3B059F22058C7DCFE5CBF02968926F797CD568A707F7437780A2EAAF6731AECC617E5D229D29D29A232B16F41A436F0A5A4907A7923E0D058553A059541FD753FF84547E8A98CB5624919816A15DFB251625E9C291B6FBEB465CFD033BE2454282E4A997C1DF909EE6EBD087E320A860D1295B62146B8FFE9DC714751966FBDE4C7D1E47D9F6642BB79EABF6AF4CFDD2322BA80B4BE8DC93D7928FB08405508CB9346927E37EBC01BB434C6C174CD4DA503D60E3AA24B3251295C24CB6E1C9AE1B06AFA7FA1E66E619C1938BD46426E4F2D9E1CFADBE8C6E048CFE8B7007D6E9DF0CC4464D1C8ABC602F01B9B69C307DB82A2274FD8D5E9525C3BA13C88E00036C343EAA1E10A2265A83EA7C0EED6C9A087343
         * 
         * Decrypted data: Hello, World!
         */

    }

    public static byte[] encryptData(PublicKey publicKey, byte[] plaintext)
            throws InvalidKeyException, NullPointerException {
        // --- create the RSA OAEP cipher ---
        Cipher oaep;
        try {
            oaep = Cipher.getInstance("RSA/ECB/OAEPwithSHA1andMGF1Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException("Exception during RSA OAEP cipher initialization", e);
        }
        oaep.init(Cipher.WRAP_MODE, publicKey);

        // --- wrap the plaintext in a buffer
        ByteBuffer plaintextBuffer = ByteBuffer.wrap(plaintext);

        // --- generate a new AES secret key ---
        KeyGenerator aesKeyGenerator;
        try {
            aesKeyGenerator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Exception during AES key generation", e);
        }
        aesKeyGenerator.init(128);
        SecretKey aesKey = aesKeyGenerator.generateKey();

        // --- wrap the new AES secret key ---
        byte[] wrappedKey;
        try {
            wrappedKey = oaep.wrap(aesKey);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("Exception during AES key wrapping", e);
        }

        // --- setup the AES GCM cipher mode ---
        Cipher aesGCM;
        try {
            aesGCM = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec staticParameterSpec = new GCMParameterSpec(128, new byte[12]);
            aesGCM.init(Cipher.ENCRYPT_MODE, aesKey, staticParameterSpec);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException("Exception during AES GCM cipher initialization", e);
        }

        // --- create a buffer of the right size for our own protocol ---
        ByteBuffer ciphertextBuffer = ByteBuffer.allocate(
                Short.BYTES
                        + oaep.getOutputSize(128 / Byte.SIZE)
                        + aesGCM.getOutputSize(plaintext.length));

        // - element 1: make sure that we know the size of the wrapped key
        ciphertextBuffer.putShort((short) wrappedKey.length);

        // - element 2: put in the wrapped key
        ciphertextBuffer.put(wrappedKey);

        // - element 3: GCM encrypt into buffer
        try {
            aesGCM.doFinal(plaintextBuffer, ciphertextBuffer);
        } catch (ShortBufferException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException("Exception during AES GCM encryption", e);
        }
        return ciphertextBuffer.array();
    }

    // Utility method to convert byte array to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }

    public static byte[] decryptData(PrivateKey privateKey, byte[] ciphertext)
            throws InvalidKeyException, NullPointerException {
        // --- create the RSA OAEP cipher ---
        Cipher oaep;
        try {
            oaep = Cipher.getInstance("RSA/ECB/OAEPwithSHA1andMGF1Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException("Exception during RSA OAEP cipher initialization", e);
        }
        oaep.init(Cipher.UNWRAP_MODE, privateKey);

        // --- wrap the ciphertext in a buffer
        ByteBuffer ciphertextBuffer = ByteBuffer.wrap(ciphertext);

        // Sanity check #1
        if (ciphertextBuffer.remaining() < 2) {
            throw new IllegalArgumentException("Invalid ciphertext");
        }

        // - element 1: the length of the encapsulated key
        int wrappedKeySize = ciphertextBuffer.getShort() & 0xFFFF;

        // Sanity check #2
        if (ciphertextBuffer.remaining() < wrappedKeySize + 128 / Byte.SIZE) {
            throw new IllegalArgumentException("Invalid ciphertext");
        }

        // --- unwrap the AES secret key ---
        byte[] wrappedKey = new byte[wrappedKeySize];
        ciphertextBuffer.get(wrappedKey);
        SecretKey aesKey;
        try {
            aesKey = (SecretKey) oaep.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Exception during AES key unwrapping", e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("Invalid ciphertext", e);
        }

        // --- setup the AES GCM cipher mode ---
        Cipher aesGCM;
        try {
            aesGCM = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec staticParameterSpec = new GCMParameterSpec(128, new byte[12]);
            aesGCM.init(Cipher.DECRYPT_MODE, aesKey, staticParameterSpec);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException("Exception during AES GCM cipher initialization", e);
        }

        // --- create a buffer of the right size for our own protocol ---
        ByteBuffer plaintextBuffer = ByteBuffer.allocate(aesGCM.getOutputSize(ciphertextBuffer.remaining()));

        // - element 3: GCM ciphertext
        try {
            aesGCM.doFinal(ciphertextBuffer, plaintextBuffer);
        } catch (ShortBufferException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException("Exception during AES GCM decryption", e);
        }
        return plaintextBuffer.array();
    }

}
