public class Pitfall_misplaced_semicolons_and_missing_braces {
    // Pitfall - Misplaced semicolons and missing braces/Kesalahan - Titik koma
    // salah tempat dan kurung kurawal hilang

    /*
     * Ini adalah kesalahan yang menyebabkan kebingungan nyata bagi pemula Java,
     * setidaknya saat pertama kali mereka melakukannya. Daripada menulis ini:
     * if (feeling == HAPPY)
     * System.out.println("Smile");
     * else
     * System.out.println("Frown");
     */

    // mereka secara tidak sengaja menulis ini:
    /*
     * if (feeling == HAPPY);
     * System.out.println("Smile");
     * else
     * System.out.println("Frown");
     */

    // dan bingung ketika kompiler Java memberi tahu mereka bahwa else salah
    // tempat. Kompiler Java menafsirkan hal di atas sebagai berikut:
    /*
     * if (feeling == HAPPY)
     * //empty statement
     * System.out.println("Smile"); // This is unconditional
     * else // This is misplaced. A statement cannot
     * // start with 'else'
     * System.out.println("Frown");
     * 
     */

    /*
     * Dalam kasus lain, tidak akan ada kesalahan kompilasi, tetapi kode tidak akan
     * melakukan apa yang diinginkan pemrogram. Misalnya:
     * for (int i = 0; i < 5; i++);
     * System.out.println("Hello");
     * 
     */

    /*
     * hanya mencetak "Halo" sekali. Sekali lagi, titik koma palsu berarti badan
     * perulangan for adalah pernyataan kosong. Itu berarti panggilan println
     * berikutnya tidak bersyarat.
     * 
     * Variasi lain:
     * for (int i = 0; i < 5; i++);
     * System.out.println("The number is " + i);
     */

    /*
     * Ini akan memberikan kesalahan "Tidak dapat menemukan simbol" untuk i.
     * Kehadiran titik koma palsu berarti panggilan println mencoba menggunakan i di
     * luar cakupannya.
     * 
     * Dalam contoh tersebut, ada solusi langsung: cukup hapus titik koma palsu.
     * Namun, ada beberapa pelajaran lebih dalam yang bisa diambil dari
     * contoh-contoh ini:
     * 
     * 1. Titik koma di Java bukanlah "kebisingan sintaksis". Ada atau tidaknya
     * titik koma dapat mengubah arti program Anda. Jangan hanya menambahkannya di
     * akhir setiap baris.
     * 2. Jangan percaya lekukan kode Anda. Dalam bahasa Java, spasi ekstra di awal
     * baris diabaikan oleh kompiler.
     * 3. Gunakan indentor otomatis. Semua IDE dan banyak editor teks sederhana
     * memahami cara membuat indentasi kode Java dengan benar.
     * 4. Ini adalah pelajaran yang paling penting. Ikuti pedoman gaya Java terbaru,
     * dan beri tanda kurung kurawal di sekitar "lalu"
     * dan pernyataan "lainnya" dan pernyataan isi perulangan. Kurung kurawal
     * terbuka ({) tidak boleh berada pada baris baru.
     */

    /*
     * Jika programmer mengikuti aturan gaya maka contoh if dengan titik koma yang
     * salah tempat akan terlihat seperti ini:
     * if (feeling == HAPPY); {
     * System.out.println("Smile");
     * } else {
     * System.out.println("Frown");
     * }
     */

    /*
     * Itu terlihat aneh bagi mata yang berpengalaman. Jika Anda memasukkan kode itu
     * secara otomatis, mungkin akan terlihat seperti ini:
     * if (feeling == HAPPY); {
     * System.out.println("Smile");
     * } else {
     * System.out.println("Frown");
     * }
     * 
     */

    // yang seharusnya dianggap salah bahkan bagi seorang pemula.

    public static void main(String[] args) throws Exception {
        // String feeling = "HAPPY";
        // if (feeling.equals("HAPPY")) {
        // System.out.println("Smile");
        // } else {
        // System.out.println("Frown");
        // }
        /*
         * output:
         * Smile
         */
        // ----------------------------
        // for (int i = 0; i < 5; i++) {
        // System.out.println("The number is" + i);
        // }

        /*
         * output:
         * The number is0
         * The number is1
         * The number is2
         * The number is3
         * The number is4
         */

    }
}
