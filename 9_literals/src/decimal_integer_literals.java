public class decimal_integer_literals {
    public static void main(String args[]) {
        // Integer literals memberikan nilai yg dapat digunakan dimana anda memerlukan
        // instance byte, short, int, long, atau char.
        // (contoh ini berfokus pada bentuk desimal sederhana. contoh lain menjelaskan
        // bagaimana literal dalam octal, hexadecimal dan binary dan penggunaan garis
        // bawah untuk meningkatkan keterbacaan)

        // Ordinary integer literals
        // Bentuk paling sederhana dan paling umum dari literal bilangan bulat adalah
        // decimal integer literal. Misalnya:
        // 0 the decimal number zero (type 'int')
        // 1 the decimal number one (type 'int')
        // 42 the decimal number forty two (type 'int')

        // anda harus berhati-hati dengan nol di depan. nol di depan menyebabkan integer
        // literal ditafsirkan sebagai oktal bukan desimal
        // 077 This literal actually means 7 x 8 + 7 ... or 63 decimal!

        // integer literal tidak bertanda tangan. jika anda melihat sesuatu seperti -10
        // atau +10 ini sebenarnya adalah ekspresi menggunakan unary - dan unary +
        // operator.

        // kisaran integer literal dari bentuk ini memiliki intrinsic type of int, dan
        // harus berada dalam kisaran nol hingga 231 atau 2,147,483,648

        // perhatikan bahwa 231 lebih besar 1 dari integer. MAX_VALUE. Literal dari 0
        // hingga 2147483647 dapat digunakan dimana saja, tetapi merupakan kesalahan
        // kompilasi untuk menggunakan 2147483648 tanpa unary - operator. (dengan kata
        // lain, itu dicadangkan untuk mengekspresikan nilai integer. MIN_VALUE)

        int max = 2147483647;
        int min = -2147483648;
        // int tooBig = 2147483648; // Error

        // Long integer literals
        // Literals bertipe long diekspresikan dengan menambahkan L suffix. misalnya:
        // 0L // the decimal number zero (type 'long')
        // 1L // the decimal number zero (type 'long')
        // 2147483648L // the value of Integer.MAX_VALUE + 1
        // long big = 2147483648; // Error
        long big2 = 2147483648L; // OK

        // perhatikan bahwa perbedaan antara int dan long literal signifikan di tempat
        // lain. misalnya:
        int i = 2147483647;
        long l = i + 1; // menghasilkan nilai negatif karena operasi dilakukan menggunakan aritmatika 32
                        // bit, dan penambahannya meluap.
        System.out.println(l);
        // hasil:
        // -2147483648

        // penjelasan:
        // membuat variabel i dengan tipe data int yg memiliki value 2147483647
        // selanjutnya membuat variabel bernama l dengan tipe data long yg memiliki
        // value i + 1,
        // selanjutnya tampilkan menggunakan System.out.println()

        long l2 = i + 1L; // Menghasilkan nilai yang benar (secara intuitif).
        System.out.println(l2);
        // hasil:
        // 2147483648

    }
}
