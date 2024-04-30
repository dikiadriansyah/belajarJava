public class Call_parent_constructor extends Parent {
    // Call parent constructor

    /*
     * Katakanlah Anda memiliki kelas Induk dan kelas Anak. Untuk membuat instance
     * Anak selalu memerlukan beberapa Induk
     * konstruktor untuk dijalankan di awal konstruktor Anak. Kita dapat memilih
     * konstruktor Induk yang kita inginkan
     * dengan secara eksplisit memanggil super(...) dengan argumen yang sesuai
     * sebagai pernyataan konstruktor Anak pertama kita. Melakukan hal ini menghemat
     * waktu kita dengan menggunakan kembali konstruktor kelas Induk daripada
     * menulis ulang kode yang sama di konstruktor kelas Anak.
     */

    // Without super(...) method:
    // (secara implisit, versi no-args super() dipanggil tanpa terlihat)

    // This does not even compile, because name and age are private,
    // making them invisible even to the child class.

    // public Call_parent_constructor() {
    // // compiler implicitly calls super() here
    // name = "John";
    // age = 42;
    // }

    // public void displayInfo() {
    // System.out.println("Name: " + name + ", Age: " + age);
    // }

    public static void main(String[] args) {
        Call_parent_constructor child = new Call_parent_constructor();
        // child.displayInfo(); // Name: John, Age: 42

        // ---------------------------
        // With super() method:

    }

    public Call_parent_constructor() {
        super("John", 42); // explicit super-call
    }

    /*
     * Catatan: Panggilan ke konstruktor lain (rantai) atau konstruktor super HARUS
     * berupa pernyataan pertama di dalam konstruktor.
     * 
     * Jika Anda memanggil konstruktor super(...) secara eksplisit, konstruktor
     * induk yang cocok harus ada (mudah saja, bukan?)
     * 
     * Jika Anda tidak memanggil konstruktor super(...) secara eksplisit, kelas
     * induk Anda harus memiliki konstruktor tanpa argumen - dan ini dapat ditulis
     * secara eksplisit atau dibuat sebagai default oleh kompiler jika kelas induk
     * tidak menyediakan konstruktor mana pun.
     * 
     * class Parent{
     * public Parent(String tName, int tAge) {}
     * }
     * class Child extends Parent{
     * public Child(){}
     * }
     * 
     * Kelas Induk tidak memiliki konstruktor default, sehingga kompiler tidak dapat
     * menambahkan super di konstruktor Anak. Kode ini tidak dapat dikompilasi. Anda
     * harus mengubah konstruktor agar sesuai dengan kedua sisi, atau menulis
     * panggilan super Anda sendiri, seperti itu:
     * class Child extends Parent{
     * public Child(){
     * super("",0);
     * }
     * }
     * 
     */

}
