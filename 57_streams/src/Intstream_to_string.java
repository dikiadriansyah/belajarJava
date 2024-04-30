import java.util.stream.IntStream;

public class Intstream_to_string {
    // IntStream to String / intstream untuk string
    /*
     * Java tidak memiliki Char Stream, jadi ketika bekerja dengan Strings dan
     * membuat Stream of Characters, pilihannya adalah mendapatkan poin kode
     * IntStream menggunakan metode String.codePoints(). Maka IntStream bisa
     * didapatkan seperti dibawah ini:
     * public IntStream stringToIntStream(String in) {
     * return in.codePoints();
     * }
     */

    /*
     * Ini sedikit lebih terlibat untuk melakukan konversi sebaliknya i.s. IntStream
     * Ke String. Itu dapat dilakukan sebagai berikut:
     * public String intStreamToString(IntStream intStream) {
     * return intStream.collect(StringBuilder::new, StringBuilder::appendCodePoint,
     * StringBuilder::append).toString();
     * }
     */

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(72, 101, 108, 108, 111);
        String box1 = intStreamToString(intStream);
        System.out.println(box1); // output: Hello
    }

    public static String intStreamToString(IntStream intStream) {
        return intStream.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

}
