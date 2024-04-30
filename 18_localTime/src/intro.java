import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;

public class intro {
    // LocalTime adalah kelas yang tidak dapat diubah dan thread-safe, digunakan
    // untuk merepresentasikan waktu, sering dipandang sebagai jam-menit-detik.
    // Waktu direpresentasikan dengan presisi nanodetik. Misalnya, nilai
    // "13:45.30.123456789" dapat disimpan di LocalTime.

    // Kelas ini tidak menyimpan atau mewakili tanggal atau time-zone. Sebaliknya,
    // itu adalah deskripsi waktu setempat seperti yang terlihat pada jam dinding.
    // Itu tidak dapat mewakili instan pada garis waktu tanpa informasi tambahan
    // seperti offset atau timezone. Ini adalah kelas berbasis nilai, metode
    // equals harus digunakan untuk perbandingan

    // Fields
    // MAX - Waktu Lokal maksimum yang didukung, '23:59:59.999999999'. MIDNIGHT,
    // MIN, NOON

    // important instance methods
    // isAfter(LocalTime other), isBefore(LocalTime other), minus(TemporalAmount
    // amountToSubtract), minus(long amountToSubtract, TemporalUnit unit),
    // plus(TemporalAmount amountToAdd), plus(long amountToAdd, TemporalUnit unit)

    public static void main(String[] args) throws Exception {
        ZoneId z = ZoneId.of("Asia/Kolkata");
        // System.out.println(z); // asia/kolkata

        LocalTime n = LocalTime.now();
        // System.out.println(n);
        // output: 17:20:45.266412400

        LocalTime n1 = LocalTime.now(z);
        // System.out.println(n1);
        // output: 15:51:59.695520500

        LocalTime th = LocalTime.parse("13:02:40");
        // System.out.println(th);
        // output: 13:02:40

        // Selisih waktu dapat dihitung dengan salah satu cara berikut
        long td = Duration.between(n, n1).toMinutes();
        System.out.println(n + "\n" + n1 + "\n" + td);
        // output: -90

        // Anda juga dapat add/subtract hours, minutes, atau seconds dari objek
        // localTime mana pun.

        // minusHours(long hoursToSubtract), minusMinutes(long hoursToMinutes),
        // minusNanos(long nanosToSubtract),
        // minusSeconds(long secondsToSubtract), plusHours(long hoursToSubtract),
        // plusMinutes(long hoursToMinutes),
        // plusNanos(long nanosToSubtract), plusSeconds(long secondsToSubtract)

        LocalTime result = n.plusHours(1);
        // System.out.println(result);
        // output:
        // tadinya 17:32:17 jadi 18:32:17

        LocalTime result2 = n1.minusMinutes(20L);
        System.out.println(result2);
        // output:
        // tadinya 16:44:20 jadi 15:44:20

    }

}
