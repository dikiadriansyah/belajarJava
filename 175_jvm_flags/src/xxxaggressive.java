public class xxxaggressive {

    // -XXaggressive

    /*
     * -XXaggressive adalah kumpulan konfigurasi yang membuat JVM bekerja dengan
     * kecepatan tinggi dan mencapai keadaan stabil
     * secepat mungkin. Untuk mencapai tujuan ini, JVM menggunakan lebih banyak
     * sumber daya internal saat startup; namun, hal ini memerlukan pengoptimalan
     * yang tidak terlalu adaptif setelah tujuan tercapai. Kami menyarankan Anda
     * menggunakan opsi ini untuk aplikasi yang berjalan lama dan intensif memori
     * yang bekerja sendiri.
     */

    // Penggunaan:
    // -XXaggressive:<param>

    // <param> | Description

    /*
     * opt | Menjadwalkan pengoptimalan adaptif lebih awal dan mengaktifkan
     * pengoptimalan baru, yang diharapkan menjadi default pada rilis mendatang
     * 
     * memory | Mengonfigurasi sistem memori untuk beban kerja intensif memori dan
     * menetapkan ekspektasi untuk mengaktifkan sumber daya memori dalam jumlah
     * besar guna memastikan throughput yang tinggi. JRockit JVM juga akan
     * menggunakan halaman besar, jika tersedia.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
