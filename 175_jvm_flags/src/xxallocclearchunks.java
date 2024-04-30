public class xxallocclearchunks {
    // -XXallocClearChunks

    /*
     * Opsi ini memungkinkan Anda menghapus TLA untuk referensi dan nilai pada waktu
     * alokasi TLA dan mengambil potongan berikutnya terlebih dahulu.
     * Ketika bilangan bulat, referensi, atau apa pun dideklarasikan, nilai
     * defaultnya adalah 0 atau null (tergantung pada jenisnya).
     * Pada saat yang tepat, Anda perlu menghapus referensi dan nilai ini untuk
     * mengosongkan memori di heap sehingga Java dapat menggunakan- atau
     * menggunakannya kembali. Anda dapat melakukannya saat objek dialokasikan atau,
     * dengan menggunakan opsi ini, saat Anda meminta TLA baru.
     */

    // gunakan:
    /*
     * -XXallocClearChunks
     * -XXallocClearChunks=<true | false>
     */

    /*
     * Opsi di atas adalah opsi boolean dan umumnya direkomendasikan pada sistem
     * IA64; pada akhirnya, penggunaannya bergantung pada aplikasinya. Jika Anda
     * ingin mengatur ukuran bongkahan yang dibersihkan, gabungkan opsi ini dengan
     * -XXallocClearChunkSize. Jika Anda menggunakan tanda ini tetapi tidak
     * menentukan nilai boolean, nilai defaultnya adalah true.
     */

}
