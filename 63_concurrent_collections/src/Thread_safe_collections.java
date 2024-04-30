import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
// import java.util.concurrent.ConcurrentHashSet;

public class Thread_safe_collections {
    // Thread-safe Collections / Koleksi yang aman untuk thread

    /*
     * Secara default, berbagai jenis Koleksi tidak aman untuk thread.
     * Namun, membuat koleksi aman untuk thread cukup mudah.
     * 
     * List<String> threadSafeList = Collections.synchronizedList(new
     * ArrayList<String>());
     * Set<String> threadSafeSet = Collections.synchronizedSet(new
     * HashSet<String>());
     * Map<String, String> threadSafeMap = Collections.synchronizedMap(new
     * HashMap<String, String>());
     */

    /*
     * Saat Anda membuat koleksi thread-safe, Anda tidak boleh mengaksesnya melalui
     * koleksi asli, hanya melalui pembungkus thread-safe.
     */

    // Version ≥ Java SE 5

    /*
     * Mulai di Java 5, java.util.collections memiliki beberapa koleksi thread-safe
     * baru yang tidak memerlukan beragam metode Collections.synchronized.
     * 
     * List<String> threadSafeList = new CopyOnWriteArrayList<String>();
     * Set<String> threadSafeSet = new ConcurrentHashSet<String>();
     * Map<String, String> threadSafeMap = new ConcurrentHashMap<String, String>();
     */

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // List<String> threadSafeList = new CopyOnWriteArrayList<String>();
        // threadSafeList.add("Item 1");
        // threadSafeList.add("Item 2");
        // threadSafeList.add("Item 3");

        // System.out.println("Thread-Safe List:");
        // for (String item : threadSafeList) {
        // System.out.println(item);
        // }

        /*
         * output:
         * Thread-Safe List:
         * Item 1
         * Item 2
         * Item 3
         */

        // Set<String> threadSafeSet = new ConcurrentHashSet<String>();

        // Contoh penggunaan ConcurrentHashMap
        Map<String, String> threadSafeMap = new ConcurrentHashMap<>();
        threadSafeMap.put("Key1", "Value1");
        threadSafeMap.put("Key2", "Value2");
        threadSafeMap.put("Key3", "Value3");

        System.out.println("\nThread-Safe Map:");
        for (Map.Entry<String, String> entry : threadSafeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        /*
         * output:
         * Thread-Safe Map:
         * Key2: Value2
         * Key1: Value1
         * Key3: Value3
         */

    }
}
