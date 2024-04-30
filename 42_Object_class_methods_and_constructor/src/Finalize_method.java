import java.io.FileDescriptor;
import java.io.IOException;

public class Finalize_method {
    // finalize() method

    /*
     * Ini adalah metode kelas Object yang dilindungi dan non-statis. Metode ini
     * digunakan untuk melakukan beberapa operasi akhir atau operasi pembersihan
     * pada suatu objek sebelum dihapus dari memori.
     * Menurut dokumen, metode ini dipanggil oleh pengumpul sampah pada suatu objek
     * ketika pengumpulan sampah menentukan bahwa tidak ada lagi referensi ke objek
     * tersebut.
     * 
     * Namun tidak ada jaminan bahwa metode finalize() akan dipanggil jika objek
     * masih dapat dijangkau atau tidak ada Pengumpul Sampah yang dijalankan saat
     * objek memenuhi syarat. Itu sebabnya lebih baik tidak mengandalkan metode ini.
     * 
     * Di perpustakaan inti Java beberapa contoh penggunaan dapat ditemukan,
     * misalnya di FileInputStream.java:
     */

    // protected void finalize() throws IOException {
    // if ((fd != null) && (fd != FileDescriptor.in)) {

    // /*
    // * jika fd dibagikan, referensi di FileDescriptor akan memastikan bahwa
    // * finalizer hanya dipanggil ketika aman untuk melakukannya. Semua referensi
    // * yang menggunakan fd menjadi tidak dapat dijangkau. Kita dapat memanggil
    // * close()
    // */
    // close();
    // }
    // }

    // Dalam hal ini, ini adalah kesempatan terakhir untuk menutup sumber daya jika
    // sumber daya tersebut belum pernah ditutup sebelumnya

    // Umumnya menggunakan metode finalize() dalam aplikasi apa pun dianggap praktik
    // buruk dan harus dihindari

    /*
     * Finalizer tidak dimaksudkan untuk membebaskan sumber daya (misalnya, menutup
     * file). Pengumpul sampah dipanggil ketika (jika!) sistem kehabisan ruang heap.
     * Anda tidak dapat mengandalkannya untuk dipanggil ketika sistem kehabisan
     * penanganan file atau, untuk alasan lain.
     * 
     * Kasus penggunaan yang dimaksudkan untuk finalizer adalah objek yang akan
     * direklamasi untuk memberi tahu objek lain tentang kehancuran yang akan
     * terjadi. Mekanisme yang lebih baik kini ada untuk tujuan
     * itu---java.lang.ref.WeakReference<T>
     * kelas. Jika Anda merasa perlu menulis metode finalize(), maka Anda harus
     * melihat apakah Anda dapat menyelesaikan masalah yang sama menggunakan
     * WeakReference. Jika itu tidak menyelesaikan masalah Anda, Anda mungkin perlu
     * memikirkan ulang desain Anda lebih dalam.
     * 
     */

    // Untuk bacaan lebih lanjut di sini adalah Item tentang metode finalize() dari
    // buku "Java Efektif" oleh Joshua Bloch.

    public static void main(String[] args) {

    }
}
