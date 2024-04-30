public class Creating_an_uber_jar_for_an_application_and_its_dependencies {
    // Creating an UberJAR for an application and its dependencies/Membuat UberJAR
    // untuk aplikasi dan aplikasinya ketergantungan

    /*
     * Persyaratan umum untuk aplikasi Java adalah dapat diterapkan dengan menyalin
     * satu file. Sederhananya
     * aplikasi yang hanya bergantung pada perpustakaan kelas Java SE standar,
     * persyaratan ini dipenuhi dengan membuat JAR
     * file yang berisi semua kelas aplikasi (yang dikompilasi).
     * 
     * Segalanya menjadi tidak mudah jika aplikasi bergantung pada perpustakaan
     * pihak ketiga. Jika Anda hanya memasukkan file JAR ketergantungan ke dalam JAR
     * aplikasi, pemuat kelas Java standar tidak akan dapat menemukan kelas
     * perpustakaan, dan aplikasi Anda tidak akan dimulai. Sebagai gantinya, Anda
     * perlu membuat satu file JAR yang berisi kelas aplikasi dan
     * sumber daya terkait bersama dengan kelas ketergantungan dan sumber daya. Ini
     * perlu diatur sebagai satu namespace agar classloader dapat mencari.
     * 
     * File JAR seperti itu sering disebut sebagai UberJAR.
     */

    // Creating an UberJAR using the "jar" command/Membuat UberJAR menggunakan
    // perintah "jar".
    /*
     * Prosedur untuk membuat UberJAR sangatlah mudah. (Saya akan menggunakan
     * perintah Linux untuk kesederhanaan. Perintahnya
     * harus sama untuk Mac OS, dan serupa untuk Windows.)
     */
    // 1. Buat direktori sementara, dan ubah direktori ke direktori tersebut.
    /*
     * $ mkdir tempDir
     * $ cd tempDir
     */

    /*
     * 2. Untuk setiap file JAR yang bergantung, dalam urutan terbalik agar file
     * tersebut muncul di classpath aplikasi, digunakan
     * perintah jar untuk membongkar JAR ke direktori sementara.
     * 
     * $ jar -xf <path/to/file.jar>
     * 
     * Melakukan hal ini untuk beberapa file JAR akan melapisi konten JAR.
     */

    // 3. Salin kelas aplikasi dari pohon build ke direktori sementara
    // $ cp -r path/to/classes .

    /*
     * 4. Buat UberJAR dari isi direktori sementara
     * $ jar -cf ../myApplication.jar
     * 
     * Jika Anda membuat file JAR yang dapat dieksekusi, sertakan MANIFEST.MF yang
     * sesuai seperti yang dijelaskan di sini.
     */

    /*
     * Creating an UberJAR using Maven/Membuat UberJAR menggunakan Maven
     * Jika proyek Anda dibuat menggunakan Maven, Anda bisa membuatnya membuat
     * UberJAR menggunakan "maven-assembly" atau
     * plugin "maven-shade". Lihat topik Majelis Maven (dalam dokumentasi Maven)
     * untuk detailnya.
     */

    /*
     * Kelebihan dan kekurangan UberJAR
     * Beberapa keunggulan UberJAR sudah jelas:
     * 
     * 1. UberJAR mudah didistribusikan.
     * 2. Anda tidak dapat memutus ketergantungan perpustakaan untuk UberJAR, karena
     * perpustakaan bersifat mandiri
     * 
     * 
     */

    /*
     * Selain itu, jika Anda menggunakan alat yang sesuai untuk membuat UberJAR,
     * Anda akan memiliki opsi untuk mengecualikan kelas perpustakaan yang tidak
     * digunakan dari file JAR. Namun, hal ini biasanya dilakukan dengan analisis
     * statis kelas. Jika aplikasi Anda menggunakan refleksi, pemrosesan anotasi,
     * dan teknik serupa, Anda harus berhati-hati agar kelas tidak dikecualikan
     * secara tidak benar.
     * UberJAR juga memiliki beberapa kelemahan:
     * 
     * 1. Jika Anda memiliki banyak UberJAR dengan dependensi yang sama,
     * masing-masing UberJAR akan berisi salinan dependensinya.
     * 2. Beberapa perpustakaan sumber terbuka memiliki lisensi yang mungkin
     * menghalangi penggunaannya di UberJAR.
     */

    /*
     * 1 - Beberapa lisensi perpustakaan sumber terbuka mengizinkan Anda menggunakan
     * perpustakaan hanya jika pengguna akhir dapat mengganti satu versi
     * perpustakaan dengan versi lainnya. UberJAR dapat mempersulit penggantian
     * dependensi versi.
     */

    public static void main(String[] args) throws Exception {

    }
}
