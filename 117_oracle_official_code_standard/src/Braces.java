public class Braces {
    // Braces/kawat gigi

    /*
     * class Example {
     * void method(boolean error) {
     * if (error) {
     * Log.error("Error occurred!");
     * System.out.println("Error!");
     * } else { // Use braces since the other block uses braces.
     * System.out.println("No error");
     * }
     * }
     * }
     */

    /*
     * 1. Kurung kurawal pembuka harus diletakkan di akhir baris saat ini, bukan di
     * baris tersendiri.
     * 
     * 2. Harus ada baris baru di depan kurung kurawal penutup kecuali blok tersebut
     * kosong (lihat Formulir Singkat di bawah)
     * 
     * 3. Tanda kurung kurawal direkomendasikan meskipun bahasanya menjadikannya
     * opsional, seperti badan if dan loop satu baris.
     * 
     * 
     * - Jika sebuah blok mencakup lebih dari satu baris (termasuk komentar), maka
     * blok tersebut harus memiliki kurung kurawal.
     * - Jika salah satu blok dalam pernyataan if / else memiliki tanda kurung
     * kurawal, blok lainnya juga harus demikian.
     * - Jika blok berada di urutan terakhir dalam blok penutup, maka blok tersebut
     * harus mempunyai kurung kurawal.
     * 
     * 4. else, catch dan kata kunci while di do… while loop berada pada baris
     * yang sama dengan kurung kurawal penutup dari blok sebelumnya.
     */

    // Short forms
    /*
     * enum Response { YES, NO, MAYBE }
     * public boolean isReference() { return true; }
     */

    /*
     * Rekomendasi di atas dimaksudkan untuk meningkatkan keseragaman (dan dengan
     * demikian meningkatkan keakraban/keterbacaan). Dalam beberapa kasus, ““short
     * forms” yang menyimpang dari pedoman di atas tetap dapat dibaca dan dapat
     * digunakan sebagai gantinya.
     * Kasus-kasus ini termasuk misalnya deklarasi enum sederhana dan metode sepele
     * serta ekspresi lambda.
     */

    void method(boolean error) {
        if (error) {
            Log.error("Error occurred!");
            System.out.println("Error!");
        } else { // Use braces since the other block uses braces.
            System.out.println("No error");
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Braces box = new Braces();
        box.method(true); // Test with error
        /*
         * output:
         * Error occurred!
         * Error!
         */

        box.method(false); // Test without error
        /*
         * output:
         * No error
         */
    }
}
