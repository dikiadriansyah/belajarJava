// public class Builtin_annotations extends Vechile {
// Built-in annotations

/*
 * Edisi Standar Java hadir dengan beberapa anotasi yang telah ditentukan
 * sebelumnya. Anda tidak perlu mendefinisikannya sendiri
 * dan Anda dapat segera menggunakannya. Mereka mengizinkan kompiler untuk
 * mengaktifkan beberapa pemeriksaan mendasar terhadap metode, kelas, dan kode.
 */

// @Override
/*
 * Anotasi ini berlaku untuk suatu metode dan mengatakan bahwa metode ini harus
 * mengesampingkan metode superkelas atau mengimplementasikan definisi metode
 * superkelas abstrak. Jika anotasi ini digunakan dengan metode lain apa pun,
 * kompiler akan memunculkan kesalahan.
 */

// Concrete superclass

// Fine
// @Override
// public void drive() {
// System.out.println("Brrrm, brrm");
// }

// public static void main(String[] args) {
// Builtin_annotations box1 = new Builtin_annotations();
// box1.drive(); // Brrrm, brrm

// }
// }

// public class Builtin_annotations extends Animal {
// Fine
// @Override
// public void makeNoise() {
// System.out.println("Woof");
// }

// public static void main(String[] args) {
// Builtin_annotations box2 = new Builtin_annotations();
// box2.makeNoise(); // Woof

// ------------------
// box2.log();
// ------------------
// box2.oldSlowUnthreadSafeMethod();
// box2.quickThreadSafeMethod();
/*
 * output:
 * Old slow unthread-safe method
 * Quick thread-safe method
 */

// -----------------
// Menggunakan lambda expression untuk implementasi antarmuka ITrade
// ITrade tradeChecker = trade -> trade.getPrice() > 100.0;

// Contoh penggunaan
// Trade highPriceTrade = new Trade("ABC", 150.0);
// Trade lowPriceTrade = new Trade("XYZ", 80.0);

// System.out.println("High price trade: " +
// tradeChecker.check(highPriceTrade));
// System.out.println("Low price trade: " + tradeChecker.check(lowPriceTrade));
/*
 * output:
 * High price trade: true
 * Low price trade: false
 */
// }

// Tidak bekerja
// public void log(String logString) {
// System.out.println(logString);
// }

// ---------------------
// Ini akan menimbulkan kesalahan waktu kompilasi. Logger2 bukan subkelas dari
// Logger1.
// metode log tidak mengesampingkan apa pun

// @Override
// public void log(String logString) {
// System.out.println("Log 2" + logString);
// }

/*
 * Tujuan utamanya adalah untuk menangkap kesalahan ketik, yang mana Anda
 * berpikir Anda mengganti suatu metode, namun sebenarnya mendefinisikan metode
 * baru.
 */

// Compiler error. "dirve" is not the correct method name to override.
// @Override
// public void dirve() {
// System.out.prinln("Brrrm, brrm");
// }

// Perhatikan bahwa arti @Override telah berubah seiring waktu:
/*
 * 1. Di Java 5, ini berarti metode yang dianotasi harus mengganti metode
 * non-abstrak yang dideklarasikan di
 * rantai superkelas.
 * 
 * 2. Mulai Java 6 dan seterusnya, juga terpenuhi jika metode beranotasi
 * mengimplementasikan metode abstrak yang dideklarasikan
 * kelas superclass/hierarki antarmuka.
 */

// (Hal ini terkadang dapat menyebabkan masalah saat melakukan back-porting kode
// ke Java 5.)

// @Deprecated
/*
 * Ini menandai metode tersebut sebagai tidak digunakan lagi. Ada beberapa
 * alasan untuk hal ini:
 * 1.API ini cacat dan tidak praktis untuk diperbaiki
 * 2. penggunaan API kemungkinan besar akan menyebabkan kesalahan
 * 3. API telah digantikan oleh API lain,
 * 4. API sudah usang,
 * 5.API bersifat eksperimental dan dapat mengalami perubahan yang tidak
 * kompatibel,
 * 6. atau kombinasi apa pun di atas.
 * 
 * Alasan spesifik penghentian biasanya dapat ditemukan dalam dokumentasi API.
 * 
 * Anotasi akan menyebabkan kompiler mengeluarkan kesalahan jika Anda
 * menggunakannya. IDE mungkin juga menyoroti metode ini sebagai metode yang
 * tidak digunakan lagi
 * 
 */

// public void oldSlowUnthreadSafeMethod() {
// // stuff here
// System.out.println("Old slow unthread-safe method");
// }

// public void quickThreadSafeMethod() {
// // client code should use this instead
// System.out.println("Quick thread-safe method");
// }

// @SuppressWarnings
/*
 * Di hampir semua kasus, ketika kompiler mengeluarkan peringatan, tindakan yang
 * paling tepat adalah memperbaiki penyebabnya. Dalam beberapa kasus (kode
 * generik menggunakan kode pra-generik yang tidak aman untuk diketik, misalnya)
 * hal ini mungkin tidak dapat dilakukan dan lebih baik untuk menyembunyikan
 * peringatan yang Anda harapkan dan tidak dapat diperbaiki, sehingga Anda dapat
 * melihat peringatan yang tidak terduga dengan lebih jelas.
 * 
 * Anotasi ini dapat diterapkan ke seluruh kelas, metode, atau baris. Dibutuhkan
 * kategori peringatan sebagai parameter.
 * 
 * @SuppressWarnings("deprecation")
 * public class RiddledWithWarnings {
 * // several methods calling deprecated code here
 * }
 * 
 * @SuppressWarning("finally")
 * public boolean checkData() {
 * // method calling return from within finally block
 * }
 */

/*
 * Sebaiknya batasi cakupan anotasi sebanyak mungkin, untuk mencegah peringatan
 * yang tidak terduga juga disembunyikan. Misalnya, membatasi cakupan anotasi
 * menjadi satu baris:
 * ComplexAlgorithm algorithm = new ComplexAlgorithm();
 * 
 * @SuppressWarnings("deprecation") algoritm.slowUnthreadSafeMethod();
 * // kami menandai metode ini tidak digunakan lagi dalam contoh di atas
 * 
 * @SuppressWarnings("unsafe") List<Integer> list = getUntypeSafeList();
 * // perpustakaan lama kembali, Daftar non-generik hanya berisi bilangan bulat
 * 
 * Peringatan yang didukung oleh anotasi ini mungkin berbeda dari satu kompiler
 * ke kompiler lainnya. Hanya yang tidak dicentang dan
 * peringatan penghentian secara khusus disebutkan di JLS. Jenis peringatan yang
 * tidak dikenal akan diabaikan.
 * 
 */

// @SafeVarargs
/*
 * Karena penghapusan tipe, void method(T... t) akan dikonversi menjadi void
 * method(Object[] t) yang berarti kompiler tidak selalu dapat memverifikasi
 * bahwa penggunaan varargs aman untuk tipe. Contohnya:
 * private static <T> void generatesVarargsWarning(T... lists) {
 */

/*
 * Ada beberapa contoh di mana penggunaannya aman, dalam hal ini Anda dapat
 * memberi anotasi pada metode ini dengan SafeVarargs
 * anotasi untuk menyembunyikan peringatan. Ini jelas menyembunyikan peringatan
 * jika penggunaan Anda juga tidak aman.
 */

// @FunctionalInterface
/*
 * Ini adalah anotasi opsional yang digunakan untuk menandai Antarmuka
 * Fungsional. Ini akan menyebabkan kompiler mengeluh jika tidak sesuai dengan
 * spesifikasi FunctionalInterface (memiliki satu metode abstrak)
 */

// @FunctionalInterface
// public interface ITrade {
// public boolean check(Trade t);
// }

// @FunctionalInterface
// public interface Predicate<T> {
// boolean test(T t);
// }
// }
