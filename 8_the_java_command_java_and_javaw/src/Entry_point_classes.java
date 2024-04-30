public class Entry_point_classes {
    // Entry point classes / Kelas titik masuk

    // Kelas titik masuk java memiliki metode utama dengan tanda tangan dan pengubah
    // berikut:
    // public static void main(String[] args)

    // sidenote: karena cara kerja array, bisa juga (String args[])

    // ketika perintah java memulai mesin virtual, ia memuat kelas titik masuk yang
    // ditentukan dan mencoba menemukan main.

    // jika berhasil, argumen dari baris perintah dikoneversi ke java String objects
    // dan dirangkai menjadi sebuah array.

    // jika main dipanggil seperti ini, array tidak akan menjadi null dan tidak akan
    // berisi entri null.

    // Metode kelas titik masuk yang valid harus melakukan hal berikut:
    // - Be named main (case-sensitive) / Diberi nama utama (peka huruf besar-kecil)

    // - Be public and static / Jadilah publik dan statis

    // - Have a void return type / Memiliki tipe pengembalian batal

    // - Have a single argument with an array String[]. The argument must be present
    // and no more than one argument is allowed. / Punya argumen tunggal dengan
    // array String[]. Argumen harus ada dan tidak boleh lebih dari satu argumen

    // - Be generic: type parameters are not allowed. / Jadilah generik: jenis
    // parameter tidak diperbolehkan

    // - Have a non-generic, top-level (not nested or inner) enclosing class /
    // Memiliki kelas penutup non-generik, tingkat atas (tidak bersarang atau
    // dalam).

    // Adalah konvensional untuk mendeklarasikan kelas sebagai publik tetapi ini
    // tidak sepenuhnya diperlukan. dari java 5 dan seterusnya, argumen metode main
    // mungkin adalah string varargs alih-alih array string.
    // main secara opsional dapat membuang pengecualian,
    // dan parameternya dapat diberi nama apa saja, tetapi secara konvensional
    // adalah args.

    // JavaFX entry-points / Titik masuk JavaFX

    // dari java 8 dan seterusnya perintah java juga dapat langsung meluncurkan
    // aplikasi javaFX. JavaFX didokumentasikan dalam tag JavaFX, tetapi titik masuk
    // JavaFX harus melakukan hal berikut:

    // - Extend javafx.application.Application / perluas
    // javafx.application.Application
    // - Be public and not abstract / Jadilah publik dan tidak abstrak
    // - Not be generic or nested / Tidak generik atau bersarang
    // - Have an explicit or implicit public no-args constructor / Memiliki
    // konstruktor no-args publik eksplisit atau implisit

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
