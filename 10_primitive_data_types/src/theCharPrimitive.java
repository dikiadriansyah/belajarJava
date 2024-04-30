public class theCharPrimitive {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // The 8 primitive data types byte, short, int, long, char, boolean, float, and
        // double are the types that store most
        // raw numerical data in Java programs

        // Char dapat menyimpan satu karakter Unicode 16-bit. Literal karakter diapit
        // oleh tanda kutip tunggal(single quotes)

        char inisialHuruf = 'D';
        char inisialAngka = '1';
        char inisialAngka2 = 14;

        // Ini memiliki nilai minimum \u0000 (0 dalam representasi desimal, juga disebut
        // karakter nol) dan maksimum nilai \uffff (65,535).

        // Nilai default char adalah \u0000.

        char defaultChar; // defaultChar == \u0000

        // Untuk menentukan karakter ' nilai, urutan escape (karakter yang didahului
        // dengan garis miring terbalik) harus digunakan:
        // char singleQuote = '\'';
        // There are also other escape sequences / Ada juga urutan pelarian lainnya:

        char tab = '\t';
        char backspace = '\b';
        char newline = '\n';
        char carriageReturn = '\r';
        char formfeed = '\f'; // ♀
        char singleQuote = '\'';
        char doubleQuote = '\"'; // escaping redundant here; '"' would be the same; however still allowed
        char backslash = '\\';
        char unicodeChar = '\u2102'; // XXXX represents the Unicode-value of the character you want to display/ XXXX
                                     // mewakili nilai Unicode dari karakter yang ingin Anda tampilkan

        // Anda dapat mendeklarasikan char dari karakter Unicode apa pun.

        char heart = '\u2764';
        // System.out.println(Character.toString(heart));

        // Dimungkinkan juga untuk menambahkan ke char. misalnya untuk mengulangi setiap
        // huruf kecil, Anda dapat melakukan hal berikut:
        for (int i = 0; i <= 25; i++) {
            char letter = (char) ('a' + i);
            System.out.println(letter);
        }
        // hasil
        // a b c d e f g sampai z

    }
}
