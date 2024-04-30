public class Pitfall_octal_literals {
    // Pitfall - Octal literals/Jebakan - Literal oktal

    /*
     * Perhatikan cuplikan kode berikut:
     * // Print the sum of the numbers 1 to 10
     * int count = 0;
     * for (int i = 1; i < 010; i++) { // Mistake here ....
     * count = count + i;
     * }
     * System.out.println("The sum of 1 to 10 is " + count);
     */

    /*
     * Seorang pemula Java mungkin terkejut mengetahui bahwa program di atas
     * mencetak jawaban yang salah. Ini sebenarnya mencetak jumlah angka 1 hingga 8.
     * 
     * Alasannya adalah literal bilangan bulat yang dimulai dengan angka nol ('0')
     * ditafsirkan oleh kompiler Java sebagai literal oktal, bukan literal desimal
     * seperti yang Anda harapkan. Jadi, 010 adalah bilangan oktal 10, yaitu 8 dalam
     * desimal.
     */

    public static void main(String[] args) throws Exception {
        // Print the sum of the numbers 1 to 10
        int count = 0;
        for (int i = 1; i < 010; i++) { // Mistake here ....
            count = count + i;
        }
        System.out.println("The sum of 1 to 10 is " + count);
        // output:
        /*
         * The sum of 1 to 10 is 28
         */
    }
}
