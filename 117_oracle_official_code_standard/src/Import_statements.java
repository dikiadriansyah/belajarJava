public class Import_statements {
    // Import statements/Impor pernyataan

    /*
     * // First java/javax packages
     * import java.util.ArrayList;
     * import javax.tools.JavaCompiler;
     * // Then third party libraries
     * import com.fasterxml.jackson.annotation.JsonProperty;
     * // Then project imports
     * import com.example.my.package.ClassA;
     * import com.example.my.package.ClassB;
     * // Then static imports (in the same order as above)
     * import static java.util.stream.Collectors.toList;
     */

    // 1. Pernyataan impor harus diurutkan…
    /*
     * …primarily by non-static / static with non-static imports first.
     * …secondarily by package origin according to the following order
     * - java packages
     * - javax packages
     * - external packages (e.g. org.xml)
     * - internal packages (e.g. com.sun)
     * …tertiary by package and class identifier in lexicographical order
     */
    // 2. Pernyataan impor tidak boleh berupa baris yang dibungkus, terlepas dari
    // apakah itu melebihi panjang baris maksimum yang disarankan.
    // 3. Seharusnya tidak ada impor yang tidak terpakai.

    // Wildcard imports
    /*
     * 1. Impor wildcard secara umum tidak boleh digunakan.
     * 2. Saat mengimpor sejumlah besar kelas yang berkaitan erat (seperti penerapan
     * pengunjung di atas pohon dengan
     * lusinan kelas “node” yang berbeda), impor wildcard dapat digunakan.
     * 3. Dalam hal apa pun, tidak boleh lebih dari satu impor wildcard per file.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
    }
}
