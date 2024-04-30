import java.util.StringJoiner;
// import java.util.logging.Formatter;
import java.util.Formatter;

public class comparingStringBuffer_StringBuilder_formatter_and_stringJoiner {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Java StringBuilder class digunakan untuk membuat string yang dapat diubah
        // (dapat dimodifikasi). Java StringBuilder class sama dengan
        // StringBuffer class kecuali bahwa itu tidak disinkronkan(non-synchronized).
        // Ini tersedia sejak JDK 1.5.

        // StringBuffer, StringBuilder, Formatter dan StringJoiner classes adalah java
        // SE utility classes yg terutama digunakan untuk merakit string dari informasi
        // lain:
        // 1. StringBuffer class telah hadir sejak java 1.0, dan menyediakan beragam
        // metode untuk membangun dan memodifikasi "buffer" yg berisi urutan karakter.
        // 2. StringBuilder class ditambahkan di Java 5 untuk mengatasi masalah kinerja
        // dengan original StringBuffer class. API untuk kedua kelas pada dasarnya sama.
        // Perbedaan utama antara StringBuffer dan StringBuilder adalah bahwa yang
        // pertama aman untuk thread dan disinkronkan dan yang terakhir tidak.

        // Contoh ini menunjukkan bagaimana StringBuilder dapat digunakan:
        int kedua = 2;
        String warna = "Hijau";
        StringBuilder sb = new StringBuilder();
        sb.append("Dua = ").append(kedua).append(", Warna = ").append(warna).append('\n');
        // System.out.println(sb); // Dua = 2, Warna = Hijau

        // (StringBuffer class digunakan dengan cara yang sama: ubah saja StringBuilder
        // menjadi StringBuffer di atas).

        // Kelas StringBuffer dan StringBuilder cocok untuk merakit dan memodifikasi
        // string; yaitu mereka menyediakan metode untuk mengganti dan menghapus
        // karakter serta menambahkannya dalam berbagai. Dua yang tersisa kelas khusus
        // untuk tugas merakit string.

        // 1. Kelas Formatter ditambahkan di Java 5, dan secara longgar dimodelkan pada
        // fungsi sprintf dalam C standard library. Dibutuhkan string format dengan
        // penentu format tersemat dan urutan argumen lain, dan menghasilkan string
        // dengan mengubah argumen menjadi teks dan menggantinya dengan format
        // penentu. Detail penentu format mengatakan bagaimana argumen diubah menjadi
        // teks

        // 2. StringJoiner class ditambahkan di Java 8. Ini adalah formatter tujuan
        // khusus yang secara ringkas memformat urutan string dengan pemisah di
        // antaranya. Ini dirancang dengan API yang lancar, dan dapat digunakan dengan
        // aliran Java 8

        // Berikut adalah beberapa contoh umum penggunaan Formatter:

        // This does the same thing as the StringBuilder example above
        int one = 1;
        String color = "yellow";
        Formatter f = new Formatter();
        // System.out.println(f.format("One = %d, colour=%s%n", one, color));
        // output: One = 1, colour = yellow

        // The same thing using the `String.format` convenience method
        // System.out.println(String.format("One = %d, Color = %s%n", one, color));
        // output: One = 1, Color = yellow

        // StringJoiner class tidak ideal untuk tugas di atas, jadi berikut adalah
        // contoh pemformatan array string.

        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (String s : new String[] { "Apel", "Duku", "Ceri" }) {
            sj.add(s);
        }

        System.out.println(sj);
        // output:
        // [Apel,Duku,Ceri]

        // Kasus penggunaan untuk 4 kelas dapat diringkas:
        // 1. StringBuilder cocok untuk perakitan string ATAU tugas modifikasi string.
        // 2. Penggunaan StringBuffer (hanya) saat Anda memerlukan versi StringBuilder
        // yang aman untuk thread.
        // 3. Formatter menyediakan fungsionalitas pemformatan string yang lebih kaya,
        // tetapi tidak seefisien StringBuilder. Ini
        // karena setiap panggilan ke Formatter.format(...) memerlukan:
        // - menguraikan string format,
        // - membuat dan mengisi array varargs, dan
        // - autoboxing argumen tipe primitif apa pun.
        // 4. StringJoiner menyediakan pemformatan urutan string yang ringkas dan
        // efisien
        // dengan pemisah, tetapi tidak cocok untuk tugas pemformatan lainnya.

    }
}
