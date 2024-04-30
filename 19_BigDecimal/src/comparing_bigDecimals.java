// BigDecimal class menyediakan operasi untuk aritmatika (add, subtract,
// multiply, divide), scale manipulation, pembulatan, perbandingan, hashing,
// dan konversi format. BigDecimal mewakili ketetapan, presisi sewenang-wenang
// bilangan desimal bertanda. Kelas ini harus digunakan dalam kebutuhan
// perhitungan presisi tinggi.

// comparing bigdecimals / perbandingan bigdecimal
import java.math.BigDecimal;

public class comparing_bigDecimals {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // metode compareTo harus digunakan untuk membandingkan bigDecimals:
        BigDecimal bd = new BigDecimal(5);
        // System.out.println(bd.compareTo(new BigDecimal(0))); // bd is greater,
        // returns 1

        // System.out.println(bd.compareTo(new BigDecimal(5))); // bd is equal, return 0
        // System.out.println(bd.compareTo(new BigDecimal(10))); // bd is less, return
        // -1

        // Biasanya Anda tidak boleh menggunakan metode yang sama karena menganggap dua
        // BigDecimal sama hanya jika nilainya sama dan juga skala:
        BigDecimal b = new BigDecimal(5);
        System.out.println(b.equals(new BigDecimal(5))); // value and scale are equal, returns true
        System.out.println(b.equals(new BigDecimal(5.00)));// value is equal but scale is not, returns false

    }
}
