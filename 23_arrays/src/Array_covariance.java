import java.util.Arrays;
import java.util.List;

public class Array_covariance {
    // Array Covariance
    /*
     * Array objek bersifat kovarian, yang berarti bahwa sama seperti Integer adalah
     * subclass dari Number, Integer[] adalah subclass dari Number[].
     * Ini mungkin tampak intuitif, namun dapat mengakibatkan perilaku yang
     * mengejutkan:
     */

    public static void main(String[] args) {
        Integer[] integerArray = { 1, 2, 3 };
        Number[] numberArray = integerArray; // valid
        Number firstElement = numberArray[0]; // valid
        // System.out.println(firstElement); // [1]

        // numberArray[0] = 4L; // throws ArrayStoreException at runtime
        /*
         * Meskipun Integer[] adalah subkelas dari Number[], ia hanya dapat menampung
         * Integer, dan mencoba menetapkan elemen Long akan memunculkan pengecualian
         * runtime.
         * 
         * Perhatikan bahwa perilaku ini unik untuk array, dan dapat dihindari dengan
         * menggunakan List generik:
         * 
         */

        List<Integer> box1 = Arrays.asList(1, 2, 3);
        // List<Number> box2 = box1; // compile error
        List<? extends Number> box2 = box1;
        Number box3 = box2.get(0);
        // box3.set(0, 4L); // compile error

        System.out.println(box3); // 1

        /*
         * Semua elemen array tidak perlu memiliki tipe yang sama, asalkan elemen
         * tersebut merupakan subkelas dari tipe array:
         * interface I {
         * }
         * 
         * class A implements I {
         * }
         * 
         * class B implements I {
         * }
         * 
         * class C implements I {
         * 
         * };
         * I[] array10 = new I[] { new A(), new B(), new C() }; // Create an array with
         * new
         * // operator and array initializer.
         * I[] array11 = { new A(), new B(), new C() }; // Shortcut syntax with array
         * // initializer.
         * I[] array12 = new I[3]; // { null, null, null }
         * I[] array13 = new A[] { new A(), new A() }; // Works because A implements I.
         * Object[] array14 = new Object[] { "Hello, World!", 3.14159, 42 }; // Create
         * an array with
         * // new operator and array initializer.
         * Object[] array15 = { new A(), 64, "My String" }; // Shortcut syntax
         * // with array initializer.
         */

    }
}
