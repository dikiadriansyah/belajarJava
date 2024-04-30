// Usage of various classes of Date Time API  / Penggunaan berbagai kelas Date Time API

import java.sql.Time;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class usageOfVariousClassesOfDateTimeAPI {
    public static void main(String[] args) {
        // contoh berikut juga memiliki penjelasan yang diperlukan untuk memahami contoh
        // di dalamnya.

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("Local Date Time menggunakan static now() method :::>>>" +
                ldt);
        // output: Local Date Time menggunakan static now() method
        // :::>>>2023-07-04T15:35:52.767
        // ----------------------------------

        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("AET")));
        System.out.println("LOCAL TIME USING now(ZoneId zoneId) method ::: >>>>" + ldt1);
        // output: LOCAL TIME USING now(ZoneId zoneId) method :::
        // >>>>2023-07-04T18:39:25.515
        // ----------------------------------

        LocalDateTime ldt2 = LocalDateTime.now(Clock.system(ZoneId.of(ZoneId.SHORT_IDS.get("PST"))));
        System.out.println("Local TIME USING now(Clock.system(ZoneId.of())) ::: >>>>"
                + ldt2);
        // output: Local TIME USING now(Clock.system(ZoneId.of())) :::
        // >>>>2023-07-04T01:50:02.631

        System.out.println("Following is a static map in ZoneId class which has  mapping of short timezone\r\n"
                + "names to their Actual timezone names");
        // Following is a static map in ZoneId class which has mapping of short timezone
        // names to their Actual timezone names
        // ----------------------------------

        System.out.println(ZoneId.SHORT_IDS);
        // {CTT=Asia/Shanghai, ART=Africa/Cairo, CNT=America/St_Johns,
        // PRT=America/Puerto_Rico, PNT=America/Phoenix, PLT=Asia/Karachi,
        // AST=America/Anchorage, BST=Asia/Dhaka, CST=America/Chicago, EST=-05:00,
        // HST=-10:00, JST=Asia/Tokyo, IST=Asia/Kolkata,
        // AGT=America/Argentina/Buenos_Aires, NST=Pacific/Auckland, MST=-07:00,
        // AET=Australia/Sydney, BET=America/Sao_Paulo, PST=America/Los_Angeles,
        // ACT=Australia/Darwin, SST=Pacific/Guadalcanal, VST=Asia/Ho_Chi_Minh,
        // CAT=Africa/Harare, ECT=Europe/Paris, EAT=Africa/Addis_Ababa,
        // IET=America/Indiana/Indianapolis, MIT=Pacific/Apia, NET=Asia/Yerevan}

        checkLocalDate();
        checkClock();
        CheckDuration();
        checkLocalTime();
        checkZonedDateTime();
    }

    public static void checkLocalDate() {
        /**
         * This has the methods of the class {@link LocalDate}
         */
        LocalDate ld = LocalDate.now();
        // LocalDate.now() artinya

        System.out.println("Memberikan tanggal tanpa Waktu menggunakan metode now().        >>" + ld);
        // output: Memberikan tanggal tanpa Waktu menggunakan metode now(). >>2023-07-04

        // ----------------------------------

        LocalDate ld2 = LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("ECT")));
        // ZoneId.of() artinya

        // ZoneId.SHORT_IDS.get() artinya

        System.out.println(
                "now() diganti untuk mengambil ZoneID sebagai parameter menggunakan ini kita bisa mendapatkan tanggal yang sama di bawah zona waktu yang berbeda. >>"
                        + ld2);
        // output: now() diganti untuk mengambil ZoneID sebagai parameter menggunakan
        // ini kita bisa mendapatkan tanggal yang sama di bawah zona waktu yang berbeda.
        // >>2023-08-01

    }

    // This has the methods of abstract class {@link Clock}. Clock can be used
    // * for time which has time with {@link TimeZone}.

    public static void checkClock() {
        Clock c = Clock.systemUTC();
        // Clock.systemUTC() artinya

        // Represents time according to ISO 8601
        System.out.println("Waktu menggunakan kelas Jam :" + c.instant());
        // .instant() artinya

        // output: Waktu menggunakan kelas Jam :2023-08-01T22:08:37.874592900Z
    }

    /**
     * This class checks the methods of the {@link Duration} class.
     */

    public static void CheckDuration() {
        // toString() converts the duration to PTnHnMnS format according to ISO
        // 8601 standard. If a field is zero its ignored.

        // P is the duration designator (historically called "period") placed at
        // the start of the duration representation.

        // Y is the year designator that follows the value for the number of
        // years.

        // M is the month designator that follows the value for the number of
        // months.

        // W is the week designator that follows the value for the number of
        // weeks.

        // D is the day designator that follows the value for the number of
        // days.

        // T is the time designator that precedes the time components of the
        // representation.

        // H is the hour designator that follows the value for the number of
        // hours.

        // M is the minute designator that follows the value for the number of
        // minutes.

        // S is the second designator that follows the value for the number of
        // seconds.

        System.out.println(Duration.ofDays(2));
        // .ofDays()
        // output: PT48H

    }

    /**
     * Shows Local time without date. It doesn't store or represenet a date and
     * time. Instead its a representation of Time like clock on the wall.
     */
    public static void checkLocalTime() {
        LocalTime lt = LocalTime.now();
        // System.out.println("Lokal Waktu:: " + lt);
        // Output: Lokal Waktu: 05:17:22.838
    }

    // A date time with Time zone details in ISO-8601 standards.

    public static void checkZonedDateTime() {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CST")));
        System.out.println(zdt);
        // output: 2023-08-01T17:19:22.993631-05:00[America/Chicago]
    }

}
