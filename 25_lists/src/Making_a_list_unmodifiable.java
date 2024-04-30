import java.util.*;

public class Making_a_list_unmodifiable {
    // Making a list unmodifiable

    public static void main(String[] args) {
        /*
         * Kelas Collections menyediakan cara untuk membuat daftar tidak dapat
         * dimodifikasi:
         */
        List<String> ls = new ArrayList<String>();

        ls.add("Java");
        ls.add("Python");
        ls.add("C++");
        List<String> unmodifiableList = Collections.unmodifiableList(ls);

        System.out.println(unmodifiableList); // [Java, Python, C++]

        /*
         * Jika Anda menginginkan daftar yang tidak dapat dimodifikasi dengan satu item,
         * Anda dapat menggunakan:
         */

        // List<String> unmodifiableList2 = Collections.singletonList("Only string in
        // the list");
        // System.out.println(unmodifiableList2); // [Only string in the list]
    }
}
