public class platformIndependentNewLineSeparator {
    public static void main(String[] args) {
        // Karena pemisah baris baru bervariasi dari platform ke platform (misalnya \n
        // pada sistem mirip Unix atau \r\n pada Windows) itu adalah seringkali
        // diperlukan untuk memiliki cara mengaksesnya yang tidak tergantung
        // platform. Di java itu dapat diambil dari sistem Properti:
        // System.out.println(
        // "Berita hari senin " + System.getProperty("line.separator") + "terjadi
        // kemacetan di hari kerja");
        // output:
        // Berita hari senin
        // terjadi kemacetan di hari kerja

        // Karena new line separator sangat dibutuhkan, dari Java 7 tersedia metode
        // pintasan yang mengembalikan hasil yang persis sama dengan kode di atas:

        // System.out.println("Mata pelajaran hari senin" + System.lineSeparator() +
        // "Algoritma pemrograman");
        // output:
        // Mata pelajaran hari senin
        // Algoritma pemrograman

        // Catatan:
        // karena sangat tidak mungkin new line separator berubah selama eksekusi
        // program, merupakan ide bagus untuk menyimpannya dalam
        // variabel final statis alih-alih mengambilnya dari property sistem setiap kali
        // diperlukan.

        // saat menggunakan String.format, gunakan %n daripada \n atau '\r\n' untuk
        // menampilkan pemisah baru yang independen platform.
        // String[] lines = { "volvo", "bmw", "ford", "toyota" };
        // System.out.println(String.format("Baris 1: %s. %nBaris 2: %s%n", lines[2],
        // lines[3]));
        // output:
        // Baris 1: ford
        // Baris 2: toyota
    }
}
