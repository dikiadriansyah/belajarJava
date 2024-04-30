import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Wrapping_statements {
    // Wrapping statements/Pernyataan pembungkus

    /*
     * 1. Kode sumber dan komentar umumnya tidak boleh melebihi 80 karakter per
     * baris dan jarang melebihi 100
     * karakter per baris, termasuk indentasi.
     * Batasan karakter harus dinilai berdasarkan kasus per kasus. Yang paling
     * penting adalah “kepadatan” semantik
     * dan keterbacaan garis. Membuat garis-garis yang terlalu panjang membuatnya
     * sulit dibaca; sama halnya, membuat “heroic
     * attempts” untuk memasukkannya ke dalam 80 kolom juga dapat membuatnya sulit
     * dibaca. Fleksibilitas yang diuraikan di sini bertujuan untuk memungkinkan
     * pengembang menghindari hal ekstrem ini, bukan untuk memaksimalkan penggunaan
     * properti monitor.
     * 
     * 2. URL atau contoh perintah tidak boleh digabungkan.
     */

    /*
     * // Ok even though it might exceed max line width when indented.
     * Error e = isTypeParam
     * ? Errors.InvalidRepeatableAnnotationNotApplicable(targetContainerType, on)
     * :
     * Errors.InvalidRepeatableAnnotationNotApplicableInContext(targetContainerType)
     * );
     * // Wrapping preferable
     * String pretty = Stream.of(args)
     * .map(Argument::prettyPrint)
     * .collectors(joining(", "));
     * // Too strict interpretation of max line width. Readability suffers.
     * Error e = isTypeParam
     * ? Errors.InvalidRepeatableAnnotationNotApplicable(
     * targetContainerType, on)
     * : Errors.InvalidRepeatableAnnotationNotApplicableInContext(
     * targetContainerType);
     * // Should be wrapped even though it fits within the character limit
     * String pretty =
     * Stream.of(args).map(Argument::prettyPrint).collectors(joining(", "));
     */

    /*
     * 1. Pembungkusan pada tingkat sintaksis yang lebih tinggi lebih disukai
     * daripada pembungkusan pada tingkat sintaksis yang lebih rendah.
     * 2. Harus ada paling banyak 1 pernyataan per baris.
     * 3. Garis lanjutan harus dibuat menjorok ke dalam dengan salah satu dari empat
     * cara berikut
     */

    /*
     * Varian 1: Dengan 8 spasi tambahan dibandingkan dengan lekukan baris
     * sebelumnya.
     * Varian 2: Dengan 8 spasi tambahan relatif terhadap kolom awal ekspresi yang
     * dibungkus.
     * Varian 3: Selaras dengan ekspresi saudara sebelumnya (asalkan jelas garis
     * lanjutannya)
     * Varian 4: Selaras dengan pemanggilan metode sebelumnya dalam ekspresi
     * berantai.
     */
    public static void main(String[] args) {
        // Menyiapkan argumen
        Argument[] arguments = {
                new Argument("arg1"),
                new Argument("arg2"),
                new Argument("arg3")
        };

        // Menggunakan Stream untuk memanggil prettyPrint pada setiap argumen dan
        // mengumpulkannya
        String pretty = Stream.of(arguments)
                .map(Argument::prettyPrint)
                .collect(Collectors.joining(", "));

        // Menampilkan hasil
        System.out.println(pretty);
        /*
         * output:
         * Argument: arg1, Argument: arg2, Argument: arg3
         */
    }
}
