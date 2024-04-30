public class An_evidence_based_approach_to_java_perfforamance_tuning {
    // An evidence-based approach to Java performance tuning/Pendekatan berbasis
    // bukti untuk Java penyetelan kinerja

    // Donald Knuth sering dikutip mengatakan ini:

    /*
     * “Pemrogram membuang banyak waktu untuk memikirkan, atau mengkhawatirkan,
     * kecepatan bagian-bagian yang tidak penting dari program mereka, dan upaya
     * efisiensi ini sebenarnya mempunyai dampak negatif yang kuat.
     * dampak ketika debugging dan pemeliharaan dipertimbangkan. Kita harus
     * melupakan efisiensi kecil, katakanlah sekitar 97%: optimasi prematur adalah
     * akar dari segala kejahatan. Namun kita tidak boleh melewatkan peluang kita
     * dalam kondisi kritis 3% itu."
     */

    // sumber

    /*
     * Dengan mengingat nasihat bijak tersebut, berikut adalah prosedur yang
     * disarankan untuk mengoptimalkan program:
     * 1. Pertama-tama, rancang dan kodekan program atau perpustakaan Anda dengan
     * fokus pada kesederhanaan dan kebenaran. Memulai dengan,
     * jangan menghabiskan banyak usaha pada kinerja.
     * 2. Membuatnya berfungsi, dan (idealnya) mengembangkan pengujian unit untuk
     * bagian-bagian penting dari basis kode.
     * 3. Mengembangkan tolok ukur kinerja tingkat aplikasi. Tolok ukurnya harus
     * mencakup kinerja penting
     * aspek aplikasi Anda, dan harus melakukan serangkaian tugas yang umum
     * dilakukan aplikasi
     * digunakan dalam produksi.
     * 4. Ukur kinerjanya.
     * 5. Bandingkan kinerja yang diukur dengan kriteria Anda mengenai seberapa
     * cepat aplikasi yang dibutuhkan. (Menghindari
     * kriteria yang tidak realistis, tidak dapat dicapai atau tidak dapat diukur
     * seperti "secepat mungkin".)
     * 6. Jika sudah memenuhi kriteria, STOP. Pekerjaanmu sudah selesai. (Upaya
     * lebih lanjut apa pun mungkin hanya membuang-buang waktu.)
     * 7. Profil aplikasi saat sedang menjalankan benchmark kinerja Anda.
     * 8. Periksa hasil pembuatan profil dan pilih "hotspot kinerja" terbesar (yang
     * belum dioptimalkan); yaitu bagian dari
     * kode tempat aplikasi tampaknya menghabiskan sebagian besar waktunya.
     * 9. Analisis bagian kode hotspot untuk mencoba memahami mengapa hal tersebut
     * menjadi hambatan, dan pikirkan cara untuk mengatasinya
     * lebih cepat.
     * 10. Terapkan itu sebagai perubahan kode yang diusulkan, uji dan debug.
     * 11. Jalankan kembali benchmark untuk melihat apakah perubahan kode telah
     * meningkatkan kinerja:
     * A. Jika Ya, kembali ke langkah 4.
     * B. Jika Tidak, tinggalkan perubahan dan kembali ke langkah 9. Jika Anda tidak
     * membuat kemajuan, pilih hotspot lain untuk Anda perhatikan.
     */

    /*
     * Pada akhirnya Anda akan sampai pada titik di mana aplikasi cukup cepat, atau
     * Anda telah mempertimbangkan semua hotspot yang signifikan. Pada titik ini
     * Anda perlu menghentikan pendekatan ini. Jika suatu bagian kode memakan
     * (katakanlah) 1% dari keseluruhan waktu, maka peningkatan 50% pun hanya akan
     * membuat aplikasi 0,5% lebih cepat secara keseluruhan.
     * 
     * Tentu saja, ada titik di mana optimalisasi hotspot hanya merupakan upaya yang
     * sia-sia. Jika Anda sampai pada titik itu, Anda perlu mengambil pendekatan
     * yang lebih radikal. Misalnya:
     * 1. Lihatlah kompleksitas algoritmik dari algoritma inti Anda.
     * 2. Jika aplikasi menghabiskan banyak waktu untuk mengumpulkan sampah, carilah
     * cara untuk mengurangi laju pembuatan objek.
     * 3. Jika bagian penting dari aplikasi membutuhkan banyak CPU dan
     * single-thread, carilah peluang untuk paralelisme.
     * 4. Jika aplikasi sudah multi-threaded, carilah hambatan konkurensi.
     */

    // Namun jika memungkinkan, andalkan alat dan pengukuran daripada naluri untuk
    // mengarahkan upaya pengoptimalan Anda.

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
