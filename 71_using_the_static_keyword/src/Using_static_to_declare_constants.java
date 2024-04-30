public class Using_static_to_declare_constants {
    // Using static to declare constants/Menggunakan statis untuk mendeklarasikan
    // konstanta

    /*
     * Karena kata kunci static digunakan untuk mengakses bidang dan metode tanpa
     * kelas yang dipakai, kata kunci tersebut dapat digunakan untuk mendeklarasikan
     * konstanta untuk digunakan di kelas lain. Variabel-variabel ini akan tetap
     * konstan di setiap pembuatan instance kelas. Berdasarkan konvensi, variabel
     * static selalu ALL_CAPS dan menggunakan garis bawah daripada camel case.
     * contoh:
     * static E STATIC_VARIABLE_NAME
     */

    /*
     * Karena konstanta tidak dapat diubah, static juga dapat digunakan dengan
     * pengubah final:
     * Misalnya, untuk mendefinisikan konstanta matematika pi:
     * public class MathUtilities {
     * static final double PI = 3.14159265358
     * }
     */

    /*
     * Yang dapat digunakan di kelas mana pun sebagai konstanta, misalnya:
     * public class MathCalculations {
     * //Calculates the circumference of a circle
     * public double calculateCircumference(double radius) {
     * return (2 * radius * MathUtilities.PI);
     * }
     * }
     */

    // Calculates the circumference of a circle
    public double calculateCircumference(double radius) {
        return (2 * radius * MathUtilities.PI);
    }

    public static void main(String[] args) {
        // Contoh penggunaan
        double radius = 5.0;
        Using_static_to_declare_constants mathCalc = new Using_static_to_declare_constants();
        double circumference = mathCalc.calculateCircumference(radius);

        System.out.println("Circumference of the circle with radius " + radius + " is: " + circumference);
        /*
         * output:
         * Circumference of the circle with radius 5.0 is: 31.4159265358
         */
    }
}
