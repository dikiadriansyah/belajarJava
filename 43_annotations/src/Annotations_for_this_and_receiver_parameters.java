import java.io.Closeable;
import java.lang.annotation.*;

public class Annotations_for_this_and_receiver_parameters {
    // Annotations for 'this' and receiver parameters / Anotasi untuk 'ini' dan
    // parameter penerima

    /*
     * Ketika anotasi Java pertama kali diperkenalkan, tidak ada ketentuan untuk
     * memberi anotasi pada target sebuah instance
     * metode atau parameter konstruktor tersembunyi untuk konstruktor kelas dalam.
     * Ini telah diperbaiki di Java 8 dengan
     * penambahan deklarasi parameter penerima; lihat JLS 8.4.1.
     */

    /*
     * Parameter penerima adalah perangkat sintaksis opsional untuk metode instan
     * atau kelas dalam
     * konstruktor. Untuk metode instan, parameter penerima mewakili objek yang
     * metodenya dipanggil. Untuk konstruktor kelas dalam, parameter penerima
     * mewakili instance objek yang baru dikonstruksikan. Apa pun yang terjadi,
     * parameter penerima ada semata-mata untuk mengizinkan tipe tersebut
     * dari objek yang diwakili untuk dilambangkan dalam kode sumber, sehingga
     * jenisnya dapat diberi anotasi. Parameter penerima bukanlah parameter formal;
     * lebih tepatnya, ini bukan deklarasi variabel apa pun (§4.12.3), tidak pernah
     * terikat pada nilai apa pun yang diteruskan sebagai argumen dalam ekspresi
     * pemanggilan metode atau ekspresi pembuatan instance kelas yang memenuhi
     * syarat, dan tidak memiliki efek apa pun di waktu berjalan.
     */

    // Contoh berikut mengilustrasikan sintaks untuk kedua jenis parameter penerima:

    /*
     * public class Outer {
     * public class Inner {
     * public Inner (Outer this) {
     * // ...
     * }
     * public void doIt(Inner this) {
     * // ...
     * }
     * }
     * }
     * 
     * 
     */

    /*
     * Satu-satunya tujuan parameter penerima adalah untuk memungkinkan Anda
     * menambahkan anotasi. Misalnya, Anda mungkin memiliki kebiasaan
     * anotasi @IsOpen yang tujuannya adalah untuk menegaskan bahwa objek Closeable
     * belum ditutup ketika suatu metode dipanggil. Misalnya:
     * 
     * public class MyResource extends Closeable {
     * public void update(@IsOpen MyResource this, int value) {
     * // ...
     * }
     * public void close() {
     * // ...
     * }
     * }
     */

    /*
     * Pada satu tingkat, anotasi @IsOpen mengenai hal ini dapat berfungsi sebagai
     * dokumentasi. Namun, kami berpotensi berbuat lebih banyak. Misalnya:
     * 1. Pemroses anotasi dapat memasukkan pemeriksaan runtime bahwa ini tidak
     * dalam keadaan tertutup ketika pembaruan dipanggil.
     * 2. Pemeriksa kode dapat melakukan analisis kode statis untuk menemukan kasus
     * yang dapat ditutup ketika pembaruan dipanggil.
     */

    public static void main(String[] args) {

    }

}
