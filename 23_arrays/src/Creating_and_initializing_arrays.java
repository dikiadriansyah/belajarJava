import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Creating_and_initializing_arrays {
    // Creating and Initializing Arrays
    /*
     * Parameter | Details
     * Array Type |Jenis larik. Ini bisa berupa primitif (int, long, byte) atau
     * Objek (String, MyObject, dll).
     * 
     * Index | Indeks mengacu pada posisi Objek tertentu dalam sebuah array.
     * Length | Setiap array, saat dibuat, memerlukan panjang tertentu. Hal ini
     * dapat dilakukan saat membuat array kosong (new int[3]) atau diterapkan saat
     * menentukan nilai ({1, 2, 3}).
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // int[] numbers1 = new int[3]; // Array for 3 int values, default value is 0
        // int[] numbers2 = { 1, 2, 3 }; // Array literal of 3 int values
        // int[] numbers3 = new int[] { 1, 2, 3 }; // Array of 3 int values initialized
        // int[][] numbers4 = { { 1, 2 }, { 3, 4, 5 } }; // Jagged array literal
        // int[][] numbers5 = new int[5][]; // Jagged array, one dimension 5 long
        // int[][] numbers6 = new int[5][4]; // Multidimensional array: 5x4
        // System.out.println(numbers1); // [I@53bd815b
        // System.out.println(numbers2[2]); // 3

        // Array dapat dibuat menggunakan tipe primitif atau referensi apa pun.
        // float[] boats = new float[5]; // Array of five 32-bit floating point numbers.
        // double[] header = new double[] { 4.56, 332.267, 7.0, 0.3367, 10.0 };
        // Array of five 64-bit floating point numbers.
        // String[] theory = new String[] { "a", "b", "c" };
        // Array of three strings (reference type).
        // Object[] dArt = new Object[] { new Object(), "We love Stack Overflow.", new
        // Integer(3) };
        // Array of three Objects (reference type).
        // System.out.println(header[1]); // 332.267
        // System.out.println(theory[1]); // b

        /*
         * Untuk contoh terakhir, perhatikan bahwa subtipe dari tipe array yang
         * dideklarasikan diperbolehkan dalam array.
         * 
         * Array untuk tipe yang ditentukan pengguna juga dapat dibuat mirip dengan tipe
         * primitif
         * UserDefinedClass[] udType = new UserDefinedClass[5];
         * 
         * Arrays, Collections, and Streams
         * versi > java se 1.2
         * 
         */

        // Parameters require objects, not primitives
        // Auto-boxing happening for int 127 here
        // Integer[] initial = { 127, Integer.valueOf(42) };
        // List<Integer> toList = Arrays.asList(initial); // Fixed size!
        // System.out.println(toList); // [127,42]

        // Note: Works with all collections
        // Integer[] fromCollection = toList.toArray(new Integer[toList.size()]);
        // System.out.println(fromCollection); // [Ljava.lang.Integer;@2401f4c3

        // Java tidak mengizinkan Anda membuat array dengan tipe parameter
        // List<String>[] list = new ArrayList<String>[2]; // Compilation error!
        // Version ≥ Java SE 8

        // Streams - JDK 8+
        // Stream<Integer> toStream = Arrays.stream(initial);
        // Integer[] fromStream = toStream.toArray(Integer[]::new);
        // System.out.println(fromStream); // [Ljava.lang.Integer;@574caa3f

        // Intro
        /*
         * Array adalah struktur data yang menyimpan sejumlah nilai primitif atau
         * referensi ke instance objek.
         * 
         * Setiap item dalam array disebut elemen, dan setiap elemen diakses berdasarkan
         * indeks numeriknya. Panjang array ditentukan ketika array dibuat:
         * 
         */
        // int size = 42;
        // int[] array = new int[size];
        // System.out.println(array); // [I@574caa3f

        /*
         * Ukuran array ditetapkan pada saat runtime ketika diinisialisasi. Itu tidak
         * dapat diubah setelah inisialisasi. Jika ukurannya harus
         * bisa berubah saat runtime, kelas Koleksi seperti ArrayList harus digunakan
         * sebagai gantinya. ArrayList menyimpan elemen dalam array dan mendukung
         * pengubahan ukuran dengan mengalokasikan array baru dan menyalin elemen dari
         * array lama.
         * 
         * Jika array bertipe primitif, mis
         * 
         */

        // int[] arr1 = { 1, 2, 3, 4 };
        // int[] arr2 = new int[10];
        // System.out.println(arr1[2]); // 3

        /*
         * nilainya disimpan dalam array itu sendiri. Dengan tidak adanya
         * penginisialisasi (seperti pada array2 di atas), nilai defaultnya
         * ditugaskan untuk setiap elemen adalah 0 (nol).
         * 
         * Jika tipe array adalah referensi objek, seperti pada
         * SomeClassOrInterface[] array = new SomeClassOrInterface[10];
         * 
         * kemudian array berisi referensi ke objek bertipe SomeClassOrInterface.
         * Referensi tersebut dapat merujuk pada an
         * contoh SomeClassOrInterface atau subkelas apa pun (untuk kelas) atau kelas
         * implementasi (untuk antarmuka).
         * SomeClassOrInterface. Jika deklarasi array tidak memiliki penginisialisasi
         * maka nilai default null ditetapkan ke setiap elemen.
         * 
         * Karena semua array diindeks int, ukuran array harus ditentukan oleh int.
         * Ukuran array tidak dapat ditentukan long:
         * 
         */
        // long size2 = 23L;
        // int[] array2 = new int[size2]; // Compile-time error:
        // incompatible types: possible lossy conversion from
        // long to int

        /*
         * Array menggunakan sistem indeks berbasis nol, yang berarti pengindeksan
         * dimulai dari 0 dan berakhir pada panjang - 1.
         * 
         * Misalnya, gambar berikut mewakili array dengan ukuran 10. Di sini, elemen
         * pertama berada di indeks 0 dan yang terakhir
         * elemen berada di indeks 9, bukan elemen pertama di indeks 1 dan elemen
         * terakhir di indeks 10 (lihat gambar di bawah).
         * 
         * Akses ke elemen array dilakukan dalam waktu yang konstan. Itu berarti
         * mengakses elemen pertama array memiliki biaya (waktu) yang sama dengan
         * mengakses elemen kedua, elemen ketiga, dan seterusnya.
         * 
         * 
         * Java menawarkan beberapa cara untuk mendefinisikan dan menginisialisasi
         * array, termasuk notasi literal dan constructor. Saat mendeklarasikan array
         * menggunakan new Type[length] constructor , setiap elemen akan diinisialisasi
         * dengan nilai default berikut:
         * 0 for primitive numerical types: byte, short, int, long, float, and double.
         * '\u0000' (null character) for the char type.
         * false for the boolean type.
         * null for reference types.
         */

        // Creating and initializing primitive type arrays
        int[] array1 = new int[] { 1, 2, 3 }; // Create an array with new operator and
        // array initializer.
        int[] array2 = { 1, 2, 3 }; // Shortcut syntax with array initializer.
        int[] array3 = new int[3]; // Equivalent to { 0, 0, 0 }
        int[] array4 = null;
        // System.out.println(array1[1]); // 2
        // System.out.println(array2[1]); // 2

        /*
         * Saat mendeklarasikan array, [] akan muncul sebagai bagian dari tipe di awal
         * deklarasi (setelah nama tipe),
         * atau sebagai bagian dari deklarator untuk variabel tertentu (setelah nama
         * variabel), atau keduanya:
         */
        int array5[]; /* equivalent to */
        // int[] array5;
        int a, b[], c[][]; /* equivalent to */
        // int a; int[] b; int[][] c;

        // int[] a, b[]; /* equivalent to */
        // int[] a; int[][] b;

        // int a, []b, c[][];
        /*
         * Compilation Error, because [] is not part of the type at beginning
         * of the declaration, rather it is before 'b'.
         */
        // The same rules apply when declaring a method that returns an array:

        // int foo()[] { /*... */ } /* equivalent to */
        // int[] foo() { ... }
        /*
         * Dalam contoh berikut, kedua deklarasi tersebut benar dan dapat dikompilasi
         * serta dijalankan tanpa masalah. Namun,
         * baik Konvensi Pengkodean Java maupun Panduan Gaya Java Google tidak
         * menyarankan formulir dengan tanda kurung setelah
         * nama variabel—tanda kurung mengidentifikasi tipe array dan akan muncul
         * bersama penunjukan tipe. Hal yang sama seharusnya
         * digunakan untuk tanda tangan pengembalian metode
         */
        float array6[]; /* and */ // int foo()[] { ... } /* are discouraged */
        float[] array7; /* and */ // int[] foo() { ... } /* are encouraged */

        /*
         * Tipe yang tidak disarankan dimaksudkan untuk mengakomodasi transisi pengguna
         * C, yang akrab dengan sintaks untuk C yang mana
         * memiliki tanda kurung setelah nama variabel.
         * 
         * Di Java, dimungkinkan untuk memiliki array berukuran 0:
         */

        int[] array8 = new int[0]; // Compiles and runs fine.
        int[] array9 = {}; // Equivalent syntax.

        /*
         * Namun, karena ini adalah array kosong, tidak ada elemen yang dapat dibaca
         * atau ditugaskan ke dalamnya:
         */
        // array[0] = 1; // Throws java.lang.ArrayIndexOutOfBoundsException.
        // int i = array2[0]; // Also throws ArrayIndexOutOfBoundsException.
        /*
         * Array kosong seperti itu biasanya berguna sebagai nilai kembalian, sehingga
         * kode pemanggil hanya perlu khawatir untuk menanganinya
         * sebuah array, bukan nilai null potensial yang dapat menyebabkan
         * NullPointerException.
         * 
         * Panjang array harus berupa bilangan bulat non-negatif:
         */
        // int[] array10 = new int[-1]; // Throws java.lang.NegativeArraySizeException
        /*
         * Ukuran array dapat ditentukan menggunakan kolom final publik yang disebut
         * length:
         */
        // System.out.println(array10.length); // Prints 0 in this case.

        /*
         * Catatan: array.length mengembalikan ukuran sebenarnya dari array dan bukan
         * jumlah elemen array yang ditugaskan
         * sebuah nilai, tidak seperti ArrayList.size() yang mengembalikan jumlah elemen
         * array yang diberi nilai.
         */

        // Creating and initializing multi-dimensional arrays(Membuat dan
        // menginisialisasi array multidimensi)
        // The simplest way to create a multi-dimensional array is as follows:
        // int[][] box1 = new int[2][3];

        /*
         * Ini akan membuat dua array int dengan panjang tiga—box1[0] dan box1[1]. Ini
         * sangat
         * mirip dengan inisialisasi gaya C klasik
         * array multidimensi persegi panjang.
         * 
         * Anda dapat membuat dan menginisialisasi secara bersamaan:
         */
        int[][] box1 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        /*
         * Berbeda dengan C, yang hanya mendukung array multidimensi persegi panjang,
         * array dalam tidak harus berupa array multidimensi
         * panjangnya sama, atau bahkan ditentukan:
         */

        int[][] box2 = { { 1 }, { 2, 3 }, null };
        /*
         * Di sini, box2[0] adalah array int dengan panjang satu, sedangkan box2[1]
         * adalah
         * array int dengan panjang dua dan box2[2] adalah null. Array seperti ini
         * adalah disebut array bergerigi atau array compang-camping, yaitu array dari
         * array. Array multidimensi di Java adalah
         * diimplementasikan sebagai array dari array, yaitu array[i][j][k] setara
         * dengan ((array[i])[j])[k]. Berbeda dengan C#, sintaksnya
         * array[i,j] tidak didukung di Java.
         */

        // Multidimensional array representation in Java

        // Creating and initializing reference type arrays(Membuat dan menginisialisasi
        // array tipe referensi)
        String[] array11 = new String[] { "Laurel", "Hardy" }; // Create an array with new
        // operator and array initializer.
        // System.out.println(array11[1]); // Hardy

        String[] array12 = { "Laurel", "Hardy" }; // Shortcut syntax with array initializer.

        String[] array13 = new String[3]; // { null, null, null }
        String[] array14 = null; // null

        /*
         * Selain literal dan primitif String yang ditunjukkan di atas, sintaks pintasan
         * untuk inisialisasi array juga berfungsi dengan tipe Objek kanonik:
         */
        Object[] array15 = { new Object(), new Object() };
        /*
         * Karena array bersifat kovarian, array tipe referensi dapat diinisialisasi
         * sebagai array dari subkelas, meskipun merupakan array
         * ArrayStoreException akan dilempar jika Anda mencoba menyetel elemen ke
         * sesuatu selain String:
         */
        Object[] array16 = new String[] { "foo", "bar", "baz" };
        array16[1] = "qux"; // fine
        // array16[1] = new StringBuilder(); // throws ArrayStoreException
        // System.out.println(array16[1]); // qux

        /*
         * Sintaks pintasan tidak dapat digunakan untuk ini karena sintaks pintasan akan
         * memiliki tipe implisit dari Objek[].
         * 
         * Sebuah array dapat diinisialisasi dengan elemen nol dengan menggunakan
         * String[] emptyArray = new String[0]. Misalnya, array dengan panjang nol
         * seperti ini digunakan untuk Membuat Array dari Koleksi ketika metode
         * memerlukan tipe runtime suatu objek.
         * 
         * Baik dalam tipe primitif maupun referensi, inisialisasi array kosong
         * (misalnya String[] array8 = new
         * String[3]) akan menginisialisasi array dengan nilai default untuk setiap tipe
         * data.
         */
        // Creating and initializing generic type arrays(Membuat dan menginisialisasi
        // array tipe generik)
        // Di kelas generik, array tipe generik tidak dapat diinisialisasi seperti ini
        // karena penghapusan tipe:
        /*
         * public class MyGenericClass<T> {
         * private T[] a;
         * public MyGenericClass() {
         * a = new T[5]; // Compile time error: generic array creation
         * }
         * }
         * 
         */

        /*
         * Sebaliknya, mereka dapat dibuat menggunakan salah satu metode berikut:
         * (perhatikan bahwa ini akan menghasilkan peringatan yang tidak dicentang)
         * 1. Dengan membuat array Object, dan mentransmisikannya ke tipe generik:
         * a = (T[]) new Object[5];
         * Ini adalah metode yang paling sederhana, namun karena array yang mendasarinya
         * masih bertipe Object[], metode ini tidak
         * memberikan keamanan tipe. Oleh karena itu, metode pembuatan array ini paling
         * baik digunakan hanya di dalam kelas generik -
         * tidak diekspos ke publik
         * 
         * 2. Dengan menggunakan Array.newInstance dengan parameter kelas:
         * public MyGenericClass(Class<T> clazz) {
         * a = (T[]) Array.newInstance(clazz, 5);
         * }
         * 
         * Di sini kelas T harus secara eksplisit diteruskan ke konstruktor. Tipe
         * pengembalian Array.newInstance adalah
         * selalu Objek. Namun cara ini lebih aman karena array yang baru dibuat selalu
         * bertipe T[], dan
         * oleh karena itu dapat dieksternalisasi dengan aman.
         */

        // Filling an array after initialization(Mengisi array setelah inisialisasi)
        // Arrays.fill() dapat digunakan untuk mengisi array dengan nilai yang sama
        // setelah inisialisasi:
        Arrays.fill(array16, "abc"); // { "abc", "abc", "abc" }

        // fill() juga dapat memberikan nilai pada setiap elemen dalam rentang array
        // yang ditentukan:
        Arrays.fill(array16, 1, 2, "aaa"); // Placing "aaa" from index 1 to 2.
        // System.out.println(array16[1]); // aaa

        /*
         * Sejak Java versi 8, metode setAll, dan parallelSetAll yang setara secara
         * bersamaan, dapat digunakan untuk menyetel setiap
         * elemen array ke nilai yang dihasilkan. Metode ini diteruskan ke fungsi
         * generator yang menerima indeks
         * dan mengembalikan nilai yang diinginkan untuk posisi itu.
         * 
         */

        // Contoh berikut membuat array bilangan bulat dan menetapkan semua elemennya ke
        // nilai indeks masing-masing:
        int[] array17 = new int[5];
        Arrays.setAll(array17, i -> i); // The array becomes { 0, 1, 2, 3, 4 }
        // System.out.println(array17[4]); // 4

        // Separate declaration and initialization of arrays(Pisahkan deklarasi dan
        // inisialisasi array)
        /*
         * Nilai indeks untuk elemen array harus berupa bilangan bulat (0, 1, 2, 3, 4,
         * ...) dan kurang dari panjang
         * array (indeks berbasis nol). Jika tidak, ArrayIndexOutOfBoundsException akan
         * dilempar:
         */

        int[] array18; // Array declaration - uninitialized
        array18 = new int[3]; // Initialize array - { 0, 0, 0 }
        array18[0] = 10; // Set index 0 value - { 10, 0, 0 }
        array18[1] = 20; // Set index 1 value - { 10, 20, 0 }
        array18[2] = 30; // Set index 2 value - { 10, 20, 30 }
        // System.out.println(array18[1]); // 20

        // Arrays may not be re-initialized with array initializer shortcut syntax(Array
        // tidak boleh diinisialisasi ulang dengan sintaks pintasan penginisialisasi
        // array)

        /*
         * Inisialisasi ulang array tidak mungkin dilakukan melalui sintaks pintasan
         * dengan penginisialisasi array karena penginisialisasi array hanya dapat
         * ditentukan dalam deklarasi bidang atau deklarasi variabel lokal, atau sebagai
         * bagian dari ekspresi pembuatan array.
         * 
         * Namun, dimungkinkan untuk membuat array baru dan menugaskannya ke variabel
         * yang digunakan untuk mereferensikan array lama.
         * Meskipun hal ini mengakibatkan array yang direferensikan oleh variabel
         * tersebut diinisialisasi ulang, isi variabelnya sepenuhnya
         * susunan baru. Untuk melakukan hal ini, new operator dapat digunakan dengan
         * penginisialisasi array dan ditugaskan ke variabel array:
         */

        // First initialization of array
        // int[] array19 = new int[] { 1, 2, 3 };
        // Prints "1 2 3 ".
        // for (int i : array19) {
        // System.out.print(i + " ");
        // }
        // Re-initializes array to a new int[] array.
        // array19 = new int[] { 4, 5, 6 };
        // Prints "4 5 6 ".
        // for (int i : array19) {
        // System.out.print(i + " ");
        // }
        /*
         * output:
         * 123456
         */

        // array19={1,2,3,4}; // Compile-time error! Can't re-initialize an array via
        // shortcut
        // syntax with array initializer.

    }
}
