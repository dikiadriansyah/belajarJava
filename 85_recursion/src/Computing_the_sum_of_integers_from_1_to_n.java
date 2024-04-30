public class Computing_the_sum_of_integers_from_1_to_n {
    // Computing the sum of integers from 1 to N/Menghitung jumlah bilangan bulat
    // dari 1 sampai N

    /*
     * Metode berikut menghitung jumlah bilangan bulat dari 0 hingga N menggunakan
     * rekursi
     * 
     * public int sum(final int n) {
     * if (n > 0) {
     * return n + sum(n - 1);
     * } else {
     * return n;
     * }
     * }
     */

    /*
     * Metode ini O(N) dan dapat direduksi menjadi loop sederhana menggunakan
     * optimasi tail-call. Faktanya ada ekspresi bentuk tertutup yang menghitung
     * jumlah dalam operasi O(1).
     */

    public static void main(String[] args) {
        Computing_the_sum_of_integers_from_1_to_n box = new Computing_the_sum_of_integers_from_1_to_n();
        int bilangan = 3;
        int result = box.sum(bilangan);
        System.out.println("Hasil dari " + bilangan + " adalah " + result);
        /*
         * output:
         * Hasil dari 3 adalah 6
         */
    }

    public int sum(final int n) {
        if (n > 0) {
            return n + sum(n - 1);
        } else {
            return n;
        }
    }

}
