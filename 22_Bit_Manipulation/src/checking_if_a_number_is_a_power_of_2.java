public class checking_if_a_number_is_a_power_of_2 {

    // Checking if a number is a power of 2
    /*
     * Jika integer x adalah pangkat 2, hanya satu bit yang diset, sedangkan
     * x-1 memiliki semua bit yang diset setelahnya. Contoh: 4 adalah 100 dan 3
     * adalah 011 sebagai bilangan biner, yang memenuhi syarat di atas. Nol bukan
     * pangkat 2 dan harus diperiksa secara eksplisit.
     * 
     * boolean isPowerOfTwo(int x)
     * {
     * return (x != 0) && ((x & (x - 1)) == 0);
     * }
     * 
     * 
     * Usage for Left and Right Shift(Penggunaan untuk Shift Kiri dan Kanan)
     * 
     * Misalkan kita mempunyai tiga jenis izin, Read, Write, dan Execute. Setiap
     * izin dapat berkisar dari 0 hingga 7. (Mari kita asumsikan sistem bilangan 4
     * bit)
     * RESOURCE = READ WRITE EXECUTE (12 bit number)
     * RESOURCE = 0100 0110 0101 = 4 6 5 (12 bit number)
     * 
     * Bagaimana kita bisa mendapatkan izin (nomor 12 bit), yang ditetapkan di atas
     * (nomor 12 bit)?
     * 0100 0110 0101
     * 0000 0000 0111 (&)
     * 0000 0000 0101 = 5
     * 
     * 
     * Jadi, ini adalah bagaimana kita bisa mendapatkan izin EXECUTE dari RESOURCE.
     * Sekarang, bagaimana jika kita ingin mendapatkan izin Read dari RESOURCE?
     * 0100 0110 0101
     * 0111 0000 0000 (&)
     * 0100 0000 0000 = 1024
     * 
     * Benar? Anda mungkin berasumsi demikian? Tapi, izinnya menghasilkan 1024. Kami
     * hanya ingin Read saja
     * izin untuk sumber daya. Jangan khawatir, itu sebabnya kami memiliki operator
     * shift. Kalau kita lihat, izin Read adalah 8
     * sedikit di belakang hasil sebenarnya, jadi jika menerapkan beberapa operator
     * shift, yang akan membawa izin Read ke kanan
     * hasil? Bagaimana jika kita melakukan:
     * 
     * 0100 0000 0000 >> 8 => 0000 0000 0100 (Karena bilangan positif jadi diganti
     * dengan 0, kalau tidak peduli tanda pakai saja operator shift kanan unsigned)
     * 
     * Kami sekarang sebenarnya memiliki izin Read yaitu 4.
     * 
     * Sekarang misal kita diberi ijin READ, WRITE, EXECUTE untuk sebuah RESOURCE,
     * apa yang bisa kita lakukan untuk membuatnya?
     * izin untuk Resource ini?
     * 
     * Pertama mari kita ambil contoh izin biner. (Masih mengasumsikan sistem
     * bilangan 4 bit)
     * READ = 0001
     * WRITE = 0100
     * EXECUTE = 0110
     * 
     * Jika Anda berpikir bahwa kami hanya akan melakukan:
     * Read | Write | EXECUTE, Anda agak benar tetapi tidak sepenuhnya benar. Lihat
     * apa yang terjadi jika kita melakukan READ |Write | Execute
     * 0001 | 0100 | 0110 => 0111
     * 
     * Namun izin sebenarnya direpresentasikan (dalam contoh kita) sebagai 0001 0100
     * 0110
     * 
     * Jadi, untuk melakukan hal ini, kita tahu bahwa READ ditempatkan 8 bit di
     * belakang, WRITE ditempatkan 4 bit di belakang dan PERMISSIONS ditempatkan
     * terakhir. Sistem angka yang digunakan untuk izin RESOURCE sebenarnya 12 bit
     * (dalam contoh kita). Ini bisa (akan) berbeda di sistem yang berbeda.
     * 
     * (READ << 8) | (WRITE << 4) | (EXECUTE)
     * 0000 0000 0001 << 8 (READ)
     * 0001 0000 0000 (Left shift by 8 bits)
     * 0000 0000 0100 << 4 (WRITE)
     * 0000 0100 0000 (Left shift by 4 bits)
     * 0000 0000 0001 (EXECUTE)
     * 
     * Nah jika kita jumlahkan hasil pergeseran di atas maka akan menjadi seperti;
     * 0001 0000 0000 (READ)
     * 0000 0100 0000 (WRITE)
     * 0000 0000 0001 (EXECUTE)
     * 0001 0100 0001 (PERMISSIONS)
     * 
     * 
     */

    public static void main(String[] args) throws Exception {

    }
}
