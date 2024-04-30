public class Inheritance extends BaseClass {

    /*
     * Inheritance adalah fitur dasar berorientasi objek di mana satu kelas
     * memperoleh dan memperluas properti kelas lain, menggunakan kata kunci
     * extends. Untuk Antarmuka dan kata kunci implementasi, lihat antarmuka.
     */

    // Inheritance / Pewarisan

    /*
     * Dengan penggunaan kata kunci extends di antara kelas-kelas, semua properti
     * superkelas (juga dikenal sebagai Parent Kelas atau Kelas Dasar) terdapat di
     * subkelas (juga dikenal sebagai Child Class atau Kelas Turunan)
     * 
     * public class BaseClass {
     * public void baseMethod(){
     * System.out.println("Doing base class stuff");
     * }
     * }
     * public class SubClass extends BaseClass {
     * }
     * 
     */

    /*
     * Contoh SubClass telah mewarisi metode baseMethod():
     * SubClass s = new SubClass();
     * s.baseMethod(); //Valid, prints "Doing base class stuff"
     * 
     */

    /*
     * Konten tambahan dapat ditambahkan ke subkelas. Melakukan hal itu memungkinkan
     * fungsionalitas tambahan di subkelas tanpa
     * perubahan apa pun pada kelas dasar atau subkelas lain dari kelas dasar yang
     * sama:
     * 
     * public class Subclass2 extends BaseClass {
     * public void anotherMethod() {
     * System.out.println("Doing subclass2 stuff");
     * }
     * }
     * Subclass2 s2 = new Subclass2();
     * s2.baseMethod(); //Still valid , prints "Doing base class stuff"
     * s2.anotherMethod(); //Also valid, prints "Doing subclass2 stuff"
     */

    // Bidang juga diwariskan:
    /*
     * public class BaseClassWithField {
     * public int x;
     * }
     * public class SubClassWithField extends BaseClassWithField {
     * public SubClassWithField(int x) {
     * this.x = x; //Can access fields
     * }
     * }
     */

    // bidang dan metode private masih ada dalam subkelas, namun tidak dapat
    // diakses:
    /*
     * public class BaseClassWithPrivateField {
     * private int x = 5;
     * public int getX() {
     * return x;
     * }
     * }
     * public class SubClassInheritsPrivateField extends BaseClassWithPrivateField {
     * public void printX() {
     * System.out.println(x); //Illegal, can't access private field x
     * System.out.println(getX()); //Legal, prints 5
     * }
     * }
     * SubClassInheritsPrivateField s = new SubClassInheritsPrivateField();
     * int x = s.getX(); //x will have a value of 5.
     */

    // Di Java, setiap kelas dapat memperluas paling banyak satu kelas lainnya.

    /*
     * public class A{}
     * public class B{}
     * public class ExtendsTwoClasses extends A, B {} //Illegal
     * 
     */

    /*
     * Hal ini dikenal sebagai pewarisan berganda, dan meskipun legal dalam beberapa
     * bahasa, Java tidak mengizinkannya dengan kelas.
     * 
     * Sebagai akibatnya, setiap kelas memiliki rantai kelas leluhur yang tidak
     * bercabang yang mengarah ke Object, tempat semua kelas diturunkan.
     */

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Inheritance box1 = new Inheritance();
        Subclass2 box2 = new Subclass2();
        box1.baseMethod(); // Doing base class stuff
        box2.anotherMethod(); // Doing subclass2 stuff
    }
}
