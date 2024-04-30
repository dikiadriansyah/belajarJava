import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Wrapping_method_declarations {
    // Wrapping Method Declarations/Deklarasi Metode Pembungkus

    /*
     * int someMethod(String aString,
     * List<Integer> aList,
     * Map<String, String> aMap,
     * int anInt,
     * long aLong,
     * Set<Number> aSet,
     * double aDouble) {
     * …
     * }
     * int someMethod(String aString, List<Integer> aList,
     * Map<String, String> aMap, int anInt, long aLong,
     * double aDouble, long aLong) {
     * …
     * }
     * int someMethod(String aString,
     * List<Map<Integer, StringBuffer>> aListOfMaps,
     * Map<String, String> aMap)
     * throws IllegalArgumentException {
     * …
     * }
     * int someMethod(String aString, List<Integer> aList,
     * Map<String, String> aMap, int anInt)
     * throws IllegalArgumentException {
     * …
     * }
     */

    /*
     * 1. Deklarasi metode dapat diformat dengan mencantumkan argumen secara
     * vertikal, atau dengan baris baru dan +8 spasi tambahan
     * 2. Jika klausa throws perlu dibungkus, letakkan baris baru di depan klausa
     * throws dan pastikan klausa throws menonjol dari daftar argumen, baik dengan
     * mengindentasi +8 relatif terhadap deklarasi fungsi, atau +8 relatif terhadap
     * sebelumnya garis.
     */

    public static void main(String[] args) {
        // Contoh pemanggilan someMethod dengan parameter yang sesuai
        Wrapping_method_declarations example = new Wrapping_method_declarations();
        String aString = "Hello";
        List<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, 3));
        Map<String, String> aMap = new HashMap<>();
        aMap.put("key1", "value1");
        aMap.put("key2", "value2");
        int anInt = 10;
        long aLong = 100L;
        Set<Number> aSet = new HashSet<>(Arrays.asList(1, 2, 3.5));
        double aDouble = 3.14;

        int result = example.someMethod(aString, aList, aMap, anInt, aLong, aSet, aDouble);
        System.out.println("Result: " + result);
        /*
         * output:
         * aString: Hello
         * aList: [1, 2, 3]
         * aMap: {key1=value1, key2=value2}
         * anInt: 10
         * aLong: 100
         * aSet: [1, 2, 3.5]
         * aDouble: 3.14
         * Result: 6
         */

    }

    int someMethod(String aString,
            List<Integer> aList,
            Map<String, String> aMap,
            int anInt,
            long aLong,
            Set<Number> aSet,
            double aDouble) {
        // Implementasi metode someMethod di sini
        System.out.println("aString: " + aString);
        System.out.println("aList: " + aList);
        System.out.println("aMap: " + aMap);
        System.out.println("anInt: " + anInt);
        System.out.println("aLong: " + aLong);
        System.out.println("aSet: " + aSet);
        System.out.println("aDouble: " + aDouble);

        // Contoh operasi yang mungkin dilakukan dalam metode ini
        int sum = 0;
        for (Integer num : aList) {
            sum += num;
        }
        return sum;
    }

}
