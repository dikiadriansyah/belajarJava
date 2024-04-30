import java.lang.reflect.Constructor;

public class Call_overloaded_construcotrs_using_reflection {
    // Call overloaded constructors using reflection/Panggil konstruktor yang
    // kelebihan beban menggunakan refleksi

    /*
     * Contoh: Panggil konstruktor berbeda dengan meneruskan parameter yang relevan
     * 
     * import java.lang.reflect.*;
     * class NewInstanceWithReflection{
     * public NewInstanceWithReflection(){
     * System.out.println("Default constructor");
     * }
     * public NewInstanceWithReflection( String a){
     * System.out.println("Constructor :String => "+a);
     * }
     * public static void main(String args[]) throws Exception {
     * 
     * NewInstanceWithReflection object =
     * (NewInstanceWithReflection)Class.forName("NewInstanceWithReflection").
     * newInstance();
     * Constructor constructor =
     * NewInstanceWithReflection.class.getDeclaredConstructor( new
     * Class[] {String.class});
     * NewInstanceWithReflection object1 =
     * (NewInstanceWithReflection)constructor.newInstance(new
     * Object[]{"StackOverFlow"});
     * 
     * }
     * }
     * 
     */

    // hasil:
    /*
     * Default constructor
     * Constructor :String => StackOverFlow
     */

    // penjelasan:
    /*
     * 1. Buat instance kelas menggunakan Class.forName : Ini memanggil constructor
     * default
     * 2. Panggil getDeclaredConstructor kelas dengan meneruskan tipe parameter
     * sebagai array Kelas
     * 3. Setelah mendapatkan constructor, buat newInstance dengan meneruskan nilai
     * parameter sebagai array Object
     */
    // ----------------
    public Call_overloaded_construcotrs_using_reflection() {
        System.out.println("Default constructor");
    }

    public Call_overloaded_construcotrs_using_reflection(String a) {
        System.out.println("Constructor :String => " + a);
    }

    public static void main(String[] args) throws Exception {

        Call_overloaded_construcotrs_using_reflection object = (Call_overloaded_construcotrs_using_reflection) Class
                .forName("Call_overloaded_construcotrs_using_reflection")
                .newInstance();
        Constructor constructor = Call_overloaded_construcotrs_using_reflection.class
                .getDeclaredConstructor(new Class[] { String.class });
        Call_overloaded_construcotrs_using_reflection object1 = (Call_overloaded_construcotrs_using_reflection) constructor
                .newInstance(new Object[] { "StackOverFlow" });

        /*
         * output:
         * Default constructor
         * Constructor :String => StackOverFlow
         */

    }
}
