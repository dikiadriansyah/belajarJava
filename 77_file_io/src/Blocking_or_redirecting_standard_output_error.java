import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Blocking_or_redirecting_standard_output_error {
    // Blocking or redirecting standard output / error / Memblokir atau mengarahkan
    // keluaran/kesalahan standar

    /*
     * Terkadang perpustakaan pihak ketiga yang dirancang dengan buruk akan menulis
     * diagnostik yang tidak diinginkan ke System.out atau System.err
     * aliran. Solusi yang disarankan untuk hal ini adalah dengan mencari
     * perpustakaan yang lebih baik atau (dalam kasus open source)
     * memperbaiki masalah dan menyumbangkan tambalan kepada pengembang.
     * 
     * Jika solusi di atas tidak memungkinkan, Anda harus mempertimbangkan untuk
     * mengalihkan aliran.
     */

    // Redirection on the command line/Pengalihan pada baris perintah
    /*
     * Pada sistem UNIX, Linux atau MacOSX dapat dilakukan dari shell menggunakan >
     * redirection. Misalnya:
     * $ java -jar app.jar arg1 arg2 > /dev/null 2>&1
     * $ java -jar app.jar arg1 arg2 > out.log 2> error.log
     */

    /*
     * Yang pertama mengalihkan keluaran standar dan kesalahan standar ke
     * "/dev/null", yang membuang apa pun yang ditulis ke aliran tersebut. Yang
     * kedua mengalihkan keluaran standar ke "out.log" dan kesalahan standar ke
     * "error.log".
     * 
     * (Untuk informasi lebih lanjut tentang pengalihan, lihat dokumentasi shell
     * perintah yang Anda gunakan. Serupa saran berlaku untuk Windows.)
     * 
     * Alternatifnya, Anda dapat menerapkan pengalihan dalam skrip pembungkus atau
     * file batch yang meluncurkan aplikasi Java.
     */

    // Redirection within a Java application/Pengalihan dalam aplikasi Java
    /*
     * Dimungkinkan juga untuk mengalihkan aliran dalam aplikasi Java menggunakan
     * System.setOut() dan System.setErr(). Misalnya, cuplikan berikut mengalihkan
     * keluaran standar dan kesalahan standar ke 2 file log:
     * System.setOut(new PrintStream(new FileOutputStream(new File("out.log"))));
     * System.setErr(new PrintStream(new FileOutputStream(new File("err.log"))));
     * 
     */

    /*
     * Jika Anda ingin membuang keluaran seluruhnya, Anda dapat membuat aliran
     * keluaran yang "menulis" ke deskriptor file yang tidak valid. Ini secara
     * fungsional setara dengan menulis ke "/dev/null" di UNIX
     * System.setOut(new PrintStream(new FileOutputStream(new FileDescriptor())));
     * System.setErr(new PrintStream(new FileOutputStream(new FileDescriptor())));
     */

    /*
     * Perhatian: berhati-hatilah dalam menggunakan setOut dan setErr:
     * 1. Pengalihan akan mempengaruhi keseluruhan JVM.
     * 2. Dengan melakukan ini, Anda menghilangkan kemampuan pengguna untuk
     * mengalihkan aliran dari baris perintah.
     */

    public static void main(String[] args) {

        try {
            // Tentukan file target untuk output
            File outputFile = new File("out.log");

            // Set up FileOutputStream untuk menulis output ke file
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

            // Set up PrintStream untuk menulis ke FileOutputStream
            PrintStream printStream = new PrintStream(fileOutputStream);

            // Redirect System.out ke PrintStream yang telah dikonfigurasi
            System.setOut(printStream);

            // Sekarang, semua output akan ditulis ke file "out.log"
            System.out.println("Hello, this will be written to out.log");
            System.out.println("Another line in out.log");

            // Pastikan untuk menutup fileOutputStream setelah selesai
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
