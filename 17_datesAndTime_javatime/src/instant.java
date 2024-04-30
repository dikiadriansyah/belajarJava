import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class instant {
    public static void main(String[] args) {
        // Merupakan instan dalam waktu. Dapat dianggap sebagai pembungkus di sekitar
        // Unix timestamp

        Instant n = Instant.now();
        // System.out.println(n); // 2023-07-04T08:12:06.720Z

        Instant e = Instant.ofEpochMilli(0);
        // System.out.println(e); // 1970-01-01T00:00:00Z

        Instant e2 = Instant.parse("2023-07-23T11:00:00Z");
        System.out.println(e2); // 2023-07-23T11:00:00Z

        Long m = ChronoUnit.MICROS.between(e, e2);
        // System.out.println(m); // 1690110000000000
    }
}
