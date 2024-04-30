import java.util.ArrayList;
import java.util.List;

public class The_liskov_substitution_principle {

    // The Liskov Substitution Principle / Prinsip Substitusi Liskov

    /*
     * Substitusi adalah prinsip dalam pemrograman berorientasi objek yang
     * diperkenalkan oleh Barbara Liskov pada konferensi tahun 1987
     * keynote yang menyatakan bahwa, jika kelas B adalah subkelas dari kelas A,
     * maka di mana pun A diharapkan, B dapat digunakan sebagai gantinya:
     */

    /*
     * class A {...}
     * class B extends A {...}
     * public void method(A obj) {...}
     * A a = new B(); // Assignment OK
     * method(new B()); // Passing as parameter OK
     */

    /*
     * Hal ini juga berlaku jika tipenya adalah antarmuka, yang tidak memerlukan
     * hubungan hierarki antar objek:
     * interface Foo {
     * void bar();
     * }
     * class A implements Foo {
     * void bar() {...}
     * }
     * class B implements Foo {
     * void bar() {...}
     * }
     * List<Foo> foos = new ArrayList<>();
     * foos.add(new A()); // OK
     * foos.add(new B()); // OK
     */

    // Sekarang daftar tersebut berisi objek yang tidak berasal dari hierarki kelas
    // yang sama

    public static void main(String[] args) {
        // List<Foo> foos = new ArrayList<>();

        // A a = new A();
        // B b = new B();

        // foos.add(a); // OK
        // foos.add(b); // OK

        // // Memanggil metode bar() dari setiap objek dalam List
        // for (Foo foo : foos) {
        // foo.bar();
        // }
    }
}
