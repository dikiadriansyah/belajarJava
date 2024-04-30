public class breakAStringUpIntoSubstringsAllOfVariableLength {
    public static void main(String[] args) {
        // Sama seperti contoh length yang diketahui, tetapi masukkan panjangnya ke
        // regex:
        String str = "pohonapel";
        int panjang = 5;
        String[] res = str.split("(?<=\\G.{" + panjang + "})");
        // System.out.println(res);
        for (String s : res) {
            System.out.println(s);
            // output:
            // pohon
            // apel
        }
    }
}
