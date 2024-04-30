import java.util.regex.*;

public class Using_regex_with_custom_behaviour_by_compiling_the_pattern_with_flags {
    // Using regex with custom behaviour by compiling the Pattern with
    // flags/Menggunakan regex dengan perilaku khusus dengan mengkompilasi Pola
    // dengan bendera

    /*
     * Sebuah Pattern dapat dikompilasi dengan flag, jika regex digunakan sebagai
     * String literal, gunakan pengubah inline:
     * 
     * Pattern pattern = Pattern.compile("foo.", Pattern.CASE_INSENSITIVE |
     * Pattern.DOTALL);
     * pattern.matcher("FOO\n").matches(); // Is true.
     * 
     * Had the regex not been compiled case insensitively and singlelined,
     * it would fail because FOO does not match /foo/ and \n (newline)
     * does not match /./.
     * 
     * Pattern anotherPattern = Pattern.compile("(?si)foo");
     * anotherPattern.matcher("FOO\n").matches(); // Is true.
     * "foOt".replaceAll("(?si)foo", "ca"); // Returns "cat".
     * 
     */

    public static void main(String[] args) {
        // Pattern pattern = Pattern.compile("foo.", Pattern.CASE_INSENSITIVE |
        // Pattern.DOTALL);
        // System.out.println(pattern.matcher("FOO\n").matches());// Is true.

        // ---------------------
        // Membuat pola regex dengan flag (?si) yang menandakan pencocokan
        // case-insensitive dan
        // multiline
        Pattern anotherPattern = Pattern.compile("(?si)foo");

        // Mencocokkan pola dengan string "FOO\n"
        boolean isMatch = anotherPattern.matcher("FOO\n").matches();
        System.out.println(isMatch); // Akan mencetak "false"

        // Mengganti "foo" atau "Foo" atau "FOO" dengan "ca"
        String replaced = "foOt".replaceAll("(?si)foo", "ca");
        // System.out.println(replaced); // Akan mencetak "cat"
    }
}
