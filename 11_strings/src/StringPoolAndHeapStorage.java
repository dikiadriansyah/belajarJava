public class StringPoolAndHeapStorage {
    public static void main(String[] args) {
        // Seperti banyak objek Java, semua instance String dibuat di heap, bahkan
        // literal. Ketika JVM menemukan sebuah String literal yang tidak memiliki
        // referensi setara di heap, JVM membuat instance
        // String yang sesuai di heap dan itu juga menyimpan referensi ke instance
        // String yang baru dibuat di kumpulan String. Referensi lain untuk
        // String literal yang sama diganti dengan instance String yang dibuat
        // sebelumnya di heap.

        // Mari kita lihat contoh berikut:
        String perkenalan = "selamat";
        String perkenalan2 = "selamat";
        String perkenalan3 = new String("selamat");

        // All three strings are equivalent
        System.out.println(perkenalan.equals(perkenalan2) && perkenalan2.equals(perkenalan3)); // true

        // Although only a and b reference the same heap object
        System.out.println(perkenalan == perkenalan2); // true
        System.out.println(perkenalan != perkenalan3); // true
        System.out.println(perkenalan2 != perkenalan3); // true
        System.out.println(perkenalan == perkenalan3); // false

        // Saat kita menggunakan tanda kutip ganda untuk membuat sebuah String,
        // pertama-tama ia mencari String dengan nilai yang sama di kumpulan String,
        // jika ditemukan hanya mengembalikan referensi yang lain itu membuat String
        // baru di kumpulan dan kemudian mengembalikan referensi.

        // Namun menggunakan new operator, kami memaksa kelas String untuk membuat
        // objek String baru di ruang heap. Kita bisa menggunakan intern()
        // metode untuk memasukkannya ke dalam kumpulan atau merujuk ke objek String
        // lain dari kumpulan string yang memiliki nilai yang sama.

        // Kumpulan String itu sendiri juga dibuat di heap.

        // Version < Java SE 7
        // Sebelum Java 7, String literal disimpan di kumpulan konstanta runtime di area
        // metode PermGen, yang memiliki ukuran tetap

        // String pool juga berada di PermGen.

        // Version ≥ Java SE 7
        // RFC: 6962931

        // Di JDK 7, string yang diinternir tidak lagi dialokasikan dalam generasi
        // permanen tumpukan Java, tetapi dialokasikan
        // malah dialokasikan di bagian utama tumpukan Java (dikenal sebagai generasi
        // muda dan tua), bersama dengan
        // objek lain yang dibuat oleh aplikasi. Perubahan ini akan menghasilkan lebih
        // banyak data yang berada di Java utama
        // tumpukan, dan lebih sedikit data dalam pembuatan permanen, dan karenanya
        // mungkin memerlukan penyesuaian ukuran tumpukan. Sebagian besar aplikasi hanya
        // akan melihat perbedaan yang relatif kecil dalam penggunaan heap karena
        // perubahan ini, tetapi aplikasi yang lebih besar yang memuat banyak kelas atau
        // banyak menggunakan metode String.intern() akan melihat perbedaan yang lebih
        // signifikan
    }
}
