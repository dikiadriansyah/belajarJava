import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Creating_a_frequency_map {
    // Creating a Frequency Map/ Membuat Peta Frekuensi

    /*
     * Kolektor groupingBy(classifier, downstream) memungkinkan pengumpulan elemen
     * Stream ke dalam Map dengan mengklasifikasikan setiap elemen dalam grup dan
     * melakukan operasi hilir pada elemen yang diklasifikasikan dalam grup yang
     * sama.
     * 
     * Contoh klasik dari prinsip ini adalah menggunakan Map untuk menghitung
     * kemunculan elemen dalam Stream. Dalam contoh ini,
     * pengklasifikasi hanyalah fungsi identitas, yang mengembalikan elemen apa
     * adanya. Operasi hilir menghitung jumlah elemen yang sama, menggunakan
     * counting().
     */

    public static void main(String[] args) {
        Stream.of("apple", "orange", "banana", "apple")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);

        /*
         * Operasi hilirnya sendiri adalah kolektor (Collectors.counting()) yang
         * beroperasi pada elemen bertipe String
         * dan menghasilkan hasil tipe Long. Hasil dari pemanggilan metode pengumpulan
         * adalah Map<String, Long>.
         */

        // Ini akan menghasilkan output berikut:
        /*
         * banana=1
         * orange=1
         * apple=2
         */
    }
}
