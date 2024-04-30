import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pitfall_efficiency_concern_with_regular_expressions {
    // Pitfall - Efficiency concerns with regular expressions/Kesalahan - Masalah
    // efisiensi dengan ekspresi reguler

    /*
     * Pencocokan ekspresi reguler adalah alat yang ampuh (di Java, dan dalam
     * konteks lain) namun memiliki beberapa kelemahan.
     * Salah satunya adalah ekspresi reguler yang cenderung agak mahal.
     */

    /*
     * Contoh Pola dan Pencocokan harus digunakan kembali
     * 
     * Perhatikan contoh berikut:
     * 
     * //Test if all strings in a list consist of English letters and numbers.
     * //@param strings the list to be checked
     * //@return 'true' if an only if all strings satisfy the criteria
     * //@throws NullPointerException if 'strings' is 'null' or a 'null' element.
     * public boolean allAlphanumeric(List<String> strings) {
     * for (String s : strings) {
     * if (!s.matches("[A-Za-z0-9]*")) {
     * return false;
     * }
     * }
     * return true;
     * }
     */

    /*
     * Kode ini benar, tetapi tidak efisien. Masalahnya ada pada panggilan
     * match(...). Di bawah tenda, s.matches("[A-Za-z0-9]*") setara dengan ini:
     * 
     * Pattern.matches(s, "[A-Za-z0-9]*")
     */

    // yang pada gilirannya setara dengan
    // Pattern.compile("[A-Za-z0-9]*").matcher(s).matches()

    /*
     * Panggilan Pattern.compile("[A-Za-z0-9]*") mem-parsing ekspresi reguler,
     * menganalisisnya, dan membuat objek Pola yang menyimpan struktur data yang
     * akan digunakan oleh mesin regex. Ini adalah perhitungan yang tidak sepele.
     * Kemudian objek Matcher dibuat untuk membungkus argumen s. Terakhir kami
     * memanggil match() untuk melakukan pencocokan pola sebenarnya.
     * 
     * Masalahnya adalah semua pekerjaan ini diulangi untuk setiap iterasi loop.
     * Solusinya adalah dengan merestrukturisasi kode sebagai berikut:
     * 
     * private static Pattern ALPHA_NUMERIC = Pattern.compile("[A-Za-z0-9]*");
     * public boolean allAlphanumeric(List<String> strings) {
     * Matcher matcher = ALPHA_NUMERIC.matcher("");
     * for (String s : strings) {
     * matcher.reset(s);
     * if (!matcher.matches()) {
     * return false;
     * }
     * }
     * return true;
     * }
     * 
     */

    // Perhatikan bahwa javadoc untuk Pola menyatakan:
    /*
     * Contoh kelas ini tidak dapat diubah dan aman untuk digunakan oleh beberapa
     * thread secara bersamaan. Contoh kelas Matcher tidak aman untuk penggunaan
     * seperti itu.
     */

    // Don't use match() when you should use find()/Jangan gunakan match() saat Anda
    // harus menggunakan find()

    /*
     * Misalkan Anda ingin menguji apakah sebuah string s berisi tiga digit atau
     * lebih berturut-turut. Anda dapat mengungkapkannya dengan berbagai cara
     * termasuk:
     * if (s.matches(".*[0-9]{3}.*")) {
     * System.out.println("matches");
     * }
     */

    // atau
    /*
     * if (Pattern.compile("[0-9]{3}").matcher(s).find()) {
     * System.out.println("matches");
     * }
     */

    /*
     * Cara pertama lebih ringkas, namun mungkin juga kurang efisien. Sepintas lalu,
     * versi pertama akan mencoba mencocokkan seluruh string dengan polanya. Lebih
     * jauh lagi, karena ".*" adalah pola "greedy", pencocokan pola kemungkinan
     * akan maju "dengan penuh semangat" mencoba ke akhir string, dan mundur hingga
     * menemukan kecocokan.
     * 
     * Sebaliknya, versi kedua akan mencari dari kiri ke kanan dan akan berhenti
     * mencari segera setelah menemukan 3 digit berturut-turut.
     */

    // Use more efficient alternatives to regular expressions/Gunakan alternatif
    // yang lebih efisien untuk ekspresi reguler

    /*
     * Ekspresi reguler adalah alat yang ampuh, tetapi ekspresi reguler tidak boleh
     * menjadi satu-satunya alat Anda. Banyak tugas yang dapat dilakukan dengan
     * lebih efisien dengan cara lain. Misalnya:
     * 
     * Pattern.compile("ABC").matcher(s).find()
     * 
     */

    // melakukan hal yang sama seperti:
    // s.contains("ABC")

    /*
     * kecuali bahwa yang terakhir ini jauh lebih efisien. (Bahkan jika Anda dapat
     * mengamortisasi biaya kompilasi ekspresi reguler.)
     * 
     * Seringkali, bentuk non-regex lebih rumit. Misalnya, pengujian yang dilakukan
     * oleh panggilan match() metode allAlplanumeric sebelumnya dapat ditulis ulang
     * sebagai:
     * 
     * public boolean matches(String s) {
     * for (char c : s) {
     * if ((c >= 'A' && c <= 'Z') ||
     * (c >= 'a' && c <= 'z') ||
     * (c >= '0' && c <= '9')) {
     * return false;
     * }
     * }
     * return true;
     * }
     */

    // Ini lebih banyak kodenya daripada menggunakan Matcher, tapi ini juga akan
    // jauh lebih cepat.

    // Catastrophic Backtracking/Kemunduran Bencana
    /*
     * (Ini berpotensi menjadi masalah dengan semua implementasi ekspresi reguler,
     * namun kami akan menyebutkannya di sini karena ini merupakan jebakan bagi
     * penggunaan Pattern.)
     * 
     * Pertimbangkan contoh (yang dibuat-buat) ini:
     * 
     * Pattern pat = Pattern.compile("(A+)+B");
     * System.out.println(pat.matcher("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB").matches());
     * System.out.println(pat.matcher("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC").matches());
     */

    /*
     * Panggilan println pertama akan dengan cepat mencetak true. Yang kedua akan
     * mencetak false. Pada akhirnya. Memang benar, jika Anda bereksperimen dengan
     * kode di atas, Anda akan melihat bahwa setiap kali Anda menambahkan A sebelum
     * C, waktu yang dibutuhkan akan berlipat ganda.
     * 
     * Perilaku ini adalah contoh kemunduran yang membawa bencana. Mesin pencocokan
     * pola yang mengimplementasikan pencocokan regex adalah upaya sia-sia untuk
     * mencoba semua cara yang mungkin agar polanya cocok.
     * 
     * Mari kita lihat apa sebenarnya arti (A+)+B. Secara dangkal, tampaknya
     * dikatakan "satu atau lebih karakter A diikuti oleh nilai B", namun
     * kenyataannya dikatakan satu atau lebih grup, yang masing-masing terdiri dari
     * satu atau lebih karakter A. Jadi, misalnya:
     * 1. 'AB' hanya cocok dengan satu arah: '(A)B'
     * 2. 'AAB' cocok dengan dua cara: '(AA)B' atau '(A)(A)B`
     * 3. 'AAAB' cocok dengan empat cara: '(AAA)B' atau '(AA)(A)Bor '(A)(AA)B atau
     * '(A)(A)(A)B`
     * 4. dan seterusnya
     * 
     * Dengan kata lain, banyaknya kemungkinan kecocokan adalah 2N dimana N adalah
     * banyaknya karakter A.
     */

    /*
     * Contoh di atas jelas dibuat-buat, namun polanya menunjukkan karakteristik
     * kinerja semacam ini (yaitu
     * O(2^N) atau O(N^K) untuk K) yang besar sering muncul ketika ekspresi reguler
     * yang tidak dipertimbangkan dengan baik digunakan. Ada beberapa pengobatan
     * standar:
     * 1. Hindari pola berulang yang bersarang di dalam pola berulang lainnya.
     * 2. Hindari menggunakan terlalu banyak pola yang berulang.
     * 3. Gunakan pengulangan non-mundur jika diperlukan.
     * 4. Jangan gunakan regex untuk tugas parsing yang rumit. (Tulis parser yang
     * tepat sebagai gantinya.)
     * 
     * Terakhir, waspadalah terhadap situasi di mana pengguna atau klien API dapat
     * menyediakan string regex dengan karakteristik patologis.
     * Hal ini dapat menyebabkan "penolakan layanan" yang tidak disengaja atau
     * disengaja.
     * 
     * Referensi:
     * 1. Tag Regular Expressions, khususnya
     * http://stackoverflow.com/documentation/regex/977/backtracking#t=
     * 201610010339131361163 dan
     * http://stackoverflow.com/documentation/regex/4527/when-you-should-not-use-
     * regular-expressions#t=2016
     * 10010339593564913
     * 2. "Kinerja Regex" oleh Jeff Atwood.
     * 3. "Cara mematikan Java dengan Ekspresi Reguler" oleh Andreas Haufler.
     */
    // ------------------------
    // private static Pattern ALPHA_NUMERIC = Pattern.compile("[A-Za-z0-9]*");

    // public boolean allAlphanumeric(List<String> strings) {
    // Matcher matcher = ALPHA_NUMERIC.matcher("");
    // for (String s : strings) {
    // matcher.reset(s);
    // if (!matcher.matches()) {
    // return false;
    // }
    // }
    // return true;
    // }
    // ----------------------------

    public boolean matches(String s) {
        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') ||
                    (c >= 'a' && c <= 'z') ||
                    (c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        // Pitfall_efficiency_concern_with_regular_expressions box = new
        // Pitfall_efficiency_concern_with_regular_expressions();
        // List<String> strings1 = List.of("abc123", "def456", "789ghi");
        // List<String> strings2 = List.of("abc123", "def456", "789ghi$");

        // System.out.println("All strings in strings1 are alphanumeric: " +
        // box.allAlphanumeric(strings1));
        // output: All strings in strings1 are alphanumeric: true

        // System.out.println("All strings in strings2 are alphanumeric: " +
        // box.allAlphanumeric(strings2));
        // output:All strings in strings2 are alphanumeric: false
        // ----------------------------------
        Pitfall_efficiency_concern_with_regular_expressions box = new Pitfall_efficiency_concern_with_regular_expressions();
        String input1 = "Hello123"; // Contoh string dengan huruf besar, huruf kecil, dan angka
        String input2 = "@#$%"; // Contoh string hanya dengan karakter khusus

        // System.out.println("Input 1: " + input1);
        // System.out.println("Result 1: " + box.matches(input1)); // Hasil harusnya
        // false karena ada huruf besar, huruf
        // kecil, dan angka
        // System.out.println();
        /*
         * output:
         * Input 1: Hello123
         * Result 1: false
         */

        // System.out.println("Input 2: " + input2);
        // System.out.println("Result 2: " + box.matches(input2)); // Hasil harusnya
        // true karena hanya karakter khusus
        /*
         * output:
         * Input 2: @#$%
         * Result 2: true
         */
        // ----------------------
        Pattern pat = Pattern.compile("(A+)+B");
        System.out.println(pat.matcher("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB").matches()); // output: true
        System.out.println(pat.matcher("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC").matches()); // output: false
    }
}
