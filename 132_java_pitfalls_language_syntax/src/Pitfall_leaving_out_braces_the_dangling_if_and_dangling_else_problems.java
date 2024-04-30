public class Pitfall_leaving_out_braces_the_dangling_if_and_dangling_else_problems {
    // Pitfall_leaving_out_braces_the_dangling_if_and_dangling_else_problems/Kesalahan
    // - Tidak menggunakan kurung kurawal: "jika yang menjuntai" dan
    // masalah"menggantung yang lain".

    /*
     * Versi terbaru dari panduan gaya Oracle Java mengamanatkan pernyataan "then"
     * dan "else" dalam pernyataan if harus selalu diapit oleh "braces" atau
     * "curly brackets". Aturan serupa berlaku untuk isi berbagai pernyataan loop.
     */

    /*
     * if (a) { // <- open brace
     * doSomething();
     * doSomeMore();
     * } // <- close brace
     */

    /*
     * Ini sebenarnya tidak diperlukan oleh sintaks bahasa Java. Memang benar, jika
     * bagian "then" dari pernyataan if adalah pernyataan tunggal, maka sah untuk
     * tidak menggunakan tanda kurung kurawal
     * if (a)
     * doSomething();
     */

    // atau bahkan
    // if (a) doSomething();

    /*
     * Namun ada bahayanya jika mengabaikan aturan gaya Java dan mengabaikan tanda
     * kurung kurawal. Secara khusus, Anda secara signifikan meningkatkan risiko
     * kesalahan pembacaan kode dengan lekukan yang salah.
     */

    // The "dangling if" problem /Masalah "menggantung jika":

    // Perhatikan contoh kode di atas, yang ditulis ulang tanpa kurung kurawal.
    /*
     * if (a)
     * doSomething();
     * doSomeMore();
     */

    /*
     * Kode ini sepertinya mengatakan bahwa panggilan ke doSomething dan doSomeMore
     * akan terjadi jika dan hanya jika a benar. Nyatanya,
     * kodenya salah indentasinya. Spesifikasi Bahasa Java yang dipanggil
     * doSomeMore() adalah pernyataan terpisah setelah pernyataan if. Indentasi yang
     * benar adalah sebagai berikut:
     * 
     * if (a)
     * doSomething();
     * doSomeMore();
     * 
     */

    // The "dangling else" problem/Masalah "menggantung yang lain".

    // Masalah kedua muncul ketika kita menambahkan else ke dalam campuran.
    // Perhatikan contoh berikut dengan kurung kurawal yang hilang

    /*
     * if (a)
     * if (b)
     * doX();
     * else if (c)
     * doY();
     * else
     * doZ();
     */

    /*
     * Kode di atas sepertinya mengatakan bahwa doZ akan dipanggil ketika a false.
     * Faktanya, lekukan tersebut sekali lagi salah.
     * Indentasi kode yang benar adalah:
     * if (a)
     * if (b)
     * doX();
     * else if (c)
     * doY();
     * else
     * doZ();
     */

    // Jika kode ditulis sesuai dengan aturan gaya Java, maka tampilannya akan
    // seperti ini:
    /*
     * if (a) {
     * if (b) {
     * doX();
     * } else if (c) {
     * doY();
     * } else {
     * doZ();
     * }
     * }
     * 
     * 
     */

    /*
     * Untuk mengilustrasikan mengapa ini lebih baik, misalkan Anda secara tidak
     * sengaja salah memasukkan kode. Anda mungkin mendapatkan hasil seperti ini:
     */

    /*
     * if (a) {
     * if (b) {
     * doX();
     * } else if (c) {
     * doY();
     * } else {
     * doZ();
     * }
     * }
     * 
     * 
     * if (a) {
     * if (b) {
     * doX();
     * } else if (c) {
     * doY();
     * } else {
     * doZ();
     * }
     * }
     * 
     */

    // Namun dalam kedua kasus tersebut, kode yang salah indentasi "looks wrong"
    // di mata pemrogram Java berpengalaman.

    public static void main(String[] args) throws Exception {
        // boolean a = true; // Atau bisa juga di-set ke false
        // if (a) {
        // // Mulai dari sini hingga kurung kurawal penutup adalah bagian dari blok yang
        // // akan dieksekusi jika a bernilai true
        // doSomething();
        // doSomeMore();
        // }
        // ---------------------------
        boolean a = true;
        boolean b = false;
        boolean c = true;

        if (a)
            if (b)
                doX();
            else if (c)
                doY();
            else
                doZ();

        /*
         * output:
         * doY() called.
         */

    }

    // Metode untuk melakukan sesuatu
    // public static void doSomething() {
    // System.out.println("Doing something...");
    // }

    // // Metode untuk melakukan sesuatu lagi
    // public static void doSomeMore() {
    // System.out.println("Doing some more...");
    // }

    // ---------------------------
    public static void doX() {
        System.out.println("doX() called.");
    }

    public static void doY() {
        System.out.println("doY() called.");
    }

    public static void doZ() {
        System.out.println("doZ() called.");
    }

}
