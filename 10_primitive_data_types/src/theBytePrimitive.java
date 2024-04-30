public class theBytePrimitive {
    public static void main(String[] args) {
        // Sebuah byte adalah 8-bit signed integer. Itu dapat menyimpan nilai
        // minimum -27 (-128), dan nilai maksimum 27 - 1 (127).
        byte bilNegatifTipeByte = -36;
        byte bilTipeByte = 96;
        byte bilByteLain = 7;
        byte penjumlahan = (byte) (bilTipeByte + bilByteLain);
        // System.out.println(penjumlahan);//103

        byte penguranganByte = (byte) (bilTipeByte - bilByteLain);
        System.out.println(penguranganByte);// 89

        // Nilai maksimum dan minimum byte dapat ditemukan di:
        byte high = Byte.MAX_VALUE; // high == 127
        byte low = Byte.MIN_VALUE; // high == -128

        // Nilai default dari sebuah byte adalah 0
        // byte defaultByte; // defaultByte == 0

    }

}
