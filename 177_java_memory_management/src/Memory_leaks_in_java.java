public class Memory_leaks_in_java {
    // Memory leaks in Java/Kebocoran memori di Java

    /*
     * Dalam contoh Pengumpulan Sampah, kami menyiratkan bahwa Java memecahkan
     * masalah kebocoran memori. Hal ini sebenarnya tidak benar. Program Java dapat
     * membocorkan memori, meskipun penyebab kebocorannya agak berbeda
     */

    // Reachable objects can leak/Benda yang dapat dijangkau bisa bocor
    // Pertimbangkan implementasi tumpukan naif berikut ini.

    /*
     * public class NaiveStack {
     * private Object[] stack = new Object[100];
     * private int top = 0;
     * public void push(Object obj) {
     * if (top >= stack.length) {
     * throw new StackException("stack overflow");
     * }
     * stack[top++] = obj;
     * }
     * public Object pop() {
     * if (top <= 0) {
     * throw new StackException("stack underflow");
     * }
     * return stack[--top];
     * }
     * public boolean isEmpty() {
     * return top == 0;
     * }
     * }
     */

    /*
     * Saat Anda mendorong suatu objek dan kemudian segera memunculkannya, masih
     * akan ada referensi ke objek tersebut dalam array tumpukan.
     * 
     * Logika implementasi tumpukan berarti bahwa referensi tersebut tidak dapat
     * dikembalikan ke klien API. Jika suatu objek telah muncul maka kita dapat
     * membuktikan bahwa objek tersebut tidak dapat
     * "diakses dalam potensi komputasi berkelanjutan apa pun dari live thread mana pun"
     * . Masalahnya adalah JVM generasi sekarang tidak dapat membuktikan hal ini.
     * JVM generasi saat ini tidak mempertimbangkan logika program dalam menentukan
     * apakah referensi dapat dijangkau. (Sebagai permulaan, ini tidak praktis.)
     * 
     * Namun mengesampingkan isu mengenai arti keterjangkauan sebenarnya, kita jelas
     * mempunyai situasi dimana implementasi NaiveStack "bergantung pada" objek yang
     * seharusnya direklamasi. Itu adalah kebocoran memori. Dalam hal ini, solusinya
     * mudah:
     * 
     * public Object pop() {
     * if (top <= 0) {
     * throw new StackException("stack underflow");
     * }
     * Object popped = stack[--top];
     * stack[top] = null; // Overwrite popped reference with null.
     * return popped;
     * }
     * 
     */

    // Caches can be memory leaks/Cache bisa menjadi kebocoran memori
    /*
     * Strategi umum untuk meningkatkan kinerja layanan adalah dengan menyimpan
     * hasil dalam cache. Idenya adalah Anda menyimpan catatan permintaan umum dan
     * hasilnya dalam struktur data dalam memori yang dikenal sebagai cache.
     * Kemudian, setiap kali permintaan dibuat, Anda mencari permintaan tersebut di
     * cache. Jika pencarian berhasil, Anda mengembalikan hasil tersimpan yang
     * sesuai.
     * 
     * Strategi ini bisa sangat efektif jika diterapkan dengan benar. Namun, jika
     * diterapkan secara tidak benar, cache dapat menyebabkan kebocoran memori.
     * Perhatikan contoh berikut:
     * 
     * public class RequestHandler {
     * private Map<Task, Result> cache = new HashMap<>();
     * public Result doRequest(Task task) {
     * Result result = cache.get(task);
     * if (result == null) {
     * result == doRequestProcessing(task);
     * cache.put(task, result);
     * }
     * return result;
     * }
     * }
     */

    /*
     * Masalah dengan kode ini adalah meskipun panggilan apa pun ke doRequest dapat
     * menambahkan entri baru ke cache, tidak ada yang dapat menghapusnya. Jika
     * layanan terus-menerus mendapatkan tugas yang berbeda, cache pada akhirnya
     * akan menghabiskan semua memori yang tersedia. Ini adalah bentuk kebocoran
     * memori.
     * 
     * Salah satu pendekatan untuk mengatasi hal ini adalah dengan menggunakan cache
     * dengan ukuran maksimum, dan membuang entri lama ketika cache melebihi
     * maksimum. (Membuang entri yang terakhir digunakan adalah strategi yang baik.)
     * Pendekatan lain adalah dengan membangun cache menggunakan WeakHashMap
     * sehingga JVM dapat mengeluarkan entri cache jika heap mulai terlalu penuh.
     */
    public static void main(String[] args) {
        NaiveStack stack = new NaiveStack();

        // Menambahkan elemen ke dalam tumpukan
        stack.push("Elemen 1");
        stack.push("Elemen 2");
        stack.push("Elemen 3");

        // Menghapus elemen dari tumpukan dan menampilkannya
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        // Memeriksa apakah tumpukan kosong
        System.out.println("Is Stack Empty: " + stack.isEmpty());
        /*
         * output:
         * Pop: Elemen 3
         * Pop: Elemen 2
         * Pop: Elemen 1 kspaceStorage\44a01b534d757a977492f8382d1624
         * Is Stack Empty: true
         */
    }
}
