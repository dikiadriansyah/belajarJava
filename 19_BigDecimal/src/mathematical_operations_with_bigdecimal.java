import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class mathematical_operations_with_bigdecimal {
    // Mathematical operations with BigDecimal
    public static void main(String[] args) {
        // Contoh ini menunjukkan cara melakukan operasi matematika dasar menggunakan
        // BigDecimals.

        // 1. Addition
        // BigDecimal one = new BigDecimal("5");
        // BigDecimal two = new BigDecimal("7");

        // Equivalent to result = one + two;
        // BigDecimal result = one.add(two);
        // System.out.println(result); // 12

        // 2. subtraction
        // BigDecimal one = new BigDecimal("5");
        // BigDecimal two = new BigDecimal("8");

        // Equivalent to result = one-two;
        // BigDecimal result = one.subtract(two);
        // System.out.println(result); // -3

        // 3. multiplication
        // Saat mengalikan dua BigDecimal, hasilnya akan memiliki skala yang sama dengan
        // jumlah skala operan.
        // BigDecimal one = new BigDecimal("5.11");
        // BigDecimal two = new BigDecimal("7.221");

        // Equivalent to result = a * b
        // BigDecimal result = one.multiply(two);
        // System.out.println(result); // 36.89931

        // Untuk mengubah skala hasil, gunakan metode perkalian kelebihan beban yang
        // memungkinkan parsing MathContext - sebuah objek
        // menjelaskan aturan untuk operator, khususnya mode presisi dan pembulatan
        // hasil. Untuk informasi lebih lanjut tentang mode pembulatan yang tersedia,
        // silakan lihat Dokumentasi Oracle.
        // BigDecimal one = new BigDecimal("5.11");
        // BigDecimal two = new BigDecimal("7.221");

        // MathContext returnRules = new MathContext(4, RoundingMode.HALF_DOWN);

        // Equivalent to result = a * b;
        // BigDecimal result = one.multiply(two, returnRules);
        // System.out.println(result); // 36.90

        // 4. division
        // Pembagian sedikit lebih rumit daripada operasi aritmatika lainnya, misalnya
        // perhatikan contoh di bawah ini:
        // BigDecimal one = new BigDecimal("5");
        // BigDecimal two = new BigDecimal("7");
        // BigDecimal result = one.divide(two);
        // System.out.println(result);
        // Kami berharap ini memberikan sesuatu yang mirip dengan: 0,7142857142857143,
        // tetapi kami akan mendapatkan:
        // Result: java.lang.ArithmeticException: Non-terminating decimal expansion; no
        // exact representable decimal result.

        // Ini akan bekerja dengan sangat baik ketika hasilnya berupa desimal terminasi
        // katakanlah jika saya ingin membagi 5 dengan 2, tetapi
        // untuk angka-angka yang setelah dibagi akan memberikan hasil yang tidak
        // berhenti, kita akan mendapatkan ArithmeticException.

        // Dalam skenario dunia nyata, seseorang tidak dapat memprediksi nilai yang akan
        // ditemui selama pembagian, jadi kita perlu menentukan Skala dan Mode
        // Pembulatan untuk pembagian BigDecimal. Untuk informasi lebih lanjut tentang
        // scale dan Rounding Mode, lihat Dokumentasi Oracle.

        // contoh:
        // BigDecimal one = new BigDecimal("5");
        // BigDecimal two = new BigDecimal("7");

        // equivalent to result = a / b(upto 10 decimal places and round HALF_UP)
        // BigDecimal result = one.divide(two, 10, RoundingMode.HALF_UP);
        // System.out.println(result);
        // output: 0.7142857143

        // 5. Reminder or Modulus
        // BigDecimal one = new BigDecimal("5");
        // BigDecimal two = new BigDecimal("7");

        // Equivalent to result = a % b
        // BigDecimal result = one.remainder(two);
        // System.out.println(result);
        // output: 5

        // 6. power
        // BigDecimal one = new BigDecimal("5");

        // equivalent to result = a^10
        // BigDecimal result = one.pow(10);
        // System.out.println(result);
        // output: 9765625

        // 7. max
        // BigDecimal one = new BigDecimal("5");
        // BigDecimal two = new BigDecimal("7");

        // Equivalent to result = MAX(one,two)
        // BigDecimal result = one.max(two);
        // System.out.println(result);
        // output: 7

        // 8. min
        // BigDecimal one = new BigDecimal("5");
        // BigDecimal two = new BigDecimal("7");

        // Equivalent to result = MIN(one, two)
        // BigDecimal result = one.min(two);
        // System.out.println(result);
        // output: 5

        // 9. move point to left
        // BigDecimal one = new BigDecimal("5234.49843776");

        // moves the decimal point to 2 places left of current position
        // BigDecimal result = one.movePointLeft(2);
        // System.out.println(result);
        // output: 52.3449843776

        // 10. move point to right
        BigDecimal one = new BigDecimal("5234.49843776");

        // moves the decimal point to 3 places right of current position
        BigDecimal result = one.movePointRight(3);
        System.out.println(result);
        // output: 5234498.43776

        // Ada lebih banyak opsi dan kombinasi parameter untuk contoh yang disebutkan di
        // atas (Misalnya, ada 6 variasi metode pembagian), kumpulan ini adalah daftar
        // yang tidak lengkap dan mencakup beberapa contoh dasar
    }
}
