import java.util.function.IntConsumer;
import java.util.function.Consumer;

public class return_only_returns_from_the_lambda_not_the_outer_method {
    // `return` only returns from the lambda, not the outer method / `return` hanya
    // mengembalikan dari lambda, bukan metode luar

    /*
     * Metode pengembalian hanya mengembalikan dari lambda, bukan metode luar.
     * 
     * Berhati-hatilah karena ini berbeda dengan Scala dan Kotlin!
     * 
     * void threeTimes(IntConsumer r) {
     * for (int i = 0; i < 3; i++) {
     * r.accept(i);
     * }
     * }
     * 
     * void demo() {
     * threeTimes(i -> {
     * System.out.println(i);
     * return; // Return from lambda to threeTimes only!
     * });
     * }
     * 
     * 
     */

    /*
     * Hal ini dapat menyebabkan perilaku yang tidak terduga ketika mencoba menulis
     * konstruksi bahasa sendiri, karena dalam konstruksi bawaan seperti for loops
     * return berperilaku berbeda:
     * void demo2() {
     * for (int i = 0; i < 3; i++) {
     * System.out.println(i);
     * return; // Return from 'demo2' entirely
     * }
     * }
     */

    /*
     * Di Scala dan Kotlin, demo dan demo2 hanya akan mencetak 0. Namun hal ini
     * tidak lebih konsisten. Pendekatan Java konsisten dengan pemfaktoran ulang dan
     * penggunaan kelas - return kode di atas, dan kode di bawah ini berperilaku
     * sama:
     * 
     * void demo3() {
     * threeTimes(new MyIntConsumer());
     * }
     * class MyIntConsumer implements IntConsumer {
     * public void accept(int i) {
     * System.out.println(i);
     * return;
     * }
     * }
     * 
     */

    /*
     * Oleh karena itu, return Java lebih konsisten dengan metode kelas dan
     * pemfaktoran ulang, tetapi kurang konsisten dengan bawaan for dan while, namun
     * tetap istimewa.
     * Oleh karena itu, dua hal berikut ini setara di Java:
     * 
     * IntStream.range(1, 4)
     * .map(x -> x * x)
     * .forEach(System.out::println);
     * IntStream.range(1, 4)
     * .map(x -> { return x * x; })
     * .forEach(System.out::println);
     */

    /*
     * Selain itu, penggunaan try-with-resources aman di Java:
     * class Resource implements AutoCloseable {
     * public void close() { System.out.println("close()"); }
     * }
     * void executeAround(Consumer<Resource> f) {
     * try (Resource r = new Resource()) {
     * System.out.print("before ");
     * f.accept(r);
     * System.out.print("after ");
     * }
     * }
     * void demo4() {
     * executeAround(r -> {
     * System.out.print("accept() ");
     * return; // Does not return from demo4, but frees the resource.
     * });
     * }
     */

    /*
     * akan mencetak sebelum accept() setelah close(). Dalam semantik Scala dan
     * Kotlin, sumber daya coba-dengan-tidak akan ditutup, tetapi hanya akan dicetak
     * sebelum accept().
     */

    void executeAround(Consumer<Resource> f) {
        try (Resource r = new Resource()) {
            System.out.print("before ");
            f.accept(r);
            System.out.print("after ");
        }
    }

    void demo4() {
        executeAround(r -> {
            System.out.print("accept() ");
            return; // Does not return from demo4, but frees the resource.
        });
    }

    public static void main(String[] args) {
        // return_only_returns_from_the_lambda_not_the_outer_method box1 = new
        // return_only_returns_from_the_lambda_not_the_outer_method();
        // box1.demo();
        /*
         * output:
         * 0
         * 1
         * 2
         */

        // box1.demo2();
        /*
         * output:
         * 0
         */

        // box1.demo3();
        /*
         * output:
         * 0
         * 1
         * 2
         */
        // ----------
        return_only_returns_from_the_lambda_not_the_outer_method demo = new return_only_returns_from_the_lambda_not_the_outer_method();
        demo.demo4(); // output: before accept() after close()
    }

    // void threeTimes(IntConsumer r) {
    // for (int i = 0; i < 3; i++) {
    // r.accept(i);
    // }
    // }

    // void demo() {
    // threeTimes(i -> {
    // System.out.println(i);
    // return; // Return from lambda to threeTimes only!
    // });
    // }

    // void demo2() {
    // for (int i = 0; i < 3; i++) {
    // System.out.println(i);
    // return; // Return from 'demo2' entirely
    // }
    // }

    // void demo3() {
    // threeTimes(new MyIntConsumer());
    // }

    // static class MyIntConsumer implements IntConsumer {
    // public void accept(int i) {
    // System.out.println(i);
    // return;
    // }
    // }

}
