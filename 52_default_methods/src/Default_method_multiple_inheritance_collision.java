// public class Default_method_multiple_inheritance_collision implements
// ABExtendsAbstract {
// Default method multiple inheritance collision / Metode default beberapa
// warisan bertabrakan

// Perhatikan contoh berikutnya:
/*
 * public interface A {
 * default void foo() { System.out.println("A.foo"); }
 * }
 * public interface B {
 * default void foo() { System.out.println("B.foo"); }
 * }
 */

/*
 * Berikut adalah dua antarmuka yang mendeklarasikan metode default foo dengan
 * tanda tangan yang sama.
 * 
 * Jika Anda mencoba extend kedua antarmuka ini di antarmuka baru, Anda
 * harus memilih dua, karena Java memaksa Anda untuk menyelesaikan tabrakan ini
 * secara eksplisit.
 * 
 * Pertama, Anda bisa mendeklarasikan metode foo dengan tanda tangan yang sama
 * dengan abstract, yang akan mengesampingkan perilaku A dan B.
 */

/*
 * public interface ABExtendsAbstract extends A, B {
 * 
 * @Override
 * void foo();
 * }
 */

// Dan ketika Anda akan mengimplementasikan ABExtendsAbstract di kelas Anda
// harus menyediakan implementasi foo:
/*
 * public class ABExtendsAbstractImpl implements ABExtendsAbstract {
 * 
 * @Override
 * public void foo() { System.out.println("ABImpl.foo"); }
 * }
 */

/*
 * Atau kedua, Anda dapat memberikan implementasi default yang benar-benar baru.
 * Anda juga dapat menggunakan kembali kode metode foo A dan B dengan Mengakses
 * metode default yang diganti dari kelas implementasi.
 */

/*
 * public interface ABExtends extends A, B {
 * 
 * @Override
 * default void foo() { System.out.println("ABExtends.foo"); }
 * }
 */

// Dan ketika Anda akan mengimplementasikan ABExtends di kelas Anda tidak perlu
// menyediakan implementasi foo:
// public class ABExtendsImpl implements ABExtends {}

// @Override
// public void foo() {
// System.out.println("ABImpl.foo");
// }

// public static void main(String[] args) {
// Default_method_multiple_inheritance_collision obj = new
// Default_method_multiple_inheritance_collision();
// obj.foo(); // Output: ABImpl.foo
// }

// }
