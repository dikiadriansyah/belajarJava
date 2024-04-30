public class Class_structure {
    // Class Structure/Struktur Kelas

    // Urutan anggota kelas

    /*
     * Anggota kelas hendaknya diurutkan sebagai berikut:
     * 1. Fields (in order of public, protected and private)
     * 2. Constructors
     * 3. Factory methods
     * 4. Other Methods (in order of public, protected and private)
     * 
     */

    /*
     * Tidak diperlukan pengurutan bidang dan metode terutama berdasarkan pengubah
     * akses atau pengidentifikasinya.
     * Berikut adalah contoh pesanan ini:
     * 
     * class Example {
     * private int i;
     * Example(int i) {
     * this.i = i;
     * }
     * static Example getExample(int i) {
     * return new Example(i);
     * }
     * 
     * @Override
     * public String toString() {
     * return "An example [" + i + "]";
     * }
     * }
     * 
     * 
     */

    // Pengelompokan anggota kelas
    /*
     * 1. Bidang terkait harus dikelompokkan bersama.
     * 2. Tipe bersarang dapat dideklarasikan tepat sebelum digunakan pertama kali;
     * jika tidak maka harus dideklarasikan sebelum kolom.
     * 3. Konstruktor dan metode yang kelebihan beban harus dikelompokkan
     * berdasarkan fungsionalitas dan diurutkan
     * meningkatkan aritas. Ini menyiratkan bahwa delegasi di antara konstruksi ini
     * mengalir ke bawah dalam kode.
     * 4. Konstruktor harus dikelompokkan bersama tanpa ada anggota lain di
     * antaranya.
     * 5. Varian metode yang kelebihan beban harus dikelompokkan bersama tanpa ada
     * anggota lain di antaranya.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Example2 box = Example2.getExample(10);
        System.out.println(box.toString());
        // output: An example [10]

    }
}
