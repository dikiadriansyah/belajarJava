public class The_equality_operators {
    // The Equality Operators (==, !=) / Operator Kesetaraan (==, !=)

    /*
     * Operator == dan != adalah operator biner yang bernilai benar atau salah
     * bergantung pada apakah operannya sama. Operator == memberikan nilai true jika
     * operannya sama dan false jika sebaliknya. Operator != memberikan false jika
     * operannya sama dan true sebaliknya.
     * 
     * Operator ini dapat menggunakan operan dengan tipe primitif dan referensi,
     * namun perilakunya sangat berbeda. Menurut JLS, sebenarnya ada tiga set
     * berbeda dari operator ini:
     * 1. The Boolean == and != operators.
     * 2. The Numeric == and != operators
     * 3. The Reference == and != operators.
     */

    // Namun, dalam semua kasus, tipe hasil dari operator == dan != adalah boolean.

    // The Numeric == and != operators(Operator Numerik == dan !=)

    /*
     * Ketika salah satu (atau keduanya) operan dari operator == atau != adalah tipe
     * numerik primitif (byte, short, char, int, long, float atau double),
     * operatornya adalah perbandingan numerik.
     * Operan kedua harus berupa tipe numerik primitif, atau tipe numerik kotak.
     */

    // Perilaku operator numerik lainnya adalah sebagai berikut:

    /*
     * 1. Jika salah satu operan bertipe kotak, maka operan tersebut tidak
     * dikotakkan.
     * 2. Jika salah satu operan sekarang berupa byte, short, atau char, maka akan
     * dipromosikan menjadi int.
     * 3. Jika tipe operannya tidak sama, maka operan dengan tipe "lebih kecil" akan
     * dipromosikan ke tipe "lebih besar".
     * 4. Perbandingannya kemudian dilakukan sebagai berikut:
     * a. Jika operan yang dipromosikan adalah int atau long maka nilainya diuji
     * untuk melihat apakah keduanya identik.
     * b. Jika operan yang dipromosikan berbentuk float atau double maka:
     * 4a. 2 versi nol (+0,0 dan -0,0) diperlakukan sama
     * 4b. nilai NaN diperlakukan tidak sama dengan apa pun, dan
     * 4c. nilai lainnya sama jika representasi IEEE 754nya identik.
     */

    // Catatan: Anda harus berhati-hati saat menggunakan == dan != untuk
    // membandingkan nilai floating point.

    // The Boolean == and != operators (Operator Boolean == dan !=)
    /*
     * Jika kedua operan adalah boolean, atau yang satu boolean dan yang lainnya
     * Boolean, operator ini adalah operator Boolean == dan !=. Perilakunya adalah
     * sebagai berikut:
     * 1. Jika salah satu operannya adalah Boolean, maka operan tersebut tidak
     * dikotak-kotakkan.
     * 2. Operan yang tidak dikotakkan diuji dan hasil boolean dihitung berdasarkan
     * tabel kebenaran berikut
     */

    /*
     * A | B | A == B | A != B
     * false | false | true | false
     * false | true | false | true
     * true | false | false | true
     * true | true | true | false
     */

    /*
     * Ada dua "jebakan" yang membuatnya disarankan untuk menggunakan == dan !=
     * secara hemat dengan nilai kebenaran:
     * 1. Jika Anda menggunakan == atau != untuk membandingkan dua objek Boolean,
     * maka operator Referensi akan digunakan. Ini mungkin memberikan
     * hasil yang tidak terduga; lihat Kesalahan: menggunakan == untuk membandingkan
     * objek pembungkus primitif seperti Integer
     * 2. Operator == dapat dengan mudah salah ketik sebagai =. Untuk sebagian besar
     * tipe operan, kesalahan ini menyebabkan kesalahan kompilasi. Namun, untuk
     * operan boolean dan boolean kesalahan tersebut menyebabkan perilaku runtime
     * yang salah; lihat Kesalahan - Menggunakan '==' untuk menguji boolean
     */

    // The Reference == and != operators(Operator Referensi == dan !=)
    /*
     * Jika kedua operan adalah referensi objek, operator == dan != menguji apakah
     * kedua operan merujuk ke objek yang sama.
     * Ini sering kali bukan yang Anda inginkan. Untuk menguji apakah dua objek
     * memiliki nilai yang sama, metode .equals() harus digunakan
     * alih-alih.
     */

    public static void main(String[] args) {
        String s1 = "We are equal";
        String s2 = new String("We are equal");
        s1.equals(s2); // true

        // WARNING - don't use == or != with String values
        // s1 == s2; // false

        /*
         * Peringatan: using == and != to compare String values is incorrect in most
         * cases;
         * see
         * http://stackoverflow.com/documentation/java/4388/java-pitfalls/16290/using-to
         * -compare-strings . A similar problem applies to primitive wrapper types; see
         * http://stackoverflow.com/documentation/java/4388/java-pitfalls/8996/using-to-
         * compare-primitive-wrappers-objects-such-as-integer .
         * 
         */

        // About the NaN edge-cases
        // JLS 15.21.1 states the following:
        /*
         * Jika salah satu operan adalah NaN, maka hasil dari == salah tetapi hasil dari
         * != benar. Memang benar, tes x != x benar jika dan hanya jika nilai x adalah
         * NaN
         * 
         * Perilaku ini (bagi sebagian besar pemrogram) tidak terduga. Jika Anda menguji
         * apakah nilai NaN sama dengan nilai itu sendiri, jawabannya adalah
         * "Tidak, tidak!". Dengan kata lain, == tidak mencerminkan nilai NaN.
         * 
         * Namun, ini bukan "keanehan" Java, perilaku ini ditentukan dalam standar
         * floating-point IEEE 754, dan Anda akan melakukannya
         * menemukan bahwa ini diterapkan oleh sebagian besar bahasa pemrograman modern.
         * (Untuk informasi lebih lanjut, lihat
         * http://stackoverflow.com/a/1573715/139985 ... mencatat bahwa ini ditulis oleh
         * seseorang yang "di dalam ruangan ketika
         * keputusan telah dibuat"!)
         */

    }
}
