import java.io.*;
import java.lang.*;
import java.util.*;

public class Sorting_arrays {
    // Sorting arrays
    /*
     * Penyortiran array dapat dengan mudah dilakukan dengan api Array.
     */
    public static void main(String[] args) {
        // creating an array with integers
        // int[] array = { 7, 4, 2, 1, 19 };
        // this is the sorting part just one function ready to be used
        // Arrays.sort(array);
        // prints [1, 2, 4, 7, 19]
        // System.out.println(Arrays.toString(array)); // [1, 2, 4, 7, 19]

        // Sorting String arrays(Menyortir array String):
        /*
         * String bukanlah data numerik, ia mendefinisikan urutannya sendiri yang
         * disebut urutan leksikografis, juga dikenal sebagai urutan abjad. Saat Anda
         * mengurutkan array String menggunakan metode sort(), array akan diurutkan ke
         * dalam urutan alami yang ditentukan oleh Comparable interface, seperti yang
         * ditunjukkan di bawah ini:
         */

        // Increasing Order
        // String[] names = { "John", "Steve", "Shane", "Adam", "Ben" };
        // System.out.println("String array before sorting : " +
        // Arrays.toString(names));
        // Arrays.sort(names);
        // System.out.println("String array after sorting in ascending order : " +
        // Arrays.toString(names));
        /*
         * output:
         * String array before sorting : [John, Steve, Shane, Adam, Ben]
         * String array after sorting in ascending order : [Adam, Ben, John, Shane,
         * Steve]
         */

        // Decreasing Order
        // Arrays.sort(names, 0, names.length, Collections.reverseOrder());
        // System.out.println("String array after sorting in descending order : " +
        // Arrays.toString(names));
        /*
         * output:
         * String array after sorting in descending order : [Steve, Shane, John, Ben,
         * Adam]
         */

        // Sorting an Object array(Menyortir array Objek)
        /*
         * Untuk mengurutkan array objek, semua elemen harus mengimplementasikan
         * antarmuka Comparable atau Comparator untuk menentukan urutan pengurutan.
         * 
         * Kita dapat menggunakan salah satu metode sort(Object[]) untuk mengurutkan
         * array objek berdasarkan urutan alaminya, namun Anda harus memastikan bahwa
         * semua elemen dalam array harus mengimplementasikan Comparable.
         * 
         * Selain itu, keduanya juga harus saling sebanding, misalnya e1.compareTo(e2)
         * tidak boleh memunculkan ClassCastException untuk elemen apa pun e1 dan e2
         * dalam array. Alternatifnya, Anda dapat mengurutkan array Objek pada urutan
         * khusus menggunakan metode sortir(T[], Comparator) seperti yang ditunjukkan
         * dalam contoh berikut.
         */
        // How to Sort Object Array in Java using Comparator and Comparable
        Course[] courses = new Course[4];
        courses[0] = new Course(101, "Java", 200);
        courses[1] = new Course(201, "Ruby", 300);
        courses[2] = new Course(301, "Python", 400);
        courses[3] = new Course(401, "Scala", 500);

        System.out.println("Object array before sorting : " + Arrays.toString(courses));
        /*
         * output:
         * Object array before sorting : [#101 Java@200, #201 Ruby@300, #301 Python@400,
         * #401 Scala@500]
         */

        Arrays.sort(courses);
        System.out.println("Object array after sorting in natural order : " + Arrays.toString(courses));

        Arrays.sort(courses, new Course.PriceComparator());
        System.out.println("Object array after sorting by price : " + Arrays.toString(courses));

        Arrays.sort(courses, new Course.NameComparator());
        System.out.println("Object array after sorting by name : " + Arrays.toString(courses));
        /*
         * output:
         * Object array after sorting in natural order : [#101 Java@200, #201 Ruby@300,
         * #301 Python@400, #401 Scala@500]
         * Object array after sorting by price : [#101 Java@200, #201 Ruby@300, #301
         * Python@400, #401 Scala@500]
         * Object array after sorting by name : [#101 Java@200, #301 Python@400, #201
         * Ruby@300, #401 Scala@500]
         */
    }
}
