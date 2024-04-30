import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertingDateToACertainStringFormat {
    public static void main(String[] args) {
        // format() dari kelas SimpleDateFormat membantu mengonversi Date object
        // menjadi objek String format tertentu dengan menggunakan
        // string pola yang disediakan.
        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yy"); // patern is specified her
        // System.out.println(df.format(t)); // output: 01-Jul-23

        // Pola dapat diterapkan lagi dengan menggunakan applyPattern()
        df.applyPattern("dd-MM-yyyy");
        // System.out.println(df.format(t)); // output: 01-07-2023

        df.applyPattern("dd-MM-yyyy HH:mm:ss E");
        System.out.println(df.format(t)); // output: 01-07-2023 12:15:45 sat

        // Catatan:
        // Di sini mm (huruf kecil m) menunjukkan menit dan MM (huruf besar M)
        // menunjukkan bulan. Perhatikan baik-baik kapan format tahun: kapital "Y" (Y)
        // menunjukkan "minggu dalam tahun" sedangkan huruf kecil "y" (y) menunjukkan
        // tahun.
    }
}
