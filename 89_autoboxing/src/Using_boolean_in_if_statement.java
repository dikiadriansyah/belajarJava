public class Using_boolean_in_if_statement {
    // Using Boolean in if statement/ Menggunakan Boolean dalam pernyataan if

    /*
     * Karena unboxing otomatis, seseorang dapat menggunakan Boolean dalam
     * pernyataan if:
     * 
     * Boolean a = Boolean.TRUE;
     * if (a) { // a gets converted to boolean
     * System.out.println("It works!");
     * }
     */

    /*
     * Itu berfungsi untuk while, do while dan kondisi dalam pernyataan
     * for juga.
     * 
     * Perhatikan bahwa, jika Boolean adalah null, NullPointerException akan
     * dimasukkan ke dalam konversi.
     */

    public static void main(String[] args) {
        Boolean a = Boolean.TRUE;
        if (a) { // a gets converted to boolean
            System.out.println("It works!");
        }

        /*
         * output:
         * It works!
         */

    }
}
