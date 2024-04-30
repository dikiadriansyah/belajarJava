public class Constant_expressions {
    // Constant Expressions/Ekspresi Konstan

    /*
     * Ekspresi konstan adalah ekspresi yang menghasilkan tipe primitif atau String,
     * dan nilainya dapat dievaluasi pada waktu kompilasi menjadi literal. Ekspresi
     * harus dievaluasi tanpa memunculkan pengecualian, dan harus terdiri dari hanya
     * yang berikut ini:
     * 
     * Primitive and String literals.
     * Type casts to primitive types or String.
     * The following unary operators: +, -, ~ and !.
     * The following binary operators: *, /, %, +, -, <<, >>, >>>, <, <=, >, >=, ==,
     * !=, &, ^, |, && and ||.
     * The ternary conditional operator ? :.
     * Parenthesized constant expressions.
     * Nama sederhana yang mengacu pada variabel konstan. (Variabel konstan adalah
     * variabel yang dinyatakan sebagai final dimana
     * ekspresi penginisialisasi itu sendiri merupakan ekspresi konstan.)
     * Nama yang memenuhi syarat dalam bentuk <TypeName> . <Identifier> yang mengacu
     * pada variabel konstan.
     */

    /*
     * Perhatikan bahwa daftar di atas tidak termasuk ++ dan --, operator
     * penugasan(assignment operators),
     * kelas dan instanceof( class and instanceof), pemanggilan metode dan
     * referensi ke variabel atau bidang umum.
     * 
     * Ekspresi konstan bertipe String menghasilkan String "interned", dan operasi
     * floating point dalam ekspresi konstan dievaluasi dengan semantik ketat FP.
     * 
     */

    // Uses for Constant Expressions/Kegunaan untuk Ekspresi Konstan

    /*
     * Ekspresi konstan dapat digunakan (hampir) di mana pun ekspresi normal dapat
     * digunakan. Namun, hal-hal tersebut mempunyai arti khusus dalam konteks
     * berikut.
     * 
     * Ekspresi konstan diperlukan untuk label kasus dalam pernyataan switch.
     * Misalnya:
     * 
     * switch (someValue) {
     * case 1 + 1: // OK
     * case Math.min(2, 3): // Error - not a constant expression
     * doSomething();
     * }
     */

    /*
     * Jika ekspresi di sisi kanan tugas adalah ekspresi konstan, maka tugas
     * tersebut dapat melakukan konversi penyempitan primitif. Hal ini diperbolehkan
     * asalkan nilai ekspresi konstannya adalah
     * dalam kisaran tipe di sisi kiri. (Lihat JLS 5.1.3 dan 5.2) Misalnya:
     * byte b1 = 1 + 1; // OK - primitive narrowing conversion.
     * byte b2 = 127 + 1; // Error - out of range
     * byte b3 = b1 + 1; // Error - not a constant expession
     * byte b4 = (byte) (b1 + 1); // OK
     */

    /*
     * Ketika ekspresi konstan digunakan sebagai kondisi dalam do, while, atau for,
     * maka hal tersebut mempengaruhi analisis keterbacaan.
     * Misalnya:
     * while (false) {
     * doSomething(); // Error - statenent not reachable
     * }
     * boolean flag = false;
     * while (flag) {
     * doSomething(); // OK
     * }
     */

    /*
     * (Perlu diperhatikan bahwa hal ini tidak berlaku pada pernyataan if. Kompiler
     * Java memperbolehkan blok pernyataan if menjadi tidak dapat dijangkau. Ini
     * adalah analogi Java dari kompilasi bersyarat dalam C dan C++.)
     * 
     * Terakhir, bidang static final di kelas atau antarmuka dengan inisialisasi
     * ekspresi konstan diinisialisasi dengan penuh semangat. Dengan demikian,
     * dijamin bahwa konstanta ini akan diamati dalam keadaan diinisialisasi, bahkan
     * ketika terdapat siklus dalam grafik ketergantungan inisialisasi kelas.
     */

    // Untuk informasi lebih lanjut, lihat JLS 15.28. Ekspresi Konstan.

    public static void main(String[] args) throws Exception {
        // int someValue = 3;

        // switch (someValue) {
        // case 1 + 1: // OK
        // System.out.println("Case 1: someValue is 2");
        // break;
        // case Math.min(2, 3): // Error - not a constant expression
        // System.out.println("Case 2: someValue is the minimum of 2 and 3");
        // break;
        // default:
        // System.out.println("Default case");
        // }
        // output:
        // case expressions must be constant expressions

    }
}
