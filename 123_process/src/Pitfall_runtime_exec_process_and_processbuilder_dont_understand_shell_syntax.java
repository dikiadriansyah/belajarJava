import java.io.IOException;

public class Pitfall_runtime_exec_process_and_processbuilder_dont_understand_shell_syntax {

    /*
     * Pitfall: Runtime.exec, Process and ProcessBuilder don't understand shell
     * syntax / Kesalahan: Runtime.exec, Proses dan ProcessBuilder tidak memahami
     * sintaksis shell
     * 
     */

    /*
     * Metode Runtime.exec(String ...) dan Runtime.exec(String) memungkinkan Anda
     * menjalankan perintah sebagai proses eksternal1. Pada versi pertama, Anda
     * menyediakan nama perintah dan argumen perintah sebagai elemen terpisah dari
     * array string, dan runtime Java meminta sistem runtime OS untuk memulai
     * perintah eksternal.
     * Versi kedua tampaknya mudah digunakan, namun memiliki beberapa kekurangan.
     */

    // Pertama-tama, berikut adalah contoh penggunaan exec(String) yang digunakan
    // dengan aman:

    /*
     * Process p = Runtime.exec("mkdir /tmp/testDir");
     * p.waitFor();
     * if (p.exitValue() == 0) {
     * System.out.println("created the directory");
     * }
     */

    // Spaces in pathnames/Spasi di nama jalur

    // Misalkan kita menggeneralisasi contoh di atas sehingga kita dapat membuat
    // direktori sembarang:
    /*
     * Process p = Runtime.exec("mkdir " + dirPath);
     * // ...
     */

    /*
     * Ini biasanya akan berhasil, tetapi akan gagal jika dirPath (misalnya)
     * "/home/user/My Documents". Masalahnya adalah
     * exec(String) membagi string menjadi perintah dan argumen hanya dengan mencari
     * spasi. String perintah:
     * "mkdir /home/user/My Documents"
     * 
     */

    // akan dipecah menjadi:
    // mkdir", "/home/user/My", "Documents"

    /*
     * dan ini akan menyebabkan perintah "mkdir" gagal karena mengharapkan satu
     * argumen, bukan dua.
     * 
     * Menghadapi hal ini, beberapa pemrogram mencoba menambahkan tanda kutip di
     * sekitar nama path. Ini juga tidak berhasil:
     * "mkdir \"/home/user/My Documents\""
     * 
     */

    // akan dipecah menjadi:
    // "mkdir", "\"/home/user/My", "Documents\""

    /*
     * Karakter tanda kutip ganda tambahan yang ditambahkan dalam upaya untuk
     * "mengutip" spasi diperlakukan seperti karakter nonspasi lainnya. Memang
     * benar, apapun yang kita lakukan atau keluar dari ruang akan gagal.
     * 
     * Cara untuk mengatasi masalah khusus ini adalah dengan menggunakan kelebihan
     * exec(String ...).
     */

    /*
     * Process p = Runtime.exec("mkdir", dirPath);
     * // ...
     */

    /*
     * Ini akan berfungsi jika dirpath menyertakan karakter spasi karena kelebihan
     * exec ini tidak berupaya membagi argumen. String diteruskan ke panggilan
     * sistem OS exec apa adanya.
     */

    // Redirection, pipelines and other shell syntax
    /*
     * Misalkan kita ingin mengalihkan input atau output perintah eksternal, atau
     * menjalankan pipeline. Misalnya:
     * Process p = Runtime.exec("find / -name *.java -print 2>/dev/null");
     * 
     */

    // atau
    /*
     * Process p = Runtime.exec("find source -name *.java | xargs grep package");
     */

    /*
     * (Contoh pertama mencantumkan nama semua file Java di sistem file, dan contoh
     * kedua mencetak paketnya pernyataan2 dalam file Java di pohon "source".)
     */

    /*
     * Ini tidak akan berjalan sesuai harapan. Dalam kasus pertama, perintah "find"
     * akan dijalankan dengan "2>/dev/null" sebagai argumen perintah. Ini tidak akan
     * ditafsirkan sebagai pengalihan. Pada contoh kedua, pipe character ("|") dan
     * karya-karya berikutnya akan diberikan kepada perintah "find".
     * 
     * Masalahnya di sini adalah metode exec dan ProcessBuilder tidak memahami
     * sintaks shell apa pun. Ini termasuk
     * pengalihan, saluran pipa, ekspansi variabel, globbing, dan sebagainya.
     * 
     * Dalam beberapa kasus (misalnya, pengalihan sederhana) Anda dapat dengan mudah
     * mencapai efek yang diinginkan menggunakan ProcessBuilder.
     * Namun, hal ini tidak berlaku secara umum. Pendekatan alternatif adalah dengan
     * menjalankan baris perintah di shell; Misalnya:
     * 
     * Process p = Runtime.exec("bash", "-c",
     * "find / -name *.java -print 2>/dev/null");
     * 
     */

    // atau
    /*
     * Process p = Runtime.exec("bash", "-c",
     * "find source -name \\*.java | xargs grep package");
     */

    /*
     * Namun perhatikan bahwa dalam contoh kedua, kita perlu keluar dari karakter
     * wildcard ("*") karena kita ingin wildcard diinterpretasikan dengan "find" dan
     * bukan shell.
     */

    // Shell builtin commands don't work

    /*
     * Misalkan contoh berikut tidak berfungsi pada sistem dengan shell mirip UNIX:
     * Process p = Runtime.exec("cd", "/tmp"); // Change java app's home directory
     */

    // atau
    /*
     * Process p = Runtime.exec("export", "NAME=value"); // Export NAME to the java
     * app's environment
     * 
     */

    /*
     * Ada beberapa alasan mengapa ini tidak berhasil:
     * 1. Pada perintah "cd" dan "ekspor" adalah perintah bawaan shell. Mereka tidak
     * ada sebagai executable yang berbeda.
     * 2. Agar shell bawaan dapat melakukan apa yang seharusnya dilakukan (misalnya
     * mengubah direktori kerja, perbarui
     * lingkungan), mereka perlu mengubah tempat di mana negara itu berada. Untuk
     * aplikasi normal (termasuk aplikasi Java) keadaan dikaitkan dengan proses
     * aplikasi. Jadi misalnya, proses anak yang menjalankan perintah "cd" tidak
     * dapat mengubah direktori kerja proses "java" induknya. Demikian pula, satu
     * proses yang dijalankan tidak dapat mengubah direktori kerja untuk proses
     * berikutnya
     */

    /*
     * Alasan ini berlaku untuk semua perintah bawaan shell.
     * 1 - Anda juga dapat menggunakan ProcessBuilder, tetapi itu tidak relevan
     * dengan inti contoh ini.
     * 2 - Ini agak kasar dan ready... tetapi sekali lagi, kegagalan pendekatan ini
     * tidak relevan dengan contoh.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        try {
            Process p = Runtime.getRuntime().exec("mkdir ../src/testDir");
            p.waitFor();
            if (p.exitValue() == 0) {
                System.out.println("Berhasil membuat direktori");
            } else {
                System.out.println("Gagal membuat direktori");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
