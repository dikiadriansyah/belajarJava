import java.util.*;
import java.util.stream.*;

public class Iterating_over_arrays {
    // Iterating over arrays

    // Anda dapat mengulangi array dengan menggunakan loop for yang ditingkatkan
    // (alias foreach) atau dengan menggunakan indeks array:
    public static void main(String[] args) {
        // int[] array = new int[10];
        // using indices: read and write
        // for (int i = 0; i < array.length; i++) {
        // array[i] = i;
        // }

        // Version ≥ Java SE 5
        // extended for: read only
        // for (int e : array) {
        // System.out.println(e);
        // }
        /*
         * output:
         * 0
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * 
         */

        /*
         * Perlu dicatat di sini bahwa tidak ada cara langsung untuk menggunakan
         * Iterator pada Array, tetapi melalui perpustakaan Array, Iterator dapat dengan
         * mudah dikonversi ke daftar untuk mendapatkan objek Iterable
         */
        // Untuk array kotak gunakan Arrays.asList:
        // Integer[] boxed = { 1, 2, 3 };
        // Iterable<Integer> boxedIt = Arrays.asList(boxed); // list-backed iterable
        // Iterator<Integer> fromBoxed1 = boxedIt.iterator();
        // System.out.println(fromBoxed1.next()); // 1

        // Untuk array primitif (menggunakan Java 8) gunakan stream (khususnya dalam
        // contoh ini - Arrays.stream -> IntStream):
        // int[] primitives = { 1, 2, 3 };
        // IntStream primitiveStream = Arrays.stream(primitives); // list-backed
        // iterable
        // PrimitiveIterator.OfInt fromPrimitive1 = primitiveStream.iterator();
        // System.out.println(fromPrimitive1.next()); // 1

        /*
         * Jika Anda tidak dapat menggunakan stream (tanpa Java 8), Anda dapat memilih
         * untuk menggunakan Google guava libarary :
         * Iterable<Integer> fromPrimitive2 = Ints.asList(primitives);
         * 
         */

        /*
         * Dalam array dua dimensi atau lebih, kedua teknik tersebut dapat digunakan
         * dengan cara yang sedikit lebih kompleks.
         */

        // Contoh
        // int[][] array = new int[10][10];
        // for (int indexOuter = 0; indexOuter < array.length; indexOuter++) {
        // for (int indexInner = 0; indexInner < array[indexOuter].length; indexInner++)
        // {
        // array[indexOuter][indexInner] = indexOuter + indexInner;
        // }
        // }
        // Version ≥ Java SE 5
        // for (int[] numbers : array) {
        // for (int value : numbers) {
        // System.out.println(value);
        // }
        // }
        /*
         * output:
         * 0
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * 
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * 10
         * 
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * 10
         * 11
         * 
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * 10
         * 11
         * 12
         * 
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * 10
         * 11
         * 12
         * 13
         * 
         * 5
         * 6
         * 7
         * 8
         * 9
         * 10
         * 11
         * 12
         * 13
         * 14
         * 
         * 6
         * 7
         * 8
         * 9
         * 10
         * 11
         * 12
         * 13
         * 14
         * 15
         * 
         * 7
         * 8
         * 9
         * 10
         * 11
         * 12
         * 13
         * 14
         * 15
         * 16
         * 
         * 8
         * 9
         * 10
         * 11
         * 12
         * 13
         * 14
         * 15
         * 16
         * 17
         * 
         * 9
         * 10
         * 11
         * 12
         * 13
         * 14
         * 15
         * 16
         * 17
         * 18
         */

        /*
         * Tidak mungkin menyetel Array ke nilai yang tidak seragam tanpa menggunakan
         * loop berbasis indeks.
         * 
         * Tentu saja Anda juga dapat menggunakan perulangan while atau do- while saat
         * melakukan iterasi menggunakan indeks.
         * 
         * Satu catatan yang perlu diperhatikan: saat menggunakan indeks array, pastikan
         * indeks berada di antara 0 dan array.length - 1 (keduanya inklusif). Jangan
         * membuat asumsi kode keras pada panjang array jika tidak, Anda mungkin merusak
         * kode Anda jika panjang array berubah tetapi nilai kode keras Anda tidak.
         */

        // Iterating_over_arrays box2 = new Iterating_over_arrays();
        // box2.incrementNumbers();
        /*
         * output:
         * 2
         * 3
         * 4
         * 5
         * 
         */

        // ------------
        // int[] myArray = { 1, 2, 3, 4, 5 };
        // box2.fillArrayWithDoubleIndex(myArray);
        /*
         * output:
         * 0
         * 2
         * 4
         * 6
         * 8
         */
        // -----------------------
        // Accessing Arrays in reverse order(Mengakses Array dalam urutan terbalik)
        // int[] array = { 0, 1, 1, 2, 3, 5, 8, 13 };
        // for (int i = array.length - 1; i >= 0; i--) {
        // System.out.println(array[i]);
        /*
         * 13
         * 8
         * 5
         * 3
         * 2
         * 1
         * 1
         * 0
         */

        // }
        // -----------------------
        /*
         * 
         * Using temporary Arrays to reduce code repetition(Menggunakan Array sementara
         * untuk mengurangi pengulangan kode)
         * 
         * Mengulangi array sementara alih-alih mengulangi kode dapat membuat kode Anda
         * lebih bersih. Ini dapat digunakan di mana
         * operasi yang sama dilakukan pada beberapa variabel.
         */
        // we want to print out all of these
        String name = "Margaret";
        int eyeCount = 16;
        double height = 50.2;
        int legs = 9;
        int arms = 5;
        // copy-paste approach:
        // System.out.println(name); // "margaret"
        // System.out.println(eyeCount); // 16
        // System.out.println(height); // 50.2
        // System.out.println(legs); // 9
        // System.out.println(arms); // 5

        // temporary array approach:
        // for (Object attribute : new Object[] { name, eyeCount, height, legs, arms })
        // System.out.println(attribute);
        /*
         * output:
         * Margaret
         * 16
         * 50.2
         * 9
         * 5
         */

        // using only numbers
        for (double number : new double[] { eyeCount, legs, arms, height })
            System.out.println(Math.sqrt(number));
        /*
         * output:
         * 4.0
         * 3.0
         * 2.23606797749979
         * 7.085195833567341
         */

        /*
         * Ingatlah bahwa kode ini tidak boleh digunakan di bagian yang kinerjanya
         * kritis, karena array dibuat setiap kali loop dimasukkan, dan variabel
         * primitif akan disalin ke dalam array sehingga tidak dapat diubah.
         */

    }

    // contoh:
    int[] numbers = { 1, 2, 3, 4 };

    public void incrementNumbers() {
        // DO THIS :
        // for (int i = 0; i < numbers.length; i++) {
        // numbers[i] += 1; // or this: numbers[i] = numbers[i] + 1; or numbers[i]++;
        // System.out.println(numbers[i]);
        // }

        // DON'T DO THIS :
        // for (int i = 0; i < 4; i++) {
        // numbers[i] += 1;
        // }

    }

    /*
     * Sebaiknya juga jika Anda tidak menggunakan perhitungan mewah untuk
     * mendapatkan indeks tetapi menggunakan indeks untuk mengulangi dan jika Anda
     * memerlukan nilai yang berbeda, hitunglah itu
     */

    // Contoh
    public void fillArrayWithDoubleIndex(int[] array) {
        // DO THIS :
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
            System.out.println(array[i]);
        }

        // DON'T DO THIS :
        // int doubleLength = array.length * 2;
        // for (int i = 0; i < doubleLength; i += 2) {
        // array[i / 2] = i;
        // }
    }

}
