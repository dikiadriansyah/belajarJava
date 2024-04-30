import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class calculateDifferenceBetween2LocalDate {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // gunakan LocalDate dan ChronoUnit:
        LocalDate d1 = LocalDate.of(2023, 6, 1);
        LocalDate d2 = LocalDate.of(2023, 6, 15);

        // sekarang, karena metode between pencacah ChronoUnit mengambil 2 Temporals
        // sebagai parameter sehingga Anda dapat meneruskan instance LocalDate tanpa
        // masalah

        long days = ChronoUnit.DAYS.between(d1, d2);
        System.out.println(days);
        // output: 14
    }
}
