import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Introduction2 {
    // Introduction / perkenalan

    // dasar

    /*
     * Reflection API memungkinkan seseorang untuk memeriksa struktur kelas kode
     * saat runtime dan memanggil kode secara dinamis. Ini sangat kuat, tetapi juga
     * berbahaya karena kompiler tidak dapat menentukan secara statis apakah
     * pemanggilan dinamis valid.
     * 
     * Contoh sederhananya adalah mendapatkan konstruktor dan metode publik dari
     * kelas tertentu:
     * 
     * import java.lang.reflect.Constructor;
     * import java.lang.reflect.Method;
     * // This is a object representing the String class (not an instance of
     * String!)
     * Class<String> clazz = String.class;
     * Constructor<?>[] constructors = clazz.getConstructors(); // returns all
     * public constructors of
     * String
     * Method[] methods = clazz.getMethods(); // returns all public methods from
     * String and parents
     */

    // Dengan informasi ini dimungkinkan untuk membuat instance objek dan memanggil
    // metode yang berbeda secara dinamis

    // Refleksi dan Tipe Generik

    // Informasi tipe generik tersedia untuk:
    /*
     * method parameters, using getGenericParameterTypes().
     * method return types, using getGenericReturnType().
     * public fields, using getGenericType.
     */

    // Contoh berikut menunjukkan cara mengekstrak informasi tipe generik dalam
    // ketiga kasus:

    /*
     * import java.lang.reflect.Field;
     * import java.lang.reflect.Method;
     * import java.lang.reflect.ParameterizedType;
     * import java.lang.reflect.Type;
     * import java.util.List;
     * import java.util.Map;
     * public class GenericTest {
     * public static void main(final String[] args) throws Exception {
     * final Method method = GenericTest.class.getMethod("testMethod", Map.class);
     * final Field field = GenericTest.class.getField("testField");
     * System.out.println("Method parameter:");
     * final Type parameterType = method.getGenericParameterTypes()[0];
     * displayGenericType(parameterType, "\t");
     * System.out.println("Method return type:");
     * final Type returnType = method.getGenericReturnType();
     * displayGenericType(returnType, "\t");
     * System.out.println("Field type:");
     * final Type fieldType = field.getGenericType();
     * displayGenericType(fieldType, "\t");
     * }
     * private static void displayGenericType(final Type type, final String prefix)
     * {
     * System.out.println(prefix + type.getTypeName());
     * if (type instanceof ParameterizedType) {
     * for (final Type subtype : ((ParameterizedType)
     * type).getActualTypeArguments()) {
     * displayGenericType(subtype, prefix + "\t");
     * }
     * }
     * }
     * public Map<String, Map<Integer, List<String>>> testField;
     * public List<Number> testMethod(final Map<String, Double> arg) {
     * return null;
     * }
     * }
     * 
     */

    // hasil:
    /*
     * Method parameter:
     * java.util.Map
     * java.lang.String
     * java.lang.Double
     * 
     * Method return type:
     * java.util.List
     * java.lang.Number
     * 
     * Field type:
     * java.util.Map
     * java.lang.String
     * java.util.Map
     * java.lang.Integer
     * java.util.List
     * java.lang.String
     */

    public static void main(String[] args) throws Exception {
        final Method method = Introduction2.class.getMethod("testMethod", Map.class);
        final Field field = Introduction2.class.getField("testField");

        System.out.println("Method parameter:");
        final Type parameterType = method.getGenericParameterTypes()[0];
        displayGenericType(parameterType, "\t");

        System.out.println("Method return type:");
        final Type returnType = method.getGenericReturnType();
        displayGenericType(returnType, "\t");

        System.out.println("Field type:");
        final Type fieldType = field.getGenericType();
        displayGenericType(fieldType, "\t");

        /*
         * output:
         * Method parameter:
         * java.util.Map
         * java.lang.String
         * java.lang.Double
         * 
         * Method return type:
         * java.util.List
         * java.lang.Number
         * 
         * Field type:
         * java.util.Map
         * java.lang.String
         * java.util.Map
         * java.lang.Integer
         * java.util.List
         * java.lang.String
         */

    }

    private static void displayGenericType(final Type type, final String prefix) {
        System.out.println(prefix + type.getTypeName());
        if (type instanceof ParameterizedType) {
            for (final Type subtype : ((ParameterizedType) type).getActualTypeArguments()) {
                displayGenericType(subtype, prefix + "\t");
            }
        }
    }

    public Map<String, Map<Integer, List<String>>> testField;

    public List<Number> testMethod(final Map<String, Double> arg) {
        return null;
    }

}
