public class New_java_se7_programming_language_features {

    // New Java SE 7 programming language features/Fitur bahasa pemrograman Java SE
    // 7 baru

    /*
     * 1. Binary Literals: Tipe integral (byte, short, int, dan long) juga dapat
     * dinyatakan menggunakan sistem bilangan biner. Untuk menentukan literal biner,
     * tambahkan awalan 0b atau 0B ke nomor tersebut
     * 2. Strings in switch statements: Anda dapat menggunakan objek String dalam
     * ekspresi pernyataan switch
     * 3. the try-with-resources statements: Pernyataan try-with-resources adalah
     * pernyataan try yang mendeklarasikan satu atau lebih sumber daya. Sumber daya
     * adalah suatu objek yang harus ditutup setelah program selesai menggunakannya.
     * Pernyataan trywith-resources memastikan bahwa setiap sumber daya ditutup pada
     * akhir pernyataan. Objek apa pun yang mengimplementasikan
     * java.lang.AutoCloseable, yang mencakup semua objek yang mengimplementasikan
     * java.io.Closeable, dapat digunakan sebagai sumber daya
     * 4. catching multiple exception types and rethrowing exceptions with improved
     * type checking:satu blok tangkapan dapat menangani lebih dari satu jenis
     * pengecualian. Fitur ini dapat mengurangi duplikasi kode dan mengurangi godaan
     * untuk menangkap pengecualian yang terlalu luas.
     * 5. underscores in numeric literals: Sejumlah karakter garis bawah (_) dapat
     * muncul di mana saja di antara digit dalam literal numerik. Fitur ini
     * memungkinkan Anda, misalnya, untuk memisahkan kelompok digit dalam literal
     * numerik, yang dapat meningkatkan keterbacaan kode Anda.
     * 6. types inference for generic instance creation: Anda dapat mengganti
     * argumen tipe yang diperlukan untuk memanggil konstruktor kelas generik dengan
     * sekumpulan parameter tipe kosong (<>) selama kompiler dapat menyimpulkan
     * argumen tipe dari konteksnya. Sepasang tanda kurung sudut ini secara informal
     * disebut berlian.
     * 7. improved compiler warnings and errors when using non-reifiable formal
     * parameters with vargs methods
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
