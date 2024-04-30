public class The_shift_operator {
    // The Shift Operators (<<, >> and >>>) / Operator Pergeseran (<<, >> dan >>>)

    /*
     * Bahasa Java menyediakan tiga operator untuk melakukan perpindahan bitwise
     * pada nilai integer 32 dan 64 bit. Ini semua adalah operator biner dengan
     * operan pertama adalah nilai yang akan digeser, dan operan kedua menyatakan
     * seberapa jauh pergeserannya.
     * 
     * 1. Operator << atau shift kiri menggeser nilai yang diberikan oleh operan
     * pertama ke kiri berdasarkan jumlah posisi bit diberikan oleh operan kedua.
     * Posisi kosong di ujung kanan diisi dengan angka nol.
     * 2. Operator '>>' atau pergeseran aritmatika menggeser nilai yang diberikan
     * oleh operan pertama ke kanan dengan jumlah posisi bit yang diberikan oleh
     * operan kedua. Posisi kosong di ujung kiri diisi dengan menyalin bit paling
     * kiri. Proses ini dikenal sebagai perluasan tanda.
     * 3. Operator '>>>' atau logika pergeseran kanan menggeser nilai yang diberikan
     * oleh operan pertama ke arah kanan dengan jumlah posisi bit yang diberikan
     * oleh operan kedua. Posisi kosong di ujung kiri diisi dengan angka nol.
     */

    // Catatan:
    /*
     * 1. Operator ini memerlukan nilai int atau long sebagai operan pertama, dan
     * menghasilkan nilai dengan tipe yang sama dengan operan pertama. (Anda perlu
     * menggunakan tipe cast eksplisit saat menetapkan hasil pergeseran ke variabel
     * byte, short, atau char.)
     * 2. Jika Anda menggunakan operator shift dengan operan pertama berupa byte,
     * char, atau short, operator tersebut dipromosikan menjadi int dan operasi
     * menghasilkan int.)
     * 3. Operan kedua dikurangi modulo jumlah bit operasi untuk memberikan jumlah
     * pergeseran. Untuk informasi lebih lanjut tentang konsep matematika mod, lihat
     * Contoh modulus.
     * 4. Bit yang digeser dari ujung kiri atau kanan karena operasi akan dibuang.
     * (Java tidak menyediakan operator "putar" primitif.)
     * 5. Operator pergeseran aritmatika setara dengan membagi suatu bilangan
     * (komplemen dua) dengan pangkat 2.
     * 6. Operator shift kiri setara dengan mengalikan suatu bilangan (komplemen
     * dua) dengan pangkat 2.
     */

    /*
     * Tabel berikut akan membantu Anda melihat dampak dari ketiga operator shift.
     * (Angka-angka tersebut telah dinyatakan dalam notasi biner untuk membantu
     * vizualisasi.)
     */

    /*
     * Operand1 | Operand2 | << >> >>>
     * 0b0000000000001011 | 0 | 0b0000000000001011 0b0000000000001011
     * 0b0000000000001011
     * 0b0000000000001011 | 1 | 0b0000000000010110 0b0000000000000101
     * 0b0000000000000101
     * 0b0000000000001011 | 2 | 0b0000000000101100 0b0000000000000010
     * 0b0000000000000010
     * 0b0000000000001011 | 28 | 0b1011000000000000 0b0000000000000000
     * 0b0000000000000000
     * 0b0000000000001011 | 31 | 0b1000000000000000 0b0000000000000000
     * 0b0000000000000000
     * 0b0000000000001011 | 32 | 0b0000000000001011 0b0000000000001011
     * 0b0000000000001011
     * 
     * 0b1000000000001011 | 0 | 0b1000000000001011 0b1000000000001011
     * 0b1000000000001011
     * 0b1000000000001011 | 1 | 0b0000000000010110 0b1100000000000101
     * 0b0100000000000101
     * 0b1000000000001011 | 2 | 0b0000000000101100 0b1110000000000010
     * 0b00100000000000100
     * 0b1000000000001011 | 31 | 0b1000000000000000 0b1111111111111111
     * 0b0000000000000001
     * 
     * 
     * Ada contoh pengguna operator shift dalam manipulasi Bit
     */

    public static void main(String[] args) {

    }
}
