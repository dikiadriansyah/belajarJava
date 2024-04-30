import java.math.BigInteger;

public class Binary_logic_operations_on_biginteger {
    // Binary Logic Operations on BigInteger
    /*
     * BigInteger mendukung operasi logika biner yang juga tersedia untuk tipe
     * Angka. Seperti semua operasi, operasi ini diimplementasikan dengan memanggil
     * suatu metode.
     */

    public static void main(String[] args) {
        // Binary Or:
        BigInteger box1 = new BigInteger("21");
        BigInteger box2 = new BigInteger("2");
        BigInteger box3 = box1.or(box2);
        // System.out.println(box3); // 23

        // --------------
        // Binary And:
        BigInteger box4 = new BigInteger("10");
        BigInteger box5 = new BigInteger("9");
        BigInteger box6 = box4.and(box5);
        // System.out.println(box6); // 8
        // ---------------------
        // Binary Xor:
        BigInteger box7 = new BigInteger("10");
        BigInteger box8 = new BigInteger("9");
        BigInteger box9 = box7.xor(box8);
        // System.out.println(box9); // 3
        // ---------------------
        // RightShift
        BigInteger box10 = new BigInteger("10");
        BigInteger box11 = box10.shiftRight(1);
        // System.out.println(box11); // 5
        // ---------------------
        // LeftShift
        BigInteger box12 = new BigInteger("10");
        BigInteger box13 = box12.shiftLeft(1);
        // System.out.println(box13); // 20
        // ---------------------
        // Binary Inversion (Not)
        BigInteger box14 = new BigInteger("10");
        BigInteger box15 = box14.not();
        // System.out.println(box15); // -11

        // ---------------------
        // NAND (And-Not):*
        BigInteger box16 = new BigInteger("10");
        BigInteger box17 = new BigInteger("9");
        BigInteger box18 = box16.andNot(box17);
        System.out.println(box18); // 2
    }
}
