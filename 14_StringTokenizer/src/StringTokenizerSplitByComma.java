
// impor kelas
import java.util.StringTokenizer;

public class StringTokenizerSplitByComma {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("Jaket, Kaos, Kemeja, Gamis");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
            // output:
            // Jaket,
            // Kaos,
            // Kemeja,
            // Gamis
        }
    }
}
