public class Happens_before_reasoning_applied_to_same_examples {
    // Happens-before reasoning applied to some examples/Terjadi-sebelum penalaran
    // diterapkan pada beberapa contoh

    /*
     * Kami akan menyajikan beberapa contoh untuk menunjukkan bagaimana menerapkan
     * penalaran yang terjadi-sebelum untuk memeriksa bahwa penulisan dapat dilihat
     * oleh pembacaan berikutnya.
     */

    // Single-threaded code/Kode utas tunggal

    /*
     * Seperti yang Anda harapkan, penulisan selalu terlihat oleh pembacaan
     * berikutnya dalam program single-thread.
     */

    /*
     * public class SingleThreadExample {
     * public int a, b;
     * 
     * public int add() {
     * a = 1; // write(a)
     * b = 2; // write(b)
     * return a + b; // read(a) followed by read(b)
     * }
     * }
     */

    // Oleh Terjadi-Sebelum Aturan #1:
    /*
     * 1. Tindakan write(a) terjadi happens-before write(b).
     * 2. Tindakan write(b) terjadi happens-before read(a).
     * 3. Tindakan read(a) terjadi-happens-before read(a).
     */

    // Oleh Terjadi-Sebelum Aturan #4:
    /*
     * 4. write(a) happens-before write(b) AND write(b) terjadi-sebelum
     * membaca(a) TERSURAT menulis(a) terjadi-sebelum membaca(a).
     * 5. write(b) happens-before read(a) AND read(a) terjadi-sebelum
     * membaca(b) TERSURAT menulis(b) terjadi-sebelum membaca(b).
     * 
     * Menyimpulkan:
     * 6. Relasi write(a) happens-before read(a) berarti bahwa pernyataan a + b
     * dijamin akan melihat nilai a yang benar.
     * 7. Relasi write(b) happens-before read(b) berarti bahwa pernyataan a + b
     * dijamin akan melihat nilai b yang benar.
     */

    // Behavior of 'volatile' in an example with 2 threads/Perilaku 'volatile' dalam
    // contoh dengan 2 thread

    /*
     * Kita akan menggunakan contoh kode berikut untuk mengeksplorasi beberapa
     * implikasi Model Memori untuk `volatile
     */

    /*
     * public class VolatileExample {
     * private volatile int a;
     * private int b; // NOT volatile
     * 
     * public void update(int first, int second) {
     * b = first; // write(b)
     * a = second; // write-volatile(a)
     * }
     * public int observe() {
     * return a + b; // read-volatile(a) followed by read(b)
     * }
     * }
     */

    /*
     * Pertama, perhatikan urutan pernyataan berikut yang melibatkan 2 thread:
     * 1. Satu contoh VolatileExample dibuat; sebut saja sudah,
     * 2. ve.update(1, 2) dipanggil dalam satu thread, dan
     * 3. ve.observe() dipanggil di thread lain.
     * 
     * Oleh Terjadi-Sebelum Aturan #1:
     * 1. Tindakan tulis(a) terjadi sebelum tindakan volatil-tulis(a).
     * 2. Tindakan volatil-baca(a) terjadi sebelum tindakan baca(b).
     * 
     * Oleh Terjadi-Sebelum Aturan #2:
     * 3. Tindakan volatil-tulis(a) di thread pertama terjadi sebelum tindakan
     * volatil-baca(a) di thread kedua
     * benang.
     * 
     * Oleh Terjadi-Sebelum Aturan #4:
     * 4. Tindakan tulis(b) di thread pertama terjadi sebelum tindakan baca(b) di
     * thread kedua.
     * 
     * Dengan kata lain, untuk urutan khusus ini, kami dijamin bahwa thread ke-2
     * akan melihat pembaruan pada variabel nonvolatile b yang dilakukan oleh thread
     * pertama. Namun, juga harus jelas bahwa jika tugas di update
     * metodenya sebaliknya, atau metode observasi() membaca variabel b sebelum a,
     * lalu terjadi sebelumnya
     * rantai akan putus. Rantai juga akan putus jika volatil-read(a) di thread
     * kedua tidak
     * di sebelah volatil-write(a) di thread pertama.
     * 
     * Ketika rantai putus, tidak ada jaminan bahwa observasi() akan melihat nilai b
     * yang benar.
     */

    // Volatile with three threads/Volatile with three threads
    /*
     * Misalkan kita menambahkan thread ketiga ke dalam contoh sebelumnya:
     * 1. Satu contoh VolatileExample dibuat; sebut saja sudah,
     * 2. Pembaruan panggilan dua utas:
     * ve.update(1, 2) dipanggil dalam satu thread,
     * ve.update(3, 4) dipanggil di thread kedua,
     * 3. ve.observe() selanjutnya dipanggil di thread ketiga.
     */

    /*
     * Untuk menganalisa hal ini secara menyeluruh, kita perlu mempertimbangkan
     * semua kemungkinan interleaving dari pernyataan-pernyataan di thread satu
     * dan benang dua. Sebaliknya, kami hanya akan membahas dua di antaranya.
     * 
     * Skenario #1 - misalkan update(1, 2) mendahului update(3,4) kita mendapatkan
     * urutan ini:
     * 
     * write(b, 1), write-volatile(a, 2) // first thread
     * write(b, 3), write-volatile(a, 4) // second thread
     * read-volatile(a), read(b) // third thread
     */

    /*
     * Dalam hal ini, mudah untuk melihat bahwa ada rantai terjadi-sebelum yang
     * tidak terputus dari write(b, 3) ke read(b).
     * Selain itu tidak ada intervensi menulis ke b. Jadi, untuk skenario ini,
     * thread ketiga dijamin melihat b memiliki nilai 3.
     */

    /*
     * Skenario #2 - misalkan update(1, 2) dan update(3,4) tumpang tindih dan asinya
     * disisipkan sebagai berikut:
     * 
     * write(b, 3) // second thread
     * write(b, 1) // first thread
     * write-volatile(a, 2) // first thread
     * write-volatile(a, 4) // second thread
     * read-volatile(a), read(b) // third thread
     * 
     */

    /*
     * Sekarang, meskipun terdapat rantai kejadian-sebelum dari write(b, 3) ke
     * read(b), terdapat intervensi write(b, 1)
     * tindakan yang dilakukan oleh thread lainnya. Ini berarti kita tidak dapat
     * memastikan nilai read(b) mana yang akan dilihat.
     * 
     * (Selain itu: Hal ini menunjukkan bahwa kita tidak dapat mengandalkan variabel
     * volatile untuk memastikan visibilitas variabel non-volatile, kecuali dalam
     * situasi yang sangat terbatas.)
     */

    public static void main(String[] args) throws Exception {

    }
}