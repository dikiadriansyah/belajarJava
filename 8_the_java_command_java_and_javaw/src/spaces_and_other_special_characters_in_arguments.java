import java.io.File;

public class spaces_and_other_special_characters_in_arguments {
    // Spaces and other special characters in arguments / Spasi dan karakter khusus
    // lainnya dalam argumen

    // Pertama-tama, masalah penanganan spasi dalam argumen sebenarnya NOT masalah
    // Java.

    // sebaliknya itu adalah masalah itu perlu ditangani oleh shell perintah yang
    // anda gunakan saat menjalankan program java

    // Sebagai contoh, misalkan kita memiliki program sederhana berikut yang
    // mencetak ukuran file:

    public static void main(String[] args) {
        for (String fname : args) {
            // String fname = "src/File.txt";

            File f = new File(fname);
            System.out.println("Size of '" + f + "' is " + f.length());

        }
    }

    // sekarang misalkan kita ingin mencetak ukuran file yang pathname-nya memiliki
    // spasi didalamnya; misalnya /home/steve/Test File.txt. Jika kita menjalankan
    // perintah seperti ini:
    // $ java PrintFileSizes /home/steve/Test File.txt

    // shell tidak akan tahu bahwa /home/steve/Test File.txt sebenarnya adalah satu
    // pathname. Sebaliknya, itu akan melewati 2 berbeda argumen ke aplikasi Java,
    // yang akan berusaha menemukan ukuran file masing-masing, dan gagal karena file
    // dengan jalur itu (mungkin) tidak ada.

    // Solutions using a POSIX shell
    // POSIX shell termasuksh juga turunan seperti bash dan ksh. jika anda
    // menggunakan salah satu dari cangkang(shells) ini, anda dapat menyelesaikan
    // masalah dengan mengutip argumennya.
    // $ java PrintFileSizes "/home/steve/Test File.txt"

    // Tanda kutip ganda di sekitar pathname memberi tahu shell bahwa itu harus
    // diteruskan sebagai argumen tunggal. Kutipan akan dihapus ketika ini terjadi.
    // Ada beberapa cara lain untuk melakukan ini:
    // $ java PrintFileSizes '/home/steve/Test File.txt'

    // Tanda kutip tunggal (lurus) diperlakukan seperti tanda kutip ganda kecuali
    // bahwa tanda kutip tersebut juga menekan berbagai perluasan dalam argumen
    // $ java PrintFileSizes /home/steve/Test\ File.txt

    // Garis miring terbalik keluar dari spasi berikut, dan menyebabkannya tidak
    // ditafsirkan sebagai pemisah argumen.

    // Untuk dokumentasi yang lebih komprehensif, termasuk deskripsi cara menangani
    // karakter khusus lainnya di argumen, silakan merujuk ke topik kutipan dalam
    // dokumentasi Bash.

    // Solution for Windows
    // Masalah mendasar untuk Windows adalah bahwa pada tingkat OS, argumen
    // diteruskan ke proses anak sebagai string tunggal
    // (https://blogs.msdn.microsoft.com/twistylittlepassagesallalike/2011/04/23/everyone-quotes-command-line-arguments-the-wrong-way/).
    // Ini berarti bahwa tanggung jawab utama penguraian (atau penguraian ulang)
    // baris perintah jatuh pada salah satu program atau pustaka runtime-nya. Ada
    // banyak inkonsistensi.
    // Dalam kasus Java, untuk mempersingkat cerita:
    // -You can put double-quotes around an argument in a java command, and that
    // will allow you to pass arguments with spaces in them. / Anda dapat
    // menempatkan tanda kutip ganda di sekitar argumen dalam perintah java, dan itu
    // akan memungkinkan Anda untuk lulus argumen dengan spasi di dalamnya.

    // - Apparently, the java command itself is parsing the command string, and it
    // gets it more or less right / Rupanya, perintah java itu sendiri sedang
    // mem-parsing string perintah, dan itu kurang lebih benar

    // - However, when you try to combine this with the use of SET and variable
    // substitution in a batch file, it gets really complicated as to whether
    // double-quotes get removed. / namun, ketika anda mencoba untuk menggabungkan
    // ini dengan penggunaan SET dan substitusi variabel dalam file batch, hasilnya
    // sangat rumit apakah tanda kutip ganda dihapus

    // - The cmd.exe shell apparently has other escaping mechanisms; e.g. doubling
    // double-quotes, and using ^ escapes. / cmd.exe shell tampaknya memiliki
    // mekanisme keluar lainnya; misalnya menggandakan tanda kutip ganda dan
    // menggunakan ^ lolos.

    // Untuk detail lebih lanjut, silakan lihat dokumentasi Batch-File.

}
