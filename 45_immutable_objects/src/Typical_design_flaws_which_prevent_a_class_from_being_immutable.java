import java.util.*;

public class Typical_design_flaws_which_prevent_a_class_from_being_immutable {
    // Typical design flaws which prevent a class from being immutable / Cacat
    // desain umum yang mencegah kelas menjadi tidak dapat diubah

    // Menggunakan beberapa setter, tanpa mengatur semua properti yang diperlukan di
    // konstruktor
    /*
     * public final class Person { // example of a bad immutability
     * private final String name;
     * private final String surname;
     * public Person(String name) {
     * this.name = name;
     * }
     * public String getName() { return name;}
     * public String getSurname() { return surname;}
     * public void setSurname(String surname) { this.surname = surname); }
     * }
     * 
     */
    // Sangat mudah untuk menunjukkan bahwa kelas Person tidak dapat diubah:
    /*
     * Person person = new Person("Joe");
     * person.setSurname("Average"); // NOT OK, change surname field after creation
     * 
     * Untuk memperbaikinya, cukup hapus setSurname() dan refactor konstruktor
     * sebagai berikut:
     */

    /*
     * public Person(String name, String surname) {
     * this.name = name;
     * this.surname = surname;
     * }
     */

    // Tidak menandai variabel instan sebagai private dan final

    // Lihatlah kelas berikut:
    /*
     * public final class Person {
     * public String name;
     * public Person(String name) {
     * this.name = name;
     * }
     * public String getName() {
     * return name;
     * }
     * 
     * }
     * 
     */

    // Cuplikan berikut menunjukkan bahwa kelas di atas tidak dapat diubah:
    /*
     * Person person = new Person("Average Joe");
     * person.name = "Magic Mike"; // not OK, new name for person after creation
     * 
     */

    // Untuk memperbaikinya, cukup tandai properti nama sebagai private dan final

    // Mengekspos objek kelas yang bisa berubah di pengambil

    // Lihatlah kelas berikut:
    /*
     * import java.util.List;
     * import java.util.ArrayList;
     * public final class Names {
     * private final List<String> names;
     * public Names(List<String> names) {
     * this.names = new ArrayList<String>(names);
     * }
     * public List<String> getNames() {
     * return names;
     * }
     * public int size() {
     * return names.size();
     * }
     * }
     * 
     * 
     */

    // Kelas nama tampaknya tidak dapat diubah pada pandangan pertama, tetapi tidak
    // seperti yang ditunjukkan oleh kode berikut:

    /*
     * List<String> namesList = new ArrayList<String>();
     * namesList.add("Average Joe");
     * Names names = new Names(namesList);
     * System.out.println(names.size()); // 1, only containing "Average Joe"
     * namesList = names.getNames();
     * namesList.add("Magic Mike");
     * System.out.println(names.size()); // 2, NOT OK, now names also contains
     * "Magic Mike"
     * 
     */

    /*
     * Hal ini terjadi karena perubahan pada Daftar referensi yang dikembalikan oleh
     * getNames() dapat mengubah daftar Nama sebenarnya.
     * 
     * Untuk memperbaikinya, cukup hindari mengembalikan referensi yang
     * mereferensikan objek kelas yang dapat diubah dengan membuat salinan defensif,
     * sebagai berikut:
     * public List<String> getNames() {
     * return new ArrayList<String>(this.names); // copies elements
     * }
     */

    // atau dengan merancang pengambil sedemikian rupa sehingga hanya objek dan
    // primitif abadi lainnya yang dikembalikan, sebagai berikut:

    /*
     * public String getName(int index) {
     * return names.get(index);
     * }
     * public int size() {
     * return names.size();
     * }
     */

    // Menyuntikkan konstruktor dengan objek yang dapat dimodifikasi di luar kelas
    // yang tidak dapat diubah
    // Ini adalah variasi dari kelemahan sebelumnya. Lihatlah kelas berikut:
    /*
     * import java.util.List;
     * public final class NewNames {
     * private final List<String> names;
     * public Names(List<String> names) {
     * this.names = names;
     * }
     * public String getName(int index) {
     * return names.get(index);
     * }
     * public int size() {
     * return names.size();
     * }
     * }
     */

    // Seperti kelas Names sebelumnya, kelas NewNames juga tampak tidak dapat diubah
    // pada pandangan pertama, namun sebenarnya tidak, faktanya cuplikan berikut
    // membuktikan sebaliknya:

    /*
     * List<String> namesList = new ArrayList<String>();
     * namesList.add("Average Joe");
     * NewNames names = new NewNames(namesList);
     * System.out.println(names.size()); // 1, only containing "Average Joe"
     * namesList.add("Magic Mike");
     * System.out.println(names.size()); // 2, NOT OK, now names also contains
     * "Magic Mike"
     * 
     */

    /*
     * Untuk memperbaikinya, seperti pada kelemahan sebelumnya, cukup buat salinan
     * defensif objek tanpa menugaskannya langsung ke kelas yang tidak dapat diubah,
     * yaitu konstruktor dapat diubah sebagai berikut:
     * public Names(List<String> names) {
     * this.names = new ArrayList<String>(names);
     * }
     */

    // Membiarkan metode kelas ditimpa
    // Lihatlah kelas berikut:
    /*
     * public class Person {
     * private final String name;
     * public Person(String name) {
     * this.name = name;
     * }
     * public String getName() { return name;}
     * }
     */

    // Kelas Person tampaknya tidak dapat diubah pada pandangan pertama, tetapi
    // anggaplah subkelas Person yang baru telah ditentukan:

    /*
     * public class MutablePerson extends Person {
     * private String newName;
     * public MutablePerson(String name) {
     * super(name);
     * }
     * 
     * @Override
     * public String getName() {
     * return newName;
     * }
     * public void setName(String name) {
     * newName = name;
     * }
     * }
     */

    // sekarang mutabilitas Person (im) dapat dieksploitasi melalui polimorfisme
    // dengan menggunakan subkelas baru:

    /*
     * Person person = new MutablePerson("Average Joe");
     * System.out.println(person.getName()); prints Average Joe
     * person.setName("Magic Mike"); // NOT OK, person has now a new name!
     * System.out.println(person.getName()); // prints Magic Mike
     */

    // Untuk memperbaikinya, tandai kelas sebagai final sehingga tidak dapat
    // diperluas atau nyatakan semua konstruktornya sebagai private.

    public static void main(String[] args) {
        // Contoh penggunaan kelas Person
        // Person2 person = new Person2("John");

        // Mendapatkan dan menampilkan nama dan nama belakang
        // System.out.println("Name: " + person.getName()); // Name: John
        // System.out.println("Surname: " + person.getSurname());// Surname: null

        // person.setSurname("Average"); // NOT OK, change surname field after creation
        // --------------------
        // List<String> namesList = new ArrayList<String>();
        // namesList.add("Average Joe");
        // Names names = new Names(namesList);
        // System.out.println(names.size()); // 1, only containing "Average Joe"

        // namesList = names.getNames();
        // namesList.add("Magic Mike");
        // System.out.println(names.size()); // 2, NOT OK, now names also contains
        // "Magic Mike"
        // --------------------
        // List<String> namesList = new ArrayList<String>();
        // namesList.add("Average Joe");
        // NewNames names = new NewNames(namesList);
        // System.out.println(names.size()); // 1, only containing "Average Joe"

        // namesList.add("Magic Mike");
        // System.out.println(names.size()); // 2, NOT OK, now names also contains
        // "Magic Mike"

        // -------------------------
        Person3 person = new MutablePerson("Average Joe");
        System.out.println(person.getName());// prints Average Joe

        // person.setName("Magic Mike"); // NOT OK, person has now a new name!
        // System.out.println(person.getName()); // prints Magic Mike
    }
}
