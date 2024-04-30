public class The_bitwise_and_logical_operators {
    // The Bitwise and Logical Operators (~, &, |, ^) / Operator Bitwise dan Logis
    // (~, &, |, ^)

    /*
     * Bahasa Java menyediakan 4 operator yang melakukan operasi bitwise atau logika
     * pada operan integer atau boolean.
     * 
     * Operator komplemen (~) adalah operator unary yang melakukan inversi bitwise
     * atau logis dari bit-bit
     * satu operan; lihat JLS 15.15.5..
     * 
     * Operator AND (&) adalah operator biner yang melakukan "dan" bitwise atau
     * logis dari dua operan; lihat JLS
     * 15.22.2..
     * 
     * Operator OR (|) adalah operator biner yang melakukan "inklusif atau" bitwise
     * atau logis dari dua operan; melihat
     * JLS 15.22.2..
     * 
     * Operator XOR (^) adalah operator biner yang melakukan "eksklusif atau"
     * bitwise atau logis dari dua operan;
     * lihat JLS 15.22.2..
     */

    /*
     * Operasi logis yang dilakukan oleh operator ini ketika operannya boolean dapat
     * diringkas sebagai berikut:
     * A | B | ~A | A & B | A | B A ^ B
     * 0 | 0 | 1 | 0 | 0 | 0
     * 0 | 1 | 1 | 0 | 1 | 1
     * 1 | 0 | 0 | 0 | 1 | 1
     * 1 | 1 | 0 | 1 | 1 | 0
     */

    /*
     * Perhatikan bahwa untuk operan bilangan bulat, tabel di atas menjelaskan apa
     * yang terjadi pada masing-masing bit. Operator sebenarnya beroperasi pada
     * semua 32 atau 64 bit operan atau operan secara paralel
     */

    // Tipe operan dan tipe hasil.

    /*
     * Konversi aritmatika biasa berlaku jika operannya integers. Kasus
     * penggunaan umum untuk operator bitwise.
     * 
     * Operator ~ digunakan untuk membalikkan nilai boolean, atau mengubah semua bit
     * dalam operan integer.
     * 
     * Operator & digunakan untuk "menutupi" beberapa bit dalam operan bilangan
     * bulat. Misalnya:
     */

    public static void main(String[] args) {
        int word = 0b00101010;
        int mask = 0b00000011; // Mask for masking out all but the bottom
        // two bits of a word

        int lowBits = word & mask; // -> 0b00000010
        int highBits = word & ~mask; // -> 0b00101000

        // System.out.println(lowBits); // 2
        // System.out.println(highBits); // 40

        /*
         * operator | digunakan untuk menggabungkan nilai kebenaran dari dua operan.
         * Misalnya:
         */

        int word2 = 0b01011111;

        // Combine the bottom 2 bits of word1 with the top 30 bits of word2
        int combined = (word & mask) | (word2 & ~mask); // -> 0b01011110s
        // System.out.println(combined); // 94

        /*
         * Operator ^ digunakan untuk mengalihkan atau "membalik" bit:
         */
        int word3 = 0b00101010;
        int word4 = word3 ^ mask; // -> 0b00101001
        System.out.println(word4); // 41

        // Untuk contoh lebih lanjut penggunaan operator bitwise, lihat Manipulasi Bit

    }
}
