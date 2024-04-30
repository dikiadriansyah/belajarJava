import java.util.ArrayList;
import java.util.List;

public class Iterating_over_elements_in_a_list {
    // Iterating over elements in a list
    /*
     * Sebagai contoh, katakanlah kita memiliki Daftar bertipe String yang berisi
     * empat elemen: "halo, ", "bagaimana", "apakah", "kamu?"
     * 
     * Cara terbaik untuk mengulangi setiap elemen adalah dengan menggunakan
     * perulangan for-each:
     */
    public static void main(String[] args) {
        Iterating_over_elements_in_a_list box1 = new Iterating_over_elements_in_a_list();

        List<String> box2 = new ArrayList<>();
        // box2.add("hello");
        // box2.add("how");
        // box2.add("are");
        // box2.add("you?");
        // box1.printEachElement(box2);
        /*
         * output:
         * hello
         * how
         * are
         * you?
         */
        // -----------------
        // Untuk mencetak semuanya dalam satu baris, Anda dapat menggunakan
        // StringBuilder:
        box2.add("hello, ");
        box2.add("how ");
        box2.add("are ");
        box2.add("you?");
        box1.printAsLine(box2);
        /*
         * output:
         * hello, how are you?
         */

        /*
         * Alternatifnya, Anda dapat menggunakan pengindeksan elemen (seperti yang
         * dijelaskan dalam Mengakses elemen di Indeks engan dari ArrayList ) untuk
         * mengulangi daftar. Peringatan: pendekatan ini tidak efisien untuk daftar
         * tertaut
         */
    }

    // membuat method bernama printEachElement
    // public void printEachElement(List<String> list) {
    // for (String s : list) {
    // System.out.println(s);
    // }
    // }

    public void printAsLine(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        System.out.println(builder.toString());
    }
}
