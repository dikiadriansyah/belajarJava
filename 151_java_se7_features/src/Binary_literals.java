public class Binary_literals {
    // Binary Literals/Literal Biner

    public static void main(String[] args) {
        // An 8-bit 'byte' value:
        byte aByte = (byte) 0b00100001;
        // A 16-bit 'short' value:
        short aShort = (short) 0b1010000101000101;
        // Some 32-bit 'int' values:
        int anInt1 = 0b10100001010001011010000101000101;
        int anInt2 = 0b101;
        int anInt3 = 0B101; // The B can be upper or lower case.
        // A 64-bit 'long' value. Note the "L" suffix:
        long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;

        // Printing the values
        System.out.println("Byte: " + aByte); // Byte: 33
        System.out.println("Short: " + aShort); // Short: -24251
        System.out.println("Int 1: " + anInt1); // Int 1: -1589272251
        System.out.println("Int 2: " + anInt2); // Int 2: 5
        System.out.println("Int 3: " + anInt3); // Int 3: 5
        System.out.println("Long: " + aLong); // Long: -6825872339779608251
    }

}
