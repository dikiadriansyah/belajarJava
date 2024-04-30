package com.example.foo;

public class links {

    // Links

    // menautkan ke javadoc lain dilakukan dengan tag @link:

    /**
     * You can link to the javadoc of an already imported class using
     * {@link ClassName}.
     *
     * You can also use the fully-qualified name, if the class is not already
     * imported:
     * {@link some.other.ClassName}
     *
     * You can link to members (fields or methods) of a class like so:
     * {@link ClassName#someMethod()}
     * {@link ClassName#someMethodWithParameters(int, String)}
     * {@link ClassName#someField}
     * {@link #someMethodInThisClass()} - used to link to members in the current
     * class
     *
     * You can add a label to a linked javadoc like so:
     * {@link ClassName#someMethod() link text}
     */

    // Dengan tag @see Anda dapat menambahkan elemen ke bagian Lihat juga. Suka
    // @param atau @return tempat kemunculannya tidak relevan. Spec mengatakan Anda
    // harus menulisnya setelah @return.

    /**
     * This method has a nice explanation but you might found further
     * information at the bottom.
     *
     * @see ClassName#someMethod()
     */

    // Jika Anda ingin menambahkan tautan ke sumber daya eksternal, Anda cukup
    // menggunakan tag HTML <a>. Anda dapat menggunakannya sebaris di mana saja atau
    // di dalam tag @link dan @see

    /**
     * Wondering how this works? You might want
     * to check this <a href="http://stackoverflow.com/">great service</a>.
     *
     * @see <a href="http://stackoverflow.com/">Stack Overflow</a>
     */

}
