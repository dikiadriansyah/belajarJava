import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Declaring_a_generic_method {
    // Declaring a Generic Method / Mendeklarasikan Metode Generik

    // Metode juga dapat memiliki parameter tipe generik.
    /*
     * public class Example {
     * // The type parameter T is scoped to the method
     * // and is independent of type parameters of other methods.
     * public <T> List<T> makeList(T t1, T t2) {
     * List<T> result = new ArrayList<T>();
     * result.add(t1);
     * result.add(t2);
     * return result;
     * }
     * public void usage() {
     * List<String> listString = makeList("Jeff", "Atwood");
     * List<Integer> listInteger = makeList(1, 2);
     * }
     * }
     */

    /*
     * Perhatikan bahwa kita tidak harus meneruskan argumen tipe aktual ke metode
     * generik. Kompiler menyimpulkan argumen tipe untuk kita, berdasarkan tipe
     * target (misalnya variabel yang kita tetapkan hasilnya), atau berdasarkan tipe
     * argumen sebenarnya. Biasanya akan menyimpulkan argumen tipe paling spesifik
     * yang akan membuat tipe panggilan menjadi benar.
     * 
     * Terkadang, meskipun jarang, inferensi tipe ini perlu diganti dengan argumen
     * tipe eksplisit:
     * 
     * void usage() {
     * consumeObjects(this.<Object>makeList("Jeff", "Atwood").stream());
     * }
     * void consumeObjects(Stream<Object> stream) { ... }
     */

    /*
     * Hal ini diperlukan dalam contoh ini karena kompiler tidak dapat
     * "melihat ke depan" untuk melihat bahwa Objek diinginkan untuk T setelah
     * memanggil stream() dan sebaliknya akan menyimpulkan String berdasarkan
     * argumen makeList. Perhatikan bahwa bahasa Java tidak mendukung penghilangan
     * kelas atau objek tempat metode dipanggil (ini ada pada contoh di atas)
     * ketika argumen tipe diberikan secara eksplisit.
     */

    // The type parameter T is scoped to the method
    // and is independent of type parameters of other methods.
    public <T> List<T> makeList(T t1, T t2) {
        List<T> result = new ArrayList<T>();
        result.add(t1);
        result.add(t2);
        return result;
    }

    public void usage() {
        List<String> listString = makeList("Jeff", "Atwood");
        List<Integer> listInteger = makeList(1, 2);

        System.out.println("List of Strings: " + listString);
        System.out.println("List of Integers: " + listInteger);
    }

    public static void main(String[] args) {
        Declaring_a_generic_method box = new Declaring_a_generic_method();
        box.usage();
        /*
         * output:
         * List of Strings: [Jeff, Atwood]
         * List of Integers: [1, 2]
         */
    }
}
