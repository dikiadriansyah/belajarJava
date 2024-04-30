
// Simple Date Manipulations / Manipulasi Tanggal Sederhana
import java.time.LocalDate;

public class SimpleDateManipulations {
    public static void main(String[] args) {
        // Dapatkan date saat ini
        // LocalDate.now();

        // Dapatkan date kemarin
        LocalDate ld = LocalDate.now().minusDays(1);
        // System.out.println(ld);
        // output: 2023-08-01
        // -------------------------
        // dapatkan date besok
        LocalDate ld2 = LocalDate.now().plusDays(1);
        // System.out.println(ld2);
        // output: 2023-08-03
        // -------------------------

        // dapatkan date spesifik
        LocalDate ld3 = LocalDate.of(1999, 10, 14);
        // System.out.println(ld3);
        // output: 1999-10-14
        // -------------------------

        // Selain metode plus dan minus, ada sekumpulan metode "with" yang dapat
        // digunakan untuk menyetel bidang tertentu pada instance LocalDate.

        // LocalDate.now().withMonth(6);
        // Contoh di atas mengembalikan instance baru dengan bulan disetel ke Juni (ini
        // berbeda dari java.util.Date di mana setMonth diindeks 0 membuat 5 Juni).

        // Karena manipulasi LocalDate mengembalikan instance LocalDate yang tidak dapat
        // diubah, metode ini juga dapat dirangkai bersama.
        LocalDate ld4 = LocalDate.now().plusDays(1).plusYears(1);
        System.out.println(ld4);
        // output: 2024-08-03

        // Ini akan memberi kita tanggal besok satu tahun dari sekarang
    }
}
