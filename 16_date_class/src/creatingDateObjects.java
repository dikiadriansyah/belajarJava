import java.util.Calendar;
import java.util.Date;

public class creatingDateObjects {
    public static void main(String[] args) {
        Date d = new Date();
        // System.out.println(d); // Sun Jul 02 02:34:47 ICT 2023

        // Di sini objek Date ini berisi Date dan time saat ini saat objek ini
        // dibuat.

        Calendar c = Calendar.getInstance();
        c.set(90, Calendar.DECEMBER, 11);
        Date mbd = c.getTime();
        // System.out.println(mbd); // output: Sat Dec 11 02:37:02 ICT 90

        // Objek tanggal paling baik dibuat melalui instance Calendar karena penggunaan
        // konstruktor data sudah tidak digunakan lagi dan
        // patah semangat. Untuk melakukannya, kita perlu mendapatkan turunan dari kelas
        // Kalender dari metode pabrik. Kemudian kita bisa mengatur
        // year, month, dan day dalam sebulan dengan menggunakan angka atau dalam hal
        // konstanta bulan disediakan py kelas Kalender untuk meningkatkan keterbacaan
        // dan mengurangi kesalahan.

        c.set(90, Calendar.DECEMBER, 11, 8, 32, 35);
        Date mbd2 = c.getTime();
        System.out.println(mbd2); // output: Sat Dec 11 08:32:35 ICT 90

        // Selain date, kita juga bisa melewati waktu dalam urutan hour, minutes, dan
        // seconds.

    }
}
