public class Access_modifier_for_inner_classes {

    // Access Modifiers for Inner Classes

    /*
     * Penjelasan lengkap tentang Access Modifiers di Java dapat ditemukan di sini.
     * Tapi bagaimana mereka berinteraksi dengan kelas batin?
     * 
     * public, seperti biasa, memberikan akses tidak terbatas ke lingkup apa pun
     * yang dapat mengakses tipe tersebut.
     * 
     * public class OuterClass {
     * public class InnerClass {
     * public int x = 5;
     * }
     * public InnerClass createInner() {
     * return new InnerClass();
     * }
     * }
     * public class SomeOtherClass {
     * public static void main(String[] args) {
     * int x = new OuterClass().createInner().x; //Direct field access is legal
     * }
     * }
     */

    /*
     * keduanya protected dan pengubah default (tidak ada) berperilaku seperti yang
     * diharapkan juga, sama seperti yang mereka lakukan untuk kelas yang tidak
     * bersarang.
     * 
     * private, menariknya, tidak membatasi pada kelasnya. Sebaliknya, ini terbatas
     * pada unit kompilasi -
     * file .java. Ini berarti bahwa kelas Luar memiliki akses penuh ke bidang dan
     * metode kelas Dalam, meskipun kelas tersebut ditandai sebagai private.
     */

    /*
     * public class OuterClass {
     * public class InnerClass {
     * private int x;
     * private void anInnerMethod() {}
     * }
     * public InnerClass aMethod() {
     * InnerClass a = new InnerClass();
     * a.x = 5; //Legal
     * a.anInnerMethod(); //Legal
     * return a;
     * }
     * }
     */

    /*
     * Kelas Dalam sendiri dapat memiliki visibilitas selain publik. Dengan
     * menandainya sebagai pribadi atau pengubah akses terbatas lainnya, kelas
     * (eksternal) lainnya tidak akan diizinkan untuk mengimpor dan menetapkan jenis
     * tersebut. Namun, mereka masih bisa mendapatkan referensi ke objek jenis itu
     */

    /*
     * public class OuterClass {
     * private class InnerClass{}
     * public InnerClass makeInnerClass() {
     * return new InnerClass();
     * }
     * }
     * public class AnotherClass {
     * public static void main(String[] args) {
     * OuterClass o = new OuterClass();
     * 
     * InnerClass x = o.makeInnerClass(); //Illegal, can't find type
     * OuterClass.InnerClass x = o.makeInnerClass(); //Illegal, InnerClass has
     * visibility private
     * Object x = o.makeInnerClass(); //Legal
     * }
     * }
     */

    public static void main(String[] args) {
        int x = new OuterClass().createInner().x; // Direct field access is legal
        System.out.println("Nilai x: " + x); // Nilai x: 5
    }
}
