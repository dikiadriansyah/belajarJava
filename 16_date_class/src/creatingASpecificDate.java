import java.util.Calendar;
import java.util.Date;

public class creatingASpecificDate {
    public static void main(String[] args) {

        // Meskipun kelas Java Date memiliki beberapa constructor, Anda akan melihat
        // bahwa sebagian besar tidak digunakan lagi. Satu-satunya cara yang dapat
        // diterima untuk membuat instance Date secara langsung adalah dengan
        // menggunakan constructor kosong atau mengirimkan long (jumlah miliseconds
        // sejak waktu dasar standar). Tidak ada yang berguna kecuali Anda sedang
        // mencari tanggal saat ini atau memiliki Contoh Date lain sudah ada di tangan.

        // Untuk membuat new date, Anda memerlukan calendar instance. Dari sana Anda
        // dapat menyetel calendar instance ke tanggal yang Anda perlukan.
        Calendar c = Calendar.getInstance();
        // Date d = c.getTime();
        // System.out.println(d); // output: Sat Jul 01 11:44:10 ICT 2023

        // Ini mengembalikan new Calendar instance yang disetel ke waktu saat ini.
        // Calendar memiliki banyak metode untuk mengubah tanggalnya
        // dan waktu atau pengaturan langsung. Dalam hal ini, kami akan menyetelnya ke
        // tanggal tertentu.

        c.set(1974, 6, 2, 8, 0, 0);
        Date d = c.getTime();
        System.out.println(d); // output: Tue Aug 01 11:04:10 ICT 2023

        // Metode getTime mengembalikan instance Date yang kita butuhkan. Perlu diingat
        // bahwa metode set Kalender hanya mengatur satu atau beberapa bidang, mereka
        // tidak mengatur semuanya. Artinya, jika Anda menyetel tahun, kolom lainnya
        // tetap tidak berubah.

        // PITFALL
        // Dalam banyak kasus, cuplikan kode ini memenuhi tujuannya, tetapi perlu
        // diingat bahwa dua bagian penting dari date/time tidak ditentukan.

        // - parameter (1974, 6, 2, 8, 0, 0) diinterpretasikan dalam default timezone,
        // ditentukan di suatu tempat kalau tidak,
        // - milliseconds tidak disetel ke nol, tetapi diisi dari jam sistem pada saat
        // instance Kalender dibuat.
    }
}
