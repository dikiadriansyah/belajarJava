public class classes_defined_within_other_constructs {
    // Classes Defined within Other Constructs/Kelas Didefinisikan dalam Konstruksi
    // Lain

    // Defined within Another Class

    // C++

    // Kelas Bersarang[ref] (membutuhkan referensi untuk melampirkan kelas)
    /*
     * class Outer {
     * class Inner {
     * public:
     * Inner(Outer* o) :outer(o) {}
     * private:
     * Outer* outer;
     * };
     * };
     */

    // Java
    // Kelas Bersarang[ref] (membutuhkan referensi untuk melampirkan kelas)
    /*
     * class OuterClass {
     * ...
     * class InnerClass {
     * ...
     * }
     * }
     */

    // Statically Defined within Another Class
    // C++
    // Kelas Bersarang Statis
    /*
     * class Outer {
     * class Inner {
     * ...
     * };
     * };
     */

    // java
    // Static Nested Class (aka Static Member Class)[ref]

    /*
     * class OuterClass {
     * ...
     * static class StaticNestedClass {
     * ...
     * }
     * }
     */

    // Didefinisikan dalam suatu Metode
    // (misalnya penanganan acara)

    // C++

    // Local Class[ref]

    /*
     * void fun() {
     * class Test {
     * //members of Test class
     * };
     * }
     */

    // Java
    // Local Class[ref]
    /*
     * class Test {
     * void f() {
     * new Thread(new Runnable() {
     * public void run() {
     * doSomethingBackgroundish();
     * }
     * }).start();
     * }
     * }
     */

    public static void main(String[] args) throws Exception {
        OuterClass2 outerObj = new OuterClass2();
        OuterClass2.InnerClass innerObj = outerObj.new InnerClass();

        // Menampilkan hasil dari OuterClass
        System.out.println("Hasil dari OuterClass: " + outerObj.outerString);
        // output: Hasil dari OuterClass: Ini dari OuterClass

        // Menampilkan hasil dari InnerClass
        System.out.println("Hasil dari InnerClass: " + innerObj.innerString);
        // output: Hasil dari InnerClass: Ini dari InnerClass
    }
}
