public class hexadecimal_octal_and_binary {

    // Hexadecimal, Octal and Binary literals / Hexadecimal, oktal dan literal biner

    // Angka heksadesimal adalah nilai dalam basis-16. Ada 16 digit, 0-9 dan huruf
    // A-F (huruf tidak masalah). A-F mewakili 10-15

    // Angka oktal adalah nilai dalam basis-8, dan menggunakan angka 0-7

    // Bilangan biner adalah nilai dalam basis-2, dan menggunakan angka 0 dan 1.

    public static void main(String[] args) {
        // Semua angka ini menghasilkan nilai yang sama, 110:

        int desimal = 110; // no prefix --> decimal literal
        int biner = 0b1101110; // '0b' prefix --> biner literal
        int octal = 0156; // '0' prefix --> octal literal
        int hexadecimal = 0x6E; // '0x' prefix --> hexadecimal literal
        System.out.println(hexadecimal);
        // hasil:
        // 110

        // penjelasan:
        // awalnya membuat public class hexadecimal_octal_and_binary{} yg berisi public
        // static void main(String[] args){},
        // selanjutnya membuat <tipeData> namaVariabel yg berisi nilai 0x6E,
        // selanjutnya tampilkan menggunakan System.out.println();
        // sehingga hasil 110 karena diubah(convert) dari 0x6E ke 110 desimal

        // Perhatikan bahwa sintaks literal biner diperkenalkan di Java 7

        // octal literal dapat mudah menjadi jebakan untuk kesalah semantik (semantic
        // errors). jika anda menentukan awalan '0' ke literal desimal anda, anda akan
        // mendapatkan nilai yang salah:
        int a = 0100;
        System.out.println(a);
        // hasil:
        // 64
        // penjelasan:
        // awalnya membuat public class hexadecimal_octal_and_binary{} yg berisi public
        // static void main(String[] args){},
        // selanjutnya membuat <tipeData> namaVariabel yg berisi nilai 0100,
        // selanjutnya tampilkan menggunakan System.out.println();
        // sehingga hasil 64 karena diubah(convert) dari 0100 octal ke 64 decimal
    }
}
