public class underscores_in_numeric_literals {
    // Underscores in Numeric Literals/Garis bawah dalam Literal Numerik

    // Contoh berikut menunjukkan cara lain menggunakan garis bawah dalam literal
    // numerik:
    /*
     * long creditCardNumber = 1234_5678_9012_3456L;
     * long socialSecurityNumber = 999_99_9999L;
     * float pi = 3.14_15F;
     * long hexBytes = 0xFF_EC_DE_5E;
     * long hexWords = 0xCAFE_BABE;
     * long maxLong = 0x7fff_ffff_ffff_ffffL;
     * byte nybbles = 0b0010_0101;
     * long bytes = 0b11010010_01101001_10010100_10010010;
     */

    /*
     * Anda hanya dapat menempatkan garis bawah di antara angka; Anda tidak dapat
     * menempatkan garis bawah di tempat-tempat berikut:
     * 
     * 1. Di awal atau akhir suatu bilangan
     * 2. Berdekatan dengan titik desimal dalam literal floating point
     * 3. Sebelum akhiran F atau L
     * 4. Pada posisi di mana rangkaian angka diharapkan
     */

    public static void main(String[] args) throws Exception {
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi = 3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;

        System.out.println("Credit Card Number: " + creditCardNumber); // Credit Card Number: 1234567890123456
        System.out.println("Social Security Number: " + socialSecurityNumber); // Social Security Number: 999999999
        System.out.println("Pi: " + pi); // Pi: 3.1415
        System.out.println("Hex Bytes: " + hexBytes);// Hex Bytes: -1253794
        System.out.println("Hex Words: " + hexWords);// Hex Words: -889275714
        System.out.println("Max Long: " + maxLong);// Max Long: 9223372036854775807
        System.out.println("Nybbles: " + nybbles);// Nybbles: 37
        System.out.println("Bytes: " + bytes);// Bytes: -764832622
    }

}
