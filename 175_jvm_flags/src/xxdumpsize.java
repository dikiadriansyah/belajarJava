public class xxdumpsize {
    // xxdumpsize

    /*
     * Opsi ini menyebabkan file dump dibuat dan memungkinkan Anda menentukan ukuran
     * relatif file tersebut (yaitu, kecil, sedang, atau besar).
     * Penggunaan:
     * 
     * -XXdumpsize:<size>
     * 
     */

    /*
     * <size> | Description
     * none Tidak menghasilkan file dump.
     * small | Di Windows, file dump kecil dibuat (di Linux, dump inti lengkap
     * dibuat). Sebuah dump kecil hanya menyertakan tumpukan thread termasuk
     * jejaknya dan sedikit lainnya. Ini adalah default di JRockit JVM 8.1 dengan
     * paket layanan 1 dan 2, serta 7.0 dengan paket layanan 3 dan lebih tinggi).
     * normal | Menyebabkan dump normal dihasilkan di semua platform. File dump ini
     * mencakup semua memori kecuali java heap. Ini adalah nilai default untuk
     * JRockit JVM 1.4.2 dan yang lebih baru
     * large | Mencakup semua yang ada di memori, termasuk heap Java. Opsi ini
     * menjadikan -XXdumpSize setara dengan -XXdumpFullState.
     * 
     */

}
