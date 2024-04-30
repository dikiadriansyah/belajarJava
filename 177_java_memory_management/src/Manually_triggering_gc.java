public class Manually_triggering_gc {
    // Manually triggering GC/Memicu GC secara manual

    /*
     * Anda dapat memicu Pengumpul Sampah secara manual dengan menelepon
     * System.gc();
     * 
     * Namun, Java tidak menjamin bahwa Pengumpul Sampah telah berjalan ketika
     * panggilan kembali. Cara ini sederhana saja
     * "menyarankan" ke JVM (Java Virtual Machine) bahwa Anda ingin menjalankan
     * pengumpul sampah, tetapi tidak memaksanya untuk melakukannya.
     */

    /*
     * Secara umum dianggap sebagai praktik buruk jika mencoba memicu pengumpulan
     * sampah secara manual. JVM dapat dijalankan dengan
     * opsi -XX:+DisableExplicitGC untuk menonaktifkan panggilan ke System.gc().
     * Memicu pengumpulan sampah dengan menelepon
     * System.gc() dapat mengganggu aktivitas normal pengelolaan sampah/promosi
     * objek dari sampah tertentu
     * implementasi kolektor yang digunakan oleh JVM.
     */

}
