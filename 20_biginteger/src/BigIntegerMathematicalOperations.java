import java.math.BigInteger;

public class BigIntegerMathematicalOperations {
    // BigInteger Mathematical Operations Examples
    /*
     * 
     * BigInteger berada dalam objek yang tidak dapat diubah, jadi Anda perlu
     * menetapkan hasil operasi matematika apa pun ke instance new BigInteger.
     * 
     */
    public static void main(String[] args) {
        // Addition(penambahan)
        // BigInteger box1 = new BigInteger("11");
        // BigInteger box2 = new BigInteger("11");
        // BigInteger box3 = box1.add(box2);
        // System.out.println(box3); // 22
        // ------------------------
        // Subtraction(pengurangan)
        BigInteger box4 = new BigInteger("21");
        BigInteger box5 = new BigInteger("4");
        BigInteger box6 = box4.subtract(box5);
        // System.out.println(box6); // 17

        // --------------------
        // division(pembagian)
        BigInteger box7 = new BigInteger("28");
        BigInteger box8 = new BigInteger("4");
        BigInteger box9 = box7.divide(box8);
        // System.out.println(box9); // 7

        BigInteger box10 = new BigInteger("20");
        BigInteger box11 = new BigInteger("6");
        // System.out.println(box10.divide(box11)); // 3
        // -----------------
        // multiplication (perkalian)
        BigInteger box12 = new BigInteger("4");
        BigInteger box13 = new BigInteger("5");
        BigInteger box14 = box12.multiply(box13);
        // System.out.println(box14); // 20
        // ---------------
        // power (akar)
        BigInteger box15 = new BigInteger("5");
        BigInteger box16 = box15.pow(3);
        // System.out.println(box16); // 125
        // ---------------
        // Remainder (sisa bagi)
        BigInteger box17 = new BigInteger("18");
        BigInteger box18 = new BigInteger("14");
        // BigInteger box19 = box17.remainder(box18);
        // System.out.println(box19); // 4

        // -----------------------
        // GDC(Greatest Common Divisor)/Pembagi Persekutuan Terbesar (PBT)
        BigInteger box20 = new BigInteger("18");
        BigInteger box21 = new BigInteger("14");
        // System.out.println(box20.gcd(box21)); // 2

        // ------------------------
        // Maximum of two Bigintegers:
        BigInteger box22 = new BigInteger("23");
        BigInteger box23 = new BigInteger("24");
        // System.out.println(box22.max(box23));// 24

        // ---------------------------
        // Minimum of two BigIntegers:
        BigInteger box24 = new BigInteger("23");
        BigInteger box25 = new BigInteger("24");
        System.out.println(box24.min(box25)); // 23

    }
}
