public class Anonymous_inner_classes {
    // Anonymous Inner Classes/ Kelas Dalam Anonim

    /*
     * Kelas dalam anonim adalah bentuk kelas dalam yang dideklarasikan dan dipakai
     * dengan satu pernyataan. Akibatnya, tidak ada nama kelas yang dapat digunakan
     * di tempat lain dalam program; yaitu anonim.
     * 
     * Kelas anonim biasanya digunakan dalam situasi di mana Anda harus bisa membuat
     * kelas ringan untuk diteruskan sebagai parameter. Ini biasanya dilakukan
     * dengan antarmuka. Misalnya:
     * 
     * public static Comparator<String> CASE_INSENSITIVE =
     * new Comparator<String>() {
     * 
     * @Override
     * public int compare(String string1, String string2) {
     * return string1.toUpperCase().compareTo(string2.toUpperCase());
     * }
     * };
     */

    /*
     * Kelas anonim ini mendefinisikan objek Comparator<String> (CASE_INSENSITIVE)
     * yang membandingkan dua string dengan mengabaikan perbedaan huruf besar-kecil.
     * Antarmuka lain yang sering diimplementasikan dan dipakai menggunakan kelas
     * anonim adalah Runnable dan Callable. Misalnya:
     * 
     */

    /*
     * // An anonymous Runnable class is used to provide an instance that the Thread
     * // will run when started.
     * Thread t = new Thread(new Runnable() {
     * 
     * @Override
     * public void run() {
     * System.out.println("Hello world");
     * }
     * });
     * t.start(); // Prints "Hello world"
     * 
     */

    /*
     * Kelas dalam anonim juga dapat didasarkan pada kelas. Dalam hal ini, kelas
     * anonim secara implisit memperluas
     * kelas yang ada. Jika kelas yang diperluas adalah kelas abstrak, maka kelas
     * anonim harus mengimplementasikan semua metode abstrak. Ini juga dapat
     * mengesampingkan metode non-abstrak.
     */

    // Constructors
    /*
     * Kelas anonim tidak boleh memiliki konstruktor eksplisit. Sebaliknya,
     * konstruktor implisit didefinisikan menggunakan
     * super(...) untuk meneruskan parameter apa pun ke konstruktor di kelas yang
     * sedang diperluas. Misalnya:
     * SomeClass anon = new SomeClass(1, "happiness") {
     * 
     * @Override
     * public int someMethod(int arg) {
     * // do something
     * }
     * };
     */

    /*
     * Konstruktor implisit untuk subkelas SomeClass anonim kita akan memanggil
     * konstruktor SomeClass yang cocok
     * tanda tangan panggilan SomeClass(int, String). Jika tidak ada konstruktor
     * yang tersedia, Anda akan mendapatkan kesalahan kompilasi. Pengecualian apa
     * pun yang diberikan oleh konstruktor yang cocok juga akan diberikan oleh
     * konstruktor implisit.
     * 
     * Tentu saja, ini tidak berfungsi saat memperluas antarmuka. Saat Anda membuat
     * kelas anonim dari interface,
     * kelas superkelasnya adalah java.lang.Object yang hanya memiliki konstruktor
     * tanpa argumen.
     */

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        });
        t.start();
        // output:
        // Hello world
    }
}
