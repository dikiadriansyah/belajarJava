public class if_else {
    // if/else

    /*
     * int i = 2;
     * if (i < 2) {
     * System.out.println("i is less than 2");
     * } else {
     * System.out.println("i is greater than 2");
     * }
     */

    /*
     * Pernyataan if mengeksekusi kode secara kondisional bergantung pada hasil
     * kondisi dalam tanda kurung. Jika kondisi dalam tanda kurung benar maka akan
     * masuk ke blok pernyataan if yang didefinisikan dengan kurung kurawal seperti
     * { dan }.
     * kurung buka hingga kurung tutup adalah cakupan pernyataan if.
     * 
     * Blok else bersifat opsional dan dapat dihilangkan. Ini berjalan jika
     * pernyataan if false dan tidak berjalan jika pernyataan if
     * pernyataan benar Karena dalam hal ini pernyataan if dieksekusi.
     */

    public static void main(String[] args) {
        int i = 2;
        if (i < 2) {
            System.out.println("i is less than 2");
        } else {
            System.out.println("i is greater than 2");
        }

        // output:
        /*
         * i is greater than 2
         */

        // Lihat juga: Ternary If

    }
}
