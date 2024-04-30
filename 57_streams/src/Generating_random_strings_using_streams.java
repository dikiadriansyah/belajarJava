import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generating_random_strings_using_streams {
    // Generating random Strings using Streams / Menghasilkan String acak
    // menggunakan Streams

    /*
     * Terkadang berguna untuk membuat String acak, mungkin sebagai ID Sesi untuk
     * layanan web atau kata sandi awal setelahnya
     * pendaftaran aplikasi. Ini dapat dengan mudah dicapai menggunakan Streams.
     * 
     * Pertama kita perlu menginisialisasi generator nomor acak. Untuk meningkatkan
     * keamanan untuk String yang dihasilkan, ini bagus
     * ide untuk menggunakan SecureRandom.
     * 
     * Catatan: Membuat SecureRandom cukup mahal, jadi sebaiknya lakukan ini sekali
     * saja dan panggil salah satunya setSeed() metode dari waktu ke waktu untuk
     * melakukan seed ulang.
     * 
     * 
     */

    /*
     * private static final SecureRandom rng = new
     * SecureRandom(SecureRandom.generateSeed(20));
     * //20 Bytes as a seed is rather arbitrary, it is the number used in the
     * JavaDoc example
     */

    /*
     * Saat membuat String acak, kami biasanya ingin string tersebut hanya
     * menggunakan karakter tertentu (misalnya hanya huruf dan angka).
     * Oleh karena itu kita dapat membuat metode yang mengembalikan boolean yang
     * nantinya dapat digunakan untuk memfilter Stream.
     */

    /*
     * //returns true for all chars in 0-9, a-z and A-Z
     * boolean useThisCharacter(char c){
     * //check for range to avoid using all unicode Letter (e.g. some chinese
     * symbols)
     * return c >= '0' && c <= 'z' && Character.isLetterOrDigit(c);
     * }
     * 
     */

    /*
     * Selanjutnya kita dapat memanfaatkan RNG untuk menghasilkan String acak dengan
     * panjang tertentu yang berisi rangkaian karakter yang melewati kita
     * pemeriksaan useThisCharacter.
     */

    /*
     * public String generateRandomString(long length){
     * //Since there is no native CharStream, we use an IntStream instead
     * //and convert it to a Stream<Character> using mapToObj.
     * //We need to specify the boundaries for the int values to ensure they can
     * safely be cast to char
     * Stream<Character> randomCharStream = rng.ints(Character.MIN_CODE_POINT,
     * Character.MAX_CODE_POINT).mapToObj(i -> (char)i).filter(c ->
     * this::useThisCharacter).limit(length);
     * //now we can use this Stream to build a String utilizing the collect method.
     * String randomString = randomCharStream.collect(StringBuilder::new,
     * StringBuilder::append,
     * StringBuilder::append).toString();
     * return randomString;
     * }
     */

    private final Random rng = new Random();

    public String generateRandomString(long length) {
        Stream<Character> randomCharStream = rng.ints(Character.MIN_CODE_POINT, Character.MAX_CODE_POINT)
                .mapToObj(i -> (char) i)
                .filter(this::useThisCharacter)
                .limit(length);

        String randomString = randomCharStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        return randomString;
    }

    private boolean useThisCharacter(char c) {
        // You can customize the criteria for including characters in the random string
        // For example, here we include alphanumeric characters
        return Character.isLetterOrDigit(c);
    }

    public static void main(String[] args) {
        Generating_random_strings_using_streams generator = new Generating_random_strings_using_streams();
        String randomString = generator.generateRandomString(10);
        System.out.println(randomString); // ????
    }
}
