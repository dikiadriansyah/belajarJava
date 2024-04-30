public class Defining_a_basic_module {

    // Defining a basic module/Mendefinisikan modul dasar

    /*
     * Modul didefinisikan dalam file bernama module-info.java, yang diberi nama
     * deskriptor modul. Itu harus ditempatkan di source-code root:
     * |-- module-info.java
     * |-- com
     * |-- example
     * |-- foo
     * |-- Foo.java
     * |-- bar
     * |-- Bar.java
     */

    // Berikut ini deskriptor modul sederhana:
    /*
     * module com.example {
     * requires java.httpclient;
     * exports com.example.foo;
     * }
     */

    /*
     * Nama modul harus unik dan disarankan agar Anda menggunakan Reverse-DNS naming
     * notation yang sama seperti yang digunakan oleh paket untuk membantu
     * memastikan hal ini.
     * 
     * Modul java.base, yang berisi kelas-kelas dasar Java, secara implisit terlihat
     * oleh modul mana pun dan tidak perlu disertakan.
     * 
     * Deklarasi require memungkinkan kita untuk menggunakan modul lain, misalnya
     * modul java.httpclient diimpor.
     * 
     * Sebuah modul juga dapat menentukan paket mana yang diekspornya dan karenanya
     * membuatnya terlihat oleh modul lain
     */

    /*
     * Paket com.example.foo yang dideklarasikan dalam klausa export akan terlihat
     * oleh modul lain. Sub-paket apa pun dari
     * com.example.foo tidak akan diekspor, mereka memerlukan deklarasi ekspornya
     * sendiri
     */

    /*
     * Sebaliknya, com.example.bar yang tidak tercantum dalam klausa export tidak
     * akan terlihat oleh modul lain.
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
