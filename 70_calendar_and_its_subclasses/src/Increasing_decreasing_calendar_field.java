import java.util.Calendar;
import java.util.GregorianCalendar;

public class Increasing_decreasing_calendar_field {
    // Increasing / Decreasing calendar fields / Menambah / Mengurangi bidang
    // kalender

    /*
     * add() dan roll() dapat digunakan untuk menambah/mengurangi bidang Kalender.
     * Calendar calendar = new GregorianCalendar(2016, Calendar.MARCH, 31); // 31
     * March 2016
     */

    /*
     * Metode add() mempengaruhi semua bidang, dan berperilaku efektif jika
     * seseorang menambah atau mengurangi tanggal sebenarnya dari kalender
     * calendar.add(Calendar.MONTH, -6);
     */

    /*
     * Operasi di atas menghapus enam bulan dari kalender, membawa kita kembali ke
     * 30 September 2015.
     * Untuk mengubah bidang tertentu tanpa mempengaruhi bidang lainnya, gunakan
     * roll().
     * calendar.roll(Calendar.MONTH, -6);
     */

    /*
     * Operasi di atas menghilangkan enam bulan dari month ini, sehingga bulan
     * tersebut diidentifikasi sebagai September. Tidak ada bidang lain yang
     * disesuaikan; tahun tidak berubah dengan operasi ini.
     */

    public static void main(String[] args) {
        // Membuat objek Calendar dan mengatur tanggal awal (31 Maret 2016)
        Calendar calendar = new GregorianCalendar(2016, Calendar.MARCH, 31);
        System.out.println("Tanggal Awal: " + calendar.getTime());
        /*
         * output:
         * Tanggal Awal: Thu Mar 31 00:00:00 WIB 2016
         */

        // Menambahkan 6 bulan ke belakang
        calendar.add(Calendar.MONTH, -6);

        // Menampilkan tanggal setelah penambahan
        System.out.println("Setelah dikurangi 6 bulan: " + calendar.getTime());
        /*
         * output:
         * Setelah dikurangi 6 bulan: Wed Sep 30 00:00:00 WIB 2015
         */
    }
}
