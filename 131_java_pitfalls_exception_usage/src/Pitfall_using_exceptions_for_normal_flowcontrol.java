public class Pitfall_using_exceptions_for_normal_flowcontrol {
    // Pitfall - Using exceptions for normal flowcontrol/Kesalahan - Menggunakan
    // pengecualian untuk kontrol aliran normal

    /*
     * Ada mantra yang tidak boleh diucapkan oleh beberapa ahli Java:
     * "Exceptions should only be used for exceptional cases."
     * /"Pengecualian hanya boleh digunakan untuk kasus luar biasa."
     */

    // (contoh: http://programmers.stackexchange.com/questions/184654 )

    /*
     * Inti dari hal ini adalah merupakan ide yang buruk (di Java) untuk menggunakan
     * pengecualian dan penanganan pengecualian untuk mengimplementasikan normal
     * Alur kontrol. Misalnya, bandingkan dua cara menangani parameter yang mungkin
     * bernilai null.
     */

    /*
     * public String truncateWordOrNull(String word, int maxLength) {
     * if (word == null) {
     * return "";
     * } else {
     * return word.substring(0, Math.min(word.length(), maxLength));
     * }
     * }
     * public String truncateWordOrNull(String word, int maxLength) {
     * try {
     * return word.substring(0, Math.min(word.length(), maxLength));
     * } catch (NullPointerException ex) {
     * return "";
     * }
     * }
     */

    /*
     * Dalam contoh ini, kami (secara sengaja) memperlakukan kasus di mana Word
     * adalah null seolah-olah itu adalah Word yang kosong. Dua versi
     * menangani null baik menggunakan if ... else konvensional dan atau try ...
     * catch. Bagaimana kita memutuskan versi mana yang lebih baik?
     * 
     * Kriteria pertama adalah keterbacaan. Meskipun keterbacaan sulit diukur secara
     * obyektif, sebagian besar pemrogram akan setuju bahwa arti penting dari versi
     * pertama lebih mudah untuk dipahami. Memang benar, untuk benar-benar memahami
     * bentuk kedua, Anda perlu memahami bahwa NullPointerException tidak dapat
     * dilempar oleh Math.min atau
     * Metode String.substring.
     * 
     * Kriteria kedua adalah efisiensi. Dalam rilis Java sebelum Java 8, versi kedua
     * secara signifikan (urutan besarnya) lebih lambat dibandingkan versi pertama.
     * Secara khusus, konstruksi objek pengecualian memerlukan penangkapan dan
     * pencatatan stackframe, untuk berjaga-jaga jika stacktrace diperlukan.
     * 
     * Di sisi lain, ada banyak situasi di mana penggunaan pengecualian lebih mudah
     * dibaca, lebih efisien dan (terkadang) lebih tepat daripada menggunakan kode
     * kondisional untuk menangani kejadian "exceptional". Memang benar, ada situasi
     * yang jarang terjadi di mana perlu menggunakannya untuk acara yang
     * "non exceptional"; yaitu peristiwa yang relatif sering terjadi.
     * Untuk yang terakhir, ada baiknya mencari cara untuk mengurangi biaya tambahan
     * dalam pembuatan objek pengecualian.
     */

    public static void main(String[] args) throws Exception {
        Pitfall_using_exceptions_for_normal_flowcontrol main = new Pitfall_using_exceptions_for_normal_flowcontrol();

        // Contoh pemanggilan metode truncateWordOrNull
        String word1 = "Hello";
        String truncatedWord1 = main.truncateWordOrNull(word1, 3);
        System.out.println("Truncated Word 1: " + truncatedWord1); // Output: Truncated Word 1: Hel

        String word2 = "World";
        String truncatedWord2 = main.truncateWordOrNull(word2, 5);
        System.out.println("Truncated Word 2: " + truncatedWord2); // Output: Truncated Word 2: World
    }

    public String truncateWordOrNull(String word, int maxLength) {
        if (word == null) {
            return "";
        } else {
            return word.substring(0, Math.min(word.length(), maxLength));
        }
    }

}
