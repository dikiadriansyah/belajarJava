
// import javax.annotation.Nonnull;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
import static java.lang.String.format;

public class General_pattern_that_does_most_commonly_asked_about_tasks {
    // General Pattern that does most commonly asked about tasks/ Pola Umum yang
    // paling sering ditanyakan tentang tugas

    /*
     * Berikut ini adalah cara menggunakan kelas java.util.Scanner dengan benar
     * untuk membaca input pengguna dari System.in secara interaktif dengan benar
     * (terkadang disebut sebagai stdin, terutama dalam C, C++ dan bahasa lain serta
     * di Unix dan Linux). Ini secara idiomatis menunjukkan hal-hal paling umum yang
     * diminta untuk dilakukan.
     */

    /*
     * package com.stackoverflow.scanner;
     * import javax.annotation.Nonnull;
     * import java.math.BigInteger;
     * import java.net.MalformedURLException;
     * import java.net.URL;
     * import java.util.*;
     * import java.util.regex.Pattern;
     * import static java.lang.String.format;
     * public class ScannerExample
     * {
     * private static final Set<String> EXIT_COMMANDS;
     * private static final Set<String> HELP_COMMANDS;
     * private static final Pattern DATE_PATTERN;
     * private static final String HELP_MESSAGE;
     * static
     * {
     * final SortedSet<String> ecmds = new
     * TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
     * ecmds.addAll(Arrays.asList("exit", "done", "quit", "end", "fino"));
     * EXIT_COMMANDS = Collections.unmodifiableSortedSet(ecmds);
     * final SortedSet<String> hcmds = new
     * TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
     * hcmds.addAll(Arrays.asList("help", "helpi", "?"));
     * HELP_COMMANDS = Collections.unmodifiableSet(hcmds);
     * DATE_PATTERN = Pattern.compile("\\d{4}([-\\/])\\d{2}\\1\\d{2}"); //
     * http://regex101.com/r/xB8dR3/1
     * HELP_MESSAGE = format("Please enter some data or enter one of the following
     * commands to
     * exit %s", EXIT_COMMANDS);
     * }
     * 
     * Using exceptions to control execution flow is always bad.
     * That is why this is encapsulated in a method, this is done this
     * way specifically so as not to introduce any external libraries
     * so that this is a completely self contained example.
     * 
     * @param s possible url
     * 
     * @return true if s represents a valid url, false otherwise
     * 
     * private static boolean isValidURL(@Nonnull final String s)
     * {
     * try { new URL(s); return true; }
     * catch (final MalformedURLException e) { return false; }
     * }
     * private static void output(@Nonnull final String format, @Nonnull final
     * Object... args)
     * {
     * System.out.println(format(format, args));
     * }
     * public static void main(final String[] args)
     * {
     * final Scanner sis = new Scanner(System.in);
     * output(HELP_MESSAGE);
     * while (sis.hasNext())
     * {
     * if (sis.hasNextInt())
     * {
     * final int next = sis.nextInt();
     * output("You entered an Integer = %d", next);
     * }
     * else if (sis.hasNextLong())
     * {
     * final long next = sis.nextLong();
     * output("You entered a Long = %d", next);
     * }
     * else if (sis.hasNextDouble())
     * {
     * final double next = sis.nextDouble();
     * output("You entered a Double = %f", next);
     * }
     * else if (sis.hasNext("\\d+"))
     * {
     * final BigInteger next = sis.nextBigInteger();
     * output("You entered a BigInteger = %s", next);
     * }
     * else if (sis.hasNextBoolean())
     * {
     * final boolean next = sis.nextBoolean();
     * output("You entered a Boolean representation = %s", next);
     * }
     * else if (sis.hasNext(DATE_PATTERN))
     * {
     * final String next = sis.next(DATE_PATTERN);
     * output("You entered a Date representation = %s", next);
     * }
     * else // unclassified
     * {
     * final String next = sis.next();
     * if (isValidURL(next))
     * {
     * output("You entered a valid URL = %s", next);
     * }
     * else
     * {
     * if (EXIT_COMMANDS.contains(next))
     * {
     * output("Exit command %s issued, exiting!", next);
     * break;
     * }
     * else if (HELP_COMMANDS.contains(next)) { output(HELP_MESSAGE); }
     * else { output("You entered an unclassified String = %s", next); }
     * }
     * }
     * }
     * 
     * This will close the underlying Readable, in this case System.in, and free
     * those resources.
     * You will not be to read from System.in anymore after this you call .close().
     * If you wanted to use System.in for something else, then don't close the
     * Scanner.
     * 
     * sis.close();
     * System.exit(0);
     * }
     * }
     * 
     */

    private static final Set<String> EXIT_COMMANDS;
    private static final Set<String> HELP_COMMANDS;
    private static final Pattern DATE_PATTERN;
    private static final String HELP_MESSAGE;
    static {
        final SortedSet<String> ecmds = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        ecmds.addAll(Arrays.asList("exit", "done", "quit", "end", "fino"));
        EXIT_COMMANDS = Collections.unmodifiableSortedSet(ecmds);
        final SortedSet<String> hcmds = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        hcmds.addAll(Arrays.asList("help", "helpi", "?"));
        HELP_COMMANDS = Collections.unmodifiableSet(hcmds);
        DATE_PATTERN = Pattern.compile("\\d{4}([-\\/])\\d{2}\\1\\d{2}"); // http://regex101.com/r/xB8dR3/1
        HELP_MESSAGE = format("Please enter some data or enter one of the following commands to exit %s",
                EXIT_COMMANDS);
    }

    /**
     * Using exceptions to control execution flow is always bad.
     * That is why this is encapsulated in a method, this is done this
     * way specifically so as not to introduce any external libraries
     * so that this is a completely self contained example.
     * 
     * @param s
     *            possible url
     * @return true if s represents a valid url, false otherwise
     */
    private static boolean isValidURL(@Nonnull final String s) {
        try {
            new URL(s);
            return true;
        } catch (final MalformedURLException e) {
            return false;
        }
    }

    private static void output(@Nonnull final String format, @Nonnull final Object... args) {
        System.out.println(format(format, args));
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // ------------------------------------
        final Scanner sis = new Scanner(System.in);
        output(HELP_MESSAGE);
        while (sis.hasNext()) {
            if (sis.hasNextInt()) {
                final int next = sis.nextInt();
                output("You entered an Integer = %d", next);
            } else if (sis.hasNextLong()) {
                final long next = sis.nextLong();
                output("You entered a Long = %d", next);
            } else if (sis.hasNextDouble()) {
                final double next = sis.nextDouble();
                output("You entered a Double = %f", next);
            } else if (sis.hasNext("\\d+")) {
                final BigInteger next = sis.nextBigInteger();
                output("You entered a BigInteger = %s", next);
            } else if (sis.hasNextBoolean()) {
                final boolean next = sis.nextBoolean();
                output("You entered a Boolean representation = %s", next);
            } else if (sis.hasNext(DATE_PATTERN)) {
                final String next = sis.next(DATE_PATTERN);
                output("You entered a Date representation = %s", next);
            } else // unclassified
            {
                final String next = sis.next();
                if (isValidURL(next)) {
                    output("You entered a valid URL = %s", next);
                } else {
                    if (EXIT_COMMANDS.contains(next)) {
                        output("Exit command %s issued, exiting!", next);
                        break;
                    } else if (HELP_COMMANDS.contains(next)) {
                        output(HELP_MESSAGE);
                    } else {
                        output("You entered an unclassified String = %s", next);
                    }
                }
            }
        }

        /*
         * This will close the underlying Readable, in this case System.in, and free
         * those resources.
         * You will not be to read from System.in anymore after this you call .close().
         * If you wanted to use System.in for something else, then don't close the
         * Scanner.
         */
        sis.close();
        System.exit(0);

        /*
         * output:
         * Please enter some data or enter one of the following commands to exit [done,
         * end, exit, fino, quit]
         * done
         * Exit command done issued, exiting!
         */

    }
}
