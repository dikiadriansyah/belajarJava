public class negativeValueRepresentation {
    public static void main(String[] args) {
        // Java dan sebagian besar bahasa lain menyimpan bilangan integral negatif dalam
        // representasi yang disebut notasi komplemen 2.

        // Untuk representasi biner unik dari tipe data menggunakan n bit, nilai
        // dikodekan seperti ini:

        // n-1 bits yang paling tidak signifikan menyimpan bilangan integral positif x
        // dalam representasi integral. Nilai paling signifikan menyimpan sedikit nilai
        // vith s. Nilai yang diwakili oleh bit-bit tersebut adalah
        // x-s * 2n-1

        // yaitu jika bit paling signifikan adalah 1, maka nilai yg hanya 1 lebih besar
        // dari angka yang dapat anda wakili dengan bit lainnya(2n-2 + 2n-3 + ... + 21 +
        // 20 = 2n-1-1) dikurangi memungkinkan representasi biner yg unik untuk
        // masing-masing nilai dari - 2n-1 (s = 1; x=0) hingga 2n-1-1 (s=0; x = 2n-1-1).

        // Ini juga memiliki efek samping yang bagus, bahwa Anda dapat menambahkan
        // representasi biner seolah-olah itu adalah bilangan biner positif

        // v1 = x1 - s1 * 2n-1
        // v2 = x2 - s2 * 2n-1

        // s1 | s2 | x1 + x2 overflow | additional result
        // 0 | 0 | No | x1 + x2 = v1 + v2
        // 0 | 0 | Yes | too large to be represented with data type (overflow)
        // 0 | 1 | No | x1 + x2 - 2n-1 = x1 + x2 - s2 * 2n-1 = v1 + v2
        // 0 | 1 | Yes | (x1 + x2) mod 2n-1 = x1 + x2 - 2n-1 = v1 + v2
        // 1 | 0 | * | see above (swap summands)
        // 1 | 1 | No | too small to be represented with data type (x1 + x2 - 2n < -2n-1
        // ; underflow)
        // 1 | 1 | Yes | (x1 + x2) mod 2n-1 - 2n-1 = (x1 + x2 - 2n-1) - 2n-1 = (x1 - s1
        // * 2n-1) + (x2 - s2 * 2n-1) = v1 + v2

        // Perhatikan bahwa fakta ini membuat pencarian representasi biner dari invers
        // penjumlahan (yaitu nilai negatif) menjadi mudah:

        // Perhatikan bahwa menambahkan pelengkap bitwise ke angka menghasilkan semua
        // bit menjadi 1. Sekarang tambahkan 1 untuk membuat nilai melimpah dan Anda
        // mendapatkan elemen netral 0 (semua bit 0).

        // Jadi nilai negatif dari angka i dapat dihitung menggunakan (mengabaikan
        // kemungkinan promosi ke int di sini)
        // (~i) + 1

        // Contoh: mengambil nilai negatif 0 (byte)

        // Hasil negasi 0, adalah 11111111. Menambahkan 1 memberikan nilai 100000000 (9
        // bit). Karena satu byte hanya dapat menyimpan 8 bit, nilai paling kiri
        // terpotong, dan hasilnya adalah 00000000

        // original | process | result
        // 0 (00000000) | Negate | -0 (11111111)
        // 11111111 | Add 1 to binary | 100000000
        // 100000000 | Truncate to 8 bits | 00000000 (-0 equals 0)
    }
}
