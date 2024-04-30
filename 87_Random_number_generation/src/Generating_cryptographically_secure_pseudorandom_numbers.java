import java.security.SecureRandom;
import java.util.Arrays;

public class Generating_cryptographically_secure_pseudorandom_numbers {
    /*
     * Generating cryptographically secure pseudorandom numbers/Menghasilkan nomor
     * pseudorandom yang aman secara kriptografis
     * 
     */

    /*
     * Random dan ThreadLocalRandom cukup baik untuk penggunaan sehari-hari, namun
     * memiliki masalah besar: Mereka didasarkan pada generator kongruensial linier,
     * sebuah algoritma yang keluarannya dapat diprediksi dengan lebih mudah. Oleh
     * karena itu, kedua kelas ini tidak cocok untuk penggunaan kriptografi (seperti
     * pembuatan kunci).
     * 
     * Seseorang dapat menggunakan java.security.SecureRandom dalam situasi di mana
     * diperlukan PRNG dengan keluaran yang sangat sulit diprediksi. Memprediksi
     * angka acak yang dibuat oleh instance kelas ini cukup sulit untuk diberi label
     * sebagai kelas tersebut aman secara kriptografis (cryptographically secure).
     */
    /*
     * import java.security.SecureRandom;
     * import java.util.Arrays;
     * public class Foo {
     * public static void main(String[] args) {
     * SecureRandom rng = new SecureRandom();
     * byte[] randomBytes = new byte[64];
     * rng.nextBytes(randomBytes); // Fills randomBytes with random bytes (duh)
     * System.out.println(Arrays.toString(randomBytes));
     * }
     * }
     */

    /*
     * Selain aman secara kriptografis, SecureRandom memiliki periode yang sangat
     * besar sebesar 2160, dibandingkan dengan periode Randoms sebesar 248. Namun,
     * ia memiliki satu kelemahan yaitu jauh lebih lambat dibandingkan Random dan
     * PRNG linier lainnya seperti Mersenne Twister dan Xorshift.
     * 
     * Perhatikan bahwa implementasi SecureRandom bergantung pada platform dan
     * penyedia. SecureRandom bawaannya (diberikan oleh penyedia SUN di
     * sun.security.provider.SecureRandom):
     * 
     * pada sistem mirip Unix, diunggulkan dengan data dari /dev/random dan/atau
     * /dev/urandom.
     * di Windows, diunggulkan dengan panggilan ke CryptGenRandom() di CryptoAPI.
     */

    public static void main(String[] args) {
        SecureRandom rng = new SecureRandom();
        byte[] randomBytes = new byte[64];
        rng.nextBytes(randomBytes); // Fills randomBytes with random bytes (duh)
        System.out.println(Arrays.toString(randomBytes));
        /*
         * [37, -50, 98, -111, -120, -39, 48, 86, 7, 103, -86, -18, 110, 115, 59, -35,
         * -3, -96, 55, -66, -1, 13, -119, 29, -31, -22, -56, 90, 93, 2, -37, -20, 63,
         * 35, 109, 91, 48, -37, 40, -110, 59, -26, -30, -67, 8, -62, -91, 116, -23, -5,
         * -26, 9, -53, 10, 53, -29,
         * -74, 127, -9, -91, 97, -18, -88, -53]
         */

    }
}
