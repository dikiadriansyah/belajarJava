import java.lang.annotation.*;

public class Annotations {
    // Annotations/Anotasi

    // Anotasi deklarasi harus diletakkan pada baris terpisah dari deklarasi yang
    // diberi anotasi.

    /*
     * @SuppressWarnings("unchecked")
     * public T[] toArray(T[] typeHolder) {
     * ...
     * }
     */

    /*
     * Namun, sedikit atau anotasi singkat yang menganotasi metode satu baris dapat
     * ditempatkan pada baris yang sama dengan metode jika metode tersebut
     * meningkatkan keterbacaan. Misalnya, seseorang mungkin menulis:
     * 
     * @Nullable String getName() { return name; }
     * 
     */

    /*
     * Demi konsistensi dan keterbacaan, semua anotasi harus diletakkan pada baris
     * yang sama atau setiap anotasi harus ditempatkan pada baris terpisah.
     * 
     * // Bad.
     * 
     * @Deprecated @SafeVarargs
     * 
     * @CustomAnnotation
     * public final Tuple<T> extend(T... elements) {
     * ...
     * }
     * // Even worse.
     * 
     * @Deprecated @SafeVarargs
     * 
     * @CustomAnnotation public final Tuple<T> extend(T... elements) {
     * ...
     * }
     * // Good.
     * 
     * @Deprecated
     * 
     * @SafeVarargs
     * 
     * @CustomAnnotation
     * public final Tuple<T> extend(T... elements) {
     * ...
     * }
     * // Good.
     * 
     * @Deprecated @SafeVarargs @CustomAnnotation
     * public final Tuple<T> extend(T... elements) {
     * ...
     * }
     * 
     * 
     */
    // ---------------
    @Deprecated
    @SafeVarargs
    // @CustomAnnotation
    public final <T> Tuple<T> extend(T... elements) {
        return new Tuple<>(elements);
    }

    // Good.
    @Deprecated
    @SafeVarargs
    // @CustomAnnotation
    public final <T> Tuple<T> extendGood(T... elements) {
        return new Tuple<>(elements);
    }

    public static void main(String[] args) throws Exception {
        Annotations main = new Annotations();
        Tuple<Integer> tuple = main.extend(1, 2, 3);
        System.out.println("Tuple elements: " + String.join(", ", mapToString(tuple.getElements()))); // output: Tuple
                                                                                                      // elements: 1, 2,
                                                                                                      // 3

        Tuple<Integer> tupleGood = main.extendGood(4, 5, 6);
        System.out.println("Tuple elements (Good): " + String.join(", ", mapToString(tupleGood.getElements())));
        /*
         * output:
         * Tuple elements (Good): 4, 5, 6
         */
    }

    private static <T> String[] mapToString(T[] array) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = String.valueOf(array[i]);
        }
        return result;
    }

}
