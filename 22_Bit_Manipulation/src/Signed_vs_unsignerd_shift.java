public class Signed_vs_unsignerd_shift {
    // Signed vs unsigned shift
    /*
     * Di Java, semua bilangan primitif ditandatangani. Misalnya, int selalu
     * mewakili nilai dari [-2^31 - 1, 2^31], menjaga
     * bit pertama yang menandatangani nilai - 1 untuk nilai negatif, 0 untuk
     * positif.
     * 
     * Operator shift dasar >> dan << adalah operator bertanda tangan. Mereka akan
     * melestarikan tanda nilainya.
     * 
     * Namun pemrogram biasanya menggunakan angka untuk menyimpan nilai yang tidak
     * ditandatangani. Untuk int, itu berarti menggeser rentang
     * hingga [0, 2^32 - 1], memiliki nilai dua kali lebih besar dibandingkan dengan
     * int yang ditandatangani.
     * 
     * Bagi pengguna yang mahir, sedikit tanda tidak ada artinya. Itu sebabnya Java
     * menambahkan >>>, operator shift kiri, mengabaikan bit tanda itu.
     * 
     * 
     * initial value: 4 ( 100)
     * signed left-shift: 4 << 1 8 ( 1000)
     * signed right-shift: 4 >> 1 2 ( 10)
     * unsigned right-shift: 4 >>> 1 2 ( 10)
     * initial value: -4 ( 11111111111111111111111111111100)
     * signed left-shift: -4 << 1 -8 ( 11111111111111111111111111111000)
     * signed right-shift: -4 >> 1 -2 ( 11111111111111111111111111111110)
     * unsigned right-shift: -4 >>> 1 2147483646 ( 1111111111111111111111111111110)
     * 
     * Mengapa tidak ada <<< ?
     * 
     * Ini berasal dari definisi pergeseran kanan yang dimaksudkan. Saat ia mengisi
     * ruang kosong di sebelah kiri, tidak ada keputusan
     * untuk mengambil tentang sedikit tanda. Alhasil, tidak diperlukan 2 operator
     * berbeda.
     * 
     */
    public static void main(String[] args) throws Exception {

    }
}
