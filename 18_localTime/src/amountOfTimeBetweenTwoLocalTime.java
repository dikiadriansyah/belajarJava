// Amount of time between two LocalTime / Jumlah waktu antara dua LocalTime

import java.lang.reflect.Method;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class amountOfTimeBetweenTwoLocalTime {
    public static void main(String[] args) throws Exception {
        // Method | Output
        // LocalTime.of(13, 12, 11) | 13:12:11
        // LocalTime.MIDNIGHT | 00:00
        // LocalTime.NOON | 12:00
        // LocalTime.now() | Current time from system clock
        // LocalTime.MAX | The maximum supported local time 23:59:59.999999999
        // LocalTime.MIN | The minimum supported local time 00:00
        // LocalTime.ofSecondOfDay(84399) | 23:59:59 , Obtains Time from second-of-day
        // value
        // LocalTime.ofNanoOfDay(2000000000) | 00:00:02 , Obtains Time from nanos-of-day
        // value

        // Ada dua cara yang setara untuk menghitung jumlah satuan waktu antara dua
        // LocalTime: (1) sampai metode until(Temporal, TemporalUnit) dan melalui (2)
        // TemporalUnit.between(Temporal, Temporal).

        LocalTime start = LocalTime.of(1, 0, 0);
        LocalTime end = LocalTime.of(2, 13, 20);

        long halfDays1 = start.until(end, ChronoUnit.HALF_DAYS);
        // System.out.println(halfDays1);
        // output: 0
        long halfDays2 = ChronoUnit.HALF_DAYS.between(start, end); // 0

        long hours1 = start.until(end, ChronoUnit.HOURS);
        // output: 1

        long hours2 = ChronoUnit.HOURS.between(start, end); // 1

        long minutes1 = start.until(end, ChronoUnit.MINUTES);
        // System.out.println(minutes1); // 73
        long minutes2 = ChronoUnit.MINUTES.between(start, end); // 73

        long second1 = start.until(end, ChronoUnit.SECONDS);
        // System.out.println(second1); // 4400

        long second2 = ChronoUnit.SECONDS.between(start, end);
        // System.out.println(second2); // 4400

        long millisecond = start.until(end, ChronoUnit.MILLIS);
        // System.out.println(millisecond); // 4400000
        long millisecond2 = ChronoUnit.MILLIS.between(start, end);
        // System.out.println(millisecond2); // 4400000

        long microsecond = start.until(end, ChronoUnit.MICROS);
        // System.out.println(microsecond); // 4400000000

        long microsecond2 = ChronoUnit.MICROS.between(start, end);
        // System.out.println(microsecond2); // 4400000000

        long nanosecond = start.until(end, ChronoUnit.NANOS);
        // System.out.println(nanosecond); // 4400000000000

        long nanosecond2 = ChronoUnit.NANOS.between(start, end);
        // System.out.println(nanosecond2); // 4400000000000

        // Menggunakan ChronoUnit lain akan dilempar UnsupportedTemporalTypeException.
        // Metode berikut adalah contohnya.
        long days1 = start.until(end, ChronoUnit.DAYS);
        // System.out.println(days1); // Unsupported unit: Days

        long days2 = ChronoUnit.DAYS.between(start, end);

    }
}
