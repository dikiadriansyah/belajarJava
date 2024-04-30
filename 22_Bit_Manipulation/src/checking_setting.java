public class checking_setting {

    /*
     * Checking, setting, clearing, and toggling individual bits. Using long as bit
     * mask
     */

    private static final long FIRST_BIT = 1L << 0;
    private static final long SECOND_BIT = 1L << 1;
    private static final long THIRD_BIT = 1L << 2;
    private static final long FOURTH_BIT = 1L << 3;
    private static final long FIFTH_BIT = 1L << 4;
    private static final long BIT_55 = 1L << 54;

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Dengan asumsi kita ingin memodifikasi bit n dari bilangan bulat primitif, i
        // (byte, short, char, int, atau long):
        /*
         * (i & 1 << n) != 0 // checks bit 'n'
         * i |= 1 << n; // sets bit 'n' to 1
         * i &= ~(1 << n); // sets bit 'n' to 0
         * i ^= 1 << n; // toggles the value of bit 'n'
         */

        // gunakan long/int/short/byte as a bit mask:
        checkBitMask(FIRST_BIT | THIRD_BIT | FIFTH_BIT | BIT_55);
    }

    private static void checkBitMask(long bitmask) {
        System.out.println("FIRST_BIT: " + ((bitmask & FIRST_BIT) != 0)); // FIRST_BIT: true
        System.out.println("SECOND_BIT: " + ((bitmask & SECOND_BIT) != 0)); // SECOND_BIT: false
        System.out.println("THIRD_BIT: " + ((bitmask & THIRD_BIT) != 0)); // THIRD_BIT: true
        System.out.println("FOURTh_BIT: " + ((bitmask & FOURTH_BIT) != 0));// FOURTh_BIT: false
        System.out.println("FIFTH_BIT: " + ((bitmask & FIFTH_BIT) != 0));// FIFTH_BIT: true
        System.out.println("BIT_55: " + ((bitmask & BIT_55) != 0));// BIT_55: true
    }
    /*
     * yang cocok dengan topeng yang kami lewati sebagai parameter checkBitMask:
     * FIRST_BIT | KETIGA_BIT | KELIMA_BIT | BIT_55.
     */
}
