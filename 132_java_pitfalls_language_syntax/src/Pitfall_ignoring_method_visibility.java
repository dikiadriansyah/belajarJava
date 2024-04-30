public class Pitfall_ignoring_method_visibility {
    // Pitfall - Ignoring method visibility/Kesalahan - Mengabaikan visibilitas
    // metode

    /*
     * Bahkan pengembang Java yang berpengalaman cenderung berpikir bahwa Java hanya
     * memiliki tiga pengubah perlindungan. Sebenarnya bahasanya
     * memiliki empat! Tingkat visibilitas package private (alias default) sering
     * kali dilupakan.
     * 
     * Anda harus memperhatikan metode apa yang Anda publikasikan. Metode publik
     * dalam suatu aplikasi adalah
     * API aplikasi yang terlihat. Ini harus sekecil dan sekompak mungkin, terutama
     * jika Anda menulis perpustakaan yang dapat digunakan kembali (lihat juga
     * prinsip SOLID). Penting juga untuk mempertimbangkan visibilitas semua metode,
     * dan hanya menggunakan akses pribadi yang dilindungi atau dikemas jika
     * diperlukan.
     * 
     * Saat Anda mendeklarasikan metode yang seharusnya bersifat private sebagai
     * publik, Anda mengekspos detail implementasi internal kelas tersebut.
     */

    /*
     * Akibat wajar dari hal ini adalah Anda hanya menguji unit metode publik kelas
     * Anda - sebenarnya Anda hanya dapat menguji metode publik. Meningkatkan
     * visibilitas metode pribadi hanya agar dapat menjalankan pengujian unit
     * terhadap metode tersebut merupakan praktik yang buruk. Menguji metode publik
     * yang memanggil metode dengan visibilitas yang lebih ketat seharusnya cukup
     * untuk menguji keseluruhan API. Anda tidak boleh memperluas API Anda dengan
     * lebih banyak metode publik hanya untuk mengizinkan pengujian unit.
     */

    public static void main(String[] args) throws Exception {

    }
}
