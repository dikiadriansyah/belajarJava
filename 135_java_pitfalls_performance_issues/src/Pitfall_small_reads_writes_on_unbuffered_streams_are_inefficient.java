import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.*;

public class Pitfall_small_reads_writes_on_unbuffered_streams_are_inefficient {
    // Pitfall - Small reads / writes on unbuffered streams are
    // inefficient/Kesalahan - Pembacaan/penulisan kecil pada aliran tanpa buffer
    // tidak efisien

    /*
     * Pertimbangkan kode berikut untuk menyalin satu file ke file lainnya:
     * 
     * import java.io.*;
     * public class FileCopy {
     * public static void main(String[] args) throws Exception {
     * try (InputStream is = new FileInputStream(args[0]);
     * OutputStream os = new FileOutputStream(args[1])) {
     * int octet;
     * while ((octet = is.read()) != -1) {
     * os.write(octet);
     * }
     * }
     * }
     * }
     */

    /*
     * (Kami sengaja menghilangkan pemeriksaan argumen normal, pelaporan kesalahan,
     * dan sebagainya karena tidak relevan dengan poin contoh ini.)
     * 
     * Jika Anda mengkompilasi kode di atas dan menggunakannya untuk menyalin file
     * besar, Anda akan melihat bahwa itu sangat lambat. Faktanya, ini akan menjadi
     * setidaknya beberapa kali lipat lebih lambat daripada utilitas penyalinan file
     * OS standar.
     * 
     * (Tambahkan pengukuran kinerja aktual di sini!)
     * 
     * Alasan utama contoh di atas lambat (dalam kasus file besar) adalah karena
     * contoh tersebut melakukan pembacaan satu byte dan penulisan satu byte pada
     * aliran byte yang tidak di-buffer. Cara sederhana untuk meningkatkan kinerja
     * adalah dengan menggabungkan aliran dengan aliran yang di-buffer. Misalnya:
     * 
     * import java.io.*;
     * public class FileCopy {
     * public static void main(String[] args) throws Exception {
     * try (InputStream is = new BufferedInputStream(
     * new FileInputStream(args[0]));
     * OutputStream os = new BufferedOutputStream(
     * new FileOutputStream(args[1]))) {
     * int octet;
     * while ((octet = is.read()) != -1) {
     * os.write(octet);
     * }
     * }
     * }
     * }
     * 
     */

    /*
     * Perubahan kecil ini akan meningkatkan kecepatan penyalinan data setidaknya
     * beberapa kali lipat, bergantung pada berbagai faktor terkait platform.
     * Pembungkus aliran yang di-buffer menyebabkan data dibaca dan ditulis dalam
     * potongan yang lebih besar. Kedua instance tersebut memiliki buffer yang
     * diimplementasikan sebagai array byte.
     * 1. Dengan ini, data dibaca dari file ke dalam buffer beberapa kilobyte
     * sekaligus. Saat read() dipanggil, implementasi biasanya akan mengembalikan
     * satu byte dari buffer. Itu hanya akan membaca dari aliran input yang
     * mendasarinya jika buffer telah dikosongkan.
     * 2. Perilaku os serupa. Panggilan ke os.write(int) menulis satu byte ke dalam
     * buffer. Data hanya ditulis ke aliran keluaran ketika buffer penuh, atau
     * ketika os di-flush atau ditutup.
     */

    /*
     * Bagaimana dengan aliran berbasis karakter?
     * Seperti yang harus Anda ketahui, Java I/O menyediakan API berbeda untuk
     * membaca dan menulis data biner dan teks.
     * 1. InputStream dan OutputStream adalah API dasar untuk I/O biner berbasis
     * aliran
     * 2. Reader dan writer adalah API dasar untuk I/O teks berbasis aliran.
     * 
     * Untuk I/O teks, BufferedReader dan BufferedWriter setara dengan
     * BufferedInputStream dan BufferedOutputStream.
     */

    /*
     * Mengapa streaming yang di-buffer membuat perbedaan sebesar ini?
     * Alasan sebenarnya mengapa aliran buffer membantu kinerja adalah karena cara
     * aplikasi berkomunikasi dengan sistem operasi:
     * 
     * 1. Metode Java dalam aplikasi Java, atau panggilan prosedur asli di
     * perpustakaan runtime asli JVM cepat. Mereka biasanya memerlukan beberapa
     * instruksi mesin dan memiliki dampak kinerja yang minimal.
     * 2. Sebaliknya, panggilan runtime JVM ke sistem operasi tidak cepat. Mereka
     * melibatkan sesuatu yang dikenal sebagai "syscall". Pola khas untuk syscall
     * adalah sebagai berikut:
     * 1. Masukkan argumen syscall ke dalam register.
     * 2. Jalankan instruksi perangkap SYSENTER.
     * 3. Penangan jebakan beralih ke status istimewa dan mengubah pemetaan memori
     * virtual. Lalu itu
     * dikirim ke kode untuk menangani syscall tertentu.
     * 4. Penangan syscall memeriksa argumen, berhati-hati agar tidak diberitahu
     * untuk mengakses memori yang
     * proses pengguna seharusnya tidak melihat.
     * 5. Pekerjaan khusus syscall dilakukan. Dalam kasus syscall baca, hal ini
     * mungkin melibatkan:
     * 1. memeriksa apakah ada data yang akan dibaca pada posisi deskriptor file
     * saat ini
     * 2. memanggil pengendali sistem file untuk mengambil data yang diperlukan dari
     * disk (atau di mana pun data disimpan).
     * cache penyangga,
     * 3. menyalin data dari cache buffer ke alamat yang disediakan JVM
     * 4. menyesuaikan posisi deskriptor file penunjuk aliran
     * 6. Kembali dari syscall. Hal ini memerlukan perubahan pemetaan VM lagi dan
     * beralih dari status istimewa.
     */

    /*
     * Seperti yang dapat Anda bayangkan, melakukan satu syscall dapat menangani
     * ribuan instruksi mesin. Secara konservatif, setidaknya dua kali lipat lebih
     * lama dari pemanggilan metode biasa. (Mungkin tiga atau lebih.)
     * 
     * Mengingat hal ini, alasan mengapa aliran buffer membuat perbedaan besar
     * adalah karena aliran tersebut mengurangi jumlah syscall secara drastis.
     * Daripada melakukan syscall untuk setiap panggilan read(), aliran input yang
     * dibuffer akan membaca data dalam jumlah besar ke dalam buffer sesuai
     * kebutuhan. Sebagian besar panggilan read() pada aliran buffer melakukan
     * pemeriksaan batas sederhana dan mengembalikan satu byte
     * yang telah dibaca sebelumnya. Alasan serupa berlaku dalam kasus aliran
     * keluaran, dan juga kasus aliran karakter.
     * 
     * (Beberapa orang berpikir bahwa kinerja I/O yang di-buffer berasal dari
     * ketidakcocokan antara ukuran permintaan baca dan ukuran blok disk, latensi
     * rotasi disk, dan hal-hal serupa. Faktanya, OS modern menggunakan sejumlah
     * strategi untuk memastikan bahwa kinerja I/O di-buffer. aplikasi biasanya
     * tidak perlu menunggu disk. Ini bukan penjelasan sebenarnya.)
     */

    // Are buffered streams always a win?/Apakah streaming yang di-buffer selalu
    // menguntungkan?
    /*
     * Tidak selalu. Streaming yang di-buffer jelas merupakan sebuah keuntungan jika
     * aplikasi Anda akan melakukan banyak pembacaan atau penulisan "small".
     * Namun, jika aplikasi Anda hanya perlu melakukan pembacaan atau penulisan
     * dalam jumlah besar ke/dari byte[] atau char[] yang besar, maka aliran yang
     * di-buffer tidak akan memberi Anda manfaat nyata. Bahkan mungkin ada penalti
     * kinerja (tiny).
     */

    // Is this the fastest way to copy a file in Java?/Apakah ini cara tercepat
    // untuk menyalin file di Java?
    /*
     * Tidak, tidak. Saat Anda menggunakan API berbasis aliran Java untuk menyalin
     * file, Anda dikenakan biaya setidaknya satu salinan data memori-ke-memori
     * tambahan. Hal ini dapat dihindari jika Anda menggunakan NIO ByteBuffer dan
     * Channel API. (Tambahkan tautan ke contoh terpisah di sini.)
     */

    public static void main(String[] args) throws Exception {
        try (InputStream is = new FileInputStream(args[0]);
                OutputStream os = new FileOutputStream(args[1])) {
            int octet;
            while ((octet = is.read()) != -1) {
                os.write(octet);
            }
        }

    }
}
