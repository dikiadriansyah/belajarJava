public class The_conditional_operator {
    // The Conditional Operator (?:)

    // Sintaks
    // {condition-to-evaluate} ? {statement-executed-on-true} :
    // {statement-executed-on-false}

    /*
     * Seperti yang ditunjukkan dalam sintaksis, Operator Bersyarat (juga dikenal
     * sebagai Operator Ternary1) menggunakan ? (tanda tanya)
     * dan : karakter (titik dua) untuk mengaktifkan ekspresi kondisional dari dua
     * kemungkinan hasil. Ini dapat digunakan untuk menggantikan blok if-else yang
     * lebih panjang untuk mengembalikan salah satu dari dua nilai berdasarkan
     * kondisi.
     * 
     * result = testCondition ? value1 : value2
     * 
     * Setara dengan
     * if (testCondition) {
     * result = value1;
     * } else {
     * result = value2;
     * }
     * 
     * Dapat dibaca sebagai “Jika testCondition true, setel hasil ke nilai1; jika
     * tidak, setel hasil ke nilai2”.
     * 
     */

    public static void main(String[] args) {
        // contoh:
        // get absolute value using conditional operator
        // int a = -10;
        // int absValue = a < 0 ? -a : a;
        // System.out.println("abs = " + absValue); // prints "abs = 10"

        // Setara dengan
        // get absolute value using if/else loop
        int a = -10;
        int absValue;
        if (a < 0) {
            absValue = -a;
        } else {
            absValue = a;
        }
        System.out.println("abs = " + absValue); // prints "abs = 10"

        // Penggunaan Umum
        // Anda dapat menggunakan operator bersyarat untuk penugasan bersyarat (seperti
        // pemeriksaan null).
        String y = "";
        // String x = y != null ? y.toString() : ""; // where y is an object

        // Contoh ini setara dengan:
        String x = "";
        if (y != null) {
            x = y.toString();
        }

        /*
         * Karena Operator Bersyarat memiliki prioritas terendah kedua, di atas Operator
         * Penugasan, maka jarang sekali ada kebutuhan untuk menggunakan tanda kurung di
         * sekitar kondisi, tetapi tanda kurung diperlukan di seluruh konstruksi
         * Operator Bersyarat ketika digabungkan dengan operator lain:
         */

        // no parenthesis needed for expressions in the 3 parts
        // 10 <= a && a < 19 ? b * 5 : b * 7

        // parenthesis required
        // 7 * (a > 0 ? 2 : 5)

        /*
         * Pensarangan operator kondisional juga dapat dilakukan di bagian ketiga, yang
         * cara kerjanya lebih seperti rangkaian atau seperti pernyataan switch.
         */
        // a ? "a is true" :
        // b ? "a is false, b is true" :
        // c ? "a and b are false, c is true" :
        // "a, b, and c are false"

        // Operator precedence can be illustrated with parenthesis:
        // a ? x : (b ? y : (c ? z : w))

        // Catatan kaki:
        /*
         * 1. Spesifikasi Bahasa Java dan Tutorial Java menyebut operator (? :) sebagai
         * Operator Bersyarat. Tutorial mengatakan bahwa ini
         * "juga dikenal sebagai Operator Ternary" karena (saat ini) merupakan
         * satu-satunya operator ternary yang ditentukan oleh Java. Terminologi
         * "Operator Bersyarat" konsisten dengan C dan C++ serta bahasa lain dengan
         * operator yang setara.
         */

    }
}
