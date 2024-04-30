public class Versioning_and_serialversionUID {
    // Versioning and serialVersionUID

    /*
     * Saat Anda mengimplementasikan antarmuka java.io.Serializable untuk membuat
     * kelas dapat diserialkan, kompiler mencari bidang static final bernama
     * serialVersionUID bertipe long. Jika kelas tidak memiliki bidang ini yang
     * dideklarasikan secara eksplisit maka kompiler akan membuat salah satu bidang
     * tersebut dan menugaskannya dengan nilai yang keluar dari komputasi
     * serialVersionUID yang bergantung pada implementasi. Perhitungan ini
     * bergantung pada berbagai aspek kelas dan mengikuti
     * Spesifikasi Serialisasi Objek yang diberikan oleh Sun. Namun, nilainya tidak
     * dijamin sama di semua kompiler implementasi.
     */

    /*
     * Nilai ini digunakan untuk memeriksa kompatibilitas kelas sehubungan dengan
     * serialisasi dan ini dilakukan saat melakukan deserialisasi objek yang
     * disimpan. Serialization Runtime memverifikasi bahwa serialVersionUID yang
     * dibaca dari data yang tidak diserialisasikan dan serialVersionUID yang
     * dideklarasikan di kelas sama persis. Jika bukan itu masalahnya, ia akan
     * melempar InvalidClassException.
     * 
     */

    /*
     * Sangat disarankan agar Anda mendeklarasikan dan menginisialisasi bidang
     * statis, final dengan tipe panjang dan nama secara eksplisit
     * 'serialVersionUID' di semua kelas yang ingin Anda jadikan Serializable
     * alih-alih mengandalkan perhitungan default
     * nilai untuk bidang ini meskipun Anda tidak akan menggunakan pembuatan versi.
     * Perhitungan 'serialVersionUID' sangat luar biasa
     * sensitif dan mungkin berbeda dari satu implementasi kompiler ke implementasi
     * lainnya dan karenanya Anda mungkin akan mendapatkannya InvalidClassException
     * bahkan untuk kelas yang sama hanya karena Anda menggunakan kompiler yang
     * berbeda implementasi pada pengirim dan penerima akhir dari proses
     * serialisasi.
     */

    /*
     * public class Example implements Serializable {
     * static final long serialVersionUID = 1L;
     * }
     */

    /*
     * Selama serialVersionUID sama, Serialisasi Java dapat menangani versi kelas
     * yang berbeda. Kompatibel dan perubahan yang tidak kompatibel adalah;
     */

    // Perubahan yang Kompatibel

    /*
     * Adding fields : Ketika kelas yang dibentuk kembali memiliki bidang yang
     * tidak muncul di aliran, bidang tersebut di objek akan diinisialisasi ke nilai
     * default untuk tipenya. Jika inisialisasi khusus kelas diperlukan, kelas
     * tersebut dapat menyediakan metode readObject yang dapat menginisialisasi
     * bidang ke nilai nondefault.
     * 
     * Adding classes : Aliran akan berisi hierarki tipe setiap objek di aliran.
     * Membandingkan hierarki dalam aliran dengan kelas saat ini dapat mendeteksi
     * kelas tambahan. Karena tidak ada informasi dalam aliran untuk
     * menginisialisasi objek, bidang kelas akan diinisialisasi ke nilai default.
     * 
     * Removing classes : Membandingkan hierarki kelas di aliran dengan kelas saat
     * ini dapat mendeteksi bahwa suatu kelas telah dihapus. Dalam hal ini, bidang
     * dan objek yang terkait dengan kelas tersebut dibaca dari aliran. Bidang
     * primitif dibuang, tetapi objek yang direferensikan oleh kelas yang dihapus
     * dibuat
     * mereka mungkin dirujuk nanti di aliran. Sampah-sampah tersebut akan
     * dikumpulkan ketika aliran sampah dikumpulkan atau diatur ulang.
     * 
     * Adding writeObject/readObject methods : Jika versi pembacaan aliran
     * memiliki metode ini
     * readObject diharapkan, seperti biasa, membaca data yang diperlukan yang
     * ditulis ke aliran dengan serialisasi default.
     * Itu harus memanggil defaultReadObject terlebih dahulu sebelum membaca data
     * opsional apa pun. Metode writeObject diharapkan seperti biasa memanggil
     * defaultWriteObject untuk menulis data yang diperlukan dan kemudian dapat
     * menulis data opsional.
     * 
     * Menambahkan java.io.Serializable : Ini sama dengan menambahkan tipe. Tidak
     * akan ada nilai dalam aliran untuk kelas ini sehingga bidangnya akan
     * diinisialisasi ke nilai default. Dukungan untuk membuat subkelas kelas yang
     * tidak dapat diserialisasi mengharuskan supertipe kelas tersebut memiliki
     * konstruktor tanpa argumen dan kelas itu sendiri akan diinisialisasi ke
     * default nilai-nilai. Jika konstruktor no-arg tidak tersedia,
     * InvalidClassException akan dilempar.
     * 
     * Changing the access to a field : Pengubah akses publik, paket, dilindungi,
     * dan pribadi tidak berpengaruh pada kemampuan serialisasi untuk menetapkan
     * nilai ke bidang.
     * 
     * Changing a field from static to nonstatic or transient to nontransient : Saat
     * mengandalkan serialisasi default untuk menghitung bidang yang dapat
     * diserialkan, perubahan ini setara dengan menambahkan bidang ke kelas. Itu
     * bidang baru akan ditulis ke aliran tetapi kelas sebelumnya akan mengabaikan
     * nilai tersebut karena serialisasi tidak akan memberikan nilai ke bidang
     * statis atau sementara
     */

    // Perubahan yang Tidak Kompatibel

    /*
     * Deleting fields : Jika suatu bidang dihapus di suatu kelas, aliran yang
     * ditulis tidak akan berisi nilainya. Ketika aliran dibaca oleh kelas
     * sebelumnya, nilai bidang akan ditetapkan ke nilai default karena tidak ada
     * nilai yang tersedia di aliran. Namun, nilai default ini dapat mengganggu
     * kemampuan versi sebelumnya untuk memenuhi kontraknya.
     */

    public static void main(String[] args) {
    }
}
