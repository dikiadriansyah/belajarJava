public class The_conditional_and_conditional_or_operator {
    // The conditional-and and conditional-or Operators ( && and || )

    /*
     * Java menyediakan operator conditional-and dan conditional-or, yang keduanya
     * mengambil satu atau dua operan bertipe boolean
     * dan menghasilkan hasil boolean. Ini adalah:
     * 1. && - the conditional-AND operator,
     * 2. || - the conditional-OR operators. The evaluation of <left-expr> &&
     * <right-expr> is equivalent to the following pseudo-code:
     */

    public static void main(String[] args) {
        // boolean result = evaluate(true); // Replace with your expressions
        // System.out.println(result); // true

        // ------------------
        // Evaluasi <left-expr> || <right-expr> setara dengan kode semu berikut:
        // boolean result = evaluate(true); // Ganti dengan ekspresi yang sesuai
        // System.out.println(result); // true
        // ---------------------------
        The_conditional_and_conditional_or_operator zeroChecker = new The_conditional_and_conditional_or_operator();

        // Uji dengan nilai yang sama dengan nol
        System.out.println(zeroChecker.isZero(0)); // Output: true

        // Uji dengan nilai yang tidak sama dengan nol
        System.out.println(zeroChecker.isZero(42)); // Output: false
    }

    // private static boolean evaluate(boolean leftExpr) {
    // boolean L = leftExpr;
    // if (L) {
    // // Replace <right-expr> with your actual right expression
    // return evaluateRightExpression();
    // } else {
    // // short-circuit the evaluation of the 2nd operand expression
    // return false;
    // }
    // }

    // private static boolean evaluateRightExpression() {
    // // Replace with your actual right expression
    // return true;
    // }
    // -------------------------
    private static boolean evaluate(boolean leftExpr) {
        boolean L = leftExpr;
        if (!L) {
            // Ganti <right-expr> dengan ekspresi yang sesuai
            return evaluateRightExpression();
        } else {
            // Pendekan sirkuit evaluasi ekspresi operand ke-2
            return true;
        }
    }

    private static boolean evaluateRightExpression() {
        // Ganti dengan ekspresi yang sesuai
        return false;
    }

    /*
     * Seperti yang diilustrasikan oleh pseudo-code di atas, perilaku operator
     * hubung singkat setara dengan penggunaan pernyataan if/else.
     */

    // Example - using && as a guard in an expression(Contoh - menggunakan &&
    // sebagai penjaga dalam sebuah ekspresi)

    /*
     * Contoh berikut menunjukkan pola penggunaan paling umum untuk operator &&.
     * Bandingkan kedua versi ini sebuah metode untuk menguji apakah Integer yang
     * disediakan adalah nol.
     */

    public boolean isZero(Integer value) {
        return value == 0;
    }

    // public boolean isZero(Integer value) {
    // return value != null && value == 0;
    // }

    /*
     * Versi pertama berfungsi dalam banyak kasus, tetapi jika argumen nilai adalah
     * null, maka NullPointerException akan dilempar.
     * 
     * Pada versi kedua kami telah menambahkan tes "penjaga". Ekspresi value != null
     * && value == 0 dievaluasi dengan terlebih dahulu melakukan pengujian value !=
     * null. Jika pengujian nol berhasil (yaitu bernilai benar) maka ekspresi nilai
     * == 0 dievaluasi. Jika pengujian null gagal, maka evaluasi nilai == 0 dilewati
     * (hubungan pendek), dan kita tidak mendapatkan NullPointerException.
     */

    // Example - using && to avoid a costly calculation(Contoh - menggunakan &&
    // untuk menghindari penghitungan yang mahal)
    /*
     * Contoh berikut menunjukkan bagaimana && dapat digunakan untuk menghindari
     * penghitungan yang relatif mahal:
     */
    // public boolean verify(int value, boolean needPrime) {
    // return !needPrime | isPrime(value);
    // }

    // public boolean verify(int value, boolean needPrime) {
    // return !needPrime || isPrime(value);
    // }

    /*
     * Pada versi pertama, kedua operan | akan selalu dievaluasi, sehingga metode
     * isPrime (mahal) akan dipanggil jika tidak perlu. Versi kedua menghindari
     * panggilan yang tidak perlu dengan menggunakan || bukannya |.
     */

}
