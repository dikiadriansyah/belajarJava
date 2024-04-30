import java.util.*;

public class Example_without_mutable_refs {
    // Example without mutable refs / Contoh tanpa referensi yang bisa berubah

    /*
     * Objek yang tidak dapat diubah adalah objek yang statusnya tidak berubah
     * setelah diinisialisasi. Misalnya, String adalah kelas yang tidak dapat diubah
     * dan setelah dibuat nilainya tidak akan pernah berubah
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Create a new color object
        Color2 myColor = new Color2(50, 100, 150);

        // Print the original color
        System.out.println("Original Color: " + myColor);
        /*
         * output:
         * Original Color: Color@2401f4c3
         */

        // Invert the color
        Color2 invertedColor = myColor.invert();

        // Print the inverted color
        System.out.println("Inverted Color: " + invertedColor);
        /*
         * output:
         * Inverted Color: Color@3419866c
         */
    }

}
