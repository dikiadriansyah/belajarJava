public class Accessing_overridden_default_methods_from_implementing_class extends Object implements Fooable {
    // Accessing overridden default methods from implementing class / Mengakses
    // metode default yang diganti dari kelas pelaksana

    /*
     * Di kelas, super.foo() hanya akan terlihat di kelas super. Jika Anda ingin
     * memanggil implementasi default dari superinterface, Anda harus memenuhi
     * syarat super dengan nama antarmuka: Fooable.super.foo().
     */

    @Override
    public int foo() {
        // Uncomment the line below to see the error
        // return super.foo() + 1; // error: no method foo() in java.lang.Object
        return Fooable.super.foo() + 1; // okay, returns 4
    }

    public static void main(String[] args) {
        Accessing_overridden_default_methods_from_implementing_class box1 = new Accessing_overridden_default_methods_from_implementing_class();
        System.out.println(box1.foo()); // output: 4

    }
}
