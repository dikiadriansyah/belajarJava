/*
 * Autoboxing adalah konversi otomatis yang dilakukan kompiler Java antara tipe primitif dan tipe terkaitnya
kelas pembungkus objek. Contoh, konversi int -> Integer, double -> Double... Jika konversinya sebaliknya,
ini disebut membuka kotak. Biasanya, ini digunakan dalam Koleksi yang tidak dapat menampung selain Objek, di mana ada tinju
tipe primitif diperlukan sebelum mengaturnya dalam koleksi.
 */

import java.util.ArrayList;
import java.util.List;

public class Using_int_and_integer_interchangeably {

    // Using int and Integer interchangeably/Menggunakan int dan Integer secara
    // bergantian

    /*
     * Saat Anda menggunakan tipe generik dengan kelas utilitas, Anda mungkin sering
     * menemukan bahwa tipe angka tidak terlalu membantu ketika ditentukan sebagai
     * tipe objek, karena tipe tersebut tidak sama dengan tipe primitifnya.
     * 
     * List<Integer> ints = new ArrayList<Integer>();
     * Version ≥ Java SE 7
     * List<Integer> ints = new ArrayList<>();
     */

    /*
     * Untungnya, ekspresi yang bernilai int dapat digunakan sebagai pengganti
     * Integer ketika diperlukan
     * 
     * for (int i = 0; i < 10; i++){
     * ints.add(i);
     * }
     * 
     * ints.add(i); pernyataan setara dengan:
     * ints.add(Integer.valueOf(i));
     * 
     * Dan mempertahankan properti dari Integer#valueOf seperti memiliki objek
     * Integer yang sama yang di-cache oleh JVM ketika berada dalam rentang caching
     * nomor.
     */

    // Hal ini juga berlaku untuk:
    /*
     * byte and Byte
     * short and Short
     * float and Float
     * double and Double
     * long and Long
     * char and Character
     * boolean and Boolean
     */

    /*
     * Namun, kehati-hatian harus dilakukan dalam situasi yang ambigu. Perhatikan
     * kode berikut:
     * List<Integer> ints = new ArrayList<Integer>();
     * ints.add(1);
     * ints.add(2);
     * ints.add(3);
     * ints.remove(1); // ints is now [1, 3]
     */

    /*
     * Antarmuka java.util.List berisi hapus(int indeks) (Metode antarmuka list)
     * dan remove(Object o) (metode yang diwarisi dari java.util.Collection). Dalam
     * hal ini tidak ada tinju yang terjadi dan remove (int indeks) dipanggil.
     * 
     * Satu lagi contoh perilaku kode Java yang aneh yang disebabkan oleh autoboxing
     * Integer dengan nilai berkisar dari -128 hingga 127:
     * Integer a = 127;
     * Integer b = 127;
     * Integer c = 128;
     * Integer d = 128;
     * System.out.println(a == b); // true
     * System.out.println(c <= d); // true
     * System.out.println(c >= d); // true
     * System.out.println(c == d); // false
     */

    /*
     * Hal ini terjadi karena operator >= secara implisit memanggil intValue() yang
     * mengembalikan int while == membandingkan referensi, bukan nilai int.
     * 
     * Secara default, Java menyimpan nilai dalam cache dalam rentang [-128, 127],
     * sehingga operator == berfungsi karena Integer dalam rentang ini merujuk ke
     * objek yang sama jika nilainya sama. Nilai maksimal dari rentang yang dapat
     * di-cache dapat ditentukan dengan - XX:Opsi JVM AutoBoxCacheMax. Jadi, jika
     * Anda menjalankan program dengan -XX:AutoBoxCacheMax=1000, kode berikut akan
     * mencetak true:
     * Integer a = 1000;
     * Integer b = 1000;
     * System.out.println(a == b); // true
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // List<Integer> ints = new ArrayList<Integer>();
        // for (int i = 0; i < 10; i++) {
        // ints.add(i);
        // }

        // System.out.println(ints);
        /*
         * output:
         * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
         */
        // ----------------------
        // List<Integer> ints = new ArrayList<Integer>();
        // ints.add(1);
        // ints.add(2);
        // ints.add(3);
        // ints.remove(1); // ints is now [1, 3]

        // System.out.println(ints); // output: [1,3]
        // -------------------------
        // Integer a = 127;
        // Integer b = 127;
        // Integer c = 128;
        // Integer d = 128;
        // System.out.println(a == b); // true
        // System.out.println(c <= d); // true
        // System.out.println(c >= d); // true
        // System.out.println(c == d); // false
        // ------------
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b); // false
    }
}
