import java.util.ArrayList;
import java.util.List;

public class Benefits_of_generic_class_and_interface {
    // Benefits of Generic class and interface / Manfaat kelas dan antarmuka Generik

    // Kode yang menggunakan kode generik memiliki banyak keunggulan dibandingkan
    // kode non-generik. Di bawah ini adalah manfaat utamanya

    // Pemeriksaan tipe yang lebih kuat pada waktu kompilasi

    /*
     * Kompiler Java menerapkan pemeriksaan tipe yang kuat pada kode generik dan
     * mengeluarkan kesalahan jika kode tersebut melanggar keamanan tipe. Pemasangan
     * kesalahan waktu kompilasi lebih mudah daripada memperbaiki kesalahan waktu
     * proses, yang mungkin sulit ditemukan.
     */

    // Penghapusan gips
    /*
     * Cuplikan kode berikut tanpa kode generik memerlukan transmisi:
     * List list = new ArrayList();
     * list.add("hello");
     * String s = (String) list.get(0);
     * 
     */

    // Saat ditulis ulang untuk menggunakan obat generik, kode tersebut tidak
    // memerlukan casting
    /*
     * List<String> list = new ArrayList<>();
     * list.add("hello");
     * String s = list.get(0); // no cast
     */

    // Memungkinkan pemrogram untuk mengimplementasikan algoritma generik
    /*
     * Dengan menggunakan obat generik, pemrogram dapat mengimplementasikan
     * algoritma generik yang bekerja pada kumpulan tipe berbeda, bisa
     * dapat disesuaikan, dan jenisnya aman serta lebih mudah dibaca.
     */

    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("hello");
        String s = (String) list.get(0);
        System.out.println("Nilai string dari list: " + s); // Nilai string dari list: hello
    }
}
