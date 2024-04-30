public class theShortPrimitive {
    public static void main(String[] args) {
        // Short adalah bilangan bulat bertanda 16-bit. Ini memiliki nilai minimum -215
        // (-32.768), dan nilai maksimum 215 ‑1 (32.767)
        short bilNegatif = -48;
        short bilKu = 987;
        short bilLain = 17;

        short penjumlahanShort = (short) (bilKu + bilLain);
        // System.out.println(penjumlahanShort); // 1004

        short penguranganShort = (short) (bilKu - bilLain);
        // System.out.println(penguranganShort); // 970

        // Nilai maksimum dan minimum short dapat ditemukan di
        short high = Short.MAX_VALUE;
        System.out.println(high); // 32767
        short low = Short.MIN_VALUE;
        System.out.println(low); // -32768

        // Nilai default short adalah 0
        short defaultShort; // defaultShort == 0
    }
}
