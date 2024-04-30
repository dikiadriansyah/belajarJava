import java.math.BigDecimal;

public class using_bigdecimal_instead_of_float {
    public static void main(String[] args) {
        // Karena tipe float direpresentasikan dalam memori komputer, hasil operasi yang
        // menggunakan tipe ini bisa jadi tidak akurat - beberapa nilai disimpan sebagai
        // perkiraan. Contoh bagus dari ini adalah perhitungan moneter. Jika presisi
        // tinggi diperlukan, jenis lain harus digunakan. misalnya Java 7 menyediakan
        // BigDecimal.

        float saldoAkun = 10000.00f;
        // System.out.println("Operasi menggunakan float");
        // System.out.println("1000 operasi untuk 1.99");
        for (int i = 0; i < 1000; i++) {
            saldoAkun -= 1.99f;
        }
        // System.out.println(String.format("Saldo akun setelah operasi float: %f",
        // saldoAkun));
        // output:
        // Operasi menggunakan float
        // 1000 operasi untuk 1.99
        // Saldo akun setelah operasi float: 8009.765625

        BigDecimal saldoAkun2 = new BigDecimal("10000.00");
        System.out.println("Operasi menggunakan BigDecimal");
        System.out.println("1000 operasi untuk 1.99");
        BigDecimal o = new BigDecimal("1.99");
        for (int k = 0; k < 1000; k++) {
            saldoAkun2 = saldoAkun2.subtract(o);

        }
        // System.out.println(String.format("Saldo akun setelah operasi BigDecimal: %f",
        // saldoAkun2));
        // output:
        // Operasi menggunakan BigDecimal
        // 1000 operasi untuk 1.99
        // Saldo akun setelah operasi BigDecimal: 8010.000000

        // penjelasan:
        // menggunakan perulangan for() yg berisi perintah pengurangan 1.99 sebanyak
        // 1000 kali

        // Untuk saldo awal 10000,00, setelah 1000 operasi untuk 1,99, kami mengharapkan
        // saldo menjadi 8010,00. Menggunakan tipe float memberi kita jawaban sekitar
        // 8009.77, yang sangat tidak tepat dalam kasus perhitungan moneter.
        // Menggunakan BigDecimal memberi kita hasil yang tepat.
    }
}
