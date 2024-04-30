public class Overloading_methods {
    // Overloading Methods / Metode Kelebihan Beban

    /*
     * Terkadang fungsi yang sama harus ditulis untuk jenis masukan yang berbeda.
     * Pada saat itu, seseorang dapat menggunakan nama metode yang sama dengan
     * serangkaian parameter berbeda. Setiap kumpulan parameter yang berbeda dikenal
     * sebagai tanda tangan metode.
     * Seperti yang terlihat pada contoh, satu metode dapat memiliki banyak tanda
     * tangan.
     */

    public void displayName(String firstName) {
        System.out.println("Name is: " + firstName);
    }

    public void displayName(String firstName, String lastName) {
        System.out.println("Name is: " + firstName + " " + lastName);
    }

    /*
     * Keuntungannya adalah fungsionalitas yang sama dipanggil dengan dua jumlah
     * input berbeda. Saat memanggil metode sesuai dengan masukan yang kita berikan,
     * (Dalam hal ini satu nilai string atau dua nilai string) metode terkait
     * dijalankan.
     */

    // Metode dapat kelebihan beban:
    // 1. Berdasarkan jumlah parameter yang dilewati.
    // Example: method(String s) and method(String s1, String s2).

    // 2.Berdasarkan urutan parameter.
    // Example: method(int i, float f) and method(float f, int i))

    /*
     * Catatan: Metode tidak dapat dibebani secara berlebihan hanya dengan mengubah
     * tipe pengembaliannya (metode int() dianggap sama dengan String
     * metode() dan akan memunculkan RuntimeException jika dicoba). Jika Anda
     * mengubah tipe pengembalian, Anda juga harus mengubah parameter agar dapat
     * kelebihan beban.
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        Overloading_methods displayer = new Overloading_methods();
        displayer.displayName("Ram"); // Name is: Ram
        displayer.displayName("Jon", "Skeet"); // Name is: Jon Skeet

    }
}
