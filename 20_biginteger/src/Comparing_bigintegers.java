import java.math.BigInteger;

public class Comparing_bigintegers {
    // Comparing BigIntegers

    /*
     * Anda dapat membandingkan BigIntegers sama seperti Anda membandingkan String
     * atau objek lain di Java.
     * 
     * contoh:
     */
    public static void main(String[] args) {
        BigInteger box1 = BigInteger.valueOf(2);
        BigInteger box2 = BigInteger.valueOf(3);
        // if (box1.equals(box2)) {
        // System.out.println("sama dengan");
        // } else {
        // System.out.println("tidak sama dengan");
        // }
        /*
         * output:
         * tidak sama dengan
         */

        /*
         * Catatan:
         * Secara umum, jangan gunakan operator == untuk membandingkan BigInteger
         * 1. == operator: membandingkan referensi; yaitu apakah dua nilai merujuk pada
         * objek yang sama
         * 2. equals() method: membandingkan konten dua BigInteger
         * 
         * Misalnya, BigIntegers tidak boleh dibandingkan dengan cara berikut:
         * if (firstBigInteger == secondBigInteger) {
         * // Only checks for reference equality, not content equality!
         * }
         * 
         * Melakukan hal ini dapat menyebabkan perilaku yang tidak diharapkan, karena
         * operator == hanya memeriksa kesetaraan referensi. Jika keduanya
         * BigIntegers berisi konten yang sama, tetapi tidak mengacu pada objek yang
         * sama, ini akan gagal. Sebaliknya, bandingkan
         * BigIntegers menggunakan metode sama dengan yang dijelaskan di atas
         * 
         * Anda juga dapat membandingkan BigInteger dengan nilai konstan seperti 0,1,10.
         * contoh:
         */
        // BigInteger reallyBig = BigInteger.valueOf(1);
        // if (BigInteger.ONE.equals(reallyBig)) {
        // // code when they are equal.
        // System.out.println("Bilangan Sama dengan");
        // } // Bilangan Sama dengan

        // ------------------
        /*
         * Anda juga dapat membandingkan dua BigInteger dengan menggunakan metode
         * bandingkanTo(), sebagai berikut: bandingkanTo() mengembalikan 3 nilai.
         * 
         * 0: When both are equal.
         * 1: When first is greater than second (the one in brackets).
         * -1: When first is less than second.
         * 
         */
        BigInteger box3 = BigInteger.valueOf(10);
        BigInteger box4 = BigInteger.valueOf(100);
        if (box3.compareTo(box4) == 0) {
            // kode ketika keduanya sama.
            System.out.println("Sama dengan");
        } else if (box3.compareTo(box4) == 1) {
            // kode ketika box3 lebih besar dari box4
            System.out.println("box3 lebih besar");

        } else if (box3.compareTo(box4) == -1) {
            // kode ketika box3 kurang dari box4
            System.out.println("box3 kurang dari");

        }

        /*
         * output:
         * box3 kurang dari
         */

    }
}
