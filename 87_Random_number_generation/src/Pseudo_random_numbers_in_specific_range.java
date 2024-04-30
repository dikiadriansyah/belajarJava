
// import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Pseudo_random_numbers_in_specific_range {
    // Pseudo Random Numbers in Specific Range/Bilangan Acak Semu dalam Rentang
    // Tertentu

    /*
     * Metode nextInt(int bound) dari Random menerima batas eksklusif atas, yaitu
     * angka yang nilai acaknya harus lebih kecil darinya. Namun, hanya metode
     * nextInt yang menerima batasan; nextLong, nextDouble, dll.
     * tidak.
     * 
     * Random random = new Random();
     * random.nextInt(1000); // 0 - 999
     * int number = 10 + random.nextInt(100); // number is in the range of 10 to 109
     */

    /*
     * Mulai Java 1.7, Anda juga dapat menggunakan ThreadLocalRandom (sumber). Kelas
     * ini menyediakan PRNG (pembuat nomor acak semu) yang aman untuk thread.
     * Perhatikan bahwa metode nextInt kelas ini menerima batas atas dan bawah.
     * 
     * import java.util.concurrent.ThreadLocalRandom;
     * // nextInt is normally exclusive of the top value,
     * // so add 1 to make it inclusive
     * ThreadLocalRandom.current().nextInt(min, max + 1);
     */

    /*
     * Perhatikan bahwa dokumentasi resmi menyatakan bahwa nextInt(int bound)
     * dapat melakukan hal-hal aneh ketika bound mendekati 230+1
     * (penekanan ditambahkan):
     * Algoritmenya sedikit rumit. Ia menolak nilai-nilai yang akan mengakibatkan
     * distribusi tidak merata (karena fakta bahwa 2^31 tidak habis dibagi n).
     * Peluang suatu nilai ditolak bergantung pada n. Kasus terburuknya adalah
     * n=2^30+1, yang mana probabilitas penolakannya adalah 1/2, dan jumlah iterasi
     * yang diharapkan sebelum perulangan berakhir adalah 2.
     */

    /*
     * Dengan kata lain, menentukan batas akan (sedikit) menurunkan kinerja metode
     * nextInt, dan penurunan kinerja ini akan menjadi lebih jelas ketika batas
     * bound setengah nilai int maksimal.
     * 
     * Random random = new Random();
     * random.nextInt(1000); // 0 - 999
     * int number = 10 + random.nextInt(100); // number is in the range of 10 to 109
     */

    /*
     * Mulai Java 1.7, Anda juga dapat menggunakan ThreadLocalRandom (sumber). Kelas
     * ini menyediakan PRNG (pseudorandom number generator) yang aman untuk thread.
     * Perhatikan bahwa metode nextInt kelas ini menerima batas atas dan bawah.
     * 
     * import java.util.concurrent.ThreadLocalRandom;
     * // nextInt is normally exclusive of the top value,
     * // so add 1 to make it inclusive
     * ThreadLocalRandom.current().nextInt(min, max + 1);
     */

    /*
     * Perhatikan bahwa dokumentasi resmi menyatakan bahwa nextInt(int bound)
     * dapat melakukan hal-hal aneh ketika terikat mendekati 230+1
     * (penekanan ditambahkan):
     * 
     * Algoritmenya sedikit rumit. Ia menolak nilai-nilai yang akan menghasilkan
     * distribusi yang tidak merata (karena
     * fakta bahwa 2^31 tidak habis dibagi n). Peluang suatu nilai ditolak
     * bergantung pada n. Kasus terburuknya adalah n=2^30+1, yang mana probabilitas
     * penolakannya adalah 1/2, dan jumlah iterasi yang diharapkan sebelum
     * perulangan berakhir adalah 2.
     */

    /*
     * Dengan kata lain, menentukan batas akan (sedikit) menurunkan kinerja metode
     * nextInt, dan ini
     * penurunan kinerja akan menjadi lebih nyata ketika batas mendekati setengah
     * nilai int maksimal.
     */

    public static void main(String[] args) {
        // Random random = new Random();
        // int randomValue1 = random.nextInt(1000); // Random integer between 0 and 999
        // int randomValue2 = 10 + random.nextInt(100); // Random integer between 10 and
        // 109
        // System.out.println("Random value between 0 and 999: " + randomValue1);
        /*
         * output:
         * Random value between 0 and 999: 369
         *
         */
        // System.out.println("Random value between 10 and 109: " + randomValue2);
        // output: Random value between 10 and 109: 88
        // -------------
        int min = 5; // Nilai minimum
        int max = 10; // Nilai maksimum

        // Menghasilkan angka acak antara min dan max (inklusif)
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        // Menampilkan hasil
        System.out.println("Angka acak antara " + min + " dan " + max + " adalah: " + randomNum);
        /*
         * output:
         * Angka acak antara 5 dan 10 adalah: 8
         */
    }
}
