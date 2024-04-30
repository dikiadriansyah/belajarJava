import java.math.BigDecimal;

public class bigDecimal_valueof {
    public static void main(String[] args) {
        // Kelas BigDecimal berisi cache internal dari nomor yang sering digunakan, mis.
        // 0 hingga 10. Metode BigDecimal.valueOf() disediakan sebagai preferensi untuk
        // konstruktor dengan parameter tipe serupa yaitu dalam contoh di bawah one
        // adalah lebih suka two
        // BigDecimal one = BigDecimal.valueOf(10L); // Returns cached Object reference
        // BigDecimal two = new BigDecimal(10L); // Does not return cached Object
        // reference

        // BigDecimal one = BigDecimal.valueOf(13L); // Returns cached Object reference
        // BigDecimal two = new BigDecimal(13L); // Does not return cached Object

        BigDecimal one = BigDecimal.valueOf(15.15);
        // Cara yang disukai untuk mengonversi double (atau float) menjadi BigDecimal,
        // karena nilai yang dikembalikan sama dengan yang dihasilkan dari
        // pembuatan BigDecimal dari hasil penggunaan Double.toString(double)
        BigDecimal two = new BigDecimal(15.15); // return unpredictable result

    }
}
