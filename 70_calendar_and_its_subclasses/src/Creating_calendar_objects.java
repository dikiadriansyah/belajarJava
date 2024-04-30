import java.util.Calendar;
import java.util.GregorianCalendar;

public class Creating_calendar_objects {
    // Creating Calendar objects/Membuat objek Kalender

    // Objek calendar dapat dibuat dengan menggunakan getInstance() atau dengan
    // menggunakan konstruktor GregorianCalendar.

    /*
     * Penting untuk diperhatikan bahwa bulan di Calendar berbasis nol, yang berarti
     * JANUARY diwakili oleh nilai int 0. Untuk memberikan kode yang lebih baik,
     * selalu gunakan konstanta Kalender, seperti Calendar.JANUARY untuk menghindari
     * kesalahpahaman.
     */

    /*
     * Calendar calendar = Calendar.getInstance();
     * Calendar gregorianCalendar = new GregorianCalendar();
     * Calendar gregorianCalendarAtSpecificDay = new GregorianCalendar(2016,
     * Calendar.JANUARY, 1);
     * Calendar gregorianCalendarAtSpecificDayAndTime = new GregorianCalendar(2016,
     * Calendar.JANUARY, 1,
     * 6, 55, 10);
     */

    /*
     * Catatan: Selalu gunakan konstanta bulan: Representasi numeriknya menyesatkan,
     * mis. Calendar.JANUARY memiliki nilai 0
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Mendapatkan instance dari Calendar menggunakan getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current Date and Time: " + calendar.getTime());
        /*
         * output:
         * Current Date and Time: Sat Jan 27 12:35:35 WIB 2024
         */

        // Mendapatkan instance dari GregorianCalendar menggunakan constructor default
        Calendar gregorianCalendar = new GregorianCalendar();
        System.out.println("Gregorian Calendar: " + gregorianCalendar.getTime());
        /*
         * output:
         * Gregorian Calendar: Sat Jan 27 12:35:35 WIB 2024
         */

        // Mendapatkan instance dari GregorianCalendar pada tanggal tertentu
        Calendar gregorianCalendarAtSpecificDay = new GregorianCalendar(2016, Calendar.JANUARY, 1);
        System.out.println("Specific Day Gregorian Calendar: " + gregorianCalendarAtSpecificDay.getTime());
        /*
         * output:
         * Specific Day Gregorian Calendar: Fri Jan 01 00:00:00 WIB 2016
         */

        // Mendapatkan instance dari GregorianCalendar pada tanggal dan waktu tertentu
        Calendar gregorianCalendarAtSpecificDayAndTime = new GregorianCalendar(2016, Calendar.JANUARY, 1, 6, 55, 10);
        System.out.println(
                "Specific Day and Time Gregorian Calendar: " + gregorianCalendarAtSpecificDayAndTime.getTime());
        /*
         * output:
         * Specific Day and Time Gregorian Calendar: Fri Jan 01 06:55:10 WIB 2016
         */

    }
}
