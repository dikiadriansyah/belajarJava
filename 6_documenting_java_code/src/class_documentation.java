// contoh
/**
 * Brief summary of this class, ending with a period.
 *
 * It is common to leave a blank line between the summary and further details.
 * The summary (everything before the first period) is used in the class or
 * package
 * overview section.
 *
 * The following inline tags can be used (not an exhaustive list):
 * {@link some.other.class.Documentation} for linking to other docs or symbols
 * {@link some.other.class.Documentation Some Display Name} the link's
 * appearance can be
 * customized by adding a display name after the doc or symbol locator
 * {@code code goes here} for formatting as code
 * {@literal <>[]()foo} for interpreting literal text without converting to HTML
 * markup
 * or other tags.
 *
 * Optionally, the following tags may be used at the end of class documentation
 * (not an exhaustive list):
 *
 * @author John Doe
 * @version 1.0
 * @since 5/10/15
 * @see some.other.class.Documentation
 * @deprecated This class has been replaced by
 *             some.other.package.BetterFileReader
 *
 *             * You can also have custom tags for displaying additional
 *             information.
 *             Using the @custom.<NAME> tag and the -tag
 *             custom.<NAME>:htmltag:"context"
 *             command line option, you can create a custom tag.
 *
 *             Example custom tag and generation:
 * @custom.updated 2.0
 *                 Javadoc flag: -tag custom.updated:a:"Updated in version:"
 *                 The above flag will display the value of @custom.updated
 *                 under "Updated in version:"
 *
 */

// tag dan format yang sama yang digunakan untuk classes juga dapat digunakan
// untuk enum dan interface.

public class class_documentation {

    // Class Documentation / Dokumentasi Kelas

    /**
     * semua komentar javadoc dimulai dengan komentar blokir diikuti dengan tanda
     * bintang(/**) dan berakhir ketika komentar blokir. Secara opsional, setiap
     * baris dapat dimulai dengan spasi kosong dan tanda bintang tunggal; ini
     * diabaikan ketika file dokumentasi dibuat.
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");

    }
}
