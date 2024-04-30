package com.example.foo;

public class inline_code_documentation {

    // Inline Code Documentation / Dokumentasi Kode Sebaris

    // Terlepas dari kode dokumentasi Javadoc dapat didokumentasikan inline.

    // Komentar baris tunggal dimulai dengan // dan dapat ditempatkan setelah
    // pernyataan pada baris yang sama, tetapi tidak sebelumnya.

    // Komentar Multi-Baris didefinisikan antara /* dan */. Mereka dapat menjangkau
    // beberapa baris dan bahkan mungkin ditempatkan di antara pernyataan

    public void method() {
        // single line comment
        someMethodCall(); // single line comment after statement
    }

    public void method(Object object) {
        /*
         * multi
         * line
         * comment
         */
        object/* inner-line-comment */.method();
    }

    // JavaDocs adalah bentuk khusus dari komentar multi-baris, dimulai dengan /**.

    // Karena terlalu banyak komentar sebaris dapat menurunkan keterbacaan kode,
    // mereka harus jarang digunakan jika kode tidak cukup jelas atau keputusan
    // desain tidak jelas.
    // Kasus penggunaan tambahan untuk komentar satu baris adalah penggunaan TAG,
    // yang merupakan kata kunci pendek yang digerakkan oleh konvensi.
    // Beberapa lingkungan pengembangan mengenali konvensi tertentu untuk komentar
    // tunggal semacam itu. Contoh umum adalah
    // TODO
    // FIXME

    // Atau terbitkan referensi, yaitu untuk Jira
    // PRJ-1234
}
