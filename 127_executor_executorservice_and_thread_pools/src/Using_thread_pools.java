public class Using_thread_pools {
    // Using Thread Pools/Menggunakan kumpulan benang

    /*
     * Kolam utas digunakan sebagian besar metode panggilan di ExecutorService.
     * 
     * Metode berikut dapat digunakan untuk mengirimkan pekerjaan untuk dieksekusi:
     */

    // Method | Description
    // submit | Mengeksekusi pekerjaan yang dikirimkan dan mengembalikan masa depan
    // yang dapat digunakan untuk mendapatkan hasilnya
    // execute | Jalankan tugas di masa depan tanpa mendapatkan nilai pengembalian
    // invokeAll | Jalankan daftar tugas dan kembalikan daftar futures
    // invokeAny | Mengeksekusi semua tetapi hanya mengembalikan hasil yang telah
    // berhasil (tanpa kecuali)

    /*
     * Setelah selesai dengan kumpulan utas, Anda dapat memanggil shutdown () untuk
     * mengakhiri kumpulan utas. Ini mengeksekusi semua tugas yang tertunda. Untuk
     * menunggu semua tugas untuk dieksekusi, Anda dapat mengulangi Awaitterminasi
     * atau Isshutdown().
     */

    public static void main(String[] args) throws Exception {
    }
}
