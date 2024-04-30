import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class convertingStringIntoDate {
    public static void main(String[] args) throws ParseException {
        // parse() dari SimpleDateFormat class membantu mengubah pola String menjadi
        // Date object

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
        String dstr = "07/01/2023"; // input string
        Date d = df.parse(dstr);
        System.out.println(d.getYear()); // 123

        // ada 4 gaya berbeda untuk format teks, SHORT, MEDIUM(this is default), LONG
        // dan FULL, semuanya bergantung pada locale. jika tidak ada locale yg
        // ditentukan, lokal default sistem akan digunakan.

        // Style | Locale.US | Locale.France
        // SHORT | 6/30/09 | 30/06/09
        // MEDIUM | Jun 30, 2009 | 30 juin 2009
        // LONG | June 30, 2009 | 30 juin 2009
        // FULL | Tuesday, June 30, 2009 | mardi 30 juin 2009

    }
}
