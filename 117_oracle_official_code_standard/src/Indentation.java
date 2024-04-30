public class Indentation {
    // Indentation/Lekukan

    /*
     * 1. Tingkat lekukan adalah empat spasi.
     * 2. Hanya karakter spasi yang boleh digunakan untuk indentasi. Tidak ada tab.
     * 3. Baris kosong tidak boleh menjorok ke dalam. (Hal ini tersirat dalam aturan
     * tidak boleh ada spasi kosong di belakangnya.)
     * 4. baris case harus diberi indentasi dengan empat spasi, dan pernyataan
     * dalam kasus tersebut harus diberi indentasi
     * empat spasi lagi.
     */

    /*
     * switch (var) {
     * case TWO:
     * setChoice("two");
     * break;
     * case THREE:
     * setChoice("three");
     * break;
     * default:
     * throw new IllegalArgumentException();
     * }
     */

    // Lihat Pernyataan Pembungkus untuk panduan tentang cara membuat indentasi
    // garis lanjutan.

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // --------
        int var = 2; // contoh nilai var yang digunakan dalam switch
        switch (var) {
            case 2:
                setChoice("two");
                break;
            case 3:
                setChoice("three");
                break;
            default:
                throw new IllegalArgumentException();
        }

        /*
         * output:
         * Choice: two
         */
    }

    public static void setChoice(String choice) {
        System.out.println("Choice: " + choice);
    }

}
