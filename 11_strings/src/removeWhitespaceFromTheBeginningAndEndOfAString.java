public class removeWhitespaceFromTheBeginningAndEndOfAString {
    public static void main(String[] args) {
        // Metode trim() mengembalikan String baru dengan spasi kosong di awal dan akhir
        // dihapus.
        String perkenalan = new String(" Assalamualaikum teman semua! ");
        String hasil = perkenalan.trim(); // hapus spasi kosong di awal dan akhir
        System.out.println(hasil);

        // Jika Anda triM sebuah String yang tidak memiliki spasi untuk dihapus, Anda
        // akan dikembalikan ke instance String yang sama.

        // Perhatikan bahwa metode trim() memiliki pengertiannya sendiri tentang spasi,
        // yang berbeda dari pengertian yang digunakan oleh Metode
        // Character.isWhitespace():
        // - All ASCII control characters with codes U+0000 to U+0020 are considered
        // whitespace and are removed by trim(). This includes U+0020 'SPACE', U+0009
        // 'CHARACTER TABULATION', U+000A 'LINE FEED' and U+000D 'CARRIAGE RETURN'
        // characters, but also the characters like U+0007 'BELL'.
        // - Unicode whitespace like U+00A0 'NO-BREAK SPACE' or U+2003 'EM SPACE' are
        // not recognized by trim().

    }
}
