import java.math.BigDecimal;

public class initializationOfBigDecimalsWithValueZero_one_or_ten {
    // Initialization of BigDecimals with value zero, one or ten / Inisialisasi
    // BigDecimals dengan nilai nol, satu atau sepuluh

    public static void main(String[] args) {
        // BigDecimal menyediakan properti statis untuk angka nol, satu, dan sepuluh.
        // Sebaiknya gunakan ini daripada menggunakan angka sebenarnya:

        // BigDecimal.ZERO
        // BigDecimal.ONE
        // BigDecimal.TEN

        // Dengan menggunakan properti statis, Anda menghindari pembuatan contoh yang
        // tidak perlu, dan Anda juga mendapatkan literal dalam kode Anda
        // dari 'angka ajaib/magic number'.

        // contoh Buruk:
        BigDecimal b1 = new BigDecimal(0);
        BigDecimal b2 = new BigDecimal(1);
        BigDecimal b3 = new BigDecimal(9);

        // contoh baik
        BigDecimal bd0 = BigDecimal.ZERO;
        BigDecimal bd1 = BigDecimal.ONE;
        BigDecimal bd10 = BigDecimal.TEN;
        System.out.println(bd10);
        // output: 10

    }
}
