public class Pitfall_thinking_of_variables_as_objects {
    // Pitfall: thinking of variables as objects/Kesalahan: menganggap variabel
    // sebagai objek

    // Tidak ada variabel Java yang mewakili suatu objek.
    // String foo; // NOT AN OBJECT

    // Array Java juga tidak berisi objek.
    // String bar[] = new String[100]; // No member is an object.

    /*
     * Jika Anda salah mengira variabel sebagai objek, perilaku bahasa Java yang
     * sebenarnya akan mengejutkan Anda
     * 
     * 1. Untuk variabel Java yang bertipe primitif (seperti int atau float),
     * variabel tersebut menyimpan salinan nilainya. Semua salinan dari nilai
     * primitif tidak dapat dibedakan; yaitu hanya ada satu nilai int untuk nomor
     * satu. Nilai-nilai primitif bukanlah objek dan tidak berperilaku seperti
     * objek.
     * 
     * 2. Untuk variabel Java yang memiliki tipe referensi (baik kelas atau tipe
     * array), variabel tersebut menyimpan referensi.
     * Semua salinan referensi tidak dapat dibedakan. Referensi bisa saja menunjuk
     * pada suatu objek, atau mungkin saja null yang berarti tidak menunjuk pada
     * suatu objek. Namun, mereka bukanlah objek dan tidak berperilaku seperti
     * objek.
     */

    /*
     * Variabel bukanlah objek dalam kedua kasus tersebut, dan mereka tidak berisi
     * objek dalam kedua kasus tersebut. Mereka mungkin berisi referensi ke objek,
     * tapi itu mengatakan sesuatu yang berbeda.
     */

    // contoh class
    // Contoh berikut menggunakan kelas ini, yang mewakili sebuah titik dalam ruang
    // 2D.

    /*
     * public final class MutableLocation {
     * public int x;
     * public int y;
     * public MutableLocation(int x, int y) {
     * this.x = x;
     * this.y = y;
     * }
     * public boolean equals(Object other) {
     * if (!(other instanceof MutableLocation) {
     * return false;
     * }
     * MutableLocation that = (MutableLocation) other;
     * return this.x == that.x && this.y == that.y;
     * }
     * }
     */

    /*
     * Instance dari kelas ini adalah sebuah objek yang memiliki dua field x dan y
     * yang bertipe int.
     * 
     * Kita dapat memiliki banyak contoh kelas MutableLocation. Beberapa akan
     * mewakili lokasi yang sama dalam ruang 2D; yaitu nilai x dan y masing-masing
     * akan cocok. Lainnya akan mewakili lokasi yang berbeda.
     */

    // Multiple variables can point to the same object/Beberapa variabel dapat
    // menunjuk ke objek yang sama

    /*
     * MutableLocation here = new MutableLocation(1, 2);
     * MutableLocation there = here;
     * MutableLocation elsewhere = new MutableLocation(1, 2);
     */

    /*
     * Pada contoh di atas, kita telah mendeklarasikan tiga variabel di sini, di
     * sana, dan elsewhere yang dapat dijadikan referensi MutableLocation objects
     */

    // Jika Anda (secara salah) menganggap variabel-variabel ini sebagai objek,
    // kemungkinan besar Anda salah membaca pernyataan yang mengatakan:
    /*
     * 1. Copy the location "[1, 2]" to here
     * 2. Copy the location "[1, 2]" to there
     * 3. Copy the location "[1, 2]" to elsewhere
     */

    /*
     * Dari situ, Anda mungkin menyimpulkan bahwa kita memiliki tiga objek
     * independen dalam tiga variabel. Sebenarnya hanya ada dua objek yang
     * diciptakan di atas. Variabel di sana-sini sebenarnya merujuk pada objek yang
     * sama.
     * 
     * Kita bisa menunjukkan hal ini. Dengan asumsi deklarasi variabel seperti di
     * atas:
     * 
     * System.out.println("BEFORE: here.x is " + here.x + ", there.x is " + there.x
     * +"elsewhere.x is " + elsewhere.x); here.x = 42;
     *
     * System.out.println("AFTER: here.x is " + here.x + ", there.x is " + there.x +
     * "elsewhere.x is " + elsewhere.x);
     */

    // Ini akan menampilkan yang berikut:
    /*
     * BEFORE: here.x is 1, there.x is 1, elsewhere.x is 1
     * AFTER: here.x is 42, there.x is 42, elsewhere.x is 1
     * 
     */

    /*
     * Kami menetapkan nilai baru ke here.x dan itu mengubah nilai yang kami lihat
     * melalui there.x. Mereka mengacu pada objek yang sama. Namun nilai yang kita
     * lihat melalui elsewhere.x tidak berubah, jadi elsewhere harus
     * merujuk ke objek yang berbeda.
     */

    // Jika suatu variabel adalah objek, maka penugasan here.x = 42 tidak akan
    // berubah there.x.

    // The equality operator does NOT test that two objects are equal/Operator
    // kesetaraan TIDAK menguji apakah dua objek adalah sama

    /*
     * Menerapkan operator equality (==) ke nilai referensi akan menguji apakah
     * nilai tersebut merujuk ke objek yang sama. Ini tidak menguji apakah dua objek
     * (berbeda) adalah "equal" dalam pengertian intuitif.
     */

    /*
     * MutableLocation here = new MutableLocation(1, 2);
     * MutableLocation there = here;
     * MutableLocation elsewhere = new MutableLocation(1, 2);
     * if (here == there) {
     * System.out.println("here is there");
     * }
     * if (here == elsewhere) {
     * System.out.println("here is elsewhere");
     * }
     */

    /*
     * Ini akan mencetak "here is theres", tetapi tidak akan mencetak
     * "here is elsewhere". (Referensi di sini dan di tempat lain ditujukan
     * untuk dua objek berbeda.)
     * 
     * Sebaliknya, jika kita memanggil metode equal(Object) yang kita terapkan di
     * atas, kita akan menguji apakah ada dua
     * MutableLocation instances memiliki lokasi yang sama.
     */

    /*
     * if (here.equals(there)) {
     * System.out.println("here equals there");
     * }
     * if (here.equals(elsewhere)) {
     * System.out.println("here equals elsewhere");
     * }
     * 
     */

    /*
     * Ini akan mencetak kedua pesan. Secara khusus, here.equals(elsewhere)
     * mengembalikan nilai true karena kriteria semantik yang kita pilih untuk
     * kesetaraan dua MutableLocation objects telah terpenuhi
     */

    // Method calls do NOT pass objects at all/Pemanggilan metode TIDAK meneruskan
    // objek sama sekali

    /*
     * Pemanggilan metode Java menggunakan pass by value1 untuk meneruskan argumen
     * dan mengembalikan hasil.
     * 
     * Saat Anda meneruskan nilai referensi ke suatu metode, Anda sebenarnya
     * meneruskan referensi ke objek berdasarkan nilai, yang berarti metode tersebut
     * membuat salinan referensi objek.
     * 
     * Selama kedua referensi objek masih menunjuk ke objek yang sama, Anda dapat
     * memodifikasi objek tersebut dari salah satu referensi, dan inilah yang
     * menyebabkan kebingungan bagi sebagian orang.
     * 
     * Namun, Anda tidak meneruskan objek dengan referensi2. Bedanya, jika salinan
     * referensi objek diubah agar menunjuk ke objek lain, maka referensi objek asli
     * akan tetap mengarah ke objek aslinya.
     */

    /*
     * void f(MutableLocation foo) {
     * foo = new MutableLocation(3, 4); // Point local foo at a different object.
     * }
     * void g() {
     * MutableLocation foo = MutableLocation(1, 2);
     * f(foo);
     * System.out.println("foo.x is " + foo.x); // Prints "foo.x is 1"
     * }
     */

    // Anda juga tidak memberikan salinan objek tersebut.
    /*
     * void f(MutableLocation foo) {
     * foo.x = 42;
     * }
     * void g() {
     * MutableLocation foo = new MutableLocation(0, 0);
     * f(foo);
     * System.out.println("foo.x is " + foo.x); // Prints "foo.x is 42"
     * }
     */

    /*
     * 1 - Dalam bahasa seperti Python dan Ruby, istilah "pass by sharing" lebih
     * disukai untuk "pass by value" suatu objek/referensi.
     * 
     * 2 - Istilah "pass by reference" atau "call by reference" memiliki arti yang
     * sangat spesifik dalam terminologi bahasa pemrograman. Artinya, ini berarti
     * Anda meneruskan alamat variabel atau elemen array, sehingga ketika metode
     * yang dipanggil memberikan nilai baru ke argumen formal, metode tersebut akan
     * mengubah nilai variabel asli. Java tidak mendukung ini. Untuk penjelasan
     * lebih lengkap tentang berbagai mekanisme untuk meneruskan parameter, silakan
     * merujuk ke
     * https://en.wikipedia.org/wiki/Evaluation_strategy.
     */

    public static void main(String[] args) {
        MutableLocation here = new MutableLocation(1, 2);
        MutableLocation there = here;
        MutableLocation elsewhere = new MutableLocation(1, 2);

        // System.out.println("BEFORE: here.x is " + here.x + ", there.x is " + there.x
        // +
        // "elsewhere.x is " + elsewhere.x);
        /*
         * output:
         * BEFORE: here.x is 1, there.x is 1elsewhere.x is 1
         */

        // here.x = 42;
        // System.out.println("AFTER: here.x is " + here.x + ", there.x is " + there.x +
        // "elsewhere.x is " + elsewhere.x);
        /*
         * output:
         * AFTER: here.x is 42, there.x is 42elsewhere.x is 1
         */
        // -------------
        // if (here == there) {
        // System.out.println("here is there");
        // }
        // if (here == elsewhere) {
        // System.out.println("here is elsewhere");
        // }
        // output: here is there
        // -------------
        g();
        // output: "foo.x is 1".
    }

    static void f(MutableLocation foo) {
        foo = new MutableLocation(3, 4); // Point local foo at a different object.
    }

    static void g() {
        MutableLocation foo = new MutableLocation(1, 2);
        f(foo);
        System.out.println("foo.x is " + foo.x);
    }

}
