public class Using_underscore_to_improve {
    // Using underscore to improve readability / Menggunakan garis bawah untuk
    // meningkatkan keterbacaan

    // Sejak Java 7 dimungkinkan untuk menggunakan satu atau lebih garis bawah (_)
    // untuk memisahkan kelompok digit dalam literal angka primitif untuk
    // meningkatkan keterbacaannya.

    // Misalnya, kedua deklarasi ini setara:

    public static void main(String[] args) {
        // versi Java SE 7
        int i1 = 123456;
        int i2 = 123_456;

        System.out.println(i1 == i2);
        // hasil:
        // true

        // Ini dapat diterapkan ke semua literal bilangan primitif seperti yang
        // ditunjukkan di bawah ini:

        byte color = 1_2_3;
        short yearsDhikiAdri = 1_999;
        int socialSecurityNumber = 999_99_9999;
        long creditCardNumber = 1234_5678_9012_3456L;
        float picFourDecimals = 3.14_15F;
        double piTenDecimals = 3.14_15_92_65_35;
        System.out.println(picFourDecimals);
        // hasil:
        // 123

        // Ini juga berfungsi menggunakan awalan untuk basis biner, oktal, dan
        // heksadesimal:
        short binary = 0b0_1_0_1;
        int octal = 07_7_7_7_7_7_7_7_0;
        long hexBytes = 0xFF_EC_DE_5E;
        System.out.println(binary);
        // hasil:
        // 5

        // penjelasan:
        // awalnya membuat <tipeData> namaVariabel yang memiliki nilai 0b0_1_0_1,
        // selanjutnya tampilkan menggunakan System.out.println();

        // Ada beberapa aturan tentang garis bawah yang melarang penempatannya di
        // tempat-tempat berikut:
        // - At the beginning or end of a number (e.g. _123 or 123_ are not valid) / Di
        // awal atau akhir angka (mis. _123 atau 123_ tidak valid)

        // - Adjacent to a decimal point in a floating point literal (e.g. 1._23 or
        // 1_.23 are not valid) / Berdekatan dengan titik desimal dalam literal titik
        // mengambang (mis. 1._23 atau 1_.23 tidak valid)

        // - Prior to an F or L suffix (e.g. 1.23_F or 9999999_L are not valid) /
        // Sebelum akhiran F atau L (mis. 1,23_F atau 9999999_L tidak valid)

        // - In positions where a string of digits is expected (e.g. 0_xFFFF is not
        // valid) / Di posisi di mana serangkaian digit diharapkan (mis. 0_xFFFF tidak
        // valid)

    }
}
