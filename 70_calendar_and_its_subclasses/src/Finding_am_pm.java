import java.util.Calendar;
import java.util.Date;

public class Finding_am_pm {
    // Finding AM/PM /Menemukan AM/PM

    /*
     * Dengan kelas Kalender, mudah untuk menemukan AM atau PM.
     */
    public static void main(String[] args) {
        // Mendapatkan instance dari Calendar
        Calendar cal = Calendar.getInstance();

        // Mengatur waktu Calendar dengan menggunakan objek Date saat ini
        cal.setTime(new Date());

        // Memeriksa apakah saat ini merupakan waktu PM
        if (cal.get(Calendar.AM_PM) == Calendar.PM) {
            System.out.println("It is PM");
        } else {
            System.out.println("It is AM");
        }

        /*
         * output:
         * It is PM
         */

    }
}
