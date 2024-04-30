// package Test.java;

/*
 * package di java digunakan untuk mengelompokkan kelas dan antarmuka. Hal ini membantu pengembang menghindari konflik ketika jumlah kelas sangat banyak. Jika kita menggunakan paket kelas ini, kita dapat membuat kelas/antarmuka dengan nama yang sama di paket berbeda. Dengan menggunakan paket kita dapat mengimpor kembali potongan tersebut ke kelas lain. Ada banyak package bawaan di java
seperti > 1.java.util > 2.java.lang > 3.java.io Kita dapat mendefinisikan paket yang ditentukan pengguna sendiri.
 */

public class Using_packages_to_create_classes_with_the_same_name {
    // Using Packages to create classes with the same name / Menggunakan Paket untuk
    // membuat kelas dengan nama yang sama

    // First Test.class:
    /*
     * package foo.bar
     * public class Test {
     * }
     */

    /*
     * Juga Test.class di paket lain
     * package foo.bar.baz
     * public class Test {
     * }
     */

    // Hal di atas baik-baik saja karena kedua kelas ada dalam paket yang berbeda

    public static void main(String[] args) {
        // System.out.println("Hello, World!");
    }
}
