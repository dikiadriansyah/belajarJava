import java.util.Calendar;

public class Subtracting_calendars {
    // Subtracting calendars/Mengurangi kalender

    /*
     * Untuk mengetahui perbedaan antara dua Kalender, gunakan metode
     * getTimeInMillis()
     */

    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.DATE, c2.get(Calendar.DATE) + 1);
        System.out.println(c2.getTimeInMillis() - c1.getTimeInMillis()); // output: 86400000 (24 * 60 * 60 * 1000);
    }
}
