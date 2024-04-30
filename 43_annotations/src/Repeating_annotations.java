import java.lang.annotation.*;

// @Authors({
//         @Author("Mary"),
//         @Author("Sam")
// })

public class Repeating_annotations {
    // Repeating Annotations / Anotasi Berulang

    /*
     * Hingga Java 8, dua contoh anotasi yang sama tidak dapat diterapkan pada satu
     * elemen. Solusi standarnya adalah dengan menggunakan anotasi container yang
     * menyimpan array dari beberapa anotasi lainnya:
     */

    public static void main(String[] args) {
        // Author[] authors =
        // Repeating_annotations.class.getAnnotation(Authors.class).value();
        // for (Author author : authors) {
        // System.out.println(author.value());
        // // Output:
        // // Mary
        // // Sam
        // }

        // ---------------------------------
        // Version ≥ Java SE 8
        /*
         * Java 8 menyediakan cara yang lebih bersih dan transparan dalam menggunakan
         * anotasi container, menggunakan anotasi @Repeatable.
         * Pertama kita menambahkan ini ke kelas Author:
         */
        // @Repeatable(Authors.class)

        /*
         * Ini memberitahu Java untuk memperlakukan beberapa anotasi @Author seolah-olah
         * dikelilingi oleh wadah @Authors.
         * Kita juga bisa menggunakan Class.getAnnotationsByType() untuk mengakses
         * array @Author berdasarkan kelasnya sendiri, bukan melalui containernya:
         */
        Author[] authors = Repeating_annotations.class.getAnnotationsByType(Author.class);
        for (Author author : authors) {
            System.out.println(author.value());
            // Output:
            // Mary
            // Sam
        }
    }
}
