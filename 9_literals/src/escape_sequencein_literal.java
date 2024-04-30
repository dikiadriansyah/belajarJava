public class escape_sequencein_literal {

    public static void main(String[] args) {

        // Escape sequences in literals / Escape sequence dalam literal

        // String dan character literal menyediakan mekanisme pelarian yang memungkinkan
        // kode karakter ekspres yang seharusnya tidak diizinkan dalam literal.
        // Urutan melarikan diri terdiri dari karakter backslash (\) diikuti oleh satu
        // atau lebih karakter lainnya. Urutan yang sama berlaku di kedua karakter dan
        // string literal.

        // Rangkaian escape sequence lengkapnya adalah sebagai berikut:
        // Escape sequence | Meaning
        // \\ Denotes an backslash (\) character
        // \' Denotes a single-quote (') character
        // \" Denotes a double-quote (") character
        // \n Denotes a line feed (LF) character
        // \r Denotes a carriage return (CR) character
        // \t Denotes a horizontal tab (HT) character
        // \f Denotes a form feed (FF) character
        // \b Denotes a backspace (BS) character
        // \<octal> Denotes a character code in the range 0 to 255

        // <octal> di atas terdiri dari satu, dua atau tiga digit oktal ('0' sampai '7')
        // yang mewakili angka antara 0 dan 255 (desimal).
        // Perhatikan bahwa garis miring terbalik yang diikuti oleh karakter lain adalah
        // urutan keluar yang tidak valid.

        // Perhatikan bahwa garis miring terbalik yang diikuti oleh karakter lain adalah
        // urutan keluar yang tidak valid. Urutan escape yang tidak valid adalah
        // diperlakukan sebagai kesalahan kompilasi oleh JLS.

        // contoh:
        // System.out.println("Selamat datang di \"DikCafe\". ");
        // hasil:
        // Selamat datang di "DikCafe".

        // contoh lain:
        System.out.println("Perkenalkan saya\t Dhiki Adriansyah");
        // hasil:
        // Perkenalkan saya Dhiki Adriansyah

        // contoh lain:
        System.out.println("Usia: 24 tahun\n tempat tinggal: jakarta");
        // hasil:
        // Usia: 24 tahun
        // tempat tinggal: jakarta

        // penjelasan:
        // awalnya membuat kelas dan main method,
        // selanjutnya membuat System.out.println(""); yg berisi escape squence \n,
        // sehingga hasil menampilkan kalimat 2 baris

        System.out.println("Alamat: Jl.Moh.kahfi2 \r kec.jagakarsa, Jakarta Selatan");
        // hasil:
        // kec.jagakarsa, jakarta selatan

        // referensi
        // JLS 3.10.6 escape sequence for character and string
        // literals(https://docs.oracle.com/javase/specs/jls/se8/html/jls-3.html#jls-3.10.6)

        // Unicode escapes / Unicode lolos
        // Selain urutan pelepasan string dan karakter yang dijelaskan di atas, Java
        // memiliki Unicode yang lebih umum mekanisme pelolosan, sebagaimana
        // didefinisikan dalam JLS 3.3. Unicode Escapes. Pelarian Unicode memiliki
        // sintaks berikut:
        // '\' 'u' <hex-digit> <hex-digit> <hex-digit> <hex-digit>

        // dimana <hex-digit> adalah salah satu dari f '0', '1', '2', '3', '4', '5',
        // '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C',
        // 'D', 'E', 'F'.

        // Pelarian Unicode dipetakan oleh kompiler Java ke sebuah karakter (tegasnya
        // unit kode Unicode 16-bit) dan dapat digunakan di mana saja dalam kode sumber
        // tempat karakter yang dipetakan valid. Hal ini umumnya digunakan dalam
        // karakter dan string literal saat Anda perlu merepresentasikan karakter
        // non-ASCII dalam literal.

        // Escaping in regexes / Melarikan diri di regex

        // TBD
    }
}
