public class Defining_annotation_types {
    // Defining annotation types

    /*
     * Jenis anotasi ditentukan dengan @interface. Parameter didefinisikan mirip
     * dengan metode antarmuka biasa.
     * 
     * @interface MyAnnotation {
     * String param1();
     * boolean param2();
     * int[] param3(); // array parameter
     * }
     * 
     * 
     * Default values
     * 
     * @interface MyAnnotation {
     * String param1() default "someValue";
     * boolean param2() default true;
     * int[] param3() default {};
     * }
     * 
     * Meta-Annotations
     * Anotasi meta adalah anotasi yang dapat diterapkan pada jenis anotasi. Anotasi
     * meta khusus yang telah ditentukan sebelumnya menentukan bagaimana jenis
     * anotasi dapat digunakan.
     * 
     * @Target
     * Anotasi meta @Target membatasi jenis anotasi yang dapat diterapkan.
     * 
     * @Target(ElementType.METHOD)
     * 
     * @interface MyAnnotation {
     * // this annotation can only be applied to methods
     * }
     * 
     * Beberapa nilai dapat ditambahkan menggunakan notasi array,
     * mis. @Target({ElementType.FIELD, ElementType.TYPE})
     * 
     * Nilai yang Tersedia
     * 
     * ElementType | target | example usage on target element
     * ANNOTATION_TYPE | annotation types | @Retention(RetentionPolicy.RUNTIME)
     * terface MyAnnotation
     * CONSTRUCTOR FIELD | Constructors fields, enum constants |
     * LOCAL_VARIABLE | variable declarations inside methods |
     * PACKAGE | package(in package-info.java) |
     * METHOD | methods |
     * PARAMETER | method/constructor parameter |
     * TYPE | classes, interfaces enums |
     * 
     */

    // Versi > java se 8
    /*
     * ElementType target example usage on target element
     * TYPE_PARAMETER
     * TYPE_USE
     * 
     * @Retention
     */

    /*
     * Anotasi meta @Retention mendefinisikan visibilitas anotasi selama proses
     * kompilasi aplikasi atau eksekusi. Secara default, anotasi disertakan dalam
     * file .class, namun tidak terlihat saat runtime. Agar anotasi dapat diakses
     * saat runtime,
     * RetentionPolicy.RUNTIME harus disetel pada anotasi tersebut.
     */

    /*
     * @Retention(RetentionPolicy.RUNTIME)
     * 
     * @interface MyAnnotation {
     * // this annotation can be accessed with reflections at runtime
     * }
     */

    // Available values

    /*
     * RetentionPolicy | Effect
     * CLASS
     * RUNTIME
     * SOURCE
     */

    // @Documented
    /*
     * Anotasi meta @Documented digunakan untuk menandai anotasi yang penggunaannya
     * harus didokumentasikan oleh API
     * generator dokumentasi seperti javadoc. Itu tidak memiliki nilai.
     * Dengan @Documented, semua kelas yang menggunakan anotasi akan melakukannya
     * mencantumkannya di halaman dokumentasi yang dihasilkan. Tanpa @Documented,
     * tidak mungkin melihat kelas mana yang menggunakan anotasi dalam dokumentasi.
     */

    // @Inherited
    /*
     * Anotasi meta @Inherited relevan dengan anotasi yang diterapkan pada kelas.
     * Itu tidak memiliki nilai. Menandai anotasi sebagai @Inherited akan mengubah
     * cara kerja kueri anotasi.
     * 
     * 1. Untuk anotasi yang tidak diwariskan, kueri hanya memeriksa kelas yang
     * diperiksa.
     * 2. Untuk anotasi yang diwariskan, kueri juga akan memeriksa rantai kelas
     * super (secara rekursif) hingga turunan anotasi ditemukan.
     * 
     * Perhatikan bahwa hanya kelas super yang ditanyakan: anotasi apa pun yang
     * dilampirkan ke antarmuka dalam hierarki kelas akan diabaikan.
     */

    // @Repeatable
    /*
     * Anotasi meta @Repeatable telah ditambahkan di Java 8. Ini menunjukkan bahwa
     * beberapa contoh anotasi dapat dilampirkan pada target anotasi. Anotasi meta
     * ini tidak memiliki nilai.
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");
    }
}
