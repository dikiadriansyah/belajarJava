public class Naming_conventions {

    // Naming conventions/Konvensi penamaan

    // Package names
    /*
     * 1. Nama paket harus menggunakan huruf kecil semua tanpa garis bawah atau
     * karakter khusus lainnya.
     * 2. Nama paket dimulai dengan bagian otoritas terbalik dari alamat web
     * perusahaan pengembang. Bagian ini dapat diikuti oleh substruktur paket yang
     * bergantung pada struktur proyek/program.
     * 3. Jangan gunakan bentuk jamak. Ikuti konvensi API standar yang digunakan
     * misalnya java.lang.annotation dan bukan java.lang.annotations.
     * 4. Contoh: com.yourcompany.widget.button, com.yourcompany.core.api
     */

    // Class, Interface and Enum Names

    /*
     * 1. Nama kelas dan enum biasanya berupa kata benda.
     * 2. Nama antarmuka biasanya berupa kata benda atau kata sifat yang diakhiri
     * dengan …mampu.
     * 3. Gunakan huruf campuran dengan huruf pertama di setiap kata dalam huruf
     * besar (yaitu CamelCase).
     * 4. Cocokkan ekspresi reguler ^[A-Z][a-zA-Z0-9]*$.
     * 5. Gunakan kata utuh dan hindari penggunaan singkatan kecuali jika singkatan
     * tersebut lebih banyak digunakan dibandingkan bentuk panjang.
     * 6. Formatlah singkatan sebagai sebuah kata jika itu adalah bagian dari nama
     * kelas yang lebih panjang.
     * 7. Contoh: ArrayList, BigInteger, ArrayIndexOutOfBoundsException, Iterable
     */

    // Method Names
    /*
     * Nama metode biasanya berupa kata kerja atau deskripsi tindakan lainnya
     * 1. Mereka harus cocok dengan ekspresi reguler ^[a-z][a-zA-Z0-9]*$.
     * 2. Gunakan huruf campuran dengan huruf pertama dalam huruf kecil.
     * 3. Contoh: toString, hashCode
     */

    // Variables
    /*
     * Nama variabel harus dalam huruf campuran dengan huruf pertama dalam huruf
     * kecil
     * 1. Cocokkan ekspresi reguler ^[a-z][a-zA-Z0-9]*$
     * 2. Rekomendasi lebih lanjut: Variabels
     * 3. Contoh: elements, currentIndex
     */

    // Type Variables
    /*
     * Untuk kasus sederhana di mana hanya ada sedikit variabel tipe yang terlibat,
     * gunakan satu huruf besar.
     * 1. Cocokkan ekspresi reguler ^[A-Z][0-9]?$
     * 2. Jika satu huruf lebih deskriptif dibandingkan huruf lainnya (seperti K dan
     * V untuk kunci dan nilai dalam maps atau R untuk tipe pengembalian fungsi),
     * gunakan huruf tersebut, jika tidak gunakan T.
     * 3. Untuk kasus kompleks di mana variabel berjenis huruf tunggal menjadi
     * membingungkan, gunakan nama yang lebih panjang yang ditulis dengan huruf
     * kapital semua dan gunakan garis bawah (_) untuk memisahkan kata.
     * 4. Contoh: T, V, SRC_VERTEX
     */

    // Constants
    /*
     * Konstanta (static final fields yang isinya tidak dapat diubah, berdasarkan
     * aturan bahasa atau konvensi) harus diberi nama
     * dengan huruf kapital semua dan garis bawah (_) untuk memisahkan kata.
     * 
     * Match the regular expression ^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$
     * Examples: BUFFER_SIZE, MAX_LEVEL
     */

    // Other guidelines on naming

    /*
     * 1. Hindari menyembunyikan/membayangi metode, variabel, dan mengetik variabel
     * di cakupan luar.
     * 2. Biarkan verbositas nama berkorelasi dengan ukuran cakupannya. (Misalnya,
     * gunakan nama deskriptif untuk
     * bidang kelas besar dan nama singkat untuk variabel lokal berumur pendek.)
     * 3. Saat memberi nama anggota statis publik, biarkan pengidentifikasinya
     * deskriptif jika Anda yakin mereka bersifat statis
     * impor.
     * 4. Bacaan lebih lanjut: Bagian Penamaan (dalam Panduan Gaya Java resmi)
     */

    // Source: Java Style Guidelines from Oracle

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
