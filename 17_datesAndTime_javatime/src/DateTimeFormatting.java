
// Sebelum Java 8, ada kelas DateFormat dan SimpleDateFormat dalam paket java.text dan kode lama ini akan terus digunakan untuk beberapa waktu.
// Namun, Java 8 menawarkan pendekatan modern untuk menangani Pemformatan dan Parsing.
// Dalam pemformatan dan penguraian, pertama Anda meneruskan objek String ke DateTimeFormatter, dan pada gilirannya menggunakannya untuk formatting atau parsing.
import java.time.*;
import java.time.format.*;

public class DateTimeFormatting {
    public static void main(String[] args) {
        // Parsing
        String p = "d-MM-yyyy HH:mm";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(p);
        // DateTimeFormatter.ofPattern() artinya

        LocalDateTime ldt1 = LocalDateTime.parse("2015-02-24T02:31");
        // LocalDateTime.parse() artinya
        LocalDateTime ldt2 = LocalDateTime.parse("22-04-2016 14:42", dtf);
        // System.out.println(ldt1 + "\n" + ldt2);
        // output:
        // 2015-02-24T02:31
        // 2016-04-22T14:42

        // -----------------------------
        // Formatting
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("EEE d, MMMM, yyyy HH:mm");
        DateTimeFormatter dtf3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // DateTimeFormatter.ISO_LOCAL_DATE_TIME

        LocalDateTime ldtf1 = LocalDateTime.now();
        // LocalDateTime.now()

        System.out.println(ldtf1.format(dtf2) + "\n" + ldtf1.format(dtf3));
        // .format() artinya

        // output:
        // Wed 2, August, 2023 11:36
        // 2023-08-02T11:36:37.6352775

        // Pemberitahuan penting, alih-alih menggunakan pola Kustom, sebaiknya gunakan
        // pemformat yang telah ditentukan sebelumnya. Kode Anda terlihat lebih jelas
        // dan penggunaan ISO8061 pasti akan membantu Anda dalam jangka panjang.
    }

}
