public class Literals {
    // Literals/harfiah

    /*
     * long l = 5432L;
     * int i = 0x123 + 0xABC;
     * byte b = 0b1010;
     * float f1 = 1 / 5432f;
     * float f2 = 0.123e4f;
     * double d1 = 1 / 5432d; // or 1 / 5432.0
     * double d2 = 0x1.3p2;
     */

    /*
     * 1. long literals harus menggunakan akhiran huruf besar L.
     * 2. Hexadecimal Literal harus menggunakan huruf besar A-F.
     * 3. Semua awalan, sisipan, dan akhiran numerik lainnya harus menggunakan huruf
     * kecil.
     */

    public static void main(String[] args) throws Exception {
        long l = 5432L;
        int i = 0x123 + 0xABC;
        byte b = 0b1010;
        float f1 = 1 / 5432f;
        float f2 = 0.123e4f;
        double d1 = 1 / 5432d; // or 1 / 5432.0
        double d2 = 0x1.3p2;

        System.out.println("Nilai l: " + l);
        System.out.println("Nilai i: " + i);
        System.out.println("Nilai b: " + b);
        System.out.println("Nilai f1: " + f1);
        System.out.println("Nilai f2: " + f2);
        System.out.println("Nilai d1: " + d1);
        System.out.println("Nilai d2: " + d2);
        /*
         * output:
         * Nilai l: 5432
         * Nilai i: 3039
         * Nilai b: 10
         * Nilai f1: 1.8409426E-4
         * Nilai f2: 1230.0
         * Nilai d1: 1.840942562592047E-4
         * Nilai d2: 4.75
         */
    }
}
