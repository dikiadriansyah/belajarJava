import java.time.LocalTime;

public class timeModification {
    public static void main(String[] args) {
        // anda dapat menambah hours, minutes, seconds dan nanoseconds:
        LocalTime t = LocalTime.now();
        // System.out.println(t);
        // output: 22:25:03

        LocalTime addHours = t.plusHours(3); // add 3 hours
        // System.out.println(addHours);
        // output: 01:25:53

        LocalTime addMinute = t.plusMinutes(4); // add 4 minutes
        // System.out.println(addMinute);
        // output: 22:31:02

        LocalTime addSeconds = t.plusSeconds(23); // add 23 seconds
        // System.out.println(addSeconds);
        // output: 22:33:50

        LocalTime addNanoSeconds = t.plusNanos(250_000_000); // add 250.000.000ns (250ms)
        System.out.println(addNanoSeconds);
        // ouput: 22:34:53.157860800

    }
}
