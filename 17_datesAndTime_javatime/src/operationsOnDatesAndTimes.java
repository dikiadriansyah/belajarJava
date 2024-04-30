import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class operationsOnDatesAndTimes {
    public static void main(String[] args) {
        LocalDate t = LocalDate.now().plusDays(1);
        LocalDateTime ldt = LocalDateTime.now().plusHours(1);
        Long db = java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(),
                LocalDate.now().plusDays(3));
        Duration d = Duration.between(Instant.now(),
                ZonedDateTime.parse("2023-07-10T08:00:00+01:00[Europe/Stockholm]"));

        // System.out.println(t); // 2023-07-04
        // System.out.println(ldt); // 2023-07-04T00:55:29.031
        // System.out.println(db); // 3
        System.out.println(d); // PT15H3M20.2955
    }
}
