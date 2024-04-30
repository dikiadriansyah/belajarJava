public class breakAStringUpIntoSubstringsAllOfAKnownLength {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Caranya adalah dengan menggunakan look-behind dengan regex \G, yang artinya
        // "end of previous match":
        String str = "diki@gmail.com";
        String[] p = str.split("(?<=\\G.{8})");
        // (?<=..) adalah positive lookbehind assertion dalam regular expression. ini
        // memastikan bahwa pemisahan hanya terjadi setelah setiap 8 character.
        // \\G adalah anchor yg menandakan posisi terakhir dimana pencocokan dimulai.
        // pada awalnya, posisi ini dianggap sebagai awal string.
        // .{8} adalah mencocokan 8 karakter.

        for (String res : p) {
            System.out.println(res);
            // output:
            // diki@gma
            // il.com
        }

        // Regex mencocokkan 8 characters setelah akhir pertandingan terakhir. Karena
        // dalam hal ini kecocokan adalah lebar nol, kita bisa lebih sederhana
        // mengatakan "8 characters setelah pertandingan terakhir".
        // Mudahnya, \G diinisialisasi untuk memulai input, jadi ini juga berfungsi
        // untuk bagian pertama input
    }
}
