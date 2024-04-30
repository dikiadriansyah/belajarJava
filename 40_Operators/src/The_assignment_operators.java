public class The_assignment_operators {
    // The Assignment Operators (=, +=, -=, *=, /=, %=, <<=, >>= , >>>=, &=, |= and
    // ^=)

    /*
     * Operan sebelah kiri untuk operator ini harus berupa variabel non-final atau
     * elemen array. Operan sebelah kanan harus sesuai tugas dengan operan sebelah
     * kiri. Artinya, tipe operan harus sama, atau tipe operan kanan harus dapat
     * dikonversi ke tipe operan kiri dengan kombinasi kotak,
     * membuka kotak atau melebar. (Untuk detail selengkapnya lihat JLS 5.2.)
     */

    // Arti sebenarnya dari operator "operasi dan penetapan" ditentukan oleh JLS
    // 15.26.2 sebagai:
    /*
     * Ekspresi penugasan majemuk dalam bentuk E1 op= E2 setara dengan E1 = (T)
     * ((E1) op (E2)), dimana T adalah tipe E1, kecuali E1 dievaluasi hanya sekali
     */

    // Perhatikan bahwa ada type-cast implisit sebelum tugas akhir
    // 1. =
    // Operator penugasan sederhana: menugaskan nilai operan sebelah kanan ke operan
    // sebelah kiri
    // contoh: c = a + b will add the value of a + b to the value of c and assign it
    // to c

    // 2. +=
    /*
     * Operator "tambah dan tetapkan": menambahkan nilai operan sebelah kanan ke
     * nilai operan sebelah kiri dan
     * menugaskan hasilnya ke operan sebelah kiri. Jika operan sebelah kiri bertipe
     * String, maka ini adalah operator "gabungan dan tetapkan".
     * 
     * Contoh: c += a is roughly the same as c = c + a
     * 
     */

    // 3. -=
    /*
     * Operator "kurangi dan tetapkan": mengurangi nilai operan kanan dari nilai
     * operan sebelah kiri dan menetapkan hasilnya ke operan sebelah kiri.
     * Contoh: c -= a is roughly the same as c = c - a
     * 
     */

    // 4. *=
    /*
     * Operator "kalikan dan tetapkan": mengalikan nilai operan sebelah kanan dengan
     * nilai operan sebelah kiri dan menetapkan hasilnya ke operan sebelah kiri. .
     * Contoh: c *= a is roughly the same as c = c * a
     */

    // 5. / =
    /*
     * Operator "bagi dan tetapkan": membagi nilai operan sebelah kanan dengan nilai
     * operan sebelah kiri dan tetapkan hasilnya ke operan sebelah kiri.
     * 
     * contoh: c /*= a is roughly the same as c = c / a
     */

    // 6. %=
    /*
     * Operator "modulus dan tetapkan": menghitung modulus nilai operan sebelah
     * kanan dengan nilai operan sebelah kiri dan menetapkan hasilnya ke operan
     * sebelah kiri
     */
    // Contoh: c %*= a is roughly the same as c = c % a

    // 7. <<=
    // Operator "shift kiri dan tetapkan".
    // Contoh: c <<= 2 is roughly the same as c = c << 2

    // 8. >>=
    // Operator "geser dan tetapkan aritmatika ke kanan".
    // Contoh: c >>= 2 is roughly the same as c = c >> 2

    // 9. >>>=
    // Operator "pergeseran dan penetapan ke kanan yang logis".
    // Contoh: c >>>= 2 is roughly the same as c = c >>> 2

    // 10. &=
    // Operator "bitwise dan dan tetapkan".
    // Contoh: c &= 2 is roughly the same as c = c & 2

    // 11. |=
    // Operator "bitwise atau dan tetapkan".
    // Contoh: c |= 2 is roughly the same as c = c | 2

    // 12. ^=
    // Operator "bitwise eksklusif atau dan tetapkan".
    // Contoh: c ^= 2 is roughly the same as c = c ^ 2

    public static void main(String[] args) {
    }
}
