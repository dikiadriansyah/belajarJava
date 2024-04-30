import java.util.Optional;

public class FlatMap {
    // FlatMap

    /*
     * flatMap mirip dengan map. Perbedaannya dijelaskan oleh javadoc sebagai
     * berikut:
     * 
     * Metode ini mirip dengan map(Function), namun mapper yang disediakan adalah
     * mapper yang hasilnya sudah berupa Optional, dan jika dipanggil, flatMap tidak
     * membungkusnya dengan Optional tambahan.
     */

    /*
     * Dengan kata lain, saat Anda merangkai pemanggilan metode yang mengembalikan
     * Optional, penggunaan Optional.flatMap akan menghindari pembuatan Opsional
     * bersarang.
     */

    // Misalnya, diberikan kelas-kelas berikut:

    /*
     * public class Foo {
     * Optional<Bar> getBar(){
     * return Optional.of(new Bar());
     * }
     * }
     * public class Bar {
     * }
     */

    /*
     * Jika Anda menggunakan Optional.map, Anda akan mendapatkan Opsional bersarang;
     * yaitu Opsional<Opsional<Bar>>.
     */

    /*
     * Optional<Optional<Bar>> nestedOptionalBar =
     * Optional.of(new Foo())
     * .map(Foo::getBar);
     * 
     */

    /*
     * Namun, jika Anda menggunakan Optional.flatMap, Anda akan mendapatkan Opsional
     * sederhana; yaitu Opsional<Bar>.
     * 
     * Optional<Bar> optionalBar =
     * Optional.of(new Foo())
     * .flatMap(Foo::getBar);
     */

    public static void main(String[] args) {
        Optional<Optional<Bar>> nestedOptionalBar = Optional.of(new Foo())
                .map(Foo::getBar);

        // Output nestedOptionalBar
        System.out.println("Nested Optional<Bar>: " + nestedOptionalBar);

        // Unwrap the nested Optional
        Optional<Bar> unwrappedBar = nestedOptionalBar.orElseGet(Optional::empty);

        // Output the unwrapped Optional<Bar>
        unwrappedBar.ifPresent(bar -> System.out.println("Unwrapped Optional<Bar>: " + bar));

        /*
         * output:
         * Nested Optional<Bar>: Optional[Optional[Bar{name='Default Bar'}]]
         * Unwrapped Optional<Bar>: Bar{name='Default Bar'}
         */

    }
}
