public class Different_ways_for_implementing_a_generic {
    // Different ways for implementing a Generic Interface (or extending a Generic
    // Class) / Berbagai cara untuk mengimplementasikan Antarmuka Generik (atau
    // memperluas Kelas Generik)

    /*
     * public interface MyGenericInterface<T> {
     * public void foo(T t);
     * }
     */

    // Di bawah ini tercantum kemungkinan cara untuk menerapkannya.
    // Implementasi kelas non-generik dengan tipe tertentu
    // Pilih tipe tertentu untuk menggantikan parameter tipe formal <T> dari
    // MyGenericClass dan implementasikan, seperti contoh berikut:
    /*
     * public class NonGenericClass implements MyGenericInterface<String> {
     * public void foo(String t) { } // type T has been replaced by String
     * }
     */

    /*
     * Kelas ini hanya berhubungan dengan String, dan ini berarti menggunakan
     * MyGenericInterface dengan parameter berbeda (mis.
     * Integer, Object, dll.) tidak dapat dikompilasi, seperti yang ditunjukkan
     * cuplikan berikut:
     */

    /*
     * NonGenericClass myClass = new NonGenericClass();
     * myClass.foo("foo_string"); // OK, legal
     * myClass.foo(11); // NOT OK, does not compile
     * myClass.foo(new Object()); // NOT OK, does not compile
     */

    // Implementasi kelas generik
    // Deklarasikan antarmuka generik lainnya dengan parameter tipe formal <T> yang
    // mengimplementasikan MyGenericInterface, sebagai berikut:
    /*
     * public class MyGenericSubclass<T> implements MyGenericInterface<T> {
     * public void foo(T t) { } // type T is still the same
     * // other methods...
     * }
     */

    // Perhatikan bahwa parameter tipe formal yang berbeda mungkin telah digunakan,
    // sebagai berikut:
    /*
     * public class MyGenericSubclass<U> implements MyGenericInterface<U> { //
     * equivalent to the previous
     * declaration
     * public void foo(U t) { }
     * // other methods...
     * }
     */

    // Implementasi kelas tipe mentah
    /*
     * Deklarasikan kelas non-generik yang mengimplementasikan MyGenericInteface
     * sebagai tipe mentah (tidak menggunakan generik sama sekali), sebagai berikut:
     */
    /*
     * public class MyGenericSubclass implements MyGenericInterface {
     * public void foo(Object t) { } // type T has been replaced by Object
     * // other possible methods
     * }
     */

    /*
     * Cara ini tidak disarankan, karena tidak 100% aman saat runtime karena
     * mencampurkan tipe mentah (dari subkelas)
     * dengan obat generik (antarmuka) dan itu juga membingungkan. Kompiler Java
     * modern akan memberikan peringatan seperti ini
     * implementasi, namun kodenya - untuk alasan kompatibilitas dengan JVM yang
     * lebih lama (1.4 atau lebih lama) - akan dikompilasi.
     * 
     * Semua cara yang tercantum di atas juga diperbolehkan saat menggunakan kelas
     * generik sebagai supertipe, bukan antarmuka generik
     */

    public static void main(String[] args) {
        NonGenericClass myClass = new NonGenericClass();

        // Memanggil foo dengan String (OK, legal)
        myClass.foo("foo_string");// Value: foo_string
    }
}
