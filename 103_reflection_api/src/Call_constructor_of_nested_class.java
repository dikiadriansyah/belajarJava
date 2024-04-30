import java.lang.reflect.Constructor;

public class Call_constructor_of_nested_class {
    // Call constructor of nested class/Panggil konstruktor kelas bersarang

    /*
     * Jika Anda ingin membuat instance kelas bersarang dalam, Anda perlu
     * menyediakan objek kelas dari kelas terlampir sebagai parameter tambahan
     * dengan Class#getDeclaredConstructor.
     */

    /*
     * public class Enclosing{
     * public class Nested{
     * public Nested(String a){
     * System.out.println("Constructor :String => "+a);
     * }
     * }
     * public static void main(String args[]) throws Exception {
     * Class<?> clazzEnclosing = Class.forName("Enclosing");
     * Class<?> clazzNested = Class.forName("Enclosing$Nested");
     * Enclosing objEnclosing = (Enclosing)clazzEnclosing.newInstance();
     * Constructor<?> constructor = clazzNested.getDeclaredConstructor(new
     * Class[]{Enclosing.class, String.class});
     * Nested objInner = (Nested)constructor.newInstance(new Object[]{objEnclosing,
     * "StackOverFlow"});
     * }
     * }
     */

    // Jika kelas yang disarangkan bersifat statis, Anda tidak memerlukan instance
    // terlampir ini
    // -------------------
    public class Nested {
        public Nested(String a) {
            System.out.println("Constructor :String => " + a);
        }
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazzEnclosing = Class.forName("Call_constructor_of_nested_class");
        Class<?> clazzNested = Class.forName("Call_constructor_of_nested_class$Nested");
        Call_constructor_of_nested_class objEnclosing = (Call_constructor_of_nested_class) clazzEnclosing.newInstance();
        Constructor<?> constructor = clazzNested
                .getDeclaredConstructor(new Class[] { Call_constructor_of_nested_class.class, String.class });
        Nested objInner = (Nested) constructor.newInstance(new Object[] { objEnclosing,
                "StackOverFlow" });

        /*
         * output: Constructor :String => StackOverFlow
         */

    }
}
