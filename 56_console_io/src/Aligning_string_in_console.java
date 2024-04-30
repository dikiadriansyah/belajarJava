public class Aligning_string_in_console {
    // Aligning strings in console / Menyelaraskan string di konsol

    /*
     * Metode PrintWriter.format (dipanggil melalui System.out.format) dapat
     * digunakan untuk mencetak string yang disejajarkan di konsol. Metode ini
     * menerima sebuah String dengan informasi format dan serangkaian objek yang
     * akan diformat:
     */

    public static void main(String[] args) {
        // String rowsStrings[] = new String[] { "1", "1234", "1234567", "123456789" };
        // String column1Format = "%-3s"; // min 3 characters, left aligned
        // String column2Format = "%-5.8s"; // min 5 and max 8 characters, left aligned
        // String column3Format = "%6.6s"; // fixed size 6 characters, right aligned
        // String formatInfo = column1Format + " " + column2Format + " " +
        // column3Format;

        // for (int i = 0; i < rowsStrings.length; i++) {
        // System.out.format(formatInfo, rowsStrings[i], rowsStrings[i],
        // rowsStrings[i]);
        // System.out.println();
        // }
        /*
         * output:
         * 1 1 1
         * 1234 1234 1234
         * 1234567 1234567 123456
         * 123456789 12345678 123456
         */
        // -----------------------------
        // Menggunakan format string dengan ukuran tetap memungkinkan untuk mencetak
        // string dalam tampilan seperti tabel dengan kolom ukuran tetap:
        // String rowsStrings[] = new String[] { "1",
        // "1234",
        // "1234567",
        // "123456789" };
        // String column1Format = "%-3.3s"; // fixed size 3 characters, left aligned
        // String column2Format = "%-8.8s"; // fixed size 8 characters, left aligned
        // String column3Format = "%6.6s"; // fixed size 6 characters, right aligned
        // String formatInfo = column1Format + " " + column2Format + " " +
        // column3Format;
        // for (int i = 0; i < rowsStrings.length; i++) {
        // System.out.format(formatInfo, rowsStrings[i], rowsStrings[i],
        // rowsStrings[i]);
        // System.out.println();
        // }
        /*
         * output:
         * 1 1 1
         * 123 1234 1234
         * 123 1234567 123456
         * 123 12345678 123456
         */
        // ----------
        // Contoh format string
        /*
         * %s: hanya string tanpa format
         * %5s: memformat string dengan minimal 5 karakter(minimum); jika stringnya
         * lebih pendek
         * maka akan diisi menjadi 5 karakter dan rata kanan
         * %-5s: memformat string dengan minimal 5 karakter; jika stringnya lebih pendek
         * maka akan diisi menjadi 5 karakter dan rata kiri
         * %5.10s: memformat string dengan minimal 5 karakter dan maksimal 10 karakter;
         * jika stringnya lebih pendek dari 5 akan diisi menjadi 5 karakter dan rata
         * kanan; jika stringnya lebih panjang dari 10 maka akan menjadi
         * terpotong menjadi 10 karakter dan rata kanan
         * %-5.5s: memformat string dengan ukuran tetap 5 karakter (minimum dan maksimum
         * sama); jika string lebih pendek dari 5 maka akan diisi menjadi 5 karakter dan
         * rata kiri; jika stringnya lebih panjang dari 5 maka akan menjadi
         * dipotong menjadi 5 karakter dan rata kiri
         */
    }
}
