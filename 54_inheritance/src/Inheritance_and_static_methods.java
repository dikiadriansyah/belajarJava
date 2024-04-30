public class Inheritance_and_static_methods {
    // Inheritance and Static Methods / Warisan dan Metode Statis

    /*
     * Di Java, kelas induk dan anak keduanya dapat memiliki metode statis dengan
     * nama yang sama. Namun dalam kasus seperti ini, implementasi metode statis
     * pada anak menyembunyikan implementasi kelas induk, bukan metode yang
     * mengesampingkan. Misalnya:
     * 
     * class StaticMethodTest {
     * // static method and inheritance
     * public static void main(String[] args) {
     * Parent p = new Child();
     * p.staticMethod(); // prints Inside Parent
     * ((Child) p).staticMethod(); // prints Inside Child
     * }
     * static class Parent {
     * public static void staticMethod() {
     * System.out.println("Inside Parent");
     * }
     * }
     * static class Child extends Parent {
     * public static void staticMethod() {
     * System.out.println("Inside Child");
     * }
     * }
     * }
     * 
     */

    /*
     * Metode statis diikat ke kelas, bukan ke instance, dan pengikatan metode ini
     * terjadi pada waktu kompilasi. Sejak di
     * panggilan pertama ke staticMethod(), referensi kelas induk p digunakan,
     * staticMethod() versi Induk dipanggil. Di dalam
     * kasus kedua, kami memasukkan p ke kelas Anak, staticMethod() Anak dieksekusi.
     */

    // static method and inheritance
    public static void main(String[] args) {
        Parent p = new Child();
        p.staticMethod(); // prints Inside Parent
        ((Child) p).staticMethod(); // prints Inside Child
    }

    static class Parent {
        public static void staticMethod() {
            System.out.println("Inside Parent");
        }
    }

    static class Child extends Parent {

        public static void main(String[] args) {
            System.out.println("Inside Child"); // inside child
        }
    }
}
