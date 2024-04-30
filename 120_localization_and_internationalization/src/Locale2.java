import java.util.Locale;
import java.util.ResourceBundle;

public class Locale2 {
    // Locale/Lokal

    /*
     * Kelas java.util.Locale digunakan untuk mewakili wilayah
     * "geografis, politik atau budaya" untuk melokalisasi teks tertentu,
     * nomor, tanggal atau operasi ke. Oleh karena itu, objek Lokal dapat berisi
     * negara, wilayah, bahasa, dan juga varian suatu bahasa, misalnya dialek yang
     * digunakan di wilayah tertentu di suatu negara, atau diucapkan di negara yang
     * berbeda dari negara asal bahasa tersebut.
     * 
     * Instance Locale diserahkan ke komponen yang perlu melokalisasi tindakannya,
     * baik itu mengonversi input,
     * keluaran, atau hanya membutuhkannya untuk operasi internal. Kelas Locale
     * tidak dapat melakukan internasionalisasi atau lokalisasi sendiri
     */

    // Language
    /*
     * Bahasa harus berupa kode bahasa ISO 639 2 atau 3 karakter, atau subtag bahasa
     * terdaftar hingga 8 karakter. Jika suatu bahasa memiliki kode bahasa 2 dan 3
     * karakter, gunakan kode 2 karakter. Daftar lengkap kode bahasa dapat ditemukan
     * di IANA Language Subtag Registry.
     * 
     * Kode bahasa tidak peka huruf besar-kecil, tetapi kelas Lokal selalu
     * menggunakan kode bahasa versi huruf kecil
     */

    // Creating a Locale
    // Membuat instance java.util.Locale dapat dilakukan dengan empat cara berbeda:
    /*
     * Locale constants
     * Locale constructors
     * Locale.Builder class
     * Locale.forLanguageTag factory method
     */

    // Java ResourceBundle
    // Anda membuat instance ResourceBundle seperti ini:
    /*
     * Locale locale = new Locale("en", "US");
     * ResourceBundle labels = ResourceBundle.getBundle("i18n.properties");
     * System.out.println(labels.getString("message"));
     * 
     */

    // Anggaplah saya memiliki file properti i18n.properties:

    // message=This is locale

    // hasil:
    // This is locale

    // Setting Locale
    // Jika Anda ingin mereproduksi status menggunakan bahasa lain, Anda dapat
    // menggunakan metode setDefault(). Penggunaannya:
    // setDefault(Locale.JAPANESE); //Set Japanese

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------------
        Locale locale = new Locale("en", "US");
        ResourceBundle labels = ResourceBundle.getBundle("i18n", locale);
        System.out.println(labels.getString("message"));// output: Hello, World!
    }
}
