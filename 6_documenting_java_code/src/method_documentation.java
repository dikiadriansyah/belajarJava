import java.io.InputStream;

public class method_documentation {

    // Method Documentation / metode dokumentasi

    // semua komentar javadoc dimulai dengan komentar blokir diikuti dengan tanda
    // bintang (/**) dan berakhir ketika komentar blokir(*/). secara opsional,
    // setiap baris dapat dimulai dengan spasi kosong dan tanda bintang tunggal; ini
    // diabaikan ketika file dokumentasi dihasilkan.

    public String[] read(InputStream stream) {
        return null;

        /**
         * Brief summary of method, ending with a period.
         *
         * Further description of method and what it does, including as much detail as
         * is
         * appropriate. Inline tags such as
         * {@code code here}, {@link some.other.Docs}, and {@literal text here} can be
         * used.
         *
         * If a method overrides a superclass method, {@inheritDoc} can be used to copy
         * the
         * documentation
         * from the superclass method
         *
         * @param stream Describe this parameter. Include as much detail as is
         *               appropriate
         *               Parameter docs are commonly aligned as here, but this is
         *               optional.
         *               As with other docs, the documentation before the first period
         *               is
         *               used as a summary.
         *
         * @return Describe the return values. Include as much detail as is appropriate
         *         Return type docs are commonly aligned as here, but this is optional.
         *         As with other docs, the documentation before the first period is used
         *         as a
         *         summary.
         *
         * @throws IOException Describe when and why this exception can be thrown.
         *                     Exception docs are commonly aligned as here, but this is
         *                     optional.
         *                     As with other docs, the documentation before the first
         *                     period
         *                     is used as a summary.
         *                     Instead of @throws, @exception can also be used.
         *
         * @since 2.1.0
         * @see some.other.class.Documentation
         * @deprecated Describe why this method is outdated. A replacement can also be
         *             specified.
         */

    }
}
