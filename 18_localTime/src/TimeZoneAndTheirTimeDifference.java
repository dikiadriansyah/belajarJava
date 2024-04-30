
// timezone and their time difference/ zona waktu dan perbedaan waktunya
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class TimeZoneAndTheirTimeDifference {
    public static void main(String[] args) {
        ZoneId z1 = ZoneId.of("Europe/Berlin");
        ZoneId z2 = ZoneId.of("Brazil/East");
        LocalTime n = LocalTime.now();
        LocalTime n1 = LocalTime.now(z1);
        LocalTime n2 = LocalTime.now(z2);

        // System.out.println("Waktu Sekarang: " + n);
        // output: Waktu Sekarang: 22:42:54.023814400

        // System.out.println("Waktu berlin : " + n1);
        // output: Waktu berlin : 17:44:00.185204300

        // System.out.println("Waktu Berasil : " + n2);
        // output: Waktu berasil: 12:44:46.932

        long berbedamenit = ChronoUnit.MINUTES.between(n2, n1);
        System.out.println("Perbedaan menit berlin dan brasil : " + berbedamenit + "menit");
        // output: Perbedaan menit berlin dan brasil : 299 menit
    }
}
