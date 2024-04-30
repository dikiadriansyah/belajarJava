public class repeatAStringnTimes {
    public static void main(String[] args) {
        // Masalah: Buat sebuah String yang berisi n pengulangan dari sebuah String s.

        // Pendekatan sepele akan berulang kali menggabungkan String:
        // final int n = 5;
        // final String s = "Apel ";
        // String result = "";

        // for (int i = 0; i < n; i++) {
        // result += s;
        // }
        // System.out.println(result); // output: Apel Apel Apel Apel Apel

        // ---------------------------
        // Ini membuat n instance string baru yang berisi 1 hingga n pengulangan s yang
        // menghasilkan runtime O(s.length() * n²) = O(s.length() * (1+2+...+(n-1)+n)).

        // Untuk menghindari ini, StringBuilder harus digunakan, yang memungkinkan
        // pembuatan String dalam O(s.length() * n) sebagai gantinya:

        final int n = 5;
        final String s = "Jeruk ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(s);
        }

        String result = sb.toString();
        System.out.println(result); // output: Jeruk Jeruk Jeruk Jeruk Jeruk

    }
}
