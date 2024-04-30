import java.util.*;

public class Object_references_as_method_parameters {
    // Object References as method parameters/Referensi Objek sebagai parameter
    // metode

    /*
     * Topik ini menjelaskan konsep referensi objek; ini ditargetkan untuk
     * orang-orang yang baru mengenal pemrograman di Java.
     * Anda pasti sudah familiar dengan beberapa istilah dan arti: definisi class,
     * main method, object instance, dan pemanggilan metode "pada" suatu objek, dan
     * meneruskan parameter ke metode.
     */

    /*
     * public class Person {
     * private String name;
     * public void setName(String name) { this.name = name; }
     * public String getName() { return name; }
     * public static void main(String [] arguments) {
     * Person person = new Person();
     * person.setName("Bob");
     * int i = 5;
     * setPersonName(person, i);
     * System.out.println(person.getName() + " " + i);
     * }
     * private static void setPersonName(Person person, int num) {
     * person.setName("Linda");
     * num = 99;
     * }
     * }
     */

    /*
     * Untuk benar-benar kompeten dalam pemrograman Java, Anda harus bisa
     * menjelaskan contoh ini kepada orang lain secara langsung. Konsepnya sangat
     * penting untuk memahami cara kerja Java.
     * 
     * Seperti yang Anda lihat, kita memiliki main yang membuat instance objek ke
     * variabel person, dan memanggil metode untuk menyetel bidang nama di objek
     * tersebut menjadi "Bob". Kemudian ia memanggil metode lain, dan meneruskan
     * person sebagai salah satu dari dua parameter; parameter lainnya adalah
     * variabel integer, disetel ke 5.
     * 
     * Metode yang dipanggil menyetel nilai nama pada objek yang diteruskan ke
     * "Linda', dan menyetel variabel integer yang diteruskan ke 99,
     * lalu kembali.
     * 
     * Jadi apa yang akan dicetak?
     * Linda 5
     */

    /*
     * Jadi mengapa perubahan yang dilakukan pada orang berlaku secara utama, tetapi
     * perubahan yang dilakukan pada bilangan bulat tidak?
     * 
     * Saat panggilan dilakukan, metode utama meneruskan referensi objek orang ke
     * metode setPersonName; setiap perubahan yang dilakukan setAnotherName pada
     * objek tersebut adalah bagian dari objek tersebut, sehingga perubahan tersebut
     * tetap menjadi bagian dari objek tersebut ketika metode kembali.
     * 
     * Cara lain untuk mengatakan hal yang sama: orang menunjuk ke suatu objek
     * (disimpan di heap, jika Anda tertarik). Setiap perubahan yang dilakukan
     * metode pada objek tersebut dibuat "pada objek itu", dan tidak terpengaruh
     * oleh apakah metode yang melakukan perubahan tersebut masih aktif atau telah
     * kembali. Ketika metode kembali, perubahan apa pun yang dilakukan pada objek
     * masih disimpan pada objek tersebut.
     */

    // Mari tambahkan metode lain ke contoh kecil kita di sini:
    /*
     * private static void getAnotherObjectNot(Person person) {
     * person = new Person();
     * person.setName("George");
     * }
     */

    // Dan, kembali ke main, di bawah panggilan ke setAnotherName, mari kita lakukan
    // panggilan ke metode ini dan panggilan println lainnya:

    /*
     * getAnotherObjectNot(person);
     * System.out.println(person.getName());
     */

    // Sekarang program akan mencetak:
    /*
     * Linda 5
     * Linda
     * 
     */

    /*
     * Apa yang terjadi dengan benda yang dimiliki George? Nah, parameter yang
     * diteruskan adalah pointer ke Linda;
     * ketika metode getAnotherObjectNot membuat objek baru, metode ini mengganti
     * referensi ke objek Linda dengan referensi ke objek George. Objek Linda masih
     * ada (di heap), metode main masih dapat mengaksesnya, tetapi
     * Metode getAnotherObjectNot tidak akan dapat melakukan apa pun setelah itu,
     * karena tidak memiliki referensi ke sana. Tampaknya penulis kode bermaksud
     * agar metode tersebut membuat objek baru dan meneruskannya kembali, tetapi
     * jika demikian, itu tidak berhasil.
     */

    /*
     * Jika itu yang penulis ingin lakukan, dia perlu mengembalikan objek yang baru
     * dibuat dari metode tersebut,
     * sesuatu seperti ini:
     */

    /*
     * private static Person getAnotherObject() {
     * Person person = new Person();
     * person.setName("Mary");
     * return person;
     * }
     */

    // Lalu panggil seperti ini:

    /*
     * Person mary;
     * mary = getAnotherObject();
     * System.out.println(mary.getName());
     * 
     */

    // Dan keseluruhan keluaran program sekarang adalah:
    /*
     * Linda 5
     * Linda
     * Mary
     */

    // Berikut keseluruhan programnya, dengan kedua tambahannya:

    /*
     * public class Person {
     * private String name;
     * public void setName(String name) { this.name = name; }
     * public String getName() { return name; }
     * public static void main(String [] arguments) {
     * Person person = new Person();
     * person.setName("Bob");
     * int i = 5;
     * setPersonName(person, i);
     * System.out.println(person.getName() + " " + i);
     * 
     * getAnotherObjectNot(person);
     * System.out.println(person.getName());
     * 
     * Person person;
     * person = getAnotherObject();
     * System.out.println(person.getName());
     * }
     * private static void setPersonName(Person person, int num) {
     * person.setName("Linda");
     * num = 99;
     * }
     * private static void getAnotherObjectNot(Person person) {
     * person = new Person();
     * person.setMyName("George");
     * }
     * private static person getAnotherObject() {
     * Person person = new Person();
     * person.setMyName("Mary");
     * return person;
     * }
     * }
     */

    // private String name;

    // public void setName(String name) {
    // this.name = name;
    // }

    // public String getName() {
    // return name;
    // }

    // ---------------------
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // Object_references_as_method_parameters person = new
        // Object_references_as_method_parameters();
        // person.setName("Bob");
        // int i = 5;
        // setPersonName(person, i);
        // System.out.println(person.getName() + " " + i);
        /*
         * output:
         * Linda 5
         */

        // ----------------------
        Object_references_as_method_parameters person = new Object_references_as_method_parameters();
        person.setName("Bob");
        int i = 5;
        setPersonName(person, i);
        System.out.println(person.getName() + " " + i);

        getAnotherObjectNot(person);
        System.out.println(person.getName());

        Object_references_as_method_parameters anotherPerson = getAnotherObject();
        System.out.println(anotherPerson.getName());
        /*
         * output:
         * Linda 5
         * Linda
         * Mary
         */

    }

    // private static void setPersonName(Object_references_as_method_parameters
    // person, int num) {
    // person.setName("Linda");
    // num = 99;
    // }

    // --------------------------
    private static void setPersonName(Object_references_as_method_parameters person, int num) {
        person.setName("Linda");
        num = 99;
    }

    private static void getAnotherObjectNot(Object_references_as_method_parameters person) {
        person = new Object_references_as_method_parameters();
        person.setName("George");
    }

    private static Object_references_as_method_parameters getAnotherObject() {
        Object_references_as_method_parameters person = new Object_references_as_method_parameters();
        person.setName("Mary");
        return person;
    }
}
