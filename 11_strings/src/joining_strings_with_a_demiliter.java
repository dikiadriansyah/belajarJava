import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class joining_strings_with_a_demiliter {
    public static void main(String[] args) {
        // Array string dapat digabungkan menggunakan metode statis String.join():
        String[] buah = { "pisang", "jeruk", "apel", "ceri" };
        String singleString = String.join("+", buah);
        // System.out.println(singleString); // pisang+jeruk+apel+ceri

        // Demikian pula, ada metode String.join() yang kelebihan beban untuk Iterables.

        // Untuk memiliki kontrol halus atas bergabung, Anda dapat menggunakan kelas
        // StringJoiner:
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        // The last two arguments are optional,
        // they define prefix and suffix for the result string
        sj.add("senin");
        sj.add("selasa");
        sj.add("rabu");
        // System.out.println(sj); // [senin, selasa, rabu]

        // Untuk menggabungkan aliran string, Anda dapat menggunakan kolektor
        // gabungan(joining collector):
        Stream<String> stringStream = Stream.of("merah", "biru", "kuning");
        // String joined = stringStream.collect(Collectors.joining(", "));
        // System.out.println(joined); // merah, biru, kuning

        // Ada opsi untuk menentukan awalan(prefix) dan akhiran(suffix) di sini juga:
        String gabung = stringStream.collect(Collectors.joining(",", "{", "}"));
        System.out.println(gabung); // {merah,biru,kuning}

    }
}
