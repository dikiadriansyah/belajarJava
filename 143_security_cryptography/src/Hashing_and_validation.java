public class Hashing_and_validation {
    // Hashing and Validation/Hashing dan Validasi

    /*
     * Fungsi hash kriptografi adalah anggota kelas fungsi dengan tiga properti
     * penting; konsistensi,
     * keunikan, dan tidak dapat diubah.
     * Konsistensi: Dengan data yang sama, hash function akan selalu mengembalikan
     * nilai yang sama. Artinya, jika X = Y, f(x) akan selalu
     * sama dengan f(y) untuk hash function f.
     * Keunikan: Tidak ada dua masukan ke hash function yang akan menghasilkan
     * keluaran yang sama. Artinya, jika X != Y, f(x) != f(y), untuk sembarang nilai
     * X dan Y.
     */

    /*
     * Irreversibility: Sangat sulit, jika bukan tidak mungkin, untuk "membalikkan"
     * fungsi hash. Artinya, hanya diberikan f(X),
     * seharusnya tidak ada cara untuk menemukan X asli selain memasukkan setiap
     * kemungkinan nilai X melalui fungsi f (brute-force). Seharusnya tidak ada
     * fungsi f1 sehingga f1(f(X)) = X.
     * 
     * Banyak fungsi yang tidak memiliki setidaknya satu dari atribut ini. Misalnya,
     * MD5 dan SHA1 diketahui mengalami tabrakan, mis.
     * dua masukan yang mempunyai keluaran yang sama, sehingga kurang memiliki
     * keunikan. Beberapa fungsi yang saat ini diyakini aman adalah SHA-256 dan
     * SHA-512.
     */

}
