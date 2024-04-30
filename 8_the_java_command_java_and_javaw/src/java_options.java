public class java_options {
    // Java Options / pilihan java

    // Perintah java mendukung berbagai opsi:
    // - All options start with a single hyphen or minus-sign (-): the GNU/Linux
    // convention of using -- for "long" options is not supported. / semua opsi
    // dimulai dengan 1 tanda hubung atau tanda minus(-): konversi penggunaan
    // GNU/Linux -- untuk opsi "long" tidak didukung.

    // - Options must appear before the <classname> or the -jar <jarfile> argument
    // to be recognized. Any arguments after them will be treated as arguments to be
    // passed to Java app that is being run. / opsi harus muncul sebelum argumen
    // <classname> atau -jar<jarfile> agar dikenali. Argumen apa pun setelahnya akan
    // diperlakukan sebagai argumen untuk diteruskan ke aplikasi Java yang sedang
    // dijalankan

    // - Options that do not start with -X or -XX are standard options. You can rely
    // on all Java implementations1 to support any standard option. / Opsi yang
    // tidak dimulai dengan -X atau -XX adalah opsi standar. anda dapat mengandalkan
    // semua java implementation1 untuk mendukung opsi standar apapun.

    // - Options that start with -X are non-standard options, and may be withdrawn
    // from one Java version to the next. / Opsi yang dimulai dengan -X adalah opsi
    // non-standar, dan dapat ditarik dari satu versi Java ke versi berikutnya.

    // - Options that start with -XX are advanced options, and may also be
    // withdrawn. / Opsi yang dimulai dengan -XX adalah opsi lanjutan, dan juga
    // dapat ditarik.

    // Setting system properties with -D / Mengatur properti sistem dengan -D
    // Opsi -D<property>=<value> digunakan untuk mengatur properti di objek System
    // Properties. Parameter ini bisa diulang untuk mengatur properti yang berbeda

    // Memory, Stack and Garbage Collector options / Opsi Memori, Tumpukan, dan
    // Pengumpul Sampah
    // Opsi utama untuk mengontrol ukuran heap dan stack didokumentasikan dalam
    // Mengatur ukuran Heap, PermGen, dan Stack. (Catatan editor: Opsi Pengumpul
    // Sampah harus dijelaskan dalam topik yang sama.)

    // Enabling and disabling assertions/ Mengaktifkan dan menonaktifkan pernyataan
    // opsi -ea dan -da masing-masing mengaktifkan dan menonaktifkan pemeriksaan
    // pernyataan Java:
    // - All assertion checking is disabled by default. / Semua pemeriksaan
    // pernyataan dinonaktifkan secara default.

    // - The -ea option enables checking of all assertions / Opsi -ea memungkinkan
    // pemeriksaan semua pernyataan

    // - The -ea:<packagename>... enables checking of assertions in a package and
    // all subpackages. / -ea:<packagename>... memungkinkan pemeriksaan pernyataan
    // dalam sebuah paket dan semua sub-paket

    // - The -ea:<classname>... enables checking of assertions in a class. /
    // -ea:<classname>... memungkinkan pemeriksaan pernyataan di kelas

    // - The -da option disables checking of all assertions / Opsi -da menonaktifkan
    // pemeriksaan semua pernyataan

    // - The -da:<packagename>... disables checking of assertions in a package and
    // all subpackages. / -da:<packagename>... menonaktifkan pemeriksaan pernyataan
    // dalam paket dan semua subpaket.

    // - The -da:<classname>... disables checking of assertions in a class. /
    // -da:<classname>... menonaktifkan pemeriksaan pernyataan di kelas.

    // - The -esa option enables checking for all system classes. / Opsi -esa
    // memungkinkan pemeriksaan untuk semua kelas sistem.

    // - The -dsa option disables checking for all system classes. / Opsi -dsa
    // menonaktifkan pemeriksaan untuk semua kelas sistem.

    // Pilihannya bisa digabungkan. Sebagai contoh.
    // $ # Enable all assertion checking in non-system classes
    // $ java -ea -dsa MyApp
    // $ # Enable assertions for all classes in a package except for one.
    // $ java -ea:com.wombat.fruitbat... -da:com.wombat.fruitbat.Brickbat MyApp

    // Perhatikan bahwa mengaktifkan pemeriksaan pernyataan dapat mengubah perilaku
    // pemrograman Java.
    // - It is liable make the application slower in general. / Ini bertanggung
    // jawab membuat aplikasi lebih lambat secara umum.
    // - It can cause specific methods to take longer to run, which could change
    // timing of threads in a multi-threaded application. / Ini dapat menyebabkan
    // metode tertentu membutuhkan waktu lebih lama untuk dijalankan, yang dapat
    // mengubah waktu utas dalam aplikasi multi-threaded.
    // - It can introduce serendipitous happens-before relations which can cause
    // memory anomalies to disappear. / Ini dapat memperkenalkan hubungan yang
    // terjadi sebelumnya secara kebetulan yang dapat menyebabkan anomali memori
    // menghilang.
    // - An incorrectly implemented assert statement could have unwanted
    // side-effects. / Pernyataan penegasan yang diterapkan secara tidak benar dapat
    // menimbulkan efek samping yang tidak diinginkan.

    // Selecting the VM type / Memilih jenis VM
    // opsi -client dan -server memungkinkan Anda memilih di antara dua bentuk VM
    // HotSpot yang berbeda:
    // -The "client" form is tuned for user applications and offers faster startup.
    // / Formulir "klien" disetel untuk aplikasi pengguna dan menawarkan pengaktifan
    // yang lebih cepat.

    // - The "server" form is tuned for long running applications. It takes longer
    // capturing statistic during JVM "warm up" which allows the JIT compiler to do
    // a better of job of optimizing the native code. / Formulir "server" disetel
    // untuk aplikasi yang berjalan lama. Dibutuhkan waktu lebih lama untuk
    // menangkap statistik selama "pemanasan" JVM yang memungkinkan kompiler JIT
    // melakukan pekerjaan yang lebih baik dalam mengoptimalkan kode asli.

    // Secara default, JVM akan berjalan dalam mode 64bit jika memungkinkan,
    // bergantung pada kemampuan platform. Opsi -d32 dan -d64 memungkinkan Anda
    // memilih mode secara eksplisit.

    // 1 - Periksa manual resmi untuk perintah java. Terkadang opsi standar
    // digambarkan sebagai "tunduk pada mengubah".

}
