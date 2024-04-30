public class Continue_statement_in_java {
    // Continue Statement in Java/ Lanjutkan Pernyataan di Java

    /*
     * Pernyataan continue digunakan untuk melewati langkah-langkah yang tersisa
     * dalam iterasi saat ini dan memulai dengan iterasi loop berikutnya. Kontrol
     * berpindah dari pernyataan continue ke nilai langkah (kenaikan atau
     * penurunan), jika ada.
     */

    /*
     * String[] programmers = {"Adrian", "Paul", "John", "Harry"};
     * //john is not printed out
     * for (String name : programmers) {
     * if (name.equals("John"))
     * continue;
     * System.out.println(name);
     * }
     */

    // Pernyataan continue juga dapat membuat kontrol program beralih ke nilai
    // langkah (jika ada) dari loop bernama:
    /*
     * Outer: // The name of the outermost loop is kept here as 'Outer'
     * for(int i = 0; i < 5; )
     * {
     * for(int j = 0; j < 5; j++)
     * {
     * continue Outer;
     * }
     * }
     */

    public static void main(String[] args) {
        // String[] programmers = { "Adrian", "Paul", "John", "Harry" };
        // // john is not printed out
        // for (String name : programmers) {
        // if (name.equals("John"))
        // continue;
        // System.out.println(name);
        // }

        /*
         * output:
         * Adrian
         * Paul
         * Harry
         */
        // ------------------

    }
}
