public class The_lambda_operator {
    // The Lambda operator ( -> )

    /*
     * Mulai Java 8 dan seterusnya, operator Lambda ( -> ) adalah operator yang
     * digunakan untuk memperkenalkan Ekspresi Lambda. Ada dua sintaksis yang umum,
     * seperti yang diilustrasikan oleh contoh berikut:
     */

    public static void main(String[] args) {
        // Version ≥ Java SE 8

        MyLambda addOneLambda = a -> a + 1; // a lambda that adds one to its argument
        System.out.println("Using lambda expression: " + addOneLambda.calculate(5));
        /*
         * output:
         * Using lambda expression: 6
         */

        // a -> { return a + 1; } // an equivalent lambda using a block.

        /*
         * Ekspresi lambda mendefinisikan fungsi anonim, atau lebih tepatnya sebuah
         * instance dari kelas anonim yang mengimplementasikan antarmuka fungsional.
         * 
         * (Contoh ini disertakan di sini untuk kelengkapan. Lihat topik Ekspresi Lambda
         * untuk penjelasan selengkapnya.)
         */
    }

    interface MyLambda {
        int calculate(int a);
    }
}
