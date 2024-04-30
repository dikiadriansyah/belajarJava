import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matching_a_backslash {
    // Matching a backslash/ Mencocokkan garis miring terbalik

    /*
     * Jika Anda ingin mencocokkan garis miring terbalik dalam ekspresi reguler
     * Anda, Anda harus menghindarinya.
     * 
     * Garis miring terbalik adalah karakter escape dalam ekspresi reguler. Anda
     * dapat menggunakan '\\' untuk merujuk pada satu garis miring terbalik dalam
     * ekspresi reguler.
     * 
     * Namun, garis miring terbalik juga merupakan karakter escape dalam string
     * literal Java. Untuk membuat ekspresi reguler dari string literal, Anda harus
     * menghindari setiap garis miring terbalik. Dalam string literal '\\\\' dapat
     * digunakan untuk membuat ekspresi reguler dengan '\\', yang pada gilirannya
     * dapat cocok dengan '\'.
     */

    /*
     * Misalnya, pertimbangkan untuk mencocokkan string seperti "C:\dir\myfile.txt".
     * Ekspresi reguler ([A-Za-z]):\\(.*) akan cocok,
     * dan berikan huruf drive sebagai grup penangkap. Perhatikan garis miring
     * terbalik dua kali lipat.
     * 
     * Untuk mengekspresikan pola tersebut dalam literal string Java, setiap garis
     * miring terbalik dalam ekspresi reguler harus di-escape.
     */

    /*
     * String path = "C:\\dir\\myfile.txt";
     * System.out.println( "Local path: " + path ); // "C:\dir\myfile.txt"
     * 
     * String regex = "([A-Za-z]):\\\\.*"; // Four to match one
     * System.out.println("Regex: " + regex ); // "([A-Za-z]):\\(.*)"
     * 
     * Pattern pattern = Pattern.compile( regex );
     * Matcher matcher = pattern.matcher( path );
     * if ( matcher.matches()) {
     * System.out.println( "This path is on drive " + matcher.group( 1 ) + ":.");
     * // This path is on drive C:.
     * }
     */

    /*
     * Jika Anda ingin mencocokkan dua garis miring terbalik, Anda akan menggunakan
     * delapan dalam string literal, untuk mewakili empat dalam ekspresi reguler,
     * untuk mencocokkan dua
     */

    public static void main(String[] args) {
        // String path = "D:\\test.txt";
        // System.out.println("Local path: " + path);
        // // output: Local path: D:\test.txt

        // String regex = "([A-Za-z]):\\\\.*"; // Four to match one
        // System.out.println("Regex: " + regex); // "([A-Za-z]):\\(.*)"

        // Pattern pattern = Pattern.compile(regex);
        // Matcher matcher = pattern.matcher(path);
        // if (matcher.matches()) {
        // System.out.println("This path is on drive " + matcher.group(1) + ":.");
        // // This path is on drive D:.
        // }
        // --------------------------
        String path = "D:\\test.txt";
        System.out.println("UNC path: " + path); // UNC path: D:\test.txt

        String regex = "\\\\\\\\(.+?)\\\\(.*)"; // Eight to match two
        System.out.println("Regex: " + regex); // output: Regex: \\\\(.+?)\\(.*)

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(path);

        if (matcher.matches()) {
            System.out.println("This path is on host '" + matcher.group(1) + "'.");
            // This path is on host 'myhost'.
        }
    }
}
