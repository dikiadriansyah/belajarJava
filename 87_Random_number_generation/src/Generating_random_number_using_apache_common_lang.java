import java.util.*;

public class Generating_random_number_using_apache_common_lang {
    // Generating Random number using apachecommon lang3/Menghasilkan nomor Acak
    // menggunakan apache common lang3

    /*
     * Kita dapat menggunakan org.apache.commons.lang3.RandomUtils untuk
     * menghasilkan angka acak menggunakan satu baris.
     * int x = RandomUtils.nextInt(1, 1000);
     */

    /*
     * Metode nextInt(int startInclusive, int endExclusive) mengambil rentang.
     * 
     * Selain int, kita dapat menghasilkan long, double, float, dan byte acak
     * menggunakan kelas ini.
     * 
     * Kelas RandomUtils berisi metode berikut
     */

    /*
     * static byte[] nextBytes(int count); //Creates an array of random bytes.
     * 
     * static double nextDouble(); //Returns a random double within 0 -
     * Double.MAX_VALUE
     * 
     * static double nextDouble(double startInclusive, double endInclusive);
     * //Returns a random double
     * // within the specified range.
     * 
     * static float nextFloat(); //Returns a random float within 0 - Float.MAX_VALUE
     * 
     * static float nextFloat(float startInclusive, float endInclusive); //Returns a
     * random float within
     * // the specified range.
     * 
     * static int nextInt() //Returns a random int within 0 - Integer.MAX_VALUE
     * 
     * static int nextInt(int startInclusive, int endExclusive) //Returns a random
     * integer within the
     * // specified range.
     * 
     * static long nextLong() //Returns a random long within 0 - Long.MAX_VALUE
     * 
     * static long nextLong(long startInclusive, long endExclusive) //Returns a
     * random long within the
     * // specified range.
     */

    private static Random random = new Random();

    public static void main(String[] args) {
        int count = 5;
        double startInclusive = 10.0;
        double endInclusive = 20.0;
        float startFloatInclusive = 5.0f;
        float endFloatInclusive = 15.0f;
        int startIntInclusive = 100;
        int endIntExclusive = 200;
        long startLongInclusive = 1000L;
        long endLongExclusive = 2000L;

        byte[] randomBytes = nextBytes(count);
        double randomDouble = nextDouble();
        double randomDoubleInRange = nextDouble(startInclusive, endInclusive);
        float randomFloat = nextFloat();
        float randomFloatInRange = nextFloat(startFloatInclusive, endFloatInclusive);
        int randomInt = nextInt();
        int randomIntInRange = nextInt(startIntInclusive, endIntExclusive);
        long randomLong = nextLong();
        long randomLongInRange = nextLong(startLongInclusive, endLongExclusive);

        System.out.println("Random Double: " + randomDouble); // output: Random Double: 0.5755685087796338
        System.out.println("Random Double in Range: " + randomDoubleInRange);// output: Random Double in Range:
                                                                             // 18.16175623058694
        System.out.println("Random Float: " + randomFloat);// output: Random Float: 0.72669435
        System.out.println("Random Float in Range: " + randomFloatInRange);// output: Random Float in Range: 13.271293
        System.out.println("Random Int: " + randomInt);// output: Random Int: -536272468
        System.out.println("Random Int in Range: " + randomIntInRange);// output: Random Int in Range: 134
        System.out.println("Random Long: " + randomLong);// output: Random Long: 4366374921876608810
        System.out.println("Random Long in Range: " + randomLongInRange);// output: Random Long in Range: 1135
    }

    static byte[] nextBytes(int count) {
        byte[] bytes = new byte[count];
        random.nextBytes(bytes);
        return bytes;
    } // Creates an array of random bytes.

    static double nextDouble() {
        return random.nextDouble();
    } // Returns a random double within 0 - Double.MAX_VALUE

    static double nextDouble(double startInclusive, double endInclusive) {
        return startInclusive + (endInclusive - startInclusive) * random.nextDouble();
    } // Returns a random double
      // within the specified range.

    static float nextFloat() {
        return random.nextFloat();
    } // Returns a random float within 0 - Float.MAX_VALUE

    static float nextFloat(float startInclusive, float endInclusive) {
        return startInclusive + (endInclusive - startInclusive) * random.nextFloat();
    } // Returns a random float within
      // the specified range.

    static int nextInt() {
        return random.nextInt();
    } // Returns a random int within 0 - Integer.MAX_VALUE

    static int nextInt(int startInclusive, int endExclusive) {
        return startInclusive + random.nextInt(endExclusive - startInclusive);
    } // Returns a random integer within the
      // specified range.

    static long nextLong() {
        return random.nextLong();
    } // Returns a random long within 0 - Long.MAX_VALUE

    static long nextLong(long startInclusive, long endExclusive) {
        return startInclusive + (long) (random.nextDouble() * (endExclusive - startInclusive));
    } // Returns a random long within the
      // specified range.

}
