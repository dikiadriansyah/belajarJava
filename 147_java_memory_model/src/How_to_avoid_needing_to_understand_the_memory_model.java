public class How_to_avoid_needing_to_understand_the_memory_model {
    // How to avoid needing to understand the Memory Model/Bagaimana menghindari
    // kebutuhan untuk memahami Model Memori

    /*
     * Model Memori sulit untuk dipahami, dan sulit untuk diterapkan. Hal ini
     * berguna jika Anda perlu mempertimbangkan kebenaran kode multi-utas, tetapi
     * Anda tidak ingin melakukan alasan ini untuk setiap aplikasi multi-utas yang
     * Anda tulis.
     * 
     * Jika Anda mengadopsi prinsip-prinsip berikut saat menulis kode bersamaan di
     * Java, Anda dapat menghindari kebutuhan untuk menggunakan alasan yang terjadi
     * sebelum.
     */

    /*
     * 1. Gunakan struktur data yang tidak dapat diubah jika memungkinkan. Kelas
     * abadi yang diterapkan dengan benar akan aman untuk thread,
     * dan tidak akan menimbulkan masalah keamanan thread saat Anda menggunakannya
     * dengan kelas lain.
     * 2. Memahami dan menghindari “publikasi yang tidak aman”.
     * 3. Gunakan mutex primitif atau objek Kunci untuk menyinkronkan akses ke
     * status dalam objek yang dapat diubah yang harus aman untuk thread1.
     * 4. Gunakan Executor / ExecutorService atau kerangka kerja gabungan fork
     * daripada mencoba membuat thread pengelolaan secara langsung.
     * 5. Gunakan kelas `java.util.concurrent yang menyediakan kunci, semafor, kait,
     * dan penghalang tingkat lanjut, daripada menggunakan wait/notify/notifyAll
     * secara langsung.
     * 6. Gunakan versi peta, set, daftar, antrian, dan deque java.util.concurrent
     * daripada sinkronisasi eksternal koleksi yang tidak bersamaan.
     */

    /*
     * Prinsip umumnya adalah mencoba menggunakan pustaka konkurensi bawaan Java
     * daripada "menggulirkan konkurensi Anda sendiri".
     * Anda dapat mengandalkannya untuk berfungsi, jika Anda menggunakannya dengan
     * benar.
     * 
     * 1 - Tidak semua objek harus aman untuk thread. Misalnya, jika suatu objek
     * atau beberapa objek dibatasi oleh thread (yaitu hanya
     * dapat diakses oleh satu thread), maka keamanan threadnya tidak relevan.
     */

}
