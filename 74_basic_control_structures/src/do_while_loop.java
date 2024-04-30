import java.util.Scanner;

public class do_while_loop {
    // do...while Loop/perulangan do..while

    /*
     * Perulangan do... while berbeda dari perulangan lainnya karena perulangan ini
     * dijamin akan dieksekusi setidaknya sekali. Ini juga disebut struktur
     * "post-test loop" karena pernyataan kondisional dilakukan setelah badan loop
     * utama.
     */

    /*
     * int i = 0;
     * do {
     * i++;
     * System.out.println(i);
     * } while (i < 100); // Condition gets checked AFTER the content of the loop
     * executes.
     */

    /*
     * Pada contoh ini, perulangan akan berjalan hingga angka 100 tercetak (walaupun
     * kondisinya i < 100 dan bukan i <= 100), karena kondisi perulangan dievaluasi
     * setelah perulangan dijalankan.
     * 
     * Dengan jaminan setidaknya satu eksekusi, dimungkinkan untuk mendeklarasikan
     * variabel di luar loop dan menginisialisasinya di dalam.
     */

    /*
     * String theWord;
     * Scanner scan = new Scanner(System.in);
     * do {
     * theWord = scan.nextLine();
     * } while (!theWord.equals("Bird"));
     * System.out.println(theWord);
     */

    /*
     * Dalam konteks ini, theWord didefinisikan di luar loop, tetapi karena dijamin
     * memiliki nilai berdasarkan aliran alaminya, theWord akan diinisialisasi.
     */

    public static void main(String[] args) {
        int i = 0;
        do {
            i++;
            System.out.println(i);
        } while (i < 5); // Condition gets checked AFTER the content of the loop executes.
        /*
         * output:
         * 1
         * 2
         * 3
         * 4
         * 5
         */

        // ----------------------------------------
        // String theWord;
        // Scanner scan = new Scanner(System.in);
        // do {
        // theWord = scan.nextLine();
        // } while (!theWord.equals("Bird"));
        // System.out.println(theWord); // output: Bird

    }

}
