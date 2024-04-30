public class Pitfall_unnecessary_use_of_primitive_wrappers_can_lead_to_nullpointerexceptions {
    // Pitfall - Unnecessary use of Primitive Wrappers can lead to
    // NullPointerExceptions/ Jebakan - Penggunaan Pembungkus Primitif yang tidak
    // perlu dapat menyebabkan NullPointerExceptions

    /*
     * Terkadang, pemrogram baru Java akan menggunakan tipe primitif dan wrapper
     * secara bergantian. Hal ini dapat menimbulkan masalah. Perhatikan contoh ini:
     * 
     * public class MyRecord {
     * public int a, b;
     * public Integer c, d;
     * }
     * ...
     * MyRecord record = new MyRecord();
     * record.a = 1; // OK
     * record.b = record.b + 1; // OK
     * record.c = 1; // OK
     * record.d = record.d + 1; // throws a NullPointerException
     */

    /*
     * Kelas 1 MyRecord kami bergantung pada inisialisasi default untuk
     * menginisialisasi nilai pada bidangnya. Jadi, saat kita membuat new record,
     * kolom a dan b akan disetel ke nol, dan kolom c dan d akan disetel ke null.
     * 
     * Ketika kami mencoba menggunakan bidang yang diinisialisasi secara default,
     * kami melihat bahwa bidang int berfungsi sepanjang waktu, tetapi bidang
     * Integer berfungsi dalam beberapa kasus dan tidak pada kasus lainnya. Secara
     * khusus, dalam kasus yang gagal (dengan d), yang terjadi adalah ekspresi di
     * sisi kanan mencoba membuka kotak referensi null, dan itulah yang menyebabkan
     * NullPointerException dilempar.
     * 
     * Ada beberapa cara untuk melihatnya:
     * 
     * 1. Jika bidang c dan d harus berupa pembungkus primitif, maka kita tidak
     * boleh mengandalkan inisialisasi default, atau kita harus menguji null. Untuk
     * yang pertama adalah pendekatan yang benar kecuali ada arti yang pasti untuk
     * bidang-bidang dalam keadaan null.
     * 
     * 2. Jika kolom tidak perlu berupa pembungkus primitif, maka merupakan suatu
     * kesalahan jika menjadikannya sebagai pembungkus primitif. Selain masalah ini,
     * pembungkus primitif memiliki overhead tambahan dibandingkan tipe primitif.
     */

    /*
     * Pelajarannya di sini adalah untuk tidak menggunakan tipe wrapper primitif
     * kecuali Anda benar-benar membutuhkannya.
     * 1 - Kelas ini bukan contoh praktik coding yang baik. Misalnya, kelas yang
     * dirancang dengan baik tidak akan memiliki kolom publik. Namun, bukan itu inti
     * dari contoh ini.
     */

    public static void main(String[] args) throws Exception {
        MyRecord record = new MyRecord();
        record.a = 1; // Menginisialisasi variabel a dengan nilai 1
        record.b = record.b + 1; // Mengambil nilai b (yang defaultnya 0 karena tipe data primitif),
                                 // menambahkannya dengan 1, lalu menyimpannya kembali ke b
        record.c = 1; // Menginisialisasi variabel c dengan nilai 1
        // record.d = record.d + 1; // Ini akan menyebabkan NullPointerException karena
        // d defaultnya null
        // Jika ingin menambahkan nilai ke d, Anda perlu memastikan bahwa d tidak null
        if (record.d != null) {
            record.d = record.d + 1; // Ini aman karena kita memeriksa apakah d tidak null sebelum menambahkannya
        } else {
            record.d = 1; // Atau alternatifnya, Anda dapat menginisialisasi d dengan nilai tertentu jika
                          // null
        }
        System.out.println("Nilai a: " + record.a); // Output: Nilai a: 1
        System.out.println("Nilai b: " + record.b); // Output: Nilai b: 1
        System.out.println("Nilai c: " + record.c); // Output: Nilai c: 1
        System.out.println("Nilai d: " + record.d); // Output: Nilai d: 1 (jika d awalnya null)
    }
}
