import java.util.*;
import java.util.Arrays;
import java.util.Date;

public class clone_method implements Cloneable {
    // clone() method

    /*
     * Metode clone() digunakan untuk membuat dan mengembalikan salinan suatu objek.
     * Cara ini boleh dibilang sebaiknya dihindari
     * bermasalah dan konstruktor penyalinan atau pendekatan penyalinan lain harus
     * digunakan untuk mendukung clone().
     * 
     * 
     * Agar metode dapat digunakan, semua kelas yang memanggil metode tersebut harus
     * mengimplementasikan Cloneable interface.
     * 
     * Antarmuka Cloneable sendiri hanyalah antarmuka tag yang digunakan untuk
     * mengubah perilaku metode clone() asli yang memeriksa apakah kelas objek
     * pemanggil mengimplementasikan Cloneable. Jika pemanggil tidak
     * mengimplementasikan antarmuka ini, CloneNotSupportedException akan dilempar.
     * 
     * Kelas Object sendiri tidak mengimplementasikan antarmuka ini sehingga
     * CloneNotSupportedException akan dilempar jika objek pemanggil adalah objek
     * kelas.
     * 
     * Agar suatu klon benar, ia harus independen terhadap objek asal klonnya, oleh
     * karena itu mungkin perlu memodifikasi objek tersebut sebelum dikembalikan.
     * Ini pada dasarnya berarti membuat "salinan dalam" dengan juga menyalin objek
     * mana pun yang dapat diubah yang membentuk struktur internal objek yang
     * dikloning. Jika ini tidak
     * diimplementasikan dengan benar, objek yang dikloning tidak akan independen
     * dan memiliki referensi yang sama ke objek yang dapat diubah dengan objek asal
     * kloningnya. Hal ini akan menghasilkan perilaku yang tidak konsisten karena
     * setiap perubahan pada salah satu hal akan mempengaruhi perubahan lainnya.
     * 
     */

    int w;
    String x;
    float[] y;
    Date z;

    public clone_method clone() {

        clone_method result = new clone_method();
        // copy primitives by value
        result.w = this.w;
        // immutable objects like String can be copied by reference
        result.x = this.x;

        // The field y refers to a mutable object (array); clone it manually.
        if (this.y != null) {
            result.y = Arrays.copyOf(this.y, this.y.length);
        }

        // The field z refers to a mutable object (Date); clone it.
        if (this.z != null) {
            result.z = (Date) this.z.clone();
        }

        // Done, return the new object
        return result;

    }

    public static void main(String[] args) {
        // Create an instance of Foo
        clone_method original = new clone_method();
        original.w = 42;
        original.x = "Hello";
        original.y = new float[] { 1.0f, 2.0f, 3.0f };
        original.z = new Date();

        // Clone the instance
        clone_method cloned = original.clone();

        // Modify the cloned instance to see if it's a deep copy
        cloned.w = 99;
        cloned.x = "World";
        cloned.y[0] = 10.0f;
        cloned.z.setTime(System.currentTimeMillis() + 1000); // Add one second

        // Print original and cloned instances
        System.out.println("Original: " + original.toString());
        System.out.println("Cloned:   " + cloned.toString());

        /*
         * output:
         * Original: clone_method@41a4555e
         * Cloned: clone_method@59690aa4
         */

    }
}
