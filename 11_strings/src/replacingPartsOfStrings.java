public class replacingPartsOfStrings {
    public static void main(String[] args) {
        // Dua cara untuk mengganti: dengan regex atau dengan pencocokan persis(exact
        // match)

        // catatan:
        // objek String asli tidak akan berubah, nilai pengembalian menyimpan String
        // yang diubah.

        // exact match
        // replace single character with another single character:
        // String replace(char oldChar, char newChar)

        // Mengembalikan string baru yang dihasilkan dari penggantian semua kemunculan
        // oldChar dalam string ini dengan newChar

        String buah = "pisang";
        // System.out.println(buah.replace('i', 'a'));
        // output:
        // pasang

        // Replace sequence of characters with another sequence of characters:
        // String replace(CharSequence target, CharSequence replacement)

        // Mengganti setiap substring dari string ini yang cocok dengan urutan target
        // literal dengan literal yang ditentukan urutan penggantian.

        String hari = "Senin Selasa";
        // System.out.println(hari.replace("elasa", "ales"));
        // output: Senin Sales

        // Regex
        // Catatan:
        // pengelompokan menggunakan karakter $ untuk mereferensikan grup, seperti $1.

        // Replace all matches:
        // String replaceAll(String regex, String replacement)

        // Mengganti setiap substring dari string ini yang cocok dengan ekspresi reguler
        // yang diberikan dengan yang diberikan penggantian.

        String berita = "pada hari senin terjadi kemacetan";
        // System.out.println(berita.replaceAll("(\\w*enin)", "$1selasa"));
        // output:
        // pada hari seninselasa terjadi kemacetan

        // Replace first match only:
        // String replaceFirst(String regex, String replacement)

        // Menggantikan substring pertama dari string ini yang cocok dengan ekspresi
        // reguler yang diberikan dengan penggantian yang diberikan
        System.out.println(berita.replaceFirst("(\\w*enin)", "selasa"));
        // output:
        // pada hari selasa terjadi kemacetan
    }
}
