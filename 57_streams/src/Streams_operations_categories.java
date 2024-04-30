import java.util.Arrays;
import java.util.stream.IntStream;

public class Streams_operations_categories {
    // Stream operations categories /Kategori operasi aliran

    /*
     * Operasi aliran terbagi dalam dua kategori utama, operasi perantara dan
     * terminal, dan dua subkategori, tanpa kewarganegaraan dan berstatus negara.
     */

    // Intermediate Operations / Operasi Menengah:

    /*
     * Operasi perantara selalu malas, seperti Stream.map sederhana. Itu tidak
     * dipanggil sampai aliran tersebut benar-benar dikonsumsi. Ini dapat
     * diverifikasi dengan mudah:
     * 
     * Arrays.asList(1, 2 ,3).stream().map(i -> {
     * throw new RuntimeException("not gonna happen");
     * return i;
     * });
     */

    /*
     * Operasi perantara adalah blok penyusun umum suatu aliran, dirangkai setelah
     * sumbernya dan biasanya diikuti oleh operasi terminal yang memicu rantai
     * aliran.
     */

    // Terminal Operations / Operasi Terminal
    /*
     * Operasi terminal inilah yang memicu konsumsi aliran. Beberapa yang lebih umum
     * adalah Stream.forEach atau Stream.collect. Mereka biasanya ditempatkan
     * setelah rantai operasi perantara dan hampir selalu bersemangat.
     */

    // Stateless Operations/ Operasi Tanpa Kewarganegaraan
    /*
     * Tanpa kewarganegaraan berarti setiap item diproses tanpa konteks item
     * lainnya. Operasi tanpa kewarganegaraan memungkinkan
     * pemrosesan aliran yang hemat memori. Operasi seperti Stream.map dan
     * Stream.filter yang tidak memerlukan informasi tentang item aliran lainnya
     * dianggap tanpa stateless.
     */

    // Stateful operations / Operasi yang penuh keadaan
    /*
     * Statefulness berarti operasi pada setiap item bergantung pada (beberapa) item
     * aliran lainnya. Hal ini memerlukan suatu negara
     * untuk dilestarikan. Operasi statefulness mungkin terhenti pada aliran yang
     * panjang atau tidak terbatas. Operasi seperti Stream.sorted
     * memerlukan keseluruhan aliran untuk diproses sebelum item apa pun dipancarkan
     * yang akan rusak dalam waktu yang cukup lama
     * aliran item. Hal ini dapat ditunjukkan dengan aliran yang panjang (risiko
     * ditanggung sendiri):
     * 
     * // works - stateless stream
     * long BIG_ENOUGH_NUMBER = 999999999;
     * IntStream.iterate(0, i -> i +
     * 1).limit(BIG_ENOUGH_NUMBER).forEach(System.out::println);
     * 
     */

    /*
     * Ini akan menyebabkan kehabisan memori karena status Stream.sorted:
     * // Out of memory - stateful stream
     * IntStream.iterate(0, i -> i +
     * 1).limit(BIG_ENOUGH_NUMBER).sorted().forEach(System.out::println);
     */

    public static void main(String[] args) {
        // try {
        // Arrays.asList(1, 2, 3)
        // .stream()
        // .map(i -> {
        // throw new RuntimeException("not gonna happen");
        // })
        // .forEach(System.out::println);
        // } catch (RuntimeException e) {
        // System.out.println("Caught exception: " + e.getMessage());
        // }
        /*
         * output:
         * Caught exception: not gonna happen
         */
        // ---------------------------
        // works - stateless stream
        long BIG_ENOUGH_NUMBER = 999999999;

        IntStream.iterate(0, i -> i + 1)
                .limit(BIG_ENOUGH_NUMBER)
                .forEach(System.out::println);

    }
}
