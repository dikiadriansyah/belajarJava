import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class java8LocalDateAndLocalDateTimeObjects {
    public static void main(String[] args) {
        // Objek Date dan LocalDate tidak dapat persis dikonversi antara satu sama lain
        // karena objek Date mewakili hari dan waktu tertentu, sedangkan objek LocalDate
        // tidak berisi informasi time atau timezone. Namun, itu bisa saja
        // berguna untuk mengonversi antara keduanya jika Anda hanya peduli dengan
        // informasi tanggal aktual dan bukan informasi waktu.

        // Creates a localDate

        // Create a default date
        LocalDate LD = LocalDate.now();
        // System.out.println(LD); // 2023-07-01

        // create a date from value
        // LD = LocalDate.of(2023, 07, 01);
        // System.out.println(LD); // 2023-07-01

        // create a date from string
        // LocalDate.now(ZoneId.systemDefault());

        // Creates a LocalDateTime

        // Create a default date time
        LocalDateTime LDT = LocalDateTime.now();
        // System.out.println(LDT); // 2023-07-01T11:01:52
        // ------------------------------------------

        // creates a date time from value
        LDT = LocalDateTime.of(2023, 07, 01, 10, 21);
        // System.out.println(LDT); // 2023-07-01T10:21

        LDT = LocalDateTime.parse("2023-07-01T10:30:30");
        // System.out.println(LDT); // 2023-07-01T10:30:30

        // create a date time from zone
        // LocalDateTime.now(ZoneId.systemDefault());
        // ------------------------------------------

        // LocalDate to Date and vice-vers
        // Date d = Date.from(Instant.now());
        // System.out.println(d); // Sat Jul 01 11:02:48 ICT 2023

        // ZoneId defaultZi = ZoneId.systemDefault();
        // System.out.println(defaultZi); // Asia/Bangkok

        // Date to LocalDate
        // LocalDate ld = d.toInstant().atZone(defaultZi).toLocalDate();
        // System.out.println(ld); // 2023-07-01

        // LocalDate to Date
        // Date res = Date.from(ld.atStartOfDay(defaultZi).toInstant());
        // System.out.println(res); // Sat Jul 01 00:00:00 ICT 2023
        // ------------------------------------------
        // LocalDateTime to Date and vice-versa
        Date d = Date.from(Instant.now());
        // System.out.println(d); // Sat Jul 01 11:02:48 ICT 2023
        ZoneId dZoneID = ZoneId.systemDefault();
        System.out.println(dZoneID); // asia/bangkok

        // Date to LocalDateTime
        LocalDateTime Ldt = d.toInstant().atZone(dZoneID).toLocalDateTime();
        // System.out.println(Ldt); // 2023-07-01T11:14.39

        // LocalDateTime to Date
        // Date res = Date.from(Ldt.atZone(dZoneID).toInstant());
        // System.out.println(res); // Sat Jul 01 11:13:51 ICT 2023
    }
}
