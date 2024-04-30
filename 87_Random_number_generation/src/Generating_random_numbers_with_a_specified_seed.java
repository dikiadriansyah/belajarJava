import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generating_random_numbers_with_a_specified_seed {
    // Generating Random Numbers with a Specified Seed/Menghasilkan Angka Acak
    // dengan Seed Tertentu

    /*
     * //Creates a Random instance with a seed of 12345.
     * Random random = new Random(12345L);
     * //Gets a ThreadLocalRandom instance
     * ThreadLocalRandom tlr = ThreadLocalRandom.current();
     * //Set the instance's seed.
     * tlr.setSeed(12345L);
     */

    /*
     * Menggunakan seed yang sama untuk menghasilkan angka acak akan menghasilkan
     * angka yang sama setiap saat, jadi menyetel seed yang berbeda untuk setiap
     * instance Random adalah ide bagus jika Anda tidak ingin mendapatkan angka
     * duplikat.
     * 
     * Metode yang bagus untuk mendapatkan Long yang berbeda untuk setiap panggilan
     * adalah System.currentTimeMillis():
     * 
     * Random random = new Random(System.currentTimeMillis());
     * ThreadLocalRandom.current().setSeed(System.currentTimeMillis());
     */

    public static void main(String[] args) {
        // Creates a Random instance with a seed of 12345.
        // Random random = new Random(12345L);

        // Gets a ThreadLocalRandom instance
        // ThreadLocalRandom tlr = ThreadLocalRandom.current();

        // Set the instance's seed.
        // tlr.setSeed(12345L);

        // Print some random numbers generated using Random class
        // System.out.println("Random numbers generated using Random class:");
        // for (int i = 0; i < 5; i++) {
        // System.out.println(random.nextInt(100));
        // }

        // Print some random numbers generated using ThreadLocalRandom class
        // System.out.println("\nRandom numbers generated using ThreadLocalRandom
        // class:");
        // for (int i = 0; i < 5; i++) {
        // System.out.println(tlr.nextInt(100));
        // }
        // ----------------
        // Menggunakan Random dengan seed waktu saat ini
        Random random = new Random(System.currentTimeMillis());
        int randomNumber1 = random.nextInt(100);
        System.out.println("Random number using Random with current time seed: " + randomNumber1);
        /*
         * output:
         * Random number using Random with current time seed: 16
         */

        // Menggunakan ThreadLocalRandom dengan seed waktu saat ini
        ThreadLocalRandom.current().setSeed(System.currentTimeMillis());
        int randomNumber2 = ThreadLocalRandom.current().nextInt(100);
        System.out.println("Random number using ThreadLocalRandom with current time seed: " + randomNumber2);

    }
}
