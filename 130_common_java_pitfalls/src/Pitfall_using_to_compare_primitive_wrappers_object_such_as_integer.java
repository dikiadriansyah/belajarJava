public class Pitfall_using_to_compare_primitive_wrappers_object_such_as_integer {
    // Pitfall: using == to compare primitive wrappers objects such as
    // Integer/Kesalahan: menggunakan == untuk membandingkan objek pembungkus
    // primitif seperti Integer

    /*
     * (Perangkap ini berlaku sama untuk semua tipe pembungkus primitif, tapi kami
     * akan mengilustrasikannya untuk Integer dan int.)
     * 
     * Saat bekerja dengan Integer object, Anda tergoda untuk menggunakan == untuk
     * membandingkan nilai, karena itulah yang akan Anda lakukan dengan nilai int.
     * Dan dalam beberapa kasus, ini tampaknya berhasil:
     * 
     * Integer int1_1 = Integer.valueOf("1");
     * Integer int1_2 = Integer.valueOf(1);
     * System.out.println("int1_1 == int1_2: " + (int1_1 == int1_2)); // true
     * System.out.println("int1_1 equals int1_2: " + int1_1.equals(int1_2)); // true
     * 
     */

    /*
     * Di sini kita membuat dua objek Integer dengan nilai 1 dan membandingkannya
     * (Dalam hal ini kita membuat satu dari String dan satu dari int literal. Ada
     * alternatif lain). Selain itu, kami mengamati bahwa kedua metode perbandingan
     * (== dan sama dengan) keduanya menghasilkan nilai true.
     * 
     * Perilaku ini berubah ketika kita memilih nilai yang berbeda:
     * 
     * Integer int2_1 = Integer.valueOf("1000");
     * Integer int2_2 = Integer.valueOf(1000);
     * System.out.println("int2_1 == int2_2: " + (int2_1 == int2_2)); // false
     * System.out.println("int2_1 equals int2_2: " + int2_1.equals(int2_2)); // true
     * 
     * 
     */

    // Dalam hal ini, hanya perbandingan yang sama yang memberikan hasil yang benar.

    /*
     * Alasan perbedaan perilaku ini adalah, JVM memelihara cache objek Integer
     * untuk rentang -128 hingga
     * 127. (Nilai atas dapat diganti dengan properti sistem
     * "java.lang.Integer.IntegerCache.high" atau argumen JVM
     * "-XX:AutoBoxCacheMax=size"). Untuk nilai dalam rentang ini, Integer.valueOf()
     * akan mengembalikan nilai yang di-cache daripada membuat nilai baru.
     */

    /*
     * Jadi, dalam contoh pertama panggilan Integer.valueOf(1) dan
     * Integer.valueOf("1") mengembalikan cache yang sama
     * Contoh integer. Sebaliknya, pada contoh kedua Integer.valueOf(1000)
     * dan Integer.valueOf("1000")
     * keduanya membuat dan mengembalikan new Integer object.
     */

    /*
     * Operator == untuk tipe referensi menguji kesetaraan referensi (yaitu objek
     * yang sama). Oleh karena itu, pada contoh pertama int1_1 == int1_2 true
     * karena referensinya sama. Pada contoh kedua int2_1 == int2_2 false karena
     * referensinya berbeda.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ------------------------------
        // Integer int1_1 = Integer.valueOf("1");
        // Integer int1_2 = Integer.valueOf(1);
        // System.out.println("int1_1 == int1_2: " + (int1_1 == int1_2));
        /*
         * output:
         * int1_1 == int1_2: true
         */
        // System.out.println("int1_1 equals int1_2: " + int1_1.equals(int1_2));
        /*
         * output:
         * int1_1 equals int1_2: true
         */
        // ---------------------------------
        Integer int2_1 = Integer.valueOf("1000");
        Integer int2_2 = Integer.valueOf(1000);
        System.out.println("int2_1 == int2_2: " + (int2_1 == int2_2));
        /*
         * output:
         * int2_1 == int2_2: false
         */

        System.out.println("int2_1 equals int2_2: " + int2_1.equals(int2_2));
        /*
         * output:
         * int2_1 equals int2_2: true
         */
    }
}
