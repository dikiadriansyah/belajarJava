import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateAndTime {
    public static void main(String[] args) {
        // Date dan time tanpa informasi zona waktu
        LocalDateTime ldt = LocalDateTime.of(2023, Month.JUNE, 24, 9, 0);
        // System.out.println(ldt); // 2023-06-24T09:00
        LocalDateTime n = LocalDateTime.now();
        LocalDateTime p = LocalDateTime.parse("2023-06-24T07:00:00");
        // System.out.println(p); // 2023-06-24T07:00

        // Date dan time dengan informasi zona waktu
        ZoneId zi = ZoneId.of("UTC+2");
        // System.out.println(zi); // UTC+02:00
        ZonedDateTime dt = ZonedDateTime.of(2016, 7, 27, 7, 0, 0, 235, zi);
        // System.out.println(dt); // 2016-07-27T07:00:00.000000235+02:00[UTC+02:00]

        LocalDate localDate = LocalDate.now(); // Menggunakan tanggal lokal saat ini
        LocalTime localTime = LocalTime.now();
        ZonedDateTime c = ZonedDateTime.of(localDate, localTime, zi);
        System.out.println(c);// 2023-07-03T13:36:17.218+02:00[UTC+02:00]

        ZonedDateTime n2 = ZonedDateTime.now();
        // System.out.println(n2); // 2023-07-03T13:08:58.401+07:00[Asia/Bangkok]

        ZonedDateTime p2 = ZonedDateTime.parse("2023-06-27T08:02:30+01:00[Europe/Stockholm]");
        // System.out.println(p2); // 2023-06-27T08:02:30+02:00[Europe/Stockholm]

        // Date dan time dengan informasi offset (mis. perubahan DST tidak
        // diperhitungkan)

        ZoneOffset zo = ZoneOffset.ofHours(2);
        // OffsetDateTime dt2 = OffsetDateTime.of(2023, 7, 1, 8, 0, 0, 235, zo);
        // System.out.println(dt2); // 2023-07-01T08:00:00.000000235+02:00

        // OffsetDateTime c = OffsetDateTime.of(localDate, localTime, zo);
        OffsetDateTime now = OffsetDateTime.now();
        // System.out.println(now); // 2023-07-01T08:00:00.000000235+02:00

        OffsetDateTime p3 = OffsetDateTime.parse("2023-07-27T07:00:00+02:00");
        // System.out.println(p3); // 2023-07-27T07:00+02:00
    }
}
