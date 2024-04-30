import java.text.DecimalFormat;

public class Formatting_the_floating_point_values {
    // Formatting the floating point values/Memformat nilai floating point

    // Angka floating point dapat diformat sebagai angka desimal menggunakan
    // String.format dengan tanda 'f'

    /*
     * //Two digits in fracttional part are rounded
     * String format1 = String.format("%.2f", 1.2399);
     * System.out.println(format1); // "1.24"
     * // three digits in fractional part are rounded
     * String format2 = String.format("%.3f", 1.2399);
     * System.out.println(format2); // "1.240"
     * 
     * //rounded to two digits, filled with zero
     * String format3 = String.format("%.2f", 1.2);
     * System.out.println(format3); // returns "1.20"
     * 
     * //rounder to two digits
     * String format4 = String.format("%.2f", 3.19999);
     * System.out.println(format4); // "3.20"
     * 
     */

    // Angka floating point dapat diformat sebagai angka desimal menggunakan
    // DecimalFormat

    /*
     * // rounded with one digit fractional part
     * String format = new DecimalFormat("0.#").format(4.3200);
     * System.out.println(format); // 4.3
     * 
     * // rounded with two digit fractional part
     * String format = new DecimalFormat("0.##").format(1.2323000);
     * System.out.println(format); //1.23
     * // formatting floating numbers to decimal number
     * double dv = 123456789;
     * System.out.println(dv); // 1.23456789E8
     * String format = new DecimalFormat("0").format(dv);
     * System.out.println(format); //123456789
     */

    public static void main(String[] args) {
        // Two digits in fracttional part are rounded
        // String format1 = String.format("%.2f", 1.2399);
        // System.out.println(format1); // "1.24"

        // // three digits in fractional part are rounded
        // String format2 = String.format("%.3f", 1.2399);
        // System.out.println(format2); // "1.240"

        // // rounded to two digits, filled with zero
        // String format3 = String.format("%.2f", 1.2);
        // System.out.println(format3); // returns "1.20"

        // // rounder to two digits
        // String format4 = String.format("%.2f", 3.19999);
        // System.out.println(format4); // "3.20"

        // -----------
        // rounded with one digit fractional part
        String format = new DecimalFormat("0.#").format(4.3200);
        System.out.println(format); // 4.3

        // rounded with two digit fractional part
        String format2 = new DecimalFormat("0.##").format(1.2323000);
        System.out.println(format2); // 1.23

        // formatting floating numbers to decimal number
        double dv = 123456789;
        System.out.println(dv); // 1.23456789E8

        String format3 = new DecimalFormat("0").format(dv);
        System.out.println(format3); // 123456789

    }
}
