public class While_loops {
    // While Loops/ perulangan While

    /*
     * int i = 0;
     * while (i < 100) { // condition gets checked BEFORE the loop body executes
     * System.out.println(i);
     * i++;
     * }
     */

    /*
     * Perulangan while berjalan selama kondisi di dalam tanda kurung true. Ini
     * juga disebut "lingkaran pra-tes"
     * struktur karena pernyataan kondisional harus dipenuhi sebelum badan
     * perulangan utama dijalankan setiap saat.
     * 
     * Tanda kurung kurawal bersifat opsional jika perulangan hanya berisi satu
     * pernyataan, namun beberapa konvensi gaya pengkodean lebih memilih menggunakan
     * tanda kurung kurawal.
     */

    public static void main(String[] args) {
        int i = 0;
        while (i < 10) { // condition gets checked BEFORE the loop body executes
            System.out.println(i);
            i++;
        }

        /*
         * output:
         * 0
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         */

    }
}
