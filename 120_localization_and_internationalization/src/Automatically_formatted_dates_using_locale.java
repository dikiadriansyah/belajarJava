import java.text.DateFormat;
import java.util.Date;

public class Automatically_formatted_dates_using_locale {
    // Automatically formatted Dates using "locale" /Tanggal yang diformat secara
    // otomatis menggunakan "lokal"

    /*
     * SimpleDateFormat sangat bagus dalam keadaan darurat, tetapi seperti namanya,
     * skalanya tidak baik.
     * 
     * Jika Anda melakukan hard-code "MM/dd/yyyy" di seluruh aplikasi Anda, pengguna
     * internasional Anda tidak akan senang
     */

    // Biarkan Java yang bekerja untuk Anda
    /*
     * Gunakan metode static di DateFormat untuk mengambil format yang tepat untuk
     * pengguna Anda. Untuk aplikasi desktop (di mana Anda akan mengandalkan default
     * locale), cukup panggil:
     * String localizedDate = DateFormat.getDateInstance(style).format(date);
     * 
     */

    /*
     * Dimana gaya adalah salah satu konstanta pemformatan (FULL, LONG, MEDIUM,
     * SHORT, dll.) yang ditentukan dalam DateFormat.
     * 
     * Untuk aplikasi sisi server di mana pengguna menentukan lokalnya sebagai
     * bagian dari permintaan, Anda harus meneruskannya secara eksplisit ke
     * getDateInstance() sebagai gantinya:
     * String localizedDate =
     * DateFormat.getDateInstance(style, request.getLocale()).format(date);
     */

    public static void main(String[] args) throws Exception {
        // Tanggal yang akan diformat
        Date date = new Date();

        // Gaya format tanggal yang diinginkan (contoh: DateFormat.SHORT)
        int style = DateFormat.SHORT;

        // Format tanggal menggunakan DateFormat
        String localizedDate = DateFormat.getDateInstance(style).format(date);

        // Tampilkan hasil
        System.out.println("Tanggal yang diformat: " + localizedDate);
        /*
         * output:
         * Tanggal yang diformat: 3/5/24
         */
    }
}
