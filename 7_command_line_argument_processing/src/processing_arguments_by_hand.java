public class processing_arguments_by_hand {
    // Processing arguments by hand / Memproses argumen dengan tangan

    // Ketika sintaks baris perintah untuk aplikasi sederhana, masuk akal untuk
    // melakukan pemrosesan argumen perintah sepenuhnya dalam kode kustom.

    // dalam contoh ini, kami akan menyajikan serangkaian studi kasus sederhana.
    // dalam setiap kasus, kode akan menghasilkan pesan error jika argumen tidak
    // dapat diterima, lalu panggil System.exit(1) untuk memberi tahu shell bahwa
    // perintah telah gagal (kami akan berasumsi dalam setiap kasus bahwa kode java
    // dipanggil menggunakan pembungkus yang namanya "myapp").

    // A command with no arguments / sebuah perintah tanpa argumen

    // Dalam studi kasus ini, perintah tidak memerlukan argumen. kode
    // mengilustrasikan bahwa args.length memberi kita jumlah argumen baris
    // perintah.

    public static void main(String[] args) {
        if (args.length > 0) {
            System.err.println("usage: myapp");
            System.exit(1);
        }
        // Run the application
        System.out.println("It worked");
    }

}
