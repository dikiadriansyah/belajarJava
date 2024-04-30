import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class timeZonesAndjavautildate {
    public static void main(String[] args) {
        // Objek java.util.Date tidak memiliki konsep timezone.

        // - Tidak ada cara untuk menetapkan timezone untuk Tanggal
        // - Tidak ada cara untuk mengubah timezone objek Tanggal
        // - Date Object yang dibuat dengan konstruktor default new Date() akan
        // diinisialisasi dengan waktu saat ini di timezone default sistem

        // Namun, dimungkinkan untuk menampilkan tanggal yang diwakili oleh titik waktu
        // yang dijelaskan oleh Date object di timezone yang berbeda menggunakan
        // mis. java.text.SimpleDateFormat:
        Date d = new Date();

        // print default timezone
        System.out.println(TimeZone.getDefault().getDisplayName()); // indochina time

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // catatan: zona waktu tidak dalam format

        // cetak tanggal dalam zona waktu asli
        System.out.println(sdf.format(d)); // 2023-07-02 21:26:08

        // waktu sekarang dalam london
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(sdf.format(d)); // 2023-07-02 15:27:31
    }
}
