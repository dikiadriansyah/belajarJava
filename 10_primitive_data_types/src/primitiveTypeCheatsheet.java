public class primitiveTypeCheatsheet {
    // Tabel yang menunjukkan kisaran ukuran dan nilai dari semua tipe primitif

    // data | type numeric representation range of values
    // boolean | n/a | false and true false
    // byte | 8-bit signed | -27to27- 1 -128 to +127
    // short | 16-bit signed | -215 to 215 - 1 0
    // -32,768 to +32,767
    // int | 32-bit signed | -231 to 231 - 1 0
    // -2,147,483,648 to +2,147,483,647
    // long | 64-bit signed | -263 to 263 - 1 0L
    // -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
    // float | 32-bit floating point | 1.401298464e-45 to 3.402823466e+38 (positive
    // or negative) 0.0F
    // double | 64-bit floating point | 4.94065645841246544e-324d to
    // 1.79769313486231570e+308d (positive or negative) 0.0D
    // char | 16-bit unsigned | 0 to 216 - 1, 0 to 65,535

    // catatan
    // 1. The Java Language Specification mandates that signed integral types (byte
    // through long) use binary twoscomplement representation, and the floating
    // point types use standard IEE 754 binary floating point representations. /
    // Mandat Spesifikasi Bahasa java bahwa tipe integral bertanda (byte hingga
    // panjang) menggunakan representasi biner twocomplement, dan tipe floating
    // point menggunakan representasi floating point biner standar IEE 754.
    // 2. Java 8 and later provide methods to perform unsigned arithmetic operations
    // on int and long. While these methods allow a program to treat values of the
    // respective types as unsigned, the types remain signed types. / Java 8 dan
    // yang lebih baru menyediakan metode untuk melakukan operasi aritmatika tak
    // bertanda pada int dan long. Sementara ini metode memungkinkan program untuk
    // memperlakukan nilai dari masing-masing tipe sebagai unsigned, tipe tetap tipe
    // yang ditandatangani.
    // 3. The smallest floating point shown above are subnormal; i.e. they have less
    // precision than a normal value. The smallest normal numbers are
    // 1.175494351e−38 and 2.2250738585072014e−308 / Titik apung terkecil yang
    // ditunjukkan di atas adalah subnormal; yaitu mereka memiliki presisi kurang
    // dari nilai normal. Bilangan normal terkecil adalah 1,175494351e−38 dan
    // 2,2250738585072014e−308
    // 4. A char conventionally represents a Unicode / UTF-16 code unit. / Char
    // secara konvensional mewakili unit kode Unicode / UTF-16.
    // 5. Although a boolean contains just one bit of information, its size in
    // memory varies depending on the Java Virtual Machine implementation (see
    // boolean type). / Meskipun boolean hanya berisi satu bit informasi, ukurannya
    // di memori bervariasi tergantung pada Java Implementasi Mesin Virtual (lihat
    // tipe boolean).

}
