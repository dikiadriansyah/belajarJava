package com.example.foo;

public class Code_snippets_inside_documentation {

    // Code snippets inside documentation / Cuplikan kode di dalam dokumentasi

    // cara kanonik untuk menulis kode di dalam dokumentasi adalah dengan {@code}
    // construct
    // Jika Anda memiliki kode multiline bungkus di dalam<pre></pre>.

    /**
     * The Class TestUtils.
     * <p>
     * This is an {@code inline("code example")}.
     * <p>
     * You should wrap it in pre tags when writing multiline code.
     * 
     * <pre>{@code
     * Example example1 = new FirstLineExample();
     * example1.butYouCanHaveMoreThanOneLine();
     * }</pre>
     * <p>
     * Thanks for reading.
     */

    // Terkadang Anda mungkin perlu memasukkan beberapa kode kompleks di dalam
    // komentar javadoc. Tanda @ secara khusus bermasalah. penggunaan tag <code>
    // lama di samping konstruk {@literal} memecahkan masalah.

    /**
     * Usage:
     * 
     * <pre><code>
     * class SomethingTest {
     * {@literal @}Rule
     * * public SingleTestRule singleTestRule = new SingleTestRule("test1");
     *
     * {@literal @}Test
     * public void test1() {
     * // only this test will be executed
     * }
     *
     * ...
     * }
     * </code></pre>
     */

    // class SingleTestRule implements TestRule { }

}
