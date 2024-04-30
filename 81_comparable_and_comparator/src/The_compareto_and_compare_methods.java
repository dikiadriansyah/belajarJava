import java.util.Comparator;

public class The_compareto_and_compare_methods {
    // The compareTo and compare Methods/Metode perbandingan dan perbandingan

    // Antarmuka Comparable<T> memerlukan satu metode:
    /*
     * public interface Comparable<T> {
     * public int compareTo(T other);
     * }
     */

    // Dan antarmuka Comparator<T> memerlukan satu metode:
    /*
     * public interface Comparator<T> {
     * public int compare(T t1, T t2);
     * }
     */

    /*
     * Kedua metode ini pada dasarnya melakukan hal yang sama, dengan satu perbedaan
     * kecil: compareTo membandingkan ini dengan yang lain,
     * sedangkan compare membandingkan t1 dengan t2, tidak memperdulikan hal this
     * sama sekali.
     */

    /*
     * Selain perbedaan tersebut, kedua metode tersebut memiliki persyaratan yang
     * serupa. Khususnya (untuk compareTo), Bandingkan ini
     * objek dengan objek yang ditentukan untuk pesanan. Mengembalikan bilangan
     * bulat negatif, nol, atau bilangan bulat positif karena objek ini lebih kecil,
     * sama dengan, atau lebih besar dari objek yang ditentukan. Jadi, untuk
     * perbandingan a dan b:
     * 
     * jika a < b, a.compareTo(b) and compare(a,b) should return a negative integer,
     * and b.compareTo(a) and
     * compare(b,a) should return a positive integer
     * jika a > b, a.compareTo(b) and compare(a,b) should return a positive integer,
     * and b.compareTo(a) and compare(b,a) should return a negative integer
     * jika a equals b for comparison, all comparisons should return 0.
     */

    public static void main(String[] args) {
        // Membuat instance dari StringLengthComparator
        Comparator<String> stringLengthComparator = new StringLengthComparator();

        // Membandingkan dua string menggunakan Comparator
        String str1 = "Hello";
        String str2 = "World";
        int result = stringLengthComparator.compare(str1, str2);

        // Menampilkan hasil perbandingan
        if (result < 0) {
            System.out.println(str1 + " lebih pendek dari " + str2);
        } else if (result > 0) {
            System.out.println(str1 + " lebih panjang dari " + str2);
        } else {
            System.out.println(str1 + " memiliki panjang yang sama dengan " + str2);
        }
        /*
         * output:
         * Hello memiliki panjang yang sama dengan World
         */
    }
}
