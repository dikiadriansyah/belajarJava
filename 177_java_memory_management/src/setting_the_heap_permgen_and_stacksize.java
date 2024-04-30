public class setting_the_heap_permgen_and_stacksize {
    // Setting the Heap, PermGen and Stack sizes/Mengatur ukuran Heap, PermGen dan
    // Stack

    /*
     * Saat mesin virtual Java dimulai, ia perlu mengetahui seberapa besar pembuatan
     * Heap, dan ukuran default untuk thread
     * tumpukan. Ini dapat ditentukan menggunakan opsi baris perintah pada perintah
     * java. Untuk versi Java sebelum Java 8, Anda juga dapat menentukan ukuran
     * wilayah PermGen di Heap.
     * 
     * Perhatikan bahwa PermGen telah dihapus di Java 8, dan jika Anda mencoba
     * mengatur ukuran PermGen, opsi tersebut akan diabaikan
     * (dengan pesan peringatan).
     * 
     * Jika Anda tidak menentukan ukuran Heap dan Stack secara eksplisit, JVM akan
     * menggunakan default yang dihitung dalam versi dan
     * cara khusus platform. Hal ini dapat mengakibatkan aplikasi Anda menggunakan
     * terlalu sedikit atau terlalu banyak memori. Ini biasanya OK untuk tumpukan
     * thread, namun bisa menjadi masalah untuk program yang menggunakan banyak
     * memori.
     */

    // Setting the Heap, PermGen and default Stack sizes/Mengatur ukuran Heap,
    // PermGen dan Stack default:

    // Opsi JVM berikut mengatur ukuran heap:

    /*
     * -Xms<size> - sets the initial heap size
     * -Xmx<size> - sets the maximum heap size
     * -XX:PermSize<size> - sets the initial PermGen size
     * -XX:MaxPermSize<size> - sets the maximum PermGen size
     * -Xss<size> - sets the default thread stack size
     */

    /*
     * Parameter <size> dapat berupa sejumlah byte, atau dapat memiliki akhiran k,
     * m, atau g. Yang terakhir menentukan ukurannya masing-masing dalam kilobyte,
     * megabyte dan gigabyte.
     * 
     * contoh:
     * $ java -Xms512m -Xmx1024m JavaApp
     * $ java -XX:PermSize=64m -XX:MaxPermSize=128m JavaApp
     * $ java -Xss512k JavaApp
     */

    // Menemukan ukuran default:
    /*
     * Opsi -XX:+printFlagsFinal dapat digunakan untuk mencetak nilai semua flag
     * sebelum memulai JVM. Ini dapat digunakan untuk mencetak default untuk
     * pengaturan heap dan ukuran tumpukan sebagai berikut:
     * 
     * Untuk Linux, Unix, Solaris dan Mac OSX
     * $ java -XX:+PrintFlagsFinal -version | grep -iE
     * 'HeapSize|PermSize|ThreadStackSize'
     * 
     * untuk windows
     * java -XX:+PrintFlagsFinal -version | findstr /i
     * "HeapSize PermSize ThreadStackSize"
     * 
     */

    // Output dari perintah di atas akan menyerupai berikut ini:

    /*
     * uintx InitialHeapSize := 20655360 {product}
     * uintx MaxHeapSize := 331350016 {product}
     * uintx PermSize = 21757952 {pd product}
     * uintx MaxPermSize = 85983232 {pd product}
     * intx ThreadStackSize = 1024 {pd product}
     */

    // Ukuran diberikan dalam byte.

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
