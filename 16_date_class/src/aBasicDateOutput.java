import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class aBasicDateOutput {
    public static void main(String[] args) {

        // Menggunakan kode berikut dengan format string yyyy/MM/dd hh:mm.ss, kita akan
        // menerima output berikut:
        // 2023/07/01 01:03.30

        // define the format to use
        String formatDateString = "yyyy/MM/dd hh:mm.s";

        // get a current date object
        Date d = Calendar.getInstance().getTime();

        // create the formatter
        SimpleDateFormat SDF = new SimpleDateFormat(formatDateString);

        // format the date
        String fd = SDF.format(d);

        // print it
        // System.out.println(fd); // 2023/07/01 03:38.19

        // single-line version of all above code
        System.out.println(new SimpleDateFormat("yyyy/MM/dd hh:mm.ss").format(Calendar.getInstance().getTime()));
        // output:
        // 2023/07/01 03:38.19
    }
}
