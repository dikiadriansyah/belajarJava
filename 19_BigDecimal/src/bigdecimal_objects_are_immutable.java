import java.math.BigDecimal;

public class bigdecimal_objects_are_immutable {
    // BigDecimal objects are immutable / Objek BigDecimal tidak dapat diubah
    public static void main(String[] args) {
        // Jika Anda ingin menghitung dengan BigDecimal, Anda harus menggunakan nilai
        // yang dikembalikan karena objek BigDecimal tidak dapat diubah:
        BigDecimal one = new BigDecimal("42.33");
        BigDecimal two = new BigDecimal("10.00");
        one.add(two);
        System.out.println(one);
        // output: 42.33

        BigDecimal three = one.add(two);
        System.out.println(three);
        // output: 52.33

    }
}
