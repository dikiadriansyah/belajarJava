public class Example_of_a_multirelease_jar_files_contents {
    // Example of a multi-release Jar file's contents/Contoh konten file Jar
    // multi-rilis

    /*
     * Dengan mengatur Multi-Release: true di file MANIFEST.MF, file Jar menjadi Jar
     * multi-rilis dan runtime Java (selama mendukung format MRJAR) akan memilih
     * versi kelas yang sesuai tergantung pada versi utama saat ini .
     * Struktur Toples tersebut adalah sebagai berikut:
     * 
     * jar root
     * - A.class
     * - B.class
     * - C.class
     * - D.class
     * - META-INF
     * - versions
     * - 9
     * - A.class
     * - B.class
     * - 10
     * - A.class
     * 
     */

    /*
     * 1. Pada JDK <9, hanya kelas dalam entri root yang terlihat oleh runtime Java.
     * 2. Pada JDK 9, kelas A dan B akan dimuat dari direktori
     * root/META-INF/versions/9, sedangkan C dan D akan dimuat dari entri dasar.
     * 3. Pada JDK 10, kelas A akan dimuat dari direktori root/META-INF/versions/10.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
