public class Building_javadocs_from_the_command_line {
    // Building Javadocs From the Command Line / Membangun Javadocs Dari Baris
    // Perintah

    // Dokumentasi untuk kode java sering dihasilkan menggunakan
    // javadoc(http://www.oracle.com/technetwork/articles/java/index-jsp-135444.html),
    // javadoc dibuat oleh Sun Microsystems untuk tujuan menghasilkan dokumentasi
    // API dalam format HTML dari kode sumber java.
    // Menggunakan format HTML memberikan kemudahan untuk dapat meng-hyperlink
    // dokumen terkait bersama-sama.

    // Building Javadocs From the Command Line / Membangun Javadocs Dari Baris
    // Perintah

    // Banyak IDE memberikan dukungan untuk menghasilkan HTML dari Javadocs secara
    // otomatis; beberapa alat bangun (Maven dan Gradle, misalnya) juga memiliki
    // plugin yang dapat menangani pembuatan HTML.
    // Namun, alat ini tidak diperlukan untuk menghasilkan HTML Javadoc; ini dapat
    // dilakukan dengan menggunakan baris perintah
    // alat javadoc.

    // Penggunaan paling dasar dari alat ini adalah:
    // javadoc JavaFile.java

    // yang akan menghasilkan HTML dari komentar Javadoc di
    // Building_javadocs_from_the_command_line.java

    // penggunaan alat baris perintah yang praktis, yang secara rekursif akan
    // membaca semua file java di [source-directory], buat dokumentasi untuk
    // [package.name] dan semua sub-paket, dan tempatkan HTML yang dihasilkan di
    // [docsdirectory] adalah:

    // javadoc -d [docs-directory] -subpackages -sourcepath [source-directory]
    // [package.name]

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
