
import java.lang.reflect.*;

public class Call_constructor {
    // Call constructor/Panggil konstruktor

    // Mendapatkan Objek Konstruktor

    // Anda dapat memperoleh kelas Constructor dari Class object seperti ini:
    /*
     * Class myClass = ... // get a class object
     * Constructor[] constructors = myClass.getConstructors();
     */

    /*
     * Dimana variabel constructors akan memiliki satu instance constructors untuk
     * setiap konstruktor publik yang dideklarasikan di kelas.
     * 
     * Jika Anda mengetahui tipe parameter konstruktor yang ingin Anda akses, Anda
     * dapat memfilter konstruktor tertentu. Contoh berikutnya mengembalikan
     * konstruktor publik dari kelas tertentu yang menggunakan Integer sebagai
     * parameter:
     * 
     * Class myClass = ... // get a class object
     * Constructor constructor = myClass.getConstructor(new Class[]{Integer.class});
     */

    /*
     * Jika tidak ada konstruktor yang cocok dengan argumen konstruktor yang
     * diberikan, NoSuchMethodException akan dilempar(thrown)
     */

    // New Instance using Constructor Object/Instance Baru menggunakan Objek
    // Konstruktor

    /*
     * Class myClass = MyObj.class // get a class object
     * Constructor constructor = myClass.getConstructor(Integer.class);
     * MyObj myObj = (MyObj) constructor.newInstance(Integer.valueOf(123));
     */

    public static void main(String[] args) throws Exception {
        Class myClass = MyObj.class; // get a class object
        Constructor constructor = myClass.getConstructor(Integer.class);
        MyObj myObj = (MyObj) constructor.newInstance(Integer.valueOf(123));
        System.out.println(myObj);
        // output: MyObj{value=123}
    }
}
