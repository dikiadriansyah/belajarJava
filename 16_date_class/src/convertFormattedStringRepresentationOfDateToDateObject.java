import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class convertFormattedStringRepresentationOfDateToDateObject {

    public static Date parseDate(String formattedDate, String dateFormat) {
        // Metode ini dapat digunakan untuk mengonversi representasi string tanggal yang
        // diformat menjadi date objek.

        /**
         * Parses the date using the given format.
         *
         * @param formattedDate the formatted date string
         * @param dateFormat    the date format which was used to create the string.
         * @return the date
         */

        Date date = null;
        SimpleDateFormat SDF = new SimpleDateFormat(dateFormat);

        try {
            date = SDF.parse(formattedDate);
        } catch (ParseException e) {
            // System.out.println("Something went wrong.");
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        String formattedDate = "02-07-2023";
        String dateFormat = "dd-MM-yyyy";
        Date date = parseDate(formattedDate, dateFormat);
        System.out.println(date); // output: Sun Jul 02 00:00:00 ICT 2023

    }
}
