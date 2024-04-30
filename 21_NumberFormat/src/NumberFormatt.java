import java.util.*;
import java.text.NumberFormat;

public class NumberFormatt {
    // NumberFormat
    /*
     * Negara yang berbeda memiliki format angka yang berbeda dan mempertimbangkan
     * hal ini kita dapat memiliki format yang berbeda menggunakan Lokal java.
     * Menggunakan lokal dapat membantu dalam pemformatan
     * 
     * Locale locale = new Locale("en", "IN");
     * NumberFormat numberFormat = NumberFormat.getInstance(locale);
     * 
     * 
     */
    public static void main(String[] args) {
        // System.out.println("Hello, World!");
        Locale locale = new Locale("en", "IN");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        // System.out.println(numberFormat); // java.text.DecimalFormat@674dc

        // menggunakan format di atas Anda dapat melakukan berbagai tugas
        // 1. Format Number
        String formattedNumber = numberFormat.format(10000000.99);
        // System.out.println("Formatted Number: " + formattedNumber); // Formatted
        // Number: 10,000,000.99

        // 2. Format Currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        String box1 = currencyFormat.format(10340.999);
        // System.out.println(box1); // 10,341.00

        // 3. Format Percentage
        NumberFormat percentageFormat = NumberFormat.getPercentInstance(locale);
        String box2 = percentageFormat.format(10929.999);
        // System.out.println(box2); // 1,093,000%

        // 4. control Number of digits
        numberFormat.setMinimumIntegerDigits(5);
        String box3 = numberFormat.format(10929.999);
        System.out.println("Formatted Number: " + box3); // Formatted Number: 10,929.999

        // numberFormat.setMaximumIntegerDigits(int digits);
        // numberFormat.setMinimumFractionDigits(int digits);
        // numberFormat.setMaximumFractionDigits(int digits);
    }

}
