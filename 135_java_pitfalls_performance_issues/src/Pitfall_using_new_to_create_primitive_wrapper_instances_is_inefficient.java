public class Pitfall_using_new_to_create_primitive_wrapper_instances_is_inefficient {
    // Pitfall - Using 'new' to create primitive wrapper instances is
    // inefficient/Kesalahan - Menggunakan 'baru' untuk membuat instance wrapper
    // primitif tidak efisien

    /*
     * Bahasa Java memungkinkan Anda menggunakan new untuk membuat instance Integer,
     * Boolean, dan sebagainya, namun secara umum ini merupakan ide yang buruk.
     * Lebih baik menggunakan autoboxing (Java 5 dan yang lebih baru) atau metode
     * valueOf.
     * 
     * Integer i1 = new Integer(1); // BAD
     * Integer i2 = 2; // BEST (autoboxing)
     * Integer i3 = Integer.valueOf(3); // OK
     */

    /*
     * Alasan penggunaan new Integer(int) secara eksplisit adalah ide yang buruk
     * adalah karena ia membuat objek baru (kecuali dioptimalkan oleh kompiler JIT).
     * Sebaliknya, ketika autoboxing atau panggilan valueOf eksplisit digunakan,
     * runtime Java akan mencoba menggunakan kembali objek Integer dari cache objek
     * yang sudah ada sebelumnya. Setiap kali runtime memiliki cache yang "terkena",
     * ia menghindari pembuatan objek. Hal ini juga menghemat memori heap dan
     * mengurangi overhead GC yang disebabkan oleh churn objek.
     * Catatan:
     * 1. Dalam implementasi Java baru-baru ini, autoboxing diimplementasikan dengan
     * memanggil valueOf, dan terdapat cache untuk Boolean, Byte, Short, Integer,
     * Long dan Character.
     * 2. Perilaku caching untuk tipe integral diamanatkan oleh Spesifikasi Bahasa
     * Java
     */

    public static void main(String[] args) throws Exception {
        Integer i1 = new Integer(1); // BAD
        Integer i2 = 2; // BEST (autoboxing)
        Integer i3 = Integer.valueOf(3); // OK

        System.out.println("i1: " + i1);
        System.out.println("i2: " + i2);
        System.out.println("i3: " + i3);
        /*
         * output:
         * i1: 1
         * i2: 2
         * i3: 3
         */

    }
}
