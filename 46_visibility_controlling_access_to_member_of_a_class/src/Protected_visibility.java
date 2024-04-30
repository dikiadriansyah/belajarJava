// import com.stackexchange.docs.MyClass;
public class Protected_visibility extends MyClass {
    // Protected Visibility/Visibilitas Terlindungi

    /*
     * Penyebab visibilitas terlindungi berarti bahwa anggota ini dapat dilihat oleh
     * package, beserta subclasses.
     */

    // Sebagai contoh:

    /*
     * package com.stackexchange.docs;
     * public class MyClass{
     * protected int variable; //This is the variable that we are trying to access
     * public MyClass(){
     * variable = 2;
     * };
     * }
     */

    // Sekarang kita akan memperluas kelas ini dan mencoba mengakses salah satu
    // anggota yang protected.
    /*
     * package some.other.pack;
     * import com.stackexchange.docs.MyClass;
     * public class SubClass extends MyClass{
     * public SubClass(){
     * super();
     * System.out.println(super.variable);
     * }
     * }
     */

    /*
     * Anda juga dapat mengakses anggota yang dilindungi tanpa memperluasnya jika
     * Anda mengaksesnya dari package yang sama
     */
    /*
     * Perhatikan bahwa pengubah ini hanya bekerja pada anggota kelas, bukan pada
     * kelas itu sendiri.
     */
    // public Protected_visibility() {
    // super();
    // System.out.println(super.variable);
    // }

    public static void main(String[] args) {
        Protected_visibility box1 = new Protected_visibility(); // 2
    }
}
