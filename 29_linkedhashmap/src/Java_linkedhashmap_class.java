import java.util.*;

public class Java_linkedhashmap_class {
    // Java LinkedHashMap class

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        /*
         * Key Points(Poin Penting):
         * 1. Apakah Hash table dan implementasi Linked list dari Map interface,
         * dengan urutan iterasi yang dapat diprediksi.
         * 2. mewarisi kelas HashMap dan mengimplementasikan Map interface.
         * 3. berisi nilai berdasarkan kunci.
         * 4. hanya elemen unik.
         * 5. mungkin memiliki satu kunci nol dan beberapa nilai nol.
         * 6. sama seperti HashMap, malah mempertahankan urutan penyisipan.
         * 
         * Methods:
         * 1. void clear().
         * 2. boolean containsKey(Object key).
         * 3. Object get(Object key).
         * 4. protected boolean removeEldestEntry(Map.Entry eldest)
         */
        LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
        lhm.put("Ramesh", "Intermediate");
        lhm.put("Shiva", "B-Tech");
        lhm.put("Santosh", "B-Com");
        lhm.put("Asha", "Msc");
        lhm.put("Raghu", "M-Tech");

        Set set = lhm.entrySet();
        Iterator i = set.iterator();
        // while (i.hasNext()) {
        // Map.Entry me = (Map.Entry) i.next();
        // System.out.println(me.getKey() + " : " + me.getValue());
        // }

        // System.out.println("The Key Contains : " + lhm.containsKey("Shiva"));
        // System.out.println("The value to the corresponding to key : " +
        // lhm.get("Asha"));
        /*
         * output:
         * Ramesh : Intermediate
         * Shiva : B-Tech
         * Santosh : B-Com
         * Asha : Msc
         * Raghu : M-Tech
         * The Key Contains : true
         * The value to the corresponding to key : Msc
         */
    }
}
