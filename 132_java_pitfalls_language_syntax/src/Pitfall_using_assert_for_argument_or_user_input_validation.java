public class Pitfall_using_assert_for_argument_or_user_input_validation {
    // Pitfall: Using 'assert' for argument or user input validation/Kesalahan:
    // Menggunakan 'assert' untuk argumen atau validasi input pengguna

    /*
     * Pertanyaan yang terkadang muncul di StackOverflow adalah apakah pantas
     * menggunakan pernyataan untuk memvalidasi argumen yang diberikan ke suatu
     * metode, atau bahkan masukan yang diberikan oleh pengguna.
     * 
     * Jawaban sederhananya adalah tidak tepat.
     */

    /*
     * Alternatif yang lebih baik meliputi:
     * 1. Melempar IllegalArgumentException menggunakan kode khusus.
     * 2. Menggunakan metode Prasyarat yang tersedia di perpustakaan Google Guava.
     * 3. Menggunakan metode Validate yang tersedia di perpustakaan Apache Commons
     * Lang3
     */

    // Inilah yang disarankan oleh Spesifikasi Bahasa Java (JLS 14.10, untuk Java 8)
    // mengenai masalah ini:

    /*
     * Biasanya, pemeriksaan pernyataan diaktifkan selama pengembangan dan pengujian
     * program, dan dinonaktifkan untuk penerapan, guna meningkatkan kinerja.
     * 
     * Karena pernyataan mungkin dinonaktifkan, program tidak boleh berasumsi bahwa
     * ekspresi yang terkandung dalam pernyataan akan dievaluasi. Oleh karena itu,
     * ekspresi boolean ini secara umum harus bebas dari efek samping.
     * Mengevaluasi ekspresi boolean seperti itu seharusnya tidak memengaruhi
     * keadaan apa pun yang terlihat setelah evaluasi selesai. Ekspresi boolean yang
     * terkandung dalam pernyataan mempunyai efek samping bukanlah hal yang ilegal,
     * namun secara umum tidak tepat, karena dapat menyebabkan perilaku program
     * bervariasi tergantung pada apakah pernyataan diaktifkan atau dinonaktifkan.
     * 
     * Mengingat hal ini, pernyataan tidak boleh digunakan untuk pemeriksaan argumen
     * dalam metode publik. Pemeriksaan argumen biasanya merupakan bagian dari
     * kontrak suatu metode, dan kontrak ini harus ditegakkan
     * pernyataan diaktifkan atau dinonaktifkan.
     * 
     * Masalah kedua dalam penggunaan pernyataan untuk pemeriksaan argumen adalah
     * bahwa argumen yang salah akan menghasilkan pengecualian run-time yang sesuai
     * (seperti IllegalArgumentException,
     * ArrayIndexOutOfBoundsException, atau NullPointerException). Kegagalan
     * pernyataan tidak akan memunculkan pengecualian yang sesuai. Sekali lagi,
     * menggunakan pernyataan untuk pemeriksaan argumen pada metode publik bukanlah
     * hal yang ilegal,
     * tetapi secara umum hal ini tidak pantas. Hal ini dimaksudkan agar
     * AssertionError tidak pernah tertangkap, namun hal ini mungkin terjadi,
     * sehingga aturan untuk pernyataan try harus memperlakukan pernyataan yang
     * muncul di blok try dengan cara yang sama dengan perlakuan saat ini terhadap
     * pernyataan throw.
     */

    public static void main(String[] args) throws Exception {

    }
}
