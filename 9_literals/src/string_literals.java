public class string_literals {
    // String literals / String literal

    public static void main(String[] args) {
        // String literal menyediakan cara yang paling nyaman untuk mewakili nilai
        // string dalam kode sumber java. string literal terdiri dari:
        // - An opening double-quote (") character. / Karakter kutip ganda ("") pembuka.

        // - Zero or more other characters that are neither a double-quote or a
        // line-break character. (A backslash (\) character alters the meaning of
        // subsequent characters; see Escape sequences in literals.) / Nol atau lebih
        // karakter lain yang bukan karakter petik ganda atau pemecah baris. (Karakter
        // garis miring terbalik (\) mengubah arti dari karakter berikutnya; lihat
        // urutan Escape dalam literal.)

        // - A closing double-quote character. / Karakter kutip ganda penutup

        // contoh:
        // - "Hello world" // A literal denoting an 11 character String (Literal yang
        // menunjukkan String 11 karakter)

        // - "" // A literal denoting an empty (zero length) String / Literal yang
        // menunjukkan String kosong (panjang nol).

        // - "\"" // A literal denoting a String consisting of one
        // double quote character / Literal yang menunjukkan sebuah String yang terdiri
        // dari satu karakter kutip ganda

        // - "1\t2\t3\n" // Another literal with escape sequences / Literal lain dengan
        // urutan pelarian

        // Perhatikan bahwa literal string tunggal mungkin tidak menjangkau beberapa
        // baris kode sumber. Ini adalah kesalahan kompilasi untuk pemutusan garis (atau
        // akhir dari file sumber) terjadi sebelum kutipan ganda penutupan literal.
        // contoh:
        // "Jello world // Compilation error (at the end of the line!)

        // Long strings / Panjang String

        // jika anda memerlukan string yang terallu panjang untuk dimuat dalam 1 baris,
        // cara konvensional untuk mengekspresikannya adalah dengan membaginya menjadi
        // beberapa literal dan menggunakan operator penggabungan(+) untuk menggabungkan
        // potongan-potongan tersebut. contoh:
        String praktekString = "Perkenalkan saya" + " Dhiki Adriansyah" + " Lahir di Jakarta";
        System.out.println(praktekString);
        // hasil:
        // Perkenalkan saya Dhiki Adriansyah Lahir di Jakarta

        // penjelasan:
        // awalnya membuat <tipeData> namaVariabel yang memiliki nilai "" + "" + "",
        // selanjutnya tampilkan menggunakan System.out.println();
        // sehingga hasil Perkenalkan saya Dhiki Adriansyah Lahir di Jakarta

        // Ekspresi seperti di atas yang terdiri dari string literal dan + memenuhi
        // persyaratan untuk menjadi ekspresi konstan(Constant Expression).
        // itu berarti bahwa ekspresi akan dievaluasi oleh compiler dan
        // direpresentasikan saat runtime oleh satu object string.

        // Interning of string literals / Magang literal string

        // ketika file kelas yang berisi literal string dimuat oleh JVM, objek String
        // terkait interned oleh sistem runtime. ini berarti bahwa literal string yang
        // digunakan di banyak kelas tidak menempati lebih banyak ruang daripada jika
        // digunakan dalam 1 kelas.

        // untuk informasi lebih lanjut tentang interning dan kumpulan string (string
        // pool), lihat contoh kumpulan string dan penyimpanan heap di topik strings
    }
}
