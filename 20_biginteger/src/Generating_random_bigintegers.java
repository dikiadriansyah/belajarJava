import java.math.BigInteger;
import java.security.SecureRandom;

public class Generating_random_bigintegers {
    // Generating random BigIntegers
    /*
     * Kelas BigInteger memiliki konstruktor yang didedikasikan untuk menghasilkan
     * BigInteger acak, jika diberi contoh
     * java.util.Random dan int yang menentukan berapa banyak bit yang dimiliki
     * BigInteger. Penggunaannya cukup sederhana -
     * ketika Anda memanggil konstruktor BigInteger(int, Random) seperti ini:
     */
    public static void main(String[] args) {
        BigInteger box1 = new BigInteger("2");
        // maka Anda akan mendapatkan BigInteger yang nilainya antara 0 (inklusif) dan
        // 2bitCount (eksklusif)

        /*
         * Ini juga berarti bahwa BigInteger baru (2147483647, sourceOfRandomness) dapat
         * mengembalikan semua BigInteger positif diberikan waktu yang cukup.
         * 
         * Apa yang akan menjadi sourceOfRandomness terserah Anda. Misalnya, new
         * Random() sudah cukup baik dalam banyak kasus:
         * new BigInteger(32, new Random());
         * 
         * Jika Anda ingin memberikan kecepatan untuk nomor acak berkualitas lebih
         * tinggi, Anda dapat menggunakan yang baru
         * ="https://docs.Oracle.com/javase/8/docs/api/java/security/SecureRandom.html"
         * rel="nofollow
         * noreferrer">SecureRandom() sebagai gantinya:
         * 
         */
        // somewhere in the code...
        new BigInteger(32, new SecureRandom());

        /*
         * Anda bahkan dapat mengimplementasikan algoritma saat itu juga dengan kelas
         * anonim! Perhatikan bahwa meluncurkan algoritme RNG Anda sendiri akan
         * menghasilkan keacakan berkualitas rendah, jadi selalu pastikan untuk
         * menggunakan algoritme yang terbukti
         * layak kecuali Anda ingin BigInteger yang dihasilkan dapat diprediksi.
         */
        // new BigInteger(32, new Random() {
        // int seed = 0;
        // @Override
        // protected int next(int bits) {
        // seed = ((22695477 * seed) + 1) & 2147483647; // Values shamelessly stolen
        // from
        // ="https://en.wikipedia.org/wiki/Linear_congruential_generator#Parameters_in_common_use"
        // rel="nofollow
        // noreferrer">Wikipedia return seed; } });

    }
}
