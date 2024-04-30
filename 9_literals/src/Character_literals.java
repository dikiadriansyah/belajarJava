public class Character_literals {

    public static void main(String[] args) {
        // Literal karakter menyediakan cara yang paling nyaman untuk mengekspresikan
        // nilai char dalam kode sumber Java. character literal terdiri dari:
        // 1. pembuka single-quote(')character
        // 2. Representasi dari sebuah karakter. representasi ini tidak boleh berupa
        // karakter kutipan tunggal(single-quote) atau pemutus baris(line-break), tapi
        // itu bisa menjadi urutan pelarian(escape sequence) yg diperkenalkan oleh
        // karakter garis miring terbalik(\); lihat escape sequences dalam literal.
        // 3.penutup single-quote(') character.

        // contoh:
        char a = 'a';
        String pertanyaan = "apa yang dirasakan", jawaban = "baik dokter";
        char doubleQuote = '"';
        char singleQuote = '\'';

        System.out.println(a);
        // jawaban:
        // a

        // jeda baris(line-break) dalam literal karakter adalah kesalahan kompilasi:

        // char newLine = '
        // Compilation error in previous line
        char newLine = '\n';
        System.out.println(pertanyaan + newLine + jawaban);
        // jawaban:
        // apa yang dirasakan
        // baik dokter

        // penjelasan:
        // membuat variabel pertanyaan dan jawaban yg memiliki tipe data string dengan
        // value apa yang dirasakan,
        // selanjutnya tampilkan dengan menulis System.out.println(pertanyaan +
        // newLine + jawaban) sehingga output berupa apa yang dirasakan

    }
}
