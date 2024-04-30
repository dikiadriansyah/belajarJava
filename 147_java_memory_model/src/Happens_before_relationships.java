public class Happens_before_relationships {
    // Happens-before relationships/Terjadi-sebelum hubungan

    /*
     * (Berikut ini adalah versi sederhana dari Spesifikasi Bahasa Java. Untuk
     * pemahaman lebih dalam, Anda perlu membaca spesifikasi itu sendiri.)
     * 
     * Hubungan terjadi-sebelum adalah bagian dari Model Memori yang memungkinkan
     * kita memahami dan mempertimbangkan visibilitas memori. Seperti yang dikatakan
     * JLS (JLS 17.4.5):
     * 
     * "Dua tindakan dapat diurutkan berdasarkan hubungan yang terjadi-sebelum. Jika suatu tindakan terjadi-sebelum tindakan lainnya, maka tindakan pertama dapat dilihat dan diurutkan sebelum tindakan kedua."
     * 
     */

    // Apa artinya ini?

    // Actions

    /*
     * Tindakan yang mengacu pada kutipan di atas ditentukan dalam JLS 17.4.2. Ada 5
     * jenis tindakan yang ditentukan oleh spesifikasi:
     * 
     * 1. Baca: Membaca variabel non-volatile.
     * 2. Write : Menulis variabel non-volatile.
     * 3. Tindakan sinkronisasi:
     * a. Volatile read : Membaca variabel volatil.
     * b. Volatile write : Menulis variabel volatil.
     * c. Kunci. Mengunci monitor
     * d. Buka kunci. Membuka kunci monitor.
     * e. Tindakan pertama dan terakhir (sintetis) dari sebuah thread.
     * f. Tindakan yang memulai thread atau mendeteksi bahwa thread telah
     * dihentikan.
     * 4. Tindakan Eksternal. Suatu tindakan yang mempunyai hasil yang bergantung
     * pada lingkungan di mana program tersebut dilakukan.
     * 5. Tindakan divergensi benang. Ini memodelkan perilaku jenis loop tak
     * terbatas tertentu.
     */

    // Program Order and Synchronization Order/Urutan Program dan Urutan
    // Sinkronisasi

    /*
     * Kedua urutan ini ( JLS 17.4.3 dan JLS 17.4.4 ) mengatur eksekusi pernyataan
     * di Java
     * Urutan program menjelaskan urutan eksekusi pernyataan dalam satu thread.
     * Urutan sinkronisasi menjelaskan urutan eksekusi pernyataan untuk dua
     * pernyataan yang dihubungkan oleh sinkronisasi:
     * 
     * 
     * 1. Tindakan membuka kunci pada monitor disinkronkan dengan semua tindakan
     * kunci berikutnya pada monitor tersebut.
     * 2. Penulisan ke variabel volatil disinkronkan dengan semua pembacaan
     * selanjutnya dari variabel yang sama oleh thread mana pun.
     * 3. Tindakan yang memulai thread (yaitu panggilan ke Thread.start())
     * disinkronkan dengan tindakan pertama dalam thread yang dimulainya (yaitu
     * panggilan ke metode run() thread).
     * 4. Inisialisasi default bidang disinkronkan dengan tindakan pertama di setiap
     * thread. (Lihat JLS untuk penjelasannya.)
     * 5. Tindakan terakhir di thread disinkronkan-dengan tindakan apa pun di thread
     * lain yang mendeteksi penghentian; misalnya
     * kembalinya panggilan join() atau panggilan isTerminated() yang mengembalikan
     * nilai true.
     * 6. Jika satu thread menginterupsi thread lain, panggilan interupsi di thread
     * pertama akan disinkronkan-dengan titik di mana thread lain mendeteksi bahwa
     * thread tersebut telah diinterupsi.
     */

    // Happens-before Order/Terjadi-sebelum Pesanan
    /*
     * Urutan ini ( JLS 17.4.5 ) inilah yang menentukan apakah penulisan memori
     * dijamin akan terlihat oleh pembacaan memori berikutnya.
     * 
     * Lebih khusus lagi, pembacaan suatu variabel v dijamin akan mengamati
     * penulisan ke v jika dan hanya jika write(v) terjadi-sebelum read(v)
     * DAN tidak ada intervensi penulisan ke v. Jika ada intervensi penulisan, maka
     * read(v) dapat melihat hasil daripada yang sebelumnya.
     * 
     * Aturan yang menentukan pengurutan terjadi sebelum adalah sebagai berikut:
     * Happens-Before Rule #1 - Jika x dan y adalah aksi dari thread yang sama
     * dan x muncul sebelum y dalam urutan program,
     * maka x terjadi-sebelum y.
     * 
     * Happens-Before Rule #2 - Terdapat tepi terjadi-sebelum dari akhir
     * konstruktor suatu objek ke awal finalizer untuk objek tersebut.
     * 
     * Happens-Before Rule #3 - Jika suatu tindakan x disinkronkan-dengan
     * tindakan berikutnya y, maka x terjadi-sebelum y.
     * 
     * Happens-Before Rule #4 - Jika x terjadi-sebelum y dan y terjadi-sebelum z
     * maka x terjadi-sebelum z.
     */

    /*
     * Selain itu, berbagai kelas di perpustakaan standar Java ditetapkan sebagai
     * penentu hubungan yang terjadi sebelum. Anda dapat mengartikan hal ini sebagai
     * sesuatu yang terjadi, tanpa perlu mengetahui secara pasti bagaimana jaminan
     * tersebut akan dipenuhi.
     */

    public static void main(String[] args) throws Exception {

    }
}
