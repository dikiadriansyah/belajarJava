public class Ternary_operator {
    // Ternary Operator
    // Terkadang Anda harus memeriksa suatu kondisi dan menetapkan nilai suatu
    // variabel.

    // Misalnya
    /*
     * String name;
     * if (A > B) {
     * name = "Billy";
     * } else {
     * name = "Jimmy";
     * }
     */

    // Ini dapat dengan mudah ditulis dalam satu baris sebagai

    // String name = A > B ? "Billy" : "Jimmy";

    /*
     * Nilai variabel ditetapkan ke nilai segera setelah kondisi, jika kondisinya
     * benar. Jika kondisi false, nilai kedua akan diberikan ke variabel.
     */

    public static void main(String[] args) {
        int A = 7;
        int B = 9;

        // String name;
        // if (A > B) {
        // name = "Billy";
        // } else {
        // name = "Jimmy";
        // }
        // System.out.println(name); // output: Jimmy
        // ------------------------------------------
        String name = A > B ? "Billy" : "Jimmy";
        System.out.println(name); // output: Jimmy

    }
}
