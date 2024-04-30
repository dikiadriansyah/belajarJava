import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Connecting_and_logging_into_a_ftp_server {
    // Connecting and Logging Into a FTP Server/Menghubungkan dan Masuk ke Server
    // FTP

    /*
     * Untuk mulai menggunakan FTP dengan Java, Anda perlu membuat FTPClient baru
     * lalu menghubungkan dan masuk ke server menggunakan
     * .connect(Server string, int port) dan .login(String username,String
     * password).
     * 
     * import java.io.IOException;
     * import org.apache.commons.net.ftp.FTPClient;
     * import org.apache.commons.net.ftp.FTPReply;
     * //Import all the required resource for this project.
     * public class FTPConnectAndLogin {
     * public static void main(String[] args) {
     * // SET THESE TO MATCH YOUR FTP SERVER //
     * String server = "www.server.com"; //Server can be either host name or IP
     * address.
     * int port = 21;
     * String user = "Username";
     * String pass = "Password";
     * FTPClient ftp = new FTPClient;
     * ftp.connect(server, port);
     * ftp.login(user, pass);
     * }
     * }
     * 
     * 
     */

    /*
     * Sekarang kita telah menyelesaikan dasar-dasarnya. Namun bagaimana jika kita
     * mengalami error saat menghubungkan ke server? Kami ingin tahu kapan terjadi
     * kesalahan dan mendapatkan pesan kesalahannya. Mari tambahkan beberapa kode
     * untuk menangkap kesalahan saat menghubungkan.
     * 
     * 
     * try {
     * ftp.connect(server, port);
     * showServerReply(ftp);
     * int replyCode = ftp.getReplyCode();
     * if (!FTPReply.isPositiveCompletion(replyCode)) {
     * System.out.printIn("Operation failed. Server reply code: " + replyCode)
     * return;
     * }
     * ftp.login(user, pass);
     * } catch {
     * }
     * 
     */

    // Mari kita uraikan apa yang baru saja kita lakukan, langkah demi langkah
    // showServerReply(ftp);

    // Ini mengacu pada fungsi yang akan kita buat pada langkah selanjutnya
    // int replyCode = ftp.getReplyCode();

    // Ini mengambil kode balasan/kesalahan dari server dan menyimpannya sebagai
    // bilangan bulat.

    /*
     * if (!FTPReply.isPositiveCompletion(replyCode)) {
     * System.out.printIn("Operation failed. Server reply code: " + replyCode)
     * return;
     * }
     */

    /*
     * Ini memeriksa kode balasan untuk melihat apakah ada kesalahan. Jika terjadi
     * kesalahan, ia hanya akan mencetak "Operasi gagal. Kode balasan server:"
     * diikuti dengan kode kesalahan. Kami juga menambahkan blok coba/tangkap yang
     * akan kami tambahkan pada langkah berikutnya. Selanjutnya, mari kita juga
     * membuat fungsi yang memeriksa kesalahan ftp.login().
     */

    /*
     * boolean success = ftp.login(user, pass);
     * showServerReply(ftp);
     * if (!success) {
     * System.out.println("Failed to log into the server");
     * return;
     * } else {
     * System.out.println("LOGGED IN SERVER");
     * }
     */

    // Mari kita hancurkan blok ini juga.
    // boolean success = ftp.login(user, pass);

    // Ini tidak hanya akan mencoba login ke server FTP, tetapi juga akan menyimpan
    // hasilnya sebagai boolean.
    // showServerReply(ftp);

    // Ini akan memeriksa apakah server mengirimi kami pesan apa pun, tetapi
    // pertama-tama kita harus membuat fungsinya pada langkah berikutnya.

    /*
     * if (!success) {
     * System.out.println("Failed to log into the server");
     * return;
     * } else {
     * System.out.println("LOGGED IN SERVER");
     * }
     */

    /*
     * Pernyataan ini akan memeriksa apakah kita berhasil login; jika demikian, maka
     * akan dicetak "LOGGED IN SERVER", jika tidak maka akan dicetak
     * "Gagal masuk ke server". Ini adalah skrip kami sejauh ini:
     * 
     * import java.io.IOException;
     * import org.apache.commons.net.ftp.FTPClient;
     * import org.apache.commons.net.ftp.FTPReply;
     * public class FTPConnectAndLogin {
     * public static void main(String[] args) {
     * // SET THESE TO MATCH YOUR FTP SERVER //
     * String server = "www.server.com";
     * int port = 21;
     * String user = "username"
     * String pass = "password"
     * FTPClient ftp = new FTPClient
     * try {
     * ftp.connect(server, port)
     * showServerReply(ftp);
     * int replyCode = ftpClient.getReplyCode();
     * if (!FTPReply.isPositiveCompletion(replyCode)) {
     * System.out.println("Operation failed. Server reply code: " + replyCode);
     * return;
     * }
     * boolean success = ftp.login(user, pass);
     * showServerReply(ftp);
     * if (!success) {
     * System.out.println("Failed to log into the server");
     * return;
     * } else {
     * System.out.println("LOGGED IN SERVER");
     * }
     * } catch {
     * }
     * }
     * }
     * 
     * 
     */

    // Sekarang selanjutnya mari kita selesaikan blok Catch jika kita mengalami
    // kesalahan pada keseluruhan proses

    /*
     * } catch (IOException ex) {
     * System.out.println("Oops! Something went wrong.");
     * ex.printStackTrace();
     * }
     */

    /*
     * Blok tangkapan yang telah selesai sekarang akan mencetak
     * "Ups! Ada yang tidak beres." dan stacktrace jika terjadi error.
     * Sekarang langkah terakhir kita adalah membuat showServerReply() yang telah
     * kita gunakan selama beberapa waktu.
     */

    /*
     * private static void showServerReply(FTPClient ftp) {
     * String[] replies = ftp.getReplyStrings();
     * if (replies != null && replies.length > 0) {
     * for (String aReply : replies) {
     * System.out.println("SERVER: " + aReply);
     * }
     * }
     * }
     */

    /*
     * Fungsi ini mengambil FTPClient sebagai variabel, dan menyebutnya "ftp".
     * Setelah itu menyimpan balasan server apa pun dari server dalam array string.
     * Selanjutnya ia memeriksa apakah ada pesan yang disimpan. Jika ada, ia akan
     * mencetak masing-masingnya sebagai
     * "SERVER: [balas]". Sekarang setelah fungsi tersebut selesai, inilah skrip
     * yang telah selesai:
     * 
     * import java.io.IOException;
     * import org.apache.commons.net.ftp.FTPClient;
     * import org.apache.commons.net.ftp.FTPReply;
     * public class FTPConnectAndLogin {
     * private static void showServerReply(FTPClient ftp) {
     * String[] replies = ftp.getReplyStrings();
     * if (replies != null && replies.length > 0) {
     * for (String aReply : replies) {
     * System.out.println("SERVER: " + aReply);
     * }
     * }
     * }
     * public static void main(String[] args) {
     * // SET THESE TO MATCH YOUR FTP SERVER //
     * String server = "www.server.com";
     * int port = 21;
     * String user = "username"
     * String pass = "password"
     * 
     * FTPClient ftp = new FTPClient
     * try {
     * ftp.connect(server, port)
     * showServerReply(ftp);
     * int replyCode = ftpClient.getReplyCode();
     * if (!FTPReply.isPositiveCompletion(replyCode)) {
     * System.out.println("Operation failed. Server reply code: " + replyCode);
     * return;
     * }
     * boolean success = ftp.login(user, pass);
     * showServerReply(ftp);
     * if (!success) {
     * System.out.println("Failed to log into the server");
     * return;
     * } else {
     * System.out.println("LOGGED IN SERVER");
     * }
     * } catch (IOException ex) {
     * System.out.println("Oops! Something went wrong.");
     * ex.printStackTrace();
     * }
     * }
     * }
     */

    /*
     * Pertama-tama kita perlu membuat FTPClient baru dan mencoba menghubungkan ke
     * servernya dan masuk ke dalamnya menggunakan
     * .connect(Server string, port int) dan .login(Nama pengguna string, kata sandi
     * string). Penting untuk terhubung dan login menggunakan blok coba/tangkap jika
     * kode kita gagal terhubung dengan server. Kita juga perlu membuat fungsi yang
     * memeriksa dan menampilkan pesan apa pun yang mungkin kita terima dari server
     * saat kita mencoba menghubungkan dan
     * masuk. Kami akan memanggil fungsi ini "showServerReply(FTPClient ftp)".
     */

    /*
     * import java.io.IOException;
     * import org.apache.commons.net.ftp.FTPClient;
     * import org.apache.commons.net.ftp.FTPReply;
     * public class FTPConnectAndLogin {
     * private static void showServerReply(FTPClient ftp) {
     * if (replies != null && replies.length > 0) {
     * for (String aReply : replies) {
     * System.out.println("SERVER: " + aReply);
     * }
     * }
     * }
     * public static void main(String[] args) {
     * // SET THESE TO MATCH YOUR FTP SERVER //
     * String server = "www.server.com";
     * int port = 21;
     * String user = "username"
     * String pass = "password"
     * FTPClient ftp = new FTPClient
     * try {
     * ftp.connect(server, port)
     * showServerReply(ftp);
     * int replyCode = ftpClient.getReplyCode();
     * if (!FTPReply.isPositiveCompletion(replyCode)) {
     * System.out.println("Operation failed. Server reply code: " + replyCode);
     * return;
     * }
     * boolean success = ftp.login(user, pass);
     * showServerReply(ftp);
     * 
     * if (!success) {
     * System.out.println("Failed to log into the server");
     * return;
     * } else {
     * System.out.println("LOGGED IN SERVER");
     * }
     * } catch (IOException ex) {
     * System.out.println("Oops! Something went wrong.");
     * ex.printStackTrace();
     * }
     * }
     * }
     * 
     */

    // Setelah ini, server FTP Anda sekarang harus terhubung ke skrip Java Anda.

    private static void showServerReply(FTPClient ftp) {
        String[] replies = ftp.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // SET THESE TO MATCH YOUR FTP SERVER //
        String server = "ftp.diksgroup.com";
        int port = 21;
        String user = "dikn9491";
        String pass = "bE9Fu5qgt94Z32";
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(server, port);
            showServerReply(ftp);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
            boolean success = ftp.login(user, pass);
            showServerReply(ftp);
            if (!success) {
                System.out.println("Failed to log into the server");
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
            }
        } catch (IOException ex) {
            System.out.println("Oops! Something went wrong.");
            ex.printStackTrace();
        }
    }

}
