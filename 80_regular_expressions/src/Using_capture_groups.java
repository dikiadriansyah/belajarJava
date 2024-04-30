import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Using_capture_groups {
    // Using capture groups/Menggunakan kelompok penangkapan

    /*
     * Jika Anda perlu mengekstrak bagian string dari string input, kita dapat
     * menggunakan capture groups regex.
     * 
     * Untuk contoh ini, kita akan mulai dengan regex nomor telepon sederhana:
     * \d{3}-\d{3}-\d{4}
     * 
     * Jika tanda kurung ditambahkan ke regex, setiap kumpulan tanda kurung dianggap
     * sebagai grup penangkap. Dalam hal ini, kami menggunakan apa yang disebut
     * kelompok penangkapan bernomor:
     * (\d{3})-(\d{3})-(\d{4})
     * ^-----^ ^-----^ ^-----^
     * Group 1 Group 2 Group 3
     * 
     * Sebelum kita dapat menggunakannya di Java, kita tidak boleh lupa untuk
     * mengikuti aturan Strings, menghindari garis miring terbalik, sehingga
     * menghasilkan pola berikut:
     * "(\\d{3})-(\\d{3})-(\\d{4})"
     * 
     * Sebelum kita dapat menggunakannya di Java, kita tidak boleh lupa untuk
     * mengikuti aturan Strings, menghindari garis miring terbalik, sehingga
     * menghasilkan pola berikut:
     * Pattern phonePattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");
     * Matcher phoneMatcher = phonePattern.matcher("abcd800-555-1234wxyz");
     * 
     * Selanjutnya, Matcher perlu menemukan urutan pertama yang cocok dengan regex:
     * phoneMatcher.find();
     * 
     * Sekarang, dengan menggunakan metode grup, kita dapat mengekstrak data dari
     * string:
     * String number = phoneMatcher.group(0); //"800-555-1234" (Group 0 is
     * everything the regex matched)
     * String aCode = phoneMatcher.group(1); //"800"
     * String threeDigit = phoneMatcher.group(2); //"555"
     * String fourDigit = phoneMatcher.group(3); //"1234"
     * 
     * Catatan: Matcher.group() dapat digunakan sebagai pengganti Matcher.group(0).
     * 
     * Version ≥ Java SE 7
     * 
     * Java 7 memperkenalkan grup penangkapan bernama. Grup tangkapan bernama
     * berfungsi sama dengan grup tangkapan bernomor (tetapi dengan nama, bukan
     * nomor), meskipun ada sedikit perubahan sintaksis. Menggunakan grup tangkapan
     * bernama meningkatkan keterbacaan.
     * Kita dapat mengubah kode di atas untuk menggunakan grup bernama:
     * 
     * (?\d{3})-(\d{3})-(\d{4})
     * ^----------------^ ^-----^ ^-----^
     * AreaCode Group 2 Group 3
     * 
     * Untuk mendapatkan konten "AreaCode", kita dapat menggunakan:
     * String aCode = phoneMatcher.group("AreaCode"); //"800"
     * 
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Pattern phonePattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");
        Matcher phoneMatcher = phonePattern.matcher("abcd800-555-1234wxyz");
        // if (phoneMatcher.find()) {
        // System.out.println("Nomor telepon ditemukan: " + phoneMatcher.group());
        // System.out.println("Bagian pertama: " + phoneMatcher.group(1));
        // System.out.println("Bagian kedua: " + phoneMatcher.group(2));
        // System.out.println("Bagian ketiga: " + phoneMatcher.group(3));
        // } else {
        // System.out.println("Nomor telepon tidak ditemukan.");
        // }

        /*
         * output:
         * Nomor telepon ditemukan: 800-555-1234
         * Bagian pertama: 800
         * Bagian kedua: 555
         * Bagian ketiga: 1234
         */
        // ---------------------------------------
        // if (phoneMatcher.find()) {
        // String number = phoneMatcher.group(0); // "800-555-1234" (Group 0 is
        // everything the regex matched)
        // String aCode = phoneMatcher.group(1); // "800"
        // String threeDigit = phoneMatcher.group(2); // "555"
        // String fourDigit = phoneMatcher.group(3); // "1234"

        // System.out.println("Full number: " + number);
        // System.out.println("Area code: " + aCode);
        // System.out.println("Three-digit part: " + threeDigit);
        // System.out.println("Four-digit part: " + fourDigit);
        // } else {
        // System.out.println("Phone number pattern not found.");
        // }
        /*
         * output:
         * Full number: 800-555-1234
         * Area code: 800
         * Three-digit part: 555
         * Four-digit part: 1234
         */

        // ------------------------
        if (phoneMatcher.find()) { // Anda harus memanggil find() terlebih dahulu untuk menemukan cocokan
            String areaCode = phoneMatcher.group(1); // Grup pertama (indeks 1) akan berisi kode area
            System.out.println("Area Code: " + areaCode); // Output: Area Code: 800
        } else {
            System.out.println("No phone number found");
        }
        /*
         * output:
         * Area Code: 800
         */

    }
}
