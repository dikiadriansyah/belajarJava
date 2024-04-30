import java.util.*;
import java.math.*;

public class Converting_string_to_other_datatypes {
        // Converting String to other datatypes/Mengonversi String ke tipe data lain

        // Anda dapat mengonversi string numerik ke berbagai tipe numerik Java sebagai
        // berikut:

        /*
         * String to int:
         * String number = "12";
         * int num = Integer.parseInt(number);
         * 
         * String to float:
         * String number = "12.0";
         * float num = Float.parseFloat(number);
         * 
         * String to double:
         * String double = "1.47";
         * double num = Double.parseDouble(double);
         * 
         * String to boolean:
         * String falseString = "False";
         * boolean falseBool = Boolean.parseBoolean(falseString); // falseBool = false
         * 
         * String trueString = "True";
         * boolean trueBool = Boolean.parseBoolean(trueString); // trueBool = true
         * 
         * String to long:
         * String number = "47";
         * long num = Long.parseLong(number);
         * 
         * String to BigInteger:
         * String bigNumber = "21";
         * BigInteger reallyBig = new BigInteger(bigNumber);
         * 
         * String to BigDecimal:
         * String bigFraction = "17.21455";
         * BigDecimal reallyBig = new BigDecimal(bigFraction);
         */

        // Pengecualian Konversi:

        /*
         * Konversi numerik di atas semuanya akan memunculkan NumberFormatException
         * (tidak dicentang) jika Anda mencoba mengurai string yang format angkanya
         * tidak sesuai, atau berada di luar jangkauan untuk jenis target. Topik
         * Pengecualian membahas cara menangani pengecualian tersebut.
         * 
         * Jika Anda ingin menguji apakah Anda dapat mengurai string, Anda dapat
         * menerapkan metode tryParse... seperti ini:
         */

        /*
         * boolean tryParseInt (String value) {
         * try {
         * String somechar = Integer.parseInt(value);
         * return true;
         * } catch (NumberFormatException e) {
         * return false;
         * }
         * }
         */

        /*
         * Namun, memanggil metode tryParse... ini segera sebelum penguraian (bisa
         * dibilang) merupakan praktik yang buruk. Akan lebih baik jika memanggil saja
         * metode parse... dan menangani pengecualian.
         */

        public static void main(String[] args) {
                // System.out.println("Hello, World!");

                // String number = "12";
                // int num = Integer.parseInt(number);
                // System.out.println("hasil dari " + number + " adalah sebagai berikut: " +
                // num);
                /*
                 * output:
                 * hasil dari 12 adalah sebagai berikut: 12
                 */

                // ---------------------------------
                // String number = "12.0";
                // float num = Float.parseFloat(number);
                // System.out.println("hasil dari " + number + " adalah sebagai berikut: " +
                // num);
                // ------------------------------
                // String double2 = "1.47";
                // double num = Double.parseDouble(double2);
                // System.out.println("hasil dari " + double2 + " adalah sebagai berikut: " +
                // num);
                /*
                 * output:
                 * hasil dari 1.47 adalah sebagai berikut: 1.47
                 */
                // ------------------------------
                // String falseString = "False";
                // boolean falseBool = Boolean.parseBoolean(falseString); // falseBool = false
                // System.out.println("hasil dari " + falseString + " adalah sebagai berikut: "
                // +
                // falseBool);
                /*
                 * output:
                 * hasil dari False adalah sebagai berikut: false
                 */

                // String trueString = "True";
                // boolean trueBool = Boolean.parseBoolean(trueString); // trueBool = true
                // System.out.println("hasil dari " + trueString + " adalah sebagai berikut: " +
                // trueBool);
                /*
                 * output:
                 * hasil dari True adalah sebagai berikut: true
                 */
                // ------------------------------
                // String number = "47";
                // long num = Long.parseLong(number);
                // System.out.println("hasil dari " + number + " adalah sebagai berikut: " +
                // num);
                /*
                 * hasil dari 47 adalah sebagai berikut: 47
                 */
                // ------------------------------
                // String bigNumber = "21";
                // BigInteger reallyBig = new BigInteger(bigNumber);
                // System.out.println("hasil dari " + bigNumber + " adalah sebagai berikut: " +
                // reallyBig);
                /*
                 * output:
                 * hasil dari 21 adalah sebagai berikut: 21
                 */
                // -------------------
                // String bigFraction = "17.21455";
                // BigDecimal reallyBig = new BigDecimal(bigFraction);
                // System.out.println("hasil dari " + bigFraction + " adalah sebagai berikut: "
                // +
                // reallyBig);
                /*
                 * output:
                 * hasil dari 17.21455 adalah sebagai berikut: 17.21455
                 */
                // -------------------
                System.out.println(tryParseInt("123")); // true
                System.out.println(tryParseInt("abc")); // false

        }

        static boolean tryParseInt(String value) {
                try {
                        int someInt = Integer.parseInt(value);
                        return true;
                } catch (NumberFormatException e) {
                        return false;
                }
        }
}
