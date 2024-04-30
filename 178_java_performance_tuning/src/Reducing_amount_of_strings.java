public class Reducing_amount_of_strings {
    // Reducing amount of Strings/Mengurangi jumlah String

    /*
     * Di Java, terlalu "mudah" untuk membuat banyak instance String yang tidak
     * diperlukan. Itu dan alasan lain yang mungkin menjadi penyebabnya
     * program Anda memiliki banyak String yang sedang sibuk dibersihkan oleh GC.
     * 
     * Beberapa cara Anda mungkin membuat instance String:
     * myString += "foo";
     * 
     */

    // Atau lebih buruk lagi, dalam satu lingkaran atau rekursi:
    /*
     * for (int i = 0; i < N; i++) {
     * myString += "foo" + i;
     * }
     */

    /*
     * Masalahnya adalah setiap + membuat new String (biasanya, karena kompiler
     * baru mengoptimalkan beberapa kasus). Mungkin
     * optimasi dapat dilakukan menggunakan StringBuilder atau StringBuffer:
     */

    /*
     * StringBuffer sb = new StringBuffer(myString);
     * for (int i = 0; i < N; i++) {
     * sb.append("foo").append(i);
     * }
     * myString = sb.toString();
     */

    // Jika Anda sering membuat String yang panjang (misalnya SQL), gunakan API
    // pembuatan String.

    /*
     * Hal lain yang perlu dipertimbangkan:
     * 1. Kurangi penggunaan replace, substring dll.
     * 2. Hindari String.toArray(), terutama pada kode yang sering diakses.
     * 3. Cetakan log yang dimaksudkan untuk difilter (misalnya karena level log)
     * tidak boleh dibuat (level log harus diperiksa terlebih dahulu).
     * 4. Gunakan perpustakaan seperti ini jika perlu.
     * 5. StringBuilder lebih baik jika variabel digunakan secara non-bersama (di
     * seluruh thread).
     */
    public static void main(String[] args) throws Exception {
        String myString = "InitialString ";
        int N = 5; // Misalnya N = 5

        // Menggunakan StringBuffer untuk penggabungan string
        StringBuffer sb = new StringBuffer(myString);
        for (int i = 0; i < N; i++) {
            sb.append(" foo").append(i);
        }

        // Mengubah StringBuffer menjadi String
        myString = sb.toString();

        // Menampilkan hasil
        System.out.println(myString);
        // ouput: InitialString foo0 foo1 foo2 foo3 foo4

    }
}
