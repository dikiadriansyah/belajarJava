import java.util.ArrayList;
import java.util.List;

public class Pitfall_string_concatenation_in_a_loop_does_not_scale {
    // Pitfall_string_concatenation_in_a_loop_does_not_scale/Kesalahan -
    // Penggabungan string dalam satu lingkaran tidak berskala

    // Perhatikan kode berikut sebagai ilustrasi:

    /*
     * public String joinWords(List<String> words) {
     * String message = "";
     * for (String word : words) {
     * message = message + " " + word;
     * }
     * return message;
     * }
     */

    /*
     * Sayangnya kode ini tidak efisien jika daftar words panjang. Akar
     * masalahnya adalah pernyataan ini:
     * 
     * message = message + " " + word;
     */

    /*
     * Untuk setiap iterasi perulangan, pernyataan ini membuat string message baru
     * yang berisi salinan semua karakter dalam string message asli dengan karakter
     * tambahan yang ditambahkan ke dalamnya. Ini menghasilkan banyak string
     * sementara, dan melakukan banyak penyalinan.
     * 
     * Saat kami menganalisis joinWords, dengan asumsi ada N kata dengan panjang
     * rata-rata M, kami menemukan bahwa O(N) string sementara dibuat dan karakter
     * O(M.N2) akan disalin dalam prosesnya. Komponen N2 sangat meresahkan.
     * 
     * Pendekatan yang disarankan untuk masalah1 semacam ini adalah dengan
     * menggunakan StringBuilder alih-alih penggabungan string sebagai berikut:
     * 
     * public String joinWords2(List<String> words) {
     * StringBuilder message = new StringBuilder();
     * for (String word : words) {
     * message.append(" ").append(word);
     * }
     * return message.toString();
     * }
     * 
     */

    /*
     * Analisis joinWords2 perlu memperhitungkan biaya tambahan untuk "growing"
     * array pendukung StringBuilder yang menyimpan karakter pembuat. Namun ternyata
     * jumlah objek baru yang dibuat adalah O(logN) dan jumlah karakter yang disalin
     * adalah O(M.N) karakter. Yang terakhir mencakup karakter yang disalin dalam
     * panggilan toString() terakhir.
     * 
     * (Dimungkinkan untuk menyempurnakannya lebih lanjut, dengan membuat
     * StringBuilder dengan kapasitas yang tepat untuk memulai.
     * Namun, kompleksitas keseluruhannya tetap sama.)
     * 
     * Kembali ke metode joinWords asli, ternyata pernyataan kritis akan
     * dioptimalkan oleh kompiler Java pada umumnya menjadi seperti ini:
     * 
     * StringBuilder tmp = new StringBuilder();
     * tmp.append(message).append(" ").append(word);
     * message = tmp.toString();
     */

    /*
     * Namun, compiler Java tidak akan "hoist" StringBuilder keluar dari loop,
     * seperti yang kita lakukan secara manual pada kode untuk joinWords2.
     * Referensi:
     * "Is Java's String '+' operator in a loop slow"
     */

    /*
     * 1 - Di Java 8 dan yang lebih baru, kelas Joiner dapat digunakan untuk
     * memecahkan masalah khusus ini. Namun, contoh ini seharusnya tidak membahas
     * hal tersebut.
     */

    // ---------------
    public String joinWords(List<String> words) {
        String message = "";
        for (String word : words) {
            message = message + " " + word;
        }
        return message;
    }

    // -----------------------
    public String joinWords2(List<String> words) {
        StringBuilder message = new StringBuilder();
        for (String word : words) {
            message.append(" ").append(word);
        }
        return message.toString();
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // -----------
        // List<String> kata = new ArrayList<>();
        // kata.add("Hai");
        // kata.add("Dunia");
        // kata.add("!");

        // Pitfall_string_concatenation_in_a_loop_does_not_scale box = new
        // Pitfall_string_concatenation_in_a_loop_does_not_scale();
        // String hasil = box.joinWords(kata);
        // System.out.println(hasil);
        /*
         * output:
         * Hai Dunia !
         */
        // -----------------
        List<String> kata = new ArrayList<>();
        kata.add("Hai");
        kata.add("Dunia");
        kata.add("!");

        Pitfall_string_concatenation_in_a_loop_does_not_scale box = new Pitfall_string_concatenation_in_a_loop_does_not_scale();
        String hasil = box.joinWords2(kata);
        System.out.println(hasil);
        /*
         * output:
         * Hai Dunia !
         */
    }
}
