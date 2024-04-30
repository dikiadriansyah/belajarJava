public class Substrings {
    public static void main(String[] args) {
        // String perkenalan = "Selamat Pagi Teman Semua";
        // String res = perkenalan.substring(8);
        // System.out.println(res);
        // output: Pagi Teman Semua

        // String perbandinganString = perkenalan.substring(8, 12);
        // System.out.println(perbandinganString);
        // output: Pagi

        // String perbandinganString2 = perkenalan.substring(8,
        // perbandinganString.length() - 3);
        // System.out.println(perbandinganString2);// perbandinganString akan menahan
        // string mulai dari karakter 8 yg
        // diakhiri. tepat sebelum panjang perbandingan String keluar dari 3
        // ("adalah ujian").
        // output: String index out of range: -7
        // karena dari perkenalan.substring() menghasilkan (8, 1), kecuali (8, 13) baru
        // berhasil.

        // Substring juga dapat diterapkan untuk memotong dan add/replace
        // karakter ke dalam String aslinya. Misalnya, Anda menghadapi chinese date yang
        // berisi karakter Cina tetapi Anda ingin menyimpannya sebagai date string
        // format yang baik.

        String dateString = "2015\u5E7411\u670817\u65E5";
        String result = dateString.substring(0, 4) + "-" + dateString.substring(5, 7) + "-"
                + dateString.substring(8, 10);
        System.out.println(result);
        // 2015-11-17

        // Metode substring mengekstrak sepotong String. Saat diberikan satu parameter,
        // parameternya adalah start dan potongan memanjang hingga akhir String. Ketika
        // diberikan dua parameter, parameter pertama adalah awal karakter dan parameter
        // kedua adalah indeks karakter tepat setelah akhir (karakter pada indeks adalah
        // tidak termasuk). Cara mudah untuk memeriksa adalah pengurangan parameter
        // pertama dari yang kedua harus menghasilkan panjang string yang diharapkan.

        // versi < java se 7
        // Dalam versi JDK <7u6, metode substring memberi contoh sebuah String yang
        // berbagi karakter pendukung yang char[] dengan String asli dan menyetel bidang
        // offset dan hitungan internal ke awal dan panjang hasil. Pembagian seperti itu
        // mungkin menyebabkan kebocoran memori, yang dapat dicegah dengan memanggil new
        // String(s.substring(...)) untuk memaksa pembuatan salinan,
        // setelah itu char[] dapat menjadi sampah yang dikumpulkan.

        // Version ≥ Java SE 7
        // Dari JDK 7u6 metode substring selalu menyalin seluruh array char[] yang
        // mendasarinya, menjadikan kompleksitas linier dibandingkan dengan konstanta
        // sebelumnya tetapi menjamin tidak adanya kebocoran memori pada saat yang
        // bersamaan.
    }
}
