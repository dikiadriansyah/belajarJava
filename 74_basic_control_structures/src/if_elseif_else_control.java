public class if_elseif_else_control {
    // If / Else If / Else Control

    /*
     * if (i < 2) {
     * System.out.println("i is less than 2");
     * } else if (i > 2) {
     * System.out.println("i is more than 2");
     * } else {
     * System.out.println("i is not less than 2, and not more than 2");
     * }
     */

    /*
     * Blok if hanya akan berjalan ketika i bernilai 1 atau kurang.
     * 
     * Kondisi else if dicentang hanya jika semua kondisi sebelumnya (dalam
     * konstruksi else if sebelumnya, dan kondisi induk.
     * if konstruksi) telah diuji false. Dalam contoh ini, kondisi else if hanya
     * akan diperiksa jika i lebih besar atau sama dengan 2.
     */

    /*
     * Jika hasilnya true, bloknya dijalankan, dan konstruksi else if dan else
     * lainnya setelahnya akan dilewati.
     * 
     * Jika tidak ada kondisi if dan else if yang diuji true, blok else di akhir
     * akan dijalankan.
     */

    public static void main(String[] args) {
        int i = 1;
        if (i < 2) {
            System.out.println("i is less than 2");
        } else if (i > 2) {
            System.out.println("i is more than 2");
        } else {
            System.out.println("i is not less than 2, and not more than 2");
        }
        /*
         * output:
         * i is less than 2
         */

    }
}
