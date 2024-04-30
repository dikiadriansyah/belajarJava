import com.example.somelib.*;
import com.acme.otherlib.*;

public class Pitfall_wildcard_imports_can_make_your_code_fragile {
    // Pitfall - Wildcard imports can make your code fragile/Kesalahan - Impor
    // karakter pengganti dapat membuat kode Anda rapuh

    // Perhatikan sebagian contoh berikut:
    /*
     * import com.example.somelib.*;
     * import com.acme.otherlib.*;
     * public class Test {
     * private Context x = new Context(); // from com.example.somelib
     * //...
     * }
     */

    /*
     * Misalkan ketika Anda pertama kali mengembangkan kode terhadap versi 1.0 dari
     * somelib dan versi 1.0 dari otherlib.
     * Kemudian di kemudian hari, Anda perlu memutakhirkan dependensi Anda ke versi
     * yang lebih baru, dan Anda memutuskan untuk menggunakan otherlib versi 2.0.
     * Misalkan salah satu perubahan yang mereka buat pada otherlib antara 1.0 dan
     * 2.0 adalah menambahkan kelas Context.
     * 
     * Sekarang ketika Anda mengkompilasi ulang Test, Anda akan mendapatkan
     * kesalahan kompilasi yang memberitahukan Anda bahwa Context adalah impor yang
     * ambigu.
     * 
     * Jika Anda familiar dengan basis kodenya, ini mungkin hanya ketidaknyamanan
     * kecil. Jika tidak, maka Anda punya pekerjaan
     * yang harus dilakukan untuk mengatasi masalah ini, di sini dan mungkin di
     * tempat lain.
     * 
     * Masalahnya di sini adalah impor wildcard. Di satu sisi, menggunakan wildcard
     * dapat membuat kelas Anda menjadi beberapa baris lebih pendek. Di samping itu:
     * 1. Perubahan yang lebih kompatibel pada bagian lain basis kode Anda, pada
     * pustaka standar Java, atau pada pustaka pihak ketiga dapat menyebabkan
     * kesalahan kompilasi.
     * 2. Keterbacaan menurun. Kecuali Anda menggunakan IDE, mencari tahu impor
     * wildcard mana yang menarik kelas bernama bisa jadi sulit.
     * 
     * Pelajarannya adalah menggunakan impor wildcard dalam kode yang memerlukan
     * umur panjang adalah ide yang buruk. Impor spesifik (non-wildcard) tidak
     * membutuhkan banyak usaha untuk dipertahankan jika Anda menggunakan IDE, dan
     * upaya tersebut tidak sia-sia.
     */

    public static void main(String[] args) throws Exception {

    }
}
