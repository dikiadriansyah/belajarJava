import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class countingOccurrencesOfASubstringOrCharacterInAString {
    public static void main(String[] args) {
        // metode countMatches dari org.apache.commons.lang3.StringUtils biasanya
        // digunakan untuk menghitung kemunculan substring atau karakter dalam sebuah
        // String:

        String hewan = "satu ayam, dua ayam, tiga ayam, empat ayam, lima ayam";

        // menghitung kemunculan substring
        // String stringTarget = "ayam";

        // int stringOccurrences = StringUtils.countMatches(hewan, stringTarget);
        // System.out.println(stringOccurrences); // output: 5

        // count occurrences of a char
        char charTarget = ',';
        int charOccurrences = StringUtils.countMatches(hewan, charTarget); // 3
        // System.out.println(charOccurrences); // output: 4

        // Jika tidak, untuk melakukan hal yang sama dengan API Java standar, Anda dapat
        // menggunakan Ekspresi Reguler:

        String buah = "satu alpukat, dua alpukat, tiga alpukat";
        System.out.println(countStringInString("alpukat", buah)); // 3
        System.out.println(countStringInString(",", buah)); // 2

    }

    public static int countStringInString(String search, String buah) {
        Pattern pattern = Pattern.compile(search);
        Matcher matcher = pattern.matcher(buah);

        int stringOccurrences = 0;
        while (matcher.find()) {
            stringOccurrences++;

        }
        return stringOccurrences;

    }
}
