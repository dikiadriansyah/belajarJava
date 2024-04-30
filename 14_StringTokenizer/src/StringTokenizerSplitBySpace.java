import java.util.StringTokenizer;

public class StringTokenizerSplitBySpace {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Kelas java.util.StringTokenizer memungkinkan Anda memecah string menjadi
        // token. Ini adalah cara sederhana untuk memutuskan string.

        // Kumpulan delimiters (characters yang memisahkan token) dapat ditentukan baik
        // pada waktu pembuatan atau berdasarkan pertoken.

        StringTokenizer st = new StringTokenizer("Meja Pintu Kursi Lampu", " ");
        // StringTokenizer merupakan dapat memecah-mecah nilai string yang panjang
        // menjadi beberapa kata atau bagian berdasarkan delimiter yang ditentukan
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
            // output:
            // Meja
            // Pintu
            // Kursi
            // Lampu
        }
    }
}
