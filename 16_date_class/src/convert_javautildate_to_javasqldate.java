import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class convert_javautildate_to_javasqldate {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // parameter | Explanation
        // No parameter | membuat new Date object menggunakan waktu alokasi (to the
        // nearest millisecond)
        // long Date | membuat objek tanggal baru dengan waktu yang disetel ke jumlah
        // milidetik sejak "the epoch"

        // konversi java.util.Date ke java.sql.Date biasanya diperlukan ketika objek
        // Date perlu ditulis dalam database.

        // java.sql.Date adalah pembungkus nilai milisecond dan digunakan oleh JDBC
        // untuk mengidentifikasi tipe SQL DATE

        // Dalam contoh di bawah ini, kami menggunakan konstruktor java.util.Date() ,
        // yang membuat Date object dan menginisialisasinya mewakili waktu ke milisecond
        // terdekat. Tanggal ini digunakan dalam metode convert(java.util.Date utilDate)
        // untuk mengembalikan objek java.sql.Date

        // contoh
        java.util.Date uD = new java.util.Date();
        System.out.println("hasil java.util.Date: " + uD); // hasil java.util.Date: Sat Jul 01:03:23 ICT 2023

        java.sql.Date sD = convert(uD);
        System.out.println("hasil java.sql.Date: " + sD); // hasil java.sql.Date: 2023-07-01

        DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
        System.out.println("hasil dateFormated: " + df.format(uD)); // hasil dateFormated: 01/07/2023 - 03:30:18

        // java.util.Date memiliki informasi date dan time, sedangkan java.sql.Date
        // hanya memiliki informasi date

    }

    private static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
