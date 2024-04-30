import java.util.*;
import java.util.Map;

public class Sorting_map_entries {
    // Sorting Map entries/Menyortir entri Peta

    // Pada Java 8, ada metode default pada antarmuka Map.Entry untuk memungkinkan
    // pengurutan iterasi peta.

    // Version ≥ Java SE 8

    /*
     * Map<String, Integer> numberOfEmployees = new HashMap<>();
     * numberOfEmployees.put("executives", 10);
     * numberOfEmployees.put("human ressources", 32);
     * numberOfEmployees.put("accounting", 12);
     * numberOfEmployees.put("IT", 100);
     */

    // Output the smallest departement in terms of number of employees
    /*
     * numberOfEmployees.entrySet().stream()
     * .sorted(Map.Entry.comparingByValue())
     * .limit(1)
     * .forEach(System.out::println); // outputs : executives=10
     */

    /*
     * Tentu saja, ini juga dapat digunakan di luar stream api :
     * Version ≥ Java SE 8
     * List<Map.Entry<String, Integer>> entries = new
     * ArrayList<>(numberOfEmployees.entrySet());
     * Collections.sort(entries, Map.Entry.comparingByValue());
     */

    public static void main(String[] args) {
        HashMap<String, Integer> numberOfEmployees = new HashMap<>();
        numberOfEmployees.put("executives", 10);
        numberOfEmployees.put("human resources", 32);
        numberOfEmployees.put("accounting", 12);
        numberOfEmployees.put("IT", 100);

        // Output the smallest department in terms of number of employees
        // numberOfEmployees.entrySet().stream()
        // .sorted(Map.Entry.<String, Integer>comparingByValue())
        // .limit(1)
        // .forEach(System.out::println); // outputs : executives=10

        // ----------------
        // Version ≥ Java SE 8
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(numberOfEmployees.entrySet());
        Collections.sort(entries, Map.Entry.comparingByValue());

        System.out.println("Jumlah karyawan per departemen (urutan menaik):");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        /*
         * output:
         * Jumlah karyawan per departemen (urutan menaik):
         * executives: 10
         * accounting: 12
         * human resources: 32
         * IT: 100
         */

    }
}
