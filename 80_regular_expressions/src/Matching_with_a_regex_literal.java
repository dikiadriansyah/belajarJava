import java.util.regex.PatternSyntaxException;

public class Matching_with_a_regex_literal {
    // Matching with a regex literal/Mencocokkan dengan literal regex

    /*
     * Jika Anda perlu mencocokkan karakter yang merupakan bagian dari sintaksis
     * ekspresi reguler, Anda dapat menandai semua atau sebagian pola sebagai
     * literal regex.
     * 
     * \Q menandai awal dari literal regex. \E menandai akhir dari literal regex.
     */

    /*
     * the following throws a PatternSyntaxException because of the un-closed
     * bracket
     * "[123".matches("[123");
     * wrapping the bracket in \Q and \E allows the pattern to match as you would
     * expect.
     * "[123".matches("\\Q[\\E123"); // returns true
     */

    // Cara yang lebih mudah untuk melakukannya tanpa harus mengingat escape
    // sequence \Q dan \E adalah dengan menggunakan Pattern.quote()

    // "[123".matches(Pattern.quote("[") + "123"); // returns true

    public static void main(String[] args) {
        // try {
        // // the following throws a PatternSyntaxException because of the un-closed
        // // bracket
        // "[123".matches("[123");
        // } catch (PatternSyntaxException e) {
        // System.out.println("PatternSyntaxException: " + e.getMessage());
        // }
        /*
         * output:
         * PatternSyntaxException: Unclosed character class near index 3
         * [123
         */
        // ---------------
        String input = "[123";
        boolean result = input.matches("\\Q[\\E123");
        System.out.println(result); // Output: true
    }
}
