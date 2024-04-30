import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.function.Predicate;

enum RegEx implements Predicate<String> {
    UPPER("[A-Z]+"), LOWER("[a-z]+"), NUMERIC("[+-]?[0-9]+");

    private final Pattern pattern;

    private RegEx(final String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public boolean test(final String input) {
        return this.pattern.matcher(input).matches();
    }
}

public class Implements_interface {
    // Implements Interface/ Antarmuka Implement

    /*
     * Ini adalah enum yang juga merupakan fungsi callable yang menguji input String
     * terhadap pola ekspresi reguler yang telah dikompilasi sebelumnya.
     */

    enum Acceptor implements Predicate<String> {
        NULL {
            @Override
            public boolean test(String s) {
                return s == null;
            }
        },
        EMPTY {
            @Override
            public boolean test(String s) {
                return s.equals("");
            }
        },
        NULL_OR_EMPTY {
            @Override
            public boolean test(String s) {
                return NULL.test(s) || EMPTY.test(s);
            }
        };
    }

    public static void main(String[] args) {
        // System.out.println(RegEx.UPPER.test("ABC")); // true
        // System.out.println(RegEx.LOWER.test("abc")); // true
        // System.out.println(RegEx.NUMERIC.test("+111")); // true

        // ----------------------
        System.out.println(Acceptor.NULL.test(null)); // true
        System.out.println(Acceptor.EMPTY.test("")); // true
        System.out.println(Acceptor.NULL_OR_EMPTY.test(" ")); // false
    }

}
