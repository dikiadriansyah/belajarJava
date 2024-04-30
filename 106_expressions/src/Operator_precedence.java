public class Operator_precedence {
    // Operator Precedence/Prioritas Operator

    /*
     * Ketika sebuah ekspresi berisi beberapa operator, ekspresi tersebut berpotensi
     * dibaca dengan cara yang berbeda. Misalnya,
     * ekspresi matematika 1 + 2 x 3 dapat dibaca dengan dua cara:
     * 1. Tambahkan 1 dan 2 dan kalikan hasilnya dengan 3. Hasilnya adalah 9. Jika
     * kita menambahkan tanda kurung, hasilnya akan terlihat
     * seperti ( 1 + 2 ) x 3.
     * 2. Tambahkan 1 pada hasil perkalian 2 dan 3. Hasilnya adalah 7. Jika kita
     * menambahkan tanda kurung, akan terlihat
     * seperti 1 + ( 2 x 3 ).
     */

    /*
     * Dalam matematika, konvensinya adalah membaca ekspresi dengan cara kedua.
     * Aturan umumnya adalah perkalian dan
     * pembagian dilakukan sebelum penjumlahan dan pengurangan. Ketika notasi
     * matematika yang lebih maju digunakan, baik itu
     * artinya "jelas dengan sendirinya" (bagi ahli matematika terlatih!), atau
     * tanda kurung ditambahkan untuk memperjelas. Dalam kedua kasus tersebut,
     * efektivitas notasi untuk menyampaikan makna bergantung pada kecerdasan dan
     * pengetahuan bersama para ahli matematika.
     * 
     * Java memiliki aturan jelas yang sama mengenai cara membaca ekspresi,
     * berdasarkan prioritas operator yang digunakan.
     * 
     * Secara umum, setiap operator dianggap memiliki nilai prioritas; lihat tabel
     * di bawah ini.
     */

    // contoh:
    // 1+2*3

    // Prioritas + lebih rendah dari prioritas *, sehingga hasil ekspresi adalah 7,
    // bukan 9.

    // Description | Operators / constructs (primary) | Precedence Associativity

    // Qualifier | name.name
    // Parentheses | (expr)
    // Instance creation | new
    // Field access | primary.name
    // Array access | primary[expr]
    // Method invocation | primary(expr, ...)
    // Method reference | primary::name
    //

    /*
     * 1 Prioritas ekspresi Lambda rumit, karena dapat juga terjadi setelah cast,
     * atau sebagai bagian ketiga dari operator ternary bersyarat.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
