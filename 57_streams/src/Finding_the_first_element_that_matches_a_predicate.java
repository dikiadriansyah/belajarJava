import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Finding_the_first_element_that_matches_a_predicate {
    // Finding the First Element that Matches a Predicate/Menemukan Elemen Pertama
    // yang Cocok dengan Predikat

    /*
     * Dimungkinkan untuk menemukan elemen pertama dari Aliran yang cocok dengan
     * suatu kondisi.
     * 
     * Untuk contoh ini, kita akan mencari bilangan bulat pertama yang kuadratnya
     * lebih dari 50.000.
     */

    /*
     * IntStream.iterate(1, i -> i + 1) // Generate an infinite stream 1,2,3,4...
     * .filter(i -> (i*i) > 50000) // Filter to find elements where the square is
     * >50000
     * .findFirst(); // Find the first filtered element
     */

    /*
     * Ekspresi ini akan mengembalikan OptionalInt dengan hasilnya.
     * 
     * Perhatikan bahwa dengan Stream tak terbatas, Java akan terus memeriksa setiap
     * elemen hingga menemukan hasilnya. Dengan Stream terbatas, jika Java kehabisan
     * elemen tetapi masih tidak dapat menemukan hasil, Java akan mengembalikan
     * OptionalInt kosong.
     */

    public static void main(String[] args) {
        OptionalInt result = IntStream.iterate(1, i -> i + 1)
                .filter(i -> (i * i) > 50000)
                .findFirst();

        if (result.isPresent()) {
            System.out.println("First element where the square is > 50000: " + result.getAsInt());
        } else {
            System.out.println("No element found where the square is > 50000.");
        }

        /*
         * output:
         * First element where the square is > 50000: 224
         */

    }
}
